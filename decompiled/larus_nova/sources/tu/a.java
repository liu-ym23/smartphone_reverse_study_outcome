package tu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uu.b f547588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f547589b;

    public a(uu.b r100, Ref.ObjectRef r101) {
        this.f547588a = r100;
        this.f547589b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        uu.b r102 = this.f547588a;
        if (r102 == null) goto L5;
        r102.execute();
    L5:
        Dialog r103 = (Dialog) this.f547589b.element;
        if (r103 == null) goto L24;
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
        return;
    }
}
