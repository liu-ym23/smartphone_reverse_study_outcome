package com.bytedance.awemeopen.apps.framework.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003JS\u0010\u0010\u001a\u00020\u00052K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u0007J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/widget/ChildCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingChild2;", "", "isIntercept", "", "setIsIntercept", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", PickerReporterConstants.KEY.TARGET, "", "dx", "dy", "needInterceptScroll", "setNeedInterceptScroll", "enabled", "setNestedScrollingEnabled", "Landroidx/core/view/NestedScrollingChildHelper;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getChildHelper", "()Landroidx/core/view/NestedScrollingChildHelper;", "childHelper", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class ChildCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f196827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super View, ? super Float, ? super Float, Boolean> f196828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f196829c;

    public ChildCoordinatorLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChildCoordinatorLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final NestedScrollingChildHelper getChildHelper() {
        return (NestedScrollingChildHelper) this.f196827a.getValue();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        return getChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        boolean r101 = super.dispatchTouchEvent(r100);
        boolean r102 = false;
        if (r100 != null) goto L5;
    L7:
        if (r102 == false) goto L12;
        if (r101 == false) goto L12;
        if (this.f196829c == false) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
    L12:
        return r101;
    L5:
        if (r100.getActionMasked() != 0) goto L7;
        r102 = true;
        goto L7
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        return getChildHelper().hasNestedScrollingParent();
    }

    public final void setIsIntercept(boolean r100) {
        this.f196829c = r100;
    }

    public final void setNeedInterceptScroll(Function3<? super View, ? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "needInterceptScroll");
        this.f196828b = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        getChildHelper().setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        return getChildHelper().startNestedScroll(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        getChildHelper().stopNestedScroll(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        return getChildHelper().dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        return getChildHelper().startNestedScroll(r100, r101);
    }

    public ChildCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f196827a = LazyKt.lazy(new ChildCoordinatorLayout$childHelper$2(this));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return getChildHelper().dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        boolean r103 = super.onNestedPreFling(r100, r101, r102);
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f196828b;
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
        boolean r106 = dispatchNestedPreFling(r101, r102);
    L11:
        if (r106 == true) goto L16;
        if (r103 == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    L10:
        r106 = false;
        goto L11
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() != true) goto L7;
        r105 = true;
        goto L8
    }

    public /* synthetic */ ChildCoordinatorLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        int r104 = R.attr.coordinatorLayoutStyle;
    L9:
        this(r100, r101, r104);
        return;
    L8:
        r104 = 0;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        boolean r103 = super.onNestedFling(r100, r101, r102, r110);
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f196828b;
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
        boolean r106 = dispatchNestedFling(r101, r102, r110);
    L11:
        if (r106 == true) goto L16;
        if (r103 == true) goto L17;
        return false;
    L17:
        return true;
    L16:
        return true;
    L10:
        r106 = false;
        goto L11
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() != true) goto L7;
        r105 = true;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "consumed");
        int[] r103 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f196828b;
        if (r104 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
        dispatchNestedPreScroll(r101, r102, r103, null);
        r110[0] = r110[0] + r103[0];
        r110[1] = r110[1] + r103[1];
        r103[0] = 0;
        r103[1] = 0;
    L10:
        super.onNestedPreScroll(r100, r101 - r110[0], r102 - r110[1], r103);
        r110[0] = r110[0] + r103[0];
        r110[1] = r110[1] + r103[1];
        return;
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() != true) goto L7;
        r105 = true;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 != 0) goto L5;
        stopNestedScroll(1);
        ViewCompat.stopNestedScroll(r100, 1);
    L5:
        boolean r104 = super.onStartNestedScroll(r100, r101, r102, r103);
        if (startNestedScroll(r102, r103) == true) goto L11;
        if (r104 == true) goto L12;
        return false;
    L12:
        return true;
    L11:
        return true;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return getChildHelper().dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r110, int r111, int r112, int[] r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r113, "consumed");
        int[] r100 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r101 = this.f196828b;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        dispatchNestedPreScroll(r111, r112, r100, null, r114);
        r113[0] = r113[0] + r100[0];
        r113[1] = r113[1] + r100[1];
        r100[0] = 0;
        r100[1] = 0;
    L10:
        super.onNestedPreScroll(r110, r111 - r113[0], r112 - r113[1], r100, r114);
        r113[0] = r113[0] + r100[0];
        r113[1] = r113[1] + r100[1];
        return;
    L5:
        if (r101.invoke(r110, Float.valueOf(r111), Float.valueOf(r112)).booleanValue() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedScroll(View r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        int[] r100 = {r11, r1};
        r110.getLocationInWindow(r100);
        int r101 = r100[0];
        int r102 = r100[1];
        super.onNestedScroll(r110, r111, r112, r113, r114);
        r110.getLocationInWindow(r100);
        int r115 = r100[0] - r101;
        int r103 = r100[1] - r102;
        dispatchNestedScroll(r111, r112, r113 + r115, r114 + r103, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return getChildHelper().dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r110, int r111, int r112, int r113, int r114, int r115) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        int[] r100 = {r0, r2};
        r110.getLocationInWindow(r100);
        int r101 = r100[0];
        int r102 = r100[1];
        super.onNestedScroll(r110, r111, r112, r113, r114, r115);
        r110.getLocationInWindow(r100);
        int r103 = r100[0] - r101;
        int r104 = r100[1] - r102;
        dispatchNestedScroll(r111, r112, r113 + r103, r114 + r104, null, r115);
    }
}
