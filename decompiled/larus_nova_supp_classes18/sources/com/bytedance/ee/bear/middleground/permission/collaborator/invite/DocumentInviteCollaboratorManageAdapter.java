package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocumentInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {
    public DocumentInviteCollaboratorManageAdapter(Locale r1, AccountService.Account r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r5, UserInfo r6) {
        super.y2(r5, r6);
        TextView r0 = (TextView) r5.getView(2131386092);
        ImageView r1 = (ImageView) r5.getView(2131386093);
        if (DocUserPermission.canEdit(r6.getPermission()) == false) goto L6;
        String r2 = ((BaseQuickAdapter) this).mContext.getString(2131888210);
    L12:
        r0.setText(r2);
        d r3 = new d(this, r6, r5);
        r0.setOnClickListener(r3);
        r1.setOnClickListener(r3);
        return;
    L6:
        if (DocUserPermission.canRead(r6.getPermission()) == false) goto L9;
        r2 = ((BaseQuickAdapter) this).mContext.getString(2131888241);
        goto L12
    L9:
        if (DocUserPermission.isFullAccess(r6.getPermission()) == false) goto L11;
        r2 = ((BaseQuickAdapter) this).mContext.getString(2131887512);
        goto L12
    L11:
        r2 = ((BaseQuickAdapter) this).mContext.getString(2131887513);
        goto L12
    }
}
