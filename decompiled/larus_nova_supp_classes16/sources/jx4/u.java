package jx4;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.debug.LoadingView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u {
    public final LoadingView a;
    public Dialog b;
    public final TextView c;

    public final void b() {
        if (this.b == null) goto L12;
        LoadingView r0 = this.a;     // Catch: Exception -> L9
        if (r0.e == null) goto L7;
        r0.clearAnimation();     // Catch: Exception -> L9
        r0.e.setRepeatCount(1);     // Catch: Exception -> L9
        r0.e.cancel();     // Catch: Exception -> L9
        r0.e.end();     // Catch: Exception -> L9
    L7:
        a(this.b);     // Catch: Exception -> L9
        this.b = null;     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public final void c() {
        Dialog r0 = this.b;
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r0);
    L7:
        LoadingView r1 = this.a;
        if (r1.e == null) goto L10;
        r1.clearAnimation();
        r1.e.setRepeatCount(1);
        r1.e.cancel();
        r1.e.end();
    L10:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.e = r2;
        r2.setDuration(1000);
        r1.e.setInterpolator(new LinearInterpolator());
        r1.e.setRepeatCount(-1);
        r1.e.setRepeatMode(1);
        r1.e.addUpdateListener(new v(r1));
        r1.e.addListener(new w());
        if (r1.e.isRunning() == true) goto L17;
        r1.e.start();
        return;
    L17:
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
        goto L7
    }

    public static void a(Dialog r3) {
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

    public u(Context r4, String r5) {
        View r0 = LayoutInflater.from(r4).inflate(2131563578, null);
        LinearLayout r1 = (LinearLayout) r0.findViewById(2131368990);
        this.a = (LoadingView) r0.findViewById(2131379091);
        TextView r2 = (TextView) r0.findViewById(2131379082);
        this.c = r2;
        r2.setText(r5);
        Dialog r6 = new Dialog(r4, 2131954396);
        this.b = r6;
        r6.setContentView(r1, new LinearLayout.LayoutParams(-1, -1));
    }
}
