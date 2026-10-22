package com.larus.reach.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/reach/ui/ReachSwipeDismissLayout;", "Lcom/larus/common_ui/venus/ShapeLinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeDirection", "getSwipeDirection", "()I", "setSwipeDirection", "(I)V", "canHandleSwipe", "Lkotlin/Function0;", "", "getCanHandleSwipe", "()Lkotlin/jvm/functions/Function0;", "setCanHandleSwipe", "(Lkotlin/jvm/functions/Function0;)V", "onSwipeDismiss", "", "getOnSwipeDismiss", "setOnSwipeDismiss", "touchSlop", "downX", "", "downY", "intercepting", "dismissRequested", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "shouldIntercept", "hasMovedBeyondTap", "swipeEnabled", "cancelPendingClick", BasicTestActionHandler.TEST_ACTION_RESET, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReachSwipeDismissLayout extends ShapeLinearLayout {
    public int N;
    public Function0<Boolean> O;
    public Function0<Unit> P;
    public final int Q;
    public float R;
    public float S;
    public boolean T;
    public boolean U;

    public static final class a {
    }

    static {
    }

    public ReachSwipeDismissLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReachSwipeDismissLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void i() {
        this.T = false;
        this.U = false;
    }

    public final boolean k() {
        Function0<Boolean> r100 = this.O;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L12:
        return false;
    L10:
        if (this.P == null) goto L12;
        return true;
    L5:
        if (r100.invoke().booleanValue() == true) goto L7;
        r101 = true;
        goto L8
    }

    public final Function0<Boolean> getCanHandleSwipe() {
        return this.O;
    }

    public final Function0<Unit> getOnSwipeDismiss() {
        return this.P;
    }

    public final int getSwipeDirection() {
        return this.N;
    }

    public final boolean h(MotionEvent r100) {
        float r101 = r100.getRawX() - this.R;
        float r102 = r100.getRawY() - this.S;
        if (Math.abs(r101) <= this.Q) goto L5;
    L8:
        return true;
    L5:
        if (Math.abs(r102) > this.Q) goto L8;
        return false;
    }

    public final boolean j(MotionEvent r100) {
        float r101 = r100.getRawX() - this.R;
        float r102 = r100.getRawY() - this.S;
        if (h(r100) == true) goto L6;
        return false;
    L6:
        if (this.N != 1) goto L11;
        if (r102 > this.Q) goto L12;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
        return false;
    L16:
        if (Math.abs(r102) <= Math.abs(r101)) goto L20;
        return true;
    L20:
        return false;
    L12:
        r103 = true;
        goto L14
    L11:
        if (r102 >= (-this.Q)) goto L13;
        goto L12
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (k() == true) goto L6;
        i();
        return super.onInterceptTouchEvent(r100);
    L6:
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L9;
        this.R = r100.getRawX();
        this.S = r100.getRawY();
        this.T = false;
        this.U = false;
    L33:
        return super.onInterceptTouchEvent(r100);
    L9:
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L19;
        if (r101 != 3) goto L33;
        if (this.U == true) goto L33;
        i();
        goto L33
    L19:
        if (j(r100) == false) goto L33;
        this.T = true;
        ViewParent r102 = getParent();
        if (r102 == null) goto L23;
        r102.requestDisallowInterceptTouchEvent(true);
    L23:
        return true;
    L25:
        if (h(r100) == false) goto L29;
        this.T = true;
        return true;
    L29:
        if (this.U == true) goto L33;
        i();
        goto L33
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (k() == true) goto L6;
        i();
        return super.onTouchEvent(r100);
    L6:
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L58;
        if (r101 != 1) goto L10;
        boolean r102 = h(r100);
        if (j(r100) == true) goto L38;
    L42:
        if (r102 == false) goto L44;
    L49:
        boolean r103 = true;
    L50:
        i();
        ViewParent r104 = getParent();
        if (r104 == null) goto L53;
        r104.requestDisallowInterceptTouchEvent(false);
    L53:
        if (r103 == false) goto L55;
    L56:
        return true;
    L55:
        if (super.onTouchEvent(r100) == true) goto L56;
        return false;
    L44:
        if (this.T == true) goto L49;
        if (this.U == true) goto L49;
        r103 = false;
        goto L50
    L38:
        if (this.U == true) goto L42;
        this.U = true;
        Function0<Unit> r105 = this.P;
        if (r105 == null) goto L42;
        r105.invoke();
        goto L42
    L10:
        if (r101 == 2) goto L23;
        if (r101 != 3) goto L60;
        if (this.U == false) goto L19;
        i();
        ViewParent r106 = getParent();
        if (r106 == null) goto L18;
        r106.requestDisallowInterceptTouchEvent(false);
    L18:
        return true;
    L19:
        i();
        ViewParent r107 = getParent();
        if (r107 == null) goto L60;
        r107.requestDisallowInterceptTouchEvent(false);
    L60:
        if (this.T == false) goto L62;
    L63:
        return true;
    L62:
        if (super.onTouchEvent(r100) == true) goto L63;
        return false;
    L23:
        if (this.T == true) goto L27;
        if (j(r100) == false) goto L60;
    L27:
        if (this.U == true) goto L60;
        this.T = true;
        this.U = true;
        MotionEvent r108 = MotionEvent.obtain(r100);
        r108.setAction(3);
        super.onTouchEvent(r108);
        r108.recycle();
        Function0<Unit> r109 = this.P;
        if (r109 == null) goto L31;
        r109.invoke();
    L31:
        ViewParent r110 = getParent();
        if (r110 == null) goto L34;
        r110.requestDisallowInterceptTouchEvent(false);
    L34:
        return true;
    L58:
        this.R = r100.getRawX();
        this.S = r100.getRawY();
        this.T = false;
        this.U = false;
        goto L60
    }

    public final void setCanHandleSwipe(Function0<Boolean> r100) {
        this.O = r100;
    }

    public final void setOnSwipeDismiss(Function0<Unit> r100) {
        this.P = r100;
    }

    public final void setSwipeDirection(int r100) {
        this.N = r100;
    }

    public ReachSwipeDismissLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.N = -1;
        this.Q = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ ReachSwipeDismissLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
