package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsrInputVoiceView f430273a;

    public d(AsrInputVoiceView r100) {
        this.f430273a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.larksuite.component.universe_design.toast.c r100 = this.f430273a.f430085v;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.cancel();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
