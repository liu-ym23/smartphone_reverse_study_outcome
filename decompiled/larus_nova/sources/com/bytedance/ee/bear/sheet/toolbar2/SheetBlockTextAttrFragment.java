package com.bytedance.ee.bear.sheet.toolbar2;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.model.toolbar.ItemV2;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment;
import com.bytedance.ee.bear.edit.component.toolbar2.BaseToolbarV2PanelViewModel;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorData;
import com.bytedance.ee.bear.sheet.selectcolor.SheetSelectColorViewModel;
import com.larus.nova.R;
import nn5.h;
import nn5.i;

/* JADX INFO: loaded from: classes18.dex */
public class SheetBlockTextAttrFragment extends BaseSubToolbarV2Fragment<SheetBlockToolbarV2> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f238446u = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SheetSelectColorViewModel f238447t;

    public class a implements SheetBlockTextAttrAdapter.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SheetBlockTextAttrFragment f238448a;

        public a(SheetBlockTextAttrFragment r100) {
            this.f238448a = r100;
        }

        @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarAdapter.a
        public final void a(final ItemV2 r100) {
            if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r100.getId()) == false) goto L5;
            final SheetBlockTextAttrFragment r101 = this.f238448a;
            int r102 = SheetBlockTextAttrFragment.f238446u;
            r101.getClass();
            ((SheetBlockToolbarV2PanelViewModel) q.a(r101, SheetBlockToolbarV2PanelViewModel.class)).getAnalytic().d("fore_color_open");
            r101.getActivity();
            r101.f238447t.openSelectColorPanel(r101, new i(r101, r100));
            return;
        L5:
            SheetBlockTextAttrFragment r103 = this.f238448a;
            int r104 = SheetBlockTextAttrFragment.f238446u;
            r103.ga0(r100, "");
        }
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final BaseToolbarV2PanelViewModel Z90() {
        return (SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final BaseSubToolbarAdapter ca0() {
        SheetBlockTextAttrAdapter r100 = new SheetBlockTextAttrAdapter(W90(((SheetBlockToolbarV2PanelViewModel) q.a(this, SheetBlockToolbarV2PanelViewModel.class)).getToolbar().getValue()));
        r100.f238441c = new a(this);
        return r100;
    }

    static {
    }

    public SheetBlockTextAttrFragment() {
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment
    public final void fa0(ItemV2[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        ItemV2 r103 = r100[r102];
        if (SheetBlockPrimaryItemId.TextAttrSecondaryItemId.foreColor.name().equals(r103.getId()) == false) goto L9;
        SheetSelectColorViewModel r104 = this.f238447t;
        if (r104 == null) goto L9;
        r104.getSelectColorData().setValue(new SheetSelectColorData(getString(R.string.Doc_Doc_ToolbarCellTxtColor), r103.getValue(), r103.getList()));
    L9:
        r102 = r102 + 1;
        goto L3
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment, com.bytedance.ee.bear.facade.common.BaseFragment, com.bytedance.ee.bear.facade.common.LifeCycleFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f238447t = (SheetSelectColorViewModel) q.a(this, SheetSelectColorViewModel.class);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.BaseSubToolbarV2Fragment, ocb.a
    public final void onKeyboardHeightChanged(pcb.a r100, int r101, int r102) {
        RecyclerView r103 = this.f226057f;
        if (r103 == null) goto L7;
        if (r101 != 0) goto L8;
        r103.post(new h(this));
        return;
    L8:
        return;
    }
}
