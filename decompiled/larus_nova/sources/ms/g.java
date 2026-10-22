package ms;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.router.SmartRouter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f515454a;

    public g(a r100) {
        this.f515454a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        com.bytedance.router.i r101 = SmartRouter.buildRoute(com.bytedance.android.gamecp.common.utils.c.b(), this.f515454a.f515092c);
        r101.f267554c.putExtra("hide_nav_bar", true);
        r101.d();
        a r102 = this.f515454a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L5:
        if (Looper.myLooper() == r103.getLooper()) goto L7;
        r103.post(DialogLancet.createDismissRunnable(r102));
    }
}
