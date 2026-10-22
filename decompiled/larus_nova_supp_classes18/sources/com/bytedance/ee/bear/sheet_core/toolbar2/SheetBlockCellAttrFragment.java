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
import rn5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockCellAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {
    public static final /* synthetic */ int x = 0;
    public SheetBlockCellAttrDivider v;
    public OfficeSheetSelectColorViewModel w;

    public final BaseToolbarV2PanelViewModel Z90() {
        return q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    public final BaseSubToolbarAdapter ca0() {
        return new SheetBlockCellAttrAdapter(W90((SheetBlockToolbarV2) q.a(this, SheetBlockToolbarV2PanelViewModel.class).getToolbar().getValue()));
    }

    public final void aa0() {
        super.aa0();
        SheetBlockToolbarV2 r0 = (SheetBlockToolbarV2) q.a(this, SheetBlockToolbarV2PanelViewModel.class).getToolbar().getValue();
        SheetBlockCellAttrDivider r1 = new SheetBlockCellAttrDivider(getContext(), W90(r0));
        this.v = r1;
        ((BaseSubToolbarV2Fragment) this).f.addItemDecoration(r1);
        ((BaseSubToolbarV2Fragment) this).f.setPadding(0, 0, 0, 0);
    }

    static {
    }

    public SheetBlockCellAttrFragment() {
    }

    public final void ea0(final ItemV2 r7) {
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r7.getId()) == false) goto L6;
        q.a(this, SheetBlockToolbarV2PanelViewModel.class).getAnalytic().d("back_color_open");
        getActivity();
        this.w.openSelectColorPanel(this, new rn5.c(this, r7));
        return;
    L6:
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.borderLine.name().equals(r7.getId()) == false) goto L8;
        ItemV2 r0 = new ItemV2(new rn5.d());
        ga0(r0, r0.getValue());
        getActivity();
        ((OfficeBorderLineViewModel) q.a(this, OfficeBorderLineViewModel.class)).openBorderLinePanel(this, new BorderLineData(r7.getId(), getString(2131887691), r7.getList()[0]), new e(this, r7));
        return;
    L8:
        ga0(r7, r7.getValue());
    }

    public final void fa0(ItemV2[] r8) {
        SheetBlockCellAttrDivider r0 = this.v;
        if (r0 == null) goto L5;
        r0.a = r8;
    L5:
        int r1 = r8.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        ItemV2 r3 = r8[r2];
        if (SheetBlockPrimaryItemId.CellAttrSecondaryItemId.backColor.name().equals(r3.getId()) == false) goto L12;
        OfficeSheetSelectColorViewModel r4 = this.w;
        if (r4 == null) goto L12;
        r4.getSelectColorData().setValue(new SheetSelectColorData(getString(2131887690), r3.getValue(), r3.getList()));
    L12:
        r2 = r2 + 1;
        goto L6
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.w = (OfficeSheetSelectColorViewModel) q.a(this, OfficeSheetSelectColorViewModel.class);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        RecyclerView r4 = ((BaseSubToolbarV2Fragment) this).f;
        if (r4 == null) goto L7;
        if (r2 != 0) goto L8;
        r4.post(new rn5.b(this));
        return;
    L8:
        return;
    }
}
