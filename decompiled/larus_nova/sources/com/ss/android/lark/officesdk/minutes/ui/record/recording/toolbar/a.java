package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmRecordingAINoteToolBarView f436658a;

    public a(MmRecordingAINoteToolBarView r100) {
        this.f436658a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MmRecordingAINoteToolBarView r100 = this.f436658a;     // Catch: Throwable -> L7
        mwb.c r101 = r100.f436624a;     // Catch: Throwable -> L7
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");     // Catch: Throwable -> L7
        r101 = null;
    L5:
        r100.Z5(r101.f516038f.getWidth());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
