package com.huawei.hms.aaid.threads;

import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.o;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AsyncExec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f276833a = null;

    public AsyncExec() {
    }

    static {
        f276833a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("SeqIO"), new ThreadPoolExecutor.AbortPolicy());
    }

    public static void submitSeqIO(Runnable r100) {
        f276833a.execute(new o(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.toString();
    }
}
