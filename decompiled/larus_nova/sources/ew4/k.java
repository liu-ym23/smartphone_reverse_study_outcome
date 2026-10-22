package ew4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f474566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f474567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f474568c;

    public k() {
        boolean r100 = false;
        String r101 = null;
        this(r101, r100, r100, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f474566a, r101.f474566a) == true) goto L12;
        return false;
    L12:
        if (this.f474567b == r101.f474567b) goto L15;
        return false;
    L15:
        if (this.f474568c == r101.f474568c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f474566a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.f474567b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f474568c == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommonCameraRequest(srcObjToken=" + this.f474566a + ", enableTakePhoto=" + this.f474567b + ", enableTakeVideo=" + this.f474568c + ')';
    }

    public k(String r100, boolean r101, boolean r102) {
        this.f474566a = r100;
        this.f474567b = r101;
        this.f474568c = r102;
    }

    public /* synthetic */ k(String r100, boolean r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = true;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
