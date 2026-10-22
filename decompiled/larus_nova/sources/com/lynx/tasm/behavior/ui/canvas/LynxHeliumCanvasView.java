package com.lynx.tasm.behavior.ui.canvas;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class LynxHeliumCanvasView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<LynxHeliumCanvas> f382486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f382487b;

    public LynxHeliumCanvas getCanvasUI() {
        WeakReference<LynxHeliumCanvas> r100 = this.f382486a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public LynxHeliumCanvasView(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (getParent() == null) goto L5;
        getParent().requestDisallowInterceptTouchEvent(this.f382487b);
    L7:
        return super.dispatchTouchEvent(r100);
    L5:
        LLog.e("LynxHeliumCanvasView", "requestDisallowInterceptTouchEvent failed, parent is null.");
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        if (r100 == null) goto L4;
        LLog.w("LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setBackgroundDrawable(null);
    }

    public void setCanvasUI(LynxHeliumCanvas r100) {
        this.f382486a = new WeakReference(r100);
    }

    public void setConsumeAllEvents(boolean r100) {
        this.f382487b = r100;
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r100) {
        if (r100 == null) goto L4;
        LLog.w("LynxHeliumCanvasView", "TextureView doesn't support displaying a foreground drawable");
    L4:
        super.setForeground(null);
    }

    public LynxHeliumCanvasView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public LynxHeliumCanvasView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
