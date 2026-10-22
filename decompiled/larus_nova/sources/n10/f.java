package n10;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.opengame.debug.dialog.DebugMenuDialog;
import com.bytedance.live.datacontext.k;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DebugMenuDialog f516658a;

    public f(DebugMenuDialog r100) {
        this.f516658a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r101 = AnchorGameContext.a.a();
        if (r101 == null) goto L7;
        k<Boolean> r102 = r101.getOpenGamePerfUploadEvent();
        if (r102 == null) goto L7;
        r102.post(Boolean.TRUE);
    L7:
        DebugMenuDialog r103 = this.f516658a;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r105 == null) goto L21;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L10:
        if (Looper.myLooper() == r104.getLooper()) goto L12;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
