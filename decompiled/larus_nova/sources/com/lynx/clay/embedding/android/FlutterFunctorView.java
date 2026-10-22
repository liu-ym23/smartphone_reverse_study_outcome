package com.lynx.clay.embedding.android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterFunctorView extends FunctorView implements s5a.c {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FlutterRenderer f380488v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f380489w;

    @Override // s5a.c
    public final void pause() {
    }

    @Override // s5a.c
    public final void b() {
        if (this.f380489w == true) goto L5;
        return;
    L5:
        invalidate();
        this.f380488v = null;
        this.f380489w = false;
    }

    @Override // com.lynx.clay.embedding.android.FunctorView
    public final void g() {
        FlutterRenderer r100 = this.f380488v;
        if (r100 == null) goto L5;
        r100.f380933a.destroyGLFunctor();
        this.f380488v.getFlutterJNI().setFlutterFunctorView(null);
    L5:
        super.g();
    }

    @Override // com.lynx.clay.embedding.android.FunctorView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FlutterRenderer r100 = this.f380488v;
        int r101 = getWidth();
        int r102 = getHeight();
        r100.f380933a.onSurfaceChanged(r101, r102);
    }

    @Override // s5a.c
    public FlutterRenderer getAttachedRenderer() {
        return this.f380488v;
    }

    public long getFunctorPtr() {
        return this.f380558d;
    }

    public FlutterFunctorView(Context r100) {
        this(r100, null);
    }

    @Override // s5a.c
    public final void a(FlutterRenderer r100) {
        this.f380488v = r100;
        this.f380489w = true;
        r100.getFlutterJNI().setFlutterFunctorView(this);
    }

    @Override // com.lynx.clay.embedding.android.FunctorView
    public final void notifyFunctorPresent(long r100) {
        FlutterRenderer r101 = this.f380488v;
        if (r101 == null) goto L6;
        r101.f380933a.notifyFunctorPresent(r100);
        return;
    }

    @Override // com.lynx.clay.embedding.android.FunctorView, android.view.View
    public final void onDraw(Canvas r110) {
        h();
        if (this.f380560f != (-1)) goto L8;
        FlutterRenderer r100 = this.f380488v;
        if (r100 == null) goto L8;
        long r101 = r100.f380933a.getSharedImageSink();
        this.f380560f = r101;
        nativeSetSharedImageSink(this.f380558d, r101);
    L8:
        if (this.f380489w == true) goto L10;
        return;
    L10:
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = getWidth();
        int r105 = getHeight();
        FlutterRenderer r106 = this.f380488v;
        boolean r107 = r110.isHardwareAccelerated();
        boolean r108 = this.f380561g;
        boolean r109 = r106.f380933a.onDraw(r110, r107, r108, r102, r103, r104, r105);
        if (this.f380561g == false) goto L13;
        this.f380561g = false;
    L13:
        if (r109 == true) goto L15;
    L17:
        if (r109 == true) goto L20;
        return;
    L20:
        if (this.f380564j == false) goto L23;
        getRootView().invalidate();
        this.f380564j = false;
        return;
    L23:
        return;
    L15:
        if (r110.isHardwareAccelerated() == false) goto L17;
        r109 = j(r110);
        goto L17
    }

    public FlutterFunctorView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FlutterFunctorView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, true);
        this.f380489w = false;
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f380489w == false) goto L8;
        FlutterRenderer r104 = this.f380488v;
        if (r104 == null) goto L9;
        r104.f380933a.onSurfaceChanged(r100, r101);
        return;
    L9:
        return;
    }
}
