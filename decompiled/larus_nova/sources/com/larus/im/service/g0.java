package com.larus.im.service;

import com.larus.im.internal.delegate.y0;
import kotlin.Lazy;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f350840a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f350841b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f350842c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f350843d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f350844e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f350845f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f350846g = 0.0d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f350847h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f350848i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double f350849j = 0.0d;

    static {
        Lazy r100 = y0.f348459a;
        y0.t r101 = new y0.t(0);
        ouc.d0 r102 = y0.i().e("type_writer_spring_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Exception -> L7
        wt7.c r103 = wt7.a.f561230a;     // Catch: Exception -> L7
        String r104 = r102.toString();     // Catch: Exception -> L7
        juc.d<y0.t> r105 = y0.t.Companion.serializer();     // Catch: Exception -> L7
        r103.getClass();     // Catch: Exception -> L7
        y0.t r106 = (y0.t) wt7.c.a(r104, r105);     // Catch: Exception -> L7
        if (r106 == null) goto L9;
        r101 = r106;
    L9:
        f350840a = r101.f348617a;
        f350841b = r101.f348622f;
        f350842c = r101.f348619c;
        int r107 = r101.f348620d;
        f350843d = r107;
        Integer r108 = r101.f348621e;
        if (r108 == null) goto L12;
        r107 = r108.intValue();
    L12:
        f350844e = r107;
        f350845f = r101.f348623g;
        f350846g = r101.f348618b;
        f350847h = r101.f348624h;
        f350848i = r101.f348625i;
        f350849j = r101.f348626j;
        return;
    L7:
        e = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getStreamSmoothConfig(): err=" + e.getMessage());
        goto L9
    }
}
