package com.obric.assistant.view.glowui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f394284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OverlayerAudioView f394285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f394286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f394287d;

    public u(OverlayerAudioView r100, OverlayerAudioView r101, int r102, j r103) {
        this.f394284a = r100;
        this.f394285b = r101;
        this.f394286c = r102;
        this.f394287d = r103;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverlayerAudioView r100 = this.f394285b;     // Catch: Throwable -> L4
        r100.postOnAnimation(new v(r100, this.f394286c, this.f394287d));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
