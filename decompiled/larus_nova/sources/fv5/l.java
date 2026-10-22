package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends v97.e {
    public l() {
        super("hasKey", 800, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Object r101 = ListProtector.get(r100, 0);
        Object r102 = ListProtector.get(r100, 1);
        if ((r101 instanceof Map) == false) goto L7;
        return Boolean.valueOf(((Map) r101).containsKey(r102));
    L7:
        throw new ExprException(101, "params invalid");
    }
}
