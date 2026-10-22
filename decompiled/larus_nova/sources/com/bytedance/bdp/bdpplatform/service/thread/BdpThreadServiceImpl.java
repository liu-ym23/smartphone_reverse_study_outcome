package com.bytedance.bdp.bdpplatform.service.thread;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdp.bdpbase.util.BdpThreadUtil;
import com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class BdpThreadServiceImpl implements BdpThreadService {
    public BdpThreadServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final boolean X() {
        BdpThreadUtil.b r100 = BdpThreadUtil.f201318e;
        if (r100.getPoolSize() <= r100.getActiveCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final int u2() {
        return BdpThreadUtil.f201317d.prestartAllCoreThreads();
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final boolean x0() {
        PThreadPoolExecutor r100 = BdpThreadUtil.f201317d;
        if (r100.getPoolSize() <= r100.getActiveCount()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final void c(Runnable r100) {
        Handler r101 = BdpThreadUtil.f201314a;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        BdpThreadUtil.f201314a.post(r100);
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final void executeCPU(Runnable r100) {
        BdpThreadUtil.f201317d.execute(r100);
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.thread.BdpThreadService
    public final void executeIO(Runnable r100) {
        BdpThreadUtil.f201318e.execute(r100);
    }
}
