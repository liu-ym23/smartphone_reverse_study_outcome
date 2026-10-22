package com.bytedance.ee.bear.tts.view;

import android.animation.ValueAnimator;
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
import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import uo5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/ee/bear/tts/view/FloatViewContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initialX", "", "initialY", "startX", "startY", "isDragging", "", "touchSlop", "statusBarHeight", "containerWidth", "containerHeight", "activityObserver", "Lcom/ss/android/lark/appcontext/applifecycle/ActivityObserver;", "onAttachedToWindow", "", "showInTopActivity", "view", "Landroid/view/View;", "addToTopActivity", "removeFromTopActivity", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "resumeAttachPosition", "ensureValidPosition", "attachToEdge", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "handleActionDown", "handleActionMove", "handleActionUpOrCancel", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatViewContainer extends FrameLayout {
    public static boolean k;
    public static float l;
    public float a;
    public float b;
    public int c;
    public int d;
    public boolean e;
    public final int f;
    public final int g;
    public int h;
    public int i;
    public com.ss.android.lark.appcontext.applifecycle.a j;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FloatViewContainer a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ ViewGroup.MarginLayoutParams c;

        public b(FloatViewContainer r1, ViewGroup r2, ViewGroup.MarginLayoutParams r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            int r1 = 0;
            this.a.setVisibility(0);
            if (this.a.getMeasuredWidth() > 0) goto L5;
            return;
        L5:
            if (this.a.getMeasuredHeight() <= 0) goto L14;
            this.a.h = this.b.getWidth();
            this.a.i = this.b.getHeight();
            if (FloatViewContainer.k == false) goto L10;
            FloatViewContainer r0 = this.a;
            r1 = r0.h - r0.getWidth();
            float r2 = -Math.abs(this.a.getTranslationX());
            int r3 = 2131232576;
        L11:
            d.a(this.a, r3);
            this.a.setTranslationX(r2);
            ViewGroup.MarginLayoutParams r4 = this.c;
            FloatViewContainer r5 = this.a;
            r4.rightMargin = r1;
            r4.topMargin = (int) (r5.i * FloatViewContainer.l);
            r5.requestLayout();
            return;
        L10:
            r2 = Math.abs(this.a.getTranslationX());
            r3 = 2131232577;
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

    public FloatViewContainer(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FloatViewContainer(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        l = 0.5f;
    }

    public final void a() {
        FragmentActivity r0 = AppLifecycle.a.a.f();
        ViewGroup r2 = null;
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        View r3 = r1.getWindow().getDecorView();
        if (c.e == false) goto L14;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == c.a) goto L14;
        c.a(r4, "getDecorView");
    L14:
        if ((r3 instanceof FrameLayout) == false) goto L16;
        FrameLayout r5 = (FrameLayout) r3;
    L17:
        if (r5 != null) goto L19;
        return;
    L19:
        tt5.a.h("FloatViewContainer", "addToTopActivity, activity: ".concat(r1.getClass().getSimpleName()));
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(this, "view");
        if (Intrinsics.areEqual(getParent(), r5) == true) goto L29;
        ViewParent r6 = getParent();
        if ((r6 instanceof ViewGroup) == false) goto L25;
        r2 = (ViewGroup) r6;
    L25:
        if (r2 == null) goto L27;
        r2.removeView(this);
    L27:
        r5.addView(this);
        return;
    L29:
        return;
    L16:
        r5 = null;
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    public final void c() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        ViewGroup r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L14;
        r1.rightMargin = 0;
        r1.topMargin = 0;
        ViewParent r3 = getParent();
        if ((r3 instanceof ViewGroup) == false) goto L10;
        r2 = (ViewGroup) r3;
    L10:
        if (r2 != null) goto L12;
        return;
    L12:
        post(new b(this, r2, r1));
        return;
    L14:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public final void b(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        tt5.a.h("FloatViewContainer", "removeFromTopActivity");
        ViewParent r4 = r3.getParent();
        if ((r4 instanceof ViewGroup) == false) goto L5;
        ViewGroup r5 = (ViewGroup) r4;
    L6:
        if (r5 == null) goto L8;
        r5.removeView(this);
    L8:
        ViewParent r6 = getParent();
        if ((r6 instanceof ViewGroup) == false) goto L11;
        ViewGroup r7 = (ViewGroup) r6;
    L12:
        if (r7 == null) goto L14;
        r7.removeView(this);
    L14:
        com.ss.android.lark.appcontext.applifecycle.a r8 = this.j;
        if (r8 == null) goto L17;
        AppLifecycle.a.a.j(r8);
    L17:
        this.j = null;
        return;
    L11:
        r7 = null;
        goto L12
    L5:
        r5 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        super.onConfigurationChanged(r3);
        tt5.a.h("FloatViewContainer", "onConfigurationChanged, screenWidth: " + r3.screenWidthDp + ", screenHeight: " + r3.screenHeightDp);
        c();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = r5.getAction();
        boolean r1 = false;
        if (r0 != 0) goto L5;
        this.a = r5.getRawX();
        this.b = r5.getRawY();
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L25:
        if (r7 == null) goto L27;
        int r2 = r7.rightMargin;
    L28:
        this.c = r2;
        if (r7 == null) goto L31;
        int r8 = r7.topMargin;
    L32:
        this.d = r8;
        this.e = false;
        return false;
    L31:
        r8 = getTop();
        goto L32
    L27:
        r2 = getRight();
        goto L28
    L24:
        r7 = null;
        goto L25
    L5:
        if (r0 != 2) goto L7;
        float r3 = Math.abs(r5.getRawX() - this.a);
        float r9 = Math.abs(r5.getRawY() - this.b);
        if (this.e == true) goto L17;
        int r4 = this.f;
        if (r3 <= r4) goto L13;
    L14:
        r1 = true;
    L15:
        this.e = r1;
        goto L17
    L13:
        if (r9 <= r4) goto L15;
    L17:
        if (this.e == false) goto L19;
        d.a(this, 2131232575);
    L19:
        tt5.a.h("FloatViewContainer", "onInterceptTouchEvent, ACTION_MOVE, isDragging: " + this.e + ", dx: " + r3 + ", dy: " + r9);
        return this.e;
    L7:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        int r0 = r9.getAction();
        FrameLayout.LayoutParams r1 = null;
        ViewGroup.MarginLayoutParams r2 = null;
        boolean r4 = false;
        if (r0 == 1) goto L30;
        if (r0 != 2) goto L6;
        float r3 = r9.getRawX() - this.a;
        float r10 = r9.getRawY() - this.b;
        int r5 = (int) (this.c - r3);
        int r11 = (int) (this.d + r10);
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if ((r6 instanceof FrameLayout.LayoutParams) == false) goto L11;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
    L12:
        if (r7 == null) goto L15;
        r7.rightMargin = r5;
        r7.topMargin = r11;
    L15:
        if (getMeasuredWidth() > 0) goto L17;
    L28:
        requestLayout();
        tt5.a.b("FloatViewContainer", "handleActionMove, newX: " + r5 + ", newY: " + r11);
        return true;
    L17:
        if (getMeasuredHeight() <= 0) goto L28;
        ViewGroup.LayoutParams r8 = getLayoutParams();
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        r2 = (ViewGroup.MarginLayoutParams) r8;
    L22:
        if (r2 == null) goto L28;
        int r12 = r2.topMargin;
        int r13 = this.g;
        if (r12 >= r13) goto L27;
        r2.topMargin = r13;
    L27:
        r2.topMargin = RangesKt.coerceIn(r2.topMargin, 0, this.i - getHeight());
        r2.rightMargin = RangesKt.coerceIn(r2.rightMargin, 0, this.h - getWidth());
        goto L28
    L11:
        r7 = null;
        goto L12
    L6:
        if (r0 == 3) goto L30;
        return super.onTouchEvent(r9);
    L30:
        if (this.e == false) goto L47;
        tt5.a.h("FloatViewContainer", "attachToEdge");
        ViewGroup.LayoutParams r14 = getLayoutParams();
        if ((r14 instanceof FrameLayout.LayoutParams) == false) goto L34;
        r1 = (FrameLayout.LayoutParams) r14;
    L34:
        if (r1 == null) goto L45;
        Rect r15 = new Rect();
        getGlobalVisibleRect(r15);
        int r16 = r15.left + (getWidth() / 2);
        int r17 = this.h;
        if (r16 >= (r17 / 2)) goto L39;
        boolean r18 = true;
    L40:
        k = r18;
        l = r1.topMargin / this.i;
        int r19 = r1.rightMargin;
        if (r18 == false) goto L43;
        int r20 = r17 - getWidth();
        float r21 = -Math.abs(getTranslationX());
        int r22 = 2131232576;
    L44:
        ValueAnimator r23 = ValueAnimator.ofInt(new int[]{r19, r20});
        r23.addUpdateListener(new uo5.a(r1, this));
        r23.addListener(new uo5.b(this, r22, r21));
        r23.setDuration(300);
        r23.start();
        goto L45
    L43:
        r21 = Math.abs(getTranslationX());
        r22 = 2131232577;
        r20 = 0;
        goto L44
    L39:
        r18 = false;
    L45:
        this.e = false;
        r4 = true;
    L47:
        return r4;
    }

    public FloatViewContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = ViewConfiguration.get(r2).getScaledTouchSlop();
        setVisibility(4);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 8388613;
        setLayoutParams(r5);
        com.ss.android.lark.forsetiutils.b.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r6 = r2.getResources();
        int r7 = (int) ((5.5f * WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).density) + 0.5f);
        setPadding(r7, r7, r7, r7);
        Intrinsics.checkNotNullParameter(r2, "context");
        Resources r8 = r2.getResources();
        setTranslationX((int) ((5.0f * WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f));
        this.g = DeviceUtils.getStatusHeight(r2);
        c();
    }

    public /* synthetic */ FloatViewContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
