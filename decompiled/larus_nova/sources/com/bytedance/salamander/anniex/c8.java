package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c8 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<Integer, s4> f268005j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f268006k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c8 f268007l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s4 f268008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s4 f268009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s4 f268010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s4 f268011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s4 f268012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s4 f268013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s4 f268014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public s4 f268015h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public s4 f268016i;

    public static final class a {
        public a() {
        }

        public static final s4 a(boolean r100, int r101) {
            Map<Integer, s4> r102 = c8.f268005j;
            s4 r103 = new s4(r100);
            com.bytedance.rts.foundation.m.e(c8.f268005j, Integer.valueOf(r101), r103);
            if (r101 <= c8.f268006k) goto L5;
            c8.f268006k = r101;
        L5:
            return r103;
        }
    }

    static {
        new a();
        f268005j = new LinkedHashMap();
        f268007l = new c8();
    }

    public final s4 a() {
        s4 r100 = this.f268012e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("lynxMonitor");
        return null;
    }

    public final s4 b() {
        s4 r100 = this.f268009b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("webMonitor");
        return null;
    }

    public c8() {
        s4 r100 = a.a(true, 0);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f268008a = r100;
        s4 r101 = a.a(true, 1);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f268009b = r101;
        Intrinsics.checkNotNullParameter(a.a(true, 2), "<set-?>");
        s4 r102 = a.a(true, 3);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f268010c = r102;
        s4 r103 = a.a(true, 4);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f268011d = r103;
        Intrinsics.checkNotNullParameter(a.a(true, 5), "<set-?>");
        s4 r104 = a.a(true, 6);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f268012e = r104;
        s4 r105 = a.a(true, 7);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        this.f268013f = r105;
        Intrinsics.checkNotNullParameter(a.a(true, 8), "<set-?>");
        s4 r106 = a.a(true, 9);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f268014g = r106;
        s4 r107 = a.a(true, 10);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        this.f268015h = r107;
        Intrinsics.checkNotNullParameter(a.a(true, 11), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 12), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 24), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 25), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 26), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 27), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 28), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 29), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(true, 30), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(false, 31), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(false, 32), "<set-?>");
        Intrinsics.checkNotNullParameter(a.a(false, 35), "<set-?>");
        s4 r108 = a.a(true, 37);
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        this.f268016i = r108;
    }
}
