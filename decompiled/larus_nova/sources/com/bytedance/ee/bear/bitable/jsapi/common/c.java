package com.bytedance.ee.bear.bitable.jsapi.common;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f214391a = null;

    static {
        f214391a = new c();
    }

    public c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(AudioRecordHelper.f214334e);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
