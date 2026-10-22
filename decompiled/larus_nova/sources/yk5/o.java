package yk5;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.widgets.t;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f568195c;

    public o(n r100) {
        this.f568195c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        n r101 = this.f568195c;
        r101.f568129b = true;
        sk5.d.b r102 = r101.f568137j;
        if (r102 == null) goto L5;
        ((vk5.b) r102).b();
    L5:
        n r103 = this.f568195c;
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
