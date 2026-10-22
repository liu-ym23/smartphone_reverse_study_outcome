package com.bytedance.ee.bear.tts.lynx.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TtsLynxPlaylistView f239650a;

    public d(TtsLynxPlaylistView r100) {
        this.f239650a = r100;
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
        this.f239650a.dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L10
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r100 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r100 == null) goto L15;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        goto L15
    }
}
