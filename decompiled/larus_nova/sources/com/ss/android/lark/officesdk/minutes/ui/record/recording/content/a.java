package com.ss.android.lark.officesdk.minutes.ui.record.recording.content;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingContentController f436324a;

    public a(MmRecordingContentController r100) {
        this.f436324a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmRecordingContentController.a(this.f436324a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
