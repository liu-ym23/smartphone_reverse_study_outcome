package com.obric.assistant.component.clicktalk;

/* JADX INFO: loaded from: classes33.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f388533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f388534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f388535c;

    public i0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (this.f388533a == r101.f388533a) goto L12;
        return false;
    L12:
        if (this.f388534b == r101.f388534b) goto L15;
        return false;
    L15:
        if (this.f388535c == r101.f388535c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f388533a == false) goto L5;
        int r101 = 1231;
    L6:
        long r102 = this.f388534b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        if (this.f388535c == true) goto L11;
        r100 = 1237;
    L11:
        return r103 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ClickTalkConfig(enableSilenceTimeout=" + this.f388533a + ", silenceTimeout=" + this.f388534b + ", staticBlur=" + this.f388535c + ')';
    }

    public i0(int r100) {
        this.f388533a = false;
        this.f388534b = 10000;
        this.f388535c = false;
    }
}
