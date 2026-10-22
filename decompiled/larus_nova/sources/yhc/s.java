package yhc;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes40.dex */
public final class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f567728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f567729b;

    public static void a(u r100) {
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f567728a == false) goto L7;
        u r101 = this.f567729b;
        r101.f567734d.j0(r101.getContext());
        a(this.f567729b);
        return;
    L7:
        if (this.f567729b.f567734d.Q() == true) goto L10;
        a(this.f567729b);
        return;
    L10:
        u r102 = this.f567729b;
        r102.f567736f = true;
        r102.f567734d.i();
        PolarisFileWrapper r103 = this.f567729b.f567734d.I();
        if (r103 == null) goto L13;
        this.f567729b.f567734d.j();
        u r104 = this.f567729b;
        r104.f567734d.L(r104.f567735e, r103);
    L14:
        this.f567729b.f567734d.p(false);
        a(this.f567729b);
        return;
    L13:
        this.f567729b.f567734d.h0(false);
        goto L14
    }

    public s(u r100, boolean r101) {
        this.f567729b = r100;
        this.f567728a = r101;
    }
}
