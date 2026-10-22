package com.bytedance.ee.bear.middleground.permission.escape;

import android.app.Application;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.adjustment.AdjustmentRequestFragment;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.framework.utils.ICUUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class EscapeApiImpl implements g {

    public static final class a {
    }

    public static final class b implements g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g.b f233845a;

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onCancel() {
            g.b r100 = this.f233845a;
            if (r100 == null) goto L6;
            r100.onCancel();
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onConfirm() {
            g.b r100 = this.f233845a;
            if (r100 == null) goto L6;
            r100.onConfirm();
            return;
        }

        public b(g.b r100) {
            this.f233845a = r100;
        }
    }

    static {
    }

    public EscapeApiImpl() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void d(FragmentActivity r100, EscapeApprovalInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showApprovalList, escapeApprovalInfo: " + r101);
        int r102 = EscapeApprovalListFragment.f233847j;
        EscapeApprovalListFragment.b.a(r100, r101);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void c(FragmentActivity r210, EscapeApprovalInfo r211, g.b r212) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showRepeatedApprovalDialog, escapeApprovalInfo: " + r211);
        int r100 = o.f233869a;
        b r101 = new b(r212);
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "escapeApprovalInfo");
        if (r211.getApprovalList().getMyInstance() == null) goto L5;
        BearUDDialogBuilder r102 = new BearUDDialogBuilder(r210);
        r102.f240192a.title(R.string.LarkCCM_InviteExternalCollab_ResubmitRequest_Title);
        r102.f240192a.message(R.string.LarkCCM_InviteExternalCollab_ResubmitRequest_Desc);
        r102.b(R.id.ud_dialog_btn_secondary, R.string.LarkCCM_Common_Cancel_Button, R.color.text_title, new l(r101));
        r102.b(R.id.ud_dialog_btn_primary, R.string.LarkCCM_InviteExternalCollab_ResubmitRequest_Submit_Button, R.color.primary_fill_default, new m(r101));
        r102.f240192a.style(R.style.ActionSheetDialogStyle);
        r102.g(new n(r101));
        r102.h();
        return;
    L5:
        BearUDDialogBuilder r103 = new BearUDDialogBuilder(r210);
        r103.f240192a.title(R.string.LarkCCM_InviteExternalCollab_ConfirmRequest_Title);
        SpannableStringBuilder r110 = new SpannableStringBuilder();
        String r111 = UIHelper.getQuantityString(R.plurals.LarkCCM_InviteExternalCollab_ConfirmRequest_NumPpl_Button, r211.getApprovalList().getInstances().size());
        int r112 = f.f233860a;
        if (r211.getType() != sbb.e.f541311v.f541317b) goto L8;
        int r113 = R.plurals.LarkCCM_ChatShare_ExternalSharingRequestPending_Desc;
    L9:
        CharSequence r114 = ICUUtils.icuFormat(UIHelper.getQuantityString(r113, 1), "members", r111);
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNull(r111);
        int r115 = StringsKt.indexOf$default(r114, r111, 0, false, 6, null);
        int r116 = r111.length() + r115;
        if (r115 < 0) goto L14;
        if (r116 < r115) goto L14;
        r110.append(r114);
        r110.setSpan(new h(r210, r211), r115, r116, 34);
    L15:
        r103.f(r110);
        r103.b(R.id.ud_dialog_btn_secondary, R.string.LarkCCM_Common_Cancel_Button, R.color.text_title, new i(r101));
        r103.b(R.id.ud_dialog_btn_primary, R.string.LarkCCM_InviteExternalCollab_ResubmitRequest_Submit_Button, R.color.primary_fill_default, new j(r101));
        r103.f240192a.style(R.style.ActionSheetDialogStyle);
        r103.g(new k(r101));
        TextView r104 = (TextView) r103.h().findViewById(R.id.ud_dialog_content_message_tv);
        if (r104 == null) goto L20;
        r104.setMovementMethod(new LinkMovementMethod());
        return;
    L20:
        return;
    L14:
        tt5.a.d("ReSubmitApplyDialog", "message parse index error " + r115 + ' ' + r116 + ' ' + r111);
        r110 = r114;
        goto L15
    L8:
        r113 = R.plurals.LarkCCM_InviteExternalCollab_ConfirmRequest_Desc;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void a(FragmentActivity r100, EscapeRuleBean r101, EscapeApprovalInfo r110, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r110, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "checkEscapeAndApproval, escapeRuleBean: " + r101 + ", escapeApprovalInfo: " + r110);
        if (r101.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L5;
        oh5.d.a(r101.getToken(), r101.getType(), r101.getEscapeSetting(), "", r101.getPermReqType(), r101.getPermReqParam()).subscribe(new com.bytedance.ee.bear.middleground.permission.escape.a(r100, r111), new com.bytedance.ee.bear.middleground.permission.escape.b(r100, r111));
        return;
    L5:
        Toast.cancelLoading();
        b(r100, r101, r110, r111);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void b(final FragmentActivity r210, final EscapeRuleBean r211, final EscapeApprovalInfo r212, g.a r213) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r212, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showEscapeApproval, escapeRuleBean: " + r211 + ", escapeApprovalInfo: " + r212);
        if (CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r211.getPermReqType())) == true) goto L6;
        tt5.a.d("AdjustmentApiImpl", "unknown permReqType: " + r211.getPermReqType());
        return;
    L6:
        String r110 = r211.getToken();
        int r111 = r211.getType();
        Application r100 = LarkContext.getApplication();
        int r112 = r211.getPermReqType();
        if (r112 == 1) goto L11;
        if (r112 == 2) goto L16;
        tt5.a.d("AdjustmentApiImpl", "buildTitle unknown permReqType: " + r211.getPermReqType());
    L15:
        int r113 = R.string.LarkCCM_ApplyExternalShare_Title;
    L17:
        String r114 = r100.getString(r113);
        Application r101 = LarkContext.getApplication();
        int r115 = r211.getPermReqType();
        int r116 = R.string.LarkCCM_ChatShare_InviteExternalCollaboratorsWithCc_Desc;
        if (r115 == 1) goto L33;
        if (r115 == 2) goto L22;
        tt5.a.d("AdjustmentApiImpl", "buildDescription unknown permReqType: " + r211.getPermReqType());
    L61:
        int r117 = R.string.LarkCCM_ApplyExternalShare_Approval_NoName_Desc;
    L62:
        String r118 = r101.getString(r117);
        String r119 = LarkContext.getApplication().getString(R.string.LarkCCM_ApplyExternalShare_Reason_Placeholder);
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L65;
        ArrayList<Reviewer> r102 = r211.getApprovalDef().getCcUsers();
    L66:
        ArrayList<Reviewer> r120 = r102;
        String r121 = LarkContext.getApplication().getString(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Submitting_Mob);
        Application r103 = LarkContext.getApplication();
        int r122 = r211.getPermReqType();
        if (r122 == 1) goto L78;
        if (r122 == 2) goto L71;
        tt5.a.d("AdjustmentApiImpl", "buildSuccessToast unknown permReqType: " + r211.getPermReqType());
    L79:
        int r104 = R.string.LarkCCM_ApplyExternalShare_CopyMngDone_Toast;
    L81:
        String r123 = r103.getString(r104);
        Application r105 = LarkContext.getApplication();
        int r106 = r211.getPermReqType();
        if (r106 == 1) goto L87;
        if (r106 == 2) goto L85;
        tt5.a.d("AdjustmentApiImpl", "buildFailedToast unknown permReqType: " + r211.getPermReqType());
    L88:
        int r107 = R.string.LarkCCM_ApplyExternalShare_SettingFail_Toast;
    L90:
        SecretLevelEscapeViewModel r108 = new SecretLevelEscapeViewModel(r110, r111, r114, r118, r119, r120, r121, r123, r105.getString(r107), r211.getEscapeSetting(), r211.getPermReqType(), r211.getPermReqParam(), r213, new EscapeApiImpl$showEscapeApproval$viewModel$1(r211, r212, this, r210));
        int r109 = AdjustmentRequestFragment.f232846o;
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r108, "viewModel");
        AdjustmentRequestFragment r124 = new AdjustmentRequestFragment(r108);
        FragmentTransaction r125 = r210.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r125, r124, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AdjustmentRequestFragment", 0) == true) goto L94;
        r125 = r125.add(r124, "AdjustmentRequestFragment");
    L94:
        r125.commitAllowingStateLoss();
        return;
    L85:
        r107 = R.string.Doc_Share_AddCollaboratorFailed;
        goto L90
    L87:
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L88;
        r107 = R.string.LarkCCM_ApplyExternalShare_RequestSubmitFail_Toast;
        goto L90
    L71:
        if (r211.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L74;
        r104 = R.string.Doc_Share_AddCollaboratorSuccessfully;
        goto L81
    L74:
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L76;
        r104 = R.string.LarkCCM_InviteExternalCollab_CopyMngDone_Toast;
        goto L81
    L76:
        r104 = R.string.LarkCCM_InviteExternalCollab_ApprovalDone_Toast;
        goto L81
    L78:
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L79;
        r104 = R.string.LarkCCM_ApplyExternalShare_ApprovalDone_Toast;
        goto L81
    L65:
        r102 = r211.getApprovalDef().getReviewers();
        goto L66
    L22:
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L30;
        int r126 = f.f233860a;
        int r127 = r211.getType();
        boolean r128 = !r211.getApprovalDef().getCcUsers().isEmpty();
        if (r127 == sbb.e.f541311v.f541317b) goto L43;
        if (r128 == false) goto L28;
        int r129 = R.string.LarkCCM_InviteExternalCollab_CopyMng_Desc;
    L42:
        r116 = r129;
        goto L43
    L28:
        r129 = R.string.LarkCCM_InviteExternalCollab_CopyMng_NoName_Desc;
    L43:
        r117 = r116;
        goto L62
    L30:
        if ((!r211.getApprovalDef().getReviewers().isEmpty()) == true) goto L46;
    L47:
        r117 = R.string.LarkCCM_InviteExternalCollab_Approval_NoName_Desc;
    L46:
        r117 = R.string.LarkCCM_InviteExternalCollab_Approval_Desc;
        goto L62
    L33:
        if (r211.getEscapeScene() != 1) goto L49;
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L45;
        int r130 = f.f233860a;
        int r131 = r211.getType();
        boolean r132 = !r211.getApprovalDef().getCcUsers().isEmpty();
        if (r131 == sbb.e.f541311v.f541317b) goto L43;
        if (r132 == false) goto L41;
        r129 = R.string.LarkCCM_InviteExternalCollab_CopyMng_Desc;
        goto L42
    L41:
        r129 = R.string.LarkCCM_InviteExternalCollab_CopyMng_NoName_Desc;
        goto L42
    L45:
        if ((!r211.getApprovalDef().getReviewers().isEmpty()) == false) goto L47;
    L49:
        if (r211.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L59;
        int r133 = f.f233860a;
        int r134 = r211.getType();
        boolean r135 = !r211.getApprovalDef().getCcUsers().isEmpty();
        if (r134 != sbb.e.f541311v.f541317b) goto L55;
        if (r135 == false) goto L54;
        r117 = R.string.LarkCCM_ChatShare_ApplyExternalSharingWithCc_Desc;
        goto L62
    L54:
        r117 = R.string.LarkCCM_ChatShare_ApplyExternalSharingWithRelevantCc_Desc;
        goto L62
    L55:
        if (r135 == false) goto L57;
        r117 = R.string.LarkCCM_ApplyExternalShare_CopyMng_Desc;
        goto L62
    L57:
        r117 = R.string.LarkCCM_ApplyExternalShare_CopyMng_NoName_Desc;
        goto L62
    L59:
        if ((!r211.getApprovalDef().getReviewers().isEmpty()) == false) goto L61;
        r117 = R.string.LarkCCM_ApplyExternalShare_Approval_Desc;
    L16:
        r113 = R.string.LarkCCM_InviteExternalCollab_Title;
        goto L17
    L11:
        if (r211.getEscapeScene() == 1) goto L16;
        if (r211.getEscapeScene() != 2) goto L15;
        goto L15
    }
}
