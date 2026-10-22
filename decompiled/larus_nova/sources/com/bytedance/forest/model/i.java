package com.bytedance.forest.model;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.forest.pollyfill.NetWorker;
import com.bytedance.geckox.GeckoClient;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetWorker f244339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super Integer, ? super String, ? super Map<String, ? extends Object>, Unit> f244340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f244341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f244342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f244343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f244344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f244345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GeckoConfig f244346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, GeckoConfig> f244347i;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{[host]=");
        r100.append(this.f244345g);
        r100.append(",[region]=");
        GeckoConfig r101 = this.f244346h;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f244246g;
    L6:
        r100.append(r103);
        r100.append(",[appId]=");
        GeckoConfig r104 = this.f244346h;
        if (r104 == null) goto L9;
        Long r105 = Long.valueOf(r104.f244243d);
    L10:
        r100.append(r105);
        r100.append(",[appVersion]=");
        GeckoConfig r106 = this.f244346h;
        if (r106 == null) goto L13;
        String r107 = r106.f244244e;
    L14:
        r100.append(r107);
        r100.append(",[did]=");
        GeckoConfig r108 = this.f244346h;
        if (r108 == null) goto L17;
        r102 = r108.f244245f;
    L17:
        r100.append(r102);
        return r100.toString();
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final GeckoConfig a(String r110) {
        Map<String, GeckoConfig> r100 = this.f244347i;
        if (r110 == null) goto L5;
        String r101 = r110;
    L6:
        GeckoConfig r102 = r100.get(r101);
        if (r102 == null) goto L10;
    L49:
        if (r102 == null) goto L52;
        return r102;
    L52:
        return this.f244346h;
    L10:
        if (com.bytedance.forest.utils.h.a(r110) == false) goto L18;
        GeckoConfig r103 = this.f244346h;
        if (r103 == null) goto L14;
        String r104 = r103.f244241b;
    L16:
        if (Intrinsics.areEqual(r110, r104) == false) goto L18;
        r102 = this.f244346h;
        goto L49
    L14:
        r104 = null;
    L18:
        GeckoConfig.a r105 = GeckoConfig.f244239j;
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        r105.getClass();
        Lazy r106 = GeckoConfig.f244238i;
        GeckoConfig r107 = (GeckoConfig) ((Map) r106.getValue()).get(r110);
        if (r107 == null) goto L25;
        r102 = r107;
        goto L49
    L25:
        GeckoClient r108 = com.bytedance.geckox.a.a(r110);
        if (r108 == null) goto L48;
        com.bytedance.geckox.GeckoConfig r109 = r108.getConfig();
        String r111 = r109.getAccessKey();
        if (r111 == null) goto L30;
        String r112 = r111;
    L31:
        String r113 = r109.getResRootDir().getAbsolutePath();
        if (r113 == null) goto L34;
        String r114 = r113;
    L35:
        long r115 = r109.getAppId();
        String r116 = r109.getAppVersion();
        if (r116 == null) goto L38;
        String r117 = r116;
    L39:
        String r118 = r109.getDeviceId();
        if (r118 == null) goto L42;
        String r119 = r118;
    L43:
        String r120 = r109.getRegion();
        if (r120 == null) goto L46;
        String r121 = r120;
    L47:
        GeckoConfig r122 = new GeckoConfig(r112, r114, r115, r117, r119, r121, false);
        ((Map) r106.getValue()).put(r110, r122);
        r102 = r122;
        goto L49
    L46:
        r121 = "";
        goto L47
    L42:
        r119 = "";
        goto L43
    L38:
        r117 = "";
        goto L39
    L34:
        r114 = "";
        goto L35
    L30:
        r112 = "";
        goto L31
    L48:
        r102 = null;
        goto L49
    L5:
        r101 = "";
        goto L6
    }

    public i(String r100, GeckoConfig r101, Map<String, GeckoConfig> r102) {
        this.f244345g = r100;
        this.f244346h = r101;
        this.f244347i = r102;
        this.f244339a = d.f244330a;
        this.f244341c = BmLocated.ALIGN_RIGHT_BOTTOM;
        this.f244342d = 4194304;
        this.f244343e = false;
        this.f244344f = d.f244331b;
    }

    public /* synthetic */ i(String r100, GeckoConfig r101, int r102) {
        LinkedHashMap r103 = null;
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r103 = new LinkedHashMap();
    L8:
        this(r100, r101, r103);
    }
}
