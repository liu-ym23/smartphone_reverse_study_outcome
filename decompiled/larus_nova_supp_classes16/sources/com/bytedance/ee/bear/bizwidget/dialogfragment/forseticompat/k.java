package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements ComponentCallbacks {
    public final /* synthetic */ Ref.IntRef a;
    public final /* synthetic */ Ref.IntRef b;
    public final /* synthetic */ Dialog c;

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        if (r5.orientation == this.a.element) goto L5;
    L6:
        Dialog r0 = this.c;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r0);
    L21:
        Ref.IntRef r2 = this.a;
        r2.element = r5.orientation;
        Ref.IntRef r3 = this.b;
        r3.element = r5.screenLayout;
        return;
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r4 == null) goto L20;
        com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        goto L20
    L9:
        if (Looper.myLooper() == r1.getLooper()) goto L11;
        r1.post(DialogLancet.createDismissRunnable(r0));
        goto L21
    L5:
        if (r5.screenLayout != this.b.element) goto L6;
    }

    public k(Ref.IntRef r1, Ref.IntRef r2, Dialog r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
