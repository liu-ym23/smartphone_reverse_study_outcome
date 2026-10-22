package com.lynx.tasm.behavior.ui.list.container;

/* JADX INFO: loaded from: classes32.dex */
public class ListContainerProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f382730a;

    public ListContainerProxy() {
    }

    private native long nativeCreate(long r100);

    private native void nativeDestroy(long r100);

    private native void nativeScrollByListContainer(long r100, int r101, float r102, float r103, float r104, float r105);

    private native void nativeScrollStopped(long r100, int r101);

    private native void nativeScrollToPosition(long r100, int r101, int r102, float r103, int r104, boolean r105);

    public final void a() {
        long r100 = this.f382730a;
        if (r100 == 0) goto L6;
        nativeDestroy(r100);
        this.f382730a = 0;
        return;
    }

    public ListContainerProxy(long r100) {
        this.f382730a = nativeCreate(r100);
    }

    public final void c(int r100) {
        long r101 = this.f382730a;
        if (r101 == 0) goto L6;
        nativeScrollStopped(r101, r100);
        return;
    }

    public final void b(int r100, float r110, float r111, float r112, float r113) {
        long r101 = this.f382730a;
        if (r101 == 0) goto L6;
        nativeScrollByListContainer(r101, r100, r110, r111, r112, r113);
        return;
    }

    public final void d(int r100, int r110, float r111, int r112, boolean r113) {
        long r101 = this.f382730a;
        if (r101 == 0) goto L6;
        nativeScrollToPosition(r101, r100, r110, r111, r112, r113);
        return;
    }
}
