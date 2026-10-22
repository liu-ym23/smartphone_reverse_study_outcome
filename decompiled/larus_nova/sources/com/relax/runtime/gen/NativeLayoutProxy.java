package com.relax.runtime.gen;

import java.util.ArrayList;
import spa.a;

/* JADX INFO: loaded from: classes34.dex */
public class NativeLayoutProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405694a;

    private native long nativeCreate(long r100);

    private native void nativeCreateColumn(long r100, int r101);

    private native void nativeCreateFlex(long r100, int r101);

    private native void nativeCreateGrid(long r100, int r101);

    private native void nativeCreateLayoutNode(long r100, int r101, String r102);

    private native void nativeCreateLinear(long r100, int r101);

    private native void nativeCreateRoot(long r100, int r101);

    private native void nativeCreateRow(long r100, int r101);

    private native void nativeCreateStack(long r100, int r101);

    private native void nativeDestroy(long r100);

    private native void nativeDestroyAllNodes(long r100);

    private native void nativeDestroyLayoutNode(long r100, int r101);

    private native int[] nativeGetCurrentDirtyIdsWithCustomMeasure(long r100);

    private native long nativeGetLayoutContext(long r100);

    private native long nativeGetNativeLayoutProxy(long r100);

    private native void nativeInsertNodeBefore(long r100, int r101, int r102, int r103);

    private native void nativeMarkLayoutNodeDirty(long r100, int r101);

    private native void nativeRemoveLayoutNode(long r100, int r101, int r102);

    private native void nativeSetMeasureFunc(long r100, int r101, MeasureCallback r102);

    private native double[] nativeStartLayout(long r100, int[] r101);

    private native boolean nativeSyncRootConstraint(long r100, double r101, int r102, double r103, int r104);

    private native void nativeUpdateLayoutArrayStyle(long r100, int r101, int r102, double[] r103, int[] r104);

    private native void nativeUpdateLayoutStyle(long r100, int r101, int[] r102, double[] r103, int[] r104);

    private native void nativeUpdateSingleLayoutStyle(long r100, int r101, int r102, double r103, int r104);

    public final void i() {
        nativeDestroy(this.f405694a);
    }

    public final ArrayList<Integer> k() {
        int[] r100 = nativeGetCurrentDirtyIdsWithCustomMeasure(this.f405694a);
        ArrayList<Integer> r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(Integer.valueOf(r100[r103]));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public final long l() {
        return nativeGetLayoutContext(this.f405694a);
    }

    public NativeLayoutProxy() {
        this.f405694a = 0;
    }

    public NativeLayoutProxy(long r100) {
        this.f405694a = 0;
        this.f405694a = nativeCreate(r100);
    }

    public final void a(int r100) {
        nativeCreateColumn(this.f405694a, r100);
    }

    public final void b(int r100) {
        nativeCreateFlex(this.f405694a, r100);
    }

    public final void c(int r100) {
        nativeCreateGrid(this.f405694a, r100);
    }

    public final void e(int r100) {
        nativeCreateLinear(this.f405694a, r100);
    }

    public final void f(int r100) {
        nativeCreateRoot(this.f405694a, r100);
    }

    public final void g(int r100) {
        nativeCreateRow(this.f405694a, r100);
    }

    public final void h(int r100) {
        nativeCreateStack(this.f405694a, r100);
    }

    public final void j(int r100) {
        nativeDestroyLayoutNode(this.f405694a, r100);
    }

    public final void n(int r100) {
        nativeMarkLayoutNodeDirty(this.f405694a, r100);
    }

    public final ArrayList<Double> p(ArrayList<Integer> r100) {
        double[] r101 = nativeStartLayout(this.f405694a, a.b(r100));
        ArrayList<Double> r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.add(Double.valueOf(r101[r104]));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public final void d(int r100, String r101) {
        nativeCreateLayoutNode(this.f405694a, r100, r101);
    }

    public final void o(int r100, int r101) {
        nativeRemoveLayoutNode(this.f405694a, r100, r101);
    }

    public final void m(int r100, int r101, int r102) {
        nativeInsertNodeBefore(this.f405694a, r100, r101, r102);
    }

    public final boolean q(double r110, int r111, double r112, int r113) {
        return nativeSyncRootConstraint(this.f405694a, r110, r111, r112, r113);
    }

    public final void r(int r100, int r101, ArrayList<Double> r110, ArrayList<Integer> r111) {
        nativeUpdateLayoutArrayStyle(this.f405694a, r100, r101, a.a(r110), a.b(r111));
    }

    public final void s(int r100, ArrayList<Integer> r101, ArrayList<Double> r110, ArrayList<Integer> r111) {
        nativeUpdateLayoutStyle(this.f405694a, r100, a.b(r101), a.a(r110), a.b(r111));
    }

    public final void t(int r100, int r110, double r111, int r112) {
        nativeUpdateSingleLayoutStyle(this.f405694a, r100, r110, r111, r112);
    }
}
