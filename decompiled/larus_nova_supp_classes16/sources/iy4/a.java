package iy4;

import android.view.View;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu.GroupIconView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends t {
    public final /* synthetic */ BlockEditPanelMenusModel.BlockEditPanelMenuItem c;
    public final /* synthetic */ GroupIconView d;

    public final void a(View r2) {
        dy4.b r3 = this.d.d;
        if (r3 == null) goto L6;
        r3.a(this.c);
        return;
    }

    public a(GroupIconView r1, BlockEditPanelMenusModel.BlockEditPanelMenuItem r2) {
        this.d = r1;
        this.c = r2;
    }
}
