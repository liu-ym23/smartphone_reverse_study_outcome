package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground.permission.escape.request.EscapeRuleResult;
import com.bytedance.ee.bear.middleground.permission.external.BlockReason;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.bear.middleground.permission.secret.b0;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SearchUserResultAdapter extends BaseQuickAdapter<UserInfo, SearchUserViewHolder> {
    public static final /* synthetic */ int q = 0;
    public final Context a;
    public final Locale b;
    public final AccountService.Account c;
    public final List<UserInfo> d;
    public final List<UserInfo> e;
    public final List<Member> f;
    public a g;
    public final InviteMemberParams h;
    public final InviteMemberViewModel i;
    public th5.b j;
    public List<SecretLevel> k;
    public Disposable l;
    public SearchUserViewHolder m;
    public UserInfo n;
    public EscapeRuleBean o;
    public EscapeApprovalInfo p;

    public static class SearchUserViewHolder extends BaseViewHolder {
        public final UDAvatar a;
        public final SpaceTagTitleView b;
        public final TextView c;
        public final UDCheckBox d;

        public SearchUserViewHolder(View r2) {
            super(r2);
            this.a = r2.findViewById(2131386088);
            this.b = (SpaceTagTitleView) r2.findViewById(2131386091);
            this.c = (TextView) r2.findViewById(2131386094);
            this.d = r2.findViewById(2131386067);
        }
    }

    public interface a {
        void P(UserInfo r1);

        void a(SearchUserViewHolder r1, UserInfo r2, boolean r3);
    }

    public final void C2() {
        tt5.a.h("SearchUserResultAdapter", "fetchVisibleSecret()...");
        Disposable r0 = this.l;
        if (r0 != null) goto L5;
    L7:
        int r1 = com.bytedance.ee.bear.middleground.permission.secret.p.a;
        InviteMemberParams r2 = this.h;
        this.l = com.bytedance.ee.bear.middleground.permission.secret.p.a(r2.a, r2.getType()).subscribe(new e(this), new f());
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.l.dispose();
        goto L7
    }

    public final boolean F2() {
        Iterator r0 = ((ArrayList) this.e).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((UserInfo) r0.next()).getOwnerType() != 29) goto L4;
        r2 = r2 + 1;
        goto L4
    L9:
        if (r2 < 10) goto L17;
        return true;
    L17:
        return false;
    }

    public final void D2(final h r10) {
        tt5.a.h("SearchUserResultAdapter", "getEscapeRuleAndInstanceList");
        Context r0 = this.a;
        Toast.showLoading(r0, r0.getString(2131888906));
        InviteMemberParams r1 = this.h;
        String r2 = r1.a;
        int r3 = r1.getType();
        InviteMemberParams r4 = this.h;
        String r5 = r4.a;
        int r6 = r4.getType();
        if (this.h.i == false) goto L5;
        int r7 = 2;
    L6:
        String r8 = li5.m.a(r5, r6, 1, r7);
        int r9 = oh5.b.a;
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter("external_access", "escapeSetting");
        Intrinsics.checkNotNullParameter(r8, "permReqParam");
        Flowable<EscapeRuleResult> r11 = oh5.f.a(r2, r3);
        int r12 = oh5.h.a;
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        StringCompanionObject r13 = StringCompanionObject.INSTANCE;
        Flowable.zip(r11, ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new oh5.g()).a(new NetService.f(String.format(Locale.US, "/space/api/sec_label/escape_rule/approval/instance/list?token=%s&type=%d", Arrays.copyOf(new Object[]{r2, Integer.valueOf(r3)}, 2)))), new oh5.a(r2, r3, r8)).subscribe(new c(this, r10), new d());
        return;
    L5:
        r7 = 0;
        goto L6
    }

    public final boolean E2(UserInfo r8) {
        if (this.h.j == false) goto L6;
        return false;
    L6:
        if (this.c == null) goto L11;
        if (TextUtils.equals(r8.getId(), this.c.uid) == false) goto L11;
        return true;
    L11:
        if (((ArrayList) this.d).contains(r8) == true) goto L13;
    L15:
        Iterator r0 = ((ArrayList) this.f).iterator();
    L17:
        if (r0.hasNext() == false) goto L25;
        Member r4 = (Member) r0.next();
        if (TextUtils.equals(r8.getId(), r4.getMemberId()) == false) goto L17;
        if (r8.getOwnerType() != r4.getMemberType()) goto L17;
        if (r8.getOwnerType() == 29) goto L17;
        return true;
    L25:
        return false;
    L13:
        if (r8.getOwnerType() == 29) goto L15;
        return true;
    }

    public final void H2(UserInfo r2) {
        ((ArrayList) this.e).remove(r2);
        if (((BaseQuickAdapter) this).mData.contains(r2) == false) goto L6;
        notifyDataSetChanged();
        return;
    }

    public final BaseViewHolder createBaseViewHolder(View r2) {
        return new SearchUserViewHolder(r2);
    }

    public static boolean z2(SearchUserResultAdapter r6, UserInfo r7) {
        if (r6.h.getType() != sbb.e.f.b) goto L5;
        return false;
    L5:
        if (r6.h.getType() == sbb.e.q.b) goto L74;
        InviteMemberParams r0 = r6.h;
        if (r0.i == true) goto L13;
        if (r0.l == true) goto L13;
        return false;
    L13:
        if (r0.o == false) goto L76;
        InviteMemberViewModel r1 = r6.i;
        if (r1 != null) goto L18;
    L68:
        tt5.a.h("SearchUserResultAdapter", "isEnableAdjustExternalShare()...viewModel or docPermSetInfo is null.");
        return false;
    L18:
        if (r1.getDocPermSetInfo() == null) goto L68;
        DocPermSetInfo r2 = r6.i.getDocPermSetInfo();
        DocPermSetInfo r3 = r6.i.getDocPermSetInfo();
        if (r3 == null) goto L32;
        IDocPublicPermission r4 = r3.f.b;
        if (r4.isPartnerTenant(r7.getTenantId()) == true) goto L25;
    L29:
        boolean r5 = false;
    L30:
        if (r5 == false) goto L32;
        SceneType r8 = SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER;
    L34:
        if (r8 != SceneType.INVITE_EXTERNAL_MEMBER) goto L38;
        if (r2.f.a.getShareExternal() != BlockReason.BLOCK_BY_SECRET.getValue()) goto L38;
    L41:
        List<SecretLevel> r9 = r6.k;
        if (r9 != null) goto L45;
        r6.C2();
        return false;
    L45:
        if (hu5.a.d(b0.c(r9, r8, null)) == true) goto L77;
    L47:
        IDocPublicPermission r10 = r2.f.b;
        if (r10.isPartnerTenant(r7.getTenantId()) == true) goto L50;
    L54:
        boolean r11 = false;
    L55:
        if (r11 == false) goto L62;
        if (r2.f.a.isSharePartnerTenantDeniedBySecret() == false) goto L59;
    L67:
        return true;
    L59:
        if (r2.f.a.isSharePartnerTenantDeniedByPublicPerm() == true) goto L67;
    L62:
        if (r2.f.a.isShareExternalDeniedBySecret() == true) goto L67;
        if (r2.f.a.isShareExternalDeniedByPublicPerm() == true) goto L67;
        if (r2.f.a.isShareExternalSelectPartnerTenantShare() == true) goto L67;
        return false;
    L50:
        if (r10.adminPartnerTenantCross() == false) goto L52;
    L53:
        r11 = true;
        goto L55
    L52:
        if (r10.adminCanCross() == false) goto L54;
    L77:
        return false;
    L38:
        if (r8 != SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER) goto L47;
        if (r2.f.a.getSharePartnerTenant() != BlockReason.BLOCK_BY_SECRET.getValue()) goto L47;
    L25:
        if (r4.adminPartnerTenantCross() == false) goto L27;
    L28:
        r5 = true;
        goto L30
    L27:
        if (r4.adminCanCross() == false) goto L29;
    L32:
        r8 = SceneType.INVITE_EXTERNAL_MEMBER;
        goto L34
    L76:
        return false;
    L74:
        return false;
    }

    public final void B2(SearchUserViewHolder r4, UserInfo r5) {
        tt5.a.h("SearchUserResultAdapter", "doSelectUser, uid: " + r5.getId());
        boolean r0 = ((ArrayList) this.e).contains(r5) ^ true;
        if (r0 == true) goto L5;
    L10:
        G2(r4, r5, r0);
        return;
    L5:
        if (r5.getOwnerType() != 29) goto L10;
        if (F2() == false) goto L10;
        Context r6 = this.a;
        Toast.showFailureText(r6, xo5.a.c(r6, 2131889095, SheetInputData.InputData.FormatType.NUMBER, String.valueOf(10)));
    }

    public final void convert(BaseViewHolder r10, Object r11) {
        SearchUserViewHolder r12 = (SearchUserViewHolder) r10;
        UserInfo r13 = (UserInfo) r11;
        float r1 = 1.0f;
        ((RecyclerView.ViewHolder) r12).itemView.setAlpha(1.0f);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(null);
        pg5.a.b(r12.a, r13);
        String r0 = r13.getDisplayName(this.b);
        if (ou5.a.e() == false) goto L5;
        r0 = ou5.c.e(this.b.getLanguage(), r13.getI18nNames(), r0);
    L5:
        r12.b.setTitle(r0);
        if (r13.getOwnerType() == 2) goto L8;
    L12:
        r12.b.setUnConstraintTitle("");
    L13:
        SpaceTagTitleView r2 = r12.b;
        boolean r3 = true;
        String r5 = r13.getOrganizationTagValue();
        boolean r6 = r13.isExternal();
        int r7 = ui5.c.a;
        boolean r8 = ui5.c.a(this.c);
        int r9 = SpaceTagType.e;
        r2.setLabels(new SpaceTagType[]{SpaceTagType.Companion.f(r5, r6, r8)});
        int r4 = 8;
        if (r13.getOwnerType() != 2) goto L16;
    L23:
        TextView r14 = r12.c;
        if (TextUtils.isEmpty(r13.getLabel()) == true) goto L27;
        r4 = 0;
    L27:
        r14.setVisibility(r4);
        r12.c.setText(r13.getLabel());
    L28:
        UDCheckBox r15 = r12.d;
        if (((ArrayList) this.e).contains(r13) == false) goto L31;
    L48:
        boolean r16 = true;
    L49:
        r15.setChecked(r16);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new g(this, r13, r12));
        if (this.c != null) goto L52;
    L54:
        boolean r17 = false;
    L55:
        if (r17 == false) goto L57;
    L66:
        boolean r18 = false;
    L68:
        if (r13.isBlock() == false) goto L70;
        r12.b.setAlpha(0.3f);
        r12.a.setAlpha(0.3f);
        r12.c.setAlpha(0.3f);
        r12.d.setAlpha(0.3f);
    L87:
        InviteMemberParams r19 = this.h;
        if (r19.p == true) goto L102;
        if (r19.r == true) goto L92;
    L100:
        r3 = false;
        goto L102
    L92:
        if (r13.getOwnerType() != 0) goto L94;
    L97:
        boolean r20 = true;
    L98:
        if (r20 == false) goto L100;
    L94:
        if (r13.getOwnerType() == 1) goto L97;
        r20 = false;
    L102:
        if (r13.isExternal() == false) goto L111;
        InviteMemberParams r21 = this.h;
        if (r21.p == true) goto L111;
        if (r21.v == false) goto L111;
        if (r21.o == false) goto L111;
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new i(this, r13, r12));
        return;
    L111:
        if (r13.isExternal() == false) goto L119;
        if (r3 == true) goto L119;
        InviteMemberParams r22 = this.h;
        if (r22.q == false) goto L116;
    L117:
        ((RecyclerView.ViewHolder) r12).itemView.setAlpha(0.3f);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new j(this, r13, r12));
        goto L119
    L116:
        if (r22.s == true) goto L117;
    L119:
        if (r13.getOwnerType() != 29) goto L129;
        InviteMemberParams r23 = this.h;
        if (r23.o == true) goto L123;
    L126:
        ((RecyclerView.ViewHolder) r12).itemView.setAlpha(0.3f);
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new k(this, r13, r12));
        return;
    L123:
        if (r23.p == false) goto L126;
        if (r23.q == false) goto L126;
        return;
    L129:
        return;
    L70:
        ((RecyclerView.ViewHolder) r12).itemView.setEnabled(r18);
        SpaceTagTitleView r24 = r12.b;
        if (r18 == false) goto L73;
        float r25 = 1.0f;
    L74:
        r24.setAlpha(r25);
        UDAvatar r26 = r12.a;
        if (r18 == false) goto L77;
        float r27 = 1.0f;
    L78:
        r26.setAlpha(r27);
        TextView r28 = r12.c;
        if (r18 == false) goto L81;
        float r29 = 1.0f;
    L82:
        r28.setAlpha(r29);
        UDCheckBox r30 = r12.d;
        if (r18 == true) goto L86;
        r1 = 0.3f;
    L86:
        r30.setAlpha(r1);
        goto L87
    L81:
        r29 = 0.3f;
        goto L82
    L77:
        r27 = 0.3f;
        goto L78
    L73:
        r25 = 0.3f;
        goto L74
    L57:
        if (r13.getId() != null) goto L59;
    L61:
        boolean r31 = false;
    L62:
        if (r31 == true) goto L66;
        if (E2(r13) == true) goto L66;
        r18 = true;
        goto L68
    L59:
        if (TextUtils.equals(r13.getId(), this.h.c) == false) goto L61;
        r31 = true;
        goto L62
    L52:
        if (TextUtils.equals(r13.getId(), this.c.uid) == false) goto L54;
        r17 = true;
        goto L55
    L31:
        if (this.c != null) goto L33;
    L35:
        boolean r32 = false;
    L36:
        if (r32 == true) goto L48;
        if (r13.getId() != null) goto L40;
    L42:
        boolean r33 = false;
    L43:
        if (r33 == true) goto L48;
        if (E2(r13) == true) goto L48;
        r16 = false;
        goto L49
    L40:
        if (TextUtils.equals(r13.getId(), this.h.c) == false) goto L42;
        r33 = true;
        goto L43
    L33:
        if (TextUtils.equals(r13.getId(), this.c.uid) == false) goto L35;
        r32 = true;
        goto L36
    L16:
        if (r13.getOwnerType() == 29) goto L23;
        TextView r34 = r12.c;
        if (TextUtils.isEmpty(r13.getDisplayLabel()) == true) goto L22;
        r4 = 0;
    L22:
        r34.setVisibility(r4);
        r12.c.setText(r13.getDisplayLabel());
        goto L28
    L8:
        if (r13.getUserCount() <= 0) goto L12;
        if (r13.getUserCountVisible() == false) goto L12;
        r12.b.setUnConstraintTitle(" (" + r13.getUserCount() + ")");
        goto L13
    }

    public static void A2(SearchUserResultAdapter r22, SearchUserViewHolder r23, UserInfo r24) {
        r22.getClass();
        tt5.a.h("SearchUserResultAdapter", "showAdjustExternalPanel()...");
        r22.m = r23;
        r22.n = r24;
        DocPermSetInfo r3 = r22.i.getDocPermSetInfo();
        if (r3 != null) goto L5;
        tt5.a.h("SearchUserResultAdapter", "showAdjustExternalPanel()...docPermSetInfo is null.");
        return;
    L5:
        DocPermSetInfo r2 = r22.i.getDocPermSetInfo();
        if (r2 == null) goto L17;
        IDocPublicPermission r4 = r2.f.b;
        if (r4.isPartnerTenant(r24.getTenantId()) == true) goto L10;
    L14:
        boolean r5 = false;
    L15:
        if (r5 == false) goto L17;
        SceneType r6 = SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER;
    L18:
        SceneType r11 = r6;
        if (r22.h.i == false) goto L21;
        int r7 = 2;
    L22:
        Context r8 = r22.a;
        InviteMemberParams r9 = r22.h;
        String r10 = r9.a;
        int r12 = r9.getType();
        boolean r13 = r22.h.i;
        int r14 = r3.f.a.getShareExternal();
        int r15 = r3.f.a.getSharePartnerTenant();
        HashMap r16 = new HashMap();
        r16.put("file_id", du5.b.g(r3.c));
        r16.put("file_type", sbb.e.f(r3.getType()));
        r16.put("app_form", "none");
        r16.put("sub_file_type", r3.e.getSubType());
        r16.put("module", "");
        r16.put("user_permission", r3.f.a.getReportJson());
        r16.put("file_permission", r3.f.b.getReportJson());
        if (r3.b() == false) goto L25;
        String r17 = "true";
    L26:
        r16.put("is_owner", r17);
        InviteMemberParams r18 = r22.h;
        String r19 = r18.a;
        int r20 = r18.getType();
        boolean r1 = r22.h.i;
        String r21 = r24.getId();
        int r110 = r24.getOwnerType();
        int r25 = oh5.d.a;
        Intrinsics.checkNotNullParameter(r19, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r21, "ownerId");
        Gson r26 = new Gson();     // Catch: Exception -> L31
        int r27 = r15;
        String r0 = r26.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to(ResourceData.KEY_TOKEN, r19), TuplesKt.to(ResourceData.KEY_TYPE, Integer.valueOf(r20)), TuplesKt.to("isWiki", Boolean.valueOf(r1)), TuplesKt.to("owners", new Gson().toJson(CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("owner_id", r21), TuplesKt.to("owner_type", Integer.valueOf(r110)), TuplesKt.to("permission", 1)})))), TuplesKt.to("notify_lark_v3", Boolean.TRUE), TuplesKt.to("lark_im_text", ""), TuplesKt.to("perm_type", Integer.valueOf(r7))}));     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L35
        String r111 = r0;
    L33:
        r22.j = new th5.b(r8, r10, r12, r13, r11, null, r14, r27, r16, 2, r111);
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).Ee(r22.j);
        return;
    L32:
        Log.e("CreateInstancePuller", "createPermissionUpdateInfo failed");
        r111 = "";
    L31:
        r27 = r15;
        goto L32
    L25:
        r17 = "false";
        goto L26
    L21:
        r7 = 0;
        goto L22
    L10:
        if (r4.adminPartnerTenantCross() == false) goto L12;
    L13:
        r5 = true;
        goto L15
    L12:
        if (r4.adminCanCross() == false) goto L14;
    L17:
        r6 = SceneType.INVITE_EXTERNAL_MEMBER;
        goto L18
    }

    public final void G2(SearchUserViewHolder r2, UserInfo r3, boolean r4) {
        if (r4 == true) goto L4;
    L8:
        r2.d.setChecked(r4);
        if (r4 == false) goto L11;
        ((ArrayList) this.e).add(r3);
    L12:
        a r0 = this.g;
        if (r0 == null) goto L18;
        r0.a(r2, r3, r4);
        return;
    L18:
        return;
    L11:
        ((ArrayList) this.e).remove(r3);
        goto L12
    L4:
        if (r3.isBlock() == false) goto L8;
        a r5 = this.g;
        if (r5 == null) goto L16;
        r5.P(r3);
        return;
    }

    public SearchUserResultAdapter(Context r2, Locale r3, AccountService.Account r4, InviteMemberParams r5, InviteMemberViewModel r6) {
        super(2131564518);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.h = r5;
        this.i = r6;
        C2();
        D2(null);
    }

    public static void y2(SearchUserResultAdapter r2, SearchUserViewHolder r3, UserInfo r4, EscapeRuleBean r5, EscapeApprovalInfo r6) {
        r2.getClass();
        tt5.a.h("SearchUserResultAdapter", "handleEscapeRuleAndInstanceList, id: " + r4.getId());
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        if (r5.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L9;
    L18:
        r2.B2(r3, r4);
        return;
    L9:
        if (r5.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L18;
        l r7 = new l(r2);
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval");
        Context r8 = r2.a;
        if (r8 == null) goto L13;
        Activity r9 = ContextsKt.findActivity(r8);
    L15:
        if ((r9 instanceof FragmentActivity) == true) goto L17;
        tt5.a.d("SearchUserResultAdapter", "mContext is not instanceof FragmentActivity!");
        return;
    L17:
        ((com.bytedance.ee.bear.middleground.permission.escape.g) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.escape.g.class)).a((FragmentActivity) r9, r5, r6, r7);
        return;
    L13:
        r9 = null;
    L19:
        tt5.a.d("SearchUserResultAdapter", "escapeRuleBean is null or escapeApprovalInfo is null!");
    }
}
