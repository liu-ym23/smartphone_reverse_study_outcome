package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.isv.template;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class TemplateInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {
    public TemplateInviteCollaboratorManageAdapter(Locale r100, AccountService$Account r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, UserInfo r101) {
        y2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r100, UserInfo r101) {
        super.y2(r100, r101);
        r100.getView(R.id.share_item_permission_icon).setVisibility(8);
    }
}
