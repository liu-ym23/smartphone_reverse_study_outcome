package com.bytedance.ies.xbridge.utils;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ThreadPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f249554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f249555b = null;

    static {
        f249555b = LazyKt.lazy(ThreadPool$mainHandler$2.INSTANCE);
    }

    public static void a(com.bytedance.ies.xbridge.h r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (f249554a != null) goto L8;
        int r101 = Runtime.getRuntime().availableProcessors() / 2;
        if (r101 != 0) goto L7;
        r101 = 1;
    L7:
        f249554a = PThreadExecutorsUtils.newFixedThreadPool(r101, new DefaultThreadFactory("ls/ThreadPool"));
    L8:
        ExecutorService r102 = f249554a;
        Intrinsics.checkNotNull(r102);
        r102.submit(r100);
    }
}
