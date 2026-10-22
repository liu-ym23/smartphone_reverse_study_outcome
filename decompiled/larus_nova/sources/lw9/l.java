package lw9;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes31.dex */
public final class l implements mn7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f511095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<l0> f511096b;

    @Override // mn7.a
    public final void a() {
    }

    @Override // mn7.a
    public final void b() {
    }

    @Override // mn7.a
    public final void dismiss() {
        l0 r100 = this.f511096b.element;
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.larus.common_ui.dialog.l0] */
    @Override // mn7.a
    public final void show() {
        if (this.f511095a == null) goto L15;
        Ref.ObjectRef<l0> r100 = this.f511096b;
        r100.element = new l0(this.f511095a, 0.0f, false, 6);
        l0 r101 = this.f511096b.element;
        if (r101 != null) goto L7;
        return;
    L7:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        return;
    }

    public l(Activity r100, Ref.ObjectRef<l0> r101) {
        this.f511095a = r100;
        this.f511096b = r101;
    }
}
