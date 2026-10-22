package com.lynx.tasm.behavior;

/* JADX INFO: loaded from: classes32.dex */
public class LayoutNodeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f381879a;

    private native void nativeAlignNativeNode(long r100, int r101, float r102, float r103);

    private native int nativeGetFlexDirection(long r100, int r101);

    private native float nativeGetHeight(long r100, int r101);

    private native int[] nativeGetMargin(long r100, int r101);

    private native float nativeGetMaxHeight(long r100, int r101);

    private native float nativeGetMaxWidth(long r100, int r101);

    private native float nativeGetMinHeight(long r100, int r101);

    private native float nativeGetMinWidth(long r100, int r101);

    private native int[] nativeGetPadding(long r100, int r101);

    private native float nativeGetWidth(long r100, int r101);

    private native boolean nativeIsDirty(long r100, int r101);

    private native void nativeMarkDirty(long r100, int r101);

    private native long nativeMeasureNativeNode(long r100, int r101, float r102, int r103, float r104, int r105, boolean r106);

    private native int[] nativeMeasureNativeNodeReturnWithBaseline(long r100, int r101, float r102, int r103, float r104, int r105, boolean r106);

    private native void nativeSetMeasureFunc(long r100, int r101, Object r102);

    private native void nativeSetNeedsLayoutForce(long r100, int r101);

    public LayoutNodeManager() {
        this.f381879a = 0;
    }

    public float b(int r100) {
        return nativeGetHeight(this.f381879a, r100);
    }

    public int[] c(int r100) {
        return nativeGetMargin(this.f381879a, r100);
    }

    public float d(int r100) {
        return nativeGetWidth(this.f381879a, r100);
    }

    public boolean e(int r100) {
        return nativeIsDirty(this.f381879a, r100);
    }

    public void f(int r100) {
        nativeMarkDirty(this.f381879a, r100);
    }

    public final void j(int r100) {
        nativeSetNeedsLayoutForce(this.f381879a, r100);
    }

    public void i(int r100, Object r101) {
        nativeSetMeasureFunc(this.f381879a, r100, r101);
    }

    public void a(int r100, float r101, float r102) {
        nativeAlignNativeNode(this.f381879a, r100, r101, r102);
    }

    public long g(int r110, float r111, int r112, float r113, int r114, boolean r115) {
        return nativeMeasureNativeNode(this.f381879a, r110, r111, r112, r113, r114, r115);
    }

    public int[] h(int r110, float r111, int r112, float r113, int r114, boolean r115) {
        return nativeMeasureNativeNodeReturnWithBaseline(this.f381879a, r110, r111, r112, r113, r114, r115);
    }
}
