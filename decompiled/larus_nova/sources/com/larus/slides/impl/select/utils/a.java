package com.larus.slides.impl.select.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f369668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f369669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f369670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f369671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f369672e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f369673f;

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
        if (this.f369668a == r101.f369668a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f369669b, r101.f369669b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f369670c, r101.f369670c) == true) goto L18;
        return false;
    L18:
        if (this.f369671d == r101.f369671d) goto L21;
        return false;
    L21:
        if (this.f369672e == r101.f369672e) goto L24;
        return false;
    L24:
        if (this.f369673f == r101.f369673f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f369668a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f369669b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f369670c;
        if (r106 == null) goto L14;
        r103 = r106.hashCode();
    L14:
        long r107 = this.f369671d;
        return ((((((r105 + r103) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f369672e) * 31) + this.f369673f;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "CallbackImageInfo(result=" + this.f369668a + ", localPath=" + this.f369669b + ", fileName=" + this.f369670c + ", fileSize=" + this.f369671d + ", width=" + this.f369672e + ", height=" + this.f369673f + ')';
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
        this.f369668a = r100;
        this.f369669b = r101;
        this.f369670c = r102;
        this.f369671d = r103;
        this.f369672e = r104;
        this.f369673f = r105;
    }
}
