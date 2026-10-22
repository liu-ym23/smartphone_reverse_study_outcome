package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.folder.FolderInviteMemberManagerFragment;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.FolderPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\b\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/FolderInviteMemberFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BaseInviteMemberFragment;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/FolderPermSetInfo;", "originUserInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "ownerInfo", "module", "", "inviteDepEnable", "", "isFromSharePanel", "inviteUserGroupEnable", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "buildInviteParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "fromSharePanel", "jumpNextPage", "jumpAskOwner", "jumpInviteMemberManage", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FolderInviteMemberFragment extends BaseInviteMemberFragment {
    public static final /* synthetic */ int r = 0;
    public FolderPermSetInfo k;
    public final ArrayList<UserInfo> l;
    public UserInfo m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;

    public static final class a {
    }

    static {
    }

    @Override // dh5.a
    public final void jD() {
    }

    @Override // dh5.a
    public final void O50() {
        int r0 = FolderInviteMemberManagerFragment.i;
        Context r1 = requireContext();
        FolderPermSetInfo r2 = this.k;
        String r3 = this.n;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r3 = null;
    L5:
        UserInfo r4 = this.m;
        boolean r5 = this.p;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "permSetInfo");
        Intrinsics.checkNotNullParameter(r3, "module");
        Bundle r6 = new Bundle();
        r6.putParcelable("extra_perm_set_info", r2);
        r6.putString("extra_module", r3);
        r6.putBoolean("from_share_panel", r5);
        r6.putParcelable("extra_owner_info", r4);
        ha0(Fragment.instantiate(r1, FolderInviteMemberManagerFragment.class.getName(), r6));
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final InviteMemberParams ba0() {
        boolean r2 = true;
        boolean r13 = !this.k.b();
        if (this.k.b() == false) goto L5;
        r2 = this.k.j.b.externalAccess();
    L5:
        boolean r1 = this.k.j.b.partnerTenantAccess();
        tt5.a.h("FolderInviteMemberFragment", "canReAdd = " + r13 + ", externalAccess = " + r2 + ", partnerTenantAccess = " + r1);
        FolderPermSetInfo r3 = this.k;
        String r4 = r3.c;
        int r5 = r3.getType();
        String r6 = this.k.e;
        String r7 = this.n;
        if (r7 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r7 = null;
    L9:
        return new InviteMemberParams(r4, r5, r6, null, r7, this.o, this.q, false, false, r13, false, this.k.b(), null, null, false, r2, this.k.j.b.adminCanCross(), r1, this.k.j.b.adminPartnerTenantCanCross(), false, false, null, 7894408);
    }

    public FolderInviteMemberFragment() {
        this.k = new FolderPermSetInfo(0, null, null, 8191);
        this.l = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final boolean ca0() {
        return this.p;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final ArrayList<UserInfo> da0() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        boolean r0 = false;
        if (r8 == null) goto L24;
        FolderPermSetInfo r3 = (FolderPermSetInfo) r8.getParcelable(DocumentType.FOLDER_NAME);
        if (r3 != null) goto L7;
        r3 = new FolderPermSetInfo(0, null, null, 8191);
    L7:
        this.k = r3;
        ArrayList r4 = r8.getParcelableArrayList("users");
        if (CollectionUtils.isEmpty(r4) == true) goto L10;
        ArrayList<UserInfo> r5 = this.l;
        Intrinsics.checkNotNull(r4);
        r5.addAll(r4);
    L10:
        this.n = r8.getString("permission_module", "");
        if (r4 == null) goto L22;
        Sequence r6 = CollectionsKt.asSequence(r4);
        if (r6 == null) goto L22;
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();
        if (((UserInfo) r10).isOwner() == false) goto L16;
    L21:
        UserInfo r11 = (UserInfo) r10;
    L23:
        this.m = r11;
        this.p = r8.getBoolean("from_share_panel", false);
    L25:
        this.i = (InviteMemberViewModel) ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        AccountService.Account r12 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r12 != null) goto L28;
    L30:
        boolean r13 = false;
    L31:
        c r14 = c.a.a;
        if (r14.g("ccm.mobile.folder_invite_group_without_check_same_tenant") == true) goto L37;
        if (r12 != null) goto L36;
    L38:
        boolean r15 = false;
    L39:
        this.o = !r13;
        if (r14.g("ccm.permission.web.user_group") == true) goto L42;
    L48:
        tt5.a.h("FolderInviteMemberFragment", "isConsumer:" + r13 + ", inviteDepEnable=" + this.o + ",isFromSharePanel=" + this.p + ", inviteUserGroupEnable=" + this.q);
        return;
    L42:
        if (this.o == false) goto L47;
        if (r15 == false) goto L47;
        if (this.k.b() == false) goto L47;
        r0 = true;
    L47:
        this.q = r0;
        goto L48
    L36:
        if (TextUtils.equals(r12.tenantId, this.k.i) == false) goto L38;
    L37:
        r15 = true;
        goto L39
    L28:
        if (r12.isConsumer() == false) goto L30;
        r13 = true;
        goto L31
    L20:
        r10 = null;
    L22:
        r11 = null;
        goto L23
    L24:
        tt5.a.d("FolderInviteMemberFragment", "initData()...args == null!");
        goto L25
    }
}
