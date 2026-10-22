package com.larus.im.internal.audio.session.omni;

/* JADX INFO: loaded from: classes29.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f347326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f347327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f347328c;

    public m0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (this.f347326a == r101.f347326a) goto L12;
        return false;
    L12:
        if (this.f347327b == r101.f347327b) goto L15;
        return false;
    L15:
        if (this.f347328c == r101.f347328c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f347326a * 31) + this.f347327b) * 31) + this.f347328c;
    }

    public final String toString() {
        return "OmniRefSignalConfig(bufferMs=" + this.f347326a + ", trimKeepMs=" + this.f347327b + ", maxAgeMs=" + this.f347328c + ')';
    }

    public /* synthetic */ m0(int r100) {
        this(400, 200, 200);
    }

    public m0(int r100, int r101, int r102) {
        this.f347326a = r100;
        this.f347327b = r101;
        this.f347328c = r102;
    }
}
