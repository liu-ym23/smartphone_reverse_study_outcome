package com.google.android.gms.common.internal;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f274530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RootTelemetryConfiguration f274531c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RootTelemetryConfiguration f274532a;

    static {
        f274531c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    public b() {
    }

    public final synchronized void a(RootTelemetryConfiguration r100) {
        monitor-enter(this);
        if (r100 != null) goto L7;
        this.f274532a = f274531c;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L7:
        RootTelemetryConfiguration r101 = this.f274532a;     // Catch: Throwable -> L17
        if (r101 != null) goto L10;
    L14:
        this.f274532a = r100;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        if (r101.f274521a < r100.f274521a) goto L14;
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
