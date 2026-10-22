package yk5;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f568173c;

    public i(g r100) {
        this.f568173c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        g r101 = this.f568173c;
        r101.f568129b = true;
        sk5.d.b r102 = r101.f568137j;
        if (r102 == null) goto L5;
        ((vk5.b) r102).b();
    L5:
        Handler r103 = DialogLancet.resolveDialogHandler(r101);
        if (r103 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r101);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r104 == null) goto L19;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L8:
        if (Looper.myLooper() == r103.getLooper()) goto L10;
        r103.post(DialogLancet.createDismissRunnable(r101));
    }
}
