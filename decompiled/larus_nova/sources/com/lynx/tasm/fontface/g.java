package com.lynx.tasm.fontface;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f383433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f383434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f383435c;

    public final int hashCode() {
        int r100 = ((this.f383433a.hashCode() * 31) + Float.floatToIntBits(this.f383434b)) * 31;
        String r101 = this.f383435c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (TextUtils.equals(this.f383435c, r101.f383435c) == true) goto L11;
    L15:
        return false;
    L11:
        if (Float.compare(this.f383434b, r101.f383434b) != 0) goto L15;
        if (TextUtils.equals(this.f383433a, r101.f383433a) == false) goto L15;
        return true;
    }

    public g(String r100, float r101, String r102) {
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        this.f383433a = r100;
        this.f383434b = r101;
        this.f383435c = r102;
    }
}
