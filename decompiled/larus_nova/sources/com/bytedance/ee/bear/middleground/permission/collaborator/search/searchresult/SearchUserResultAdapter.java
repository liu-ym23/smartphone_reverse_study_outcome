package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
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
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
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

/* JADX INFO: loaded from: classes18.dex */
public class SearchUserResultAdapter extends BaseQuickAdapter<UserInfo, SearchUserViewHolder> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f233512q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f233514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccountService$Account f233515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<UserInfo> f233516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<UserInfo> f233517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Member> f233518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f233519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final InviteMemberParams f233520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InviteMemberViewModel f233521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public th5.b f233522j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<SecretLevel> f233523k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f233524l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SearchUserViewHolder f233525m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public UserInfo f233526n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public EscapeRuleBean f233527o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public EscapeApprovalInfo f233528p;

    public static class SearchUserViewHolder extends BaseViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final UDAvatar f233529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SpaceTagTitleView f233530b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f233531c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UDCheckBox f233532d;

        public SearchUserViewHolder(View r100) {
            super(r100);
            this.f233529a = (UDAvatar) r100.findViewById(R.id.share_item_icon);
            this.f233530b = (SpaceTagTitleView) r100.findViewById(R.id.share_item_name);
            this.f233531c = (TextView) r100.findViewById(R.id.share_item_subtitle);
            this.f233532d = (UDCheckBox) r100.findViewById(R.id.share_checkbox);
        }
    }

    public interface a {
        void P(UserInfo r100);

        void a(SearchUserViewHolder r100, UserInfo r101, boolean r102);
    }

    public final void C2() {
        tt5.a.h("SearchUserResultAdapter", "fetchVisibleSecret()...");
        Disposable r100 = this.f233524l;
        if (r100 != null) goto L5;
    L7:
        int r101 = com.bytedance.ee.bear.middleground.permission.secret.p.f234126a;
        InviteMemberParams r102 = this.f233520h;
        this.f233524l = com.bytedance.ee.bear.middleground.permission.secret.p.a(r102.f233166a, r102.getType()).subscribe(new e(this), new f());
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        this.f233524l.dispose();
        goto L7
    }

    public final boolean F2() {
        Iterator r100 = ((ArrayList) this.f233517e).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((UserInfo) r100.next()).getOwnerType() != 29) goto L4;
        r101 = r101 + 1;
        goto L4
    L9:
        if (r101 < 10) goto L17;
        return true;
    L17:
        return false;
    }

    public final void D2(final h r110) {
        tt5.a.h("SearchUserResultAdapter", "getEscapeRuleAndInstanceList");
        Context r100 = this.f233513a;
        Toast.showLoading(r100, r100.getString(R.string.LarkCCM_Common_Loading_Toast));
        InviteMemberParams r101 = this.f233520h;
        String r102 = r101.f233166a;
        int r103 = r101.getType();
        InviteMemberParams r104 = this.f233520h;
        String r105 = r104.f233166a;
        int r106 = r104.getType();
        if (this.f233520h.f233174i == false) goto L5;
        int r107 = 2;
    L6:
        String r108 = li5.m.a(r105, r106, 1, r107);
        int r109 = oh5.b.f523308a;
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter("external_access", "escapeSetting");
        Intrinsics.checkNotNullParameter(r108, "permReqParam");
        Flowable<EscapeRuleResult> r111 = oh5.f.a(r102, r103);
        int r112 = oh5.h.f523310a;
        Intrinsics.checkNotNullParameter(r102, "token");
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        Flowable.zip(r111, ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new oh5.g()).a(new NetService.f(String.format(Locale.US, "/space/api/sec_label/escape_rule/approval/instance/list?token=%s&type=%d", Arrays.copyOf(new Object[]{r102, Integer.valueOf(r103)}, 2)))), new oh5.a(r102, r103, r108)).subscribe(new c(this, r110), new d());
        return;
    L5:
        r107 = 0;
        goto L6
    }

    public final boolean E2(UserInfo r100) {
        if (this.f233520h.f233175j == false) goto L6;
        return false;
    L6:
        if (this.f233515c == null) goto L11;
        if (TextUtils.equals(r100.getId(), this.f233515c.uid) == false) goto L11;
        return true;
    L11:
        if (((ArrayList) this.f233516d).contains(r100) == true) goto L13;
    L15:
        Iterator r101 = ((ArrayList) this.f233518f).iterator();
    L17:
        if (r101.hasNext() == false) goto L25;
        Member r102 = (Member) r101.next();
        if (TextUtils.equals(r100.getId(), r102.getMemberId()) == false) goto L17;
        if (r100.getOwnerType() != r102.getMemberType()) goto L17;
        if (r100.getOwnerType() == 29) goto L17;
        return true;
    L25:
        return false;
    L13:
        if (r100.getOwnerType() == 29) goto L15;
        return true;
    }

    public final void H2(UserInfo r100) {
        ((ArrayList) this.f233517e).remove(r100);
        if (this.mData.contains(r100) == false) goto L6;
        notifyDataSetChanged();
        return;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final BaseViewHolder createBaseViewHolder(View r100) {
        return new SearchUserViewHolder(r100);
    }

    public static boolean z2(SearchUserResultAdapter r100, UserInfo r101) {
        if (r100.f233520h.getType() != sbb.e.f541295f.f541317b) goto L5;
        return false;
    L5:
        if (r100.f233520h.getType() == sbb.e.f541306q.f541317b) goto L74;
        InviteMemberParams r102 = r100.f233520h;
        if (r102.f233174i == true) goto L13;
        if (r102.f233177l == true) goto L13;
        return false;
    L13:
        if (r102.f233180o == false) goto L76;
        InviteMemberViewModel r103 = r100.f233521i;
        if (r103 != null) goto L18;
    L68:
        tt5.a.h("SearchUserResultAdapter", "isEnableAdjustExternalShare()...viewModel or docPermSetInfo is null.");
        return false;
    L18:
        if (r103.getDocPermSetInfo() == null) goto L68;
        DocPermSetInfo r104 = r100.f233521i.getDocPermSetInfo();
        DocPermSetInfo r105 = r100.f233521i.getDocPermSetInfo();
        if (r105 == null) goto L32;
        IDocPublicPermission r106 = r105.f234432f.f234420b;
        if (r106.isPartnerTenant(r101.getTenantId()) == true) goto L25;
    L29:
        boolean r107 = false;
    L30:
        if (r107 == false) goto L32;
        SceneType r108 = SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER;
    L34:
        if (r108 != SceneType.INVITE_EXTERNAL_MEMBER) goto L38;
        if (r104.f234432f.f234419a.getShareExternal() != BlockReason.BLOCK_BY_SECRET.getValue()) goto L38;
    L41:
        List<SecretLevel> r109 = r100.f233523k;
        if (r109 != null) goto L45;
        r100.C2();
        return false;
    L45:
        if (hu5.a.d(b0.c(r109, r108, null)) == true) goto L77;
    L47:
        IDocPublicPermission r110 = r104.f234432f.f234420b;
        if (r110.isPartnerTenant(r101.getTenantId()) == true) goto L50;
    L54:
        boolean r111 = false;
    L55:
        if (r111 == false) goto L62;
        if (r104.f234432f.f234419a.isSharePartnerTenantDeniedBySecret() == false) goto L59;
    L67:
        return true;
    L59:
        if (r104.f234432f.f234419a.isSharePartnerTenantDeniedByPublicPerm() == true) goto L67;
    L62:
        if (r104.f234432f.f234419a.isShareExternalDeniedBySecret() == true) goto L67;
        if (r104.f234432f.f234419a.isShareExternalDeniedByPublicPerm() == true) goto L67;
        if (r104.f234432f.f234419a.isShareExternalSelectPartnerTenantShare() == true) goto L67;
        return false;
    L50:
        if (r110.adminPartnerTenantCross() == false) goto L52;
    L53:
        r111 = true;
        goto L55
    L52:
        if (r110.adminCanCross() == false) goto L54;
    L77:
        return false;
    L38:
        if (r108 != SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER) goto L47;
        if (r104.f234432f.f234419a.getSharePartnerTenant() != BlockReason.BLOCK_BY_SECRET.getValue()) goto L47;
    L25:
        if (r106.adminPartnerTenantCross() == false) goto L27;
    L28:
        r107 = true;
        goto L30
    L27:
        if (r106.adminCanCross() == false) goto L29;
    L32:
        r108 = SceneType.INVITE_EXTERNAL_MEMBER;
        goto L34
    L76:
        return false;
    L74:
        return false;
    }

    public final void B2(SearchUserViewHolder r100, UserInfo r101) {
        tt5.a.h("SearchUserResultAdapter", "doSelectUser, uid: " + r101.getId());
        boolean r102 = ((ArrayList) this.f233517e).contains(r101) ^ true;
        if (r102 == true) goto L5;
    L10:
        G2(r100, r101, r102);
        return;
    L5:
        if (r101.getOwnerType() != 29) goto L10;
        if (F2() == false) goto L10;
        Context r103 = this.f233513a;
        Toast.showFailureText(r103, xo5.a.c(r103, R.string.LarkCCM_Docs_InviteEmail_LimitPerInvite_Toast, "number", String.valueOf(10)));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, UserInfo r111) {
        SearchUserViewHolder r112 = (SearchUserViewHolder) r110;
        UserInfo r113 = r111;
        float r100 = 1.0f;
        r112.itemView.setAlpha(1.0f);
        r112.itemView.setOnClickListener(null);
        pg5.a.b(r112.f233529a, r113);
        String r101 = r113.getDisplayName(this.f233514b);
        if (ou5.a.e() == false) goto L5;
        r101 = ou5.c.e(this.f233514b.getLanguage(), r113.getI18nNames(), r101);
    L5:
        r112.f233530b.setTitle(r101);
        if (r113.getOwnerType() == 2) goto L8;
    L12:
        r112.f233530b.setUnConstraintTitle("");
    L13:
        SpaceTagTitleView r102 = r112.f233530b;
        boolean r103 = true;
        String r104 = r113.getOrganizationTagValue();
        boolean r105 = r113.isExternal();
        int r106 = ui5.c.f550208a;
        boolean r107 = ui5.c.a(this.f233515c);
        int r108 = SpaceTagType.f240339e;
        r102.setLabels(new SpaceTagType[]{SpaceTagType.Companion.f(r104, r105, r107)});
        int r109 = 8;
        if (r113.getOwnerType() != 2) goto L16;
    L23:
        TextView r114 = r112.f233531c;
        if (TextUtils.isEmpty(r113.getLabel()) == true) goto L27;
        r109 = 0;
    L27:
        r114.setVisibility(r109);
        r112.f233531c.setText(r113.getLabel());
    L28:
        UDCheckBox r115 = r112.f233532d;
        if (((ArrayList) this.f233517e).contains(r113) == false) goto L31;
    L48:
        boolean r116 = true;
    L49:
        r115.setChecked(r116);
        r112.itemView.setOnClickListener(new g(this, r113, r112));
        if (this.f233515c != null) goto L52;
    L54:
        boolean r117 = false;
    L55:
        if (r117 == false) goto L57;
    L66:
        boolean r118 = false;
    L68:
        if (r113.isBlock() == false) goto L70;
        r112.f233530b.setAlpha(0.3f);
        r112.f233529a.setAlpha(0.3f);
        r112.f233531c.setAlpha(0.3f);
        r112.f233532d.setAlpha(0.3f);
    L87:
        InviteMemberParams r119 = this.f233520h;
        if (r119.f233181p == true) goto L102;
        if (r119.f233183r == true) goto L92;
    L100:
        r103 = false;
        goto L102
    L92:
        if (r113.getOwnerType() != 0) goto L94;
    L97:
        boolean r120 = true;
    L98:
        if (r120 == false) goto L100;
    L94:
        if (r113.getOwnerType() == 1) goto L97;
        r120 = false;
    L102:
        if (r113.isExternal() == false) goto L111;
        InviteMemberParams r121 = this.f233520h;
        if (r121.f233181p == true) goto L111;
        if (r121.f233187v == false) goto L111;
        if (r121.f233180o == false) goto L111;
        r112.itemView.setOnClickListener(new i(this, r113, r112));
        return;
    L111:
        if (r113.isExternal() == false) goto L119;
        if (r103 == true) goto L119;
        InviteMemberParams r122 = this.f233520h;
        if (r122.f233182q == false) goto L116;
    L117:
        r112.itemView.setAlpha(0.3f);
        r112.itemView.setOnClickListener(new j(this, r113, r112));
        goto L119
    L116:
        if (r122.f233184s == true) goto L117;
    L119:
        if (r113.getOwnerType() != 29) goto L129;
        InviteMemberParams r123 = this.f233520h;
        if (r123.f233180o == true) goto L123;
    L126:
        r112.itemView.setAlpha(0.3f);
        r112.itemView.setOnClickListener(new k(this, r113, r112));
        return;
    L123:
        if (r123.f233181p == false) goto L126;
        if (r123.f233182q == false) goto L126;
        return;
    L129:
        return;
    L70:
        r112.itemView.setEnabled(r118);
        SpaceTagTitleView r124 = r112.f233530b;
        if (r118 == false) goto L73;
        float r125 = 1.0f;
    L74:
        r124.setAlpha(r125);
        UDAvatar r126 = r112.f233529a;
        if (r118 == false) goto L77;
        float r127 = 1.0f;
    L78:
        r126.setAlpha(r127);
        TextView r128 = r112.f233531c;
        if (r118 == false) goto L81;
        float r129 = 1.0f;
    L82:
        r128.setAlpha(r129);
        UDCheckBox r130 = r112.f233532d;
        if (r118 == true) goto L86;
        r100 = 0.3f;
    L86:
        r130.setAlpha(r100);
        goto L87
    L81:
        r129 = 0.3f;
        goto L82
    L77:
        r127 = 0.3f;
        goto L78
    L73:
        r125 = 0.3f;
        goto L74
    L57:
        if (r113.getId() != null) goto L59;
    L61:
        boolean r131 = false;
    L62:
        if (r131 == true) goto L66;
        if (E2(r113) == true) goto L66;
        r118 = true;
        goto L68
    L59:
        if (TextUtils.equals(r113.getId(), this.f233520h.f233168c) == false) goto L61;
        r131 = true;
        goto L62
    L52:
        if (TextUtils.equals(r113.getId(), this.f233515c.uid) == false) goto L54;
        r117 = true;
        goto L55
    L31:
        if (this.f233515c != null) goto L33;
    L35:
        boolean r132 = false;
    L36:
        if (r132 == true) goto L48;
        if (r113.getId() != null) goto L40;
    L42:
        boolean r133 = false;
    L43:
        if (r133 == true) goto L48;
        if (E2(r113) == true) goto L48;
        r116 = false;
        goto L49
    L40:
        if (TextUtils.equals(r113.getId(), this.f233520h.f233168c) == false) goto L42;
        r133 = true;
        goto L43
    L33:
        if (TextUtils.equals(r113.getId(), this.f233515c.uid) == false) goto L35;
        r132 = true;
        goto L36
    L16:
        if (r113.getOwnerType() == 29) goto L23;
        TextView r134 = r112.f233531c;
        if (TextUtils.isEmpty(r113.getDisplayLabel()) == true) goto L22;
        r109 = 0;
    L22:
        r134.setVisibility(r109);
        r112.f233531c.setText(r113.getDisplayLabel());
        goto L28
    L8:
        if (r113.getUserCount() <= 0) goto L12;
        if (r113.getUserCountVisible() == false) goto L12;
        r112.f233530b.setUnConstraintTitle(" (" + r113.getUserCount() + ")");
        goto L13
    }

    public static void A2(SearchUserResultAdapter r210, SearchUserViewHolder r211, UserInfo r212) {
        r210.getClass();
        tt5.a.h("SearchUserResultAdapter", "showAdjustExternalPanel()...");
        r210.f233525m = r211;
        r210.f233526n = r212;
        DocPermSetInfo r100 = r210.f233521i.getDocPermSetInfo();
        if (r100 != null) goto L5;
        tt5.a.h("SearchUserResultAdapter", "showAdjustExternalPanel()...docPermSetInfo is null.");
        return;
    L5:
        DocPermSetInfo r101 = r210.f233521i.getDocPermSetInfo();
        if (r101 == null) goto L17;
        IDocPublicPermission r102 = r101.f234432f.f234420b;
        if (r102.isPartnerTenant(r212.getTenantId()) == true) goto L10;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        SceneType r104 = SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER;
    L18:
        SceneType r110 = r104;
        if (r210.f233520h.f233174i == false) goto L21;
        int r105 = 2;
    L22:
        Context r106 = r210.f233513a;
        InviteMemberParams r107 = r210.f233520h;
        String r108 = r107.f233166a;
        int r111 = r107.getType();
        boolean r112 = r210.f233520h.f233174i;
        int r113 = r100.f234432f.f234419a.getShareExternal();
        int r114 = r100.f234432f.f234419a.getSharePartnerTenant();
        HashMap r109 = new HashMap();
        r109.put("file_id", du5.b.g(r100.f234429c));
        r109.put("file_type", sbb.e.f(r100.getType()));
        r109.put("app_form", "none");
        r109.put("sub_file_type", r100.f234431e.getSubType());
        r109.put(EventConstant.Key.MODULE, "");
        r109.put("user_permission", r100.f234432f.f234419a.getReportJson());
        r109.put("file_permission", r100.f234432f.f234420b.getReportJson());
        if (r100.b() == false) goto L25;
        String r115 = "true";
    L26:
        r109.put("is_owner", r115);
        InviteMemberParams r116 = r210.f233520h;
        String r117 = r116.f233166a;
        int r118 = r116.getType();
        boolean r119 = r210.f233520h.f233174i;
        String r120 = r212.getId();
        int r121 = r212.getOwnerType();
        int r213 = oh5.d.f523309a;
        Intrinsics.checkNotNullParameter(r117, "token");
        Intrinsics.checkNotNullParameter(r120, "ownerId");
        Gson r122 = new Gson();     // Catch: Exception -> L31
        int r214 = r114;
        String r123 = r122.toJson(MapsKt.mapOf(new Pair[]{TuplesKt.to("token", r117), TuplesKt.to("type", Integer.valueOf(r118)), TuplesKt.to("isWiki", Boolean.valueOf(r119)), TuplesKt.to("owners", new Gson().toJson(CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("owner_id", r120), TuplesKt.to("owner_type", Integer.valueOf(r121)), TuplesKt.to("permission", 1)})))), TuplesKt.to("notify_lark_v3", Boolean.TRUE), TuplesKt.to("lark_im_text", ""), TuplesKt.to(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, Integer.valueOf(r105))}));     // Catch: Exception -> L35
        Intrinsics.checkNotNull(r123);     // Catch: Exception -> L35
        String r124 = r123;
    L33:
        r210.f233522j = new th5.b(r106, r108, r111, r112, r110, null, r113, r214, r109, 2, r124);
        ((cj5.c) org.koin.java.a.a(cj5.c.class)).Ee(r210.f233522j);
        return;
    L32:
        Log.e("CreateInstancePuller", "createPermissionUpdateInfo failed");
        r124 = "";
    L31:
        r214 = r114;
        goto L32
    L25:
        r115 = "false";
        goto L26
    L21:
        r105 = 0;
        goto L22
    L10:
        if (r102.adminPartnerTenantCross() == false) goto L12;
    L13:
        r103 = true;
        goto L15
    L12:
        if (r102.adminCanCross() == false) goto L14;
    L17:
        r104 = SceneType.INVITE_EXTERNAL_MEMBER;
        goto L18
    }

    public final void G2(SearchUserViewHolder r100, UserInfo r101, boolean r102) {
        if (r102 == true) goto L4;
    L8:
        r100.f233532d.setChecked(r102);
        if (r102 == false) goto L11;
        ((ArrayList) this.f233517e).add(r101);
    L12:
        a r103 = this.f233519g;
        if (r103 == null) goto L18;
        r103.a(r100, r101, r102);
        return;
    L18:
        return;
    L11:
        ((ArrayList) this.f233517e).remove(r101);
        goto L12
    L4:
        if (r101.isBlock() == false) goto L8;
        a r104 = this.f233519g;
        if (r104 == null) goto L16;
        r104.P(r101);
        return;
    }

    public SearchUserResultAdapter(Context r100, Locale r101, AccountService$Account r102, InviteMemberParams r103, InviteMemberViewModel r104) {
        super(R.layout.share_search_user_result_item);
        this.f233516d = new ArrayList();
        this.f233517e = new ArrayList();
        this.f233518f = new ArrayList();
        this.f233513a = r100;
        this.f233514b = r101;
        this.f233515c = r102;
        this.f233520h = r103;
        this.f233521i = r104;
        C2();
        D2(null);
    }

    public static void y2(SearchUserResultAdapter r100, SearchUserViewHolder r101, UserInfo r102, EscapeRuleBean r103, EscapeApprovalInfo r104) {
        r100.getClass();
        tt5.a.h("SearchUserResultAdapter", "handleEscapeRuleAndInstanceList, id: " + r102.getId());
        if (r103 == null) goto L19;
        if (r104 == null) goto L19;
        if (r103.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L9;
    L18:
        r100.B2(r101, r102);
        return;
    L9:
        if (r103.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L18;
        l r105 = new l(r100);
        tt5.a.h("SearchUserResultAdapter", "checkEscapeAndApproval");
        Context r106 = r100.f233513a;
        if (r106 == null) goto L13;
        Activity r107 = ContextsKt.findActivity(r106);
    L15:
        if ((r107 instanceof FragmentActivity) == true) goto L17;
        tt5.a.d("SearchUserResultAdapter", "mContext is not instanceof FragmentActivity!");
        return;
    L17:
        ((com.bytedance.ee.bear.middleground.permission.escape.g) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.escape.g.class)).a((FragmentActivity) r107, r103, r104, r105);
        return;
    L13:
        r107 = null;
    L19:
        tt5.a.d("SearchUserResultAdapter", "escapeRuleBean is null or escapeApprovalInfo is null!");
    }
}
