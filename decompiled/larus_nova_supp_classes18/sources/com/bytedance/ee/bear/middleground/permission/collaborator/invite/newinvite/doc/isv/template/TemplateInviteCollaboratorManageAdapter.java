package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.isv.template;

import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class TemplateInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {
    public TemplateInviteCollaboratorManageAdapter(Locale r1, AccountService.Account r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r1, UserInfo r2) {
        super.y2(r1, r2);
        r1.getView(2131386093).setVisibility(8);
    }
}
