package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d f331786i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f331787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f331788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f331789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f331790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f331791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f331792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f331793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f331794h;

    public static final class a {
    }

    public d() {
        this(false, 0, 0, 0, null, null, false, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f331787a == r101.f331787a) goto L12;
        return false;
    L12:
        if (this.f331788b == r101.f331788b) goto L15;
        return false;
    L15:
        if (this.f331789c == r101.f331789c) goto L18;
        return false;
    L18:
        if (this.f331790d == r101.f331790d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f331791e, r101.f331791e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f331792f, r101.f331792f) == true) goto L27;
        return false;
    L27:
        if (this.f331793g == r101.f331793g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f331794h, r101.f331794h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f331787a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((((((((r101 * 31) + this.f331788b) * 31) + this.f331789c) * 31) + this.f331790d) * 31) + this.f331791e.hashCode()) * 31) + this.f331792f.hashCode()) * 31;
        if (this.f331793g == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f331794h;
        if (r104 != null) goto L13;
        int r105 = 0;
    L15:
        return r103 + r105;
    L13:
        r105 = r104.hashCode();
        goto L15
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraOfflineRecordTransferProgress(syncing=" + this.f331787a + ", totalCount=" + this.f331788b + ", completedCount=" + this.f331789c + ", progress=" + this.f331790d + ", currentVuiId=" + this.f331791e + ", localFilePath=" + this.f331792f + ", hasError=" + this.f331793g + ", errorMessage=" + this.f331794h + ')';
    }

    static {
        f331786i = new d(false, 0, 0, 0, null, null, false, null, 255);
    }

    public d(boolean r100, int r101, int r102, int r103, String r104, String r105, boolean r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = "";
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = "";
    L21:
        if ((r112 & 64) == 0) goto L24;
        r110 = false;
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = null;
    L26:
        Intrinsics.checkNotNullParameter(r104, "currentVuiId");
        Intrinsics.checkNotNullParameter(r105, "localFilePath");
        this.f331787a = r100;
        this.f331788b = r101;
        this.f331789c = r102;
        this.f331790d = r103;
        this.f331791e = r104;
        this.f331792f = r105;
        this.f331793g = r110;
        this.f331794h = r111;
    }
}
