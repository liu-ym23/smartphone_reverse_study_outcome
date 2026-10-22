package com.ss.android.lark.widget.previewanimation.toolkit;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0003MNOB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\bJ\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020!J\u0012\u0010/\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000201H\u0002J\u0012\u00105\u001a\u00020!2\b\u00104\u001a\u0004\u0018\u000101H\u0016J\u0010\u00106\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0002J\u0012\u0010:\u001a\u00020+2\b\u0010;\u001a\u0004\u0018\u00010$H\u0002J$\u0010<\u001a\u00020+2\b\u0010=\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\b2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u00020+2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020+2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010E\u001a\u00020+2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010F\u001a\u00020+2\u0006\u0010B\u001a\u00020\u0012H\u0016J\u0014\u0010G\u001a\u00020+2\n\u0010H\u001a\u00060\u0010j\u0002`IH\u0002J\u0014\u0010J\u001a\u00020+*\u00020$2\u0006\u0010K\u001a\u00020\u0010H\u0002J\f\u0010L\u001a\u00020+*\u00020$H\u0002R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView;", "Landroid/widget/FrameLayout;", "Lcom/ss/android/lark/widget/previewanimation/animation/AnimationListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "configuration", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "maxFlingVelocity", "", "restoreAnimator", "Landroid/animation/ValueAnimator;", "dragScaleListener", "Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragScaleListener;", "getDragScaleListener", "()Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragScaleListener;", "setDragScaleListener", "(Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragScaleListener;)V", "value", "Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragStateInfo;", "dragStateInfo", "getDragStateInfo", "()Lcom/ss/android/lark/widget/previewanimation/toolkit/DragScaleView$DragStateInfo;", "lastDownY", "lastDownX", "isInDrag", "", "allowDrag", "contentView", "Landroid/view/View;", "isAnimation", "dragBackgroundColor", "velocityTracker", "Landroid/view/VelocityTracker;", "isDragEnable", "setDragBackgroundColor", "", "color", "setEnableDrag", "isEnabled", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "shouldHandleMoveEvent", "handleMoveEvent", "event", "onTouchEvent", "setupVelocityTrackerIfNeed", "alphaBackground", "alpha", "initDownEventData", "resetContent", BaseSwitches.V, "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "onAnimationStart", GXTemplateKey.GAIAX_ANIMATION, "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationCancel", "onAnimationUpdate", "handleAnimationUpdate", "progress", "Lcom/ss/android/lark/widget/previewanimation/toolkit/Progress;", "setScale", "scale", "resetPivotInner", "Companion", "DragStateInfo", "DragScaleListener", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragScaleView extends FrameLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f448022o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewConfiguration f448023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f448024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ValueAnimator f448025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f448026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f448027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f448028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f448029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f448030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f448031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f448032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f448033k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f448034l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f448035m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f448036n;

    public static final class a {
    }

    public interface b {
        void c40(DragScaleView r100);

        void jQ(DragScaleView r100);

        void kZ(DragScaleView r100);

        boolean qM(DragScaleView r100);

        void wx(DragScaleView r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f448037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f448038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f448039c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f448040d;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Float.compare(this.f448037a, r101.f448037a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f448038b, r101.f448038b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f448039c, r101.f448039c) == 0) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f448040d, r101.f448040d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f448037a) * 31) + Float.floatToIntBits(this.f448038b)) * 31) + Float.floatToIntBits(this.f448039c)) * 31) + this.f448040d.hashCode();
        }

        public final String toString() {
            return "DragStateInfo(scale=" + this.f448037a + ", transitionX=" + this.f448038b + ", transitionY=" + this.f448039c + ", currentBounds=" + this.f448040d + ')';
        }

        public /* synthetic */ c(int r100) {
            int r101 = DragScaleView.f448022o;
            this(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, new Rect());
        }

        public c(float r100, float r101, float r102, Rect r103) {
            Intrinsics.checkNotNullParameter(r103, "currentBounds");
            this.f448037a = r100;
            this.f448038b = r101;
            this.f448039c = r102;
            this.f448040d = r103;
        }
    }

    static {
    }

    public DragScaleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DragScaleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DragScaleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public final b getDragScaleListener() {
        return this.f448026d;
    }

    public final c getDragStateInfo() {
        return this.f448027e;
    }

    public static void b(View r100) {
        r100.setPivotX((r100.getLeft() + r100.getRight()) / 2.0f);
        r100.setPivotY((r100.getTop() + r100.getBottom()) / 2.0f);
    }

    private final void setupVelocityTrackerIfNeed(MotionEvent r100) {
        if (this.f448035m == null) goto L5;
        return;
    L5:
        VelocityTracker r101 = VelocityTracker.obtain();
        this.f448035m = r101;
        if (r101 == null) goto L9;
        r101.addMovement(r100);
        return;
    }

    public final void a(float r100) {
        c r101 = this.f448027e;
        float r102 = r101.f448037a;
        float r103 = ((1.0f - r102) * r100) + r102;
        View r104 = this.f448032j;
        if (r104 == null) goto L5;
        float r105 = r101.f448038b;
        r104.setTranslationX(((0.0f - r105) * r100) + r105);
        float r106 = this.f448027e.f448039c;
        r104.setTranslationY(((0.0f - r106) * r100) + r106);
        r104.setScaleX(r103);
        r104.setScaleY(r103);
        r104.invalidate();
    L5:
        setBackgroundColor(udc.b.a(r103, this.f448034l));
    }

    public final boolean d(MotionEvent r100) {
        if (this.f448031i == true) goto L5;
    L7:
        float r101 = r100.getY() - this.f448028f;
        float r102 = r100.getX() - this.f448029g;
        int r103 = this.f448023a.getScaledTouchSlop();
        if (((r102 * r102) + (r101 * r101)) <= (r103 * r103)) goto L10;
        boolean r104 = true;
    L12:
        if (r101 <= Math.abs(r102)) goto L14;
        boolean r105 = true;
    L16:
        if (this.f448033k == true) goto L19;
        if (r105 == true) goto L20;
        if (r104 == true) goto L19;
    L20:
        if (r104 == false) goto L25;
        if (r105 == false) goto L25;
        if (this.f448031i == false) goto L25;
        return true;
    L25:
        return false;
    L19:
        this.f448031i = false;
        goto L20
    L14:
        r105 = false;
        goto L16
    L10:
        r104 = false;
        goto L12
    L5:
        if (this.f448030h == false) goto L7;
        return true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a(1.0f);
        this.f448033k = false;
        b r101 = this.f448026d;
        if (r101 == null) goto L6;
        r101.jQ(this);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        a(0.0f);
        this.f448033k = true;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        a(((Float) r101).floatValue() / 1000.0f);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L23;
        if (this.f448032j == null) goto L23;
        if (this.f448036n == false) goto L23;
        if (this.f448033k == false) goto L12;
        this.f448030h = false;
        this.f448031i = false;
        return true;
    L12:
        int r101 = r100.getAction() & 255;
        if (r101 != 0) goto L15;
        this.f448028f = r100.getY();
        this.f448029g = r100.getX();
        this.f448030h = false;
        this.f448031i = true;
    L21:
        return super.onInterceptTouchEvent(r100);
    L15:
        if (r101 != 2) goto L21;
        return d(r100);
    L23:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        if (r110 == null) goto L82;
        if (this.f448036n == false) goto L82;
        int r100 = r110.getAction() & 255;
        if (r100 == 0) goto L76;
        boolean r101 = false;
        if (r100 == 1) goto L41;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L41;
        return super.onTouchEvent(r110);
    L17:
        if (d(r110) == true) goto L19;
        boolean r102 = false;
    L34:
        if (r102 == false) goto L36;
        return true;
    L36:
        if (super.onTouchEvent(r110) == true) goto L84;
        return false;
    L84:
        return true;
    L19:
        setupVelocityTrackerIfNeed(r110);
        if (this.f448030h == true) goto L24;
        b r103 = this.f448026d;
        if (r103 == null) goto L24;
        r103.kZ(this);
    L24:
        this.f448030h = true;
        VelocityTracker r104 = this.f448035m;
        if (r104 == null) goto L27;
        r104.addMovement(r110);
    L27:
        float r105 = r110.getY() - this.f448028f;
        float r106 = r110.getX() - this.f448029g;
        float r107 = Math.max(0.25f, Math.min(1 - ((0.75f * r105) / getHeight()), 1.0f));
        float r108 = r106 * r107;
        float r109 = r105 * r107;
        View r111 = this.f448032j;
        if (r111 == null) goto L30;
        r111.setTranslationX(r108);
        r111.setTranslationY(r109);
        r111.setPivotX(r110.getX());
        r111.setPivotY(r110.getY());
        r111.setScaleX(r107);
        r111.setScaleY(r107);
    L30:
        setBackgroundColor(udc.b.a(r107, this.f448034l));
        this.f448027e = new c(r107, r108, r109, new Rect(MathKt.roundToInt((r110.getX() + r108) + ((getLeft() - r110.getX()) * r107)), MathKt.roundToInt((r110.getY() + r109) + ((getTop() - r110.getY()) * r107)), MathKt.roundToInt((r110.getX() + r108) + ((getRight() - r110.getX()) * r107)), MathKt.roundToInt((r110.getY() + r109) + ((getBottom() - r110.getY()) * r107))));
        b r112 = this.f448026d;
        if (r112 == null) goto L33;
        r112.c40(this);
    L33:
        r102 = true;
    L41:
        if (this.f448030h == false) goto L74;
        if (this.f448032j == null) goto L74;
        b(this);
        b r113 = this.f448026d;
        if (r113 == null) goto L48;
        r113.wx(this);
    L48:
        VelocityTracker r114 = this.f448035m;
        if (r114 == null) goto L51;
        r114.addMovement(r110);
    L51:
        VelocityTracker r115 = this.f448035m;
        if (r115 == null) goto L54;
        r115.computeCurrentVelocity(1000, this.f448024b);
    L54:
        VelocityTracker r116 = this.f448035m;
        if (r116 == null) goto L57;
        float r117 = r116.getYVelocity();
    L58:
        VelocityTracker r118 = this.f448035m;
        if (r118 == null) goto L61;
        r118.recycle();
    L61:
        this.f448035m = null;
        if (r117 <= 300.0f) goto L64;
    L65:
        b r119 = this.f448026d;
        if (r119 != null) goto L68;
    L70:
        if (r101 == true) goto L72;
        this.f448025c.start();
    L72:
        return true;
    L68:
        if (r119.qM(this) != true) goto L70;
        r101 = true;
        goto L70
    L64:
        if (this.f448027e.f448037a >= 0.8f) goto L70;
    L57:
        r117 = 0.0f;
    L74:
        return super.onTouchEvent(r110);
    L76:
        if (this.f448033k == true) goto L78;
        setupVelocityTrackerIfNeed(r110);
        b(this);
        return true;
    L78:
        return super.onTouchEvent(r110);
    L82:
        return super.onTouchEvent(r110);
    }

    public final void setDragBackgroundColor(int r100) {
        this.f448034l = r100;
        setBackgroundColor(r100);
    }

    public final void setDragScaleListener(b r100) {
        this.f448026d = r100;
    }

    public final void setEnableDrag(boolean r100) {
        this.f448036n = r100;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        this.f448032j = r100;
        removeAllViews();
        super.addView(r100, r101, r102);
    }

    public DragScaleView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r101 = null;
    L5:
        int r104 = 0;
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        ViewConfiguration r105 = ViewConfiguration.get(r100);
        this.f448023a = r105;
        this.f448024b = r105.getScaledMaximumFlingVelocity();
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r106.setDuration(300);
        r106.addUpdateListener(this);
        r106.addListener(this);
        this.f448025c = r106;
        this.f448027e = new c(r104);
        this.f448028f = Float.MIN_VALUE;
        this.f448029g = Float.MIN_VALUE;
        this.f448031i = true;
        setDragBackgroundColor(-16777216);
    }
}
