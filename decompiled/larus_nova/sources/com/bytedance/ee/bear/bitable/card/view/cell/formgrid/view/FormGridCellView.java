package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.common.widgets.d;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0014¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridCellView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/CommonCellView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "showEmptyValue", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridCellView extends CommonCellView {
    public FormGridCellView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FormGridCellView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView
    public final void c() {
        View r100 = getCellValueView();
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell.CommonCellView
    public final void b(BaseCellData r100, gv4.a r101) {
        super.b(r100, r101);
        String r102 = null;
        if (r100 == null) goto L5;
        HighlightModel r103 = r100.getHighlightColorV2();
    L6:
        if (r100 == null) goto L8;
        r102 = r100.getBorderHighlightColor();
    L8:
        setBackground(new d(r103, r102));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public FormGridCellView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setPadding(n.d(8), 0, n.d(8), 0);
    }

    public /* synthetic */ FormGridCellView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
