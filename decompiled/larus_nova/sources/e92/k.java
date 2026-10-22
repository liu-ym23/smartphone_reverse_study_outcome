package e92;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f471462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f471463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f471464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f471465d;

    public k(Context r100) {
        this.f471465d = r100;
        this.f471463b = new CompositeDisposable();
    }

    public static void a(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }
}
