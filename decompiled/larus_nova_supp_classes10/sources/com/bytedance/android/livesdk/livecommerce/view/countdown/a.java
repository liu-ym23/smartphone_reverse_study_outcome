package com.bytedance.android.livesdk.livecommerce.view.countdown;

import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ ScreenshotCountDownDialog a;
    public final /* synthetic */ Animation b;

    public a(ScreenshotCountDownDialog r1, Animation r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Long r5 = (Long) r4;
        TextView r6 = this.a.a;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L5:
        r6.setText(String.valueOf(this.a.c));
        this.b.reset();
        TextView r7 = this.a.a;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("countdownTextView");
    L8:
        r7.startAnimation(this.b);
        ScreenshotCountDownDialog r8 = this.a;
        if (r8.c > 0) goto L30;
        Disposable r9 = r8.b;
        if (r9 == null) goto L13;
        r9.dispose();
    L13:
        this.a.d.invoke();
        ScreenshotCountDownDialog r10 = this.a;
        Handler r0 = DialogLancet.resolveDialogHandler(r10);
        if (r0 != null) goto L16;
    L18:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L21 Exception -> L23
    L27:
        DialogLancet.afterDialogDismiss(r10);
        goto L30
    L21:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L23:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L21
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L21
        if (r1 == null) goto L27;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L21
        goto L27
    L16:
        if (Looper.myLooper() == r0.getLooper()) goto L18;
        r0.post(DialogLancet.createDismissRunnable(r10));
    L30:
        this.a.c--;
    }
}
