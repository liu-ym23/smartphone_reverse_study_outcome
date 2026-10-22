package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Dialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ReSubmitApplyDialog {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public ReSubmitApplyDialog() {
    }

    public static boolean b(SecretReviewModel r2) {
        if (r2 != null) goto L5;
        return true;
    L5:
        if (r2.getState() == 1) goto L15;
        ArrayList<SecretApprovalInstanceModel.Instance> r3 = r2.getInstanceArrayList();
        if (r3 == null) goto L9;
        int r4 = r3.size();
    L10:
        if (r4 == 1) goto L16;
        return false;
    L16:
        return true;
    L9:
        r4 = 0;
        goto L10
    L15:
        return true;
    }

    public static void e(Dialog r2, SecretReviewModel r3) {
        if (r3 == null) goto L18;
        boolean r1 = true;
        if (r3.getState() == 1) goto L19;
        ArrayList<SecretApprovalInstanceModel.Instance> r4 = r3.getInstanceArrayList();
        if (r4 == null) goto L8;
        int r5 = r4.size();
    L9:
        if (r5 > 0) goto L12;
        r1 = false;
    L12:
        if (r1 == false) goto L20;
        if (r2 == null) goto L21;
        TextView r6 = (TextView) r2.findViewById(2131391794);
        if (r6 == null) goto L22;
        r6.setMovementMethod(new LinkMovementMethod());
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L8:
        r5 = 0;
        goto L9
    L19:
        return;
    }

    public static void c(final FragmentActivity r8, DialogInterface.OnClickListener r9, DialogInterface.OnClickListener r10, final SecretReviewModel r11, final boolean r12, final int r13) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "confirmListener");
        UDDialog r14 = a(r8, r9, r10, r11, r12, r13, new ReSubmitApplyDialog$show$dialog$1(r8, r11, r13, r12));
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r14);
    L7:
        e(r14, r11);
        com.bytedance.ee.bear.middleground.permission.c.J(b(r11), r12);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        goto L7
    }

    public static /* synthetic */ void d(FragmentActivity r6, DialogInterface.OnClickListener r7, SecretReviewModel r8, boolean r9, int r10, int r11) {
        if ((r11 & 8) == 0) goto L5;
        r8 = null;
    L5:
        SecretReviewModel r3 = r8;
        if ((r11 & 16) == 0) goto L8;
        boolean r4 = false;
    L9:
        c(r6, r7, null, r3, r4, r10);
        return;
    L8:
        r4 = r9;
        goto L9
    }

    public static UDDialog a(FragmentActivity r24, DialogInterface.OnClickListener r25, DialogInterface.OnClickListener r26, SecretReviewModel r27, boolean r28, int r29, Function0 r30) {
        Intrinsics.checkNotNullParameter(r24, "context");
        Intrinsics.checkNotNullParameter(r25, "confirmListener");
        if (r27 != null) goto L5;
    L49:
        Intrinsics.checkNotNullParameter(r24, "context");
        UDDialogBuilder r3 = new UDDialogBuilder(r24);
        r3.autoDismiss(true);
        r3.title(2131889904);
        r3.message(2131889903);
        r3.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131889902).textColorRes(2131106622).onClickListener(new i(r26, r28)));
        r3.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131889909).textColorRes(2131105548).onClickListener(new j(r25, r28)));
        r3.style(2131951622);
        return r3.build();
    L5:
        if (r27.getState() == 1) goto L49;
        ArrayList<SecretApprovalInstanceModel.Instance> r7 = r27.getInstanceArrayList();
        if (r7 == null) goto L9;
        int r8 = r7.size();
    L10:
        if (r8 <= 0) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L49;
        Intrinsics.checkNotNullParameter(r24, "context");
        UDDialogBuilder r6 = new UDDialogBuilder(r24);
        r6.autoDismiss(true);
        r6.title(2131889904);
        SpannableStringBuilder r10 = new SpannableStringBuilder();
        ArrayList<SecretApprovalInstanceModel.Instance> r15 = r27.getInstanceArrayList();
        if (r15 == null) goto L18;
        int r16 = r15.size();
    L20:
        if (r16 != 1) goto L31;
        int r17 = a0.a;
        if (r16 != 1) goto L24;
        int r5 = a0.a(r29, 2131888875, 2131889899);
    L25:
        String r11 = r24.getString(r5);
        SecretLevel r12 = r27.getSecretLevel();
        if (r12 == null) goto L29;
        String r13 = r12.getName();
        if (r13 == null) goto L29;
    L30:
        CharSequence r14 = UIHelper.mustacheFormat(r11, "secure_label", r13);
    L41:
        if (r16 != 1) goto L43;
        String r18 = r24.getString(2131889898);
    L44:
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r18);
        int r19 = StringsKt.indexOf$default(r14, r18, 0, false, 6, null);
        if (r19 < 0) goto L47;
        Pair r20 = TuplesKt.to(Integer.valueOf(r19), Integer.valueOf(r19 + r18.length()));
        int r21 = ((Number) r20.component1()).intValue();
        int r22 = ((Number) r20.component2()).intValue();
        r10.append(r14);
        r10.setSpan(new h(r30, r24), r21, r22, 34);
    L48:
        Intrinsics.checkNotNullParameter(r10, "value");
        r6.message(r10);
        r6.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131889902).textColorRes(2131106622).onClickListener(new f(r26, r27, r28)));
        r6.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131889909).textColorRes(2131105548).onClickListener(new g(r25, r27, r28)));
        r6.style(2131951622);
        return r6.build();
    L47:
        tt5.a.d("ReSubmitApplyDialog", "message parse index error " + r19 + ' ' + r18);
        r10 = r14;
        goto L48
    L43:
        r18 = UIHelper.mustacheFormat(r24.getString(2131889905), SheetInputData.InputData.FormatType.NUMBER, String.valueOf(r16));
    L29:
        r13 = "";
        goto L30
    L24:
        r5 = a0.a(r29, 2131888877, 2131889906);
        goto L25
    L31:
        int r110 = a0.a;
        if (r16 != 1) goto L34;
        int r23 = a0.a(r29, 2131888875, 2131889899);
    L35:
        String r31 = r24.getString(r23);
        Pair[] r32 = new Pair[2];
        SecretLevel r33 = r27.getSecretLevel();
        if (r33 == null) goto L39;
        String r34 = r33.getName();
        if (r34 == null) goto L39;
    L40:
        r32[0] = TuplesKt.to("secure_label", r34);
        r32[1] = TuplesKt.to(SheetInputData.InputData.FormatType.NUMBER, String.valueOf(r16));
        r14 = UIHelper.mustacheFormat(r31, MapsKt.mapOf(r32));
    L39:
        r34 = "";
        goto L40
    L34:
        r23 = a0.a(r29, 2131888877, 2131889906);
        goto L35
    L18:
        r16 = 0;
        goto L20
    L12:
        r9 = false;
        goto L13
    L9:
        r8 = 0;
        goto L10
    }
}
