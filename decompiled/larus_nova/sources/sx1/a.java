package sx1;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.livesdk.sharedpref.f;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f543793a;

    public a(c r100) {
        this.f543793a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f543793a.a("no_wifi_continue");
        c r101 = this.f543793a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r101);
    L17:
        com.bytedance.android.livesdk.sharedpref.e<Long> r103 = com.bytedance.android.livesdk.sharedpref.b.f158133d0;
        Long r104 = Long.valueOf(System.currentTimeMillis());
        r103.getClass();
        f.d(r103, r104);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r105 == null) goto L16;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L5:
        if (Looper.myLooper() == r102.getLooper()) goto L7;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L17
    }
}
