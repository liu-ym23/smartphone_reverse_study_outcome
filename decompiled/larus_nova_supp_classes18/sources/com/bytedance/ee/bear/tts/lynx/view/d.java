package com.bytedance.ee.bear.tts.lynx.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements Runnable {
    public final /* synthetic */ TtsLynxPlaylistView a;

    public d(TtsLynxPlaylistView r1) {
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
        this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r0 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r0 == null) goto L15;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L15
    }
}
