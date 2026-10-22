package ihc;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;

/* JADX INFO: loaded from: classes40.dex */
public final class k implements com.ss.android.ugc.route_monitor.impl.route_out.control.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ControlRule f489945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f489946b;

    public static void c(com.ss.android.ugc.route_monitor.impl.route_out.control.f r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.control.f.b
    public final void a(com.ss.android.ugc.route_monitor.impl.route_out.control.f r100) {
        this.f489946b.c(this.f489945a);
        c(r100);
    }

    @Override // com.ss.android.ugc.route_monitor.impl.route_out.control.f.b
    public final void b(com.ss.android.ugc.route_monitor.impl.route_out.control.f r100) {
        this.f489946b.b(this.f489945a);
        c(r100);
    }

    public k(ControlRule r100, m r101) {
        this.f489945a = r100;
        this.f489946b = r101;
    }
}
