package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ InviteMemberAskOwnerView a;
    public final /* synthetic */ UserInfo b;

    public f(InviteMemberAskOwnerView r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.o(this.b);
    }
}
