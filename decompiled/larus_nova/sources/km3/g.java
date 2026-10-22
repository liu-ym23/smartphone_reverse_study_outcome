package km3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes14.dex */
public final class g extends ProgressDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f504056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f504057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f504058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f504059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f504060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f504061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f504062g;

    public interface a {
        void onClose();
    }

    public final void b() {
        this.f504061f = true;
        if (this.f504057b == false) goto L8;
        View r100 = this.f504059d;
        if (r100 == null) goto L9;
        r100.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        final CircularProgressView r100 = (CircularProgressView) findViewById(R.id.iv_loading);
        Runnable r101 = new f(this, r100);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r101.run();
        return;
    L5:
        if (r100 == null) goto L9;
        r100.post(r101);
        return;
    }

    public g(Context r100) {
        super(r100, 3);
        this.f504056a = true;
        this.f504061f = false;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.uicomponent_layout_custom_progress_dialog);
        View r101 = findViewById(R.id.iv_close);
        this.f504059d = r101;
        if (this.f504061f == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        this.f504059d.setOnClickListener(new e(this));
        this.f504057b = true;
        setMessage(this.f504058c);
        setIndeterminate(false);
        setCanceledOnTouchOutside(false);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // android.app.ProgressDialog
    public final void setIndeterminate(boolean r100) {
        super.setIndeterminate(r100);
        if (this.f504057b == false) goto L13;
        CircularProgressView r101 = (CircularProgressView) findViewById(R.id.iv_loading);
        if (r101 == null) goto L7;
        r101.setIndeterminate(r100);
    L7:
        TextView r102 = (TextView) findViewById(R.id.progress);
        if (r100 == false) goto L10;
        int r103 = 4;
    L11:
        r102.setVisibility(r103);
        return;
    L10:
        r103 = 0;
        goto L11
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public final void setMessage(CharSequence r100) {
        super.setMessage(r100);
        if (this.f504057b == false) goto L11;
        TextView r101 = (TextView) findViewById(R.id.message);
        if (r101 == null) goto L11;
        r101.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L9;
        int r102 = 8;
    L10:
        r101.setVisibility(r102);
        goto L11
    L9:
        r102 = 0;
    L11:
        this.f504058c = r100;
    }

    @Override // android.app.ProgressDialog
    public final void setProgress(int r100) {
        super.setProgress(r100);
        TextView r101 = (TextView) findViewById(R.id.progress);
        if (r101 == null) goto L5;
        r101.setText(r100 + GXTemplateKey.GAIAX_PE);
    L5:
        CircularProgressView r102 = (CircularProgressView) findViewById(R.id.iv_loading);
        if (r102 == null) goto L9;
        r102.setProgress(r100);
        return;
    }

    public g(Context r100, int r101) {
        super(r100, 3);
        this.f504056a = true;
        this.f504061f = false;
    }

    public static void a(g r100, CircularProgressView r101) {
        r100.getClass();
        if (r101 == null) goto L5;
        r101.c();
    L5:
        Handler r102 = DialogLancet.resolveDialogHandler(r100);
        if (r102 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r100);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r100);
    L20:
        a r103 = r100.f504060e;
        if (r103 == null) goto L29;
        r103.onClose();
        return;
    L29:
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r104 == null) goto L19;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L8:
        if (Looper.myLooper() == r102.getLooper()) goto L10;
        r102.post(DialogLancet.createDismissRunnable(r100));
        goto L20
    }

    public static g c(Context r100, String r101) {
        g r102 = new g(r100, 0);
        r102.setCancelable(false);
        r102.setIndeterminate(false);
        r102.setMax(100);
        if ((r100 instanceof Activity) == true) goto L5;
    L11:
        r102.setMessage(r101);
        View r103 = r102.findViewById(R.id.progress);
        if (r103 != null) goto L15;
    L18:
        return r102;
    L15:
        if (r102.f504056a == false) goto L17;
        r103.setVisibility(0);
        goto L18
    L17:
        r103.setVisibility(4);
        goto L18
    L5:
        if (((Activity) r100).isFinishing() == true) goto L11;
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r102);
        goto L11
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L10:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L11
    }
}
