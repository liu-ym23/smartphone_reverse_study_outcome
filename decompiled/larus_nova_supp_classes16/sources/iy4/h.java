package iy4;

import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu.ToolbarMenuPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements dy4.b {
    public final /* synthetic */ ToolbarMenuPanel a;

    public h(ToolbarMenuPanel r1) {
        this.a = r1;
    }

    @Override // dy4.b
    public final void a(BlockEditPanelMenusModel.BlockEditPanelMenuItem r3) {
        ToolbarMenuPanel r0 = this.a;
        int r1 = ToolbarMenuPanel.x;
        r0.e.onClickEditMenuItem(r3);
    }
}
