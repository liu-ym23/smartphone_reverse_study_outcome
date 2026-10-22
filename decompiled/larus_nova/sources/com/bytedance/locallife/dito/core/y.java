package com.bytedance.locallife.dito.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f258159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final lp6.b f258160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.locallife.dito.provider.h> f258161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<AbsDitoPlugin> f258162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f258163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0 f258164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.locallife.dito.provider.f> f258165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.locallife.dito.provider.e> f258166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DitoScrollConfig f258167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a0 f258168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f258169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f258170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f258171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f258172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f258173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f258174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f258175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f258176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f258177s;

    public y() {
        throw null;
    }

    public y(String r210, lp6.b r211, List r212, List r213, t r214, e0 r215, DitoScrollConfig r310, a0 r311, boolean r312, boolean r313, boolean r314, boolean r315, int r316) {
        if ((r316 & 4) == 0) goto L5;
        List r100 = new ArrayList();
    L7:
        if ((r316 & 8) == 0) goto L9;
        List r101 = new ArrayList();
    L11:
        if ((r316 & 16) == 0) goto L13;
        t r102 = new t(0, null, null, 15);
    L15:
        if ((r316 & 32) == 0) goto L17;
        e0 r103 = new e0(null, 0, 0, 0, 31);
    L19:
        if ((r316 & 64) == 0) goto L21;
        ArrayList r110 = new ArrayList();
    L23:
        if ((r316 & 128) == 0) goto L25;
        ArrayList r111 = new ArrayList();
    L27:
        if ((r316 & 256) == 0) goto L29;
        DitoScrollConfig r112 = DitoScrollConfig.DEFAULT;
    L31:
        if ((r316 & 512) == 0) goto L33;
        a0 r113 = new a0(null, null, null, false, false, false, 16383);
    L35:
        if ((r316 & 1024) == 0) goto L37;
        ConcurrentHashMap<String, String> r114 = new ConcurrentHashMap();
    L39:
        if ((r316 & 2048) == 0) goto L41;
        ConcurrentHashMap<String, Object> r115 = new ConcurrentHashMap();
    L43:
        if ((r316 & 4096) == 0) goto L45;
        ConcurrentHashMap<String, Object> r104 = new ConcurrentHashMap();
    L47:
        if ((r316 & 8192) == 0) goto L49;
        boolean r105 = false;
    L50:
        boolean r116 = r105;
        if ((r316 & 16384) == 0) goto L53;
        boolean r106 = false;
    L55:
        if ((r316 & 32768) == 0) goto L57;
        boolean r216 = true;
    L59:
        if ((r316 & 131072) == 0) goto L61;
        boolean r117 = false;
    L62:
        Intrinsics.checkNotNullParameter(r210, "page");
        Intrinsics.checkNotNullParameter(r211, "requestApi");
        Intrinsics.checkNotNullParameter(r100, "viewProviderList");
        Intrinsics.checkNotNullParameter(r101, "pluginList");
        Intrinsics.checkNotNullParameter(r102, "ditoInteractParams");
        Intrinsics.checkNotNullParameter(r103, "monitorData");
        Intrinsics.checkNotNullParameter(r110, "ditoEventBusProviderList");
        Intrinsics.checkNotNullParameter(r111, "actionProviderList");
        Intrinsics.checkNotNullParameter(r112, "scrollConfig");
        Intrinsics.checkNotNullParameter(r113, "ditoUIConfig");
        Intrinsics.checkNotNullParameter(r114, "mobParams");
        Intrinsics.checkNotNullParameter(r115, "paramsMap");
        Intrinsics.checkNotNullParameter(r104, "lynxQueryParams");
        this.f258159a = r210;
        this.f258160b = r211;
        this.f258161c = r100;
        this.f258162d = r101;
        this.f258163e = r102;
        this.f258164f = r103;
        this.f258165g = r110;
        this.f258166h = r111;
        this.f258167i = r112;
        this.f258168j = r113;
        this.f258169k = r114;
        this.f258170l = r115;
        this.f258171m = r104;
        this.f258172n = r116;
        this.f258173o = r106;
        this.f258174p = r216;
        this.f258175q = null;
        this.f258176r = r117;
        h r107 = new h(null);
        this.f258177s = r107;
        rq6.a.f538927a.a("dito_log", "DitoParams - ditoUIConfig: " + r113);
        Pair<String, Object> r108 = r113.f257874a;
        if (r108 == null) goto L65;
        r107.f257922c.add(TuplesKt.to(r108.getFirst(), r108.getSecond()));
    L65:
        r107.f257922c.addAll(r113.f257876c);
        Pair<String, Object> r109 = r113.f257875b;
        if (r109 == null) goto L68;
        r107.f257920a.add(TuplesKt.to(r109.getFirst(), r109.getSecond()));
    L68:
        r107.f257923d.addAll(r113.f257877d);
        r107.f257924e.addAll(r113.f257878e);
        r107.f257925f = r113.f257881h;
        r107.f257926g = r113.f257882i;
        r107.f257927h = r113.f257879f;
        r107.f257928i = r113.f257880g;
        return;
    L61:
        r117 = r315;
        goto L62
    L57:
        r216 = r314;
        goto L59
    L53:
        r106 = r313;
        goto L55
    L49:
        r105 = r312;
        goto L50
    L45:
        r104 = null;
        goto L47
    L41:
        r115 = null;
        goto L43
    L37:
        r114 = null;
        goto L39
    L33:
        r113 = r311;
        goto L35
    L29:
        r112 = r310;
        goto L31
    L25:
        r111 = null;
        goto L27
    L21:
        r110 = null;
        goto L23
    L17:
        r103 = r215;
        goto L19
    L13:
        r102 = r214;
        goto L15
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }
}
