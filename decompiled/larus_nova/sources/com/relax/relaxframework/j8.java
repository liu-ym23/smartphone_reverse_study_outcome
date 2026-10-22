package com.relax.relaxframework;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j8 extends v0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static long f405151l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f405152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f405153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final double f405154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f405155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f405156k;

    public static final class a {
    }

    static {
    }

    public j8(String r100, double r101, double r102, double r103, double r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100, EventType.TouchEvent, true, PhaseType.None);
        this.f405152g = r101;
        this.f405153h = r102;
        this.f405154i = r103;
        this.f405155j = r110;
        long r104 = f405151l;
        f405151l = 1 + r104;
        this.f405156k = r104;
    }
}
