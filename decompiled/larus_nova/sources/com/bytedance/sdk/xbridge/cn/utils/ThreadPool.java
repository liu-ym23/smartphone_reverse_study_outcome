package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class ThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f270250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f270251b = null;

    static {
        f270251b = LazyKt.lazy(ThreadPool$mainHandler$2.INSTANCE);
    }

    public static boolean a() {
        return Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(((Handler) f270251b.getValue()).getLooper()), ThreadMethodProxy.currentThread());
    }

    public static void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (f270250a != null) goto L5;
        f270250a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ls/ThreadPool"));
    L5:
        ExecutorService r101 = f270250a;
        Intrinsics.checkNotNull(r101);
        r101.submit(r100);
    }

    public static void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        ((Handler) f270251b.getValue()).post(r100);
    }
}
