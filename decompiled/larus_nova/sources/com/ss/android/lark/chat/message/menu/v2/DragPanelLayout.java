package com.ss.android.lark.chat.message.menu.v2;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u000200H\u0016J\u0018\u00101\u001a\u00020\r2\u0006\u00102\u001a\u0002032\u0006\u0010/\u001a\u000200H\u0002J \u00104\u001a\u00020\r2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u001dH\u0002J\u0010\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u000200H\u0016J\u0010\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010=\u001a\u00020,2\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010>\u001a\u00020,H\u0014J\b\u0010?\u001a\u00020,H\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001b\u001a\u0004\b$\u0010\u0019R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/ss/android/lark/chat/message/menu/v2/DragPanelLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dragEnable", "", "getDragEnable", "()Z", "setDragEnable", "(Z)V", "interceptChildMove", "getInterceptChildMove", "setInterceptChildMove", "initParams", "Lcom/ss/android/lark/chat/message/menu/v2/DragPanelInitParams;", "rootHeight", "getRootHeight", "()I", "rootHeight$delegate", "Lkotlin/Lazy;", "halfExpandThreshold", "", "getHalfExpandThreshold", "()F", "halfExpandThreshold$delegate", "velocityTracker", "Landroid/view/VelocityTracker;", "maximumVelocity", "getMaximumVelocity", "maximumVelocity$delegate", "touchSlop", "startY", "preY", "listener", "Lcom/ss/android/lark/chat/message/menu/v2/PanelDragLayoutChangeListener;", "setInitParams", "", "params", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "isChildNeedScroll", "viewGroup", "Landroid/view/ViewGroup;", "isLocationInView", "view", "Landroid/view/View;", "x", "y", "onTouchEvent", "event", "handleActionUp", "velocityY", "setListener", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragPanelLayout extends FrameLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f415544k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f415545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f415546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f415547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f415548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f415549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f415550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f415551g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f415552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f415553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l0 f415554j;

    public static final class a {
    }

    static {
    }

    public final void setInitParams(b r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    private final float getHalfExpandThreshold() {
        return ((Number) this.f415548d.getValue()).floatValue();
    }

    private final int getMaximumVelocity() {
        return ((Number) this.f415550f.getValue()).intValue();
    }

    private final int getRootHeight() {
        return ((Number) this.f415547c.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r100 = this.f415549e;
        if (r100 == null) goto L7;
        if (r100 == null) goto L6;
        r100.recycle();
    L6:
        this.f415549e = null;
    L7:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f415549e = VelocityTracker.obtain();
    }

    public final boolean getDragEnable() {
        return this.f415545a;
    }

    public final boolean getInterceptChildMove() {
        return this.f415546b;
    }

    public DragPanelLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f415545a = true;
        this.f415546b = true;
        this.f415547c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.f415548d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f415550f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.f415551g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static final /* synthetic */ int a(DragPanelLayout r100) {
        return r100.getRootHeight();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Log.d("DragPanelLayout", "onInterceptTouchEvent: event = " + r100.getActionMasked());
        int r101 = r100.getAction();
        if (r101 != 0) goto L5;
        l0 r102 = this.f415554j;
        if (r102 == null) goto L19;
        r102.d();
    L19:
        float r103 = r100.getRawY();
        this.f415552h = r103;
        this.f415553i = r103;
    L21:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 2) goto L21;
        if (Math.abs(r100.getRawY() - this.f415552h) <= this.f415551g) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L21;
        if (b(this, r100) == true) goto L21;
        this.f415553i = r100.getRawY();
        return true;
    L10:
        r104 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f415545a == true) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.f415549e != null) goto L9;
        this.f415549e = VelocityTracker.obtain();
    L9:
        VelocityTracker r100 = this.f415549e;
        if (r100 == null) goto L12;
        r100.addMovement(r110);
    L12:
        VelocityTracker r101 = this.f415549e;
        if (r101 == null) goto L15;
        r101.computeCurrentVelocity(1000, getMaximumVelocity());
    L15:
        VelocityTracker r102 = this.f415549e;
        if (r102 == null) goto L18;
        float r103 = r102.getYVelocity();
    L19:
        int r104 = r110.getAction();
        boolean r105 = false;
        if (r104 != 1) goto L22;
        float r106 = this.f415553i - this.f415552h;
        if (getHeight() >= getHalfExpandThreshold()) goto L36;
        float r107 = 0.0f;
    L38:
        if (r103 <= 600.0f) goto L40;
        boolean r108 = true;
    L41:
        Log.d("DragPanelLayout", "onTouchEvent, action = ACTION_UP, isOverTouchSpeed = " + r108 + ", totalOffset = " + r106);
        if (r108 == false) goto L46;
        if (r106 < 0.0f) goto L46;
    L47:
        l0 r109 = this.f415554j;
        if (r109 == null) goto L60;
        r109.e();
    L60:
        Log.i("DragPanelLayout", "onTouchEvent, event = " + r110.getAction());
        return true;
    L46:
        if (r106 > r107) goto L47;
        if (r108 == false) goto L52;
    L57:
        this.f415546b = false;
        l0 r111 = this.f415554j;
        if (r111 == null) goto L60;
        r111.b();
        goto L60
    L52:
        if (r106 < (-r107)) goto L57;
        l0 r112 = this.f415554j;
        if (r112 == null) goto L60;
        r112.c();
        goto L60
    L40:
        r108 = false;
        goto L41
    L36:
        r107 = 150.0f;
        goto L38
    L22:
        if (r104 != 2) goto L60;
        if (this.f415553i != 0.0f) goto L27;
        r105 = true;
    L27:
        if (r105 == false) goto L29;
        this.f415553i = r110.getRawY();
    L29:
        Log.d("DragPanelLayout", "onTouchEvent, event = ACTION_MOVE, preY = " + this.f415553i + ", rawY = " + r110.getRawY() + " offset = " + (r110.getRawY() - this.f415553i));
        l0 r113 = this.f415554j;
        if (r113 == null) goto L32;
        r113.a(r110.getRawY() - this.f415553i);
    L32:
        this.f415553i = r110.getRawY();
        goto L60
    L18:
        r103 = 0.0f;
        goto L19
    }

    public final void setDragEnable(boolean r100) {
        this.f415545a = r100;
    }

    public final void setInterceptChildMove(boolean r100) {
        this.f415546b = r100;
    }

    public final void setListener(l0 r100) {
        this.f415554j = r100;
    }

    public DragPanelLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f415545a = true;
        this.f415546b = true;
        this.f415547c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.f415548d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f415550f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.f415551g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public final boolean b(ViewGroup r110, MotionEvent r111) {
        if (this.f415546b == false) goto L6;
        return false;
    L6:
        if ((r111.getRawY() - this.f415552h) >= 0.0f) goto L9;
        return true;
    L9:
        if (r110.canScrollVertically(-1) == false) goto L11;
        return true;
    L11:
        int r100 = r110.getChildCount();
        int r101 = 0;
    L12:
        if (r101 >= r100) goto L26;
        View r102 = r110.getChildAt(r101);
        if (r102 == null) goto L25;
        float r103 = r111.getRawX();
        float r104 = r111.getRawY();
        int[] r112 = new int[2];
        r102.getLocationOnScreen(r112);
        int r113 = r112[0];
        if (new RectF(r113, r112[1], r113 + r102.getWidth(), r112[1] + r102.getHeight()).contains(r103, r104) == false) goto L25;
        if ((r102 instanceof ViewGroup) == false) goto L22;
        boolean r105 = b((ViewGroup) r102, r111);
    L23:
        if (r105 == false) goto L25;
        return true;
    L22:
        r105 = r102.canScrollVertically(-1);
    L25:
        r101 = r101 + 1;
        goto L12
    L26:
        return false;
    }

    public DragPanelLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f415545a = true;
        this.f415546b = true;
        this.f415547c = LazyKt.lazy(new DragPanelLayout$rootHeight$2(this));
        this.f415548d = LazyKt.lazy(new DragPanelLayout$halfExpandThreshold$2(this));
        this.f415550f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(this));
        this.f415551g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
