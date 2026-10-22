package vd6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class i extends o {
    public i() {
        super("<=", 500, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        c(r100, true);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L30;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L30;
        String r102 = b(r100);
        if (Intrinsics.areEqual(r102, "param_type_double") == false) goto L16;
        Object r103 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Number");
        double r104 = ((Number) r103).doubleValue();
        Object r105 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Number");
        if (r104 <= ((Number) r105).doubleValue()) goto L14;
        r101 = false;
    L14:
        return Boolean.valueOf(r101);
    L16:
        if (Intrinsics.areEqual(r102, "param_type_number") == false) goto L24;
        Object r106 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Number");
        long r107 = ((Number) r106).longValue();
        Object r108 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Number");
        if (r107 <= ((Number) r108).longValue()) goto L22;
        r101 = false;
    L22:
        return Boolean.valueOf(r101);
    L24:
        if (String.valueOf(ListProtector.get(r100, 0)).compareTo(String.valueOf(ListProtector.get(r100, 1))) <= 0) goto L28;
        r101 = false;
    L28:
        return Boolean.valueOf(r101);
    L30:
        return new sd6.e(0);
    }
}
