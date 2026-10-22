package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.b;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.InviteMemberAskOwnerFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.DocInviteMemberManagerFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.InviteMemberSendLinkFragment;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import sbb.e;
import sbb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\u0018\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0014J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0014H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/DocInviteMemberFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BaseInviteMemberFragment;", "<init>", "()V", "permSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "originUserInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "ownerInfo", "module", "", "inviteDepEnable", "", "inviteUserGroupEnable", "inviteEmailEnable", "isFromSharePanel", "isAtVC", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "buildInviteParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "fromSharePanel", "jumpNextPage", "jumpAskOwner", "jumpInviteMemberManage", "jumpSendLink", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onFloatDismiss", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocInviteMemberFragment extends BaseInviteMemberFragment {
    public static final /* synthetic */ int t = 0;
    public DocPermSetInfo k;
    public final ArrayList<UserInfo> l;
    public UserInfo m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;

    public static final class a {
    }

    static {
    }

    @Override // dh5.a
    public final void O50() {
        String r1 = null;
        if (this.k.f.a.canManageCollaborator() == false) goto L10;
        int r0 = DocInviteMemberManagerFragment.k;
        Context r2 = requireContext();
        DocPermSetInfo r6 = this.k;
        String r7 = this.n;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("module");
    L8:
        UserInfo r8 = this.m;
        boolean r9 = this.r;
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "permSetInfo");
        Intrinsics.checkNotNullParameter(r1, "module");
        Bundle r3 = new Bundle();
        r3.putParcelable("extra_perm_set_info", r6);
        r3.putString("extra_module", r1);
        r3.putBoolean("from_share_panel", r9);
        r3.putParcelable("extra_owner_info", r8);
        ha0(Fragment.instantiate(r2, DocInviteMemberManagerFragment.class.getName(), r3));
        return;
    L7:
        r1 = r7;
        goto L8
    L10:
        if (this.k.f.b.isLinkShareClose() == false) goto L12;
        jD();
        return;
    L12:
        int r4 = InviteMemberSendLinkFragment.h;
        Context r5 = requireContext();
        DocPermSetInfo r10 = this.k;
        String r11 = this.n;
        if (r11 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("module");
    L16:
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "permSetInfo");
        Intrinsics.checkNotNullParameter(r1, "module");
        Bundle r12 = new Bundle();
        r12.putParcelable("extra_perm_set_info", r10);
        r12.putString("permission_module", r1);
        ha0(Fragment.instantiate(r5, InviteMemberSendLinkFragment.class.getName(), r12));
        return;
    L15:
        r1 = r11;
        goto L16
    }

    public final void Y90() {
        tt5.a.h("InviteMemberFragment", "onFloatDismiss");
        fa0();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final InviteMemberParams ba0() {
        DocPermSetInfo r1 = this.k;
        if (r1.d == false) goto L5;
    L12:
        boolean r2 = false;
    L13:
        int r3 = this.k.getType();
        e r7 = e.q;
        if (r3 != r7.b) goto L16;
        r2 = false;
    L16:
        DocPermSetInfo r4 = this.k;
        if (r4.d == false) goto L19;
    L22:
        boolean r5 = this.k.f.b.externalAccess();
    L24:
        if (this.k.f.b.partnerTenantCross() == true) goto L26;
    L28:
        boolean r8 = false;
    L29:
        tt5.a.h("InviteMemberFragment", "canReAdd = " + r2 + ", externalAccess = " + r5 + ", partnerTenantAccess = " + r8);
        DocPermSetInfo r9 = this.k;
        String r10 = r9.c;
        int r11 = r9.getType();
        String r12 = this.k.e.getOwnerUid();
        String r13 = this.k.e.getSubType();
        String r14 = this.n;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r15 = null;
    L33:
        boolean r16 = this.o;
        boolean r6 = this.p;
        boolean r17 = this.q;
        boolean r28 = this.k.f.b.adminPartnerTenantCross();
        if (this.k.f.b.getPartnerTenantAccessBlockValue() != 1) goto L36;
        boolean r29 = true;
    L37:
        DocPermSetInfo r18 = this.k;
        boolean r19 = r18.d;
        boolean r21 = r18.a();
        DocPermSetInfo r20 = this.k;
        if (r20.d == true) goto L40;
        boolean r24 = r20.f.a.isFullAccess();
    L48:
        return new InviteMemberParams(r10, r11, r12, r13, r15, r16, r6, r17, r19, r2, false, r21, null, null, r24, r5, this.k.f.b.adminCanCross(), r8, r28, r29, this.k.f.b.canExternalAccessOpenEscape(), null, 5256192);
    L40:
        if (r20.f.a.isSinglePageFullAccess() == false) goto L42;
    L45:
        r24 = true;
        goto L48
    L42:
        if (this.k.f.a.isFullAccess() == true) goto L45;
        r24 = false;
        goto L48
    L36:
        r29 = false;
        goto L37
    L32:
        r15 = r14;
        goto L33
    L26:
        if (this.k.getType() == r7.b) goto L28;
        r8 = true;
        goto L29
    L19:
        if (r4.a() == true) goto L22;
        r5 = true;
        goto L24
    L5:
        if (r1.a() == true) goto L12;
        String r22 = this.n;
        if (r22 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r22 = null;
    L10:
        if (TextUtils.equals(r22, ThumbGlideUrl.SOURCE_TEMPLATE) == true) goto L12;
        r2 = true;
        goto L13
    }

    @Override // dh5.a
    public final void jD() {
        int r0 = InviteMemberAskOwnerFragment.j;
        Context r1 = requireContext();
        DocPermSetInfo r2 = this.k;
        UserInfo r3 = this.m;
        String r4 = this.n;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "permSetInfo");
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter("send_link", "source");
        Bundle r5 = new Bundle();
        r5.putParcelable("extra_perm_set_info", r2);
        r5.putParcelable("extra_owner_info", r3);
        r5.putString("permission_module", r4);
        r5.putString("extra_source", "send_link");
        ha0(Fragment.instantiate(r1, InviteMemberAskOwnerFragment.class.getName(), r5));
    }

    public DocInviteMemberFragment() {
        this.k = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
        this.l = new ArrayList();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final boolean ca0() {
        return this.r;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final ArrayList<UserInfo> da0() {
        return this.l;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final void onCreate(Bundle r19) {
        super.onCreate(r19);
        Bundle r1 = getArguments();
        boolean r2 = false;
        String r4 = null;
        if (r1 == null) goto L24;
        DocPermSetInfo r5 = (DocPermSetInfo) r1.getParcelable(DocumentType.DOC_NAME);
        if (r5 != null) goto L7;
        r5 = new DocPermSetInfo(null, 0, null, false, null, null, null, false, false, false, 2047);
    L7:
        this.k = r5;
        ArrayList r6 = r1.getParcelableArrayList("users");
        if (CollectionUtils.isEmpty(r6) == true) goto L10;
        ArrayList<UserInfo> r7 = this.l;
        Intrinsics.checkNotNull(r6);
        r7.addAll(r6);
    L10:
        this.n = r1.getString("permission_module", "");
        if (r6 == null) goto L22;
        Sequence r8 = CollectionsKt.asSequence(r6);
        if (r8 == null) goto L22;
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L20;
        Object r10 = r9.next();
        if (((UserInfo) r10).isOwner() == false) goto L16;
    L21:
        UserInfo r11 = (UserInfo) r10;
    L23:
        this.m = r11;
        this.r = r1.getBoolean("from_share_panel", false);
        this.s = r1.getBoolean("is_at_vc", false);
    L25:
        InviteMemberViewModel r3 = (InviteMemberViewModel) ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        this.i = r3;
        if (r3 == null) goto L28;
        r3.setDocPermSetInfo(this.k);
    L28:
        AccountService.Account r12 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r12 != null) goto L31;
    L33:
        boolean r13 = false;
    L34:
        if (r12 != null) goto L36;
    L38:
        boolean r14 = false;
    L39:
        if (r13 == true) goto L47;
        String r15 = this.n;
        if (r15 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("module");
    L45:
        if (Intrinsics.areEqual(r4, ThumbGlideUrl.SOURCE_TEMPLATE) == true) goto L47;
        boolean r16 = true;
    L48:
        this.o = r16;
        if (r16 == false) goto L56;
        if (r14 == false) goto L56;
        if (this.k.a() == false) goto L54;
    L55:
        boolean r17 = true;
    L57:
        this.p = r17;
        if (g.b(this.k.getType()) == false) goto L60;
    L74:
        this.q = r2;
        tt5.a.h("InviteMemberFragment", "isConsumer:" + r13 + ", type = " + this.k.getType() + ", isAtVC = " + this.s + ", inviteDepEnable = " + this.o + ", inviteUserGroupEnable = " + this.p + ", isFromSharePanel = " + this.r + ", inviteEmailEnable = " + this.q);
        return;
    L60:
        if (this.k.getType() == 125) goto L74;
        if (this.s == true) goto L74;
        if (this.k.getType() == e.f.b) goto L74;
        if (this.k.getType() == e.q.b) goto L74;
        if (this.k.a() == false) goto L70;
    L71:
        int r18 = b.a;
        if (c.a.a.f("ccm.permision.mail_sharing") == false) goto L74;
        r2 = true;
        goto L74
    L70:
        if (this.k.d == false) goto L74;
    L54:
        if (this.k.d == true) goto L55;
    L56:
        r17 = false;
        goto L57
    L43:
        r4 = r15;
    L47:
        r16 = false;
        goto L48
    L36:
        if (TextUtils.equals(r12.tenantId, this.k.e.getCreatorTenantId()) == false) goto L38;
        r14 = true;
        goto L39
    L31:
        if (r12.isConsumer() == false) goto L33;
        r13 = true;
        goto L34
    L20:
        r10 = null;
    L22:
        r11 = null;
        goto L23
    L24:
        tt5.a.d("InviteMemberFragment", "initData()...args == null!");
        goto L25
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        fa0();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment
    public final void Z90(WindowManager.LayoutParams r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "attributes");
        Intrinsics.checkNotNullParameter(r2, "attributes");
        if (r3 == false) goto L5;
        r2.height = n.p(getActivity()) - this.j;
        return;
    L5:
        r2.height = -1;
    }
}
