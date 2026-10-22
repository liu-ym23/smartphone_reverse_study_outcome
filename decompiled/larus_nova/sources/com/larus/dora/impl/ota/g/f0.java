package com.larus.dora.impl.ota.g;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {
    public static final boolean a(String r100, String r101, String r102) {
        if (r101 != null) goto L5;
    L11:
        if (r102 != null) goto L13;
    L15:
        r102 = null;
    L16:
        if (r102 != null) goto L18;
    L20:
        return false;
    L18:
        if (Intrinsics.areEqual(r100, r102) == false) goto L20;
        return true;
    L13:
        if ((!StringsKt.isBlank(r102)) == false) goto L15;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        r102 = r101;
        goto L16
    }

    public static final u.c b(boolean r100, d49.a r101, d49.a r102) {
        Intrinsics.checkNotNullParameter(r102, "current");
        u.c r103 = u.c.f337559a;
        if (r100 == true) goto L5;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L16;
        return null;
    L16:
        return r103;
    L5:
        if ((r101 instanceof d49.a.m) == true) goto L11;
        if ((r102 instanceof d49.a.m) == false) goto L11;
        if (Intrinsics.areEqual(((d49.a.m) r102).f466856d, "PERIPHERAL_LOW_BATTERY".toLowerCase(Locale.ROOT)) == false) goto L11;
        r104 = true;
        goto L12
    }
}
