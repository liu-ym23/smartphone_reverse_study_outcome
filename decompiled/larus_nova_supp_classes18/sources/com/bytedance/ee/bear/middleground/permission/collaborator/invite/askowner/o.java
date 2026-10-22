package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ InviteMemberAskOwnerView a;

    public o(InviteMemberAskOwnerView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(this.a.d.getId(), "");
    }
}
