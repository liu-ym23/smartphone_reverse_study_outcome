package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes41.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<ag.a<String, String, String>> f464184a = null;

    static {
        final int r100 = 6;
        f464184a = new AnonymousClass1(r100);
    }

    private static Bundle a(String r100) {
        return ag.a(com.xiaomi.push.q.m9304a(), r100, null);
    }

    public static int a(Context r100, String r101) {
        int r102 = 0;
        if (r100 != null) goto L5;
    L85:
        com.xiaomi.channel.commonutils.logger.b.m8718a("context | packageName must not be null");
        return 0;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L85;
        com.xiaomi.push.g.b r103 = com.xiaomi.push.g.a(r100, r101, true);
        if (r103 != com.xiaomi.push.g.b.f463640b) goto L10;
        r102 = 1;
    L12:
        int r104 = 32;
        int r105 = 8;
        if (ag.a() == false) goto L54;
        Bundle r106 = a(r101);
        ag.a<String, String, String> r107 = ag.f464202g;
        if (r106.containsKey(r107.f464206c) == true) goto L17;
    L20:
        ag.a<String, String, String> r108 = ag.f464200e;
        if (r106.containsKey(r108.f464206c) == true) goto L23;
    L26:
        ag.a<String, String, String> r109 = ag.f464201f;
        if (r106.containsKey(r109.f464206c) == true) goto L29;
    L33:
        ag.a<String, String, String> r110 = ag.f464197b;
        if (r106.containsKey(r110.f464206c) == true) goto L36;
    L40:
        ag.a<String, String, String> r111 = ag.f464198c;
        if (r106.containsKey(r111.f464206c) == true) goto L43;
    L47:
        ag.a<String, String, String> r112 = ag.f464203h;
        if (r106.containsKey(r112.f464206c) == true) goto L50;
        return r102;
    L50:
        if (r106.getBoolean(r112.f464206c) == false) goto L52;
        int r113 = 4096;
    L88:
        return r102 | r113;
    L52:
        r113 = 8192;
        goto L88
    L43:
        if (r106.getBoolean(r111.f464206c) == false) goto L45;
        int r114 = 1024;
    L46:
        r102 = r102 | r114;
        goto L47
    L45:
        r114 = 2048;
        goto L46
    L36:
        if (r106.getBoolean(r110.f464206c) == false) goto L38;
        int r115 = 256;
    L39:
        r102 = r102 | r115;
        goto L40
    L38:
        r115 = 512;
        goto L39
    L29:
        if (r106.getBoolean(r109.f464206c) == false) goto L31;
        int r116 = 64;
    L32:
        r102 = r102 | r116;
        goto L33
    L31:
        r116 = 128;
        goto L32
    L23:
        if (r106.getBoolean(r108.f464206c) == false) goto L25;
        r104 = 16;
    L25:
        r102 = r102 | r104;
        goto L26
    L17:
        if (r106.getBoolean(r107.f464206c) == false) goto L19;
        r105 = 4;
    L19:
        r102 = r102 | r105;
        goto L20
    L54:
        int r117 = a(r101, 1);
        if (r117 != 1) goto L57;
        r102 = r102 | 4;
    L59:
        int r118 = a(r101, 4);
        if (r118 != 1) goto L62;
        r102 = r102 | 16;
    L64:
        int r119 = a(r101, 2);
        if (r119 != 1) goto L67;
        r102 = r102 | 64;
    L69:
        int r120 = a(r101, 8);
        if (r120 != 1) goto L72;
        r102 = r102 | 256;
    L74:
        int r121 = a(r101, 16);
        if (r121 != 1) goto L77;
        r102 = r102 | 1024;
    L79:
        int r122 = a(r101, 32);
        if (r122 != 1) goto L83;
        int r123 = r102 | 4096;
    L89:
        return r123;
    L83:
        if (r122 != 0) goto L90;
        r123 = r102 | 8192;
        goto L89
    L90:
        return r102;
    L77:
        if (r121 != 0) goto L79;
        r102 = r102 | 2048;
        goto L79
    L72:
        if (r120 != 0) goto L74;
        r102 = r102 | 512;
        goto L74
    L67:
        if (r119 != 0) goto L69;
        r102 = r102 | 128;
        goto L69
    L62:
        if (r118 != 0) goto L64;
        r102 = r102 | 32;
        goto L64
    L57:
        if (r117 != 0) goto L59;
        r102 = r102 | 8;
        goto L59
    L10:
        if (r103 != com.xiaomi.push.g.b.f463641c) goto L12;
        r102 = 2;
        goto L12
    }

    private static int a(String r100, int r101) {
        return ag.a(com.xiaomi.push.q.m9304a(), r100, null, f464184a.get(r101));
    }
}
