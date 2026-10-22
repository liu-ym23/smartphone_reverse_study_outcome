package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

/* JADX INFO: loaded from: classes37.dex */
public final class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f434365c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f434366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f434367b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f434366a == r101.f434366a) goto L12;
        return false;
    L12:
        if (this.f434367b == r101.f434367b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f434366a * 31) + this.f434367b;
    }

    public final String toString() {
        return "MmRecordingAudioFormat(sampleRateHz=" + this.f434366a + ", channelCount=" + this.f434367b + ')';
    }

    public f(int r100, int r101) {
        this.f434366a = r100;
        this.f434367b = r101;
    }
}
