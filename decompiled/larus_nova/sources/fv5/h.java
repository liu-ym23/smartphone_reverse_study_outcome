package fv5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends v97.e {
    public h() {
        super("==", 400, 2);
    }

    @Override // v97.e
    public final Object a(List<? extends Object> r100) {
        boolean r101 = false;
        c(r100, false);
        if (Intrinsics.areEqual(b(r100), "param_type_double") == false) goto L18;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L16;
        double r103 = ((Number) r102).doubleValue();
        Object r104 = ListProtector.get(r100, 1);
        if (r104 == null) goto L14;
        if (r103 != ((Number) r104).doubleValue()) goto L12;
        r101 = true;
    L12:
        return Boolean.valueOf(r101);
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L16:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Number");
    L18:
        return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(ListProtector.get(r100, 0)), String.valueOf(ListProtector.get(r100, 1))));
    }
}
