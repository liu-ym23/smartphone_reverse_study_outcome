package iy4;

import android.view.View;
import com.bytedance.ee.bear.doc.blockeditpanel.model.BlockEditPanelMenusModel;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.toolbatmenu.GroupIconView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BlockEditPanelMenusModel.BlockEditPanelMenuItem f496478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ GroupIconView f496479d;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        dy4.b r101 = this.f496479d.f217724d;
        if (r101 == null) goto L6;
        r101.a(this.f496478c);
        return;
    }

    public a(GroupIconView r100, BlockEditPanelMenusModel.BlockEditPanelMenuItem r101) {
        this.f496479d = r100;
        this.f496478c = r101;
    }
}
