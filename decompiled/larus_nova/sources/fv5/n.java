package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends v97.e {
    public n() {
        super("isIntersect", 700, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Object r101 = ListProtector.get(r100, 0);
        Object r102 = ListProtector.get(r100, 1);
        if ((r101 instanceof Collection) == false) goto L9;
        if ((r102 instanceof Collection) == false) goto L9;
        return Boolean.valueOf(!CollectionsKt.intersect((Iterable) r101, (Iterable) r102).isEmpty());
    L9:
        throw new ExprException(101, "not support");
    }
}
