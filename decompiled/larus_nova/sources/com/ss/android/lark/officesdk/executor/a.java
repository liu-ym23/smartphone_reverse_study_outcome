package com.ss.android.lark.officesdk.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f433204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f433205b;

    public a(int r100) {
        this.f433205b = r100;
        this.f433204a = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Thread r101 = this.f433204a.newThread(r100);
        ThreadMethodProxy.setPriority(r101, this.f433205b);
        ThreadMethodProxy.setName(r101, "OfficeSDK_HighPrioritySingleThread");
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
