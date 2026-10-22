package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import cj5.c;
import com.bytedance.ee.bear.bitable.lynx.pro.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.BitableProInviteMemberManagerFragment;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import e0c.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0019H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BitableProInviteMemberFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BaseInviteMemberFragment;", "<init>", "()V", "originUserInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "existUserInfoList", "topStickUserInfoList", ResourceData.KEY_TOKEN, "", "roleId", "ownerId", "createTenantId", "isTemplate", "", ResourceData.KEY_TYPE, "", "delegate", "Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/api/IShareUIService$IInviteMemberDelegate;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "buildInviteParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "fromSharePanel", "jumpNextPage", "jumpAskOwner", "jumpInviteMemberManage", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProInviteMemberFragment extends BaseInviteMemberFragment {
    public final ArrayList<UserInfo> k;
    public ArrayList<UserInfo> l;
    public ArrayList<UserInfo> m;
    public String n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public final int s;
    public c.a t;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final boolean ca0() {
        return false;
    }

    @Override // dh5.a
    public final void jD() {
    }

    @Override // dh5.a
    public final void O50() {
        int r0 = BitableProInviteMemberManagerFragment.l;
        Context r1 = requireContext();
        String r2 = this.n;
        int r3 = this.s;
        String r4 = this.o;
        String r5 = this.p;
        ArrayList<UserInfo> r6 = this.k;
        c.a r7 = this.t;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "roleId");
        Intrinsics.checkNotNullParameter(r5, "ownerId");
        Intrinsics.checkNotNullParameter(r6, "originUsers");
        Bundle r8 = new Bundle();
        r8.putString("extra_token", r2);
        r8.putInt("extra_type", r3);
        r8.putString("extra_owner_id", r5);
        r8.putSerializable("extra_users", r6);
        r8.putString("extra_role_id", r4);
        BitableProInviteMemberManagerFragment r9 = Fragment.instantiate(r1, BitableProInviteMemberManagerFragment.class.getName(), r8);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.BitableProInviteMemberManagerFragment");
        BitableProInviteMemberManagerFragment r10 = r9;
        r10.k = r7;
        ha0(r10);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final InviteMemberParams ba0() {
        AccountService.Account r1 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r1 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        boolean r11 = !r4;
        tt5.a.h("BitableProInviteMemberFragment", "isConsumer:" + r4 + " isSameTenant:" + r2 + " isTemplate:" + this.r + " inviteDepEnable=" + r11 + ' ');
        if (r4 == true) goto L19;
        if (r2 == false) goto L19;
        if (this.r == true) goto L19;
        boolean r12 = true;
    L21:
        return new InviteMemberParams(this.n, this.s, this.p, null, null, r11, r12, false, false, false, true, false, "ccm_bitable_premium_permission_invite_collaborator_view", null, false, true, true, false, false, false, false, this.l, 4090776);
    L19:
        r12 = false;
        goto L21
    L10:
        if (TextUtils.equals(r1.tenantId, this.q) == false) goto L12;
        r2 = true;
        goto L13
    L5:
        if (r1.isConsumer() == false) goto L7;
        r4 = true;
        goto L8
    }

    public BitableProInviteMemberFragment() {
        this.k = new ArrayList();
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = e.i.b;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final ArrayList<UserInfo> da0() {
        return this.k;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final ArrayList<UserInfo> ga0() {
        return this.m;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Bundle r4 = getArguments();
        if (r4 == null) goto L8;
        ArrayList r0 = r4.getParcelableArrayList("users");
        if (CollectionUtils.isEmpty(r0) == true) goto L7;
        ArrayList<UserInfo> r1 = this.k;
        Intrinsics.checkNotNull(r0);
        r1.addAll(r0);
    L7:
        this.n = r4.getString("extra_token", "");
        this.o = r4.getString("extra_role_id", "");
        this.p = r4.getString("extra_owner_id", "");
        this.q = r4.getString("extra_create_tenant_id", "");
        this.r = r4.getBoolean("extra_is_template", false);
        this.m = r4.getParcelableArrayList("extra_top_stick_users");
        this.l = r4.getParcelableArrayList("exist_users");
    L9:
        this.i = (InviteMemberViewModel) ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        return;
    L8:
        tt5.a.d("BitableProInviteMemberFragment", "initData()...args == null!");
        goto L9
    }

    @JvmStatic
    public static final void ia0(FragmentActivity r2, Fragment r3, String r4, String r5, String r6, String r7, boolean r8, ArrayList r9, ArrayList r10, ArrayList r11, d r12) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "ownerId");
        Intrinsics.checkNotNullParameter(r6, "roleId");
        Intrinsics.checkNotNullParameter(r7, "createTenantId");
        Intrinsics.checkNotNullParameter(r9, "originUsers");
        Bundle r0 = new Bundle();
        r0.putString("extra_token", r4);
        r0.putString("extra_owner_id", r5);
        r0.putString("extra_role_id", r6);
        r0.putString("extra_create_tenant_id", r7);
        r0.putBoolean("extra_is_template", r8);
        r0.putParcelableArrayList("users", r9);
        r0.putParcelableArrayList("exist_users", r11);
        r0.putParcelableArrayList("extra_top_stick_users", r10);
        BitableProInviteMemberFragment r13 = Fragment.instantiate(r2, BitableProInviteMemberFragment.class.getName(), r0);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.search.BitableProInviteMemberFragment");
        BitableProInviteMemberFragment r14 = r13;
        r14.t = r12;
        com.bytedance.ee.bear.appsetting.c r15 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r16 = LarkContext.getApplication();
        r15.getClass();
        boolean r17 = ((dn4.a) k.b(((v) k.a(r16, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r16, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.bitable.big_screen_panel_adaptation_v2");
        tt5.a.h("BitableProInviteMemberFragment", "BITABLE_BIG_SCREEN_PANEL_ADAPTATION_V2...enable = " + r17);
        if (r17 == true) goto L5;
    L7:
        boolean r18 = false;
    L8:
        if (r18 == true) goto L10;
    L11:
        FragmentManager r19 = r2.getSupportFragmentManager();
        String r20 = BitableProInviteMemberFragment.class.getName();
        LandscapeRestrictionOperation r21 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r14, r20, r21);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r19, r14, r21) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L17
    L15:
        r14.show(r19, r20);
        return;
    L21:
        return;
    L10:
        if (f.e(r14, r3, ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, ForsetiHelper.m(), 28) == false) goto L11;
        return;
    L5:
        if (ForsetiHelper.s(r3) == false) goto L7;
        r18 = true;
        goto L8
    }
}
