package com.f.android.quality.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f274098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f274099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f274100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f274101d;

    public final synchronized void a() {
        monitor-enter(this);
        this.f274098a = true;     // Catch: Throwable -> L7
        this.f274099b.a();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final int hashCode() {
        String r100 = this.f274100c;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f274101d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Step(" + this.f274100c + ", " + this.f274101d + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f274100c, r101.f274100c) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.f274101d, r101.f274101d) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public f(String r100, String r101) {
        this.f274100c = r100;
        this.f274101d = r101;
        this.f274099b = new b();
    }
}
