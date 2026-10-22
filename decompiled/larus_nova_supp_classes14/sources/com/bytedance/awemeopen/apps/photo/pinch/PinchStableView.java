package com.bytedance.awemeopen.apps.photo.pinch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\b\r,\u0010B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0016¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR#\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR#\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010 \u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView$c;", "listener", "", "setGestureListener", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot", "b", "getDisplayRoot", "displayRoot", "c", "getPinchBtmBar", "pinchBtmBar", "d", "getGestureRoot", "gestureRoot", "", "e", "getStatusHeight", "()I", "statusHeight", "f", "getBtmBarHeight", "btmBarHeight", "g", "getTouchSlop", "touchSlop", "getDisplayHeight", "displayHeight", "getDisplayWidth", "displayWidth", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Gesture", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class PinchStableView extends FrameLayout {
    public static final /* synthetic */ int k = 0;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public c h;
    public final GestureDetector i;
    public final GestureDetector j;

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView$Gesture;", "", "Companion", "a", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Gesture {
        public static final a Companion = null;
        public static final String PULL_DOWN = "slide_down";
        public static final String PULL_UP = "slide_up";
        public static final String SLIDE_RIGHT = "slide_right";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public static final class a {
    }

    public static final class b implements c {
        public b() {
        }

        @Override // com.bytedance.awemeopen.apps.photo.pinch.PinchStableView.c
        public final boolean b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "gesture");
            return false;
        }
    }

    public interface c {
        boolean b(String r1);
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ Function0<Unit> a;

        public d(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.invoke();
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ PinchStableView a;
        public final /* synthetic */ Function0<Unit> b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.setVisibility(8);
            this.b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.setVisibility(8);
            this.b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animator");
            this.a.k(false);
        }

        public e(PinchStableView r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {
        public final /* synthetic */ PinchStableView a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            return false;
        }

        public f(PinchStableView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            if (r2 == null) goto L14;
            if (r3 == null) goto L14;
            float r6 = r3.getY() - r2.getY();
            float r7 = r3.getX() - r2.getX();
            if (r7 <= 150.0f) goto L14;
            if (r6 <= (-PinchStableView.g(this.a))) goto L14;
            if ((Math.abs(r6) / r7) >= 1.0f) goto L14;
            return this.a.h.b(Gesture.SLIDE_RIGHT);
        L14:
            return false;
        }
    }

    public static final class g extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {
        public final /* synthetic */ PinchStableView a;

        public g(PinchStableView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
            if (r2 == null) goto L16;
            if (r3 == null) goto L16;
            float r6 = r3.getY() - r2.getY();
            float r7 = r3.getX() - r2.getX();
            if (Math.abs(r6) <= 150.0f) goto L16;
            if ((Math.abs(r7) / Math.abs(r6)) >= 1.0f) goto L16;
            c r8 = this.a.h;
            if (r6 <= 0.0f) goto L13;
            String r9 = Gesture.PULL_DOWN;
        L15:
            return r8.b(r9);
        L13:
            r9 = Gesture.PULL_UP;
        L16:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            PinchStableView r5 = this.a;
            int r6 = PinchStableView.k;
            r5.getClass();
            return false;
        }
    }

    static {
    }

    public PinchStableView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PinchStableView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final int getBtmBarHeight() {
        return ((Number) this.f.getValue()).intValue();
    }

    private final ViewGroup getContentRoot() {
        return (ViewGroup) this.a.getValue();
    }

    private final ViewGroup getDisplayRoot() {
        return (ViewGroup) this.b.getValue();
    }

    private final ViewGroup getGestureRoot() {
        return (ViewGroup) this.d.getValue();
    }

    private final ViewGroup getPinchBtmBar() {
        return (ViewGroup) this.c.getValue();
    }

    private final int getStatusHeight() {
        return ((Number) this.e.getValue()).intValue();
    }

    private final int getTouchSlop() {
        return ((Number) this.g.getValue()).intValue();
    }

    private final int getDisplayHeight() {
        return (getContentRoot().getHeight() - getBtmBarHeight()) - getStatusHeight();
    }

    private final int getDisplayWidth() {
        return getContentRoot().getWidth();
    }

    public final void h() {
        com.bytedance.awemeopen.apps.photo.pinch.e.b(getDisplayRoot(), new PinchStableView$adaptDisplayLP$1(this));
    }

    public static final /* synthetic */ int e(PinchStableView r0) {
        return r0.getBtmBarHeight();
    }

    public static final /* synthetic */ ViewGroup f(PinchStableView r0) {
        return r0.getContentRoot();
    }

    public static final /* synthetic */ int g(PinchStableView r0) {
        return r0.getTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "ev");
        r10.getActionMasked();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        if (this.j.onTouchEvent(r10) == false) goto L6;
        long r3 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        super.dispatchTouchEvent(MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0));     // Catch: Throwable -> L9
        boolean r11 = true;
    L7:
        Object r12 = Result.constructor-impl(Boolean.valueOf(r11));     // Catch: Throwable -> L9
    L11:
        Boolean r1 = Boolean.FALSE;
        if (Result.isFailure-impl(r12) == false) goto L15;
        r12 = r1;
    L15:
        return ((Boolean) r12).booleanValue();
    L6:
        r11 = super.dispatchTouchEvent(r10);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void k(boolean r3) {
        ViewGroup r0 = getPinchBtmBar();
        if (r3 == false) goto L5;
        float r1 = 1.0f;
    L6:
        r0.setAlpha(r1);
        ViewGroup r2 = getPinchBtmBar();
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        r2.setVisibility(r4);
        return;
    L9:
        r4 = 8;
        goto L10
    L5:
        r1 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        if (r2 == null) goto L5;
        this.i.onTouchEvent(r2);
    L5:
        return super.onTouchEvent(r2);
    }

    public final void setGestureListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.h = r2;
    }

    public static void a(PinchStableView r1, final ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r1.getDisplayRoot(), new PinchStableView$enter$1$1$1(r2));
    }

    public static void b(PinchStableView r1, final ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r1.getDisplayRoot(), new PinchStableView$exit$1$1$1(r2));
    }

    public static void c(PinchStableView r1, final ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r1.getDisplayRoot(), new PinchStableView$enter$animBuilder$1$1$1(r2));
    }

    public static void d(PinchStableView r1, final ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r1.getDisplayRoot(), new PinchStableView$exit$animBuilder$1$1$1(r2));
    }

    public PinchStableView(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$contentRoot$2(this));
        this.b = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$displayRoot$2(this));
        this.c = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$pinchBtmBar$2(this));
        this.d = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$gestureRoot$2(this));
        this.e = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$statusHeight$2(r2));
        this.f = com.bytedance.awemeopen.apps.photo.pinch.e.a(PinchStableView$btmBarHeight$2.INSTANCE);
        this.g = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$touchSlop$2(r2));
        this.h = new b();
        this.i = new GestureDetector(r2, new f(this));
        this.j = new GestureDetector(r2, new g(this));
    }

    public /* synthetic */ PinchStableView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void i(int r6, int r7, boolean r8, final Function0<Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "onEnterEnd");
        setVisibility(0);
        if (r8 == true) goto L6;
        h();
        k(true);
        r9.invoke();
        return;
    L6:
        Function0<Unit> r10 = new PinchStableView$enter$onAnimEnd$1(r9, this);
        AnimatorSet r11 = new AnimatorSet().setDuration(250);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{r6, getDisplayHeight()});
        r12.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.a(this));
        AnimatorSet.Builder r13 = r11.play(r12);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{r7 - getStatusHeight(), 0});
        r14.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.b(this));
        r13.with(r14);
        ObjectAnimator r15 = ObjectAnimator.ofFloat(getPinchBtmBar(), "alpha", new float[]{0.0f, 1.0f});
        k(true);
        r13.with(r15);
        r11.addListener(new d(r10));
        r11.start();
    }

    public final void j(int r5, int r6, boolean r7, final Function0<Unit> r8) {
        Intrinsics.checkNotNullParameter(r8, "onExitEnd");
        int r9 = r6 - getStatusHeight();
        if (r7 == true) goto L6;
        h();
        setVisibility(8);
        k(false);
        r8.invoke();
        return;
    L6:
        Function0<Unit> r10 = new PinchStableView$exit$onAnimEnd$1(r8, this);
        AnimatorSet r11 = new AnimatorSet().setDuration(250);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{getDisplayHeight(), r5});
        r12.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.c(this));
        AnimatorSet.Builder r13 = r11.play(r12);
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{0, r9});
        r14.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.d(this));
        r13.with(r14);
        r11.addListener(new e(this, r10));
        r11.start();
    }
}
