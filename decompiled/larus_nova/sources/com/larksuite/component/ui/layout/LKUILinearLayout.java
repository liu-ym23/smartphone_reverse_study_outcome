package com.larksuite.component.ui.layout;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0014J0\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010'\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0014J\b\u0010,\u001a\u00020\u0014H\u0014J\b\u0010-\u001a\u00020\u0014H\u0014J\"\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0014J(\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0014J(\u0010:\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\u0014H\u0016J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010A\u001a\u00020\u0004H\u0096\u0001J\t\u0010B\u001a\u00020CH\u0096\u0001J(\u0010D\u001a\u0004\u0018\u0001HE\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0019H\u0096\u0001J#\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\t\u0010M\u001a\u00020\u0014H\u0096\u0001J\t\u0010N\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010O\u001a\u00020\u00142\u0006\u00103\u001a\u000204H\u0096\u0001J\t\u0010P\u001a\u00020\u0014H\u0096\u0001J\u0011\u0010Q\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010R\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0018\u0010S\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0018\u0010U\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020*H\u0096\u0001¢\u0006\u0002\u0010VJ\u0011\u0010W\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\u0011\u0010X\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0096\u0001J\t\u0010Y\u001a\u00020\u0014H\u0096\u0001J#\u0010Z\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0012H\u0096\u0001J\u0018\u0010[\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0018\u0010\\\u001a\u0004\u0018\u00010\u00192\u0006\u0010#\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ\u0011\u0010]\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010^\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0001J\u0011\u0010_\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010`\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010a\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\u0011\u0010b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J)\u0010c\u001a\u00020\u00142\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\bH\u0096\u0001J\u0018\u0010d\u001a\u0004\u0018\u00010\u00192\u0006\u0010'\u001a\u00020$H\u0096\u0001¢\u0006\u0002\u0010TJ&\u0010e\u001a\u0002HE\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001¢\u0006\u0002\u0010IJ!\u0010f\u001a\u00020\u0014\"\b\b\u0000\u0010E*\u00020F2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HE0HH\u0096\u0001R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/larksuite/component/ui/layout/LKUILinearLayout;", "Landroid/widget/LinearLayout;", "Lcom/larksuite/component/ui/layout/ILKUILayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasureData", "Lcom/larksuite/component/ui/layout/OnMeasureData;", "onLayoutData", "Lcom/larksuite/component/ui/layout/OnLayoutData;", "paddingData", "Landroid/graphics/Rect;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "", "l", "t", "r", "b", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "event", "onInterceptHoverEvent", "onDragEvent", "Landroid/view/DragEvent;", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onFocusChanged", "gainFocus", "direction", "previouslyFocusedRect", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onSizeChanged", "w", "h", "oldw", "oldh", "setPadding", "left", "top", "right", "bottom", "computeScroll", "getAttrs", "getLKUIContext", "getLayout", "Landroid/view/ViewGroup;", "getPlus", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "plusClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/larksuite/component/ui/layout/plus/BaseLKUIPlus;", "hasPlus", "onConstructor", "layout", "onDelegateAttachedToWindow", "onDelegateComputeScroll", "onDelegateConfigurationChanged", "onDelegateDetachedFromWindow", "onDelegateDispatchDrawEnd", "onDelegateDispatchDrawStart", "onDelegateDispatchTouchEvent", "(Landroid/view/MotionEvent;)Ljava/lang/Boolean;", "onDelegateDragEvent", "(Landroid/view/DragEvent;)Ljava/lang/Boolean;", "onDelegateDrawEnd", "onDelegateDrawStart", "onDelegateFinishInflate", "onDelegateFocusChanged", "onDelegateInterceptHoverEvent", "onDelegateInterceptTouchEvent", "onDelegateLayoutEnd", "onDelegateLayoutStart", "onDelegateMeasureEnd", "onDelegateMeasureStart", "onDelegateSetPaddingEnd", "onDelegateSetPaddingStart", "onDelegateSizeChanged", "onDelegateTouchEvent", "registerPlus", "unRegisterPlus", "suite-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LKUILinearLayout extends LinearLayout implements ILKUILayout {
    private final /* synthetic */ LKUILayoutDispatcher $$delegate_0;
    private final c onLayoutData;
    private final d onMeasureData;
    private final Rect paddingData;

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public AttributeSet getAttrs() {
        return this.$$delegate_0.getAttrs();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Context getLKUIContext() {
        return this.$$delegate_0.getLKUIContext();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public ViewGroup getLayout() {
        return this.$$delegate_0.getLayout();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T getPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        return (T) this.$$delegate_0.getPlus(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public boolean hasPlus() {
        return this.$$delegate_0.hasPlus();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onConstructor(ViewGroup r100, Context r101, AttributeSet r102) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.$$delegate_0.onConstructor(r100, r101, r102);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateAttachedToWindow() {
        this.$$delegate_0.onDelegateAttachedToWindow();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateComputeScroll() {
        this.$$delegate_0.onDelegateComputeScroll();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        this.$$delegate_0.onDelegateConfigurationChanged(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDetachedFromWindow() {
        this.$$delegate_0.onDelegateDetachedFromWindow();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.onDelegateDispatchDrawEnd(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDispatchDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.onDelegateDispatchDrawStart(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return this.$$delegate_0.onDelegateDispatchTouchEvent(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateDragEvent(DragEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.$$delegate_0.onDelegateDragEvent(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawEnd(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.onDelegateDrawEnd(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateDrawStart(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        this.$$delegate_0.onDelegateDrawStart(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFinishInflate() {
        this.$$delegate_0.onDelegateFinishInflate();
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateFocusChanged(boolean r100, int r101, Rect r102) {
        this.$$delegate_0.onDelegateFocusChanged(r100, r101, r102);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.$$delegate_0.onDelegateInterceptHoverEvent(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return this.$$delegate_0.onDelegateInterceptTouchEvent(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutEnd(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        this.$$delegate_0.onDelegateLayoutEnd(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateLayoutStart(c r100) {
        Intrinsics.checkNotNullParameter(r100, "onLayoutData");
        this.$$delegate_0.onDelegateLayoutStart(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureEnd(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        this.$$delegate_0.onDelegateMeasureEnd(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateMeasureStart(d r100) {
        Intrinsics.checkNotNullParameter(r100, "onMeasureData");
        this.$$delegate_0.onDelegateMeasureStart(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingEnd(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        this.$$delegate_0.onDelegateSetPaddingEnd(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSetPaddingStart(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "paddingData");
        this.$$delegate_0.onDelegateSetPaddingStart(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public void onDelegateSizeChanged(int r100, int r101, int r102, int r103) {
        this.$$delegate_0.onDelegateSizeChanged(r100, r101, r102, r103);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public Boolean onDelegateTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return this.$$delegate_0.onDelegateTouchEvent(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> T registerPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        return (T) this.$$delegate_0.registerPlus(r100);
    }

    @Override // com.larksuite.component.ui.layout.ILKUILayout
    public <T extends com.larksuite.component.ui.layout.plus.a> void unRegisterPlus(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "plusClass");
        this.$$delegate_0.unRegisterPlus(r100);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (hasPlus() == true) goto L6;
        super.computeScroll();
        return;
    L6:
        super.computeScroll();
        onDelegateComputeScroll();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        if (hasPlus() == true) goto L6;
        super.onAttachedToWindow();
        return;
    L6:
        super.onAttachedToWindow();
        onDelegateAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        if (hasPlus() == true) goto L6;
        super.onDetachedFromWindow();
        return;
    L6:
        super.onDetachedFromWindow();
        onDelegateDetachedFromWindow();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        if (hasPlus() == true) goto L6;
        super.onFinishInflate();
        return;
    L6:
        super.onFinishInflate();
        onDelegateFinishInflate();
    }

    public LKUILinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (hasPlus() == true) goto L6;
        super.dispatchDraw(r100);
        return;
    L6:
        onDelegateDispatchDrawStart(r100);
        super.dispatchDraw(r100);
        onDelegateDispatchDrawEnd(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (hasPlus() == false) goto L5;
        Boolean r101 = onDelegateDispatchTouchEvent(r100);
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return super.dispatchTouchEvent(r100);
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        if (hasPlus() == true) goto L6;
        super.onConfigurationChanged(r100);
        return;
    L6:
        super.onConfigurationChanged(r100);
        onDelegateConfigurationChanged(r100);
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (hasPlus() == false) goto L5;
        Boolean r101 = onDelegateDragEvent(r100);
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return super.onDragEvent(r100);
    L5:
        return super.onDragEvent(r100);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (hasPlus() == true) goto L6;
        super.onDraw(r100);
        return;
    L6:
        onDelegateDrawStart(r100);
        super.onDraw(r100);
        onDelegateDrawEnd(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (hasPlus() == false) goto L5;
        Boolean r101 = onDelegateInterceptHoverEvent(r100);
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return super.onInterceptHoverEvent(r100);
    L5:
        return super.onInterceptHoverEvent(r100);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (hasPlus() == false) goto L5;
        Boolean r101 = onDelegateInterceptTouchEvent(r100);
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return super.onInterceptTouchEvent(r100);
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (hasPlus() == false) goto L5;
        Boolean r101 = onDelegateTouchEvent(r100);
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return super.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public LKUILinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (hasPlus() == true) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        d r102 = this.onMeasureData;
        r102.f284232a = r100;
        r102.f284233b = r101;
        onDelegateMeasureStart(r102);
        d r103 = this.onMeasureData;
        super.onMeasure(r103.f284232a, r103.f284233b);
        onDelegateMeasureEnd(this.onMeasureData);
    }

    public LKUILinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.$$delegate_0 = new LKUILayoutDispatcher();
        this.onMeasureData = new d();
        this.onLayoutData = new c();
        this.paddingData = new Rect(0, 0, 0, 0);
        onConstructor(this, r100, r101);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean r100, int r101, Rect r102) {
        if (hasPlus() == true) goto L6;
        super.onFocusChanged(r100, r101, r102);
        return;
    L6:
        super.onFocusChanged(r100, r101, r102);
        onDelegateFocusChanged(r100, r101, r102);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        if (hasPlus() == true) goto L6;
        super.onSizeChanged(r100, r101, r102, r103);
        return;
    L6:
        super.onSizeChanged(r100, r101, r102, r103);
        onDelegateSizeChanged(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public void setPadding(int r100, int r101, int r102, int r103) {
        if (hasPlus() == true) goto L6;
        super.setPadding(r100, r101, r102, r103);
        return;
    L6:
        Rect r104 = this.paddingData;
        r104.left = r100;
        r104.top = r101;
        r104.right = r102;
        r104.bottom = r103;
        onDelegateSetPaddingStart(r104);
        Rect r105 = this.paddingData;
        super.setPadding(r105.left, r105.top, r105.right, r105.bottom);
        onDelegateSetPaddingEnd(this.paddingData);
    }

    public /* synthetic */ LKUILinearLayout(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        if (hasPlus() == true) goto L6;
        super.onLayout(r100, r101, r102, r110, r111);
        return;
    L6:
        c r103 = this.onLayoutData;
        r103.f284227a = r100;
        r103.f284228b = r101;
        r103.f284229c = r102;
        r103.f284230d = r110;
        r103.f284231e = r111;
        onDelegateLayoutStart(r103);
        c r104 = this.onLayoutData;
        super.onLayout(r104.f284227a, r104.f284228b, r104.f284229c, r104.f284230d, r104.f284231e);
        onDelegateLayoutEnd(this.onLayoutData);
    }
}
