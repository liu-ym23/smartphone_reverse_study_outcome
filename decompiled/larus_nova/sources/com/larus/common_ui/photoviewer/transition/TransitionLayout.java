package com.larus.common_ui.photoviewer.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import j19.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k19.b;
import k19.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l19.d;
import l19.f;
import l19.h;
import l19.i;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001T\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000bH\u0014J\u0012\u0010Z\u001a\u00020W2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\n\u0010]\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010^\u001a\u00020-2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020W2\u0006\u0010b\u001a\u00020-H\u0016J\u0010\u0010c\u001a\u00020-2\u0006\u0010d\u001a\u00020`H\u0016J\u0010\u0010e\u001a\u00020W2\u0006\u0010f\u001a\u00020 H\u0016J\u0010\u0010g\u001a\u00020W2\u0006\u0010f\u001a\u00020 H\u0016J\u0010\u0010h\u001a\u00020W2\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010j\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010k\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0014\u0010l\u001a\u00020W*\u00020\u00162\u0006\u0010i\u001a\u00020\u000fH\u0002J\u0010\u0010m\u001a\u00020W2\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0012\u0010n\u001a\u00020W*\u00020\u000f2\u0006\u0010o\u001a\u00020\u0014J\b\u0010p\u001a\u00020WH\u0002J\u0018\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020\u000f2\b\u0010O\u001a\u0004\u0018\u00010PJ\u000e\u0010s\u001a\u00020W2\u0006\u0010t\u001a\u00020\u0004R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020'8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u00020-2\u0006\u0010&\u001a\u00020-@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u00020%2\u0006\u0010&\u001a\u00020%8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u00020-2\u0006\u0010&\u001a\u00020-@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R\u001a\u00109\u001a\u00020-X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R$\u0010;\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010A\u001a\u0004\u0018\u00010@2\b\u0010&\u001a\u0004\u0018\u00010@@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010F\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u000e\u0010N\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0004\n\u0002\u0010U¨\u0006u"}, d2 = {"Lcom/larus/common_ui/photoviewer/transition/TransitionLayout;", "Landroid/widget/FrameLayout;", "Lcom/larus/common_ui/photoviewer/gestures/GestureListener;", "Lcom/larus/common_ui/photoviewer/gestures/TransformGestureDetector;", "Lcom/larus/common_ui/photoviewer/transition/TransitionView;", "Lcom/larus/common_ui/photoviewer/transition/ITransitionParams;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "workingStartRect", "Landroid/graphics/Rect;", "workingEndRect", "currentViewRect", "tempRect", "tempRectF", "Landroid/graphics/RectF;", "tempTransform", "Landroid/graphics/Matrix;", "childView", "Landroid/view/View;", "animator", "Landroid/animation/ValueAnimator;", "detector", "transitionState", "transitionViewDelegate", "transitionListeners", "Ljava/util/LinkedHashSet;", "Lcom/larus/common_ui/photoviewer/transition/TransitionListener;", "Lkotlin/collections/LinkedHashSet;", "dragActionHelper", "Lcom/larus/common_ui/photoviewer/DragActionHelper;", "savedScaleFactor", "", "value", "", "transitionAnimationDuration", "getTransitionAnimationDuration", "()J", "setTransitionAnimationDuration", "(J)V", "", "isDragTransitionEnabled", "()Z", "setDragTransitionEnabled", "(Z)V", "maxDragTransitionFactor", "getMaxDragTransitionFactor", "()F", "setMaxDragTransitionFactor", "(F)V", "isSingleTagDismissEnabled", "setSingleTagDismissEnabled", "isDismissAnimatedEnable", "setDismissAnimatedEnable", "enterTransitionStartRect", "getEnterTransitionStartRect", "()Landroid/graphics/Rect;", "setEnterTransitionStartRect", "(Landroid/graphics/Rect;)V", "Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "restoreTransitionProvider", "getRestoreTransitionProvider", "()Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;", "setRestoreTransitionProvider", "(Lcom/larus/common_ui/photoviewer/IRestoreTransitionProvider;)V", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "getPos", "()I", "setPos", "(I)V", "dismissAnimationType", "getDismissAnimationType", "setDismissAnimationType", "isChildViewRequestDisallowInterceptTouchEvent", "endViewInfo", "Lcom/larus/common_ui/photoviewer/transition/TransitionEndViewInfo;", "animatorUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "animatorListener", "com/larus/common_ui/photoviewer/transition/TransitionLayout$animatorListener$1", "Lcom/larus/common_ui/photoviewer/transition/TransitionLayout$animatorListener$1;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "checkAndGetChildView", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "requestDisallowInterceptTouchEvent", "disallowIntercept", "onTouchEvent", "event", "addTransitionListener", "listener", "removeTransitionListener", "transformView", SVGRenderEngine.RECT, "onGestureBegin", "onGestureUpdate", "mapRect", "onGestureEnd", "set", "rectF", "updateWorkingEndRect", "startEnterTransition", "startRect", "setDelegateDragTransitionView", "transitionView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransitionLayout extends FrameLayout implements b<e>, i, l19.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f327724w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f327725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f327726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f327727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f327728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f327729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f327730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f327731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ValueAnimator f327732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f327733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f327734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i f327735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashSet<f> f327736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final j19.b f327737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f327738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f327739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f327740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f327741q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j19.e f327742r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f327743s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f327744t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f327745u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l19.b f327746v;

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TransitionLayout f327747a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public a(TransitionLayout r100) {
            this.f327747a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            onAnimationEnd(r100);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            TransitionLayout r101 = this.f327747a;
            int r102 = r101.f327734j;
            Iterator<T> r103 = r101.f327736l.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            ((f) r103.next()).onTransitionEnd(r101.f327734j);
            goto L4
        L6:
            this.f327747a.f327734j = -1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            TransitionLayout r101 = this.f327747a;
            Iterator<T> r102 = r101.f327736l.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            ((f) r102.next()).onTransitionBegin(r101.f327734j);
            goto L4
        L6:
            int r103 = this.f327747a.f327734j;
        }
    }

    public TransitionLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TransitionLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return true;
    }

    public void setDismissAnimatedEnable(boolean r100) {
    }

    public final View a() {
        i r100 = this.f327735k;
        if (r100 == null) goto L5;
        View r101 = r100.b();
    L6:
        if (r101 == null) goto L12;
        i r102 = this.f327735k;
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.b();
    L12:
        if (getChildCount() >= 2) goto L19;
        if (this.f327731g != null) goto L17;
        this.f327731g = getChildAt(0);
    L17:
        return this.f327731g;
    L19:
        throw new IllegalStateException("only allow one child view");
    L5:
        r101 = null;
        goto L6
    }

    public final void g() {
        l19.b r100 = this.f327746v;
        if (r100 == null) goto L5;
        Gravity.apply(r100.f507028c, r100.f507026a, r100.f507027b, new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), this.f327726b);
        return;
    L5:
        this.f327726b.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // l19.a
    public float getMaxDragTransitionFactor() {
        return this.f327737m.f496872d;
    }

    @Override // l19.a
    public int getDismissAnimationType() {
        return this.f327744t;
    }

    @Override // l19.a
    public Rect getEnterTransitionStartRect() {
        return this.f327741q;
    }

    @Override // l19.a
    public int getPos() {
        return this.f327743s;
    }

    @Override // l19.a
    public j19.e getRestoreTransitionProvider() {
        return this.f327742r;
    }

    @Override // l19.a
    public long getTransitionAnimationDuration() {
        return this.f327738n;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.f327739o;
    }

    @Override // l19.a
    public final boolean isSingleTagDismissEnabled() {
        return this.f327740p;
    }

    @Override // l19.i
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f327736l.add(r100);
        i r101 = this.f327735k;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.c(r100);
        return;
    L8:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.f327732h.isRunning() == false) goto L6;
        return false;
    L6:
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        this.f327745u = false;
    L14:
        if (this.f327735k != null) goto L26;
        if (this.f327745u == true) goto L26;
        if (r100 == null) goto L19;
        this.f327733i.b(r100);
    L19:
        ViewParent r103 = getParent();
        if (r103 == null) goto L26;
        if (this.f327734j != 3) goto L24;
        r101 = true;
    L24:
        r103.requestDisallowInterceptTouchEvent(r101);
    L26:
        return super.dispatchTouchEvent(r100);
    L8:
        if (r100.getAction() != 0) goto L10;
        r102 = true;
        goto L11
    }

    @Override // l19.i
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f327736l.remove(r100);
        i r101 = this.f327735k;
        if (r101 == null) goto L7;
        if (r101 == null) goto L8;
        r101.e(r100);
        return;
    L8:
        return;
    }

    public final void f(Rect r100) {
        View r101 = a();
        if (r101 != null) goto L5;
        return;
    L5:
        this.f327727c.set(r100);
        r101.setX(r100.left);
        r101.setY(r100.top);
        r101.getLayoutParams().width = r100.width();
        r101.getLayoutParams().height = r100.height();
        r101.requestLayout();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        View r101 = a();
        if (r101 == null) goto L6;
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.post(new d(this));
        return;
    }

    @Override // k19.b
    public final void onGestureBegin(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.f327734j = -1;
    }

    @Override // k19.b
    public final void onGestureEnd(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        this.f327737m.a();
        if (this.f327734j != 3) goto L33;
        Iterator<T> r101 = this.f327736l.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        ((f) r101.next()).onTransitionEnd(this.f327734j);
        goto L6
    L8:
        j19.b r102 = this.f327737m;
        boolean r103 = false;
        if ((r102.f496870b.f501407f / r102.f496871c) <= r102.f496872d) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L30;
        this.f327725a.set(this.f327727c);
        j19.e r105 = getRestoreTransitionProvider();
        if (r105 == null) goto L18;
        View r106 = r105.d(getPos());
        if (r106 == null) goto L18;
        Rect r107 = h.a(r106);
    L19:
        if (r107 != null) goto L21;
    L23:
        if (r103 == false) goto L25;
        Rect r108 = this.f327726b;
        Intrinsics.checkNotNull(r107);
        r108.set(r107);
    L29:
        this.f327734j = 2;
        this.f327732h.start();
        return;
    L25:
        this.f327730f.reset();
        if (getDismissAnimationType() != 0) goto L28;
        this.f327730f.postScale(0.1f, 0.1f, this.f327727c.centerX(), this.f327727c.centerY());
    L28:
        this.f327728d.set(this.f327725a);
        d(this.f327730f, this.f327728d);
        this.f327726b.set(this.f327728d);
        goto L29
    L21:
        if (r107.isEmpty() == true) goto L23;
        r103 = true;
    L18:
        r107 = null;
        goto L19
    L30:
        this.f327725a.set(this.f327727c);
        this.f327734j = 1;
        this.f327732h.start();
        return;
    L11:
        r104 = false;
        goto L12
    }

    @Override // k19.b
    public final void onGestureUpdate(e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.f327733i.f501413l != 4) goto L14;
        if (this.f327734j == 3) goto L14;
        if (this.f327739o == false) goto L14;
        this.f327734j = 3;
        Iterator<T> r101 = this.f327736l.iterator();
    L10:
        if (r101.hasNext() == false) goto L12;
        ((f) r101.next()).onTransitionBegin(this.f327734j);
        goto L10
    L12:
        this.f327725a.set(this.f327727c);
    L14:
        if (this.f327734j != 3) goto L19;
        this.f327730f.reset();
        this.f327730f.postScale(this.f327737m.a(), this.f327737m.a(), this.f327725a.centerX(), this.f327725a.centerY());
        Matrix r102 = this.f327730f;
        e r103 = this.f327733i;
        r102.postTranslate(r103.f501406e, r103.f501407f);
        this.f327728d.set(this.f327725a);
        d(this.f327730f, this.f327728d);
        f(this.f327728d);
        Iterator<T> r104 = this.f327736l.iterator();
    L17:
        if (r104.hasNext() == false) goto L22;
        f r105 = (f) r104.next();
        int r106 = this.f327734j;
        j19.b r107 = this.f327737m;
        r105.onTransitionChanged(r106, r107.f496870b.f501407f / r107.f496871c);
        goto L17
    L22:
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean r100) {
        super.requestDisallowInterceptTouchEvent(r100);
        this.f327745u = r100;
    }

    public final void setDelegateDragTransitionView(i r100) {
        Intrinsics.checkNotNullParameter(r100, "transitionView");
        i r101 = this.f327735k;
        if (r101 == null) goto L8;
        Iterator<T> r102 = this.f327736l.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r101.e((f) r102.next());
    L8:
        this.f327735k = r100;
        Iterator<T> r103 = this.f327736l.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        f r104 = (f) r103.next();
        i r105 = this.f327735k;
        if (r105 == null) goto L10;
        r105.c(r104);
        goto L10
    L14:
        i r106 = this.f327735k;
        if (r106 == null) goto L24;
        c.e(r106, this);
        return;
    }

    @Override // l19.a
    public void setDismissAnimationType(int r100) {
        this.f327744t = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setDragTransitionEnabled(boolean r100) {
        this.f327739o = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setEnterTransitionStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f327741q.set(r100);
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setMaxDragTransitionFactor(float r100) {
        this.f327737m.f496872d = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setPos(int r100) {
        this.f327743s = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setRestoreTransitionProvider(j19.e r100) {
        this.f327742r = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setSingleTagDismissEnabled(boolean r100) {
        this.f327740p = r100;
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    @Override // l19.a
    public void setTransitionAnimationDuration(long r100) {
        this.f327738n = r100;
        this.f327732h.setDuration(r100);
        i r101 = this.f327735k;
        if (r101 == null) goto L6;
        c.e(r101, this);
        return;
    }

    public final void d(Matrix r100, Rect r101) {
        this.f327729e.set(r101);
        r100.mapRect(this.f327729e);
        RectF r102 = this.f327729e;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r102, "rectF");
        r101.left = (int) r102.left;
        r101.top = (int) r102.top;
        r101.right = (int) r102.right;
        r101.bottom = (int) r102.bottom;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f327734j != (-1)) goto L6;
        g();
        this.f327727c.set(this.f327726b);
        return;
    }

    public TransitionLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f327725a = new Rect();
        this.f327726b = new Rect();
        this.f327727c = new Rect();
        this.f327728d = new Rect();
        this.f327729e = new RectF();
        this.f327730f = new Matrix();
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f327732h = r103;
        e r104 = new e();
        this.f327733i = r104;
        this.f327734j = -1;
        this.f327736l = new LinkedHashSet();
        this.f327737m = new j19.b(r100, r104);
        this.f327738n = 300;
        this.f327739o = true;
        this.f327740p = true;
        this.f327741q = new Rect();
        this.f327743s = -1;
        ValueAnimator.AnimatorUpdateListener r105 = new l19.c(this);
        a r106 = new a(this);
        if (r104.f501404c.contains(2) == true) goto L5;
        r104.f501404c.add(2);
    L5:
        r103.addUpdateListener(r105);
        r103.addListener(r106);
        r103.setDuration(getTransitionAnimationDuration());
        Intrinsics.checkNotNullParameter(this, "listener");
        r104.f501402a.add(this);
    }

    public /* synthetic */ TransitionLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
