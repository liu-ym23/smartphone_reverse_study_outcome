package com.bytedance.applet.aibridge.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements f09.a.a {
    public final /* synthetic */ a.c a;

    public final void onCreate(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }

    public b(a.c r1) {
        this.a = r1;
    }

    public final void onPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onPreDestroyed(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (this.a.p.get() == r4) goto L5;
        return;
    L5:
        AppCompatDialog r5 = this.a.s.get();
        if (r5 == null) goto L27;
        a.c r0 = this.a;
        if (r5.isShowing() == false) goto L26;
        Handler r1 = DialogLancet.resolveDialogHandler(r5);
        if (r1 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r2 == null) goto L23;
        d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r1.getLooper()) goto L14;
        r1.post(DialogLancet.createDismissRunnable(r5));
        return;
    L26:
        a.a(r0);
        return;
    L27:
        a.c r6 = a.a;
        a.a(this.a);
    }

    public final void onResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStart(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }
}
