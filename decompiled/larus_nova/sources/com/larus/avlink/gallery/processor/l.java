package com.larus.avlink.gallery.processor;

import com.larus.common.apphost.AppHost;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class l {
    public static k a(k r110, int r111, String r210, String r211, int r212, int r213) {
        int r100 = 0;
        if ((r213 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "";
        if ((r213 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r213 & 4) != 0) goto L15;
        r102 = r211;
    L15:
        if ((r213 & 8) != 0) goto L18;
        r100 = r212;
    L18:
        Object r104 = null;
        if ((r213 & 16) == 0) goto L24;
        f09.a r105 = AppHost.f326268a.a();
        if (r105 == null) goto L23;
        r104 = Integer.valueOf(r105.isAppBackground() ? 1 : 0);
    L23:
        r104 = String.valueOf(r104);
    L24:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r103, "resultAlgorithm");
        Intrinsics.checkNotNullParameter(r102, com.heytap.mcssdk.constant.b.C);
        Intrinsics.checkNotNullParameter(r104, "background");
        Map r106 = MapsKt.toMutableMap(r110.f292694e);
        r106.put("code", Integer.valueOf(r101));
        r106.put("resultAlgorithm", r103);
        r106.put(com.heytap.mcssdk.constant.b.C, r102);
        r106.put("background", r104);
        r106.put("activeMask", Integer.valueOf(r100));
        boolean r112 = r110.f292690a;
        String r113 = r110.f292691b;
        String r114 = r110.f292692c;
        long r115 = r110.f292693d;
        boolean r107 = r110.f292695f;
        Intrinsics.checkNotNullParameter(r113, "outputPath");
        Intrinsics.checkNotNullParameter(r114, "error");
        Intrinsics.checkNotNullParameter(r106, "extras");
        return new k(r112, r113, r114, r115, r106, r107);
    L9:
        r103 = r210;
        goto L11
    L5:
        r101 = r111;
        goto L6
    }
}
