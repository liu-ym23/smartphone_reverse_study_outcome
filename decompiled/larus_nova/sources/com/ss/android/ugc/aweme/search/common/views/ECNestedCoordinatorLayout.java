package com.ss.android.ugc.aweme.search.common.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\"\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/views/ECNestedCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingChild2;", "", "enabled", "", "setNestedScrollingEnabled", "Lcom/ss/android/ugc/aweme/search/common/views/NestedCoordinatorController;", "nestedCoordinatorController", "setNestedCoordinator", "b", "Z", "getDisableChildHelper", "()Z", "setDisableChildHelper", "(Z)V", "disableChildHelper", "<set-?>", "Lcom/ss/android/ugc/aweme/search/common/views/NestedCoordinatorController;", "getNestedCoordinatorController", "()Lcom/ss/android/ugc/aweme/search/common/views/NestedCoordinatorController;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECNestedCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NestedScrollingChildHelper f452575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452576b;

    public ECNestedCoordinatorLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECNestedCoordinatorLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final NestedCoordinatorController getNestedCoordinatorController() {
        return null;
    }

    public final void setNestedCoordinator(NestedCoordinatorController r100) {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r100 = this.f452575a;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r100.isNestedScrollingEnabled();
    }

    public final boolean getDisableChildHelper() {
        return this.f452576b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r101 = this.f452575a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r101.hasNestedScrollingParent();
    }

    public final void setDisableChildHelper(boolean r100) {
        this.f452576b = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        if (this.f452576b == false) goto L5;
        return;
    L5:
        NestedScrollingChildHelper r101 = this.f452575a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L8:
        r101.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r101 = this.f452575a;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r101.startNestedScroll(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        if (this.f452576b == false) goto L5;
        return;
    L5:
        NestedScrollingChildHelper r101 = this.f452575a;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L8:
        r101.stopNestedScroll(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r102 = this.f452575a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r102.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r102 = this.f452575a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r102.startNestedScroll(r100, r101);
    }

    public ECNestedCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        if (this.f452576b == true) goto L7;
        NestedScrollingChildHelper r103 = new NestedScrollingChildHelper(this);
        this.f452575a = r103;
        r103.setNestedScrollingEnabled(true);
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r103 = this.f452575a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r103.dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return super.onNestedPreFling(r100, r101, r102);
    }

    public /* synthetic */ ECNestedCoordinatorLayout(Context r100, AttributeSet r101, int r102, int r103) {
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
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return super.onNestedFling(r100, r101, r102, r103);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        return super.onStartNestedScroll(r100, r101, r102, r103);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r103 = this.f452575a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r103.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        super.onNestedPreScroll(r100, r101, r102, r103, r104);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        if (this.f452576b == false) goto L6;
        return false;
    L6:
        NestedScrollingChildHelper r102 = this.f452575a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L10:
        return r102.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        super.onNestedScroll(r100, r101, r102, r103, r104, r105);
    }
}
