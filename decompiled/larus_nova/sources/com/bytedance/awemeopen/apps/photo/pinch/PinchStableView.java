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
import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\b\r,\u0010B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0016¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR#\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR#\u0010\u0015\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001b\u0010\u001a\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u0019R\u001b\u0010 \u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010$\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019¨\u0006-"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView$c;", "listener", "", "setGestureListener", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot", "b", "getDisplayRoot", "displayRoot", "c", "getPinchBtmBar", "pinchBtmBar", "d", "getGestureRoot", "gestureRoot", "", "e", "getStatusHeight", "()I", "statusHeight", "f", "getBtmBarHeight", "btmBarHeight", ce.f26391f, "getTouchSlop", "touchSlop", "getDisplayHeight", "displayHeight", "getDisplayWidth", "displayWidth", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Gesture", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class PinchStableView extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f197789k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f197790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f197791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f197792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f197793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f197794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f197795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f197796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f197797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GestureDetector f197798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final GestureDetector f197799j;

    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/pinch/PinchStableView$Gesture;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Gesture {
        public static final a Companion = null;
        public static final String PULL_DOWN = "slide_down";
        public static final String PULL_UP = "slide_up";
        public static final String SLIDE_RIGHT = "slide_right";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f197800a = null;

            static {
                f197800a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f197800a;
        }
    }

    public static final class a {
    }

    public static final class b implements c {
        public b() {
        }

        @Override // com.bytedance.awemeopen.apps.photo.pinch.PinchStableView.c
        public final boolean b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "gesture");
            return false;
        }
    }

    public interface c {
        boolean b(String r100);
    }

    public static final class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f197801a;

        public d(Function0<Unit> r100) {
            this.f197801a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f197801a.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f197801a.invoke();
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinchStableView f197802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f197803b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f197802a.setVisibility(8);
            this.f197803b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f197802a.setVisibility(8);
            this.f197803b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f197802a.k(false);
        }

        public e(PinchStableView r100, Function0<Unit> r101) {
            this.f197802a = r100;
            this.f197803b = r101;
        }
    }

    public static final class f extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinchStableView f197804a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            return false;
        }

        public f(PinchStableView r100) {
            this.f197804a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            if (r100 == null) goto L14;
            if (r101 == null) goto L14;
            float r104 = r101.getY() - r100.getY();
            float r105 = r101.getX() - r100.getX();
            if (r105 <= 150.0f) goto L14;
            if (r104 <= (-PinchStableView.g(this.f197804a))) goto L14;
            if ((Math.abs(r104) / r105) >= 1.0f) goto L14;
            return this.f197804a.f197797h.b(Gesture.SLIDE_RIGHT);
        L14:
            return false;
        }
    }

    public static final class g extends com.bytedance.awemeopen.apps.framework.feed.pinch.utils.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PinchStableView f197805a;

        public g(PinchStableView r100) {
            this.f197805a = r100;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            if (r100 == null) goto L16;
            if (r101 == null) goto L16;
            float r104 = r101.getY() - r100.getY();
            float r105 = r101.getX() - r100.getX();
            if (Math.abs(r104) <= 150.0f) goto L16;
            if ((Math.abs(r105) / Math.abs(r104)) >= 1.0f) goto L16;
            c r106 = this.f197805a.f197797h;
            if (r104 <= 0.0f) goto L13;
            String r107 = "slide_down";
        L15:
            return r106.b(r107);
        L13:
            r107 = Gesture.PULL_UP;
        L16:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            PinchStableView r104 = this.f197805a;
            int r105 = PinchStableView.f197789k;
            r104.getClass();
            return false;
        }
    }

    static {
    }

    public PinchStableView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PinchStableView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final int getBtmBarHeight() {
        return ((Number) this.f197795f.getValue()).intValue();
    }

    private final ViewGroup getContentRoot() {
        return (ViewGroup) this.f197790a.getValue();
    }

    private final ViewGroup getDisplayRoot() {
        return (ViewGroup) this.f197791b.getValue();
    }

    private final ViewGroup getGestureRoot() {
        return (ViewGroup) this.f197793d.getValue();
    }

    private final ViewGroup getPinchBtmBar() {
        return (ViewGroup) this.f197792c.getValue();
    }

    private final int getStatusHeight() {
        return ((Number) this.f197794e.getValue()).intValue();
    }

    private final int getTouchSlop() {
        return ((Number) this.f197796g.getValue()).intValue();
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

    public static final /* synthetic */ int e(PinchStableView r100) {
        return r100.getBtmBarHeight();
    }

    public static final /* synthetic */ ViewGroup f(PinchStableView r100) {
        return r100.getContentRoot();
    }

    public static final /* synthetic */ int g(PinchStableView r100) {
        return r100.getTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        r110.getActionMasked();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        if (this.f197799j.onTouchEvent(r110) == false) goto L6;
        long r101 = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        super.dispatchTouchEvent(MotionEvent.obtain(r101, r101, 3, 0.0f, 0.0f, 0));     // Catch: Throwable -> L9
        boolean r111 = true;
    L7:
        Object r112 = Result.m9449constructorimpl(Boolean.valueOf(r111));     // Catch: Throwable -> L9
    L11:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r112) == false) goto L15;
        r112 = r102;
    L15:
        return ((Boolean) r112).booleanValue();
    L6:
        r111 = super.dispatchTouchEvent(r110);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void k(boolean r100) {
        ViewGroup r101 = getPinchBtmBar();
        if (r100 == false) goto L5;
        float r102 = 1.0f;
    L6:
        r101.setAlpha(r102);
        ViewGroup r103 = getPinchBtmBar();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r100 == false) goto L9;
        int r104 = 0;
    L10:
        r103.setVisibility(r104);
        return;
    L9:
        r104 = 8;
        goto L10
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L5;
        this.f197798i.onTouchEvent(r100);
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setGestureListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f197797h = r100;
    }

    public static void a(PinchStableView r100, final ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r100.getDisplayRoot(), new PinchStableView$enter$1$1$1(r101));
    }

    public static void b(PinchStableView r100, final ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r100.getDisplayRoot(), new PinchStableView$exit$1$1$1(r101));
    }

    public static void c(PinchStableView r100, final ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r100.getDisplayRoot(), new PinchStableView$enter$animBuilder$1$1$1(r101));
    }

    public static void d(PinchStableView r100, final ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        com.bytedance.awemeopen.apps.photo.pinch.e.b(r100.getDisplayRoot(), new PinchStableView$exit$animBuilder$1$1$1(r101));
    }

    public PinchStableView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f197790a = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$contentRoot$2(this));
        this.f197791b = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$displayRoot$2(this));
        this.f197792c = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$pinchBtmBar$2(this));
        this.f197793d = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$gestureRoot$2(this));
        this.f197794e = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$statusHeight$2(r100));
        this.f197795f = com.bytedance.awemeopen.apps.photo.pinch.e.a(PinchStableView$btmBarHeight$2.INSTANCE);
        this.f197796g = com.bytedance.awemeopen.apps.photo.pinch.e.a(new PinchStableView$touchSlop$2(r100));
        this.f197797h = new b();
        this.f197798i = new GestureDetector(r100, new f(this));
        this.f197799j = new GestureDetector(r100, new g(this));
    }

    public /* synthetic */ PinchStableView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void i(int r100, int r101, boolean r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "onEnterEnd");
        setVisibility(0);
        if (r102 == true) goto L6;
        h();
        k(true);
        r103.invoke();
        return;
    L6:
        Function0<Unit> r104 = new PinchStableView$enter$onAnimEnd$1(r103, this);
        AnimatorSet r105 = new AnimatorSet().setDuration(250);
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{r100, getDisplayHeight()});
        r106.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.a(this));
        AnimatorSet.Builder r107 = r105.play(r106);
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r101 - getStatusHeight(), 0});
        r108.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.b(this));
        r107.with(r108);
        ObjectAnimator r109 = ObjectAnimator.ofFloat(getPinchBtmBar(), "alpha", new float[]{0.0f, 1.0f});
        k(true);
        r107.with(r109);
        r105.addListener(new d(r104));
        r105.start();
    }

    public final void j(int r100, int r101, boolean r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "onExitEnd");
        int r104 = r101 - getStatusHeight();
        if (r102 == true) goto L6;
        h();
        setVisibility(8);
        k(false);
        r103.invoke();
        return;
    L6:
        Function0<Unit> r105 = new PinchStableView$exit$onAnimEnd$1(r103, this);
        AnimatorSet r106 = new AnimatorSet().setDuration(250);
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{getDisplayHeight(), r100});
        r107.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.c(this));
        AnimatorSet.Builder r108 = r106.play(r107);
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{0, r104});
        r109.addUpdateListener(new com.bytedance.awemeopen.apps.photo.pinch.d(this));
        r108.with(r109);
        r106.addListener(new e(this, r105));
        r106.start();
    }
}
