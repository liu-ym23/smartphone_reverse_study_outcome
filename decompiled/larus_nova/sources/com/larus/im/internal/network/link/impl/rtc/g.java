package com.larus.im.internal.network.link.impl.rtc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f349309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f349310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f349311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f349312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f349313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f349314f;

    public static final class a {
    }

    static {
    }

    public final synchronized void a() {
        monitor-enter(this);
        this.f349313e = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        this.f349312d = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized long d(long r100) {
        monitor-enter(this);
        long r101 = RangesKt.coerceAtLeast(this.f349310b - r100, 0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized h c(RTCConnectRetryReason r110, long r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "reason");     // Catch: Throwable -> L52
        if (this.f349309a == true) goto L7;
    L50:
        monitor-exit(this);
        return null;
    L7:
        if (this.f349312d == true) goto L50;
        if (this.f349313e == true) goto L50;
        int r100 = this.f349311c;     // Catch: Throwable -> L52
        if (r100 < 2) goto L16;
        monitor-exit(this);
        return null;
    L16:
        int r101 = r100 + 1;
        if (r110 != RTCConnectRetryReason.NETWORK_RECOVERY) goto L20;
        long r102 = 800;
    L23:
        long r103 = r111 + r102;     // Catch: Throwable -> L52
        long r112 = this.f349310b;     // Catch: Throwable -> L52
        if (r103 < r112) goto L28;
        monitor-exit(this);
        return null;
    L28:
        this.f349311c = r101;     // Catch: Throwable -> L52
        if (r110 == RTCConnectRetryReason.START_SESSION_FAILED) goto L33;
        if (r110 == RTCConnectRetryReason.SESSION_STARTED_TIMEOUT) goto L33;
    L35:
        RTCConnectRetryAction r104 = RTCConnectRetryAction.FULL_RECONNECT;     // Catch: Throwable -> L52
    L36:
        RTCConnectRetryAction r105 = r104;
        if (r110 != RTCConnectRetryReason.INVALID_TOKEN) goto L39;
        boolean r106 = true;
    L41:
        if (r110 != RTCConnectRetryReason.NO_ENGINE) goto L43;
    L46:
        boolean r113 = true;
    L47:
        h r114 = new h(r110, r101, r102, r105, r106, r113, r112);     // Catch: Throwable -> L52
        monitor-exit(this);
        return r114;
    L43:
        if (r110 == RTCConnectRetryReason.CREATE_ROOM_FAILED) goto L46;
        r113 = false;
        goto L47
    L39:
        r106 = false;
    L33:
        if (this.f349314f == true) goto L35;
        this.f349314f = true;     // Catch: Throwable -> L52
        r104 = RTCConnectRetryAction.RESEND_START_SESSION;     // Catch: Throwable -> L52
        goto L36
    L20:
        if (r101 != 1) goto L22;
        r102 = 0;
        goto L23
    L22:
        r102 = 500;
    L52:
        th = move-exception;
        throw th;
    }

    public g(boolean r100, long r101, long r102) {
        this.f349309a = r100;
        this.f349310b = r101 + RangesKt.coerceAtLeast(r102, 0);
    }
}
