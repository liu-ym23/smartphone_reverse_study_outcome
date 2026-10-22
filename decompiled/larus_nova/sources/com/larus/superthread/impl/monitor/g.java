package com.larus.superthread.impl.monitor;

import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements IThreadMonitor {
    public g() {
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor
    public final void onThreadRunning(Thread r100) {
        Intrinsics.checkNotNullParameter(r100, "thread");
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor
    public final void afterLooperPrepared(Thread r100) {
        IThreadMonitor.DefaultImpls.afterLooperPrepared(this, r100);
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor
    public final void onThreadExit(Thread r100) {
        Intrinsics.checkNotNullParameter(r100, "thread");
        r100.getName();
        r100.getId();
        AppHost.f326268a.isDebug();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.convergence.external.IThreadMonitor
    public final void onThreadStart(Thread r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "thread");
        r100.getName();
        r100.getId();
        AppHost.f326268a.isDebug();
    }
}
