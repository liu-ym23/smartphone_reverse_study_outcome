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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class EscapeApiImpl implements g {

    public static final class a {
    }

    public static final class b implements g.b {
        public final /* synthetic */ g.b a;

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onCancel() {
            g.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onCancel();
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.escape.g.b
        public final void onConfirm() {
            g.b r0 = this.a;
            if (r0 == null) goto L6;
            r0.onConfirm();
            return;
        }

        public b(g.b r1) {
            this.a = r1;
        }
    }

    static {
    }

    public EscapeApiImpl() {
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void d(FragmentActivity r3, EscapeApprovalInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r4, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showApprovalList, escapeApprovalInfo: " + r4);
        int r0 = EscapeApprovalListFragment.j;
        EscapeApprovalListFragment.b.a(r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void c(FragmentActivity r21, EscapeApprovalInfo r22, g.b r23) {
        Intrinsics.checkNotNullParameter(r21, "activity");
        Intrinsics.checkNotNullParameter(r22, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showRepeatedApprovalDialog, escapeApprovalInfo: " + r22);
        int r4 = o.a;
        b r5 = new b(r23);
        Intrinsics.checkNotNullParameter(r21, "activity");
        Intrinsics.checkNotNullParameter(r22, "escapeApprovalInfo");
        if (r22.getApprovalList().getMyInstance() == null) goto L5;
        BearUDDialogBuilder r1 = new BearUDDialogBuilder(r21);
        r1.a.title(2131889557);
        r1.a.message(2131889555);
        r1.b(2131391778, 2131888904, 2131106622, new l(r5));
        r1.b(2131391777, 2131889556, 2131105548, new m(r5));
        r1.a.style(2131951622);
        r1.g(new n(r5));
        r1.h();
        return;
    L5:
        BearUDDialogBuilder r2 = new BearUDDialogBuilder(r21);
        r2.a.title(2131889551);
        SpannableStringBuilder r11 = new SpannableStringBuilder();
        String r12 = UIHelper.getQuantityString(2131755041, r22.getApprovalList().getInstances().size());
        int r13 = f.a;
        if (r22.getType() != sbb.e.v.b) goto L8;
        int r14 = 2131755028;
    L9:
        CharSequence r15 = ICUUtils.icuFormat(UIHelper.getQuantityString(r14, 1), "members", r12);
        Intrinsics.checkNotNull(r15);
        Intrinsics.checkNotNull(r12);
        int r16 = StringsKt.indexOf$default(r15, r12, 0, false, 6, null);
        int r17 = r12.length() + r16;
        if (r16 < 0) goto L14;
        if (r17 < r16) goto L14;
        r11.append(r15);
        r11.setSpan(new h(r21, r22), r16, r17, 34);
    L15:
        r2.f(r11);
        r2.b(2131391778, 2131888904, 2131106622, new i(r5));
        r2.b(2131391777, 2131889556, 2131105548, new j(r5));
        r2.a.style(2131951622);
        r2.g(new k(r5));
        TextView r0 = (TextView) r2.h().findViewById(2131391794);
        if (r0 == null) goto L20;
        r0.setMovementMethod(new LinkMovementMethod());
        return;
    L20:
        return;
    L14:
        tt5.a.d("ReSubmitApplyDialog", "message parse index error " + r16 + ' ' + r17 + ' ' + r12);
        r11 = r15;
        goto L15
    L8:
        r14 = 2131755040;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void a(FragmentActivity r8, EscapeRuleBean r9, EscapeApprovalInfo r10, com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult.l r11) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r10, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "checkEscapeAndApproval, escapeRuleBean: " + r9 + ", escapeApprovalInfo: " + r10);
        if (r9.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L5;
        oh5.d.a(r9.getToken(), r9.getType(), r9.getEscapeSetting(), "", r9.getPermReqType(), r9.getPermReqParam()).subscribe(new com.bytedance.ee.bear.middleground.permission.escape.a(r8, r11), new com.bytedance.ee.bear.middleground.permission.escape.b(r8, r11));
        return;
    L5:
        Toast.cancelLoading();
        b(r8, r9, r10, r11);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.escape.g
    public final void b(final FragmentActivity r26, final EscapeRuleBean r27, final EscapeApprovalInfo r28, g.a r29) {
        Intrinsics.checkNotNullParameter(r26, "activity");
        Intrinsics.checkNotNullParameter(r27, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r28, "escapeApprovalInfo");
        tt5.a.h("AdjustmentApiImpl", "showEscapeApproval, escapeRuleBean: " + r27 + ", escapeApprovalInfo: " + r28);
        if (CollectionsKt.listOf(new Integer[]{1, 2}).contains(Integer.valueOf(r27.getPermReqType())) == true) goto L6;
        tt5.a.d("AdjustmentApiImpl", "unknown permReqType: " + r27.getPermReqType());
        return;
    L6:
        String r11 = r27.getToken();
        int r12 = r27.getType();
        Application r8 = LarkContext.getApplication();
        int r10 = r27.getPermReqType();
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L16;
        tt5.a.d("AdjustmentApiImpl", "buildTitle unknown permReqType: " + r27.getPermReqType());
    L15:
        int r13 = 2131888734;
    L17:
        String r14 = r8.getString(r13);
        Application r9 = LarkContext.getApplication();
        int r15 = r27.getPermReqType();
        int r16 = 2131888873;
        if (r15 == 1) goto L33;
        if (r15 == 2) goto L22;
        tt5.a.d("AdjustmentApiImpl", "buildDescription unknown permReqType: " + r27.getPermReqType());
    L61:
        int r17 = 2131888727;
    L62:
        String r18 = r9.getString(r17);
        String r19 = LarkContext.getApplication().getString(2131888731);
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L65;
        ArrayList<Reviewer> r20 = r27.getApprovalDef().getCcUsers();
    L66:
        ArrayList<Reviewer> r110 = r20;
        String r111 = LarkContext.getApplication().getString(2131889910);
        Application r21 = LarkContext.getApplication();
        int r112 = r27.getPermReqType();
        if (r112 == 1) goto L78;
        if (r112 == 2) goto L71;
        tt5.a.d("AdjustmentApiImpl", "buildSuccessToast unknown permReqType: " + r27.getPermReqType());
    L79:
        int r22 = 2131888728;
    L81:
        String r113 = r21.getString(r22);
        Application r23 = LarkContext.getApplication();
        int r24 = r27.getPermReqType();
        if (r24 == 1) goto L87;
        if (r24 == 2) goto L85;
        tt5.a.d("AdjustmentApiImpl", "buildFailedToast unknown permReqType: " + r27.getPermReqType());
    L88:
        int r4 = 2131888733;
    L90:
        SecretLevelEscapeViewModel r6 = new SecretLevelEscapeViewModel(r11, r12, r14, r18, r19, r110, r111, r113, r23.getString(r4), r27.getEscapeSetting(), r27.getPermReqType(), r27.getPermReqParam(), r29, new EscapeApiImpl$showEscapeApproval$viewModel$1(r27, r28, this, r26));
        int r1 = AdjustmentRequestFragment.o;
        Intrinsics.checkNotNullParameter(r26, "activity");
        Intrinsics.checkNotNullParameter(r6, "viewModel");
        AdjustmentRequestFragment r2 = new AdjustmentRequestFragment(r6);
        FragmentTransaction r0 = r26.getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "AdjustmentRequestFragment", 0) == true) goto L94;
        r0 = r0.add(r2, "AdjustmentRequestFragment");
    L94:
        r0.commitAllowingStateLoss();
        return;
    L85:
        r4 = 2131888198;
        goto L90
    L87:
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L88;
        r4 = 2131888732;
        goto L90
    L71:
        if (r27.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L74;
        r22 = 2131888199;
        goto L81
    L74:
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L76;
        r22 = 2131889552;
        goto L81
    L76:
        r22 = 2131889548;
        goto L81
    L78:
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == true) goto L79;
        r22 = 2131888725;
        goto L81
    L65:
        r20 = r27.getApprovalDef().getReviewers();
        goto L66
    L22:
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L30;
        int r114 = f.a;
        int r115 = r27.getType();
        boolean r116 = !r27.getApprovalDef().getCcUsers().isEmpty();
        if (r115 == sbb.e.v.b) goto L43;
        if (r116 == false) goto L28;
        int r117 = 2131889553;
    L42:
        r16 = r117;
        goto L43
    L28:
        r117 = 2131889554;
    L43:
        r17 = r16;
        goto L62
    L30:
        if ((!r27.getApprovalDef().getReviewers().isEmpty()) == true) goto L46;
    L47:
        r17 = 2131889550;
    L46:
        r17 = 2131889549;
        goto L62
    L33:
        if (r27.getEscapeScene() != 1) goto L49;
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L45;
        int r118 = f.a;
        int r119 = r27.getType();
        boolean r120 = !r27.getApprovalDef().getCcUsers().isEmpty();
        if (r119 == sbb.e.v.b) goto L43;
        if (r120 == false) goto L41;
        r117 = 2131889553;
        goto L42
    L41:
        r117 = 2131889554;
        goto L42
    L45:
        if ((!r27.getApprovalDef().getReviewers().isEmpty()) == false) goto L47;
    L49:
        if (r27.getApprovalDef().getApprovalDetail().getOnlyCarbonCopy() == false) goto L59;
        int r121 = f.a;
        int r122 = r27.getType();
        boolean r123 = !r27.getApprovalDef().getCcUsers().isEmpty();
        if (r122 != sbb.e.v.b) goto L55;
        if (r123 == false) goto L54;
        r17 = 2131888860;
        goto L62
    L54:
        r17 = 2131888861;
        goto L62
    L55:
        if (r123 == false) goto L57;
        r17 = 2131888729;
        goto L62
    L57:
        r17 = 2131888730;
        goto L62
    L59:
        if ((!r27.getApprovalDef().getReviewers().isEmpty()) == false) goto L61;
        r17 = 2131888726;
    L16:
        r13 = 2131889558;
        goto L17
    L11:
        if (r27.getEscapeScene() == 1) goto L16;
        if (r27.getEscapeScene() != 2) goto L15;
        goto L15
    }
}
