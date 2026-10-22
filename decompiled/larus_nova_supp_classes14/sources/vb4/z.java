package vb4;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class z implements sb4.l {
    public final /* synthetic */ TuringLiveDetectGuideActivity a;

    public final void a() {
        this.a.finish();
    }

    public final void b() {
        sb4.g r0 = this.a.n;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r0);
    L17:
        AppCompatActivity r2 = this.a;
        r2.getClass();
        Intent r3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r3.setData(Uri.fromParts("package", r2.getPackageName(), null));
        r2.startActivityForResult(r3, 1);
        return;
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r4 == null) goto L16;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L16
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L17
    }

    public final void onCancel() {
        this.a.finish();
    }

    public z(TuringLiveDetectGuideActivity r1) {
        this.a = r1;
    }
}
