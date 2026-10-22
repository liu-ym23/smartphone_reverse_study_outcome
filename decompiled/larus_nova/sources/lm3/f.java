package lm3;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f509887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f509888b;

    public f(d r100, List r101) {
        this.f509887a = r100;
        this.f509888b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c.a r101 = ((c) ListProtector.get(this.f509888b, 1)).f509865c;
        if (r101 == null) goto L6;
        r101.onAction(this.f509887a);
    L6:
        if (((c) ListProtector.get(this.f509888b, 1)).f509863a == false) goto L24;
        d r102 = this.f509887a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
