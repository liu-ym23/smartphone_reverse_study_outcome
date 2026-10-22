package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ui.ec.widget.photodraweeview.DragActionHelper;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0001\u0012\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B%\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020JH\u0016J\n\u0010W\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010X\u001a\u00020UH\u0016J\b\u0010Y\u001a\u00020UH\u0002J\u0010\u0010Z\u001a\u00020'2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010]\u001a\u00020\u001fH\u0002J\u0006\u0010^\u001a\u00020'J\u0010\u0010_\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010`\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010a\u001a\u00020U2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010b\u001a\u00020U2\u0006\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000bH\u0014J\u0010\u0010e\u001a\u00020'2\u0006\u0010f\u001a\u00020\\H\u0016J\u0010\u0010g\u001a\u00020U2\u0006\u0010V\u001a\u00020JH\u0016J\u0010\u0010h\u001a\u00020U2\u0006\u0010i\u001a\u00020'H\u0016J\u0010\u0010j\u001a\u00020U2\u0006\u0010k\u001a\u00020\u001fH\u0002J\u000e\u0010l\u001a\u00020U2\u0006\u0010m\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020U2\u0006\u0010;\u001a\u00020\u001fJ\u0018\u0010o\u001a\u00020U2\u0006\u0010p\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\u0017H\u0002J\b\u0010r\u001a\u00020UH\u0002J\u0012\u0010s\u001a\u00020U*\u00020\u001f2\u0006\u0010t\u001a\u00020PR\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010!X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020'X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R&\u00102\u001a\u0002012\u0006\u00100\u001a\u0002018V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u000e\u0010:\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010;\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u001f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010C\u001a\u00020B2\u0006\u00100\u001a\u00020B8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/GestureListener;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionView;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/ITransitionParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "alphaAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "animator", "animatorListener", "com/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout$animatorListener$1", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionLayout$animatorListener$1;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "childView", "Landroid/view/View;", "childViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "detector", "dismissAlphaAnimatorUpdateListener", "dragActionHelper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/DragActionHelper;", "endWorkingRect", "Landroid/graphics/Rect;", "getExitRect", "Lkotlin/Function0;", "getGetExitRect", "()Lkotlin/jvm/functions/Function0;", "setGetExitRect", "(Lkotlin/jvm/functions/Function0;)V", "isChildViewRequestDisallowInterceptTouchEvent", "", "isDragReturnAnimationEnabled", "()Z", "setDragReturnAnimationEnabled", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "value", "", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "optEnterTransition", "getOptEnterTransition", "setOptEnterTransition", "savedScaleFactor", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "tempLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "", "transitionAnimationDuration", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "transitionState", "transitionViewDelegate", "workingRect", "workingRectF", "Landroid/graphics/RectF;", "workingStartRect", "workingTransform", "Landroid/graphics/Matrix;", "addTransitionListener", "", "listener", "checkAndGetChildView", "dismissAnimated", "dismissAnimatedInternal", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getExitRectInner", "isEnableDismissTransition", "onGestureBegin", "onGestureEnd", "onGestureUpdate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "removeTransitionListener", "requestDisallowInterceptTouchEvent", "disallowIntercept", "setChildExitSize", "exitRect", "setDelegateDragTransitionView", "transitionView", "startEnterTransition", "transformView", "rect", "view", "useTempLayoutParams", "set", "rectF", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionLayout extends FrameLayout implements GestureListener<TransformGestureDetector>, TransitionView, ITransitionParams {
    private final ValueAnimator alphaAnimator;
    private final ValueAnimator animator;
    private final TransitionLayout$animatorListener$1 animatorListener;
    private final ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private View childView;
    private ViewGroup.LayoutParams childViewLayoutParams;
    private final TransformGestureDetector detector;
    private final ValueAnimator.AnimatorUpdateListener dismissAlphaAnimatorUpdateListener;
    private final DragActionHelper dragActionHelper;
    private Rect endWorkingRect;
    private Function0<Rect> getExitRect;
    private boolean isChildViewRequestDisallowInterceptTouchEvent;
    private boolean isDragReturnAnimationEnabled;
    private boolean isDragTransitionEnabled;
    private boolean isSingleTagDismissEnabled;
    private float maxDragTransitionFactor;
    private boolean optEnterTransition;
    private float savedScaleFactor;
    private Rect startRect;
    private final FrameLayout.LayoutParams tempLayoutParams;
    private long transitionAnimationDuration;
    private final LinkedHashSet<TransitionListener> transitionListeners;
    private int transitionState;
    private TransitionView transitionViewDelegate;
    private final Rect workingRect;
    private final RectF workingRectF;
    private Rect workingStartRect;
    private final Matrix workingTransform;

    public TransitionLayout(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public TransitionLayout(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    @Override // android.view.View, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return true;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void dismissAnimated() {
        TransitionView r0 = this.transitionViewDelegate;
        if (r0 == null) goto L6;
        if (r0 == null) goto L8;
        r0.dismissAnimated();
        return;
    L8:
        return;
    L6:
        useTempLayoutParams();
        dismissAnimatedInternal();
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public float getMaxDragTransitionFactor() {
        return this.dragActionHelper.getMaxDragTransitionFactor();
    }

    public final boolean isEnableDismissTransition() {
        if (this.transitionViewDelegate == null) goto L5;
    L8:
        return true;
    L5:
        if (getExitRectInner().isEmpty() == false) goto L8;
        return false;
    }

    private final View checkAndGetChildView() {
        if (getChildCount() >= 2) goto L10;
        if (this.childView != null) goto L8;
        this.childView = getChildAt(0);
    L8:
        return this.childView;
    L10:
        throw new IllegalStateException("only allow one child view");
    }

    private final void dismissAnimatedInternal() {
        Rect r0 = getExitRectInner();
        View r1 = checkAndGetChildView();
        if (r1 == null) goto L5;
        this.workingStartRect.set(0, 0, r1.getMeasuredWidth(), r1.getMeasuredHeight());
    L5:
        this.endWorkingRect.set(r0);
        this.transitionState = 2;
        setChildExitSize(r0);
        this.animator.start();
        if (r0.isEmpty() == false) goto L8;
    L9:
        this.alphaAnimator.start();
        return;
    L8:
        if (this.workingStartRect.isEmpty() == true) goto L9;
    }

    private final Rect getExitRectInner() {
        Function0<Rect> r0 = getGetExitRect();
        if (r0 == null) goto L12;
        Rect r1 = (Rect) r0.invoke();
        if (r1 == null) goto L12;
        if ((!r1.isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        return r1;
    L12:
        return getStartRect();
    }

    private final void useTempLayoutParams() {
        View r0 = checkAndGetChildView();
        if (r0 == null) goto L6;
        this.childViewLayoutParams = r0.getLayoutParams();
        r0.setLayoutParams(this.tempLayoutParams);
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Function0<Rect> getGetExitRect() {
        return this.getExitRect;
    }

    public final boolean getOptEnterTransition() {
        return this.optEnterTransition;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Rect getStartRect() {
        return this.startRect;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public long getTransitionAnimationDuration() {
        return this.transitionAnimationDuration;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragReturnAnimationEnabled() {
        return this.isDragReturnAnimationEnabled;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isDragTransitionEnabled() {
        return this.isDragTransitionEnabled;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public boolean isSingleTagDismissEnabled() {
        return this.isSingleTagDismissEnabled;
    }

    public static final /* synthetic */ View access$checkAndGetChildView(TransitionLayout r0) {
        return r0.checkAndGetChildView();
    }

    public static final /* synthetic */ ValueAnimator access$getAnimator$p(TransitionLayout r0) {
        return r0.animator;
    }

    public static final /* synthetic */ ViewGroup.LayoutParams access$getChildViewLayoutParams$p(TransitionLayout r0) {
        return r0.childViewLayoutParams;
    }

    public static final /* synthetic */ Rect access$getEndWorkingRect$p(TransitionLayout r0) {
        return r0.endWorkingRect;
    }

    public static final /* synthetic */ LinkedHashSet access$getTransitionListeners$p(TransitionLayout r0) {
        return r0.transitionListeners;
    }

    public static final /* synthetic */ int access$getTransitionState$p(TransitionLayout r0) {
        return r0.transitionState;
    }

    public static final /* synthetic */ Rect access$getWorkingRect$p(TransitionLayout r0) {
        return r0.workingRect;
    }

    public static final /* synthetic */ Rect access$getWorkingStartRect$p(TransitionLayout r0) {
        return r0.workingStartRect;
    }

    public static final /* synthetic */ void access$useTempLayoutParams(TransitionLayout r0) {
        r0.useTempLayoutParams();
    }

    private final void setChildExitSize(Rect r3) {
        if (r3.isEmpty() == true) goto L11;
        ViewGroup.LayoutParams r0 = this.childViewLayoutParams;
        if (r0 == null) goto L7;
        r0.height = r3.height();
    L7:
        ViewGroup.LayoutParams r1 = this.childViewLayoutParams;
        if (r1 == null) goto L12;
        r1.width = r3.width();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void addTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.transitionListeners.add(r2);
        TransitionView r0 = this.transitionViewDelegate;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.addTransitionListener(r2);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        boolean r1 = false;
        if (this.animator.isRunning() == false) goto L6;
        return false;
    L6:
        if (r5.getAction() != 0) goto L9;
        this.isChildViewRequestDisallowInterceptTouchEvent = false;
    L9:
        if (this.transitionViewDelegate != null) goto L19;
        if (this.isChildViewRequestDisallowInterceptTouchEvent == true) goto L19;
        this.detector.onTouchEvent(r5);
        ViewParent r0 = getParent();
        if (r0 == null) goto L19;
        if (this.transitionState != 3) goto L17;
        r1 = true;
    L17:
        r0.requestDisallowInterceptTouchEvent(r1);
    L19:
        return super.dispatchTouchEvent(r5);
    }

    /* JADX INFO: renamed from: onGestureBegin, reason: avoid collision after fix types in other method */
    public void onGestureBegin2(TransformGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        this.transitionState = -1;
    }

    /* JADX INFO: renamed from: onGestureEnd, reason: avoid collision after fix types in other method */
    public void onGestureEnd2(TransformGestureDetector r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        this.savedScaleFactor = this.dragActionHelper.getScaleFactorWhenDragState();
        if (this.transitionState != 3) goto L32;
        Iterator<T> r6 = this.transitionListeners.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        ((TransitionListener) r6.next()).onTransitionEnd(this.transitionState);
        goto L6
    L9:
        if (this.dragActionHelper.isDragOutSatisfied() == false) goto L29;
        this.workingStartRect.set(this.workingRect);
        Function0<Rect> r7 = getGetExitRect();
        if (r7 == null) goto L19;
        Rect r8 = (Rect) r7.invoke();
        if (r8 == null) goto L19;
        if ((true ^ r8.isEmpty()) == true) goto L18;
        r8 = null;
    L18:
        if (r8 == null) goto L19;
    L21:
        if (r8.isEmpty() == false) goto L23;
    L25:
        this.workingTransform.reset();
        this.workingTransform.postScale(0.1f, 0.1f, this.workingRect.centerX(), this.workingRect.centerY());
        this.workingRectF.set(this.endWorkingRect);
        this.workingTransform.mapRect(this.workingRectF);
        set(this.workingRect, this.workingRectF);
        this.endWorkingRect.set(this.workingRect);
    L26:
        this.transitionState = 2;
        this.animator.start();
        if (r8.isEmpty() == false) goto L33;
        this.alphaAnimator.start();
        return;
    L33:
        return;
    L23:
        if (isDragReturnAnimationEnabled() == false) goto L25;
        this.endWorkingRect.set(r8);
        setChildExitSize(r8);
    L19:
        r8 = getStartRect();
        goto L21
    L29:
        this.workingStartRect.set(this.workingRect);
        this.transitionState = 1;
        this.animator.start();
        return;
    }

    /* JADX INFO: renamed from: onGestureUpdate, reason: avoid collision after fix types in other method */
    public void onGestureUpdate2(TransformGestureDetector r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        if (this.detector.getGestureIntent() != 4) goto L14;
        if (this.transitionState == 3) goto L14;
        if (isDragTransitionEnabled() == false) goto L14;
        this.transitionState = 3;
        Iterator<T> r6 = this.transitionListeners.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        ((TransitionListener) r6.next()).onTransitionBegin(this.transitionState);
        goto L10
    L12:
        useTempLayoutParams();
    L14:
        if (this.transitionState != 3) goto L22;
        this.workingTransform.reset();
        this.workingTransform.postTranslate(this.detector.getTranslationX(), this.detector.getTranslationY());
        this.workingTransform.postScale(this.dragActionHelper.getScaleFactorWhenDragState(), this.dragActionHelper.getScaleFactorWhenDragState(), this.workingRect.centerX(), this.workingRect.centerY());
        this.workingRectF.set(this.endWorkingRect);
        this.workingTransform.mapRect(this.workingRectF);
        set(this.workingRect, this.workingRectF);
        View r7 = checkAndGetChildView();
        if (r7 == null) goto L18;
        transformView(this.workingRect, r7);
    L18:
        Iterator<T> r8 = this.transitionListeners.iterator();
    L20:
        if (r8.hasNext() == false) goto L25;
        ((TransitionListener) r8.next()).onTransitionChanged(this.transitionState, this.dragActionHelper.getDragFactor());
        goto L20
    L25:
        return;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void removeTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.transitionListeners.remove(r2);
        TransitionView r0 = this.transitionViewDelegate;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.removeTransitionListener(r2);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r1) {
        super.requestDisallowInterceptTouchEvent(r1);
        this.isChildViewRequestDisallowInterceptTouchEvent = r1;
    }

    public final void setDelegateDragTransitionView(TransitionView r3) {
        Intrinsics.checkNotNullParameter(r3, "transitionView");
        this.transitionViewDelegate = r3;
        Iterator<T> r4 = this.transitionListeners.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        TransitionListener r0 = (TransitionListener) r4.next();
        TransitionView r1 = this.transitionViewDelegate;
        if (r1 == null) goto L4;
        r1.addTransitionListener(r0);
        goto L4
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragReturnAnimationEnabled(boolean r1) {
        this.isDragReturnAnimationEnabled = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setDragTransitionEnabled(boolean r1) {
        this.isDragTransitionEnabled = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setGetExitRect(Function0<Rect> r1) {
        this.getExitRect = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setMaxDragTransitionFactor(float r2) {
        this.maxDragTransitionFactor = r2;
        this.dragActionHelper.setMaxDragTransitionFactor(r2);
    }

    public final void setOptEnterTransition(boolean r1) {
        this.optEnterTransition = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setSingleTagDismissEnabled(boolean r1) {
        this.isSingleTagDismissEnabled = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setStartRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.startRect.set(r2);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public void setTransitionAnimationDuration(long r2) {
        this.transitionAnimationDuration = r2;
        this.animator.setDuration(r2);
        this.alphaAnimator.setDuration(r2);
    }

    public final void startEnterTransition(final Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "startRect");
        if (this.animator.isRunning() == false) goto L5;
        return;
    L5:
        post(new AnonymousClass1(this, r2));
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r1) {
        onGestureBegin2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r1) {
        onGestureEnd2(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r1) {
        onGestureUpdate2(r1);
    }

    public static final /* synthetic */ void access$setChildViewLayoutParams$p(TransitionLayout r0, ViewGroup.LayoutParams r1) {
        r0.childViewLayoutParams = r1;
    }

    public static final /* synthetic */ void access$setEndWorkingRect$p(TransitionLayout r0, Rect r1) {
        r0.endWorkingRect = r1;
    }

    public static final /* synthetic */ void access$setTransitionState$p(TransitionLayout r0, int r1) {
        r0.transitionState = r1;
    }

    public static final /* synthetic */ void access$setWorkingStartRect$p(TransitionLayout r0, Rect r1) {
        r0.workingStartRect = r1;
    }

    private final void transformView(Rect r3, View r4) {
        r4.setX(r3.left);
        r4.setY(r3.top);
        r4.getLayoutParams().width = r3.width();
        r4.getLayoutParams().height = r3.height();
        r4.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        View r0 = checkAndGetChildView();
        if (r0 != null) goto L7;
        super.onMeasure(r4, r5);
        return;
    L7:
        if (this.optEnterTransition == false) goto L16;
        int r1 = this.transitionState;
        if (r1 == (-1)) goto L12;
        if (r1 != 0) goto L16;
    L12:
        if (getStartRect().isEmpty() == true) goto L16;
        if (this.childViewLayoutParams != null) goto L16;
        useTempLayoutParams();
        transformView(getStartRect(), r0);
    L16:
        super.onMeasure(r4, r5);
        if (this.optEnterTransition == false) goto L30;
        int r6 = this.transitionState;
        if (r6 == (-1)) goto L22;
        if (r6 == 0) goto L22;
        return;
    L22:
        if (this.endWorkingRect.isEmpty() == false) goto L34;
        Object r7 = r0.getParent();
        if ((r7 instanceof View) == true) goto L26;
        r7 = null;
    L26:
        View r8 = (View) r7;
        if (r8 == null) goto L35;
        this.endWorkingRect.set(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());
        return;
    L35:
        return;
    L34:
        return;
    L30:
        if (this.transitionState != (-1)) goto L37;
        this.endWorkingRect.set(0, 0, r0.getMeasuredWidth(), r0.getMeasuredHeight());
        return;
    }

    public final void set(Rect r2, RectF r3) {
        Intrinsics.checkNotNullParameter(r2, "$this$set");
        Intrinsics.checkNotNullParameter(r3, "rectF");
        r2.left = (int) r3.left;
        r2.top = (int) r3.top;
        r2.right = (int) r3.right;
        r2.bottom = (int) r3.bottom;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.animation.Animator$AnimatorListener, com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionLayout$animatorListener$1] */
    public TransitionLayout(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6, r7, r8);
        this.workingStartRect = new Rect();
        this.endWorkingRect = new Rect();
        this.workingRect = new Rect();
        this.workingRectF = new RectF();
        this.workingTransform = new Matrix();
        this.tempLayoutParams = new FrameLayout.LayoutParams(0, 0);
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animator = r9;
        TransformGestureDetector r0 = new TransformGestureDetector();
        this.detector = r0;
        this.transitionState = -1;
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.alphaAnimator = r1;
        this.transitionListeners = new LinkedHashSet();
        ValueAnimator.AnimatorUpdateListener r2 = new TransitionLayout$dismissAlphaAnimatorUpdateListener$1(this);
        this.dismissAlphaAnimatorUpdateListener = r2;
        this.dragActionHelper = new DragActionHelper(r6, r0);
        this.savedScaleFactor = 1.0f;
        this.transitionAnimationDuration = 300;
        this.isDragTransitionEnabled = true;
        this.maxDragTransitionFactor = 0.4f;
        this.isSingleTagDismissEnabled = true;
        this.startRect = new Rect();
        ValueAnimator.AnimatorUpdateListener r10 = new TransitionLayout$animatorUpdateListener$1(this);
        this.animatorUpdateListener = r10;
        ?? r3 = new TransitionLayout$animatorListener$1(this);
        this.animatorListener = r3;
        r0.ignoreInitGestureIntent(2);
        r9.addUpdateListener(r10);
        r9.addListener(r3);
        r9.setDuration(getTransitionAnimationDuration());
        r1.setDuration(getTransitionAnimationDuration());
        r1.addUpdateListener(r2);
        r0.addListener(this);
    }

    public static final /* synthetic */ void access$transformView(TransitionLayout r0, Rect r1, View r2) {
        r0.transformView(r1, r2);
    }

    public /* synthetic */ TransitionLayout(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
