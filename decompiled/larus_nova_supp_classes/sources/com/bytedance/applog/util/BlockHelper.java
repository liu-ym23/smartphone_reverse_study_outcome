package com.bytedance.applog.util;

import android.os.SystemClock;
import com.bytedance.applog.log.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class BlockHelper {
    public static long a = 100;
    public static volatile boolean b = false;
    public static volatile long c = -1;
    public static volatile boolean enableBlock = true;

    public BlockHelper() {
    }

    public static void beginBlock() {
        b = true;
        c = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        b = false;
        c = -1;
    }

    public static void tryBlock() {
        if (enableBlock == true) goto L6;
        return;
    L6:
        if (b == false) goto L16;
        if (b == false) goto L6;
        if (Math.abs(SystemClock.elapsedRealtime() - c) < 10000) goto L11;
        endBlock();     // Catch: InterruptedException -> L14
        goto L6
    L11:
        Thread.sleep(a);     // Catch: InterruptedException -> L14
    L14:
        e = move-exception;
        n.w().q("BlockHelper: block interrupted!", e, new Object[0]);
        goto L6
    }

    public static long getBlockInterval() {
        return a;
    }

    public static void setBlockInterval(long r2) {
        a = Math.max(r2, 1);
    }

    public static void setEnableBlock(boolean r0) {
        enableBlock = r0;
    }
}
