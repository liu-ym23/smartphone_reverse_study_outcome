package ub4;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.identityverify.IdentityVerifyService$b;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import qb4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends Dialog {
    public final Activity a;
    public final a b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public View g;

    @Override // android.app.Dialog
    public final void show() {
        if ((!this.a.isFinishing()) == true) goto L6;
        return;
    L6:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(this);
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
    }

    public static void a(i r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131558790);
        this.f = findViewById(2131392110);
        this.g = findViewById(2131392111);
        TextView r3 = (TextView) findViewById(2131390522);
        TextView r4 = (TextView) findViewById(2131390521);
        this.c = (TextView) findViewById(2131390519);
        this.d = (TextView) findViewById(2131390520);
        this.e = findViewById(2131384840);
        BdTuringConfig r5 = b.c.a.a;
        if (r5 == null) goto L5;
        r5.getThemeConfig();
    L5:
        setOnCancelListener(new f(this));
        this.c.setOnClickListener(new g(this));
        this.d.setOnClickListener(new h(this));
    }

    public i(Activity r2, IdentityVerifyService$b r3) {
        super(r2, 2131951903);
        this.a = r2;
        this.b = r3;
    }
}
