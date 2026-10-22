package xb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f563101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f563102c;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f563100a, r101.f563100a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f563101b, r101.f563101b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f563102c, r101.f563102c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f563100a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f563101b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f563102c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExtraRequestData(requestFromPage=" + this.f563100a + ", subTab=" + this.f563101b + ", searchSource=" + this.f563102c + ")";
    }

    public a(String r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = null;
    L5:
        this.f563100a = null;
        this.f563101b = null;
        this.f563102c = r100;
    }
}
