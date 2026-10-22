package com.bytedance.badger.network;

import android.os.SystemClock;
import com.bytedance.badger.data.ReportStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f199073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z64.c f199074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z64.g f199075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReportStage f199076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f199077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f199078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f199079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f199080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f199081i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L44:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L43;
        b r101 = (b) r100;
        if (this.f199073a != r101.f199073a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L43;
        if (Intrinsics.areEqual(this.f199074b, r101.f199074b) == false) goto L43;
        if (Intrinsics.areEqual(this.f199075c, r101.f199075c) == false) goto L43;
        if (Intrinsics.areEqual(this.f199076d, r101.f199076d) == false) goto L43;
        if (this.f199077e != r101.f199077e) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L43;
        if (this.f199078f != r101.f199078f) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L43;
        if (this.f199079g != r101.f199079g) goto L30;
        boolean r105 = true;
    L31:
        if (r105 == false) goto L43;
        if (this.f199080h != r101.f199080h) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L43;
        if (this.f199081i != r101.f199081i) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L43;
    L40:
        r107 = false;
        goto L41
    L35:
        r106 = false;
        goto L36
    L30:
        r105 = false;
        goto L31
    L25:
        r104 = false;
        goto L26
    L20:
        r103 = false;
        goto L21
    L9:
        r102 = false;
    L43:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r100 = this.f199073a * 31;
        z64.c r101 = this.f199074b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        z64.g r105 = this.f199075c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        ReportStage r108 = this.f199076d;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        int r109 = (r107 + r102) * 31;
        boolean r110 = this.f199077e;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L16;
        r112 = 1;
    L16:
        long r113 = this.f199078f;
        int r114 = (((r109 + r112) * 31) + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f199079g;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f199080h;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        boolean r119 = this.f199081i;
        if (r119 == true) goto L21;
        r111 = r119;
    L21:
        return r118 + r111;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CustomReportContext(sceneId=" + this.f199073a + ", badgerRequest=" + this.f199074b + ", callback=" + this.f199075c + ", reportStage=" + this.f199076d + ", isTimeoutRetry=" + this.f199077e + ", timeoutElapsedTimeMs=" + this.f199078f + ", startTime=" + this.f199079g + ", startUptime=" + this.f199080h + ", ignoreCheckForeground=" + this.f199081i + ")";
    }

    public b(int r100, z64.c r101, z64.g r102, ReportStage r103, boolean r104, long r105, long r110, long r111, boolean r112, int r113) {
        if ((r113 & 8) == 0) goto L6;
        r103 = ReportStage.FINAL;
    L6:
        if ((r113 & 16) == 0) goto L9;
        r104 = false;
    L9:
        if ((r113 & 32) == 0) goto L12;
        r105 = 0;
    L12:
        if ((r113 & 64) == 0) goto L15;
        r110 = SystemClock.elapsedRealtime();
    L15:
        if ((r113 & 128) == 0) goto L18;
        r111 = SystemClock.uptimeMillis();
    L18:
        if ((r113 & 256) == 0) goto L20;
        r112 = false;
    L20:
        this.f199073a = r100;
        this.f199074b = r101;
        this.f199075c = r102;
        this.f199076d = r103;
        this.f199077e = r104;
        this.f199078f = r105;
        this.f199079g = r110;
        this.f199080h = r111;
        this.f199081i = r112;
    }
}
