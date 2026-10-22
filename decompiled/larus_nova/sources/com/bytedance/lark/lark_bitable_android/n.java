package com.bytedance.lark.lark_bitable_android;

/* JADX INFO: loaded from: classes43.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f253090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253091b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f253090a == r101.f253090a) goto L12;
        return false;
    L12:
        if (this.f253091b == r101.f253091b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f253090a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f253091b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BitableTenantTypeInfo(soloUser=" + this.f253090a + ", soloBase=" + this.f253091b + ')';
    }

    public n(boolean r100, boolean r101) {
        this.f253090a = r100;
        this.f253091b = r101;
    }
}
