package com.larksuite.component.ui.layout.plus;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.larksuite.component.ui.layout.ILKUILayout;
import com.larksuite.component.ui.layout.c;
import com.larksuite.component.ui.layout.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a {
    private final /* synthetic */ com.larksuite.component.ui.layout.a $$delegate_0;
    private final ILKUILayout mLayout;

    public void onDelegateAttachedToWindow() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateComputeScroll() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateDetachedFromWindow() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateFinishInflate() {
        this.$$delegate_0.getClass();
    }

    public void onDelegateFocusChanged(boolean r100, int r101, Rect r102) {
        this.$$delegate_0.getClass();
    }

    public void onDelegateSizeChanged(int r100, int r101, int r102, int r103) {
        this.$$delegate_0.getClass();
    }

    public final AttributeSet getAttrs() {
        return this.mLayout.getAttrs();
    }

    public final Context getContext() {
        return this.mLayout.getLKUIContext();
    }

    public final ViewGroup getLayout() {
        return this.mLayout.getLayout();
    }

    public a(ILKUILayout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        this.$$delegate_0 = new com.larksuite.component.ui.layout.a();
        this.mLayout = r100;
    }

    public void onDelegateConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public void onDelegateDispatchDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public void onDelegateDispatchDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public Boolean onDelegateDispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "ev");
        return null;
    }

    public Boolean onDelegateDragEvent(DragEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        return null;
    }

    public void onDelegateDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public void onDelegateDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public Boolean onDelegateInterceptHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        return null;
    }

    public Boolean onDelegateInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "ev");
        return null;
    }

    public void onDelegateLayoutEnd(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
    }

    public void onDelegateLayoutStart(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
    }

    public void onDelegateMeasureEnd(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
    }

    public void onDelegateMeasureStart(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
    }

    public void onDelegateSetPaddingEnd(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "paddingData");
    }

    public void onDelegateSetPaddingStart(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "paddingData");
    }

    public Boolean onDelegateTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.$$delegate_0.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        return null;
    }
}
