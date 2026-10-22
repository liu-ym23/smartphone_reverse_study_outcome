package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f435129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f435130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f435131c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f435129a == r101.f435129a) goto L12;
        return false;
    L12:
        if (this.f435130b == r101.f435130b) goto L15;
        return false;
    L15:
        if (this.f435131c == r101.f435131c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f435129a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f435130b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f435131c == true) goto L15;
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
        return "MmStandaloneAIInterpretationPlaybackMuteResult(actualMuted=" + this.f435129a + ", appliedToRtc=" + this.f435130b + ", changeToOrigin=" + this.f435131c + ')';
    }

    public d(boolean r100, boolean r101, boolean r102) {
        this.f435129a = r100;
        this.f435130b = r101;
        this.f435131c = r102;
    }
}
