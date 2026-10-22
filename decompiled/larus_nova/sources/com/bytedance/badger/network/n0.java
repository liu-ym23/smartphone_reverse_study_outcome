package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.monitor.TriggerStage;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z64.c f199123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f199124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f199125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TriggerStage f199126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f199127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f199128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f199129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f199130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.badger.C.a f199131i;

    public /* synthetic */ n0(z64.c r110, int r111, TriggerStage r112, com.bytedance.badger.C.a r113, int r114) {
        if ((r114 & 32) == 0) goto L5;
        long r100 = SystemClock.elapsedRealtime();
    L7:
        if ((r114 & 64) == 0) goto L9;
        long r101 = SystemClock.uptimeMillis();
    L11:
        if ((r114 & 128) == 0) goto L13;
        AtomicLong r102 = new AtomicLong(0);
    L14:
        AtomicLong r115 = r102;
        if ((r114 & 256) == 0) goto L17;
        com.bytedance.badger.C.a r116 = com.bytedance.badger.C.a.f199018b;
    L18:
        this(r110, "/passport/dtrait/sinr/", r111, r112, false, r100, r101, r115, r116);
        return;
    L17:
        r116 = r113;
        goto L18
    L13:
        r102 = null;
        goto L14
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = 0;
        goto L7
    }

    public n0(z64.c r100, String r101, int r102, TriggerStage r103, boolean r104, long r105, long r106, AtomicLong r110, com.bytedance.badger.C.a r111) {
        this.f199123a = r100;
        this.f199124b = r101;
        this.f199125c = r102;
        this.f199126d = r103;
        this.f199127e = r104;
        this.f199128f = r105;
        this.f199129g = r106;
        this.f199130h = r110;
        this.f199131i = r111;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L38:
        return true;
    L5:
        if ((r100 instanceof n0) == false) goto L37;
        n0 r101 = (n0) r100;
        if (Intrinsics.areEqual(this.f199123a, r101.f199123a) == false) goto L37;
        if (Intrinsics.areEqual(this.f199124b, r101.f199124b) == false) goto L37;
        if (this.f199125c != r101.f199125c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L37;
        if (Intrinsics.areEqual(this.f199126d, r101.f199126d) == false) goto L37;
        if (this.f199127e != r101.f199127e) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L37;
        if (this.f199128f != r101.f199128f) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L37;
        if (this.f199129g != r101.f199129g) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L37;
        if (Intrinsics.areEqual(this.f199130h, r101.f199130h) == false) goto L37;
        if (Intrinsics.areEqual(this.f199131i, r101.f199131i) == false) goto L37;
    L30:
        r105 = false;
        goto L31
    L25:
        r104 = false;
        goto L26
    L20:
        r103 = false;
        goto L21
    L13:
        r102 = false;
    L37:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        z64.c r100 = this.f199123a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f199124b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f199125c) * 31;
        TriggerStage r107 = this.f199126d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f199127e;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f199128f;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f199129g;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        AtomicLong r117 = this.f199130h;
        if (r117 == null) goto L20;
        int r118 = r117.hashCode();
    L21:
        int r119 = (r116 + r118) * 31;
        com.bytedance.badger.C.a r120 = this.f199131i;
        if (r120 == null) goto L25;
        r101 = r120.hashCode();
    L25:
        return r119 + r101;
    L20:
        r118 = 0;
        goto L21
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportContext(request=" + this.f199123a + ", path=" + this.f199124b + ", timeout=" + this.f199125c + ", triggerStage=" + this.f199126d + ", isTimeoutRetry=" + this.f199127e + ", startTime=" + this.f199128f + ", startUptime=" + this.f199129g + ", timeoutElapsedTimeMs=" + this.f199130h + ", compensateType=" + this.f199131i + ")";
    }
}
