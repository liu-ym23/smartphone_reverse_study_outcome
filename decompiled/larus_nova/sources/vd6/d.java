package vd6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class d extends o {
    public d() {
        super("==", 400, 2);
    }

    @Override // vd6.o
    public final Object a(List<? extends Object> r100) {
        boolean r101 = false;
        c(r100, false);
        Intrinsics.checkNotNull(r100);
        if ((ListProtector.get(r100, 0) instanceof sd6.f) == false) goto L9;
        if ((ListProtector.get(r100, 1) instanceof sd6.f) == false) goto L9;
        return Boolean.TRUE;
    L9:
        if ((ListProtector.get(r100, 0) instanceof sd6.e) == true) goto L23;
        if ((ListProtector.get(r100, 1) instanceof sd6.e) == true) goto L23;
        if (Intrinsics.areEqual(b(r100), "param_type_double") == false) goto L21;
        Object r102 = ListProtector.get(r100, 0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Number");
        double r103 = ((Number) r102).doubleValue();
        Object r104 = ListProtector.get(r100, 1);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Number");
        if (r103 != ((Number) r104).doubleValue()) goto L19;
        r101 = true;
    L19:
        return Boolean.valueOf(r101);
    L21:
        return Boolean.valueOf(Intrinsics.areEqual(String.valueOf(ListProtector.get(r100, 0)), String.valueOf(ListProtector.get(r100, 1))));
    L23:
        return new sd6.e(0);
    }
}
