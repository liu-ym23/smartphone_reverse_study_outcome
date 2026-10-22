package com.ss.android.bytedcert.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes34.dex */
public class DialogHelper {
    public DialogHelper() {
    }

    public static void INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_DialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static void showJsbIdEmpDialog(Activity r100) {
        if (r100 == null) goto L5;
        INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_DialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(new JSBImgDialog(r100));
        return;
    }

    public static void INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_DialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(JSBImgDialog r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    private static AlertDialog buildAlertDialog(Context r100, String r101, String r102, String r103, String r104, DialogInterface.OnClickListener r105, DialogInterface.OnClickListener r106) {
        if (r100 == null) goto L11;
        AlertDialog.Builder r107 = new AlertDialog.Builder(r100, R.style.byted_alert_dialog);
        r107.setCancelable(false);
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r107.setPositiveButton(r101, r105);
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r107.setNegativeButton(r102, r106);
    L10:
        return r107.create();
    L11:
        return null;
    }

    public static void showAlertDialog(Context r100, String r101, String r102, String r103, String r104, DialogInterface.OnClickListener r105, DialogInterface.OnClickListener r106) {
        if (r100 == null) goto L10;
        AlertDialog r107 = buildAlertDialog(r100, r101, r102, r103, r104, r105, r106);
        if (r107 != null) goto L6;
        return;
    L6:
        TextView r108 = new TextView(r100);
        r108.setText(r103);
        r108.setPadding(0, 30, 0, 0);
        r108.setGravity(17);
        r108.setTextSize(2, 17.0f);
        r108.setTextColor(-16777216);
        r107.setCustomTitle(r108);
        TextView r109 = new TextView(r100);
        r109.setVisibility(0);
        r109.setText(r104);
        r109.setTextColor(-16777216);
        r109.setGravity(17);
        r109.setPadding(40, 20, 40, 0);
        r109.setTextSize(2, 15.0f);
        r107.setView(r109);
        INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_DialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r107);
        Button r110 = r107.getButton(-1);
        r110.setTextColor(-13987625);
        r110.setTextSize(2, 17.0f);
        Button r111 = r107.getButton(-2);
        if (r111 == null) goto L11;
        r111.setTextColor(-13987625);
        r111.setTextSize(2, 17.0f);
        return;
    L11:
        return;
    }
}
