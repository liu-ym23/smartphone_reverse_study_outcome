package com.bytedance.awemeopen.domain.user.login.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import j44.c;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/domain/user/login/dialog/PhoneNumberLoginDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ao_user_login_dialog_release"}, k = 1, mv = {1, 7, 1})
public final class PhoneNumberLoginDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f198517b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f198518a;

    public static final class a {
    }

    public interface b {
        void a();

        void onCancel();

        void onConfirm();
    }

    static {
    }

    public static void I0(PhoneNumberLoginDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public PhoneNumberLoginDialog(Context r210, String r211, String r212, i04.a r213) {
        CharSequence r100 = r212;
        super(r210, R.style.phone_number_login_dialog_style);
        this.f198518a = r213;
        setContentView(R.layout.aos_phone_number_login_dialog);
        ((TextView) findViewById(R.id.aos_phone_number_login_title)).setText(r211);
        TextView r101 = (TextView) findViewById(R.id.aos_phone_number_login_msg);
        if (StringsKt.contains$default(r100, "[", false, 2, null) == true) goto L5;
    L7:
        r101.setText(r100);
        ((TextView) findViewById(R.id.confirm_btn)).setOnClickListener(new j44.a(this));
        ((TextView) findViewById(R.id.use_another_account_btn)).setOnClickListener(new j44.b(this));
        setOnDismissListener(new c(this));
        return;
    L5:
        if (StringsKt.contains$default(r100, "]", false, 2, null) == false) goto L7;
        SpannableString r110 = new SpannableString(r100);
        r110.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.aos_phone_number_login_text_color)), 0, StringsKt.indexOf$default(r212, "[", 0, false, 6, null), 18);
        r110.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.aos_phone_number_login_phone_color)), StringsKt.indexOf$default(r212, "[", 0, false, 6, null), StringsKt.indexOf$default(r212, "]", 0, false, 6, null) + 1, 18);
        r110.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.aos_phone_number_login_text_color)), StringsKt.indexOf$default(r212, "]", 0, false, 6, null) + 1, r212.length(), 18);
        r100 = r110;
        goto L7
    }
}
