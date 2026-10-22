package com.bytedance.pia.core.worker.binding;

import android.content.Context;
import com.bytedance.pia.core.worker.a;
import com.bytedance.vmsdk.jsbridge.JSMethod;
import com.bytedance.vmsdk.jsbridge.JSModule;

/* JADX INFO: loaded from: classes21.dex */
public class WarmupModule extends JSModule {
    public static final String NAME = "WarmupModule";
    private final a worker;

    @JSMethod
    public void finishWarmup() {
        a r100 = this.worker;
        monitor-enter(r100);
        r100.f266463h = System.currentTimeMillis();     // Catch: Throwable -> L9
        r100.f266459d = true;     // Catch: Throwable -> L9
        if (r100.f266460e == null) goto L7;
        r100.f266460e.run();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public WarmupModule(Context r100, Object r101) {
        super(r100, r101);
        this.worker = (a) r101;
    }
}
