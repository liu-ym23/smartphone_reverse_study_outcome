package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\"\u001a\u00020#H\u0014J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000bJ\u0006\u0010&\u001a\u00020#J\u0006\u0010'\u001a\u00020#J\u0006\u0010(\u001a\u00020#J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020#H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "maxSwipeDistance", "", "swipeThreshold", "touchSlop", "minFlingVelocity", "onSwipeListener", "Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;", "getOnSwipeListener", "()Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;", "setOnSwipeListener", "(Lcom/larus/dora/impl/nl/notification_rule/ui/SwipeLayout$OnSwipeListener;)V", "contentView", "Landroid/view/View;", "menuView", "value", "", "isOpen", "()Z", "isDragging", "downX", "downY", "lastX", "velocityTracker", "Landroid/view/VelocityTracker;", "onFinishInflate", "", "setMaxSwipeDistance", "distance", "open", "close", "toggle", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "onDetachedFromWindow", "Companion", "OnSwipeListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f336320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f336321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f336322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f336323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f336324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f336325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f336326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f336327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f336328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f336329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f336330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f336331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f336332m;

    public static final class a {
    }

    public interface b {
        void a(SwipeLayout r100);

        void b(SwipeLayout r100);

        void c(SwipeLayout r100);
    }

    static {
    }

    public SwipeLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SwipeLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        View r100 = this.f336325f;
        if (r100 == null) goto L18;
        if (r100 == null) goto L14;
        ViewPropertyAnimator r101 = r100.animate();
        if (r101 == null) goto L14;
        ViewPropertyAnimator r102 = r101.translationX(0.0f);
        if (r102 == null) goto L14;
        ViewPropertyAnimator r103 = r102.setDuration(200);
        if (r103 == null) goto L14;
        ViewPropertyAnimator r104 = r103.withEndAction(new g0(this));
        if (r104 == null) goto L14;
        r104.start();
    L14:
        this.f336327h = false;
        b r105 = this.f336324e;
        if (r105 == null) goto L19;
        r105.a(this);
        return;
    L19:
        return;
    }

    public final void b() {
        if (this.f336325f == null) goto L20;
        View r100 = this.f336326g;
        if (r100 == null) goto L7;
        r100.setVisibility(0);
    L7:
        View r101 = this.f336325f;
        if (r101 == null) goto L16;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L16;
        ViewPropertyAnimator r103 = r102.translationX(-this.f336320a);
        if (r103 == null) goto L16;
        ViewPropertyAnimator r104 = r103.setDuration(200);
        if (r104 == null) goto L16;
        r104.start();
    L16:
        this.f336327h = true;
        b r105 = this.f336324e;
        if (r105 == null) goto L21;
        r105.b(this);
        return;
    L21:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VelocityTracker r100 = this.f336332m;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f336332m = null;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() < 2) goto L6;
        this.f336326g = getChildAt(0);
        this.f336325f = getChildAt(1);
        return;
    }

    public final b getOnSwipeListener() {
        return this.f336324e;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        this.f336329j = r100.getX();
        this.f336330k = r100.getY();
        this.f336331l = r100.getX();
        this.f336328i = false;
        VelocityTracker r102 = this.f336332m;
        if (r102 == null) goto L28;
        r102.recycle();
    L28:
        VelocityTracker r103 = VelocityTracker.obtain();
        this.f336332m = r103;
        if (r103 == null) goto L32;
        r103.addMovement(r100);
    L32:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 2) goto L32;
        float r104 = r100.getX() - this.f336329j;
        float r105 = r100.getY() - this.f336330k;
        if (this.f336328i == true) goto L20;
        if (Math.abs(r104) <= this.f336322c) goto L20;
        if (Math.abs(r104) <= Math.abs(r105)) goto L20;
        this.f336328i = true;
        ViewParent r106 = getParent();
        if (r106 == null) goto L16;
        r106.requestDisallowInterceptTouchEvent(true);
    L16:
        b r107 = this.f336324e;
        if (r107 == null) goto L20;
        r107.c(this);
    L20:
        if (this.f336328i == false) goto L32;
        VelocityTracker r108 = this.f336332m;
        if (r108 == null) goto L24;
        r108.addMovement(r100);
    L24:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        VelocityTracker r101 = this.f336332m;
        if (r101 == null) goto L5;
        r101.addMovement(r100);
    L5:
        int r102 = r100.getAction();
        boolean r103 = false;
        if (r102 == 1) goto L36;
        if (r102 == 2) goto L26;
        if (r102 == 3) goto L13;
    L64:
        return true;
    L13:
        if (this.f336328i == false) goto L64;
        this.f336328i = false;
        ViewParent r104 = getParent();
        if (r104 == null) goto L18;
        r104.requestDisallowInterceptTouchEvent(false);
    L18:
        if (this.f336327h == false) goto L20;
        b();
    L21:
        VelocityTracker r105 = this.f336332m;
        if (r105 == null) goto L24;
        r105.recycle();
    L24:
        this.f336332m = null;
        goto L64
    L20:
        a();
        goto L21
    L26:
        if (this.f336328i == false) goto L64;
        if (this.f336325f == null) goto L64;
        float r106 = r100.getX() - this.f336331l;
        this.f336331l = r100.getX();
        View r107 = this.f336325f;
        Intrinsics.checkNotNull(r107);
        float r108 = RangesKt.coerceIn(r107.getTranslationX() + r106, -this.f336320a, 0.0f);
        if (r108 >= 0.0f) goto L34;
        View r109 = this.f336326g;
        if (r109 == null) goto L34;
        r109.setVisibility(0);
    L34:
        View r110 = this.f336325f;
        Intrinsics.checkNotNull(r110);
        r110.setTranslationX(r108);
        goto L64
    L36:
        if (this.f336328i == false) goto L64;
        if (this.f336325f == null) goto L64;
        this.f336328i = false;
        ViewParent r111 = getParent();
        if (r111 == null) goto L42;
        r111.requestDisallowInterceptTouchEvent(false);
    L42:
        VelocityTracker r112 = this.f336332m;
        if (r112 == null) goto L45;
        r112.computeCurrentVelocity(1000);
    L45:
        VelocityTracker r113 = this.f336332m;
        if (r113 == null) goto L48;
        float r114 = r113.getXVelocity();
    L50:
        if (Math.abs(r114) > this.f336323d) goto L52;
        View r115 = this.f336325f;
        Intrinsics.checkNotNull(r115);
        if (r115.getTranslationX() >= ((-this.f336320a) * this.f336321b)) goto L57;
    L56:
        r103 = true;
    L57:
        if (r103 == false) goto L59;
        b();
    L60:
        VelocityTracker r116 = this.f336332m;
        if (r116 == null) goto L63;
        r116.recycle();
    L63:
        this.f336332m = null;
        goto L64
    L59:
        a();
        goto L60
    L52:
        if (r114 >= 0.0f) goto L57;
    L48:
        r114 = 0.0f;
        goto L50
    }

    public final void setMaxSwipeDistance(float r100) {
        this.f336320a = r100;
    }

    public final void setOnSwipeListener(b r100) {
        this.f336324e = r100;
    }

    public SwipeLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f336320a = r100.getResources().getDimension(v19.c.b(R.attr.larus_dp_72, r100, R.dimen.larus_dp_72)) * 2;
        this.f336321b = 0.5f;
        this.f336322c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f336323d = ViewConfiguration.get(r100).getScaledMinimumFlingVelocity();
    }

    public /* synthetic */ SwipeLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
