package com.bytedance.ee.bear.sheet_core.toolbar2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
import rn5.h;
import rn5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetBlockTextAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {
    public static final /* synthetic */ int w = 0;
    public OfficeSheetSelectColorViewModel v;

    public class a implements SheetBlockTextAttrAdapter.c {
        public final /* synthetic */ SheetBlockTextAttrFragment a;

        public a(SheetBlockTextAttrFragment r1) {
            this.a = r1;
        }

        public final void a(final ItemV2 r4) {
            if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r4.getId()) == false) goto L5;
            final Fragment r0 = this.a;
            int r1 = SheetBlockTextAttrFragment.w;
            r0.getClass();
            q.a(r0, SheetBlockToolbarV2PanelViewModel.class).getAnalytic().d("fore_color_open");
            r0.getActivity();
            r0.v.openSelectColorPanel(r0, new i(r0, r4));
            return;
        L5:
            SheetBlockTextAttrFragment r2 = this.a;
            int r3 = SheetBlockTextAttrFragment.w;
            r2.ga0(r4, "");
        }
    }

    public final BaseToolbarV2PanelViewModel Z90() {
        return q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    public final BaseSubToolbarAdapter ca0() {
        SheetBlockTextAttrAdapter r1 = new SheetBlockTextAttrAdapter(W90((SheetBlockToolbarV2) q.a(this, SheetBlockToolbarV2PanelViewModel.class).getToolbar().getValue()));
        r1.e = new a(this);
        return r1;
    }

    static {
    }

    public SheetBlockTextAttrFragment() {
    }

    public final void fa0(ItemV2[] r8) {
        int r0 = r8.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ItemV2 r2 = r8[r1];
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r2.getId()) == false) goto L9;
        OfficeSheetSelectColorViewModel r3 = this.v;
        if (r3 == null) goto L9;
        r3.getSelectColorData().setValue(new SheetSelectColorData(getString(2131887696), r2.getValue(), r2.getList()));
    L9:
        r1 = r1 + 1;
        goto L3
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.v = (OfficeSheetSelectColorViewModel) q.a(this, OfficeSheetSelectColorViewModel.class);
    }

    public final void onKeyboardHeightChanged(pcb.a r1, int r2, int r3) {
        RecyclerView r4 = ((BaseSubToolbarV2Fragment) this).f;
        if (r4 == null) goto L7;
        if (r2 != 0) goto L8;
        r4.post(new h(this));
        return;
    L8:
        return;
    }
}
