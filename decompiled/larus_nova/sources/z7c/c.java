package z7c;

import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f570746a;

    public c(d r100) {
        this.f570746a = r100;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
        if (r101 != 6) goto L23;
        UDDialog r103 = this.f570746a.getMDialog();
        if (r103 == null) goto L28;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r103);
        return true;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r105 == null) goto L20;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L9:
        if (Looper.myLooper() == r104.getLooper()) goto L11;
        r104.post(DialogLancet.createDismissRunnable(r103));
        return true;
    L28:
        return true;
    L23:
        return true;
    }
}
