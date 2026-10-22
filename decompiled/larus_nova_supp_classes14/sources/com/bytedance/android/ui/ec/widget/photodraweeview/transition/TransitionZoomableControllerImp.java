package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.ui.ec.widget.photodraweeview.DragActionHelper;
import com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp;
import com.bytedance.android.ui.ec.widget.photodraweeview.gestures.TransformGestureDetector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000205H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020%H\u0002J\b\u0010?\u001a\u00020;H\u0016J\u0012\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020\tH\u0002J\u0010\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020\u0004H\u0016J\u0010\u0010D\u001a\u00020;2\u0006\u0010C\u001a\u00020\u0004H\u0016J\u0010\u0010E\u001a\u00020;2\u0006\u0010C\u001a\u00020\u0004H\u0016J\u0010\u0010F\u001a\u00020;2\u0006\u0010<\u001a\u000205H\u0016J\b\u0010G\u001a\u00020;H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0017R&\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010&\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010,\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`6X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionZoomableControllerImp;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/ZoomableControllerImp;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionView;", "transformGestureDetector", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;", "context", "Landroid/content/Context;", "(Lcom/bytedance/android/ui/ec/widget/photodraweeview/gestures/TransformGestureDetector;Landroid/content/Context;)V", "allowDragTransition", "", "dismissScaleFactor", "", "dragActionHelper", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/DragActionHelper;", "getExitRect", "Lkotlin/Function0;", "Landroid/graphics/Rect;", "getGetExitRect", "()Lkotlin/jvm/functions/Function0;", "setGetExitRect", "(Lkotlin/jvm/functions/Function0;)V", "value", "isDragReturnAnimationEnabled", "()Z", "setDragReturnAnimationEnabled", "(Z)V", "isDragTransitionEnabled", "setDragTransitionEnabled", "isInDragTransitionState", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "newTransform", "Landroid/graphics/Matrix;", "startRect", "getStartRect", "()Landroid/graphics/Rect;", "setStartRect", "(Landroid/graphics/Rect;)V", "", "transitionAnimationDuration", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "transitionAnimatorListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "transitionStartMatrix", "transitionState", "", "addTransitionListener", "", "listener", "calculateDragGestureTransform", "outTransform", "dismissAnimated", "dismissAnimatedInternal", "isOuterCall", "onGestureBegin", "detector", "onGestureEnd", "onGestureUpdate", "removeTransitionListener", "resumeAnimated", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TransitionZoomableControllerImp extends ZoomableControllerImp implements TransitionView {
    private boolean allowDragTransition;
    private final float dismissScaleFactor;
    private final DragActionHelper dragActionHelper;
    private Function0<Rect> getExitRect;
    private boolean isDragReturnAnimationEnabled;
    private boolean isDragTransitionEnabled;
    private boolean isSingleTagDismissEnabled;
    private final Matrix newTransform;
    private Rect startRect;
    private long transitionAnimationDuration;
    private final ValueAnimator.AnimatorUpdateListener transitionAnimatorListener;
    private final LinkedHashSet<TransitionListener> transitionListeners;
    private final Matrix transitionStartMatrix;
    private int transitionState;

    private final void resumeAnimated() {
        this.transitionState = 1;
        setDisableGesture(true);
        this.newTransform.set(this.transitionStartMatrix);
        Iterator<T> r0 = this.transitionListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((TransitionListener) r0.next()).onTransitionBegin(this.transitionState);
        goto L4
    L6:
        setTransformAnimated(this.newTransform, getTransitionAnimationDuration(), new RunnableC02042(this), this.transitionAnimatorListener);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void dismissAnimated() {
        this.transitionStartMatrix.set(getActiveTransform());
        dismissAnimatedInternal(true);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public float getMaxDragTransitionFactor() {
        return this.dragActionHelper.getMaxDragTransitionFactor();
    }

    public final boolean isInDragTransitionState() {
        if (this.transitionState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.ITransitionParams
    public Function0<Rect> getGetExitRect() {
        return this.getExitRect;
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

    public static final /* synthetic */ LinkedHashSet access$getTransitionListeners$p(TransitionZoomableControllerImp r0) {
        return r0.transitionListeners;
    }

    public static final /* synthetic */ int access$getTransitionState$p(TransitionZoomableControllerImp r0) {
        return r0.transitionState;
    }

    private final void calculateDragGestureTransform(Matrix r6) {
        RectF r0 = getImageBounds();
        r6.set(this.transitionStartMatrix);
        float r1 = getDetector().getTranslationY();
        float r2 = this.dragActionHelper.getScaleFactorWhenDragState();
        r6.postScale(r2, r2, r0.centerX(), r0.centerY());
        Iterator<T> r3 = this.transitionListeners.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        ((TransitionListener) r3.next()).onTransitionChanged(this.transitionState, this.dragActionHelper.getDragFactor());
        goto L4
    L7:
        if (isTranslationEnabled() == false) goto L11;
        r6.postTranslate(getDetector().getTranslationX(), r1);
        return;
    }

    private final void dismissAnimatedInternal(boolean r9) {
        this.transitionState = 2;
        setDisableGesture(true);
        this.newTransform.set(getActiveTransform());
        Function0<Rect> r1 = getGetExitRect();
        if (r1 == null) goto L11;
        Rect r2 = (Rect) r1.invoke();
        if (r2 == null) goto L11;
        if ((true ^ r2.isEmpty()) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L11;
    L13:
        if (r2.isEmpty() == false) goto L15;
    L18:
        if (r9 == false) goto L20;
        this.newTransform.postTranslate(getImageBounds().centerX() - getTransformedImageBounds().centerX(), getImageBounds().centerY() - getTransformedImageBounds().centerY());
        Matrix r10 = this.newTransform;
        float r0 = this.dismissScaleFactor;
        r10.postScale(r0, r0, getImageBounds().centerX(), getImageBounds().centerY());
    L21:
        Iterator<T> r11 = this.transitionListeners.iterator();
    L23:
        if (r11.hasNext() == false) goto L25;
        ((TransitionListener) r11.next()).onTransitionBegin(this.transitionState);
        goto L23
    L25:
        setTransformAnimated(this.newTransform, getTransitionAnimationDuration(), new AnonymousClass2(this), this.transitionAnimatorListener);
        return;
    L20:
        Matrix r12 = this.newTransform;
        float r3 = this.dismissScaleFactor;
        r12.postScale(r3, r3, getTransformedImageBounds().centerX(), getTransformedImageBounds().centerY());
        goto L21
    L15:
        if (isDragReturnAnimationEnabled() == false) goto L18;
        float r13 = r2.width() / getTransformedImageBounds().width();
        this.newTransform.postScale(r13, r13, getTransformedImageBounds().centerX(), getTransformedImageBounds().centerY());
        this.newTransform.postTranslate(r2.centerX() - getTransformedImageBounds().centerX(), r2.exactCenterY() - getTransformedImageBounds().centerY());
    L11:
        r2 = getStartRect();
        goto L13
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void addTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.transitionListeners.add(r2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureBegin(TransformGestureDetector r2) {
        Intrinsics.checkNotNullParameter(r2, "detector");
        super.onGestureBegin(r2);
        if (isDisableGesture() == false) goto L5;
        return;
    L5:
        this.transitionState = -1;
        this.allowDragTransition = !isImageOutTopEdge();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureEnd(TransformGestureDetector r3) {
        Intrinsics.checkNotNullParameter(r3, "detector");
        if (isDisableGesture() == false) goto L6;
        return;
    L6:
        if (this.transitionState != 3) goto L15;
        Iterator<T> r4 = this.transitionListeners.iterator();
    L9:
        if (r4.hasNext() == false) goto L12;
        ((TransitionListener) r4.next()).onTransitionEnd(this.transitionState);
        goto L9
    L12:
        if (this.dragActionHelper.isDragOutSatisfied() == false) goto L14;
        dismissAnimatedInternal$default(this, false, 1, null);
        return;
    L14:
        resumeAnimated();
        return;
    L15:
        super.onGestureEnd(r3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController
    public void onGestureUpdate(TransformGestureDetector r5) {
        Intrinsics.checkNotNullParameter(r5, "detector");
        if (isDisableGesture() == false) goto L5;
        return;
    L5:
        if (isAnimatingOrScrolling() == false) goto L8;
        return;
    L8:
        if (isDragTransitionEnabled() == false) goto L20;
        if (r5.getGestureIntent() != 4) goto L20;
        if (this.allowDragTransition == false) goto L20;
        if (this.transitionState != (-1)) goto L20;
        this.transitionState = 3;
        this.transitionStartMatrix.set(getActiveTransform());
        Iterator<T> r0 = this.transitionListeners.iterator();
    L17:
        if (r0.hasNext() == false) goto L20;
        ((TransitionListener) r0.next()).onTransitionBegin(this.transitionState);
    L20:
        if (this.transitionState != 3) goto L22;
        calculateDragGestureTransform(getActiveTransform());
        onTransformChanged();
        return;
    L22:
        super.onGestureUpdate(r5);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionView
    public void removeTransitionListener(TransitionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.transitionListeners.remove(r2);
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
        this.dragActionHelper.setMaxDragTransitionFactor(r2);
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
    public void setTransitionAnimationDuration(long r1) {
        this.transitionAnimationDuration = r1;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureBegin(TransformGestureDetector r1) {
        onGestureBegin(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureEnd(TransformGestureDetector r1) {
        onGestureEnd(r1);
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.ZoomableControllerImp, com.bytedance.android.ui.ec.widget.photodraweeview.ABSZoomableController, com.bytedance.android.ui.ec.widget.photodraweeview.gestures.GestureListener
    public /* bridge */ /* synthetic */ void onGestureUpdate(TransformGestureDetector r1) {
        onGestureUpdate(r1);
    }

    public TransitionZoomableControllerImp(TransformGestureDetector r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r3, r4);
        this.transitionListeners = new LinkedHashSet();
        this.transitionState = -1;
        this.newTransform = new Matrix();
        this.allowDragTransition = true;
        this.transitionStartMatrix = new Matrix();
        this.dismissScaleFactor = 0.1f;
        this.dragActionHelper = new DragActionHelper(r4, r3);
        this.transitionAnimatorListener = new TransitionZoomableControllerImp$transitionAnimatorListener$1(this);
        this.transitionAnimationDuration = 300;
        this.isDragTransitionEnabled = true;
        this.isSingleTagDismissEnabled = true;
        this.startRect = new Rect();
    }

    public static final /* synthetic */ void access$setTransitionState$p(TransitionZoomableControllerImp r0, int r1) {
        r0.transitionState = r1;
    }

    public static /* synthetic */ void dismissAnimatedInternal$default(TransitionZoomableControllerImp r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        r0.dismissAnimatedInternal(r1);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dismissAnimatedInternal");
    }
}
