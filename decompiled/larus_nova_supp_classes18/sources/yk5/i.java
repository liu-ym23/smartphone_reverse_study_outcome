package yk5;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends t {
    public final /* synthetic */ g c;

    public i(g r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        g r5 = this.c;
        r5.b = true;
        sk5.d.b r0 = r5.j;
        if (r0 == null) goto L5;
        ((vk5.b) r0).b();
    L5:
        Handler r1 = DialogLancet.resolveDialogHandler(r5);
        if (r1 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L8:
        if (Looper.myLooper() == r1.getLooper()) goto L10;
        r1.post(DialogLancet.createDismissRunnable(r5));
    }
}
