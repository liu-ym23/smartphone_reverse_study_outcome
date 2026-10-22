package com.bytedance.applog.util;

import android.os.SystemClock;
import com.bytedance.applog.log.n;

/* JADX INFO: loaded from: classes.dex */
public class BlockHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f192845a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f192846b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f192847c = -1;
    public static volatile boolean enableBlock = true;

    public BlockHelper() {
    }

    public static void beginBlock() {
        f192846b = true;
        f192847c = SystemClock.elapsedRealtime();
    }

    public static void endBlock() {
        f192846b = false;
        f192847c = -1;
    }

    public static void tryBlock() {
        if (enableBlock == true) goto L6;
        return;
    L6:
        if (f192846b == false) goto L16;
        if (f192846b == false) goto L6;
        if (Math.abs(SystemClock.elapsedRealtime() - f192847c) < 10000) goto L11;
        endBlock();     // Catch: InterruptedException -> L14
        goto L6
    L11:
        Thread.sleep(f192845a);     // Catch: InterruptedException -> L14
    L14:
        e = move-exception;
        n.w().q("BlockHelper: block interrupted!", e, new Object[0]);
        goto L6
    }

    public static long getBlockInterval() {
        return f192845a;
    }

    public static void setBlockInterval(long r100) {
        f192845a = Math.max(r100, 1);
    }

    public static void setEnableBlock(boolean r100) {
        enableBlock = r100;
    }
}
