package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/BaseInviteCollaboratorManageAdapter;", "locale", "Ljava/util/Locale;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Ljava/util/Locale;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", "item", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberSendLinkAdapter extends BaseInviteCollaboratorManageAdapter {
    public static final /* synthetic */ int d = 0;

    public static final class a extends t {
        public final /* synthetic */ InviteMemberSendLinkAdapter c;
        public final /* synthetic */ UserInfo d;
        public final /* synthetic */ BaseViewHolder e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            InviteMemberSendLinkAdapter r4 = this.c;
            int r0 = InviteMemberSendLinkAdapter.d;
            BaseInviteCollaboratorManageAdapter.a r5 = r4.c;
            if (r5 == null) goto L6;
            r5.a(this.d, this.e.getLayoutPosition());
            return;
        }

        public a(InviteMemberSendLinkAdapter r1, UserInfo r2, BaseViewHolder r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
        }
    }

    public InviteMemberSendLinkAdapter(Locale r2, AccountService.Account r3) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        Intrinsics.checkNotNullParameter(r3, "account");
        super(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r5, UserInfo r6) {
        Intrinsics.checkNotNullParameter(r5, "helper");
        super.y2(r5, r6);
        View r0 = ((RecyclerView.ViewHolder) r5).itemView;
        ImageView r1 = null;
        if (r0 == null) goto L5;
        TextView r2 = (TextView) r0.findViewById(2131386092);
    L7:
        if (r2 == null) goto L9;
        r2.setVisibility(8);
    L9:
        View r3 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r3 == null) goto L12;
        ImageView r4 = (ImageView) r3.findViewById(2131386093);
    L13:
        if (r4 == null) goto L15;
        r4.setVisibility(8);
    L15:
        View r7 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r7 == null) goto L18;
        ImageView r8 = (ImageView) r7.findViewById(2131386069);
    L19:
        if (r8 == null) goto L21;
        r8.setVisibility(0);
    L21:
        View r9 = ((RecyclerView.ViewHolder) r5).itemView;
        if (r9 == null) goto L24;
        r1 = (ImageView) r9.findViewById(2131386069);
    L24:
        if (r1 == null) goto L27;
        r1.setOnClickListener(new a(this, r6, r5));
        return;
    L27:
        return;
    L18:
        r8 = null;
        goto L19
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }
}
