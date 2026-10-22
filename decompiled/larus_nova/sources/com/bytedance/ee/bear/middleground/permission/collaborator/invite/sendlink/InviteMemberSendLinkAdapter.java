package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/sendlink/InviteMemberSendLinkAdapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/BaseInviteCollaboratorManageAdapter;", "locale", "Ljava/util/Locale;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "<init>", "(Ljava/util/Locale;Lcom/bytedance/ee/bear/contract/AccountService$Account;)V", "convert", "", "helper", "Lcom/chad/library/adapter/base/BaseViewHolder;", MapController.ITEM_LAYER_TAG, "Lcom/bytedance/ee/bear/share/export/UserInfo;", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberSendLinkAdapter extends BaseInviteCollaboratorManageAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f233354d = 0;

    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InviteMemberSendLinkAdapter f233355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ UserInfo f233356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f233357e;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            InviteMemberSendLinkAdapter r101 = this.f233355c;
            int r102 = InviteMemberSendLinkAdapter.f233354d;
            BaseInviteCollaboratorManageAdapter.a r103 = r101.f233164c;
            if (r103 == null) goto L6;
            r103.a(this.f233356d, this.f233357e.getLayoutPosition());
            return;
        }

        public a(InviteMemberSendLinkAdapter r100, UserInfo r101, BaseViewHolder r102) {
            this.f233355c = r100;
            this.f233356d = r101;
            this.f233357e = r102;
        }
    }

    public InviteMemberSendLinkAdapter(Locale r100, AccountService$Account r101) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        Intrinsics.checkNotNullParameter(r101, "account");
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
        View r102 = r100.itemView;
        ImageView r103 = null;
        if (r102 == null) goto L5;
        TextView r104 = (TextView) r102.findViewById(R.id.share_item_permission);
    L7:
        if (r104 == null) goto L9;
        r104.setVisibility(8);
    L9:
        View r105 = r100.itemView;
        if (r105 == null) goto L12;
        ImageView r106 = (ImageView) r105.findViewById(R.id.share_item_permission_icon);
    L13:
        if (r106 == null) goto L15;
        r106.setVisibility(8);
    L15:
        View r107 = r100.itemView;
        if (r107 == null) goto L18;
        ImageView r108 = (ImageView) r107.findViewById(R.id.share_collaborator_delete);
    L19:
        if (r108 == null) goto L21;
        r108.setVisibility(0);
    L21:
        View r109 = r100.itemView;
        if (r109 == null) goto L24;
        r103 = (ImageView) r109.findViewById(R.id.share_collaborator_delete);
    L24:
        if (r103 == null) goto L27;
        r103.setOnClickListener(new a(this, r101, r100));
        return;
    L27:
        return;
    L18:
        r108 = null;
        goto L19
    L12:
        r106 = null;
        goto L13
    L5:
        r104 = null;
        goto L7
    }
}
