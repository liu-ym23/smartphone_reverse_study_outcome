package iy4;

import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu.ToolbarMenuPanel;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements dy4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ToolbarMenuPanel f496488a;

    public h(ToolbarMenuPanel r100) {
        this.f496488a = r100;
    }

    @Override // dy4.b
    public final void a(BlockEditPanelMenusModel.BlockEditPanelMenuItem r100) {
        ToolbarMenuPanel r101 = this.f496488a;
        int r102 = ToolbarMenuPanel.f217732x;
        r101.f217674e.onClickEditMenuItem(r100);
    }
}
