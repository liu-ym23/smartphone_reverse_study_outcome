package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436102a;

    public o(MmAINotePanelAnimator r100) {
        this.f436102a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmAINotePanelAnimator r100 = this.f436102a;     // Catch: Throwable -> L4
        r100.G = SystemClock.uptimeMillis() + 700;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
