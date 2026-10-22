package hi5;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.search.dto.UserGroupScene;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x.a f485329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Dialog f485330b;

    @Override // hi5.y.a
    public final /* synthetic */ void QF() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        x.a r101 = this.f485329a;
        if (r101 == null) goto L21;
        Dialog r102 = this.f485330b;
        t r103 = (t) r101;
        x.g(r103.f485331a, r103.f485332b);
        com.bytedance.ee.bear.middleground.permission.c.w(r103.f485333c, r103.f485334d, "real_name_link", UserGroupScene.DEFAULT_NAME_SPACE);
        Handler r104 = DialogLancet.resolveDialogHandler(r102);
        if (r104 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r105 == null) goto L18;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L7:
        if (Looper.myLooper() == r104.getLooper()) goto L9;
        r104.post(DialogLancet.createDismissRunnable(r102));
        return;
    }

    public s(t r100, UDDialog r101) {
        this.f485329a = r100;
        this.f485330b = r101;
    }
}
