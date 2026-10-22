package com.bytedance.salamander.adapter;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements ThreadFactory {
    public final int a;
    public final String b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "r");
        PthreadThreadV2 r0 = new PthreadThreadV2(r3, "PriorityThreadFactory");
        Process.setThreadPriority(this.a);
        ThreadMethodProxy.setName(r0, this.b);
        r0.setDaemon(true);
        return r0;
    }

    public h(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        this.a = r2;
        this.b = r3;
    }
}
