package com.relax.relaxui;

import android.graphics.Canvas;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.UIBody;
import com.relax.runtime.gen.NativeListProxy;
import java.util.HashSet;
import ppa.d;

/* JADX INFO: loaded from: classes34.dex */
public class RelaxUIBody extends UIBody.UIBodyView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f405602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f405603b;

    private native void nativeBindRelaxEngine(long r100, long r101, long r102, long r103);

    private native long nativeCreateRelaxUIBody(Object r100);

    private native void nativeDestroyRelaxUIBody(long r100);

    private native void nativeListScrollByListContainer(long r100, int r101, float r102, float r103, float r104, float r105);

    private native void nativeListScrollStopped(long r100, int r101);

    private native void nativeListScrollToPosition(long r100, int r101, int r102, float r103, int r104, boolean r105);

    private native void nativeOnFirstDrawEnd(long r100);

    public LayoutProxy getLayoutProxy() {
        return null;
    }

    public d getRenderRelaxUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public UIProxy getUIProxy() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        x6a.d.k(this, r100);
    }

    public void setNativeListProxy(NativeListProxy r100) {
    }

    public void setRenderRelaxUI(d r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        x6a.d.l(this, r100);
    }

    public final void finalize() throws Throwable {
        new HashSet();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.UIBody.UIBodyView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        super.dispatchDraw(r100);
        if (this.f405603b == getMeaningfulPaintTiming()) goto L6;
        this.f405603b = getMeaningfulPaintTiming();
        nativeOnFirstDrawEnd(0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        LLog.i("RelaxUIBody", "LynxView dispatchTouchEvent, this: " + hashCode());     // Catch: Throwable -> L12
        int r101 = r100.getAction();     // Catch: Throwable -> L12
        if (r101 != 0) goto L6;
        this.f405602a = true;     // Catch: Throwable -> L12
    L6:
        boolean r102 = this.f405602a;     // Catch: Throwable -> L12
        if (r101 != 1) goto L9;
    L10:
        this.f405602a = false;     // Catch: Throwable -> L12
        goto L11
    L9:
        if (r101 == 3) goto L10;
    L11:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        LLog.i("RelaxUIBody", "relaxuibody onInterceptTouchEvent, this: " + hashCode());     // Catch: Throwable -> L5
        return super.onInterceptTouchEvent(r100);
    L5:
        return false;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        LLog.i("Lynx", "LynxView onTouchEvent, this: " + hashCode());     // Catch: Throwable -> L6
        return true;
    L6:
        return false;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r100) {
        if (r100 != null) goto L4;
        boolean r101 = true;
    L5:
        setFocusableInTouchMode(r101);
        super.setOnClickListener(r100);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void setRtsPipelineEnabled(boolean r100) {
        if (r100 == false) goto L5;
        throw null;
    L5:
        throw null;
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        LLog.i("Lynx", "setVisibility:" + hashCode() + " " + r100);
    }
}
