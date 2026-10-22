package com.bytedance.ee.bear.tts.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uo5.d;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/tts/view/FloatViewContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialX", "", "initialY", "startX", "startY", "isDragging", "", "touchSlop", "statusBarHeight", "containerWidth", "containerHeight", "activityObserver", "Lcom/ss/android/lark/appcontext/applifecycle/ActivityObserver;", "onAttachedToWindow", "", "showInTopActivity", "view", "Landroid/view/View;", "addToTopActivity", "removeFromTopActivity", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "resumeAttachPosition", "ensureValidPosition", "attachToEdge", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleActionDown", "handleActionMove", "handleActionUpOrCancel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatViewContainer extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f239786k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static float f239787l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f239788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f239789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f239790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f239791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f239792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f239793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f239794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f239795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f239796i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.ss.android.lark.appcontext.applifecycle.a f239797j;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FloatViewContainer f239798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f239799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.MarginLayoutParams f239800c;

        public b(FloatViewContainer r100, ViewGroup r101, ViewGroup.MarginLayoutParams r102) {
            this.f239798a = r100;
            this.f239799b = r101;
            this.f239800c = r102;
        }

        public final void a() {
            int r100 = 0;
            this.f239798a.setVisibility(0);
            if (this.f239798a.getMeasuredWidth() > 0) goto L5;
            return;
        L5:
            if (this.f239798a.getMeasuredHeight() <= 0) goto L14;
            this.f239798a.f239795h = this.f239799b.getWidth();
            this.f239798a.f239796i = this.f239799b.getHeight();
            if (FloatViewContainer.f239786k == false) goto L10;
            FloatViewContainer r101 = this.f239798a;
            r100 = r101.f239795h - r101.getWidth();
            float r102 = -Math.abs(this.f239798a.getTranslationX());
            int r103 = R.drawable.ccm_shape_float_round_pin_left;
        L11:
            d.a(this.f239798a, r103);
            this.f239798a.setTranslationX(r102);
            ViewGroup.MarginLayoutParams r104 = this.f239800c;
            FloatViewContainer r105 = this.f239798a;
            r104.rightMargin = r100;
            r104.topMargin = (int) (r105.f239796i * FloatViewContainer.f239787l);
            r105.requestLayout();
            return;
        L10:
            r102 = Math.abs(this.f239798a.getTranslationX());
            r103 = R.drawable.ccm_shape_float_round_pin_right;
            goto L11
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

    public FloatViewContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatViewContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        f239787l = 0.5f;
    }

    public final void a() {
        Activity r100 = AppLifecycle.a.f408803a.f();
        ViewGroup r101 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        View r103 = r102.getWindow().getDecorView();
        if (c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == c.f346341a) goto L14;
        c.a(r104, "getDecorView");
    L14:
        if ((r103 instanceof FrameLayout) == false) goto L16;
        FrameLayout r105 = (FrameLayout) r103;
    L17:
        if (r105 != null) goto L19;
        return;
    L19:
        tt5.a.h("FloatViewContainer", "addToTopActivity, activity: ".concat(r102.getClass().getSimpleName()));
        Intrinsics.checkNotNullParameter(r105, "<this>");
        Intrinsics.checkNotNullParameter(this, "view");
        if (Intrinsics.areEqual(getParent(), r105) == true) goto L29;
        ViewParent r106 = getParent();
        if ((r106 instanceof ViewGroup) == false) goto L25;
        r101 = (ViewGroup) r106;
    L25:
        if (r101 == null) goto L27;
        r101.removeView(this);
    L27:
        r105.addView(this);
        return;
    L29:
        return;
    L16:
        r105 = null;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    public final void c() {
        ViewGroup.LayoutParams r100 = getLayoutParams();
        ViewGroup r101 = null;
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r100;
    L6:
        if (r102 == null) goto L14;
        r102.rightMargin = 0;
        r102.topMargin = 0;
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == false) goto L10;
        r101 = (ViewGroup) r103;
    L10:
        if (r101 != null) goto L12;
        return;
    L12:
        post(new b(this, r101, r102));
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        tt5.a.h("FloatViewContainer", "removeFromTopActivity");
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L8;
        r102.removeView(this);
    L8:
        ViewParent r103 = getParent();
        if ((r103 instanceof ViewGroup) == false) goto L11;
        ViewGroup r104 = (ViewGroup) r103;
    L12:
        if (r104 == null) goto L14;
        r104.removeView(this);
    L14:
        com.ss.android.lark.appcontext.applifecycle.a r105 = this.f239797j;
        if (r105 == null) goto L17;
        AppLifecycle.a.f408803a.j(r105);
    L17:
        this.f239797j = null;
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        tt5.a.h("FloatViewContainer", "onConfigurationChanged, screenWidth: " + r100.screenWidthDp + ", screenHeight: " + r100.screenHeightDp);
        c();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        boolean r102 = false;
        if (r101 != 0) goto L5;
        this.f239788a = r100.getRawX();
        this.f239789b = r100.getRawY();
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
    L25:
        if (r104 == null) goto L27;
        int r105 = r104.rightMargin;
    L28:
        this.f239790c = r105;
        if (r104 == null) goto L31;
        int r106 = r104.topMargin;
    L32:
        this.f239791d = r106;
        this.f239792e = false;
        return false;
    L31:
        r106 = getTop();
        goto L32
    L27:
        r105 = getRight();
        goto L28
    L24:
        r104 = null;
        goto L25
    L5:
        if (r101 != 2) goto L7;
        float r107 = Math.abs(r100.getRawX() - this.f239788a);
        float r108 = Math.abs(r100.getRawY() - this.f239789b);
        if (this.f239792e == true) goto L17;
        int r109 = this.f239793f;
        if (r107 <= r109) goto L13;
    L14:
        r102 = true;
    L15:
        this.f239792e = r102;
        goto L17
    L13:
        if (r108 <= r109) goto L15;
    L17:
        if (this.f239792e == false) goto L19;
        d.a(this, R.drawable.ccm_shape_float_round);
    L19:
        tt5.a.h("FloatViewContainer", "onInterceptTouchEvent, ACTION_MOVE, isDragging: " + this.f239792e + ", dx: " + r107 + ", dy: " + r108);
        return this.f239792e;
    L7:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        FrameLayout.LayoutParams r102 = null;
        ViewGroup.MarginLayoutParams r103 = null;
        boolean r104 = false;
        if (r101 == 1) goto L30;
        if (r101 != 2) goto L6;
        float r105 = r100.getRawX() - this.f239788a;
        float r106 = r100.getRawY() - this.f239789b;
        int r107 = (int) (this.f239790c - r105);
        int r108 = (int) (this.f239791d + r106);
        ViewGroup.LayoutParams r109 = getLayoutParams();
        if ((r109 instanceof FrameLayout.LayoutParams) == false) goto L11;
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109;
    L12:
        if (r110 == null) goto L15;
        r110.rightMargin = r107;
        r110.topMargin = r108;
    L15:
        if (getMeasuredWidth() > 0) goto L17;
    L28:
        requestLayout();
        tt5.a.b("FloatViewContainer", "handleActionMove, newX: " + r107 + ", newY: " + r108);
        return true;
    L17:
        if (getMeasuredHeight() <= 0) goto L28;
        ViewGroup.LayoutParams r111 = getLayoutParams();
        if ((r111 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        r103 = (ViewGroup.MarginLayoutParams) r111;
    L22:
        if (r103 == null) goto L28;
        int r112 = r103.topMargin;
        int r113 = this.f239794g;
        if (r112 >= r113) goto L27;
        r103.topMargin = r113;
    L27:
        r103.topMargin = RangesKt.coerceIn(r103.topMargin, 0, this.f239796i - getHeight());
        r103.rightMargin = RangesKt.coerceIn(r103.rightMargin, 0, this.f239795h - getWidth());
        goto L28
    L11:
        r110 = null;
        goto L12
    L6:
        if (r101 == 3) goto L30;
        return super.onTouchEvent(r100);
    L30:
        if (this.f239792e == false) goto L47;
        tt5.a.h("FloatViewContainer", "attachToEdge");
        ViewGroup.LayoutParams r114 = getLayoutParams();
        if ((r114 instanceof FrameLayout.LayoutParams) == false) goto L34;
        r102 = (FrameLayout.LayoutParams) r114;
    L34:
        if (r102 == null) goto L45;
        Rect r115 = new Rect();
        getGlobalVisibleRect(r115);
        int r116 = r115.left + (getWidth() / 2);
        int r117 = this.f239795h;
        if (r116 >= (r117 / 2)) goto L39;
        boolean r118 = true;
    L40:
        f239786k = r118;
        f239787l = r102.topMargin / this.f239796i;
        int r119 = r102.rightMargin;
        if (r118 == false) goto L43;
        int r120 = r117 - getWidth();
        float r121 = -Math.abs(getTranslationX());
        int r122 = R.drawable.ccm_shape_float_round_pin_left;
    L44:
        ValueAnimator r123 = ValueAnimator.ofInt(new int[]{r119, r120});
        r123.addUpdateListener(new uo5.a(r102, this));
        r123.addListener(new uo5.b(this, r122, r121));
        r123.setDuration(300);
        r123.start();
        goto L45
    L43:
        r121 = Math.abs(getTranslationX());
        r122 = R.drawable.ccm_shape_float_round_pin_right;
        r120 = 0;
        goto L44
    L39:
        r118 = false;
    L45:
        this.f239792e = false;
        r104 = true;
    L47:
        return r104;
    }

    public FloatViewContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f239793f = ViewConfiguration.get(r100).getScaledTouchSlop();
        setVisibility(4);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = GravityCompat.END;
        setLayoutParams(r103);
        com.ss.android.lark.forsetiutils.b.f424768a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r104 = r100.getResources();
        int r105 = (int) ((5.5f * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density) + 0.5f);
        setPadding(r105, r105, r105, r105);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Resources r106 = r100.getResources();
        setTranslationX((int) ((5.0f * WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density) + 0.5f));
        this.f239794g = DeviceUtils.getStatusHeight(r100);
        c();
    }

    public /* synthetic */ FloatViewContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
