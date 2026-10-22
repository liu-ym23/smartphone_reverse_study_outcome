package com.ss.android.lark.widget.recyclerview;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\b\u0000\u0018\u0000 \u008e\u00012\u00020\u00012\u00020\u0002:\f\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010N\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010P\u001a\u00020OH\u0002J\b\u0010Q\u001a\u00020OH\u0002J\b\u0010R\u001a\u00020OH\u0002J\u0010\u0010S\u001a\u00020O2\u0006\u0010T\u001a\u00020\fH\u0002J\u0006\u0010Z\u001a\u00020OJ\u0006\u0010[\u001a\u00020OJ\u0010\u0010[\u001a\u00020O2\u0006\u0010\\\u001a\u00020\fH\u0007J\b\u0010]\u001a\u00020OH\u0002J\u0010\u0010^\u001a\u00020O2\u0006\u0010_\u001a\u00020\fH\u0002J \u0010`\u001a\u00020O2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00042\u0006\u0010T\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020O2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010f\u001a\u00020O2\u0006\u0010a\u001a\u00020bH\u0002J\u0016\u0010g\u001a\u00020O2\u0006\u0010h\u001a\u00020\f2\u0006\u0010i\u001a\u00020\fJ\u0018\u0010j\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010k\u001a\u00020lH\u0016J\u0018\u0010m\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010n\u001a\u00020lH\u0016J\u0010\u0010o\u001a\u00020O2\u0006\u0010p\u001a\u00020<H\u0016J\u0010\u0010q\u001a\u00020O2\u0006\u0010r\u001a\u00020&H\u0002J\u0010\u0010s\u001a\u00020O2\u0006\u0010t\u001a\u00020&H\u0002J8\u0010u\u001a\u00020\f2\u0006\u0010v\u001a\u00020&2\u0006\u0010w\u001a\u00020&2\u0006\u0010x\u001a\u00020C2\u0006\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020\f2\u0006\u0010{\u001a\u00020\fH\u0002J\u0018\u0010|\u001a\u00020<2\u0006\u0010}\u001a\u00020&2\u0006\u0010~\u001a\u00020&H\u0007J\u0018\u0010\u007f\u001a\u00020<2\u0006\u0010}\u001a\u00020&2\u0006\u0010~\u001a\u00020&H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010%\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R$\u00100\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u001c\u001a\u0004\b2\u0010\u001e\"\u0004\b3\u0010 R$\u00104\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010\u001c\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b?\u0010\u001cR\u0014\u0010@\u001a\u00020\fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bA\u0010\u001cR\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010E\u001a\n G*\u0004\u0018\u00010F0FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020\fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\bI\u0010\u001cR\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010V\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020<8G¢\u0006\u0006\u001a\u0004\bX\u0010WR\u0011\u0010Y\u001a\u00020<8G¢\u0006\u0006\u001a\u0004\bY\u0010WR\u0013\u0010\u0080\u0001\u001a\u00020\b8G¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010\u0012R\u0013\u0010\u0082\u0001\u001a\u00020\b8G¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\u0012R\u0017\u0010\u0084\u0001\u001a\u00020C8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0087\u0001\u001a\u00020C8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0088\u0001\u0010\u0086\u0001¨\u0006\u008f\u0001"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/FastScroller;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mVerticalThumbDrawable", "Landroid/graphics/drawable/StateListDrawable;", "verticalTrackDrawable", "Landroid/graphics/drawable/Drawable;", "mHorizontalThumbDrawable", "horizontalTrackDrawable", "defaultWidth", "", "scrollbarMinimumRange", GXTemplateKey.FLEXBOX_MARGIN, "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/StateListDrawable;Landroid/graphics/drawable/Drawable;III)V", "getVerticalTrackDrawable", "()Landroid/graphics/drawable/Drawable;", "getHorizontalTrackDrawable", "mScrollbarMinimumRange", "mMargin", "mVerticalThumbWidth", "mVerticalTrackWidth", "mHorizontalThumbHeight", "mHorizontalTrackHeight", "mVerticalThumbHeight", "getMVerticalThumbHeight$annotations", "()V", "getMVerticalThumbHeight", "()I", "setMVerticalThumbHeight", "(I)V", "mVerticalThumbCenterY", "getMVerticalThumbCenterY$annotations", "getMVerticalThumbCenterY", "setMVerticalThumbCenterY", "mVerticalDragY", "", "getMVerticalDragY$annotations", "getMVerticalDragY", "()F", "setMVerticalDragY", "(F)V", "mHorizontalThumbWidth", "getMHorizontalThumbWidth$annotations", "getMHorizontalThumbWidth", "setMHorizontalThumbWidth", "mHorizontalThumbCenterX", "getMHorizontalThumbCenterX$annotations", "getMHorizontalThumbCenterX", "setMHorizontalThumbCenterX", "mHorizontalDragX", "getMHorizontalDragX$annotations", "getMHorizontalDragX", "setMHorizontalDragX", "mRecyclerViewWidth", "mRecyclerViewHeight", "mRecyclerView", "mNeedVerticalScrollbar", "", "mNeedHorizontalScrollbar", "mState", "getMState$annotations", "mDragState", "getMDragState$annotations", "mVerticalRange", "", "mHorizontalRange", "mShowHideAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "mAnimationState", "getMAnimationState$annotations", "mHideRunnable", "Ljava/lang/Runnable;", "mOnScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "attachToRecyclerView", "", "setupCallbacks", "destroyCallbacks", "requestRedraw", "setState", "state", "isLayoutRTL", "isDragging", "()Z", "isVisible", "isHidden", "show", "hide", "duration", "cancelHide", "resetHideDelay", "delay", "onDrawOver", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawVerticalScrollbar", "drawHorizontalScrollbar", "updateScrollPosition", "offsetX", "offsetY", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "me", "onRequestDisallowInterceptTouchEvent", "disallowIntercept", "verticalScrollTo", "yPoint", "horizontalScrollTo", "xPoint", "scrollTo", "oldDragPos", "newDragPos", "scrollbarRange", "scrollRange", "scrollOffset", "viewLength", "isPointInsideVerticalThumb", "x", "y", "isPointInsideHorizontalThumb", "horizontalThumbDrawable", "getHorizontalThumbDrawable", "verticalThumbDrawable", "getVerticalThumbDrawable", "verticalRange", "getVerticalRange", "()[I", "horizontalRange", "getHorizontalRange", "State", "DragState", "AnimationState", "AnimatorListener", "AnimatorUpdater", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] D = null;
    public static final int[] E = null;
    public int A;
    public final d B;
    public final boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateListDrawable f448129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f448130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateListDrawable f448131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f448132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f448133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f448134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f448135g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f448136h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f448137i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f448138j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f448139k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f448140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f448141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f448142n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f448143o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f448144p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f448145q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f448146r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public RecyclerView f448147s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f448148t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f448149u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f448150v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f448151w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f448152x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int[] f448153y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ValueAnimator f448154z;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/FastScroller$AnimationState;", "", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AnimationState {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/FastScroller$DragState;", "", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DragState {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/FastScroller$State;", "", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface State {
    }

    public final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f448155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FastScroller f448156b;

        public a(FastScroller r100) {
            this.f448156b = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f448155a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f448155a == false) goto L6;
            this.f448155a = false;
            return;
        L6:
            Object r101 = this.f448156b.f448154z.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            if (((Float) r101).floatValue() != 0.0f) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L12;
            FastScroller r103 = this.f448156b;
            r103.A = 0;
            r103.setState(0);
            return;
        L12:
            FastScroller r104 = this.f448156b;
            r104.A = 2;
            r104.requestRedraw();
            return;
        L9:
            r102 = false;
            goto L10
        }
    }

    public final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FastScroller f448157a;

        public b(FastScroller r100) {
            this.f448157a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "valueAnimator");
            Object r101 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
            int r102 = (int) (255 * ((Float) r101).floatValue());
            this.f448157a.f448129a.setAlpha(r102);
            this.f448157a.f448130b.setAlpha(r102);
            this.f448157a.requestRedraw();
        }
    }

    public static final class c {
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FastScroller f448158a;

        public d(FastScroller r100) {
            this.f448158a = r100;
        }

        public final void a() {
            FastScroller r100 = this.f448158a;
            int r101 = r100.A;
            if (r101 == 1) goto L7;
            if (r101 != 2) goto L10;
            r100.A = 3;
            ValueAnimator r102 = r100.f448154z;
            Object r103 = r102.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            r102.setFloatValues(new float[]{((Float) r103).floatValue(), 0.0f});
            r100.f448154z.setDuration(500);
            r100.f448154z.start();
            return;
        L10:
            return;
        L7:
            r100.f448154z.cancel();
            r100.A = 3;
            ValueAnimator r104 = r100.f448154z;
            Object r105 = r104.getAnimatedValue();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Float");
            r104.setFloatValues(new float[]{((Float) r105).floatValue(), 0.0f});
            r100.f448154z.setDuration(500);
            r100.f448154z.start();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    static {
        D = new int[]{R.attr.state_pressed};
        E = new int[0];
    }

    public final void requestRedraw() {
        RecyclerView r100 = this.f448147s;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r100 = null;
    L5:
        r100.invalidate();
    }

    public final void show() {
        int r100 = this.A;
        if (r100 != 0) goto L5;
        this.A = 1;
        ValueAnimator r101 = this.f448154z;
        Object r110 = r101.getAnimatedValue();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type kotlin.Float");
        r101.setFloatValues(new float[]{((Float) r110).floatValue(), 1.0f});
        this.f448154z.setDuration(500);
        this.f448154z.setStartDelay(0);
        this.f448154z.start();
        return;
    L5:
        if (r100 != 3) goto L11;
        this.f448154z.cancel();
        this.A = 1;
        ValueAnimator r102 = this.f448154z;
        Object r111 = r102.getAnimatedValue();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type kotlin.Float");
        r102.setFloatValues(new float[]{((Float) r111).floatValue(), 1.0f});
        this.f448154z.setDuration(500);
        this.f448154z.setStartDelay(0);
        this.f448154z.start();
        return;
    }

    public final void setState(int r100) {
        RecyclerView r101 = null;
        if (r100 == 2) goto L5;
    L10:
        if (r100 != 0) goto L12;
        requestRedraw();
    L14:
        if (this.f448150v != 2) goto L25;
        if (r100 == 2) goto L25;
        this.f448129a.setState(E);
        RecyclerView r102 = this.f448147s;
        if (r102 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r102 = null;
    L19:
        r102.removeCallbacks(this.B);
        RecyclerView r103 = this.f448147s;
        if (r103 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L23:
        r101.postDelayed(this.B, 1200);
    L34:
        this.f448150v = r100;
        return;
    L22:
        r101 = r103;
    L25:
        if (r100 != 1) goto L34;
        RecyclerView r104 = this.f448147s;
        if (r104 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L29:
        r104.removeCallbacks(this.B);
        RecyclerView r105 = this.f448147s;
        if (r105 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L33:
        r101.postDelayed(this.B, 1500);
        goto L34
    L32:
        r101 = r105;
        goto L33
    L12:
        show();
        goto L14
    L5:
        if (this.f448150v == 2) goto L10;
        this.f448129a.setState(D);
        RecyclerView r106 = this.f448147s;
        if (r106 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r106 = null;
    L9:
        r106.removeCallbacks(this.B);
        goto L10
    }

    public final boolean isPointInsideHorizontalThumb(float r100, float r101) {
        if (r101 < (this.f448146r - this.f448137i)) goto L9;
        int r102 = this.f448143o;
        int r103 = this.f448142n;
        if (r100 < (r102 - (r103 / 2))) goto L9;
        if (r100 > (r102 + (r103 / 2))) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isPointInsideVerticalThumb(float r100, float r101) {
        if (this.C == false) goto L8;
        if (r100 <= (this.f448135g / 2)) goto L9;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L17;
        int r103 = this.f448140l;
        int r104 = this.f448139k;
        if (r101 < (r103 - (r104 / 2))) goto L17;
        if (r101 > (r103 + (r104 / 2))) goto L17;
        return true;
    L17:
        return false;
    L9:
        r102 = true;
        goto L11
    L8:
        if (r100 < (this.f448145q - this.f448135g)) goto L10;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "ev");
        int r102 = this.f448150v;
        if (r102 != 1) goto L14;
        boolean r103 = isPointInsideVerticalThumb(r101.getX(), r101.getY());
        boolean r104 = isPointInsideHorizontalThumb(r101.getX(), r101.getY());
        if (r101.getAction() != 0) goto L16;
        if (r103 == true) goto L8;
        if (r104 == true) goto L8;
        return false;
    L8:
        if (r104 == false) goto L10;
        this.f448151w = 1;
        this.f448144p = (int) r101.getX();
    L12:
        setState(2);
    L13:
        return true;
    L10:
        if (r103 == false) goto L12;
        this.f448151w = 2;
        this.f448141m = (int) r101.getY();
        goto L12
    L16:
        return false;
    L14:
        if (r102 == 2) goto L13;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, "recyclerView");
        Intrinsics.checkNotNullParameter(r111, "me");
        if (this.f448150v != 0) goto L6;
        return;
    L6:
        if (r111.getAction() != 0) goto L16;
        boolean r112 = isPointInsideVerticalThumb(r111.getX(), r111.getY());
        boolean r100 = isPointInsideHorizontalThumb(r111.getX(), r111.getY());
        if (r112 == true) goto L10;
        if (r100 == true) goto L10;
        return;
    L10:
        if (r100 == false) goto L12;
        this.f448151w = 1;
        this.f448144p = (int) r111.getX();
    L14:
        setState(2);
        return;
    L12:
        if (r112 == false) goto L14;
        this.f448151w = 2;
        this.f448141m = (int) r111.getY();
        goto L14
    L16:
        if (r111.getAction() != 1) goto L21;
        if (this.f448150v != 2) goto L21;
        this.f448141m = 0.0f;
        this.f448144p = 0.0f;
        setState(1);
        this.f448151w = 0;
        return;
    L21:
        if (r111.getAction() == 2) goto L23;
        return;
    L23:
        if (this.f448150v != 2) goto L66;
        show();
        RecyclerView r101 = null;
        if (this.f448151w != 1) goto L43;
        float r113 = r111.getX();
        int[] r102 = this.f448153y;
        int r103 = this.f448134f;
        r102[0] = r103;
        int r104 = this.f448145q - r103;
        r102[1] = r104;
        float r114 = Math.max(r103, (int) Math.min(r104, r113));
        if (Math.abs(this.f448143o - r114) < 2.0f) goto L43;
        float r105 = this.f448144p;
        RecyclerView r106 = this.f448147s;
        if (r106 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r106 = null;
    L32:
        int r107 = r106.computeHorizontalScrollRange();
        RecyclerView r108 = this.f448147s;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r108 = null;
    L35:
        int r109 = h(r105, r114, r102, r107, r108.computeHorizontalScrollOffset(), this.f448145q);
        if (r109 == 0) goto L41;
        RecyclerView r115 = this.f448147s;
        if (r115 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r115 = null;
    L40:
        r115.scrollBy(r109, 0);
    L41:
        this.f448144p = r114;
    L43:
        if (this.f448151w != 2) goto L67;
        float r116 = r111.getY();
        int[] r117 = this.f448152x;
        int r118 = this.f448134f;
        r117[0] = r118;
        int r119 = this.f448146r - r118;
        r117[1] = r119;
        float r120 = Math.max(r118, (int) Math.min(r119, r116));
        if (Math.abs(this.f448140l - r120) < 2.0f) goto L68;
        float r121 = this.f448141m;
        RecyclerView r122 = this.f448147s;
        if (r122 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r122 = null;
    L50:
        int r123 = r122.computeVerticalScrollRange();
        RecyclerView r124 = this.f448147s;
        if (r124 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r124 = null;
    L53:
        int r125 = h(r121, r120, r117, r123, r124.computeVerticalScrollOffset(), this.f448146r);
        if (r125 == 0) goto L60;
        RecyclerView r126 = this.f448147s;
        if (r126 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L59:
        r101.scrollBy(0, r125);
        goto L60
    L58:
        r101 = r126;
    L60:
        this.f448141m = r120;
        return;
    L68:
        return;
    L67:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, "parent");
        Intrinsics.checkNotNullParameter(r102, "state");
        RecyclerView r103 = this.f448147s;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r103 = null;
    L6:
        if (this.f448145q == r103.getWidth()) goto L8;
    L22:
        this.f448145q = r103.getWidth();
        this.f448146r = r103.getHeight();
        setState(0);
        return;
    L8:
        if (this.f448146r != r103.getHeight()) goto L22;
        if (this.A != 0) goto L13;
        return;
    L13:
        if (this.f448148t == false) goto L19;
        int r104 = this.f448145q;
        int r105 = this.f448135g;
        int r106 = r104 - r105;
        int r107 = this.f448140l;
        int r108 = this.f448139k;
        int r109 = r107 - (r108 / 2);
        this.f448129a.setBounds(0, 0, r105, r108);
        this.f448130b.setBounds(0, 0, this.f448136h, this.f448146r);
        if (this.C == false) goto L17;
        this.f448130b.draw(r100);
        float r110 = r109;
        r100.translate(this.f448135g, r110);
        r100.scale(-1.0f, 1.0f);
        this.f448129a.draw(r100);
        r100.scale(1.0f, 1.0f);
        r100.translate(-this.f448135g, -r110);
        goto L19
    L17:
        float r111 = r106;
        r100.translate(r111, 0.0f);
        this.f448130b.draw(r100);
        float r112 = r109;
        r100.translate(0.0f, r112);
        this.f448129a.draw(r100);
        r100.translate(-r111, -r112);
    L19:
        if (this.f448149u == false) goto L25;
        int r113 = this.f448146r;
        int r114 = this.f448137i;
        int r115 = this.f448143o;
        int r116 = this.f448142n;
        this.f448131c.setBounds(0, 0, r116, r114);
        this.f448132d.setBounds(0, 0, this.f448145q, this.f448138j);
        float r117 = r113 - r114;
        r100.translate(0.0f, r117);
        this.f448132d.draw(r100);
        float r118 = r115 - (r116 / 2);
        r100.translate(r118, 0.0f);
        this.f448131c.draw(r100);
        r100.translate(-r118, -r117);
        return;
    }

    public static int h(float r100, float r101, int[] r102, int r103, int r104, int r105) {
        boolean r106 = true;
        int r107 = r102[1] - r102[0];
        if (r107 != 0) goto L5;
        return 0;
    L5:
        int r108 = r103 - r105;
        int r109 = (int) (((r101 - r100) / r107) * r108);
        int r110 = r104 + r109;
        if (r110 < 0) goto L9;
        if (r110 >= r108) goto L9;
    L10:
        if (r106 == true) goto L12;
        return 0;
    L12:
        return r109;
    L9:
        r106 = false;
        goto L10
    }

    public FastScroller(RecyclerView r110, StateListDrawable r111, Drawable r112, StateListDrawable r113, Drawable r210, int r211, int r212, int r213) {
        RecyclerView r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r111, "mVerticalThumbDrawable");
        Intrinsics.checkNotNullParameter(r112, "verticalTrackDrawable");
        Intrinsics.checkNotNullParameter(r113, "mHorizontalThumbDrawable");
        Intrinsics.checkNotNullParameter(r210, "horizontalTrackDrawable");
        this.f448129a = r111;
        this.f448130b = r112;
        this.f448131c = r113;
        this.f448132d = r210;
        this.f448152x = new int[2];
        this.f448153y = new int[2];
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f448154z = r101;
        d r102 = new d(this);
        this.B = r102;
        RecyclerView.OnScrollListener r114 = new FastScroller$mOnScrollListener$1(this);
        RecyclerView r115 = this.f448147s;
        RecyclerView r116 = null;
        if (r115 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r115 = null;
    L5:
        boolean r117 = true;
        if (ViewCompat.getLayoutDirection(r115) == 1) goto L9;
        r117 = false;
    L9:
        this.C = r117;
        this.f448135g = Math.max(r211, r111.getIntrinsicWidth());
        this.f448136h = Math.max(r211, r112.getIntrinsicWidth());
        this.f448137i = Math.max(r211, r113.getIntrinsicWidth());
        this.f448138j = Math.max(r211, r210.getIntrinsicWidth());
        this.f448133e = r212;
        this.f448134f = r213;
        r111.setAlpha(255);
        r112.setAlpha(255);
        r101.addListener(new a(this));
        r101.addUpdateListener(new b(this));
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        RecyclerView r103 = this.f448147s;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r103 = null;
    L12:
        if (r103 == r100) goto L38;
        RecyclerView r104 = this.f448147s;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L17:
        r104.removeItemDecoration(this);
        RecyclerView r105 = this.f448147s;
        if (r105 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r105 = null;
    L20:
        r105.removeOnItemTouchListener(this);
        RecyclerView r106 = this.f448147s;
        if (r106 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r106 = null;
    L23:
        r106.removeOnScrollListener(r114);
        RecyclerView r107 = this.f448147s;
        if (r107 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r107 = null;
    L26:
        r107.removeCallbacks(r102);
        this.f448147s = r100;
        if (r100 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r100 = null;
    L29:
        r100.addItemDecoration(this);
        RecyclerView r108 = this.f448147s;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r108 = null;
    L32:
        r108.addOnItemTouchListener(this);
        RecyclerView r109 = this.f448147s;
        if (r109 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L36:
        r116.addOnScrollListener(r114);
        return;
    L35:
        r116 = r109;
        goto L36
    }
}
