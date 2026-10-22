package com.ss.android.ugc.aweme.search.vision.result.panel.widget;

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
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJS\u0010\u0016\u001a\u00020\u00052K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\rJ\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\bH\u0016¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/PhotoSearchCoordinatorLayout;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroidx/core/view/NestedScrollingChild2;", "Lcom/ss/android/ugc/aweme/search/vision/result/panel/widget/OnDownListener;", "listener", "", "setDownListener", "Lkotlin/Function0;", "", "interceptScroll", "setInterceptScroll", "isIntercept", "setIsIntercept", "Lkotlin/Function3;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", PickerReporterConstants.KEY.TARGET, "", "dx", "dy", "needInterceptScroll", "setNeedInterceptScroll", "enabled", "setNestedScrollingEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchCoordinatorLayout extends CoordinatorLayout implements NestedScrollingChild2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NestedScrollingChildHelper f453750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function3<? super View, ? super Float, ? super Float, Boolean> f453751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f453752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Boolean> f453753d;

    public PhotoSearchCoordinatorLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PhotoSearchCoordinatorLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setDownListener(OnDownListener r100) {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean isNestedScrollingEnabled() {
        NestedScrollingChildHelper r100 = this.f453750a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r100.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = super.dispatchTouchEvent(r100);
        if (r100.getActionMasked() != 0) goto L8;
        if (r101 == false) goto L8;
        if (this.f453752c == false) goto L8;
        getParent().requestDisallowInterceptTouchEvent(true);
    L8:
        return r101;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean hasNestedScrollingParent(int r100) {
        NestedScrollingChildHelper r101 = this.f453750a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r101.hasNestedScrollingParent();
    }

    public final void setInterceptScroll(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptScroll");
        this.f453753d = r100;
    }

    public final void setIsIntercept(boolean r100) {
        this.f453752c = r100;
    }

    public final void setNeedInterceptScroll(Function3<? super View, ? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "needInterceptScroll");
        this.f453751b = r100;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        NestedScrollingChildHelper r101 = this.f453750a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L5:
        r101.setNestedScrollingEnabled(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean startNestedScroll(int r100) {
        NestedScrollingChildHelper r101 = this.f453750a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r101.startNestedScroll(r100);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final void stopNestedScroll(int r100) {
        NestedScrollingChildHelper r101 = this.f453750a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L5:
        r101.stopNestedScroll(r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedPreFling(float r100, float r101) {
        NestedScrollingChildHelper r102 = this.f453750a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r102.dispatchNestedPreFling(r100, r101);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        super.onStopNestedScroll(r100, r101);
        stopNestedScroll(r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public final boolean startNestedScroll(int r100, int r101) {
        NestedScrollingChildHelper r102 = this.f453750a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r102.startNestedScroll(r100, r101);
    }

    public PhotoSearchCoordinatorLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        NestedScrollingChildHelper r103 = new NestedScrollingChildHelper(this);
        this.f453750a = r103;
        r103.setNestedScrollingEnabled(true);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public final boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        NestedScrollingChildHelper r103 = this.f453750a;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r103.dispatchNestedFling(r100, r101, r102);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        boolean r103 = super.onNestedPreFling(r100, r101, r102);
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f453751b;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = dispatchNestedPreFling(r101, r102);
    L9:
        if (r105 == true) goto L14;
        if (r103 == true) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() != true) goto L8;
        r105 = false;
        goto L9
    }

    public /* synthetic */ PhotoSearchCoordinatorLayout(Context r100, AttributeSet r101, int r102, int r103) {
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
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f453751b;
        if (r104 != null) goto L5;
    L8:
        boolean r105 = dispatchNestedFling(r101, r102, r110);
    L9:
        if (r105 == true) goto L14;
        if (r103 == true) goto L15;
        return false;
    L15:
        return true;
    L14:
        return true;
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() != true) goto L8;
        r105 = false;
        goto L9
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r110) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r110, "consumed");
        int[] r103 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r104 = this.f453751b;
        if (r104 != null) goto L5;
    L6:
        dispatchNestedPreScroll(r101, r102, r103, null);
        r110[0] = r110[0] + r103[0];
        r110[1] = r110[1] + r103[1];
        r103[0] = 0;
        r103[1] = 0;
    L7:
        super.onNestedPreScroll(r100, r101 - r110[0], r102 - r110[1], r103);
        r110[0] = r110[0] + r103[0];
        r110[1] = r110[1] + r103[1];
        return;
    L5:
        if (r104.invoke(r100, Float.valueOf(r101), Float.valueOf(r102)).booleanValue() == true) goto L7;
        goto L6
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
        NestedScrollingChildHelper r103 = this.f453750a;
        if (r103 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r103.dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r110, int r111, int r112, int[] r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r113, "consumed");
        int[] r100 = new int[2];
        Function3<? super View, ? super Float, ? super Float, Boolean> r101 = this.f453751b;
        if (r101 != null) goto L5;
    L6:
        dispatchNestedPreScroll(r111, r112, r100, null, r114);
        r113[0] = r113[0] + r100[0];
        r113[1] = r113[1] + r100[1];
        r100[0] = 0;
        r100[1] = 0;
    L7:
        super.onNestedPreScroll(r110, r111 - r113[0], r112 - r113[1], r100, r114);
        r113[0] = r113[0] + r100[0];
        r113[1] = r113[1] + r100[1];
        return;
    L5:
        if (r101.invoke(r110, Float.valueOf(r111), Float.valueOf(r112)).booleanValue() == true) goto L7;
        goto L6
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
        NestedScrollingChildHelper r102 = this.f453750a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("childHelper");
    L6:
        return r102.dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
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
