package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmSubtitleScrollHelper f436536a;

    public v(MmSubtitleScrollHelper r100) {
        this.f436536a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f436536a.f436481d.c("scrollToBottomOnInitialized");     // Catch: Throwable -> L4
        this.f436536a.m();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
