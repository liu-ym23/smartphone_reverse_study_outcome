package com.bytedance.ee.bear.tts.lynx.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements Runnable {
    public final /* synthetic */ TtsLynxModalControllerView a;

    public c(TtsLynxModalControllerView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L18:
        this.a.dismiss();     // Catch: Exception -> L5 Throwable -> L10
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r0 == null) goto L15;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L15
    }
}
