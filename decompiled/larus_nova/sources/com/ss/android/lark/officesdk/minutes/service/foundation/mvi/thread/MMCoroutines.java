package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MMCoroutines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f433826a = null;

    static {
        f433826a = LazyKt.lazy(MMCoroutines$coreThreadPool$2.INSTANCE);
    }

    public static ExecutorCoroutineDispatcher a() {
        return ExecutorsKt.from(a.f433827a.getCachedThreadPool());
    }

    public static ExecutorCoroutineDispatcher b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "threadPoolName");
        CoreThreadPool r101 = a.f433827a;
        Intrinsics.checkNotNullParameter(r100, "threadPoolName");
        return ExecutorsKt.from(a.f433827a.getSingleScheduledThreadPool(r100));
    }
}
