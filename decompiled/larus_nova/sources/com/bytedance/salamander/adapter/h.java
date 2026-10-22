package com.bytedance.salamander.adapter;

import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f267782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f267783b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "PriorityThreadFactory");
        Process.setThreadPriority(this.f267782a);
        ThreadMethodProxy.setName(r101, this.f267783b);
        r101.setDaemon(true);
        return r101;
    }

    public h(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f267782a = r100;
        this.f267783b = r101;
    }
}
