package vb4;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.livedetect.TuringLiveDetectActivity;
import com.bytedance.bdturing.livedetect.TuringLiveDetectWebActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements sb4.l {
    public final /* synthetic */ TuringLiveDetectActivity a;

    public final void a() {
        AppCompatActivity r0 = this.a;
        int r1 = TuringLiveDetectActivity.y;
        r0.getClass();
        TuringLiveDetectWebActivity.startActivity(r0, e.b(), r0.getString(2131923600));
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
        this.a.I1();
    }

    public final void onCancel() {
        this.a.finish();
    }

    public q(TuringLiveDetectActivity r1) {
        this.a = r1;
    }
}
