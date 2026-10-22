package vb4;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements Runnable {
    public final /* synthetic */ TuringLiveByteNNActivity a;

    /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Activity, com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity, com.bytedance.bdturing.livedetect.TuringLiveDetectActivity] */
    public final void a() {
        this.a.A1();
        if (this.a.A.get() == true) goto L5;
    L10:
        ?? r0 = this.a;
        sb4.k r1 = r0.q;
        if (r1 == null) goto L29;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L15;
    L17:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L20 Exception -> L22
    L26:
        DialogLancet.afterDialogDismiss(r1);
        goto L29
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L20
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L20
        if (r3 == null) goto L26;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L15:
        if (Looper.myLooper() == r2.getLooper()) goto L17;
        r2.post(DialogLancet.createDismissRunnable(r1));
    L29:
        String r4 = r0.getString(2131923575);
        if (r0.A.get() == true) goto L32;
        String r5 = r0.getString(2131923577);
    L34:
        if (r0.z.get() == true) goto L36;
        r5 = r0.getString(2131923572);
    L36:
        sb4.b r6 = new sb4.b();
        r6.a = r4;
        r6.b = r5;
        r6.c = r0.getString(2131923573);
        r6.d = r0.getString(2131923574);
        String r7 = "byteNNLoad:" + r0.A + ";modelFileReady=" + r0.z;
        sb4.k r8 = new sb4.k(r0, r6, false, new m(r0, r7));
        r0.q = r8;
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r8);
    L41:
        EventReport.r(3, 0, r7, r0.v);
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L40:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L41
    L32:
        r5 = "";
        goto L34
    L5:
        if (this.a.z.get() == false) goto L10;
        TuringLiveByteNNActivity r9 = this.a;
        if (r9.B == true) goto L50;
        r9.B = true;
        ThreadMethodProxy.start(new PthreadThreadV2(new l(r9), "TuringLiveByteNNActivity"));
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public o(TuringLiveByteNNActivity r1) {
        this.a = r1;
    }
}
