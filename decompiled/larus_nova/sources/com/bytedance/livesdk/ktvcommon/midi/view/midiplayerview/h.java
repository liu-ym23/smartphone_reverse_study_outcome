package com.bytedance.livesdk.ktvcommon.midi.view.midiplayerview;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiPlayerView f256243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f256244b;

    public h(KtvMidiPlayerView r100, i r101) {
        this.f256243a = r100;
        this.f256244b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.f256243a.getViewTreeObserver().isAlive() == false) goto L9;
        this.f256243a.getViewTreeObserver().addOnGlobalLayoutListener(this.f256244b);     // Catch: Throwable -> L6
        return;
    }
}
