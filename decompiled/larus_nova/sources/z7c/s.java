package z7c;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes38.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f570837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f570838b;

    public s(q r100) {
        this.f570838b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = this.f570837a;
        long r102 = System.currentTimeMillis();
        this.f570837a = r102;
        if ((r102 - r101) >= 500) goto L5;
        return;
    L5:
        q r103 = this.f570838b;
        p.a r104 = r103.f570806d;
        if (r104 == null) goto L8;
        r104.a(TodoItemMemberRole.WRITER, q.b(r103));
    L8:
        UDDialog r105 = this.f570838b.getMDialog();
        if (r105 == null) goto L27;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r105);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r107 == null) goto L24;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r106.getLooper()) goto L15;
        r106.post(DialogLancet.createDismissRunnable(r105));
        return;
    }
}
