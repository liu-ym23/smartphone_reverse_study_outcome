package com.bytedance.ee.bear.bitable.infoarch.nativeview.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f213646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f213647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f213648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f213649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f213650e;

    public final void b() {
        d r100 = this.f213650e;
        r100.f213675b++;
        r100.f213674a += System.currentTimeMillis() - this.f213647b;
    }

    public final void a() {
        this.f213647b = System.currentTimeMillis();
    }

    public a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleConsumer");
        this.f213646a = r100;
        this.f213650e = new d();
    }
}
