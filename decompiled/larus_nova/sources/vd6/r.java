package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class r extends o {
    public r() {
        super("-", 600, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L24;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L24;
        String r101 = b(r100);
        if (Intrinsics.areEqual(r101, "param_type_double") == false) goto L12;
        Object r102 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        double r103 = ((Number) r102).doubleValue();
        Object r104 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        return Double.valueOf(r103 - ((Number) r104).doubleValue());
    L12:
        if (Intrinsics.areEqual(r101, "param_type_number") == false) goto L16;
        Object r105 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Number");
        long r106 = ((Number) r105).longValue();
        Object r107 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Number");
        return Long.valueOf(r106 - ((Number) r107).longValue());
    L16:
        if ((ListProtector.get(r100, 0) instanceof Collection) == false) goto L22;
        if ((ListProtector.get(r100, 1) instanceof Collection) == false) goto L22;
        Object r108 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        Object r109 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
        return CollectionsKt.minus((Collection) r108, CollectionsKt.toSet((Collection) r109));
    L22:
        throw new ExprException(101, "not support");
    L24:
        return new sd6.e(0);
    }
}
