package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends v97.e {
    public m() {
        super("in", 700, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Object r101 = ListProtector.get(r100, 1);
        if ((r101 instanceof Collection) == false) goto L7;
        return Boolean.valueOf(((Collection) r101).contains(ListProtector.get(r100, 0)));
    L7:
        throw new ExprException(101, "not support");
    }
}
