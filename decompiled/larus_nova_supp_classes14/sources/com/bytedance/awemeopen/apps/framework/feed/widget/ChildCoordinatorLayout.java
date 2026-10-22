package com.bytedance.awemeopen.apps.framework.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003JS\u0010\u0010\u001a\u00020\u00052K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/widget/ChildCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingChild2;", "", "isIntercept", "", "setIsIntercept", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "target", "", "dx", "dy", "needInterceptScroll", "setNeedInterceptScroll", "enabled", "setNestedScrollingEnabled", "Landroidx/core/view/NestedScrollingChildHelper;", "a", "Lkotlin/Lazy;", "getChildHelper", "()Landroidx/core/view/NestedScrollingChildHelper;", "childHelper", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ChildCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild2 {
    public final Lazy a;
    public Function3<? super View, ? super Float, ? super Float, Boolean> b;
    public boolean c;

    public ChildCoordinatorLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChildCoordinatorLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final NestedScrollingChildHelper getChildHelper() {
        return (NestedScrollingChildHelper) this.a.getValue();
    }

    public final boolean isNestedScrollingEnabled() {
        return getChildHelper().isNestedScrollingEnabled();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        boolean r0 = super/*android.view.ViewGroup*/.dispatchTouchEvent(r4);
        boolean r2 = false;
        if (r4 != null) goto L5;
    L7:
        if (r2 == false) goto L12;
        if (r0 == false) goto L12;
        if (this.c == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
    L12:
        return r0;
    L5:
        if (r4.getActionMasked() != 0) goto L7;
        r2 = true;
        goto L7
    }

    public final boolean hasNestedScrollingParent(int r1) {
        return getChildHelper().hasNestedScrollingParent();
    }

    public final void setIsIntercept(boolean r1) {
        this.c = r1;
    }

    public final void setNeedInterceptScroll(Function3<? super View, ? super Float, ? super Float, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "needInterceptScroll");
        this.b = r2;
    }

    public void setNestedScrollingEnabled(boolean r2) {
        getChildHelper().setNestedScrollingEnabled(r2);
    }

    public final boolean startNestedScroll(int r2) {
        return getChildHelper().startNestedScroll(r2);
    }

    public final void stopNestedScroll(int r2) {
        getChildHelper().stopNestedScroll(r2);
    }

    public final boolean dispatchNestedPreFling(float r2, float r3) {
        return getChildHelper().dispatchNestedPreFling(r2, r3);
    }

    public final void onStopNestedScroll(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "target");
        super.onStopNestedScroll(r2, r3);
        stopNestedScroll(r3);
    }

    public final boolean startNestedScroll(int r2, int r3) {
        return getChildHelper().startNestedScroll(r2, r3);
    }

    public ChildCoordinatorLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new ChildCoordinatorLayout$childHelper$2(this));
    }

    public final boolean dispatchNestedFling(float r2, float r3, boolean r4) {
        return getChildHelper().dispatchNestedFling(r2, r3, r4);
    }

    public final boolean onNestedPreFling(View r7, float r8, float r9) {
        Intrinsics.checkNotNullParameter(r7, "target");
        boolean r0 = super.onNestedPreFling(r7, r8, r9);
        Function3<? super View, ? super Float, ? super Float, Boolean> r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        if (r10 == true) goto L10;
        boolean r11 = dispatchNestedPreFling(r8, r9);
    L11:
        if (r11 == true) goto L16;
        if (r0 == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    L10:
        r11 = false;
        goto L11
    L5:
        if (((Boolean) r1.invoke(r7, Float.valueOf(r8), Float.valueOf(r9))).booleanValue() != true) goto L7;
        r10 = true;
        goto L8
    }

    public /* synthetic */ ChildCoordinatorLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r3 & 4) == 0) goto L8;
        int r5 = 2130969638;
    L9:
        this(r1, r2, r5);
        return;
    L8:
        r5 = 0;
        goto L9
    }

    public final boolean onNestedFling(View r7, float r8, float r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "target");
        boolean r0 = super.onNestedFling(r7, r8, r9, r10);
        Function3<? super View, ? super Float, ? super Float, Boolean> r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        if (r11 == true) goto L10;
        boolean r12 = dispatchNestedFling(r8, r9, r10);
    L11:
        if (r12 == true) goto L16;
        if (r0 == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    L10:
        r12 = false;
        goto L11
    L5:
        if (((Boolean) r1.invoke(r7, Float.valueOf(r8), Float.valueOf(r9))).booleanValue() != true) goto L7;
        r11 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedPreScroll(View r7, int r8, int r9, int[] r10) {
        Intrinsics.checkNotNullParameter(r7, "target");
        Intrinsics.checkNotNullParameter(r10, "consumed");
        int[] r0 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        dispatchNestedPreScroll(r8, r9, r0, null);
        r10[0] = r10[0] + r0[0];
        r10[1] = r10[1] + r0[1];
        r0[0] = 0;
        r0[1] = 0;
    L10:
        super.onNestedPreScroll(r7, r8 - r10[0], r9 - r10[1], r0);
        r10[0] = r10[0] + r0[0];
        r10[1] = r10[1] + r0[1];
        return;
    L5:
        if (((Boolean) r1.invoke(r7, Float.valueOf(r8), Float.valueOf(r9))).booleanValue() != true) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean onStartNestedScroll(View r2, View r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "child");
        Intrinsics.checkNotNullParameter(r3, "target");
        if (r5 != 0) goto L5;
        stopNestedScroll(1);
        ViewCompat.stopNestedScroll(r2, 1);
    L5:
        boolean r6 = super.onStartNestedScroll(r2, r3, r4, r5);
        if (startNestedScroll(r4, r5) == true) goto L11;
        if (r6 == true) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    public final boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    public final void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r13, "consumed");
        int[] r0 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r1 = this.b;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        dispatchNestedPreScroll(r11, r12, r0, null, r14);
        r13[0] = r13[0] + r0[0];
        r13[1] = r13[1] + r0[1];
        r0[0] = 0;
        r0[1] = 0;
    L10:
        super.onNestedPreScroll(r10, r11 - r13[0], r12 - r13[1], r0, r14);
        r13[0] = r13[0] + r0[0];
        r13[1] = r13[1] + r0[1];
        return;
    L5:
        if (((Boolean) r1.invoke(r10, Float.valueOf(r11), Float.valueOf(r12))).booleanValue() != true) goto L7;
        r2 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNestedScroll(View r11, int r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "target");
        int[] r0 = {r11, r1};
        r11.getLocationInWindow(r0);
        int r2 = r0[0];
        int r4 = r0[1];
        super.onNestedScroll(r11, r12, r13, r14, r15);
        r11.getLocationInWindow(r0);
        int r16 = r0[0] - r2;
        int r1 = r0[1] - r4;
        dispatchNestedScroll(r12, r13, r14 + r16, r15 + r1, null);
    }

    public final boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return getChildHelper().dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    public final void onNestedScroll(View r11, int r12, int r13, int r14, int r15, int r16) {
        Intrinsics.checkNotNullParameter(r11, "target");
        int[] r1 = {r0, r2};
        r11.getLocationInWindow(r1);
        int r3 = r1[0];
        int r5 = r1[1];
        super.onNestedScroll(r11, r12, r13, r14, r15, r16);
        r11.getLocationInWindow(r1);
        int r0 = r1[0] - r3;
        int r2 = r1[1] - r5;
        dispatchNestedScroll(r12, r13, r14 + r0, r15 + r2, null, r16);
    }
}
