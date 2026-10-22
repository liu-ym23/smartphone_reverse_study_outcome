package com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.field;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.record.HorizontalDividerItemDecoration;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.panel.TextModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import gv4.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mt4.c;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001%B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J0\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J0\u0010 \u001a\u00020\u000f2\u0016\u0010!\u001a\u00120\"R\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldHeaderView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldView;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldData;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/field/GridFieldHeaderData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "onScroll", "position", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/Position;", "scrollX", "dx", "fixedWidth", "minFixedWidth", "createFixedColView", "createCellView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindCellView", "holder", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/row/BaseRowView$RowViewHolder;", "getItemViewType", "getRowHeight", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridFieldHeaderView extends BaseRowView<GridFieldView, GridFieldData> implements b<GridFieldHeaderData> {

    public static final class a {
    }

    static {
    }

    public GridFieldHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GridFieldHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView
    public int getRowHeight() {
        int r100 = ht4.a.f487118a;
        return ht4.a.f487119b;
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView
    public final View d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        return new GridFieldView(r100, r101, 6, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView
    public final int e(GridFieldData r100) {
        GridFieldData r101 = r100;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L12;
        return 2;
    L12:
        return 1;
    L5:
        if (r101.isAddCol() != true) goto L7;
        r102 = true;
        goto L8
    }

    public final void g(GridFieldHeaderData r100, e r110) {
        ArrayList<GridFieldData> r101 = r100.getFields();
        if (r101 == null) goto L8;
        getAdapter().y2(r101, 0);
        mt4.e r102 = getRowScrollManager().f515638b;
        b(r102.f515644f, r102.f515643e, -1, r102.b(), r102.f515646h);
        getAdapter().notifyDataSetChanged();
        GridFieldData r103 = (GridFieldData) m.j(r101, 0, null);
        if (r103 == null) goto L9;
        GridFieldView r104 = getFixCol();
        r103.setFieldWidth(getRowScrollManager().f515638b.b());
        r103.setLayoutStart(true);
        r104.b(r103, r110);
        return;
    L9:
        return;
    }

    public GridFieldHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        HorizontalDividerItemDecoration r103 = new HorizontalDividerItemDecoration(r100);
        r103.f213584d = false;
        getRecyclerView().addItemDecoration(r103);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView
    public final View c(Context r100, ViewGroup r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r103 = 0;
        int r104 = 6;
        AttributeSet r105 = null;
        if (r102 != 1) goto L5;
        View r106 = new GridAddFieldView(r100, r105, r104, r103);
    L6:
        r106.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        return r106;
    L5:
        r106 = new GridFieldView(r100, r105, r104, r103);
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView
    public final void f(BaseRowView<GridFieldView, GridFieldData>.RowViewHolder r100, GridFieldData r101, int r102) {
        GridFieldData r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r103.setFieldWidth(getRowScrollManager().f515638b.a(r102));
        GridFieldView r104 = null;
        GridAddFieldView r105 = null;
        if (r103.isAddCol() == false) goto L24;
        View r106 = r100.itemView;
        if ((r106 instanceof GridAddFieldView) == false) goto L7;
        r105 = (GridAddFieldView) r106;
    L7:
        if (r105 == null) goto L29;
        e r107 = getViewContext().e();
        if (r103.getFieldNameEx() != null) goto L11;
    L18:
        TextView r108 = r105.f213547a.f210793c;
        String r109 = r103.getFieldName();
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r108.setText(r109);
    L23:
        r105.setOnClickListener(new it4.a(r103, r107));
        goto L29
    L11:
        if (r103.getIcon() == null) goto L18;
        TextModel r110 = r103.getFieldNameEx();
        if (r110 == null) goto L15;
        r110.apply(r105.f213547a.f210793c);
    L15:
        Icon r111 = r103.getIcon();
        if (r111 == null) goto L23;
        r111.apply(r105.f213547a.f210792b);
    L29:
        com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.b r112 = getViewContext().f465348b.f213638c.f213682a;
        r112.f213657g = Math.max(r112.f213657g, r102);
        return;
    L24:
        View r113 = r100.itemView;
        if ((r113 instanceof GridFieldView) == false) goto L27;
        r104 = (GridFieldView) r113;
    L27:
        if (r104 == null) goto L29;
        r104.b(r103, getViewContext().e());
        goto L29
    }

    public /* synthetic */ GridFieldHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.row.BaseRowView, mt4.b
    public final void b(c r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "position");
        super.b(r100, r101, r102, r103, r104);
        getViewContext().b();
        getViewContext().h().t1(r101);
    }
}
