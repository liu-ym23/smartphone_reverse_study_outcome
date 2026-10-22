package com.ss.android.lark.biz.im.extension.panel.drag.view;

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
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001<B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u0002002\u0006\u0010,\u001a\u00020-H\u0002J \u00101\u001a\u00020\f2\u0006\u00102\u001a\u0002032\u0006\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u00105\u001a\u00020-H\u0016J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001aH\u0002J\u0010\u00109\u001a\u0002072\b\u0010&\u001a\u0004\u0018\u00010'J\b\u0010:\u001a\u000207H\u0014J\b\u0010;\u001a\u000207H\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b!\u0010\u0016R\u000e\u0010#\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/biz/im/extension/panel/drag/view/DragPanelLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dragEnable", "", "getDragEnable", "()Z", "setDragEnable", "(Z)V", "interceptChildMove", "getInterceptChildMove", "setInterceptChildMove", "rootHeight", "getRootHeight", "()I", "rootHeight$delegate", "Lkotlin/Lazy;", "halfExpandThreshold", "", "getHalfExpandThreshold", "()F", "halfExpandThreshold$delegate", "velocityTracker", "Landroid/view/VelocityTracker;", "maximumVelocity", "getMaximumVelocity", "maximumVelocity$delegate", "touchSlop", "startY", "preY", "listener", "Lcom/ss/android/lark/biz/im/extension/panel/drag/view/PanelDragLayoutChangeListener;", "childLocation", "", "parentLocation", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "isChildNeedScroll", "viewGroup", "Landroid/view/ViewGroup;", "isLocationInView", "view", "Landroid/view/View;", "onTouchEvent", "event", "handleActionUp", "", "velocityY", "setListener", "onAttachedToWindow", "onDetachedFromWindow", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DragPanelLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f410566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f410567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f410568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f410569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VelocityTracker f410570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f410571f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f410572g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f410573h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f410574i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f410575j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f410576k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f410577l;

    public static final class a {
    }

    static {
    }

    public DragPanelLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DragPanelLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DragPanelLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    private final float getHalfExpandThreshold() {
        return ((Number) this.f410569d.getValue()).floatValue();
    }

    private final int getMaximumVelocity() {
        return ((Number) this.f410571f.getValue()).intValue();
    }

    private final int getRootHeight() {
        return ((Number) this.f410568c.getValue()).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        VelocityTracker r100 = this.f410570e;
        if (r100 == null) goto L7;
        if (r100 == null) goto L6;
        r100.recycle();
    L6:
        this.f410570e = null;
    L7:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f410570e = VelocityTracker.obtain();
    }

    public final boolean getDragEnable() {
        return this.f410566a;
    }

    public final boolean getInterceptChildMove() {
        return this.f410567b;
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
        b r102 = this.f410575j;
        if (r102 == null) goto L19;
        r102.d();
    L19:
        float r103 = r100.getRawY();
        this.f410573h = r103;
        this.f410574i = r103;
    L21:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r101 != 2) goto L21;
        if (Math.abs(r100.getRawY() - this.f410573h) <= this.f410572g) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L21;
        if (b(this, r100) == true) goto L21;
        this.f410574i = r100.getRawY();
        return true;
    L10:
        r104 = false;
        goto L11
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        if (this.f410566a == true) goto L7;
        return super.onTouchEvent(r110);
    L7:
        if (this.f410570e != null) goto L9;
        this.f410570e = VelocityTracker.obtain();
    L9:
        VelocityTracker r100 = this.f410570e;
        if (r100 == null) goto L12;
        r100.addMovement(r110);
    L12:
        VelocityTracker r101 = this.f410570e;
        if (r101 == null) goto L15;
        r101.computeCurrentVelocity(1000, getMaximumVelocity());
    L15:
        VelocityTracker r102 = this.f410570e;
        if (r102 == null) goto L18;
        float r103 = r102.getYVelocity();
    L19:
        int r104 = r110.getAction();
        boolean r105 = false;
        if (r104 != 1) goto L22;
        float r106 = this.f410574i - this.f410573h;
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
        b r109 = this.f410575j;
        if (r109 == null) goto L60;
        r109.e();
    L60:
        Log.d("DragPanelLayout", "onTouchEvent, event = " + r110.getAction());
        return true;
    L46:
        if (r106 > r107) goto L47;
        if (r108 == false) goto L52;
    L57:
        this.f410567b = false;
        b r111 = this.f410575j;
        if (r111 == null) goto L60;
        r111.b();
        goto L60
    L52:
        if (r106 < (-r107)) goto L57;
        b r112 = this.f410575j;
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
        if (this.f410574i != 0.0f) goto L27;
        r105 = true;
    L27:
        if (r105 == false) goto L29;
        this.f410574i = r110.getRawY();
    L29:
        Log.d("DragPanelLayout", "onTouchEvent, event = ACTION_MOVE, preY = " + this.f410574i + ", rawY = " + r110.getRawY() + " offset = " + (r110.getRawY() - this.f410574i));
        b r113 = this.f410575j;
        if (r113 == null) goto L32;
        r113.a(r110.getRawY() - this.f410574i);
    L32:
        this.f410574i = r110.getRawY();
        goto L60
    L18:
        r103 = 0.0f;
        goto L19
    }

    public final void setDragEnable(boolean r100) {
        this.f410566a = r100;
    }

    public final void setInterceptChildMove(boolean r100) {
        this.f410567b = r100;
    }

    public final void setListener(b r100) {
        this.f410575j = r100;
    }

    public final boolean b(ViewGroup r110, MotionEvent r111) {
        if (this.f410567b == false) goto L6;
        return false;
    L6:
        if ((r111.getRawY() - this.f410573h) >= 0.0f) goto L9;
        return true;
    L9:
        if (r110.canScrollVertically(-1) == false) goto L11;
        return true;
    L11:
        getLocationInWindow(this.f410577l);
        int r100 = r110.getChildCount();
        int r101 = 0;
    L12:
        if (r101 >= r100) goto L26;
        View r102 = r110.getChildAt(r101);
        if (r102 == null) goto L25;
        int[] r103 = this.f410577l;
        r102.getLocationInWindow(this.f410576k);
        float r104 = r111.getX() + r103[0];
        float r112 = r111.getY() + r103[1];
        int[] r113 = this.f410576k;
        int r114 = r113[0];
        if (new RectF(r114, r113[1], r114 + r102.getWidth(), this.f410576k[1] + r102.getHeight()).contains(r104, r112) == false) goto L25;
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

    public DragPanelLayout(final Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f410566a = true;
        LazyThreadSafetyMode r104 = LazyThreadSafetyMode.NONE;
        this.f410568c = LazyKt.lazy(r104, new DragPanelLayout$rootHeight$2(r100));
        this.f410569d = LazyKt.lazy(r104, new DragPanelLayout$halfExpandThreshold$2(this));
        this.f410571f = LazyKt.lazy(new DragPanelLayout$maximumVelocity$2(r100));
        this.f410572g = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f410576k = new int[2];
        this.f410577l = new int[2];
    }
}
