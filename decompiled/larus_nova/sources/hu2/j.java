package hu2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.livesdk.utils.c7;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class j implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f487226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f487227b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Throwable r101 = r100;
        if (this.f487226a.isShowing() == false) goto L21;
        ProgressDialog r102 = this.f487226a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r104 == null) goto L18;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L7:
        if (Looper.myLooper() == r103.getLooper()) goto L9;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L21:
        ExceptionUtils.handleException(this.f487227b, r101);
    }

    public j(c7 r100, Activity r101) {
        this.f487226a = r100;
        this.f487227b = r101;
    }
}
