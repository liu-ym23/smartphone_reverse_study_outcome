package com.larus.common_ui.dbx.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001lB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;H\u0016J(\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J(\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u0002032\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J0\u0010E\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020(2\u0006\u0010B\u001a\u00020\bH\u0016J@\u0010I\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\u0006\u0010H\u001a\u00020(H\u0016J8\u0010I\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016J\u0018\u0010N\u001a\u00020D2\u0006\u0010@\u001a\u0002032\u0006\u0010B\u001a\u00020\bH\u0016J \u0010O\u001a\u00020\u00122\u0006\u0010@\u001a\u0002032\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 H\u0016J(\u0010R\u001a\u00020\u00122\u0006\u0010@\u001a\u0002032\u0006\u0010P\u001a\u00020 2\u0006\u0010Q\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0012H\u0016J\b\u0010S\u001a\u00020\bH\u0016J\u0006\u0010T\u001a\u00020DJ\u0006\u0010U\u001a\u00020DJ\u0006\u0010V\u001a\u00020DJ\u0018\u0010W\u001a\u00020\u00122\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u0018\u0010Y\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u0018\u0010Z\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\u0006\u0010X\u001a\u00020\bH\u0002J\u000f\u0010[\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u00020D2\b\u0010^\u001a\u0004\u0018\u000103H\u0002J\u0010\u0010_\u001a\u00020 2\u0006\u0010`\u001a\u00020 H\u0002J\u0018\u0010a\u001a\u00020D2\u0006\u0010Q\u001a\u00020 2\u0006\u0010b\u001a\u00020\u0012H\u0002J\u0012\u0010c\u001a\u00020D2\b\u0010?\u001a\u0004\u0018\u000103H\u0002J\u0010\u0010d\u001a\u00020D2\u0006\u0010:\u001a\u00020;H\u0002J\u0018\u0010e\u001a\u00020\u00122\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 H\u0002J\f\u0010h\u001a\u00020\u0012*\u000203H\u0002J \u0010i\u001a\u0002032\u0006\u0010j\u001a\u00020k2\u0006\u0010f\u001a\u00020 2\u0006\u0010g\u001a\u00020 H\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020305X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u00108¨\u0006m"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent3;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "delegate", "Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;", "getDelegate", "()Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;", "setDelegate", "(Lcom/larus/common_ui/dbx/component/DbxPanelDragLayout$Delegate;)V", "isInteractionEnabled", "", "()Z", "setInteractionEnabled", "(Z)V", "value", "isScrollInteractionBlocked", "setScrollInteractionBlocked", "nestedScrollingParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "activePointerId", "initialX", "", "initialY", "lastY", "downOnNestedScrollingChild", "isTouchSequenceInProgress", "isDirectDragging", "hasInterceptedCurrentSequence", "locationOnScreen", "", "currentScreenY", "hasCurrentScreenY", "nestedDragLastScreenY", "hasNestedDragLastScreenY", "isBlockedTouchActive", "isPanelDragActive", "panelDragTranslationY", "lastTouchVelocityY", "lastTouchCancelled", "panelDragNestedTarget", "Landroid/view/View;", "blockedNestedTargets", "", "frozenScrollChild", "frozenScrollChildOverScrollMode", "Ljava/lang/Integer;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "onTouchEvent", "onStartNestedScroll", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, PickerReporterConstants.KEY.TARGET, "axes", "type", "onNestedScrollAccepted", "", "onNestedPreScroll", "dx", "dy", "consumed", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStopNestedScroll", "onNestedPreFling", "velocityX", "velocityY", "onNestedFling", "getNestedScrollAxes", "cancelActiveInteraction", "resetInteractionState", "releaseFrozenScrollChild", "tryBeginDirectDrag", "pointerIndex", "screenY", "screenX", "nestedDragDeltaY", "()Ljava/lang/Float;", "beginPanelDrag", "scrollChild", "dispatchPanelDrag", "deltaY", "finishPanelDrag", "cancelled", "freezeScrollChild", "trackVelocity", "hasNestedScrollingChildAt", "x", "y", "isVerticalNestedScrollingChild", "deepestVisibleChildAt", "parent", "Landroid/view/ViewGroup;", "Delegate", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DbxPanelDragLayout extends FrameLayout implements NestedScrollingParent3 {
    public View A;
    public Integer B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f326951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f326952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f326953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NestedScrollingParentHelper f326954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f326955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VelocityTracker f326956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f326957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f326958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f326959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f326960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f326961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f326962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f326963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f326964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int[] f326965o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f326966p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f326967q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f326968r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f326969s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f326970t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f326971u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f326972v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f326973w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f326974x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f326975y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Set<View> f326976z;

    public interface a {
        float a(float r100);

        boolean b(float r100);

        void c();

        boolean d(float r100, float r101, boolean r102);
    }

    public DbxPanelDragLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DbxPanelDragLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final Float f() {
        if (this.f326967q == true) goto L7;
        return null;
    L7:
        if (this.f326969s == true) goto L10;
        this.f326968r = this.f326966p;
        this.f326969s = true;
        return Float.valueOf(0.0f);
    L10:
        float r100 = this.f326966p;
        float r101 = r100 - this.f326968r;
        this.f326968r = r100;
        return Float.valueOf(r101);
    }

    public final void g() {
        View r100 = this.A;
        Integer r101 = this.B;
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        r100.setOverScrollMode(r101.intValue());
    L6:
        this.A = null;
        this.B = null;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f326954d.getNestedScrollAxes();
    }

    public final a getDelegate() {
        return this.f326951a;
    }

    public final void a(View r100) {
        if (this.f326971u == false) goto L5;
        return;
    L5:
        this.f326971u = true;
        this.f326975y = r100;
        this.f326972v = 0.0f;
        this.f326969s = false;
        if (r100 != null) goto L8;
    L11:
        a r101 = this.f326951a;
        if (r101 == null) goto L15;
        r101.c();
        return;
    L15:
        return;
    L8:
        if (this.A == r100) goto L11;
        g();
        this.A = r100;
        this.B = Integer.valueOf(r100.getOverScrollMode());
        r100.setOverScrollMode(2);
        goto L11
    }

    public final void c(float r100) {
        if (this.f326971u == false) goto L15;
        float r101 = 0.0f;
        if (r100 != 0.0f) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L16;
        a r103 = this.f326951a;
        if (r103 == null) goto L13;
        r101 = r103.a(r100);
    L13:
        this.f326972v += r101;
        return;
    L16:
        return;
    L7:
        r102 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getActionMasked() != 0) goto L5;
        this.f326962l = true;
    L5:
        int r101 = r100.getActionMasked();
        float r102 = 0.0f;
        if (r101 != 0) goto L8;
        VelocityTracker r103 = this.f326956f;
        if (r103 == null) goto L23;
        r103.recycle();
    L23:
        this.f326956f = VelocityTracker.obtain();
        this.f326957g = r100.getPointerId(0);
        this.f326973w = 0.0f;
        this.f326974x = false;
    L24:
        VelocityTracker r104 = this.f326956f;
        if (r104 == null) goto L28;
        r104.addMovement(r100);
    L28:
        if (r100.getActionMasked() != 1) goto L30;
    L31:
        VelocityTracker r105 = this.f326956f;
        if (r105 == null) goto L34;
        r105.computeCurrentVelocity(1000);
    L34:
        VelocityTracker r106 = this.f326956f;
        if (r106 == null) goto L37;
        r102 = r106.getYVelocity(this.f326957g);
    L37:
        this.f326973w = r102;
        if (r100.getActionMasked() != 3) goto L40;
        boolean r107 = true;
    L41:
        this.f326974x = r107;
    L43:
        if (r100.getActionMasked() != 2) goto L47;
        int r108 = r100.findPointerIndex(this.f326957g);
        if (r108 < 0) goto L47;
        this.f326966p = i(r100, r108);
        this.f326967q = true;
    L47:
        boolean r109 = super.dispatchTouchEvent(r100);
        if (r100.getActionMasked() != 1) goto L50;
    L51:
        this.f326962l = false;
        this.f326970t = false;
        this.f326967q = false;
        VelocityTracker r110 = this.f326956f;
        if (r110 == null) goto L54;
        r110.recycle();
    L54:
        this.f326956f = null;
        this.f326957g = -1;
    L55:
        return r109;
    L50:
        if (r100.getActionMasked() != 3) goto L55;
    L40:
        r107 = false;
        goto L41
    L30:
        if (r100.getActionMasked() != 3) goto L43;
    L8:
        if (r101 != 6) goto L24;
        int r111 = r100.getActionIndex();
        if (r100.getPointerId(r111) != this.f326957g) goto L24;
        if (r111 != 0) goto L14;
        int r112 = 1;
    L16:
        if (r112 >= r100.getPointerCount()) goto L24;
        this.f326957g = r100.getPointerId(r112);
        this.f326960j = i(r100, r112);
        if (this.f326963m == true) goto L24;
        this.f326958h = h(r100, r112);
        this.f326959i = i(r100, r112);
        goto L24
    L14:
        r112 = 0;
        goto L16
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (r100.getActionMasked() != 0) goto L6;
        this.f326970t = false;
    L6:
        if (this.f326970t == false) goto L9;
        return true;
    L9:
        if (this.f326953c == false) goto L13;
        this.f326970t = true;
        return true;
    L13:
        if (this.f326952b == true) goto L16;
        return false;
    L16:
        if (this.f326963m == true) goto L18;
    L20:
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L23;
        this.f326957g = r100.getPointerId(0);
        this.f326958h = h(r100, 0);
        float r102 = i(r100, 0);
        this.f326959i = r102;
        this.f326960j = r102;
        this.f326963m = false;
        this.f326964n = false;
        this.f326961k = e(r100.getX(), r100.getY());
    L40:
        return false;
    L23:
        if (r101 != 2) goto L40;
        if (this.f326961k == true) goto L38;
        if (this.f326963m == true) goto L38;
        int r103 = r100.findPointerIndex(this.f326957g);
        if (r103 >= 0) goto L34;
        return false;
    L34:
        if (j(r100, r103) == false) goto L40;
        this.f326964n = true;
        return true;
    L38:
        return this.f326963m;
    L18:
        if (r100.getActionMasked() == 0) goto L20;
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = 0;
        if (this.f326970t == true) goto L5;
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L49;
        if (r102 == 1) goto L41;
        if (r102 == 2) goto L28;
        if (r102 == 3) goto L41;
        if (r102 != 6) goto L19;
        int r103 = r100.getActionIndex();
        if (r100.getPointerId(r103) != this.f326957g) goto L27;
        if (r103 != 0) goto L25;
        r101 = 1;
    L25:
        if (r101 >= r100.getPointerCount()) goto L27;
        this.f326957g = r100.getPointerId(r101);
        this.f326960j = i(r100, r101);
    L27:
        return true;
    L19:
        return super.onTouchEvent(r100);
    L28:
        int r104 = r100.findPointerIndex(this.f326957g);
        if (r104 >= 0) goto L32;
        return true;
    L32:
        if (this.f326963m == false) goto L34;
    L38:
        float r105 = i(r100, r104);
        c(r105 - this.f326960j);
        this.f326960j = r105;
        return true;
    L34:
        if (this.f326964n == false) goto L36;
    L37:
        return true;
    L36:
        if (j(r100, r104) == true) goto L38;
    L41:
        if (this.f326963m == false) goto L47;
        float r106 = this.f326973w;
        if (r100.getActionMasked() != 3) goto L45;
        boolean r107 = true;
    L46:
        d(r106, r107);
        goto L47
    L45:
        r107 = false;
    L47:
        this.f326963m = false;
        return true;
    L49:
        this.f326957g = r100.getPointerId(0);
        this.f326958h = h(r100, 0);
        float r108 = i(r100, 0);
        this.f326959i = r108;
        this.f326960j = r108;
        this.f326963m = false;
        this.f326964n = false;
        this.f326961k = e(r100.getX(), r100.getY());
        return true;
    L5:
        if (r100.getActionMasked() != 1) goto L7;
    L8:
        this.f326970t = false;
    L9:
        return true;
    L7:
        if (r100.getActionMasked() != 3) goto L9;
        goto L8
    }

    public final void setDelegate(a r100) {
        this.f326951a = r100;
    }

    public final void setInteractionEnabled(boolean r100) {
        this.f326952b = r100;
    }

    public final void setScrollInteractionBlocked(boolean r100) {
        this.f326953c = r100;
        if (r100 == true) goto L5;
        return;
    L5:
        if (this.f326962l == false) goto L7;
        this.f326970t = true;
    L7:
        requestDisallowInterceptTouchEvent(false);
    }

    public final void d(float r100, boolean r101) {
        if (this.f326971u == true) goto L5;
        return;
    L5:
        float r102 = this.f326972v;
        boolean r103 = false;
        this.f326971u = false;
        this.f326975y = null;
        this.f326972v = 0.0f;
        this.f326969s = false;
        a r104 = this.f326951a;
        if (r104 != null) goto L8;
    L10:
        if (r103 == true) goto L13;
        g();
        return;
    L13:
        return;
    L8:
        if (r104.d(r102, r100, r101) != true) goto L10;
        r103 = true;
        goto L10
    }

    public final boolean e(float r100, float r101) {
        View r102 = b(this, r100, r101);
    L3:
        boolean r103 = false;
        if (r102 == null) goto L19;
        if (r102 == this) goto L19;
        if (ViewCompat.isNestedScrollingEnabled(r102) == true) goto L9;
    L13:
        if (r103 == true) goto L14;
        Object r104 = r102.getParent();
        if ((r104 instanceof View) == true) goto L17;
        r102 = null;
        goto L3
    L17:
        r102 = (View) r104;
        goto L3
    L14:
        return true;
    L9:
        if (r102.canScrollVertically(-1) == false) goto L11;
    L12:
        r103 = true;
        goto L13
    L11:
        if (r102.canScrollVertically(1) == false) goto L13;
    L19:
        return false;
    }

    public final float h(MotionEvent r100, int r101) {
        getLocationOnScreen(this.f326965o);
        return r100.getX(r101) + this.f326965o[0];
    }

    public final float i(MotionEvent r100, int r101) {
        getLocationOnScreen(this.f326965o);
        return r100.getY(r101) + this.f326965o[1];
    }

    public final boolean j(MotionEvent r100, int r101) {
        if (this.f326963m == false) goto L6;
        return true;
    L6:
        if (this.f326952b == true) goto L8;
    L29:
        return false;
    L8:
        if (this.f326953c == true) goto L29;
        if (this.f326961k == false) goto L13;
        return false;
    L13:
        float r102 = h(r100, r101) - this.f326958h;
        float r103 = i(r100, r101) - this.f326959i;
        if (Math.abs(r103) <= this.f326955e) goto L29;
        if (Math.abs(r103) <= Math.abs(r102)) goto L29;
        a r104 = this.f326951a;
        if (r104 != null) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == false) goto L29;
        this.f326963m = true;
        this.f326960j = i(r100, r101);
        a(null);
        ViewParent r106 = getParent();
        if (r106 == null) goto L28;
        r106.requestDisallowInterceptTouchEvent(true);
    L28:
        return true;
    L20:
        if (r104.b(r103) != true) goto L22;
        r105 = true;
        goto L23
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f326954d.onStopNestedScroll(r100, r101);
        if (r101 != 0) goto L5;
        this.f326976z.remove(r100);
    L5:
        if (r101 == 0) goto L7;
        return;
    L7:
        if (this.f326975y == r100) goto L9;
        return;
    L9:
        if (this.f326971u == false) goto L11;
        d(this.f326973w, this.f326974x);
    L11:
        this.f326975y = null;
    }

    public DbxPanelDragLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f326954d = new NestedScrollingParentHelper(this);
        this.f326955e = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f326957g = -1;
        this.f326965o = new int[2];
        this.f326976z = new LinkedHashSet();
        setClickable(true);
    }

    public static View b(ViewGroup r100, float r101, float r102) {
        int r103 = r100.getChildCount() - 1;
    L3:
        if ((-1) >= r103) goto L21;
        View r104 = r100.getChildAt(r103);
        if (r104.getVisibility() != 0) goto L20;
        float r105 = ((r100.getScrollX() + r101) - r104.getLeft()) - r104.getTranslationX();
        float r106 = ((r100.getScrollY() + r102) - r104.getTop()) - r104.getTranslationY();
        if (r105 < 0.0f) goto L20;
        if (r106 < 0.0f) goto L20;
        if (r105 >= r104.getWidth()) goto L20;
        if (r106 >= r104.getHeight()) goto L20;
        if ((r104 instanceof ViewGroup) == true) goto L29;
        Intrinsics.checkNotNull(r104);
        return r104;
    L29:
        return b((ViewGroup) r104, r105, r106);
    L20:
        r103 = r103 - 1;
        goto L3
    L21:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f326971u == false) goto L8;
        if (this.f326975y != r100) goto L8;
        this.f326973w = -r102;
    L8:
        if (this.f326953c == false) goto L10;
    L17:
        return true;
    L10:
        if (this.f326976z.contains(r100) == true) goto L17;
        if (this.f326971u == true) goto L14;
    L16:
        return false;
    L14:
        if (this.f326975y != r100) goto L16;
        goto L16
    }

    public /* synthetic */ DbxPanelDragLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f326953c == false) goto L5;
    L12:
        return true;
    L5:
        if (this.f326976z.contains(r100) == true) goto L12;
        if (this.f326971u == true) goto L9;
    L11:
        return false;
    L9:
        if (this.f326975y != r100) goto L11;
        goto L11
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f326954d.onNestedScrollAccepted(r100, r101, r102, r103);
        if (r103 == 0) goto L5;
        return;
    L5:
        if (this.f326953c == false) goto L9;
        this.f326976z.add(r101);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f326952b == false) goto L5;
    L8:
        if (r103 == 0) goto L10;
    L12:
        return false;
    L10:
        if ((r102 & 2) == 0) goto L12;
        return true;
    L5:
        if (this.f326953c == true) goto L8;
        if (this.f326976z.contains(r101) == false) goto L12;
        goto L8
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if (r104 == 0) goto L6;
        return;
    L6:
        if (this.f326953c == false) goto L9;
        this.f326976z.add(r100);
    L9:
        if (this.f326976z.contains(r100) == false) goto L13;
        r103[1] = r103[1] + r102;
        return;
    L13:
        if (this.f326971u == true) goto L15;
        return;
    L15:
        if (this.f326975y != r100) goto L25;
        if (r102 <= 0) goto L26;
        Float r105 = f();
        if (r105 == null) goto L21;
        float r106 = r105.floatValue();
    L22:
        c(r106);
        r103[1] = r103[1] + r102;
        return;
    L21:
        r106 = -r102;
        goto L22
    L26:
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r110, int r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        onNestedScroll(r110, r111, r112, r113, r114, r115, new int[2]);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        if (r105 == 0) goto L6;
        return;
    L6:
        if (this.f326953c == false) goto L9;
        this.f326976z.add(r100);
    L9:
        if (this.f326976z.contains(r100) == false) goto L12;
        r106[1] = r106[1] + r104;
        return;
    L12:
        if (r104 < 0) goto L14;
        return;
    L14:
        if (this.f326952b == false) goto L38;
        boolean r107 = this.f326971u;
        if (r107 == true) goto L19;
    L21:
        if (r107 == true) goto L31;
        a r108 = this.f326951a;
        if (r108 != null) goto L25;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == true) goto L30;
        return;
    L30:
        a(r100);
        goto L31
    L25:
        if (r108.b(-r104) != true) goto L27;
        r109 = true;
    L31:
        Float r110 = f();
        if (r110 == null) goto L34;
        float r111 = r110.floatValue();
    L35:
        c(r111);
        r106[1] = r106[1] + r104;
        return;
    L34:
        r111 = -r104;
        goto L35
    L19:
        if (this.f326975y == r100) goto L21;
        return;
    }
}
