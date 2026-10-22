package com.bytedance.ies.xbridge.base.runtime.thread;

import android.os.Handler;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f249450a = null;

    static {
        f249450a = LazyKt.lazy(ThreadUtils$mainThreadHandler$2.INSTANCE);
    }

    public static final Handler a() {
        return (Handler) f249450a.getValue();
    }
}
