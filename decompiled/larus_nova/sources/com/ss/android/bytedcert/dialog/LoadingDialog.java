package com.ss.android.bytedcert.dialog;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.ablity.ICertLoadingDialog;
import java.lang.ref.WeakReference;
import rsa.i;

/* JADX INFO: loaded from: classes34.dex */
public class LoadingDialog implements ICertLoadingDialog {
    private WeakReference<Activity> mActivityRef;
    private final boolean mCancelable;
    private SSDialog mSSDialog;
    private String mText;
    private TextView mTextView;

    @Override // com.ss.android.cert.manager.ablity.ICertLoadingDialog
    public void dismiss() {
        WeakReference<Activity> r100 = this.mActivityRef;     // Catch: Exception -> L18
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L23;
        Activity r101 = this.mActivityRef.get();     // Catch: Exception -> L18
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.isFinishing() == true) goto L25;
        SSDialog r102 = this.mSSDialog;     // Catch: Exception -> L18
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.isShowing() == false) goto L27;
        INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_LoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.mSSDialog);     // Catch: Exception -> L18
        return;
    L27:
        return;
    L25:
        return;
    L23:
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public AppCompatDialog getDialog() {
        WeakReference<Activity> r100 = this.mActivityRef;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.get() != null) goto L8;
        return null;
    L8:
        if (this.mSSDialog != null) goto L11;
        this.mSSDialog = new SSDialog(this.mActivityRef.get(), R.style.byted_loading_dialog_style);
    L11:
        return this.mSSDialog;
    }

    @Override // com.ss.android.cert.manager.ablity.ICertLoadingDialog
    public void show() {
        WeakReference<Activity> r100 = this.mActivityRef;     // Catch: Exception -> L26
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.get() == null) goto L30;
        Activity r101 = this.mActivityRef.get();     // Catch: Exception -> L26
        if (this.mSSDialog != null) goto L10;
        this.mSSDialog = new SSDialog(r101, R.style.byted_loading_dialog_style);     // Catch: Exception -> L26
    L10:
        this.mSSDialog.setCanceledOnTouchOutside(false);     // Catch: Exception -> L26
        this.mSSDialog.setCancelable(this.mCancelable);     // Catch: Exception -> L26
        Window r102 = this.mSSDialog.getWindow();     // Catch: Exception -> L26
        if (r102 == null) goto L13;
        r102.setGravity(17);     // Catch: Exception -> L26
        r102.setBackgroundDrawableResource(R.color.byted_transparent);     // Catch: Exception -> L26
    L13:
        View r103 = LayoutInflater.from(r101).inflate(R.layout.byted_loading_dialog, null);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(this.mText) == true) goto L19;
        if (r103 == null) goto L19;
        TextView r104 = (TextView) r103.findViewById(R.id.loading_dialog_text);     // Catch: Exception -> L26
        this.mTextView = r104;     // Catch: Exception -> L26
        if (r104 == null) goto L24;
        r104.setText(this.mText);     // Catch: Exception -> L26
    L24:
        this.mSSDialog.setContentView(r103);     // Catch: Exception -> L26
        INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_LoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mSSDialog);     // Catch: Exception -> L26
        return;
    L19:
        if (r103 == null) goto L24;
        TextView r105 = (TextView) r103.findViewById(R.id.loading_dialog_text);     // Catch: Exception -> L26
        this.mTextView = r105;     // Catch: Exception -> L26
        if (r105 == null) goto L23;
        r105.setVisibility(8);     // Catch: Exception -> L26
    L23:
        ProgressBar r106 = (ProgressBar) r103.findViewById(R.id.pb_loading);     // Catch: Exception -> L26
        LinearLayout.LayoutParams r107 = (LinearLayout.LayoutParams) r106.getLayoutParams();     // Catch: Exception -> L26
        int r108 = (int) i.b(r101, 16.0f);     // Catch: Exception -> L26
        r107.setMargins(r108, r108, r108, r108);     // Catch: Exception -> L26
        r106.setLayoutParams(r107);     // Catch: Exception -> L26
        goto L24
    L30:
        return;
    }

    public static void INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_LoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(SSDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_ss_android_bytedcert_dialog_LoadingDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(SSDialog r100) {
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

    public static LoadingDialog create(Activity r100) {
        return new LoadingDialog(r100, null);
    }

    public void setText(String r100) {
        this.mText = r100;
        TextView r101 = this.mTextView;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public LoadingDialog(Activity r100, String r101) {
        this(r100, r101, true);
    }

    public static LoadingDialog create(Activity r100, String r101) {
        return new LoadingDialog(r100, r101);
    }

    public LoadingDialog(Activity r100, String r101, boolean r102) {
        if (r100 == null) goto L5;
        this.mActivityRef = new WeakReference(r100);
    L5:
        this.mText = r101;
        this.mCancelable = r102;
    }

    public static LoadingDialog create(Activity r100, String r101, boolean r102) {
        return new LoadingDialog(r100, r101, r102);
    }
}
