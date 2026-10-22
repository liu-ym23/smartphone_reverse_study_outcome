package com.lynx.clay.relax.adaptor;

import com.lynx.clay.embedding.android.d;

/* JADX INFO: loaded from: classes32.dex */
public class RelaxAdaptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f380951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f380952b;

    private native long createNativeRelaxAdaptor();

    private native void nativeBindRelaxEngine(long r100, long r101, long r102);

    private native void nativeDestroy(long r100);

    public final void b() {
        long r100 = this.f380952b;
        if (r100 == 0) goto L6;
        nativeDestroy(r100);
        this.f380952b = 0;
        return;
    }

    public final void finalize() throws Throwable {
        b();
        super.finalize();
    }

    public RelaxAdaptor(d r100) {
        this.f380952b = 0;
        this.f380951a = r100;
    }

    public final void a(long r110) {
        if (this.f380952b != 0) goto L5;
        this.f380952b = createNativeRelaxAdaptor();
    L5:
        d r100 = this.f380951a;
        if (r100 == null) goto L8;
        long r101 = r100.f380643b.f380694a.getNativeClayViewContext();
    L10:
        if (r101 == 0) goto L13;
        nativeBindRelaxEngine(this.f380952b, r110, r101);
        return;
    L13:
        return;
    L8:
        r101 = 0;
        goto L10
    }
}
