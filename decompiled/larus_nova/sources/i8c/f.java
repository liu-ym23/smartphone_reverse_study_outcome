package i8c;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.dependent.dialog.TaskDependentDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f488744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskDependentDialog f488745b;

    public f(TaskDependentDialog r100) {
        this.f488745b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f488744a;
        long r102 = System.currentTimeMillis();
        this.f488744a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        TaskDependentDialog r103 = this.f488745b;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r103);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r105 == null) goto L19;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r104.getLooper()) goto L10;
        r104.post(DialogLancet.createDismissRunnable(r103));
    }
}
