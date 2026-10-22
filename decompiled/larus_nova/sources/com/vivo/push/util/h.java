package com.vivo.push.util;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes41.dex */
final class h implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f462578a;

    public h(String r100) {
        this.f462578a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "o/push/util/h");
        ThreadMethodProxy.setName(r101, this.f462578a);
        r101.setDaemon(true);
        return r101;
    }
}
