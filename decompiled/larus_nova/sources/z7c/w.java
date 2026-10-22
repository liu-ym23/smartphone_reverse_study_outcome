package z7c;

import android.os.Handler;
import android.os.Looper;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements DetailTaskListSelectAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f570851a;

    public w(v r100) {
        this.f570851a = r100;
    }

    public static void c(UDDialog r100) {
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

    @Override // com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerGuid");
        u.a r101 = this.f570851a.f570842a;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        UDDialog r102 = this.f570851a.getMDialog();
        if (r102 == null) goto L9;
        c(r102);
        return;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.taskList.DetailTaskListSelectAdapter.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerName");
        u.a r101 = this.f570851a.f570842a;
        if (r101 == null) goto L5;
        r101.c(r100);
    L5:
        UDDialog r102 = this.f570851a.getMDialog();
        if (r102 == null) goto L9;
        c(r102);
        return;
    }
}
