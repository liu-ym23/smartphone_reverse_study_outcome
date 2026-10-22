package com.larus.login.api;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f357008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f357009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f357010c;

    public d() {
        this(false, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f357008a == r101.f357008a) goto L12;
        return false;
    L12:
        if (this.f357009b == r101.f357009b) goto L15;
        return false;
    L15:
        if (this.f357010c == r101.f357010c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f357008a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f357009b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f357010c == true) goto L15;
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
        return "BindResultToastConfig(showSuccessToast=" + this.f357008a + ", showFailToast=" + this.f357009b + ", showCancelToast=" + this.f357010c + ')';
    }

    public /* synthetic */ d(boolean r100, int r101) {
        boolean r102 = true;
        if ((r101 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r101 & 2) == 0) goto L8;
        boolean r103 = true;
    L10:
        if ((r101 & 4) != 0) goto L13;
        r102 = false;
    L13:
        this(r100, r103, r102);
        return;
    L8:
        r103 = false;
        goto L10
    }

    public d(boolean r100, boolean r101, boolean r102) {
        this.f357008a = r100;
        this.f357009b = r101;
        this.f357010c = r102;
    }
}
