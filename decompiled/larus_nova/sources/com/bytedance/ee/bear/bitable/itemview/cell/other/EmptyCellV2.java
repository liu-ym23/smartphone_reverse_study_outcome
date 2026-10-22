package com.bytedance.ee.bear.bitable.itemview.cell.other;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.e;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qt4.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellV2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCell;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setData", "", "data", "Lcom/bytedance/ee/bear/bitable/itemview/cell/other/EmptyCellData;", "extra", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyCellV2 extends EmptyCell {
    public EmptyCellV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public EmptyCellV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.LayoutParams r102 = getBinding().f210869b.getLayoutParams();
        r102.height = n.d(28);
        ViewGroup.LayoutParams r103 = getBinding().f210869b.getLayoutParams();
        r103.width = n.d(28);
        getBinding().f210871d.setPadding(0, n.d(2), 0, n.d(2));
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.other.EmptyCell
    public final void a(EmptyCellData r100, a r101) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmptyIcon() == false) goto L8;
        e.j(getBinding().f210869b, r100.getIcon());
        m.y(new View[]{getBinding().f210869b}, new View[]{getBinding().f210870c, getBinding().f210871d});
        return;
    L8:
        if (r100.isDashLine() == false) goto L11;
        m.y(new View[]{getBinding().f210870c}, new View[]{getBinding().f210869b, getBinding().f210871d});
        return;
    L11:
        if (r100.isTextPlaceholder() == false) goto L17;
        getBinding().f210871d.setText(r100.getText());
        rt4.a.a(getBinding().f210871d, r101.f534793j, Boolean.FALSE);
        m.y(new View[]{getBinding().f210871d}, new View[]{getBinding().f210869b, getBinding().f210870c});
        return;
    }
}
