package lm3;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f509889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f509890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f509891c;

    public g(d r100, List r101, int r102) {
        this.f509889a = r100;
        this.f509890b = r101;
        this.f509891c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c.a r101 = ((c) ListProtector.get(this.f509890b, this.f509891c)).f509865c;
        if (r101 == null) goto L6;
        r101.onAction(this.f509889a);
    L6:
        if (((c) ListProtector.get(this.f509890b, this.f509891c)).f509863a == false) goto L24;
        d r102 = this.f509889a;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r102);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r104 == null) goto L21;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r103.getLooper()) goto L12;
        r103.post(DialogLancet.createDismissRunnable(r102));
        return;
    }
}
