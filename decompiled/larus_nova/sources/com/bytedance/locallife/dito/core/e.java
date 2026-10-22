package com.bytedance.locallife.dito.core;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f257905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f257906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f257907c;

    public e() {
        this(true, true, true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f257905a == r101.f257905a) goto L12;
        return false;
    L12:
        if (this.f257906b == r101.f257906b) goto L15;
        return false;
    L15:
        if (this.f257907c == r101.f257907c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f257905a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f257906b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f257907c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DemoteConfig(ditoDecorationEnable=" + this.f257905a + ", fixGroupMarginError=" + this.f257906b + ", fixUpdateDataIllegalState=" + this.f257907c + ')';
    }

    public e(boolean r100, boolean r101, boolean r102) {
        this.f257905a = r100;
        this.f257906b = r101;
        this.f257907c = r102;
    }
}
