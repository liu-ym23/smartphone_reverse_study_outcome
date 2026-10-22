package com.bytedance.ee.bear.bitable.core.infoarch.basemain.controller;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J8\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u001a\u0010\u001f\u001a\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u0010!\u001a\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bJ\u001e\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000eJ\u000e\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0012J(\u0010'\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u000eH\u0002J0\u0010)\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0005H\u0002J:\u0010-\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0006\u00101\u001a\u00020\fJ\u0010\u00102\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001bH\u0002J\u0018\u00103\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J\u0012\u00104\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u0012H\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u001b2\u0006\u0010#\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/controller/OfficeBaseMainHeaderAppBarBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "<init>", "()V", "currentOffset", "", "expandedHeaderHeight", "offsetAnimator", "Landroid/animation/ValueAnimator;", "offsetListeners", "", "Lkotlin/Function1;", "", "onLayoutChild", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "abl", "Lcom/google/android/material/appbar/AppBarLayout;", "layoutDirection", "onInterceptTouchEvent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "onStartNestedScroll", "directTargetChild", "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "axes", "type", "addOnOffsetChangedListener", "listener", "removeOnOffsetChangedListener", "setHeaderCollapsed", "appBarLayout", "collapsed", "animate", BasicTestActionHandler.TEST_ACTION_RESET, "setHeaderOffset", "offset", "animateHeaderClipHeight", "clipContainer", "header", "targetHeight", "applyHeaderClipHeight", "height", "dispatchDependentChanged", "dispatchOffsetChanged", "cancelOffsetAnimation", "refreshExpandedHeaderHeight", "getCurrentClipHeight", "getHeader", "getHeaderClipContainer", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseMainHeaderAppBarBehavior extends AppBarLayout.Behavior {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f210312e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f210313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f210314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f210315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<Function1<Integer, Unit>> f210316d;

    public static final class a {
        public static OfficeBaseMainHeaderAppBarBehavior a(AppBarLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "appBarLayout");
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();
            if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L5;
            CoordinatorLayout.LayoutParams r102 = (CoordinatorLayout.LayoutParams) r101;
        L6:
            if (r102 == null) goto L8;
            CoordinatorLayout.Behavior r103 = r102.getBehavior();
        L10:
            if ((r103 instanceof OfficeBaseMainHeaderAppBarBehavior) == true) goto L12;
            return null;
        L12:
            return (OfficeBaseMainHeaderAppBarBehavior) r103;
        L8:
            r103 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    public OfficeBaseMainHeaderAppBarBehavior() {
        this.f210316d = new LinkedHashSet();
    }

    public final void b(View r100) {
        int r101 = Math.max(r100.getMeasuredHeight(), r100.getHeight());
        if (r101 <= 0) goto L8;
        if (this.f210313a != 0) goto L8;
        this.f210314b = r101;
        return;
    L8:
        if (this.f210314b > 0) goto L13;
        if (r101 <= 0) goto L14;
        this.f210314b = r101;
        return;
    L14:
        return;
    }

    public final void c(AppBarLayout r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "appBarLayout");
        ViewParent r100 = r110.getParent();
        if ((r100 instanceof CoordinatorLayout) == false) goto L5;
        CoordinatorLayout r101 = (CoordinatorLayout) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        View r102 = r110.findViewById(R.id.bitable_header_container);
        if (r102 != null) goto L11;
        return;
    L11:
        b(r102);
        int r103 = this.f210314b;
        if (r111 == false) goto L14;
        int r113 = -r103;
    L15:
        View r104 = r110.findViewById(R.id.bitable_header_container);
        if (r104 == null) goto L48;
        View r105 = r110.findViewById(R.id.bitable_header_clip_container);
        if (r105 != null) goto L21;
        View r106 = r104;
    L22:
        b(r104);
        int r107 = this.f210314b;
        if (r107 <= 0) goto L49;
        int r114 = RangesKt.coerceIn(r113, -r107, 0);
        if (r112 == false) goto L42;
        int r115 = r114 + r107;
        ValueAnimator r116 = this.f210315c;
        if (r116 == null) goto L30;
        r116.cancel();
    L30:
        this.f210315c = null;
        if (r106.getVisibility() != 8) goto L33;
        int r117 = 0;
    L34:
        if (r117 <= 0) goto L36;
    L39:
        if (r117 == r115) goto L50;
        r106.setVisibility(0);
        r104.setVisibility(0);
        ValueAnimator r118 = ValueAnimator.ofInt(new int[]{r117, r115});
        r118.setDuration(300);
        r118.setInterpolator(new DecelerateInterpolator());
        r118.addUpdateListener(new f(this, r101, r110, r106, r104));
        r118.addListener(new g(this, r106, r104, r115, r110, r101));
        r118.start();
        this.f210315c = r118;
        return;
    L50:
        return;
    L36:
        if (this.f210313a < 0) goto L39;
        r117 = RangesKt.coerceAtLeast(Math.max(r104.getHeight(), r104.getMeasuredHeight()), 0);
        goto L39
    L33:
        r117 = RangesKt.coerceAtLeast(Math.max(r106.getHeight(), r106.getMeasuredHeight()), 0);
        goto L34
    L42:
        ValueAnimator r119 = this.f210315c;
        if (r119 == null) goto L45;
        r119.cancel();
    L45:
        this.f210315c = null;
        a(r101, r110, r106, r104, r107 + r114, true);
        return;
    L49:
        return;
    L21:
        r106 = r105;
        goto L22
    L48:
        return;
    L14:
        r113 = 0;
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter((AppBarLayout) r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "ev");
        return false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public final boolean onLayoutChild(CoordinatorLayout r100, AppBarLayout r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, "abl");
        boolean r112 = super.onLayoutChild(r100, r110, r111);
        r110.setClipChildren(true);
        r110.setClipToPadding(true);
        View r101 = r110.findViewById(R.id.bitable_header_container);
        if (r101 != null) goto L5;
        return r112;
    L5:
        View r102 = r110.findViewById(R.id.bitable_header_clip_container);
        if (r102 != null) goto L8;
        View r103 = r101;
    L9:
        b(r101);
        int r104 = this.f210314b;
        if (r104 > 0) goto L12;
        return r112;
    L12:
        int r105 = RangesKt.coerceIn(this.f210313a, -r104, 0);
        a(r100, r110, r103, r101, this.f210314b + r105, false);
        return r112;
    L8:
        r103 = r102;
        goto L9
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter((AppBarLayout) r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "ev");
        return false;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout r100, View r101, int r102) {
        return onLayoutChild(r100, (AppBarLayout) r101, r102);
    }

    public final void a(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, boolean r105) {
        int r106 = RangesKt.coerceIn(r104, 0, this.f210314b);
        r102.setVisibility(0);
        r103.setVisibility(0);
        ViewGroup.LayoutParams r107 = r102.getLayoutParams();
        r107.height = r106;
        r102.setLayoutParams(r107);
        r103.setTranslationY(0.0f);
        r103.setAlpha(1.0f);
        this.f210313a = -(this.f210314b - r106);
        r102.requestLayout();
        r101.requestLayout();
        if (r105 == false) goto L5;
        r100.dispatchDependentViewsChanged(r101);
    L5:
        int r108 = this.f210313a;
        Iterator<T> r109 = this.f210316d.iterator();
    L7:
        if (r109.hasNext() == false) goto L9;
        ((Function1) r109.next()).invoke(Integer.valueOf(r108));
        goto L7
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r110, View r111, int r112, int r113) {
        onStartNestedScroll(r100, (AppBarLayout) r101, r110, r111, r112, r113);
        return false;
    }
}
