package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f331796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f331797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f331798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f331799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f331800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f331801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f331802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f331803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f331804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f331805k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f331806l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f331807m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f331808n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f331809o;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f331795a, r101.f331795a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f331796b, r101.f331796b) == true) goto L15;
        return false;
    L15:
        if (this.f331797c == r101.f331797c) goto L18;
        return false;
    L18:
        if (this.f331798d == r101.f331798d) goto L21;
        return false;
    L21:
        if (this.f331799e == r101.f331799e) goto L24;
        return false;
    L24:
        if (this.f331800f == r101.f331800f) goto L27;
        return false;
    L27:
        if (this.f331801g == r101.f331801g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f331802h, r101.f331802h) == true) goto L33;
        return false;
    L33:
        if (this.f331803i == r101.f331803i) goto L36;
        return false;
    L36:
        if (this.f331804j == r101.f331804j) goto L39;
        return false;
    L39:
        if (this.f331805k == r101.f331805k) goto L42;
        return false;
    L42:
        if (this.f331806l == r101.f331806l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f331807m, r101.f331807m) == true) goto L48;
        return false;
    L48:
        if (this.f331808n == r101.f331808n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f331809o, r101.f331809o) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f331795a.hashCode() * 31;
        String r101 = this.f331796b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f331797c) * 31;
        long r104 = this.f331798d;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f331799e;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f331800f;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f331801g;
        int r111 = (((((((((((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f331802h.hashCode()) * 31) + this.f331803i) * 31) + this.f331804j) * 31) + this.f331805k) * 31) + this.f331806l) * 31) + this.f331807m.hashCode()) * 31;
        long r112 = this.f331808n;
        return ((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.f331809o.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraOfflineSyncedRecording(vuiId=" + this.f331795a + ", onlineRecordId=" + this.f331796b + ", segmentType=" + this.f331797c + ", startTimeMs=" + this.f331798d + ", endTimeMs=" + this.f331799e + ", durationMs=" + this.f331800f + ", fileSize=" + this.f331801g + ", fileFormat=" + this.f331802h + ", sampleRate=" + this.f331803i + ", channels=" + this.f331804j + ", bitrateBps=" + this.f331805k + ", frameMs=" + this.f331806l + ", checksum=" + this.f331807m + ", createdAtMs=" + this.f331808n + ", localFilePath=" + this.f331809o + ')';
    }

    public e(String r100, String r101, int r110, long r111, long r112, long r113, long r114, String r115, int r210, int r211, int r212, int r213, String r214, long r215, String r216) {
        Intrinsics.checkNotNullParameter(r100, "vuiId");
        Intrinsics.checkNotNullParameter(r115, "fileFormat");
        Intrinsics.checkNotNullParameter(r214, "checksum");
        Intrinsics.checkNotNullParameter(r216, "localFilePath");
        this.f331795a = r100;
        this.f331796b = r101;
        this.f331797c = r110;
        this.f331798d = r111;
        this.f331799e = r112;
        this.f331800f = r113;
        this.f331801g = r114;
        this.f331802h = r115;
        this.f331803i = r210;
        this.f331804j = r211;
        this.f331805k = r212;
        this.f331806l = r213;
        this.f331807m = r214;
        this.f331808n = r215;
        this.f331809o = r216;
    }
}
