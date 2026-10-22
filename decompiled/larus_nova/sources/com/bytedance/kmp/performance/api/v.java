package com.bytedance.kmp.performance.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import md6.d1;

/* JADX INFO: loaded from: classes19.dex */
public final class v implements AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f252689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f252690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<d1, AutoCloseable> f252691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d1 f252692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f252693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f252694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f252695g;

    public v() {
        throw null;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f252695g == false) goto L5;
        return;
    L5:
        this.f252695g = true;
    }

    public final boolean a(int r100) {
        if (this.f252695g == false) goto L5;
        return false;
    L5:
        if (this.f252694f == true) goto L19;
        boolean r101 = this.f252689a;
        if (r101 == true) goto L10;
        return false;
    L10:
        if (r101 == false) goto L14;
        if (r100 < 1) goto L14;
        boolean r102 = true;
    L15:
        if (r102 == false) goto L20;
        return true;
    L20:
        return false;
    L14:
        r102 = false;
        goto L15
    L19:
        return false;
    }

    public v(boolean r100, Function0 r101) {
        Function1<d1, AutoCloseable> r102 = new u();
        Intrinsics.checkNotNullParameter(r101, "onStarted");
        Intrinsics.checkNotNullParameter(r102, "traceSubscriber");
        this.f252689a = r100;
        this.f252690b = r101;
        this.f252691c = r102;
        this.f252692d = new d1(null);
    }
}
