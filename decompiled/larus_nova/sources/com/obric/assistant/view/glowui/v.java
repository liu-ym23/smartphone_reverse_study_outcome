package com.obric.assistant.view.glowui;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OverlayerAudioView f394288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f394289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f394290c;

    public v(OverlayerAudioView r100, int r101, Function0<Unit> r102) {
        this.f394288a = r100;
        this.f394289b = r101;
        this.f394290c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverlayerAudioView r100 = this.f394288a;     // Catch: Throwable -> L4
        int r101 = this.f394289b;     // Catch: Throwable -> L4
        Function0<Unit> r102 = this.f394290c;     // Catch: Throwable -> L4
        float[] r103 = OverlayerAudioView.B;     // Catch: Throwable -> L4
        r100.g(r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
