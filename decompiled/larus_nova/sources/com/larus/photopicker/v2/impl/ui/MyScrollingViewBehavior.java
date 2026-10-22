package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J8\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016J \u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0016J \u0010\u001c\u001a\u0004\u0018\u00010\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MyScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tempRect", "Landroid/graphics/Rect;", "tempRect2", "appbarHeight", "", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "dependency", "onMeasureChild", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "onLayoutChild", "layoutDirection", "onDependentViewChanged", "findDependency", "dependencies", "", "id", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyScrollingViewBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f364678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f364679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f364680c;

    public MyScrollingViewBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f364678a = new Rect();
        this.f364679b = new Rect();
    }

    public static View a(List r100, int r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        View r103 = (View) r102.next();
        if (r103.getId() != r101) goto L4;
        return r103;
    L8:
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        if (r102.getId() != R.id.title_container) goto L5;
    L8:
        return true;
    L5:
        if (r102.getId() == R.id.app_bar) goto L8;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onDependentViewChanged(CoordinatorLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        if ((r102 instanceof AppBarLayout) == false) goto L7;
        this.f364680c = ((AppBarLayout) r102).getHeight();
        return false;
    L7:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r110, View r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "parent");
        Intrinsics.checkNotNullParameter(r111, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        View r100 = a(r110.getDependencies(r111), R.id.title_container);
        int r101 = 0;
        if (r100 == null) goto L13;
        ViewGroup.LayoutParams r102 = r111.getLayoutParams();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r103 = (CoordinatorLayout.LayoutParams) r102;
        Rect r104 = this.f364678a;
        if (r100.getBottom() != 0) goto L10;
        View r105 = a(r110.getDependencies(r111), R.id.app_bar);
        if (r105 == null) goto L9;
        r101 = r105.getBottom();
    L9:
        int r106 = ((ViewGroup.MarginLayoutParams) r103).topMargin;
    L11:
        int r107 = r101 + r106;
        r104.set(r110.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r103).leftMargin, r107, (r110.getWidth() - r110.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r103).rightMargin, ((r110.getHeight() + r100.getBottom()) - r110.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r103).bottomMargin);
        Rect r113 = this.f364679b;
        GravityCompat.apply(8388659, r111.getMeasuredWidth(), r111.getMeasuredHeight(), r104, r113, r112);
        r111.layout(r113.left, r113.top, r113.right, r113.bottom);
        return true;
    L10:
        r101 = r100.getBottom();
        r106 = ((ViewGroup.MarginLayoutParams) r103).topMargin;
        goto L11
    L13:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout r100, View r101, int r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        View r102 = a(r100.getDependencies(r101), R.id.title_container);
        if (r102 == null) goto L13;
        int r114 = View.MeasureSpec.getSize(r112);
        if (r114 != 0) goto L7;
        r114 = r100.getHeight();
    L7:
        int r115 = (r114 - r102.getMeasuredHeight()) - this.f364680c;
        if (r101.getLayoutParams().height != (-1)) goto L10;
        int r103 = 1073741824;
    L11:
        r100.onMeasureChild(r101, r110, r111, View.MeasureSpec.makeMeasureSpec(r115, r103), r113);
        return true;
    L10:
        r103 = Integer.MIN_VALUE;
        goto L11
    L13:
        return false;
    }
}
