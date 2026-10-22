package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ThreadUtils {
    private static Field groupField = null;
    private static Thread mainThread = null;
    private static ThreadGroup mainThreadGroup = null;
    private static boolean threadGroupFetchable = true;

    public ThreadUtils() {
    }

    private static ThreadGroup getThreadGroup(Thread r1, boolean r2) {
        if (r2 == false) goto L8;
        ThreadGroup r3 = mainThreadGroup;
        if (r3 != null) goto L19;
        ThreadGroup r4 = r1.getThreadGroup();
        mainThreadGroup = r4;
        return r4;
    L19:
        return r3;
    L8:
        if (threadGroupFetchable == false) goto L16;
        if (groupField == null) goto L17;
    L12:
        return (ThreadGroup) groupField.get(r1);
    L14:
        threadGroupFetchable = false;
        goto L16
    L17:
        Field r5 = Thread.class.getDeclaredField("group");     // Catch: Exception -> L14
        r5.setAccessible(true);     // Catch: Exception -> L14
        groupField = r5;     // Catch: Exception -> L14
    L16:
        return r1.getThreadGroup();
    }

    public static ThreadGroup getThreadInitGroup(ThreadGroup r1) {
        if (SuperThreadPool.INSTANCE.getEnableThreadGroupOpt() == true) goto L5;
        return r1;
    L5:
        if (r1 == null) goto L7;
        return r1;
    L7:
        Thread r2 = Thread.currentThread();
        return getThreadGroup(r2, isMainThread(r2));
    }

    public static boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    private static boolean isMainThread(Thread r1) {
        Thread r0 = mainThread;
        if (r0 != null) goto L5;
        r0 = Looper.getMainLooper().getThread();
        mainThread = r0;
    L5:
        if (r0 != r1) goto L7;
        return true;
    L7:
        return false;
    }
}
