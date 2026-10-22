package yk5;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends t {
    public final /* synthetic */ c c;

    public e(c r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        c r5 = this.c;
        r5.b = true;
        sk5.d.b r6 = r5.j;
        if (r6 == null) goto L5;
        ((vk5.b) r6).a();
    L5:
        c r7 = this.c;
        Handler r0 = DialogLancet.resolveDialogHandler(r7);
        if (r0 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r1 == null) goto L19;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r0.getLooper()) goto L10;
        r0.post(DialogLancet.createDismissRunnable(r7));
    }
}
