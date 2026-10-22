package com.lynx.tasm.behavior;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.ui.PropBundle;

/* JADX INFO: loaded from: classes32.dex */
public abstract class LayoutContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f381876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f381877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f381878c;

    private native long nativeCreateLayoutContext(Object r100);

    private native void nativeTriggerLayout(long r100);

    public abstract void attachLayoutNodeManager(long r100);

    public void b() {
        this.f381877b = true;
    }

    public abstract int createNode(int r100, String r101, PropBundle r102, ReadableMapBuffer r103, boolean r104);

    public abstract void destroyNodes(int[] r100);

    public abstract void dispatchOnLayout(int r100, int r101, int r102, int r103, int r104);

    public abstract void dispatchOnLayoutBefore(int r100);

    public abstract Object getExtraBundle(int r100);

    public abstract void insertNode(int r100, int r101, int r102);

    public abstract void removeNode(int r100, int r101, int r102);

    public abstract void scheduleLayout();

    public abstract void setFontFaces(ReadableMap r100);

    public abstract void updateProps(int r100, PropBundle r101, ReadableMapBuffer r102);

    public void c() {
        long r100 = this.f381876a;
        if (r100 == 0) goto L6;
        nativeTriggerLayout(r100);
        return;
    }

    public void detachNativePtr() {
        this.f381876a = 0;
    }

    public LayoutContext() {
        this.f381876a = 0;
        this.f381878c = 0;
    }

    public void a(v0 r100) {
        this.f381878c = nativeCreateLayoutContext(r100);
    }

    public void attachNativePtr(long r100) {
        this.f381876a = r100;
    }
}
