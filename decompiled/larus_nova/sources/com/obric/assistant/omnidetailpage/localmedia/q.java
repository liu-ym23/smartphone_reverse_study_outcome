package com.obric.assistant.omnidetailpage.localmedia;

/* JADX INFO: loaded from: classes33.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f390841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f390842b;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f390841a == r101.f390841a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f390842b, r101.f390842b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f390841a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + Float.floatToIntBits(this.f390842b);
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "TaskLocalAudioPlaybackState(isPlaying=" + this.f390841a + ", progress=" + this.f390842b + ')';
    }

    public /* synthetic */ q(int r100) {
        this(false, 0.0f);
    }

    public q(boolean r100, float r101) {
        this.f390841a = r100;
        this.f390842b = r101;
    }
}
