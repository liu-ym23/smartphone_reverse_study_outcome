package i8c;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.dependent.dialog.TaskDependentDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f488746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskDependentDialog f488747b;

    public g(TaskDependentDialog r100) {
        this.f488747b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f488746a;
        long r102 = System.currentTimeMillis();
        this.f488746a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        this.f488747b.f443076b.b();
        TaskDependentDialog r103 = this.f488747b;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r105 == null) goto L19;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L8:
        if (Looper.myLooper() == r104.getLooper()) goto L10;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
