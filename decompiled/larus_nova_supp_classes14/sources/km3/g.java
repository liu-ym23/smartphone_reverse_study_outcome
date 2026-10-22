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
import com.bytedance.android.uicomponent.loading.CircularProgressView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends ProgressDialog {
    public final boolean a;
    public boolean b;
    public CharSequence c;
    public View d;
    public a e;
    public boolean f;
    public View.OnClickListener g;

    public interface a {
        void onClose();
    }

    public final void b() {
        this.f = true;
        if (this.b == false) goto L8;
        View r0 = this.d;
        if (r0 == null) goto L9;
        r0.setVisibility(0);
        return;
    L9:
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        final CircularProgressView r0 = (CircularProgressView) findViewById(2131376377);
        Runnable r1 = new f(this, r0);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r1.run();
        return;
    L5:
        if (r0 == null) goto L9;
        r0.post(r1);
        return;
    }

    public g(Context r2) {
        super(r2, 3);
        this.a = true;
        this.f = false;
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(2131568112);
        View r4 = findViewById(2131376107);
        this.d = r4;
        if (this.f == false) goto L5;
        int r0 = 0;
    L6:
        r4.setVisibility(r0);
        this.d.setOnClickListener(new e(this));
        this.b = true;
        setMessage(this.c);
        setIndeterminate(false);
        setCanceledOnTouchOutside(false);
        return;
    L5:
        r0 = 8;
        goto L6
    }

    @Override // android.app.ProgressDialog
    public final void setIndeterminate(boolean r2) {
        super.setIndeterminate(r2);
        if (this.b == false) goto L13;
        CircularProgressView r0 = (CircularProgressView) findViewById(2131376377);
        if (r0 == null) goto L7;
        r0.setIndeterminate(r2);
    L7:
        TextView r1 = (TextView) findViewById(2131383286);
        if (r2 == false) goto L10;
        int r3 = 4;
    L11:
        r1.setVisibility(r3);
        return;
    L10:
        r3 = 0;
        goto L11
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public final void setMessage(CharSequence r3) {
        super.setMessage(r3);
        if (this.b == false) goto L11;
        TextView r0 = (TextView) findViewById(2131379959);
        if (r0 == null) goto L11;
        r0.setText(r3);
        if (TextUtils.isEmpty(r3) == false) goto L9;
        int r1 = 8;
    L10:
        r0.setVisibility(r1);
        goto L11
    L9:
        r1 = 0;
    L11:
        this.c = r3;
    }

    @Override // android.app.ProgressDialog
    public final void setProgress(int r4) {
        super.setProgress(r4);
        TextView r0 = (TextView) findViewById(2131383286);
        if (r0 == null) goto L5;
        r0.setText(r4 + "%");
    L5:
        CircularProgressView r1 = (CircularProgressView) findViewById(2131376377);
        if (r1 == null) goto L9;
        r1.setProgress(r4);
        return;
    }

    public g(Context r1, int r2) {
        super(r1, 3);
        this.a = true;
        this.f = false;
    }

    public static void a(g r2, CircularProgressView r3) {
        r2.getClass();
        if (r3 == null) goto L5;
        r3.c();
    L5:
        Handler r4 = DialogLancet.resolveDialogHandler(r2);
        if (r4 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r2);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r2);
    L20:
        a r5 = r2.e;
        if (r5 == null) goto L29;
        r5.onClose();
        return;
    L29:
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r6 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r6 == null) goto L19;
        com.bytedance.crash.d.d(r6, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L8:
        if (Looper.myLooper() == r4.getLooper()) goto L10;
        r4.post(DialogLancet.createDismissRunnable(r2));
        goto L20
    }

    public static g c(Context r3, String r4) {
        g r0 = new g(r3, 0);
        r0.setCancelable(false);
        r0.setIndeterminate(false);
        r0.setMax(100);
        if ((r3 instanceof Activity) == true) goto L5;
    L11:
        r0.setMessage(r4);
        View r5 = r0.findViewById(2131383286);
        if (r5 != null) goto L15;
    L18:
        return r0;
    L15:
        if (r0.a == false) goto L17;
        r5.setVisibility(0);
        goto L18
    L17:
        r5.setVisibility(4);
        goto L18
    L5:
        if (((Activity) r3).isFinishing() == true) goto L11;
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(r0);
        goto L11
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L10:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L11
    }
}
