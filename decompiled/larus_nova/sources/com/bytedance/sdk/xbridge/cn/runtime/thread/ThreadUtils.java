package com.bytedance.sdk.xbridge.cn.runtime.thread;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270141a = null;

    static {
        f270141a = LazyKt.lazy(ThreadUtils$mainThreadHandler$2.INSTANCE);
    }

    public static final Handler a() {
        return (Handler) f270141a.getValue();
    }
}
