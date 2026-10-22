package com.vivo.push.restructure.a.a;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes41.dex */
final class g extends a<com.vivo.push.restructure.a.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462458b;

    @Override // com.vivo.push.restructure.a.a.a
    public final synchronized String b() {
        monitor-enter(this);
        a(this.f462458b);     // Catch: Throwable -> L6
        String r100 = super.b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.vivo.push.restructure.a.a.a
    public final /* bridge */ /* synthetic */ int a(com.vivo.push.restructure.a.a r100) {
        return 0;
    }

    public g(com.vivo.push.restructure.a.a r100, j r101) {
        super("IPCNode", r100, r101);
        this.f462458b = 0;
        long r102 = SystemClock.elapsedRealtime();
        long r103 = r100.d();
        if (r103 > 0) goto L5;
        return;
    L5:
        if (r102 <= r103) goto L9;
        this.f462458b = r102 - r103;
        return;
    }
}
