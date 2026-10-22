package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.OfficeSheetSelectColorViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockPrimaryItemId;
import com.bytedance.ee.bear.sheet.toolbar2.SheetBlockToolbarV2;
import com.larus.nova.R;
import rn5.h;
import rn5.i;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockTextAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f238546w = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OfficeSheetSelectColorViewModel f238547v;

    public class a implements SheetBlockTextAttrAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBlockTextAttrFragment f238548a;

        public a(SheetBlockTextAttrFragment r100) {
            this.f238548a = r100;
        }

        @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarAdapter.b
        public final void a(final ItemV2 r100) {
            if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r100.getId()) == false) goto L5;
            final SheetBlockTextAttrFragment r101 = this.f238548a;
            int r102 = SheetBlockTextAttrFragment.f238546w;
            r101.getClass();
            ((SheetBlockToolbarV2PanelViewModel) q.a(r101, SheetBlockToolbarV2PanelViewModel.class)).getAnalytic().d("fore_color_open");
            r101.getActivity();
            r101.f238547v.openSelectColorPanel(r101, new i(r101, r100));
            return;
        L5:
            SheetBlockTextAttrFragment r103 = this.f238548a;
            int r104 = SheetBlockTextAttrFragment.f238546w;
            r103.ga0(r100, "");
        }
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseToolbarV2PanelViewModel Z90() {
        return (SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        SheetBlockTextAttrAdapter r100 = new SheetBlockTextAttrAdapter(W90(((SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class)).getToolbar().getValue()));
        r100.f238541e = new a(this);
        return r100;
    }

    static {
    }

    public SheetBlockTextAttrFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment
    public final void fa0(ItemV2[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ItemV2 r103 = r100[r102];
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r103.getId()) == false) goto L9;
        OfficeSheetSelectColorViewModel r104 = this.f238547v;
        if (r104 == null) goto L9;
        r104.getSelectColorData().setValue(new SheetSelectColorData(getString(R.string.Doc_Doc_ToolbarCellTxtColor), r103.getValue(), r103.getList()));
    L9:
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238547v = (OfficeSheetSelectColorViewModel) q.a(this, OfficeSheetSelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.toolbar.toolbar2.BaseSubToolbarV2Fragment, ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        RecyclerView r103 = this.f226217f;
        if (r103 == null) goto L7;
        if (r101 != 0) goto L8;
        r103.post(new h(this));
        return;
    L8:
        return;
    }
}
