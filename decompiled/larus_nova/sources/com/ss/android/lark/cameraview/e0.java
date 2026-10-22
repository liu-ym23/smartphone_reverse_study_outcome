package com.ss.android.lark.cameraview;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureLayout f410974a;

    public e0(CaptureLayout r100) {
        this.f410974a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f410974a.f410811e;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("btnCapture");     // Catch: Throwable -> L7
        r100 = null;
    L5:
        r100.setEnabled(true);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
