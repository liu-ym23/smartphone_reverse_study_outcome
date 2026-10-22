package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ InviteMemberAskOwnerView a;
    public final /* synthetic */ UserInfo b;

    public i(InviteMemberAskOwnerView r1, UserInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        InviteMemberAskOwnerView r5 = this.a;
        UserInfo r0 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, "userInfo");
        tt5.a.h("InviteMemberAskOwnerView", "onClickSetCanEdit()...position = " + r5.i);
        com.bytedance.ee.bear.middleground.permission.c.k(r0, 4);
        r0.setPermission(4);
        r5.h().notifyItemChanged(r5.i);
        vi5.a r6 = r5.h;
        if (r6 == null) goto L6;
        r6.b();
        return;
    }
}
