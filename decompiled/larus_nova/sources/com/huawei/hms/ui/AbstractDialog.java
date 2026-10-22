package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f277821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AlertDialog f277822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Callback f277823c;

    public interface Callback {
        void onCancel(AbstractDialog r100);

        void onDoWork(AbstractDialog r100);
    }

    public class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f277824a;

        public a(AbstractDialog r100) {
            this.f277824a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            this.f277824a.fireDoWork();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f277825a;

        public b(AbstractDialog r100) {
            this.f277825a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r100, int r101) {
            this.f277825a.cancel();
        }
    }

    public class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f277826a;

        public c(AbstractDialog r100) {
            this.f277826a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r100) {
            this.f277826a.fireCancel();
        }
    }

    public class d implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f277827a;

        public d(AbstractDialog r100) {
            this.f277827a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (4 == r101) goto L5;
            return false;
        L5:
            if (r102.getAction() != 1) goto L10;
            this.f277827a.cancel();
            return true;
        L10:
            return false;
        }
    }

    public AbstractDialog() {
    }

    public abstract String onGetMessageString(Context r100);

    public abstract String onGetNegativeButtonString(Context r100);

    public abstract String onGetPositiveButtonString(Context r100);

    public abstract String onGetTitleString(Context r100);

    public void cancel() {
        AlertDialog r100 = this.f277822b;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public void dismiss() {
        AlertDialog r100 = this.f277822b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L9;
        INVOKEVIRTUAL_com_huawei_hms_ui_AbstractDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.f277822b);
        return;
    }

    public void fireCancel() {
        Callback r100 = this.f277823c;
        if (r100 == null) goto L6;
        r100.onCancel(this);
        return;
    }

    public void fireDoWork() {
        Callback r100 = this.f277823c;
        if (r100 == null) goto L6;
        r100.onDoWork(this);
        return;
    }

    public int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    public Activity getActivity() {
        return this.f277821a;
    }

    public static void INVOKEVIRTUAL_com_huawei_hms_ui_AbstractDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r100) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_huawei_hms_ui_AbstractDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r100) {
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

    public AlertDialog onCreateDialog(Activity r100) {
        AlertDialog.Builder r101 = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String r102 = onGetTitleString(r100);
        if (r102 == null) goto L5;
        r101.setTitle(r102);
    L5:
        String r103 = onGetMessageString(r100);
        if (r103 == null) goto L8;
        r101.setMessage(r103);
    L8:
        String r104 = onGetPositiveButtonString(r100);
        if (r104 == null) goto L11;
        r101.setPositiveButton(r104, new a(this));
    L11:
        String r105 = onGetNegativeButtonString(r100);
        if (r105 == null) goto L15;
        r101.setNegativeButton(r105, new b(this));
    L15:
        return r101.create();
    }

    public void setMessage(CharSequence r100) {
        AlertDialog r101 = this.f277822b;
        if (r101 == null) goto L6;
        r101.setMessage(r100);
        return;
    }

    public void setTitle(CharSequence r100) {
        AlertDialog r101 = this.f277822b;
        if (r101 == null) goto L6;
        r101.setTitle(r100);
        return;
    }

    public void show(Activity r100, Callback r101) {
        this.f277821a = r100;
        this.f277823c = r101;
        if (r100 != null) goto L5;
    L9:
        HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
        return;
    L5:
        if (r100.isFinishing() == true) goto L9;
        AlertDialog r102 = onCreateDialog(this.f277821a);
        this.f277822b = r102;
        r102.setCanceledOnTouchOutside(false);
        this.f277822b.setOnCancelListener(new c(this));
        this.f277822b.setOnKeyListener(new d(this));
        UIUtil.enableFocusedForButtonsInTV(this.f277822b);
        INVOKEVIRTUAL_com_huawei_hms_ui_AbstractDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.f277822b);
    }
}
