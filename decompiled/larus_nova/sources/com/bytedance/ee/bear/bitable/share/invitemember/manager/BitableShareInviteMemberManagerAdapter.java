package com.bytedance.ee.bear.bitable.share.invitemember.manager;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/invitemember/manager/BitableShareInviteMemberManagerAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/BaseInviteCollaboratorManageAdapter;", "locale", "Ljava/util/Locale;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Ljava/util/Locale;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "getLocale", "()Ljava/util/Locale;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/share/export/UserInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareInviteMemberManagerAdapter extends BaseInviteCollaboratorManageAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f215317d = 0;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BitableShareInviteMemberManagerAdapter f215318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserInfo f215319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f215320e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            BitableShareInviteMemberManagerAdapter r101 = this.f215318c;
            int r102 = BitableShareInviteMemberManagerAdapter.f215317d;
            BaseInviteCollaboratorManageAdapter.a r103 = r101.f233164c;
            if (r103 == null) goto L6;
            r103.a(this.f215319d, this.f215320e.getLayoutPosition());
            return;
        }

        public a(BitableShareInviteMemberManagerAdapter r100, UserInfo r101, BaseViewHolder r102) {
            this.f215318c = r100;
            this.f215319d = r101;
            this.f215320e = r102;
        }
    }

    public BitableShareInviteMemberManagerAdapter(Locale r100, AccountService$Account r101) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        super(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public final /* bridge */ /* synthetic */ void convert(BaseViewHolder r100, UserInfo r101) {
        y2(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter
    public final void y2(BaseViewHolder r100, UserInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "helper");
        super.y2(r100, r101);
        r100.setVisible(R.id.share_item_permission, false).setVisible(R.id.share_item_permission_icon, false).setVisible(R.id.share_collaborator_delete, true);
        r100.getView(R.id.share_collaborator_delete).setOnClickListener(new a(this, r101, r100));
    }
}
