package com.bytedance.common.push;

import android.os.Looper;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadPlus {
    public static void runOnChildThread(Runnable r100) {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        submitRunnable(r100);
        return;
    L5:
        r100.run();
    }

    public static Future<?> submitRunnable(Runnable r100) {
        return TTExecutors.getIOThreadPool().submit(r100);
    }
}
