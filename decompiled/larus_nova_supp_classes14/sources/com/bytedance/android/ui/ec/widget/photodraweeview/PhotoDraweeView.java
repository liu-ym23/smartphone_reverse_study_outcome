package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ScrollingView;
import com.bytedance.android.shopping.yata.business.function.ScrollPosition;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.DefaultGestureHandler;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListenerWrapper;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010S\u001a\u00020\u00182\u0018\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0015J\u0012\u0010U\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0010\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\bH\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020\bH\u0016J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\u0018H\u0016J\b\u0010^\u001a\u00020\bH\u0016J\b\u0010_\u001a\u00020\bH\u0016J\b\u0010`\u001a\u00020\bH\u0016J\b\u0010a\u001a\u0004\u0018\u00010\u0017J\u0012\u0010b\u001a\u00020\u00182\b\u0010c\u001a\u0004\u0018\u00010\u0017H\u0004J\u0010\u0010d\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u0017H\u0004J\u001a\u0010e\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010f\u001a\u00020\u00182\u0006\u0010g\u001a\u00020hH\u0014J\b\u0010i\u001a\u00020\u0018H\u0002J0\u0010j\u001a\u00020\u00182\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0014J\b\u0010p\u001a\u00020\u0018H\u0002J\u0010\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020sH\u0016J \u0010t\u001a\u00020\u00182\u0018\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0015J\u0012\u0010u\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0012\u0010v\u001a\u00020\u00182\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0010\u0010w\u001a\u00020\u00182\u0006\u0010x\u001a\u00020)H\u0004J\u000e\u0010y\u001a\u00020\u00182\u0006\u0010z\u001a\u00020\nJ\u0010\u0010{\u001a\u00020\u00182\u0006\u0010O\u001a\u00020PH\u0004J\b\u0010|\u001a\u00020\u0018H\u0002J\b\u0010}\u001a\u00020\u0018H\u0004R&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010.\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R$\u00104\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u000e\u00106\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R&\u00108\u001a\u0002072\u0006\u0010\f\u001a\u0002078F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R&\u0010=\u001a\u0002072\u0006\u0010\f\u001a\u0002078F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<R*\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\f\u001a\u0004\u0018\u00010@8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER*\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\f\u001a\u0004\u0018\u00010F8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/PhotoDraweeView;", "Lcom/facebook/drawee/view/GenericDraweeView;", "Landroidx/core/view/ScrollingView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "needSetupZoomController", "", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "value", "", "animationDuration", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "boundsChangeListeners", "", "Lkotlin/Function2;", "Landroid/view/View;", "Landroid/graphics/RectF;", "", "callback", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;", "getCallback", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;", "setCallback", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;)V", "controllerListener", "Lcom/facebook/drawee/controller/BaseControllerListener;", "", "getControllerListener", "()Lcom/facebook/drawee/controller/BaseControllerListener;", "setControllerListener", "(Lcom/facebook/drawee/controller/BaseControllerListener;)V", "controllerListenerInternal", "Lcom/facebook/drawee/controller/ControllerListener;", "defaultGestureHandler", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/DefaultGestureHandler;", "gestureDetector", "Landroid/view/GestureDetector;", "hasSetImage", "imageBounds", "isDoubleClickScaleEnabled", "()Z", "setDoubleClickScaleEnabled", "(Z)V", "isScaleEnabled", "setScaleEnabled", "isTranslationEnabled", "setTranslationEnabled", "lastImageBounds", "", "maxScaleFactor", "getMaxScaleFactor", "()F", "setMaxScaleFactor", "(F)V", "minScaleFactor", "getMinScaleFactor", "setMinScaleFactor", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "scaleFactorRetriever", "getScaleFactorRetriever", "()Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;", "setScaleFactorRetriever", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/ScaleFactorRetriever;)V", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "tapListener", "getTapListener", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "setTapListener", "(Landroid/view/GestureDetector$SimpleOnGestureListener;)V", "tapListenerWrapper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListenerWrapper;", "viewBounds", "zoomableController", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "zoomableListener", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableController$Listener;", "addBoundsChangeListener", "listener", "addControllerListener", "controller", "Lcom/facebook/drawee/interfaces/DraweeController;", "canScrollVertically", "direction", "computeHorizontalScrollExtent", "computeHorizontalScrollOffset", "computeHorizontalScrollRange", "computeScroll", "computeVerticalScrollExtent", "computeVerticalScrollOffset", "computeVerticalScrollRange", "getAvailableImageBounds", "getImageBounds", "outBounds", "getLimitBounds", "inflateHierarchy", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFinalImageSet", "onLayout", "changed", ScrollPosition.POSITION_LEFT, ScrollPosition.POSITION_TOP, ScrollPosition.POSITION_RIGHT, ScrollPosition.POSITION_BOTTOM, "onRelease", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeBoundsChangeListener", "removeControllerListener", "setController", "setGestureHandler", "gestureHandler", "setHorizontalNestedScrollEnabled", "enabled", "setZoomableControllerImp", "setupZoomController", "updateZoomableControllerBounds", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PhotoDraweeView extends GenericDraweeView implements ScrollingView {
    private long animationDuration;
    private final Set<Function2<View, RectF, Unit>> boundsChangeListeners;
    private IPhotoDraweeViewCallback callback;
    private BaseControllerListener<Object> controllerListener;
    private final ControllerListener<Object> controllerListenerInternal;
    private DefaultGestureHandler defaultGestureHandler;
    private GestureDetector gestureDetector;
    private boolean hasSetImage;
    private final RectF imageBounds;
    private boolean isDoubleClickScaleEnabled;
    private boolean isScaleEnabled;
    private boolean isTranslationEnabled;
    private final RectF lastImageBounds;
    private float maxScaleFactor;
    private float minScaleFactor;
    private ScaleFactorRetriever scaleFactorRetriever;
    private GestureDetector.SimpleOnGestureListener tapListener;
    private GestureListenerWrapper tapListenerWrapper;
    private final RectF viewBounds;
    private ZoomableControllerImp zoomableController;
    private final ZoomableController.Listener zoomableListener;

    public PhotoDraweeView(Context r8) {
        this(r8, null, 0, false, 14, null);
    }

    public PhotoDraweeView(Context r8, AttributeSet r9) {
        this(r8, r9, 0, false, 12, null);
    }

    public PhotoDraweeView(Context r8, AttributeSet r9, int r10) {
        this(r8, r9, r10, false, 8, null);
    }

    private final void onFinalImageSet() {
        this.hasSetImage = true;
        ZoomableControllerImp r1 = this.zoomableController;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        if (r1.isEnabled() == true) goto L12;
        ZoomableControllerImp r2 = this.zoomableController;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L10:
        r2.setEnabled(true);
        updateZoomableControllerBounds();
        return;
    }

    private final void onRelease() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupZoomController() {
        ZoomableControllerImp r0 = new ZoomableControllerImp(new TransformGestureDetector(), getContext());
        setZoomableControllerImp(r0);
        setGestureHandler(new DefaultGestureHandler(r0));
    }

    public int computeHorizontalScrollExtent() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollOffset() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollRange() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeHorizontalScrollRange();
    }

    public void computeScroll() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.computeScroll();
    }

    public int computeVerticalScrollExtent() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeVerticalScrollOffset();
    }

    public int computeVerticalScrollRange() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.computeVerticalScrollRange();
    }

    public final long getAnimationDuration() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.getAnimationDuration();
    }

    public final RectF getAvailableImageBounds() {
        if (this.hasSetImage == true) goto L7;
        return null;
    L7:
        return this.imageBounds;
    }

    public final float getMaxScaleFactor() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.getMaxScaleFactor();
    }

    public final float getMinScaleFactor() {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L6:
        return r0.getMinScaleFactor();
    }

    public final GestureDetector.SimpleOnGestureListener getTapListener() {
        GestureListenerWrapper r0 = this.tapListenerWrapper;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L6:
        return r0.getListener();
    }

    public final boolean isDoubleClickScaleEnabled() {
        DefaultGestureHandler r0 = this.defaultGestureHandler;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        return r0.isDoubleClickScaleEnabled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateZoomableControllerBounds() {
        getImageBounds(this.imageBounds);
        getLimitBounds(this.viewBounds);
        IPhotoDraweeViewCallback.Companion r0 = IPhotoDraweeViewCallback.Companion;
        r0.getTempRect().set(this.imageBounds);
        IPhotoDraweeViewCallback r1 = this.callback;
        if (r1 == null) goto L5;
        r1.configTransform(this, r0.getTempRect());
    L5:
        IPhotoDraweeViewCallback r2 = this.callback;
        if (r2 == null) goto L10;
        Matrix r3 = r2.getDefaultTransform();
        if (r3 == null) goto L10;
        r3.mapRect(this.imageBounds);
    L10:
        ZoomableControllerImp r4 = this.zoomableController;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L13:
        r4.setImageBounds(this.imageBounds);
        ZoomableControllerImp r5 = this.zoomableController;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L16:
        r5.setViewBounds(this.viewBounds);
        if ((!Intrinsics.areEqual(this.lastImageBounds, this.imageBounds)) == false) goto L24;
        this.lastImageBounds.set(this.imageBounds);
        if (this.hasSetImage == false) goto L26;
        Iterator<T> r6 = this.boundsChangeListeners.iterator();
    L22:
        if (r6.hasNext() == false) goto L27;
        ((Function2) r6.next()).invoke(this, this.imageBounds);
        goto L22
    L27:
        return;
    L26:
        return;
    }

    public final IPhotoDraweeViewCallback getCallback() {
        return this.callback;
    }

    public final BaseControllerListener<Object> getControllerListener() {
        return this.controllerListener;
    }

    public final ScaleFactorRetriever getScaleFactorRetriever() {
        return this.scaleFactorRetriever;
    }

    public final boolean isScaleEnabled() {
        return this.isScaleEnabled;
    }

    public final boolean isTranslationEnabled() {
        return this.isTranslationEnabled;
    }

    public static final /* synthetic */ DefaultGestureHandler access$getDefaultGestureHandler$p(PhotoDraweeView r1) {
        DefaultGestureHandler r2 = r1.defaultGestureHandler;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        return r2;
    }

    public static final /* synthetic */ void access$onFinalImageSet(PhotoDraweeView r0) {
        r0.onFinalImageSet();
    }

    public static final /* synthetic */ void access$onRelease(PhotoDraweeView r0) {
        r0.onRelease();
    }

    private final void addControllerListener(DraweeController r2) {
        if ((r2 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r2).addControllerListener(this.controllerListenerInternal);
        return;
    }

    private final void removeControllerListener(DraweeController r2) {
        if ((r2 instanceof AbstractDraweeController) == false) goto L6;
        ((AbstractDraweeController) r2).removeControllerListener(this.controllerListenerInternal);
        return;
    }

    public final void addBoundsChangeListener(Function2<? super View, ? super RectF, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.boundsChangeListeners.add(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean canScrollVertically(int r1) {
        return super/*android.widget.ImageView*/.canScrollVertically(r1);
    }

    public final void getImageBounds(RectF r2) {
        getHierarchy().getActualImageBounds(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void getLimitBounds(RectF r4) {
        Intrinsics.checkNotNullParameter(r4, "outBounds");
        r4.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r4) {
        Intrinsics.checkNotNullParameter(r4, "canvas");
        int r0 = r4.save();
        ZoomableControllerImp r1 = this.zoomableController;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r4.concat(r1.getActiveTransform());
        IPhotoDraweeViewCallback r2 = this.callback;
        if (r2 == null) goto L10;
        Matrix r3 = r2.getDefaultTransform();
        if (r3 == null) goto L10;
        r4.concat(r3);
    L10:
        super/*android.widget.ImageView*/.onDraw(r4);
        r4.restoreToCount(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        super/*com.facebook.drawee.view.DraweeView*/.onTouchEvent(r5);
        GestureDetector r0 = this.gestureDetector;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L5:
        r0.onTouchEvent(r5);
        ZoomableControllerImp r1 = this.zoomableController;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L9:
        if (r1.onTouchEvent(r5) == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L12:
        getParent().requestDisallowInterceptTouchEvent(false);
        MotionEvent r6 = MotionEvent.obtain(r5);
        r6.setAction(3);
        GestureDetector r2 = this.gestureDetector;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
    L15:
        r2.onTouchEvent(r6);
        ZoomableControllerImp r3 = this.zoomableController;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L18:
        r3.onTouchEvent(r6);
        r6.recycle();
        return false;
    }

    public final void removeBoundsChangeListener(Function2<? super View, ? super RectF, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.boundsChangeListeners.remove(r2);
    }

    public final void setAnimationDuration(long r3) {
        this.animationDuration = r3;
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setAnimationDuration(r3);
    }

    public final void setCallback(IPhotoDraweeViewCallback r1) {
        this.callback = r1;
    }

    public void setController(DraweeController r2) {
        removeControllerListener(getController());
        addControllerListener(r2);
        super/*com.facebook.drawee.view.DraweeView*/.setController(r2);
    }

    public final void setControllerListener(BaseControllerListener<Object> r1) {
        this.controllerListener = r1;
    }

    public final void setDoubleClickScaleEnabled(boolean r3) {
        DefaultGestureHandler r0 = this.defaultGestureHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        r0.setDoubleClickScaleEnabled(r3);
        this.isDoubleClickScaleEnabled = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setGestureHandler(DefaultGestureHandler r5) {
        Intrinsics.checkNotNullParameter(r5, "gestureHandler");
        this.defaultGestureHandler = r5;
        DefaultGestureHandler r1 = this.defaultGestureHandler;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L5:
        this.tapListenerWrapper = new GestureListenerWrapper(r1);
        Context r2 = getContext();
        GestureListenerWrapper r3 = this.tapListenerWrapper;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L8:
        GestureDetector r0 = new GestureDetector(r2, r3);
        this.gestureDetector = r0;
        r0.setIsLongpressEnabled(true);
        r5.setScaleFactorRetriever(getScaleFactorRetriever());
    }

    public final void setHorizontalNestedScrollEnabled(boolean r3) {
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setHorizontalNestedScrollEnabled(r3);
    }

    public final void setMaxScaleFactor(float r3) {
        this.maxScaleFactor = r3;
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setMaxScaleFactor(r3);
    }

    public final void setMinScaleFactor(float r3) {
        this.minScaleFactor = r3;
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setMinScaleFactor(r3);
    }

    public final void setScaleEnabled(boolean r3) {
        this.isScaleEnabled = r3;
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setScaleEnabled(r3);
    }

    public final void setScaleFactorRetriever(ScaleFactorRetriever r3) {
        this.scaleFactorRetriever = r3;
        DefaultGestureHandler r0 = this.defaultGestureHandler;
        if (r0 == null) goto L8;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("defaultGestureHandler");
    L6:
        r0.setScaleFactorRetriever(r3);
        return;
    }

    public final void setTapListener(GestureDetector.SimpleOnGestureListener r3) {
        GestureListenerWrapper r0 = this.tapListenerWrapper;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tapListenerWrapper");
    L5:
        r0.setListener(r3);
        this.tapListener = r3;
    }

    public final void setTranslationEnabled(boolean r3) {
        this.isTranslationEnabled = r3;
        ZoomableControllerImp r0 = this.zoomableController;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("zoomableController");
    L5:
        r0.setTranslationEnabled(r3);
    }

    public final void setZoomableControllerImp(ZoomableControllerImp r2) {
        Intrinsics.checkNotNullParameter(r2, "zoomableController");
        this.zoomableController = r2;
        r2.setListener(this.zoomableListener);
        setScaleFactorRetriever(new DefaultScaleFactorRetrieverImp(r2));
    }

    public static final /* synthetic */ void access$setDefaultGestureHandler$p(PhotoDraweeView r0, DefaultGestureHandler r1) {
        r0.defaultGestureHandler = r1;
    }

    public void inflateHierarchy(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        GenericDraweeHierarchyBuilder r0 = new GenericDraweeHierarchyBuilder(r3.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        GenericDraweeHierarchyInflater.updateBuilder(r0, r3, r4);
        setAspectRatio(r0.getDesiredAspectRatio());
        setHierarchy(r0.build());
    }

    public PhotoDraweeView(Context r1, AttributeSet r2, int r3, boolean r4) {
        super(r1, r2, r3);
        this.imageBounds = new RectF();
        this.viewBounds = new RectF();
        this.isDoubleClickScaleEnabled = true;
        this.maxScaleFactor = 1.0f;
        this.minScaleFactor = 1.0f;
        this.controllerListenerInternal = new PhotoDraweeView$controllerListenerInternal$1(this);
        this.zoomableListener = new PhotoDraweeView$zoomableListener$1(this);
        if (r4 == false) goto L5;
        setupZoomController();
    L5:
        this.isScaleEnabled = true;
        this.isTranslationEnabled = true;
        this.lastImageBounds = new RectF();
        this.boundsChangeListeners = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super/*android.widget.ImageView*/.onLayout(r1, r2, r3, r4, r5);
        updateZoomableControllerBounds();
    }

    public /* synthetic */ PhotoDraweeView(Context r1, AttributeSet r2, int r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r5 & 8) == 0) goto L11;
        r4 = true;
    L11:
        this(r1, r2, r3, r4);
    }
}
