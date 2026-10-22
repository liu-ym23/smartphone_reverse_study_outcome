package com.larus.office.plugins.slides.media.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f363416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f363417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f363418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f363419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f363420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f363421f;

    public a() {
        String r100 = null;
        this(r100, r100, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f363416a == r101.f363416a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363417b, r101.f363417b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f363418c, r101.f363418c) == true) goto L18;
        return false;
    L18:
        if (this.f363419d == r101.f363419d) goto L21;
        return false;
    L21:
        if (this.f363420e == r101.f363420e) goto L24;
        return false;
    L24:
        if (this.f363421f == r101.f363421f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f363416a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f363417b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f363418c;
        if (r106 == null) goto L14;
        r103 = r106.hashCode();
    L14:
        long r107 = this.f363419d;
        return ((((((r105 + r103) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f363420e) * 31) + this.f363421f;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallbackImageInfo(result=" + this.f363416a + ", localPath=" + this.f363417b + ", fileName=" + this.f363418c + ", fileSize=" + this.f363419d + ", width=" + this.f363420e + ", height=" + this.f363421f + ')';
    }

    public /* synthetic */ a(String r100, String r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 4) == 0) goto L8;
        String r101 = null;
    L9:
        this(false, r100, r101, 0, 0, 0);
        return;
    L8:
        r101 = r110;
        goto L9
    }

    public a(boolean r100, String r101, String r102, long r103, int r104, int r105) {
        this.f363416a = r100;
        this.f363417b = r101;
        this.f363418c = r102;
        this.f363419d = r103;
        this.f363420e = r104;
        this.f363421f = r105;
    }
}
