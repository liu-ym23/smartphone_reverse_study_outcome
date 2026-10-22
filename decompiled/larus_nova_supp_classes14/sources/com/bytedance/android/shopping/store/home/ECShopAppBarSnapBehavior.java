package com.bytedance.android.shopping.store.home;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.store.widget.ECOverScrollExpandBehavior;
import com.bytedance.android.ec.store.widget.ECOverScrollExpandCoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/ECShopAppBarSnapBehavior;", "Lcom/bytedance/android/ec/store/widget/ECOverScrollExpandBehavior;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAppBarSnapBehavior extends ECOverScrollExpandBehavior {
    public final int a;
    public CoordinatorLayout b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public final void recover() {
        super.recover();
    }

    public final int applyAdjust(int r1) {
        return super.applyAdjust(r1);
    }

    public final void initOnce(View r3) {
        Intrinsics.checkNotNullParameter(r3, "coordinator");
        super.initOnce(r3);
        if (this.b != null) goto L14;
        AppBarLayout r1 = null;
        if ((r3 instanceof CoordinatorLayout) == true) goto L7;
        View r0 = null;
    L8:
        this.b = (CoordinatorLayout) r0;
        AppBarLayout r4 = qc3.a.a(r3, AnonymousClass1.INSTANCE);
        if ((r4 instanceof AppBarLayout) == false) goto L13;
        r1 = r4;
    L13:
        return;
    L7:
        r0 = r3;
        goto L8
    }

    public ECShopAppBarSnapBehavior(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = 16;
        com.bytedance.android.shopping.extensions.b.b(120);
        com.bytedance.android.shopping.extensions.b.b(150);
        com.bytedance.android.shopping.extensions.b.b(40);
        this.e = true;
        this.i = -1;
        this.k = true;
    }

    public final void adjustTarget(int r1, int r2) {
        super.adjustTarget(r1, r2);
    }

    public final boolean snapToBoundaryIfNeed(CoordinatorLayout r2, AppBarLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "abl");
        currentOffset();
        if (this.c == false) goto L7;
        return true;
    L7:
        return super/*com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior*/.snapToBoundaryIfNeed(r2, r3);
    }

    public final boolean onTouchEvent(CoordinatorLayout r8, AppBarLayout r9, MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r8, "parent");
        Intrinsics.checkNotNullParameter(r9, "child");
        Intrinsics.checkNotNullParameter(r10, "ev");
        int r0 = r10.getActionMasked();
        boolean r1 = false;
        if (r0 != 1) goto L5;
    L32:
        this.i = -1;
        this.j = 0;
        currentOffset();
    L34:
        return super/*com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior*/.onTouchEvent(r8, r9, r10);
    L5:
        if (r0 != 2) goto L7;
        int r2 = this.i;
        if (r2 >= 0) goto L12;
        int r3 = 0;
    L13:
        this.i = (int) r10.getRawY();
        this.j += r3;
        int r4 = currentOffset();
        if (this.j >= getTouchSlop()) goto L16;
    L22:
        if (r1 == false) goto L34;
        if ((r8 instanceof ECOverScrollExpandCoordinatorLayout) == true) goto L26;
        CoordinatorLayout r11 = null;
    L27:
        ECOverScrollExpandCoordinatorLayout r12 = (ECOverScrollExpandCoordinatorLayout) r11;
        if (r12 == null) goto L30;
        r12.setTouchStoreInfoAreaSnapToheadEnable(true);
    L30:
        snapTo(getSnapToHeadHeight(), r8, r9);
        return true;
    L26:
        r11 = r8;
        goto L27
    L16:
        if (Math.abs(r4) >= Math.abs(0)) goto L22;
        if (Math.abs(r4) < (Math.abs(0) * 0.9f)) goto L20;
    L21:
        r1 = true;
        goto L22
    L20:
        if ((Math.abs(r4) + r3) < Math.abs(0)) goto L22;
    L12:
        r3 = r2 - ((int) r10.getRawY());
        goto L13
    L7:
        if (r0 == 3) goto L32;
        goto L32
    }

    public final void onStopNestedScroll(CoordinatorLayout r11, AppBarLayout r12, View r13, int r14) {
        Intrinsics.checkNotNullParameter(r11, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r12, "abl");
        Intrinsics.checkNotNullParameter(r13, "target");
        this.f = false;
        this.g = false;
        int r1 = currentOffset();
        if (this.d == false) goto L15;
        if (Math.abs(r1) < (((double) Math.abs(0)) * 0.5d)) goto L7;
    L9:
        boolean r2 = false;
    L11:
        if (this.c == true) goto L15;
        if (r2 == false) goto L15;
        this.c = true;
        ValueAnimator r3 = ValueAnimator.ofInt(new int[]{r1, 0}).setDuration(200);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new b(this, r11, r12, r13));
        r3.addListener(new c(this, r11, r12, r13, r14));
        r3.start();
        goto L15
    L7:
        if (Math.abs(r1) <= 0) goto L9;
        r2 = true;
    L15:
        if (this.d == false) goto L17;
    L18:
        Math.abs(r1);
        Math.abs(0);
    L19:
        if (r14 != 0) goto L21;
        this.d = false;
        this.k = false;
        this.h = false;
    L21:
        super.onStopNestedScroll(r11, r12, r13, r14);
        return;
    L17:
        if (this.k == false) goto L19;
        goto L18
    }

    public final /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r1, View r2, View r3, int r4) {
        onStopNestedScroll(r1, (AppBarLayout) r2, r3, r4);
    }

    public final boolean onNestedPreFling(CoordinatorLayout r2, AppBarLayout r3, View r4, float r5, float r6) {
        Intrinsics.checkNotNullParameter(r2, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r3, "child");
        Intrinsics.checkNotNullParameter(r4, "target");
        return super.onNestedPreFling(r2, r3, r4, r5, r6);
    }

    public final /* bridge */ /* synthetic */ boolean onNestedPreFling(CoordinatorLayout r1, View r2, View r3, float r4, float r5) {
        return onNestedPreFling(r1, (AppBarLayout) r2, r3, r4, r5);
    }

    public final void onNestedPreScroll(CoordinatorLayout r7, AppBarLayout r8, View r9, int r10, int r11, int[] r12, int r13) {
        Intrinsics.checkNotNullParameter(r7, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r8, "child");
        Intrinsics.checkNotNullParameter(r9, "target");
        Intrinsics.checkNotNullParameter(r12, "consumed");
        if (r13 == 0) goto L5;
    L7:
        int r1 = currentOffset();
        boolean r2 = false;
        if (r11 > 0) goto L10;
    L13:
        Math.abs(r1);
    L14:
        if (r11 < 0) goto L16;
    L19:
        if (r11 >= 0) goto L27;
        if (r1 != 0) goto L27;
        if (r13 != 0) goto L27;
        if (this.g == false) goto L27;
        if (isExpand() == true) goto L27;
        boolean r3 = true;
    L28:
        if (r11 < 0) goto L30;
    L33:
        boolean r4 = false;
    L35:
        if (this.c == true) goto L39;
        if (r3 == true) goto L38;
        if (r4 == false) goto L39;
    L38:
        r12[1] = r11;
        ViewCompat.stopNestedScroll(r9, r13);
        boolean r5 = true;
    L40:
        if (r5 == false) goto L42;
        return;
    L42:
        if (r11 > 0) goto L44;
    L48:
        if (r2 == false) goto L50;
        return;
    L50:
        this.f = true;
        this.g = true;
        super.onNestedPreScroll(r7, r8, r9, r10, r11, r12, r13);
        return;
    L44:
        if (this.e == true) goto L48;
        if ((getTopAndBottomOffset() - r11) > getSnapToHeadHeight()) goto L48;
        int r6 = r1 - getSnapToHeadHeight();
        int r14 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r11, 0), r6);
        snapTo(r1 - r14, r7, r8);
        r12[1] = r14;
        r2 = true;
    L39:
        r5 = false;
        goto L40
    L30:
        if ((r1 - r11) < 0) goto L33;
        if (r13 != 1) goto L33;
        r4 = true;
    L27:
        r3 = false;
        goto L28
    L16:
        if (Math.abs(r11) <= this.a) goto L19;
        if (r13 != 0) goto L19;
        this.d = true;
        goto L19
    L10:
        if (Math.abs(r1) != Math.abs(0)) goto L13;
        if (this.f == true) goto L14;
    L5:
        if (this.h == true) goto L7;
        this.h = true;
        goto L7
    }

    public final /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout r1, View r2, View r3, int r4, int r5, int[] r6, int r7) {
        onNestedPreScroll(r1, (AppBarLayout) r2, r3, r4, r5, r6, r7);
    }

    public final void onNestedScroll(CoordinatorLayout r3, AppBarLayout r4, View r5, int r6, int r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r3, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r4, "child");
        Intrinsics.checkNotNullParameter(r5, "target");
        if (r9 < 0) goto L5;
    L12:
        super/*com.bytedance.android.ec.store.widget.ControllableAppBarSnapBehavior*/.onNestedScroll(r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L5:
        if (canScrollVertically(r5) == true) goto L12;
        if (r10 != 1) goto L12;
        if (Math.abs(currentOffset()) > Math.abs(0)) goto L12;
        ViewCompat.stopNestedScroll(r5, r10);
    }
}
