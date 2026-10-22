package com.relax.relaxui;

import com.lynx.tasm.behavior.LayoutNodeManager;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxLayoutNodeManager extends LayoutNodeManager {
    private native void nativeAlignNativeNode(long r100, int r101, float r102, float r103);

    private native int nativeGetFlexDirection(long r100, int r101);

    private native float nativeGetHeight(long r100, int r101);

    private native int[] nativeGetMargin(long r100, int r101);

    private native int[] nativeGetPadding(long r100, int r101);

    private native float nativeGetWidth(long r100, int r101);

    private native boolean nativeIsDirty(long r100, int r101);

    private native void nativeMarkDirty(long r100, int r101);

    private native long nativeMeasureNativeNode(long r100, int r101, float r102, int r103, float r104, int r105, boolean r106);

    private native int[] nativeMeasureNativeNodeReturnWithBaseline(long r100, int r101, float r102, int r103, float r104, int r105, boolean r106);

    private native void nativeSetMeasureFunc(long r100, int r101, Object r102);

    public void align(int r100) {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final float b(int r100) {
        return nativeGetHeight(this.f381879a, r100);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final int[] c(int r100) {
        return nativeGetMargin(this.f381879a, r100);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final float d(int r100) {
        return nativeGetWidth(this.f381879a, r100);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final boolean e(int r100) {
        return nativeIsDirty(this.f381879a, r100);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final void f(int r100) {
        nativeMarkDirty(this.f381879a, r100);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final void i(int r100, Object r101) {
        nativeSetMeasureFunc(this.f381879a, r100, this);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final void a(int r100, float r101, float r102) {
        nativeAlignNativeNode(this.f381879a, r100, r101, r102);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final long g(int r110, float r111, int r112, float r113, int r114, boolean r115) {
        return nativeMeasureNativeNode(this.f381879a, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.lynx.tasm.behavior.LayoutNodeManager
    public final int[] h(int r110, float r111, int r112, float r113, int r114, boolean r115) {
        return nativeMeasureNativeNodeReturnWithBaseline(this.f381879a, r110, r111, r112, r113, r114, r115);
    }

    public float[] measure(int r100, float r101, int r102, float r103, int r104, boolean r105) {
        throw null;
    }
}
