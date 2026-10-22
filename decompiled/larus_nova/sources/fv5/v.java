package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends v97.e {
    public v() {
        super("!", 600, 1);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Object r101 = ListProtector.get(r100, 0);
        if ((r101 instanceof Boolean) == false) goto L7;
        return Boolean.valueOf(!((Boolean) r101).booleanValue());
    L7:
        throw new ExprException(101, "params invalid");
    }
}
