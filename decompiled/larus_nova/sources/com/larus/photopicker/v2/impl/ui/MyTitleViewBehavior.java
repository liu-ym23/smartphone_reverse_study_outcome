package com.larus.photopicker.v2.impl.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wp9.h;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011J \u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MyTitleViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "expanded", "", "tempRect", "Landroid/graphics/Rect;", "tempRect2", "viewOffsetHelper", "Lcom/larus/photopicker/v2/impl/utils/ViewOffsetHelper;", "tempTopBottomOffset", "", "tempLeftRightOffset", "setTopAndBottomOffset", "offset", "layoutDependsOn", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "dependency", "onLayoutChild", "layoutDirection", "findFirstDependency", "dependencies", "", "setExpanded", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyTitleViewBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f364681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f364682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f364683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f364684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f364685e;

    public MyTitleViewBehavior(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f364681a = true;
        this.f364682b = new Rect();
        this.f364683c = new Rect();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(CoordinatorLayout r100, View r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        return r102 instanceof AppBarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout r100, View r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r110, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r100.onLayoutChild(r110, r111);
        Iterator<View> r101 = r100.getDependencies(r110).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        View r102 = r101.next();
        if ((r102 instanceof AppBarLayout) == false) goto L4;
    L9:
        if (r102 == null) goto L12;
        ViewGroup.LayoutParams r103 = r110.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams r104 = (CoordinatorLayout.LayoutParams) r103;
        Rect r105 = this.f364682b;
        r105.set(r100.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r104).leftMargin, r102.getBottom() + ((ViewGroup.MarginLayoutParams) r104).topMargin, (r100.getWidth() - r100.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r104).rightMargin, ((r100.getHeight() + r102.getBottom()) - r100.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r104).bottomMargin);
        Rect r106 = this.f364683c;
        GravityCompat.apply(8388659, r110.getMeasuredWidth(), r110.getMeasuredHeight(), r105, r106, r111);
        r110.layout(r106.left, r106.top, r106.right, r106.bottom);
    L12:
        if (this.f364684d != null) goto L14;
        this.f364684d = new h(r110);
    L14:
        h r107 = this.f364684d;
        if (r107 == null) goto L17;
        r107.f560631b = r107.f560630a.getTop();
        r107.f560632c = r107.f560630a.getLeft();
        r107.a();
    L17:
        int r108 = this.f364685e;
        if (r108 == 0) goto L26;
        h r109 = this.f364684d;
        if (r109 != null) goto L22;
    L24:
        this.f364685e = 0;
        goto L26
    L22:
        if (r109.f560633d == r108) goto L24;
        r109.f560633d = r108;
        r109.a();
    L26:
        if (this.f364681a == true) goto L34;
        int r112 = -r110.getMeasuredHeight();
        h r113 = this.f364684d;
        if (r113 == null) goto L32;
        Intrinsics.checkNotNull(r113);
        if (r113.f560633d == r112) goto L33;
        r113.f560633d = r112;
        r113.a();
    L33:
        this.f364681a = true;
        goto L34
    L32:
        this.f364685e = r112;
    L34:
        h r114 = this.f364684d;
        if (r114 == null) goto L37;
        int r115 = r114.f560633d;
    L38:
        int r116 = MathUtils.clamp(r115, -r110.getMeasuredHeight(), 0);
        h r117 = this.f364684d;
        if (r117 == null) goto L43;
        Intrinsics.checkNotNull(r117);
        if (r117.f560633d == r116) goto L44;
        r117.f560633d = r116;
        r117.a();
    L44:
        return true;
    L43:
        this.f364685e = r116;
        goto L44
    L37:
        r115 = 0;
        goto L38
    L8:
        r102 = null;
        goto L9
    }
}
