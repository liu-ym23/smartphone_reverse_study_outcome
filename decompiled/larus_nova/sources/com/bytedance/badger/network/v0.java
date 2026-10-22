package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes47.dex */
public final class v0 implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199155a;

    public v0(String r100) {
        this.f199155a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "badger-delay-" + this.f199155a + '-' + z0.f199164g.getAndIncrement());
        if (r101.isDaemon() == false) goto L6;
        r101.setDaemon(false);
    L6:
        if (r101.getPriority() == 5) goto L8;
        ThreadMethodProxy.setPriority(r101, 5);
    L8:
        return r101;
    }
}
