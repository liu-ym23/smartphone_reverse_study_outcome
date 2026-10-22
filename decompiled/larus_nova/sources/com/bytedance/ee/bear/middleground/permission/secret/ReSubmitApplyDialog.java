package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class ReSubmitApplyDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f233941a = 0;

    static {
    }

    public ReSubmitApplyDialog() {
    }

    public static boolean b(SecretReviewModel r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.getState() == 1) goto L15;
        ArrayList<SecretApprovalInstanceModel.Instance> r101 = r100.getInstanceArrayList();
        if (r101 == null) goto L9;
        int r102 = r101.size();
    L10:
        if (r102 == 1) goto L16;
        return false;
    L16:
        return true;
    L9:
        r102 = 0;
        goto L10
    L15:
        return true;
    }

    public static void e(Dialog r100, SecretReviewModel r101) {
        if (r101 == null) goto L18;
        boolean r102 = true;
        if (r101.getState() == 1) goto L19;
        ArrayList<SecretApprovalInstanceModel.Instance> r103 = r101.getInstanceArrayList();
        if (r103 == null) goto L8;
        int r104 = r103.size();
    L9:
        if (r104 > 0) goto L12;
        r102 = false;
    L12:
        if (r102 == false) goto L20;
        if (r100 == null) goto L21;
        TextView r105 = (TextView) r100.findViewById(R.id.ud_dialog_content_message_tv);
        if (r105 == null) goto L22;
        r105.setMovementMethod(new LinkMovementMethod());
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r104 = 0;
        goto L9
    L19:
        return;
    }

    public static void c(final FragmentActivity r100, DialogInterface.OnClickListener r101, DialogInterface.OnClickListener r110, final SecretReviewModel r111, final boolean r112, final int r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "confirmListener");
        UDDialog r102 = a(r100, r101, r110, r111, r112, r113, new ReSubmitApplyDialog$show$dialog$1(r100, r111, r113, r112));
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r102);
    L7:
        e(r102, r111);
        com.bytedance.ee.bear.middleground.permission.c.J(b(r111), r112);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L7
    }

    public static /* synthetic */ void d(FragmentActivity r100, DialogInterface.OnClickListener r101, SecretReviewModel r102, boolean r103, int r110, int r111) {
        if ((r111 & 8) == 0) goto L5;
        r102 = null;
    L5:
        SecretReviewModel r104 = r102;
        if ((r111 & 16) == 0) goto L8;
        boolean r105 = false;
    L9:
        c(r100, r101, null, r104, r105, r110);
        return;
    L8:
        r105 = r103;
        goto L9
    }

    public static UDDialog a(FragmentActivity r210, DialogInterface.OnClickListener r211, DialogInterface.OnClickListener r212, SecretReviewModel r213, boolean r214, int r215, Function0 r310) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "confirmListener");
        if (r213 != null) goto L5;
    L49:
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r100 = new UDDialogBuilder(r210);
        r100.autoDismiss(true);
        r100.title(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_ConfirmSubmit_Title);
        r100.message(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_ConfirmSubmit_Text);
        r100.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Cancel_Button).textColorRes(R.color.text_title).onClickListener(new i(r212, r214)));
        r100.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Submit_Button).textColorRes(R.color.primary_fill_default).onClickListener(new j(r211, r214)));
        r100.style(R.style.ActionSheetDialogStyle);
        return r100.build();
    L5:
        if (r213.getState() == 1) goto L49;
        ArrayList<SecretApprovalInstanceModel.Instance> r101 = r213.getInstanceArrayList();
        if (r101 == null) goto L9;
        int r102 = r101.size();
    L10:
        if (r102 <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L49;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        UDDialogBuilder r104 = new UDDialogBuilder(r210);
        r104.autoDismiss(true);
        r104.title(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_ConfirmSubmit_Title);
        SpannableStringBuilder r105 = new SpannableStringBuilder();
        ArrayList<SecretApprovalInstanceModel.Instance> r110 = r213.getInstanceArrayList();
        if (r110 == null) goto L18;
        int r111 = r110.size();
    L20:
        if (r111 != 1) goto L31;
        int r112 = a0.f234022a;
        if (r111 != 1) goto L24;
        int r106 = a0.a(r215, R.string.LarkCCM_ChatShare_OnePreviousSecurityLevelRequest_Desc, R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_1RequestedBefore_Mob);
    L25:
        String r107 = r210.getString(r106);
        SecretLevel r108 = r213.getSecretLevel();
        if (r108 == null) goto L29;
        String r109 = r108.getName();
        if (r109 == null) goto L29;
    L30:
        CharSequence r113 = UIHelper.mustacheFormat(r107, "secure_label", r109);
    L41:
        if (r111 != 1) goto L43;
        String r114 = r210.getString(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_1Request_Mob);
    L44:
        Intrinsics.checkNotNull(r113);
        Intrinsics.checkNotNull(r114);
        int r115 = StringsKt.indexOf$default(r113, r114, 0, false, 6, null);
        if (r115 < 0) goto L47;
        Pair r116 = TuplesKt.to(Integer.valueOf(r115), Integer.valueOf(r115 + r114.length()));
        int r117 = ((Number) r116.component1()).intValue();
        int r118 = ((Number) r116.component2()).intValue();
        r105.append(r113);
        r105.setSpan(new h(r310, r210), r117, r118, 34);
    L48:
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.message(r105);
        r104.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Cancel_Button).textColorRes(R.color.text_title).onClickListener(new f(r212, r213, r214)));
        r104.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_Submit_Button).textColorRes(R.color.primary_fill_default).onClickListener(new g(r211, r213, r214)));
        r104.style(R.style.ActionSheetDialogStyle);
        return r104.build();
    L47:
        tt5.a.d("ReSubmitApplyDialog", "message parse index error " + r115 + ' ' + r114);
        r105 = r113;
        goto L48
    L43:
        r114 = UIHelper.mustacheFormat(r210.getString(R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_NRequest_Mob), "number", String.valueOf(r111));
    L29:
        r109 = "";
        goto L30
    L24:
        r106 = a0.a(r215, R.string.LarkCCM_ChatShare_PreviousSecurityLevelRequests_Desc, R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_NRequestedBefore_Mob);
        goto L25
    L31:
        int r119 = a0.f234022a;
        if (r111 != 1) goto L34;
        int r120 = a0.a(r215, R.string.LarkCCM_ChatShare_OnePreviousSecurityLevelRequest_Desc, R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_1RequestedBefore_Mob);
    L35:
        String r121 = r210.getString(r120);
        Pair[] r122 = new Pair[2];
        SecretLevel r123 = r213.getSecretLevel();
        if (r123 == null) goto L39;
        String r124 = r123.getName();
        if (r124 == null) goto L39;
    L40:
        r122[0] = TuplesKt.to("secure_label", r124);
        r122[1] = TuplesKt.to("number", String.valueOf(r111));
        r113 = UIHelper.mustacheFormat(r121, MapsKt.mapOf(r122));
    L39:
        r124 = "";
        goto L40
    L34:
        r120 = a0.a(r215, R.string.LarkCCM_ChatShare_PreviousSecurityLevelRequests_Desc, R.string.LarkCCM_Workspace_SecLeviI_AdjustRequest_NRequestedBefore_Mob);
        goto L35
    L18:
        r111 = 0;
        goto L20
    L12:
        r103 = false;
        goto L13
    L9:
        r102 = 0;
        goto L10
    }
}
