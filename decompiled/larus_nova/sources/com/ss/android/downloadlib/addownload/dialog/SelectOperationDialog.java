package com.ss.android.downloadlib.addownload.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes34.dex */
public class SelectOperationDialog extends Dialog implements IReserveWifiView {
    private Activity mActivity;
    private TextView mCancelView;
    private TextView mConfirmView;
    private IDeleteBtnListener mDeleteBtnListener;
    private String mDeleteBtnText;
    private TextView mDeleteView;
    private boolean mIsFromConfirm;
    private boolean mIsFromDelete;
    private String mMessage;
    private TextView mMessageView;
    private String mNegativeBtnText;
    private String mPositiveBtnText;
    private ISelectOperationListener mSelectOperationListener;

    public static class Builder {
        private Activity mActivity;
        private boolean mCancelableOnTouchOutside;
        private IDeleteBtnListener mDeleteBtnListener;
        private String mDeleteBtnText;
        private String mMessage;
        private String mNegativeBtnText;
        private String mPositiveBtnText;
        private ISelectOperationListener mSelectOperationListener;

        public SelectOperationDialog build() {
            return new SelectOperationDialog(this.mActivity, this.mMessage, this.mPositiveBtnText, this.mNegativeBtnText, this.mDeleteBtnText, this.mCancelableOnTouchOutside, this.mSelectOperationListener, this.mDeleteBtnListener);
        }

        public Builder(Activity r100) {
            this.mActivity = r100;
        }

        public Builder setCancelableOnTouchOutside(boolean r100) {
            this.mCancelableOnTouchOutside = r100;
            return this;
        }

        public Builder setDeleteBtnListener(IDeleteBtnListener r100) {
            this.mDeleteBtnListener = r100;
            return this;
        }

        public Builder setDeleteBtnText(String r100) {
            this.mDeleteBtnText = r100;
            return this;
        }

        public Builder setMessage(String r100) {
            this.mMessage = r100;
            return this;
        }

        public Builder setNegativeBtnText(String r100) {
            this.mNegativeBtnText = r100;
            return this;
        }

        public Builder setPositiveBtnText(String r100) {
            this.mPositiveBtnText = r100;
            return this;
        }

        public Builder setSelectOperationListener(ISelectOperationListener r100) {
            this.mSelectOperationListener = r100;
            return this;
        }
    }

    public static /* synthetic */ void access$001(Dialog r100) {
        super.dismiss();
    }

    private void confirm() {
        this.mIsFromConfirm = true;
        INVOKEVIRTUAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
    }

    private void delete() {
        this.mIsFromDelete = true;
        INVOKEVIRTUAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
    }

    @Override // com.ss.android.downloadlib.addownload.dialog.IReserveWifiView
    public int getCancelViewId() {
        return R.id.cancel_tv;
    }

    @Override // com.ss.android.downloadlib.addownload.dialog.IReserveWifiView
    public int getConfirmViewId() {
        return R.id.confirm_tv;
    }

    public int getDeleteViewId() {
        return R.id.delete_tv;
    }

    @Override // com.ss.android.downloadlib.addownload.dialog.IReserveWifiView
    public int getLayoutId() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    private void init() {
        setContentView(LayoutInflater.from(this.mActivity.getApplicationContext()).inflate(getLayoutId(), null));
        this.mConfirmView = (TextView) findViewById(getConfirmViewId());
        this.mCancelView = (TextView) findViewById(getCancelViewId());
        this.mMessageView = (TextView) findViewById(R.id.message_tv);
        this.mDeleteView = (TextView) findViewById(R.id.delete_tv);
        if (TextUtils.isEmpty(this.mPositiveBtnText) == true) goto L6;
        this.mConfirmView.setText(this.mPositiveBtnText);
    L6:
        if (TextUtils.isEmpty(this.mNegativeBtnText) == true) goto L9;
        this.mCancelView.setText(this.mNegativeBtnText);
    L9:
        if (TextUtils.isEmpty(this.mDeleteBtnText) == true) goto L11;
        this.mDeleteView.setText(this.mDeleteBtnText);
    L13:
        if (TextUtils.isEmpty(this.mMessage) == true) goto L15;
        this.mMessageView.setText(this.mMessage);
    L15:
        this.mConfirmView.setOnClickListener(new AnonymousClass1(this));
        this.mCancelView.setOnClickListener(new AnonymousClass2(this));
        this.mDeleteView.setOnClickListener(new AnonymousClass3(this));
        return;
    L11:
        this.mDeleteView.setVisibility(8);
        goto L13
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        INVOKESPECIAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        if (this.mActivity.isFinishing() == true) goto L6;
        this.mActivity.finish();
    L6:
        if (this.mIsFromConfirm == false) goto L9;
        this.mSelectOperationListener.confirm();
        return;
    L9:
        if (this.mIsFromDelete == false) goto L11;
        this.mDeleteBtnListener.delete();
        return;
    L11:
        this.mSelectOperationListener.cancel();
    }

    private void clickCancel() {
        INVOKEVIRTUAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
    }

    public static void INVOKESPECIAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        access$001(r100);     // Catch: Throwable -> L11 Exception -> L13
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

    public static void INVOKEVIRTUAL_com_ss_android_downloadlib_addownload_dialog_SelectOperationDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(SelectOperationDialog r100) {
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

    public static /* synthetic */ void access$000(SelectOperationDialog r100) {
        r100.confirm();
    }

    public static /* synthetic */ void access$100(SelectOperationDialog r100) {
        r100.clickCancel();
    }

    public static /* synthetic */ void access$200(SelectOperationDialog r100) {
        r100.delete();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (r100.getKeyCode() != 4) goto L7;
        return true;
    L7:
        return super.dispatchKeyEvent(r100);
    }

    public SelectOperationDialog(Activity r100, String r101, String r102, String r103, String r104, boolean r105, ISelectOperationListener r106, IDeleteBtnListener r107) {
        super(r100, R.style.ttdownloader_translucent_dialog);
        this.mActivity = r100;
        this.mSelectOperationListener = r106;
        this.mMessage = r101;
        this.mPositiveBtnText = r102;
        this.mNegativeBtnText = r103;
        this.mDeleteBtnText = r104;
        this.mDeleteBtnListener = r107;
        setCanceledOnTouchOutside(r105);
        init();
    }
}
