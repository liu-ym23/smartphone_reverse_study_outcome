package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class DocumentInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {
    public DocumentInviteCollaboratorManageAdapter(Locale r100, AccountService$Account r101) {
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, UserInfo r101) {
        y2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r100, UserInfo r101) {
        super.y2(r100, r101);
        TextView r102 = (TextView) r100.getView(R.id.share_item_permission);
        ImageView r103 = (ImageView) r100.getView(R.id.share_item_permission_icon);
        if (DocUserPermission.canEdit(r101.getPermission()) == false) goto L6;
        String r104 = this.mContext.getString(R.string.Doc_Share_Editable);
    L12:
        r102.setText(r104);
        d r105 = new d(this, r101, r100);
        r102.setOnClickListener(r105);
        r103.setOnClickListener(r105);
        return;
    L6:
        if (DocUserPermission.canRead(r101.getPermission()) == false) goto L9;
        r104 = this.mContext.getString(R.string.Doc_Share_Readable);
        goto L12
    L9:
        if (DocUserPermission.isFullAccess(r101.getPermission()) == false) goto L11;
        r104 = this.mContext.getString(R.string.CreationMobile_Wiki_Permission_FullAccess_Options);
        goto L12
    L11:
        r104 = this.mContext.getString(R.string.CreationMobile_Wiki_Permission_NoAccess_Options);
        goto L12
    }
}
