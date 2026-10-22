package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

/* JADX INFO: loaded from: classes37.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f434407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434408b;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f434407a == r101.f434407a) goto L12;
        return false;
    L12:
        if (this.f434408b == r101.f434408b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434407a * 31) + this.f434408b;
    }

    public final String toString() {
        return "MmVolumeBean(interval=" + this.f434407a + ", level=" + this.f434408b + ')';
    }

    public h(int r100) {
        this.f434407a = 400;
        this.f434408b = -20;
    }
}
