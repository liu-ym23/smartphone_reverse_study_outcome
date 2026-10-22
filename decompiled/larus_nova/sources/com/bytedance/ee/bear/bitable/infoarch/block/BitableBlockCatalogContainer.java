package com.bytedance.ee.bear.bitable.infoarch.block;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.bitable.core.infoarch.g;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ4\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/block/BitableBlockCatalogContainer;", "Lcom/bytedance/ee/bear/bitable/infoarch/block/AbstractBlockCatalogContainer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentShadowView", "Landroid/view/View;", "getContentShadowView", "()Landroid/view/View;", "pinRadiusView", "Landroid/widget/ImageView;", "getPinRadiusView", "()Landroid/widget/ImageView;", "compatBackgroundWrapper", "Landroid/widget/FrameLayout;", "getCompatBackgroundWrapper", "()Landroid/widget/FrameLayout;", "onToggleDrawer", "", "state", "Lcom/bytedance/ee/bear/bitable/core/infoarch/InfoArchState;", "appBarheight", "headerHeight", "topHeight", "leftPlaceHolderWidth", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableBlockCatalogContainer extends AbstractBlockCatalogContainer {
    public BitableBlockCatalogContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableBlockCatalogContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final FrameLayout getCompatBackgroundWrapper() {
        View r100 = findViewById(R.id.compat_bg_wrapper);
        if (r100 == null) goto L7;
        return (FrameLayout) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final View getContentShadowView() {
        View r100 = findViewById(R.id.bg_compat_for_content_shadow);
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final ImageView getPinRadiusView() {
        View r100 = findViewById(R.id.bg_compat_for_pincontainer_radius);
        if (r100 == null) goto L7;
        return (ImageView) r100;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public BitableBlockCatalogContainer(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110, R.layout.bitable_block_catalog_container_layout, R.id.compat_bg_wrapper);
        if (f.a(r100) == true) goto L5;
        getContentShadowView().setBackground(com.bytedance.ee.bear.bitable.common.widgets.b.a(r100, n.c(24.0f), false));
    L5:
        getPinRadiusView().setBackground(AppCompatResources.getDrawable(r100, R.drawable.bitable_pin_bg_compat_in_block_catalog));
    }

    public /* synthetic */ BitableBlockCatalogContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void g(g r100, int r101, int r102, int r103, int r110) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.f210554b == false) goto L15;
        View r104 = getContentShadowView();
        r104.setVisibility(0);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r100.f210553a == false) goto L7;
        int r107 = r101;
    L8:
        r106.topMargin = r107;
        ImageView r108 = getPinRadiusView();
        if (r100.f210553a == false) goto L11;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) r109).topMargin = r101;
        ViewGroup.LayoutParams r111 = r108.getLayoutParams();
        r111.height = RangesKt.coerceAtLeast(r103 - r100.f210557e, 0);
        r108.setVisibility(0);
    L12:
        int r112 = r110 + n.c(12.0f);
        if (getCompatBackgroundWrapper().getLayoutParams().width == r112) goto L16;
        getCompatBackgroundWrapper().getLayoutParams().width = r112;
    L16:
        e(r100.f210554b, r100.f210558f, r100.f210553a, r102);
        return;
    L11:
        r108.setVisibility(8);
        goto L12
    L7:
        r107 = RangesKt.coerceAtLeast(r102 - r100.f210557e, 0) + r101;
        goto L8
    L15:
        getContentShadowView().setVisibility(8);
        getPinRadiusView().setVisibility(8);
        goto L16
    }
}
