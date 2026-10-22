package zv8;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.larus.utils.t0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes26.dex */
public abstract class j extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f573754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearLayout f573755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Space f573756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f573757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewStub f573758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f573759h;

    public abstract int h();

    @Override // zv8.a
    public final void f() {
        t0.c(new f(this));
    }

    @Override // zv8.a, zv8.e
    public final void a() {
        super.a();
        b r100 = this.f573754c;
        if (r100 == null) goto L5;
        g(r100);
    L5:
        this.f573754c = null;
    }

    public j() {
    }

    public static void g(b r100) {
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
}
