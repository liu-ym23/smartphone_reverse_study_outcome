package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.view.View;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.chad.library.adapter.base.BaseViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends t {
    public final /* synthetic */ UserInfo c;
    public final /* synthetic */ BaseViewHolder d;
    public final /* synthetic */ DocumentInviteCollaboratorManageAdapter e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r3) {
        BaseInviteCollaboratorManageAdapter.a r4 = this.e.c;
        if (r4 == null) goto L6;
        r4.a(this.c, this.d.getLayoutPosition());
        return;
    }

    public d(DocumentInviteCollaboratorManageAdapter r1, UserInfo r2, BaseViewHolder r3) {
        this.e = r1;
        this.c = r2;
        this.d = r3;
    }
}
