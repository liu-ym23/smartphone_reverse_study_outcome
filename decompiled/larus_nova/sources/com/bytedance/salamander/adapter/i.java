package com.bytedance.salamander.adapter;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f267784c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f267785d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f267786e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f267787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f267788b;

    public static final class a {
    }

    static {
        f267784c = new i(PullConfiguration.PROCESS_NAME_MAIN, true);
        f267785d = new i("background", false);
        f267786e = new i("utility", false);
        new i("userInteractive", false);
        new i("userInitiated", false);
    }

    public i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f267787a = "";
        this.f267787a = r100;
        ConcurrentHashMap<String, j> r102 = v.f267800a;
        Intrinsics.checkNotNullParameter(r100, "name");
        ConcurrentHashMap<String, j> r103 = v.f267800a;
        Locale r104 = Locale.ROOT;
        String r105 = r100.toLowerCase(r104);
        j r106 = r103.get(r105);
        if (r106 != null) goto L39;
        String r107 = r100.toLowerCase(r104);
        switch(r107.hashCode()) {
            case -1332194002: goto L27;
            case -288953984: goto L23;
            case -114978452: goto L19;
            case 3343801: goto L16;
            case 1544803905: goto L12;
            case 2090935863: goto L8;
            default: goto L31;
        };
    L31:
        if (r101 == false) goto L33;
        j r108 = new t(r100, 0);
    L34:
        r106 = r108;
    L35:
        j r109 = r103.putIfAbsent(r105, r106);
        if (r109 == null) goto L39;
        r106 = r109;
        goto L39
    L33:
        r108 = new com.bytedance.salamander.adapter.a(r100, 0);
        goto L34
    L8:
        if (r107.equals("userinteractive") == false) goto L31;
        j r110 = v.a(r100, -8, r101);
    L30:
        r106 = r110;
        goto L35
    L12:
        if (r107.equals("default") == false) goto L31;
        r110 = v.a(r100, 0, r101);
        goto L30
    L16:
        if (r107.equals(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L31;
        r110 = new g();
        goto L30
    L19:
        if (r107.equals("utility") == false) goto L31;
        r110 = v.a(r100, 19, r101);
        goto L30
    L23:
        if (r107.equals("userinitiated") == false) goto L31;
        r110 = v.a(r100, -4, r101);
        goto L30
    L27:
        if (r107.equals("background") == false) goto L31;
        r110 = v.a(r100, 10, r101);
    L39:
        this.f267788b = r106;
    }
}
