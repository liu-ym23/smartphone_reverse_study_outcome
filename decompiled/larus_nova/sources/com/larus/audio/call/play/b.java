package com.larus.audio.call.play;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f289295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f289296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f289297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f289298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f289299e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f289295a == r101.f289295a) goto L12;
        return false;
    L12:
        if (this.f289296b == r101.f289296b) goto L15;
        return false;
    L15:
        if (this.f289297c == r101.f289297c) goto L18;
        return false;
    L18:
        if (this.f289298d == r101.f289298d) goto L21;
        return false;
    L21:
        if (this.f289299e == r101.f289299e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f289295a * 31) + this.f289296b) * 31) + this.f289297c) * 31) + this.f289298d) * 31) + this.f289299e;
    }

    public final String toString() {
        return "AudioPlayConfig(streamType=" + this.f289295a + ", bufferSize=" + this.f289296b + ", sampleRate=" + this.f289297c + ", channelConfig=" + this.f289298d + ", audioFormat=" + this.f289299e + ')';
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f289295a = r100;
        this.f289296b = r101;
        this.f289297c = r102;
        this.f289298d = r103;
        this.f289299e = 2;
    }
}
