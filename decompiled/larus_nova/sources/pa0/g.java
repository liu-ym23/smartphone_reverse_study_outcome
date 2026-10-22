package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {
    public static final Long a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$cashBalanceOrNull");
        Long r101 = Long.valueOf(r100.f528344a.getCashBalance());
        if (r101.longValue() < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public static final k b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dy");
        if ((r100 instanceof k) == true) goto L6;
        r100 = null;
    L6:
        return (k) r100;
    }

    public static final Long c(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$goldBalanceOrNull");
        Long r101 = Long.valueOf(r100.f528344a.getGoldBalance());
        if (r101.longValue() < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }
}
