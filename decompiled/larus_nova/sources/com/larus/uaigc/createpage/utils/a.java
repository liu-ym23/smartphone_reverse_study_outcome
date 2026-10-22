package com.larus.uaigc.createpage.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f372626a = 0;

    static {
    }

    public static int a(com.larus.bmhome.resource.access.a0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        String r101 = r100.f313620b;
        switch(r101.hashCode()) {
            case -2109015642: goto L42;
            case -2105443597: goto L39;
            case -1723259401: goto L36;
            case -1421272810: goto L33;
            case -934348968: goto L30;
            case -805388692: goto L27;
            case 94416770: goto L24;
            case 224030908: goto L21;
            case 227665410: goto L18;
            case 258330299: goto L15;
            case 576581451: goto L12;
            case 924905569: goto L9;
            case 1392426448: goto L6;
            default: goto L43;
        };
    L43:
        int r102 = r100.f313619a.getOrder();
        boolean r103 = true;
        if (r102 < 0) goto L47;
        if (r102 >= 20) goto L47;
        boolean r104 = true;
    L48:
        if (r104 == false) goto L51;
    L49:
        return 8;
    L51:
        if (20 > r102) goto L54;
        if (r102 >= 30) goto L54;
        boolean r105 = true;
    L55:
        if (r105 == false) goto L58;
        return 20;
    L58:
        if (30 > r102) goto L61;
        if (r102 >= 40) goto L61;
        boolean r106 = true;
    L62:
        if (r106 == false) goto L65;
    L63:
        return 35;
    L65:
        if (40 > r102) goto L68;
        if (r102 >= 50) goto L68;
        boolean r107 = true;
    L69:
        if (r107 == false) goto L72;
    L70:
        return 45;
    L72:
        if (50 > r102) goto L75;
        if (r102 >= 60) goto L75;
        boolean r108 = true;
    L76:
        if (r108 == false) goto L78;
    L77:
        return 85;
    L78:
        if (60 <= r102) goto L80;
    L82:
        r103 = false;
    L83:
        if (r103 == false) goto L85;
    L84:
        return 95;
    L85:
        return 98;
    L80:
        if (r102 >= 70) goto L82;
    L75:
        r108 = false;
    L68:
        r107 = false;
    L61:
        r106 = false;
    L54:
        r105 = false;
    L47:
        r104 = false;
        goto L48
    L6:
        if (r101.equals("post_process") == true) goto L84;
    L9:
        if (r101.equals("remote_download") == false) goto L43;
        return 20;
    L12:
        if (r101.equals("remote_policy") == false) goto L43;
        return 20;
    L15:
        if (r101.equals("remote_fallback") == false) goto L43;
        return 20;
    L18:
        if (r101.equals("remote_direct") == true) goto L85;
    L21:
        if (r101.equals("remote_detect") == true) goto L63;
    L24:
        if (r101.equals("cache") == true) goto L85;
    L27:
        if (r101.equals("preprocess") == false) goto L43;
        return 20;
    L30:
        if (r101.equals("review") == true) goto L77;
    L33:
        if (r101.equals(com.alipay.sdk.m.l.c.f25505j) == false) goto L43;
    L36:
        if (r101.equals("local_detect") == true) goto L63;
    L39:
        if (r101.equals("remote_resolve") == false) goto L43;
        return 20;
    L42:
        if (r101.equals("sdk_upload") == true) goto L70;
        goto L43
    }

    public static int b(Long r100) {
        if (r100 == null) goto L4;
        long r101 = r100.longValue();
    L6:
        return ((((int) RangesKt.coerceIn(r101, 0, 100)) * 30) / 100) + 45;
    L4:
        r101 = 0;
        goto L6
    }
}
