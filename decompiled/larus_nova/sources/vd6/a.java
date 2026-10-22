package vd6;

import com.bytedance.lark.express.exception.ExprException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes28.dex */
public final class a extends o {
    public a() {
        super(Marker.ANY_NON_NULL_MARKER, 600, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        c(r100, true);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L18;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L18;
        String r101 = b(r100);
        if (Intrinsics.areEqual(r101, "param_type_double") == false) goto L12;
        Object r102 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        double r103 = ((Number) r102).doubleValue();
        Object r104 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        return Double.valueOf(r103 + ((Number) r104).doubleValue());
    L12:
        if (Intrinsics.areEqual(r101, "param_type_number") == false) goto L16;
        Object r105 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Number");
        long r106 = ((Number) r105).longValue();
        Object r107 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Number");
        return Long.valueOf(r106 + ((Number) r107).longValue());
    L16:
        throw new ExprException(101, "not support");
    L18:
        return new sd6.e(0);
    }
}
