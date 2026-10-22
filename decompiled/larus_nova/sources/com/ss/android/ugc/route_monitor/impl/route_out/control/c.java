package com.ss.android.ugc.route_monitor.impl.route_out.control;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f454613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f454614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f454615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f454616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454617e;

    public final int hashCode() {
        return this.f454615c.hashCode();
    }

    public final String toString() {
        return "{certId = " + this.f454615c + ", onceValid = " + this.f454616d + '}';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f454615c, ((c) r100).f454615c) == false) goto L7;
        return true;
    }

    public c(String r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r102 & 4) == 0) goto L8;
        long r103 = -1;
    L9:
        this.f454615c = r100;
        this.f454616d = r101;
        this.f454617e = r103;
        b r104 = new b(this);
        this.f454614b = r104;
        if (r103 <= 0) goto L13;
        com.ss.android.ugc.route_monitor.utils.r.a(r104, r103);
        return;
    L13:
        return;
    L8:
        r103 = 0;
        goto L9
    }
}
