package hl2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f485668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f485669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f485670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f485671d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f485668a, r101.f485668a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f485669b, r101.f485669b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f485670c, r101.f485670c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f485671d, r101.f485671d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f485668a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f485669b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f485670c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f485671d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "ECLiveLayoutPadding(top=" + this.f485668a + ", bottom=" + this.f485669b + ", left=" + this.f485670c + ", right=" + this.f485671d + ")";
    }

    public b(Integer r100, Integer r101, Integer r102, Integer r103) {
        this.f485668a = r100;
        this.f485669b = r101;
        this.f485670c = r102;
        this.f485671d = r103;
    }
}
