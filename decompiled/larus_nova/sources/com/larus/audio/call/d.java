package com.larus.audio.call;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f289098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f289099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f289100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f289101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f289102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f289103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f289104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f289105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f289106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f289107j;

    public d() {
        this(false, false, "", "", "", "", "", "", Long.MAX_VALUE, Long.MAX_VALUE);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f289098a == r101.f289098a) goto L12;
        return false;
    L12:
        if (this.f289099b == r101.f289099b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f289100c, r101.f289100c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f289101d, r101.f289101d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f289102e, r101.f289102e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f289103f, r101.f289103f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f289104g, r101.f289104g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f289105h, r101.f289105h) == true) goto L33;
        return false;
    L33:
        if (this.f289106i == r101.f289106i) goto L36;
        return false;
    L36:
        if (this.f289107j == r101.f289107j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f289098a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f289099b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((((((((((((r102 + r100) * 31) + this.f289100c.hashCode()) * 31) + this.f289101d.hashCode()) * 31) + this.f289102e.hashCode()) * 31) + this.f289103f.hashCode()) * 31) + this.f289104g.hashCode()) * 31) + this.f289105h.hashCode()) * 31;
        long r104 = this.f289106i;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f289107j;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DumpConfig(isRealtimeCallDumpEnable=" + this.f289098a + ", isDoraCallDumpEnable=" + this.f289099b + ", realtimeDumpDir=" + this.f289100c + ", streamPlayerDumpDire=" + this.f289101d + ", doraDumpDir=" + this.f289102e + ", aecDumpDir=" + this.f289103f + ", loudnessDumpPath=" + this.f289104g + ", doraSiDumpDir=" + this.f289105h + ", realtimeDumpFileSizeBytes=" + this.f289106i + ", realtimeDumpTotalSizeBytes=" + this.f289107j + ')';
    }

    public d(boolean r100, boolean r101, String r102, String r103, String r104, String r105, String r106, String r107, long r110, long r111) {
        Intrinsics.checkNotNullParameter(r102, "realtimeDumpDir");
        Intrinsics.checkNotNullParameter(r103, "streamPlayerDumpDire");
        Intrinsics.checkNotNullParameter(r104, "doraDumpDir");
        Intrinsics.checkNotNullParameter(r105, "aecDumpDir");
        Intrinsics.checkNotNullParameter(r106, "loudnessDumpPath");
        Intrinsics.checkNotNullParameter(r107, "doraSiDumpDir");
        this.f289098a = r100;
        this.f289099b = r101;
        this.f289100c = r102;
        this.f289101d = r103;
        this.f289102e = r104;
        this.f289103f = r105;
        this.f289104g = r106;
        this.f289105h = r107;
        this.f289106i = r110;
        this.f289107j = r111;
    }
}
