package com.xiaomi.push;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public class cw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f463314a;

    public static void a(Context r100) {
    }

    static {
        f463314a = new PThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("iaomi/push/cw"));
    }
}
