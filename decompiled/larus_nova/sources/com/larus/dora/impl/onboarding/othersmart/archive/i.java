package com.larus.dora.impl.onboarding.othersmart.archive;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomBarCountAudioVisualizer f337126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ byte[] f337127b;

    public i(CustomBarCountAudioVisualizer r100, byte[] r101) {
        this.f337126a = r100;
        this.f337127b = r101;
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
        if (this.f337126a.getVisibility() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        this.f337126a.setAudioData(this.f337127b);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r100 = false;
        goto L6
    }
}
