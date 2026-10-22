package com.bytedance.livesdk.ktvcommon.midi.view;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes20.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMidiView f256088a;

    public g(KtvMidiView r100) {
        this.f256088a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KtvMidiView r100 = this.f256088a;     // Catch: Throwable -> L4
        int r101 = KtvMidiView.f256049i;     // Catch: Throwable -> L4
        r100.getViewTreeObserver().addOnGlobalLayoutListener(new h(r100));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
