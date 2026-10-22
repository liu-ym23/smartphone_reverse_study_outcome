package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class FolderInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f233165d;

    public FolderInviteCollaboratorManageAdapter(Locale r100, AccountService$Account r101) {
        super(r100, r101);
        this.f233165d = true;
    }

    public static void z2(BaseViewHolder r100, boolean r101) {
        ImageView r102 = (ImageView) r100.getView(R.id.share_collaborator_delete);
        TextView r103 = (TextView) r100.getView(R.id.share_item_permission);
        ImageView r104 = (ImageView) r100.getView(R.id.share_item_permission_icon);
        if (r101 == false) goto L5;
        r102.setVisibility(8);
        r103.setVisibility(0);
        r104.setVisibility(0);
        return;
    L5:
        r102.setVisibility(0);
        r103.setVisibility(8);
        r104.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, UserInfo r101) {
        y2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r100, UserInfo r101) {
        super.y2(r100, r101);
        int r102 = 0;
        if (this.f233165d == false) goto L33;
        boolean r103 = true;
        z2(r100, true);
        TextView r104 = (TextView) r100.getView(R.id.share_item_permission);
        ImageView r105 = (ImageView) r100.getView(R.id.share_item_permission_icon);
        if (r101.getPermission() != 3) goto L8;
        String r106 = this.mContext.getString(R.string.CreationMobile_Wiki_Permission_FullAccess_Options);
    L14:
        r104.setText(r106);
        if (r101.isCan_modify_perm() == true) goto L17;
    L23:
        r103 = false;
    L24:
        r104.setEnabled(r103);
        if (r103 == false) goto L27;
        float r107 = 1.0f;
    L28:
        r104.setAlpha(r107);
        if (r103 == true) goto L32;
        r102 = 8;
    L32:
        r105.setVisibility(r102);
        r105.setEnabled(r103);
        f r108 = new f(this, r101, r100);
        r104.setOnClickListener(r108);
        r105.setOnClickListener(r108);
        return;
    L27:
        r107 = 0.5f;
        goto L28
    L17:
        if (r101.isOwner() == true) goto L23;
        AccountService$Account r109 = this.f233163b;
        if (r109 == null) goto L23;
        if (TextUtils.equals(r109.uid, r101.getId()) == true) goto L23;
    L8:
        if (r101.getPermission() != 2) goto L11;
        r106 = this.mContext.getString(R.string.Doc_Share_Editable);
        goto L14
    L11:
        if (r101.getPermission() != 1) goto L13;
        r106 = this.mContext.getString(R.string.Doc_Share_Readable);
        goto L14
    L13:
        r106 = "";
        goto L14
    L33:
        z2(r100, false);
        ((ImageView) r100.getView(R.id.share_collaborator_delete)).setOnClickListener(new e(this, r101, r100));
    }
}
