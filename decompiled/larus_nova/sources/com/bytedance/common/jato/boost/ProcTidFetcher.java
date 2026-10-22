package com.bytedance.common.jato.boost;

import android.os.Process;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes15.dex */
public class ProcTidFetcher {
    private static long sStartTime;

    public interface IFetcher {
        void onError(Throwable r100);

        void onFetch(int r100);
    }

    public ProcTidFetcher() {
    }

    private static native int nativeGetRenderThreadTid(int r100);

    public static void getTid(IFetcher r100) {
        sStartTime = System.currentTimeMillis();     // Catch: Throwable -> L11
    L4:
        if ((System.currentTimeMillis() - sStartTime) >= 1000) goto L5;
        int r101 = nativeGetRenderThreadTid(Process.myPid());     // Catch: Throwable -> L11
        if (r101 > 0) goto L8;
        Thread.sleep(100);     // Catch: Throwable -> L11
        goto L4
    L8:
        r100.onFetch(r101);     // Catch: Throwable -> L11
        return;
    L5:
        r100.onError(new TimeoutException("too long to fetch renderthread tid"));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        r100.onError(th);
    }
}
