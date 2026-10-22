package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.view.MotionEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DisplayMode;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioPanelInnerView f429938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MotionEvent f429939b;

    public g(AudioPanelInnerView r100, MotionEvent r101) {
        this.f429938a = r100;
        this.f429939b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioPanelInnerView r100 = this.f429938a;     // Catch: Throwable -> L4
        r100.f429912g = false;     // Catch: Throwable -> L4
        r100.getParent().requestDisallowInterceptTouchEvent(true);     // Catch: Throwable -> L4
        this.f429939b.setAction(0);     // Catch: Throwable -> L4
        AudioPanelInnerView r101 = this.f429938a;     // Catch: Throwable -> L4
        h.o(r101.f429906a, AudioPluginEnums$DisplayMode.COMPLETE, this.f429939b, AudioPanelInnerView.S5(r101), AudioPanelInnerView.R5(this.f429938a), 16);     // Catch: Throwable -> L4
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
