package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CoreThreadPool f433827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ExecutorService f433828b;

    static {
        f433827a = CoreThreadPool.getDefault();
    }
}
