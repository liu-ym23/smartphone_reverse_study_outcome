package com.bytedance.salamander.adapter;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static final i c = null;
    public static final i d = null;
    public static final i e = null;
    public final String a;
    public final j b;

    public static final class a {
    }

    static {
        c = new i("main", true);
        d = new i("background", false);
        e = new i("utility", false);
        new i("userInteractive", false);
        new i("userInitiated", false);
    }

    public i(String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "name");
        this.a = "";
        this.a = r6;
        ConcurrentHashMap<String, j> r1 = v.a;
        Intrinsics.checkNotNullParameter(r6, "name");
        ConcurrentHashMap<String, j> r0 = v.a;
        Locale r2 = Locale.ROOT;
        String r3 = r6.toLowerCase(r2);
        j r4 = r0.get(r3);
        if (r4 != null) goto L39;
        String r5 = r6.toLowerCase(r2);
        switch(r5.hashCode()) {
            case -1332194002: goto L27;
            case -288953984: goto L23;
            case -114978452: goto L19;
            case 3343801: goto L16;
            case 1544803905: goto L12;
            case 2090935863: goto L8;
            default: goto L31;
        };
    L31:
        if (r7 == false) goto L33;
        j r8 = new t(r6, 0);
    L34:
        r4 = r8;
    L35:
        j r9 = r0.putIfAbsent(r3, r4);
        if (r9 == null) goto L39;
        r4 = r9;
        goto L39
    L33:
        r8 = new com.bytedance.salamander.adapter.a(r6, 0);
        goto L34
    L8:
        if (r5.equals("userinteractive") == false) goto L31;
        j r10 = v.a(r6, -8, r7);
    L30:
        r4 = r10;
        goto L35
    L12:
        if (r5.equals("default") == false) goto L31;
        r10 = v.a(r6, 0, r7);
        goto L30
    L16:
        if (r5.equals("main") == false) goto L31;
        r10 = new g();
        goto L30
    L19:
        if (r5.equals("utility") == false) goto L31;
        r10 = v.a(r6, 19, r7);
        goto L30
    L23:
        if (r5.equals("userinitiated") == false) goto L31;
        r10 = v.a(r6, -4, r7);
        goto L30
    L27:
        if (r5.equals("background") == false) goto L31;
        r10 = v.a(r6, 10, r7);
    L39:
        this.b = r4;
    }
}
