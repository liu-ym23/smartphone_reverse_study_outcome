package com.bytedance.ee.bear.bitable.core.infoarch.basemain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.BitableBackgroundContainer;
import com.bytedance.ee.bear.bitable.core.infoarch.arch.j;
import com.bytedance.ee.bear.bitable.infoarch.header.BitableHeaderContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.toolbar.BitableToolbarContainer;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableLoadingContainer;
import com.bytedance.ee.bear.bitable.infoarch.view.BitableViewContainer;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
public final class OfficeBaseMainInfoArchViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f210504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppBarLayout f210505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f210506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f210507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableHeaderContainer f210508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f210509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f210510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f210511h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f210512i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final OfficeBaseMainTopLayout f210513j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BitableViewContainer f210514k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final BitableToolbarContainer f210515l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final BitableBackgroundContainer f210516m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f210517n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OfficeBaseMainOverlayContainer f210518o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BitableNativeViewContainer f210519p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OfficeBaseMainBlockCatalogContainer f210520q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f210521r;

    public final int a() {
        View r100 = this.f210505b.findViewById(R.id.titleContentLayout);
        if (r100 == null) goto L6;
        return Math.max(r100.getMeasuredHeight(), r100.getHeight());
    L6:
        return RangesKt.coerceAtLeast(Math.max(this.f210505b.getMeasuredHeight(), this.f210505b.getHeight()) - Math.max(this.f210508e.getMeasuredHeight(), this.f210508e.getHeight()), 0);
    }

    public OfficeBaseMainInfoArchViewHolder(Context r100, AppBarLayout r101, k r102, ViewGroup r103, BitableHeaderContainer r104, ViewGroup r105, ViewGroup r106, ViewGroup r110, ViewGroup r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "appBarLayout");
        Intrinsics.checkNotNullParameter(r103, "rootContainer");
        Intrinsics.checkNotNullParameter(r104, "headerContainer");
        Intrinsics.checkNotNullParameter(r105, "contentContainer");
        Intrinsics.checkNotNullParameter(r106, "webSurfaceContainer");
        Intrinsics.checkNotNullParameter(r111, "topSlotContainer");
        this.f210504a = r100;
        this.f210505b = r101;
        this.f210506c = r102;
        this.f210507d = r103;
        this.f210508e = r104;
        this.f210509f = r105;
        this.f210510g = r106;
        this.f210511h = r110;
        this.f210512i = r111;
        View r107 = r111.findViewById(R.id.bitable_top_container);
        AttributeSet r108 = null;
        if ((r107 instanceof OfficeBaseMainTopLayout) == false) goto L5;
        OfficeBaseMainTopLayout r109 = (OfficeBaseMainTopLayout) r107;
    L12:
        if (r109.getParent() == r111) goto L20;
        ViewParent r112 = r109.getParent();
        if ((r112 instanceof ViewGroup) == false) goto L16;
        ViewGroup r113 = (ViewGroup) r112;
    L17:
        if (r113 == null) goto L19;
        r113.removeView(r109);
    L19:
        r111.addView(r109, new FrameLayout.LayoutParams(-1, -2));
        goto L20
    L16:
        r113 = null;
    L20:
        this.f210513j = r109;
        this.f210514k = r109.getViewContainer();
        this.f210515l = r109.getToolbarContainer();
        BitableBackgroundContainer r114 = (BitableBackgroundContainer) r103.findViewById(R.id.bitable_background_container);
        int r115 = 0;
        if (r114 != null) goto L24;
        r114 = new BitableBackgroundContainer(r100, null, 0, 12);
        r114.setId(R.id.bitable_background_container);
        r103.addView(r114, 0, new CoordinatorLayout.LayoutParams(-1, -1));
    L24:
        this.f210516m = r114;
        View r116 = r101.findViewById(R.id.bitable_header_clip_container);
        View r117 = r104;
        if (r116 == null) goto L28;
        r117 = r116;
    L28:
        this.f210517n = r117;
        OfficeBaseMainOverlayContainer r118 = (OfficeBaseMainOverlayContainer) r106.findViewById(R.id.bitable_web_overlay_container);
        int r119 = 6;
        if (r118 != null) goto L31;
        r118 = new OfficeBaseMainOverlayContainer(r100, r108, r119, r115);
        r118.setId(R.id.bitable_web_overlay_container);
        r118.setVisibility(8);
        r106.addView(r118, new FrameLayout.LayoutParams(-1, -1));
    L31:
        this.f210518o = r118;
        OfficeBaseMainOverlayType r120 = OfficeBaseMainOverlayType.NATIVE_VIEW;
        BitableNativeViewContainer r121 = (BitableNativeViewContainer) r118.a(r120).findViewById(R.id.bitable_native_view_container);
        if (r121 != null) goto L34;
        r121 = j.a(r100, r118.a(r120));
        r121.setVisibility(0);
    L34:
        this.f210519p = r121;
        View r122 = r103.findViewById(R.id.bitable_block_catalog_container);
        if ((r122 instanceof OfficeBaseMainBlockCatalogContainer) == false) goto L37;
        OfficeBaseMainBlockCatalogContainer r123 = (OfficeBaseMainBlockCatalogContainer) r122;
    L38:
        if (r123 != null) goto L48;
        r123 = new OfficeBaseMainBlockCatalogContainer(r100, r108, r119, r115);
        r123.setId(R.id.bitable_block_catalog_container);
        r123.setVisibility(8);
        View r124 = r103.findViewById(r123.getId());
        if (r124 == null) goto L47;
        ViewParent r125 = r124.getParent();
        if ((r125 instanceof ViewGroup) == false) goto L44;
        ViewGroup r126 = (ViewGroup) r125;
    L45:
        if (r126 == null) goto L47;
        r126.removeView(r124);
        goto L47
    L44:
        r126 = null;
    L47:
        r103.addView(r123, new CoordinatorLayout.LayoutParams(-1, -1));
    L48:
        this.f210520q = r123;
        if (((BitableLoadingContainer) r103.findViewById(R.id.global_loading_layout)) != null) goto L51;
        BitableLoadingContainer r127 = new BitableLoadingContainer(r100, r108, r119, r115);
        r127.setId(R.id.global_loading_layout);
        r127.setVisibility(8);
        r103.addView(r127, new CoordinatorLayout.LayoutParams(-1, -1));
    L51:
        this.f210521r = LazyKt.lazy(new OfficeBaseMainInfoArchViewHolder$emptyView$2(this));
        return;
    L37:
        r123 = null;
        goto L38
    L5:
        if (r107 == null) goto L7;
        ViewParent r128 = r107.getParent();
    L8:
        if (r128 != r111) goto L10;
        r111.removeView(r107);
    L10:
        r109 = new OfficeBaseMainTopLayout(r100, null);
        r109.setId(R.id.bitable_top_container);
        r109.setBackgroundResource(R.color.transparent);
        goto L12
    L7:
        r128 = null;
        goto L8
    }
}
