package vb4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p implements sb4.l {
    public final /* synthetic */ TuringLiveDetectActivity a;

    public final void a() {
        EventReport.r(1, 1, "", this.a.v);
        this.a.finish();
    }

    public final void b() {
        sb4.k r0 = this.a.q;
        if (r0 == null) goto L21;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r0);
        goto L21
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r2 == null) goto L18;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r1.getLooper()) goto L9;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L21:
        EventReport.r(1, 2, "", this.a.v);
        this.a.I1();
    }

    public final void onCancel() {
        EventReport.r(1, 3, "", this.a.v);
        this.a.finish();
    }

    public p(TuringLiveDetectActivity r1) {
        this.a = r1;
    }
}
