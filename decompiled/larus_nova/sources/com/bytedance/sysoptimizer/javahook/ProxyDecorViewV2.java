package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.internal.policy.DecorView;
import com.bytedance.sysoptimizer.proxyinstance.ProxyInstance;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyDecorViewV2 extends DecorView {
    private static final String TAG = "ProxyDecorViewV2";
    private static boolean sLog;

    public void finalize() throws Throwable {
        super.finalize();
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "finalize() called");
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().e(TAG, "onAttachedToWindow() called", new Throwable());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onDetachedFromWindow() called");
        return;
    }

    public ProxyDecorViewV2(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onDraw() called with: canvas = [" + r100 + "]");
        return;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r100) {
        super.onViewAdded(r100);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onViewAdded() called with: child = [" + r100 + "]");
        return;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onViewRemoved() called with: child = [" + r100 + "]");
        return;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onWindowVisibilityChanged() called with: visibility = [" + r100 + "]");
        return;
    }

    public ProxyDecorViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onMeasure() called with: widthMeasureSpec = [" + r100 + "], heightMeasureSpec = [" + r101 + "]");
        return;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onVisibilityChanged() called with: changedView = [" + r100 + "], visibility = [" + r101 + "]");
        return;
    }

    public ProxyDecorViewV2(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public ProxyDecorViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (sLog == false) goto L6;
        ProxyInstance.getCallback().d(TAG, "onLayout() called with: changed = [" + r100 + "], left = [" + r101 + "], top = [" + r102 + "], right = [" + r103 + "], bottom = [" + r104 + "]");
        return;
    }
}
