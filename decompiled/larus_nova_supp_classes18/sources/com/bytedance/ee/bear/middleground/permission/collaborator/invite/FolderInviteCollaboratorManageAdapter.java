package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderInviteCollaboratorManageAdapter extends BaseInviteCollaboratorManageAdapter {
    public final boolean d;

    public FolderInviteCollaboratorManageAdapter(Locale r1, AccountService.Account r2) {
        super(r1, r2);
        this.d = true;
    }

    public static void z2(BaseViewHolder r4, boolean r5) {
        ImageView r0 = (ImageView) r4.getView(2131386069);
        TextView r1 = (TextView) r4.getView(2131386092);
        ImageView r6 = (ImageView) r4.getView(2131386093);
        if (r5 == false) goto L5;
        r0.setVisibility(8);
        r1.setVisibility(0);
        r6.setVisibility(0);
        return;
    L5:
        r0.setVisibility(0);
        r1.setVisibility(8);
        r6.setVisibility(8);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r7, UserInfo r8) {
        super.y2(r7, r8);
        int r1 = 0;
        if (this.d == false) goto L33;
        boolean r0 = true;
        z2(r7, true);
        TextView r2 = (TextView) r7.getView(2131386092);
        ImageView r3 = (ImageView) r7.getView(2131386093);
        if (r8.getPermission() != 3) goto L8;
        String r4 = ((BaseQuickAdapter) this).mContext.getString(2131887512);
    L14:
        r2.setText(r4);
        if (r8.isCan_modify_perm() == true) goto L17;
    L23:
        r0 = false;
    L24:
        r2.setEnabled(r0);
        if (r0 == false) goto L27;
        float r5 = 1.0f;
    L28:
        r2.setAlpha(r5);
        if (r0 == true) goto L32;
        r1 = 8;
    L32:
        r3.setVisibility(r1);
        r3.setEnabled(r0);
        f r6 = new f(this, r8, r7);
        r2.setOnClickListener(r6);
        r3.setOnClickListener(r6);
        return;
    L27:
        r5 = 0.5f;
        goto L28
    L17:
        if (r8.isOwner() == true) goto L23;
        AccountService.Account r9 = this.b;
        if (r9 == null) goto L23;
        if (TextUtils.equals(r9.uid, r8.getId()) == true) goto L23;
    L8:
        if (r8.getPermission() != 2) goto L11;
        r4 = ((BaseQuickAdapter) this).mContext.getString(2131888210);
        goto L14
    L11:
        if (r8.getPermission() != 1) goto L13;
        r4 = ((BaseQuickAdapter) this).mContext.getString(2131888241);
        goto L14
    L13:
        r4 = "";
        goto L14
    L33:
        z2(r7, false);
        ((ImageView) r7.getView(2131386069)).setOnClickListener(new e(this, r8, r7));
    }
}
