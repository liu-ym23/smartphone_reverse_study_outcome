package rg5;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d a;

    public c(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d r3 = this.a;
        r3.n = 1;
        r3.o();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.d.h(this.a, 1);
    }
}
