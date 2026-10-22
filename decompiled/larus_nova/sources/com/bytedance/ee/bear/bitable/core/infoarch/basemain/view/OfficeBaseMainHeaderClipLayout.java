package com.bytedance.ee.bear.bitable.core.infoarch.basemain.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/infoarch/basemain/view/OfficeBaseMainHeaderClipLayout;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "measureChildWithMargins", "", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseMainHeaderClipLayout extends FrameLayout {
    public OfficeBaseMainHeaderClipLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OfficeBaseMainHeaderClipLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -2, 80);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    public OfficeBaseMainHeaderClipLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setClipChildren(true);
        setClipToPadding(true);
    }

    public /* synthetic */ OfficeBaseMainHeaderClipLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        int r107 = FrameLayout.getChildMeasureSpec(r101, (((getPaddingLeft() + getPaddingRight()) + r106.leftMargin) + r106.rightMargin) + r102, r106.width);
        if (r106.height != (-2)) goto L5;
        int r108 = View.MeasureSpec.makeMeasureSpec(0, 0);
    L6:
        r100.measure(r107, r108);
        return;
    L5:
        r108 = FrameLayout.getChildMeasureSpec(r103, (((getPaddingTop() + getPaddingBottom()) + r106.topMargin) + r106.bottomMargin) + r104, r106.height);
        goto L6
    }
}
