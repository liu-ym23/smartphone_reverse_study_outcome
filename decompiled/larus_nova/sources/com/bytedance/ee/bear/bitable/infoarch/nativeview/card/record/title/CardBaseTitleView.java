package com.bytedance.ee.bear.bitable.infoarch.nativeview.card.record.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.widgets.c;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class CardBaseTitleView extends CommonCellView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f213292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f213293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f213294m;

    private final View getLoadingView() {
        return (View) this.f213294m.getValue();
    }

    public final void d() {
        if (getLoadingView().getParent() != null) goto L5;
        addView(getLoadingView());
    L5:
        View r100 = getCellValueView();
        if (r100 == null) goto L8;
        r100.setVisibility(8);
    L8:
        View r101 = getEmptyValueView();
        if (r101 == null) goto L12;
        r101.setVisibility(8);
        return;
    }

    public final int getLoadingHeight() {
        return this.f213293l;
    }

    public final float getLoadingWidthPercent() {
        return this.f213292k;
    }

    public final void setLoadingHeight(int r100) {
        this.f213293l = r100;
    }

    public final void setLoadingWidthPercent(float r100) {
        this.f213292k = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView
    public final void b(BaseCellData r100, a r101) {
        removeView(getLoadingView());
        View r102 = getCellValueView();
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        View r103 = getEmptyValueView();
        if (r103 == null) goto L8;
        r103.setVisibility(0);
    L8:
        if (r100 == null) goto L10;
        setVisibility(0);
        super.b(r100, r101);
        setBackground(new c(r100.getHighlightColor(), r100.getBorderHighlightColor()));
        return;
    L10:
        setVisibility(8);
    }

    public CardBaseTitleView(final Context r100, AttributeSet r101, float r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f213292k = r102;
        this.f213293l = r103;
        this.f213294m = LazyKt.lazy(new CardBaseTitleView$loadingView$2(r100, this));
    }
}
