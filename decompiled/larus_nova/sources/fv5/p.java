package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends v97.e {
    public p() {
        super("<", 500, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        boolean r101 = true;
        c(r100, true);
        String r102 = b(r100);
        if (Intrinsics.areEqual(r102, "param_type_double") == false) goto L19;
        Object r103 = ListProtector.get(r100, 0);
        if (r103 == null) goto L17;
        double r104 = ((Number) r103).doubleValue();
        Object r105 = ListProtector.get(r100, 1);
        if (r105 == null) goto L15;
        if (r104 < ((Number) r105).doubleValue()) goto L13;
        r101 = false;
    L13:
        return Boolean.valueOf(r101);
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L17:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L19:
        if (Intrinsics.areEqual(r102, "param_type_number") == false) goto L35;
        Object r106 = ListProtector.get(r100, 0);
        if (r106 == null) goto L33;
        long r107 = ((Number) r106).longValue();
        Object r108 = ListProtector.get(r100, 1);
        if (r108 == null) goto L31;
        if (r107 < ((Number) r108).longValue()) goto L29;
        r101 = false;
    L29:
        return Boolean.valueOf(r101);
    L31:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L33:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L35:
        if (String.valueOf(ListProtector.get(r100, 0)).compareTo(String.valueOf(ListProtector.get(r100, 1))) < 0) goto L39;
        r101 = false;
    L39:
        return Boolean.valueOf(r101);
    }
}
