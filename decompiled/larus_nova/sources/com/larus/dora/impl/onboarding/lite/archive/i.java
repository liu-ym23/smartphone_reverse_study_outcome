package com.larus.dora.impl.onboarding.lite.archive;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomBarCountAudioVisualizer f336954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f336955b;

    public i(CustomBarCountAudioVisualizer r100, byte[] r101) {
        this.f336954a = r100;
        this.f336955b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f336954a.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        this.f336954a.setAudioData(this.f336955b);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r100 = false;
        goto L6
    }
}
