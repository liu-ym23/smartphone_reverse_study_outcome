package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class AnimationFrame {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405689a;

    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativecancelAnimationFrame(long r100, long r101);

    private native long nativerequestAnimationFrame(long r100, RAFCallback r101);

    private native long nativerequestFrameCommitCallback(long r100, RFCCallback r101);

    public AnimationFrame() {
        this.f405689a = 0;
    }

    public AnimationFrame(long r100) {
        this.f405689a = 0;
        this.f405689a = nativeCreate(r100);
    }

    public final void a(long r100) {
        nativecancelAnimationFrame(this.f405689a, r100);
    }

    public final long b(RFCCallback r100) {
        return nativerequestFrameCommitCallback(this.f405689a, r100);
    }
}
