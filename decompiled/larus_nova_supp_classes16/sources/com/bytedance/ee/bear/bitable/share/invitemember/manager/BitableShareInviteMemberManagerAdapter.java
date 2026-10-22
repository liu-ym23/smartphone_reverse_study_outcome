package com.bytedance.ee.bear.bitable.share.invitemember.manager;

import android.view.View;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/invitemember/manager/BitableShareInviteMemberManagerAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/BaseInviteCollaboratorManageAdapter;", "locale", "Ljava/util/Locale;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Ljava/util/Locale;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "getLocale", "()Ljava/util/Locale;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", "item", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareInviteMemberManagerAdapter extends BaseInviteCollaboratorManageAdapter {
    public static final /* synthetic */ int d = 0;

    public static final class a extends t {
        public final /* synthetic */ BitableShareInviteMemberManagerAdapter c;
        public final /* synthetic */ UserInfo d;
        public final /* synthetic */ BaseViewHolder e;

        public final void a(View r3) {
            BitableShareInviteMemberManagerAdapter r4 = this.c;
            int r0 = BitableShareInviteMemberManagerAdapter.d;
            BaseInviteCollaboratorManageAdapter.a r5 = ((BaseInviteCollaboratorManageAdapter) r4).c;
            if (r5 == null) goto L6;
            r5.a(this.d, this.e.getLayoutPosition());
            return;
        }

        public a(BitableShareInviteMemberManagerAdapter r1, UserInfo r2, BaseViewHolder r3) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
        }
    }

    public BitableShareInviteMemberManagerAdapter(Locale r2, AccountService$Account r3) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        super(r2, r3);
    }

    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r1, Object r2) {
        y2(r1, (UserInfo) r2);
    }

    public final void y2(BaseViewHolder r4, UserInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "helper");
        super.y2(r4, r5);
        r4.setVisible(2131386092, false).setVisible(2131386093, false).setVisible(2131386069, true);
        r4.getView(2131386069).setOnClickListener(new a(this, r5, r4));
    }
}
