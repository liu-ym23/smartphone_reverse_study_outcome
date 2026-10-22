package com.larus.platform.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f365263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FlowDriveFileType f365264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f365266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f365267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f365268h;

    public s() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f365261a, r101.f365261a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365262b, r101.f365262b) == true) goto L15;
        return false;
    L15:
        if (this.f365263c == r101.f365263c) goto L18;
        return false;
    L18:
        if (this.f365264d == r101.f365264d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365265e, r101.f365265e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f365266f, r101.f365266f) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.f365267g, r101.f365267g) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f365268h, r101.f365268h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f365261a.hashCode() * 31) + this.f365262b.hashCode()) * 31;
        long r101 = this.f365263c;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f365264d.hashCode()) * 31;
        String r103 = this.f365265e;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f365266f;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (((r106 + r108) * 31) + Float.floatToIntBits(this.f365267g)) * 31;
        Map<String, String> r110 = this.f365268h;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return r109 + r104;
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowDriveFileItem(fileName=" + this.f365261a + ", fileToken=" + this.f365262b + ", fileSize=" + this.f365263c + ", fileType=" + this.f365264d + ", originImgUrl=" + this.f365265e + ", videoCoverUrl=" + this.f365266f + ", videoDuration=" + this.f365267g + ", extra=" + this.f365268h + ')';
    }

    public s(String r100, String r101, long r102, FlowDriveFileType r103, Map r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = FlowDriveFileType.FILE;
    L9:
        if ((r105 & 128) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "fileName");
        Intrinsics.checkNotNullParameter(r101, "fileToken");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        this.f365261a = r100;
        this.f365262b = r101;
        this.f365263c = r102;
        this.f365264d = r103;
        this.f365265e = null;
        this.f365266f = null;
        this.f365267g = 0.0f;
        this.f365268h = r104;
    }
}
