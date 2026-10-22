package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.card.view.cell.linktable.model.LinkTableDataModelManager;
import com.bytedance.ee.bear.bitable.databinding.BitableCardStackLinkTableBinding;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.BitableNativeViewContainer;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BitableNativeViewData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.MobileViewContainerType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridViewData;
import com.bytedance.ee.bear.bitable.infoarch.titlebar.BitableBaseTitleBar;
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewLogger;
import com.bytedance.ee.bear.bitable.itemview.util.i;
import com.bytedance.ee.bear.bitable.itemview.util.l;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.n;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends CommonLinkTableView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BitableCardStackLinkTableBinding f213943d;

    @Override // com.bytedance.ee.bear.bitable.common.k
    public final void b() {
        this.f213943d.f210704d.getGridView().getViewContext().b();
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView
    public final void h() {
        BitableBaseTitleBar r100 = this.f213943d.f210705e;
        LinkTableCellValue r101 = getState().f213890c;
        if (r101 == null) goto L5;
        String r102 = r101.getFieldName();
    L6:
        r100.setLeftText(r102);
        LinkTableCellValue r103 = this.f213885a.f213890c;
        boolean r104 = true;
        if (r103 != null) goto L9;
    L11:
        boolean r105 = false;
    L12:
        if (r105 == true) goto L22;
        LinkTableCellValue r106 = this.f213885a.f213890c;
        if (r106 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == true) goto L22;
        r104 = false;
        goto L22
    L16:
        if (r106.getEditable() != true) goto L18;
        r107 = true;
    L22:
        if (r104 == false) goto L24;
        this.f213943d.f210702b.setVisibility(0);
        return;
    L24:
        this.f213943d.f210702b.setVisibility(8);
        return;
    L9:
        if (r103.getTableAddable() != true) goto L11;
        r105 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l.a("LinkTableFullScreenView onDetachedFromWindow:", ItemViewLogger.ItemViewLinkTable, null, null, 12);
        tp4.a r100 = getMDataModelDelegate();
        if (r100 == null) goto L10;
        com.bytedance.ee.bear.bitable.itemview.b r101 = i.c(this);
        if (r101 == null) goto L11;
        LinkTableDataModelManager r102 = r101.fx();
        if (r102 == null) goto L12;
        r102.destroyLinkTableDataModel(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final BitableCardStackLinkTableBinding getBinding() {
        return this.f213943d;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView
    public MobileViewContainerType getContainerType() {
        return MobileViewContainerType.LinkedFullTable;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView
    public final void a(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "viewData");
        BitableNativeViewData r101 = r100.f538848a.getValue();
        GridViewData r102 = null;
        if (r101 == null) goto L5;
        BaseViewData<?, ?> r103 = r101.getData();
    L7:
        if ((r103 instanceof GridViewData) == false) goto L9;
        r102 = (GridViewData) r103;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.getFooter() != null) goto L13;
        r102.setFooter(new SimpleItemModel());
    L13:
        SimpleItemModel r104 = r102.getFooter();
        if (r104 == null) goto L18;
        r104.setStyle("footerAutoHeight");
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.cell.link.CommonLinkTableView
    public final void g(rp4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "mViewData");
        BitableNativeViewData r101 = r100.f538848a.getValue();
        if (r101 != null) goto L5;
        return;
    L5:
        gv4.a r102 = getHandler();
        BitableNativeViewContainer r103 = this.f213943d.f210704d;
        com.bytedance.ee.bear.bitable.itemview.b r104 = i.c(this);
        if (r104 == null) goto L8;
        FragmentActivity r105 = r104.p0();
    L9:
        r103.j(r105, r101, r102, r100.f538849b, true);
        this.f213943d.f210706f.c(r100.f538848a.getToolBarData(), r102);
        return;
    L8:
        r105 = null;
        goto L9
    }

    public final void setBinding(BitableCardStackLinkTableBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213943d = r100;
    }

    public e(LinkTableCellValue r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "tableCellValue");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null);
        BitableCardStackLinkTableBinding r102 = BitableCardStackLinkTableBinding.a(LayoutInflater.from(r101), this);
        this.f213943d = r102;
        r102.f210701a.setOnClickListener(b.f213940a);
        m.u(this.f213943d.f210705e, StatusBarUtil.getStatusBarHeight(r101), false);
        ImageView r103 = this.f213943d.f210705e.getLeftImage();
        int r104 = n.d(20);
        int r105 = n.d(20);
        Intrinsics.checkNotNullParameter(r103, "<this>");
        ViewGroup.LayoutParams r106 = r103.getLayoutParams();
        if (r106 == null) goto L5;
        r106.width = r104;
        r106.height = r105;
    L6:
        this.f213943d.f210705e.setLeftClickListener(new c(this));
        this.f213943d.f210702b.setOnClickListener(new d(this));
        l.a("LinkTableFullScreenView init: " + r100, ItemViewLogger.ItemViewLinkTable, null, null, 12);
        f(r100);
        return;
    L5:
        r103.setLayoutParams(new ViewGroup.LayoutParams(r104, r105));
        goto L6
    }
}
