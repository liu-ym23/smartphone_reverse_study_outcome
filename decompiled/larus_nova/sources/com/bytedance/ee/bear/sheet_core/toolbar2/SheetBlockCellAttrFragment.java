package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.borderline.BorderLineData;
import com.bytedance.ee.bear.sheet.borderline.OfficeBorderLineViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.OfficeSheetSelectColorViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2;
import com.larus.nova.R;
import rn5.e;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockCellAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f238526x = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public SheetBlockCellAttrDivider f238527v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public OfficeSheetSelectColorViewModel f238528w;

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseToolbarV2PanelViewModel Z90() {
        return (SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        return new SheetBlockCellAttrAdapter(W90(((SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class)).getToolbar().getValue()));
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final void aa0() {
        super.aa0();
        SheetBlockToolbarV2 r100 = ((SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class)).getToolbar().getValue();
        SheetBlockCellAttrDivider r101 = new SheetBlockCellAttrDivider(getContext(), W90(r100));
        this.f238527v = r101;
        this.f226217f.addItemDecoration(r101);
        this.f226217f.setPadding(0, 0, 0, 0);
    }

    static {
    }

    public SheetBlockCellAttrFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final void ea0(final ItemV2 r100) {
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r100.getId()) == false) goto L6;
        ((SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class)).getAnalytic().d("back_color_open");
        getActivity();
        this.f238528w.openSelectColorPanel(this, new rn5.c(this, r100));
        return;
    L6:
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.borderLine.name().equals(r100.getId()) == false) goto L8;
        ItemV2 r101 = new ItemV2(new rn5.d());
        ga0(r101, r101.getValue());
        getActivity();
        ((OfficeBorderLineViewModel) q.a(this, OfficeBorderLineViewModel.class)).openBorderLinePanel(this, new BorderLineData(r100.getId(), getString(R.string.Doc_Doc_ToolbarCellBorderLine), r100.getList()[0]), new e(this, r100));
        return;
    L8:
        ga0(r100, r100.getValue());
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final void fa0(ItemV2[] r100) {
        SheetBlockCellAttrDivider r101 = this.f238527v;
        if (r101 == null) goto L5;
        r101.f238523a = r100;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        ItemV2 r104 = r100[r103];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r104.getId()) == false) goto L12;
        OfficeSheetSelectColorViewModel r105 = this.f238528w;
        if (r105 == null) goto L12;
        r105.getSelectColorData().setValue(new SheetSelectColorData(getString(R.string.Doc_Doc_ToolbarCellBgColor), r104.getValue(), r104.getList()));
    L12:
        r103 = r103 + 1;
        goto L6
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238528w = (OfficeSheetSelectColorViewModel) q.a(this, OfficeSheetSelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment, ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        RecyclerView r103 = this.f226217f;
        if (r103 == null) goto L7;
        if (r101 != 0) goto L8;
        r103.post(new rn5.b(this));
        return;
    L8:
        return;
    }
}
