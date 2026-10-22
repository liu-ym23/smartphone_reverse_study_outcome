package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiPlayerView f256242a;

    public g(KtvMidiPlayerView r100) {
        this.f256242a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvMidiPlayerView r100 = this.f256242a;     // Catch: Throwable -> L4
        int r101 = KtvMidiPlayerView.G;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        r100.post(new h(r100, new i(r100)));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
