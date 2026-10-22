package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.SuperThreadPool;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ThreadUtils {
    private static Field groupField = null;
    private static Thread mainThread = null;
    private static ThreadGroup mainThreadGroup = null;
    private static boolean threadGroupFetchable = true;

    public ThreadUtils() {
    }

    private static ThreadGroup getThreadGroup(Thread r100, boolean r101) {
        if (r101 == false) goto L8;
        ThreadGroup r102 = mainThreadGroup;
        if (r102 != null) goto L19;
        ThreadGroup r103 = r100.getThreadGroup();
        mainThreadGroup = r103;
        return r103;
    L19:
        return r102;
    L8:
        if (threadGroupFetchable == false) goto L16;
        if (groupField == null) goto L17;
    L12:
        return (ThreadGroup) groupField.get(r100);
    L14:
        threadGroupFetchable = false;
        goto L16
    L17:
        Field r104 = Thread.class.getDeclaredField("group");     // Catch: Exception -> L14
        r104.setAccessible(true);     // Catch: Exception -> L14
        groupField = r104;     // Catch: Exception -> L14
    L16:
        return r100.getThreadGroup();
    }

    public static ThreadGroup getThreadInitGroup(ThreadGroup r100) {
        if (SuperThreadPool.INSTANCE.getEnableThreadGroupOpt() == true) goto L5;
        return r100;
    L5:
        if (r100 == null) goto L7;
        return r100;
    L7:
        Thread r101 = Thread.currentThread();
        return getThreadGroup(r101, isMainThread(r101));
    }

    public static boolean isMainThread() {
        return isMainThread(Thread.currentThread());
    }

    private static boolean isMainThread(Thread r100) {
        Thread r101 = mainThread;
        if (r101 != null) goto L5;
        r101 = Looper.getMainLooper().getThread();
        mainThread = r101;
    L5:
        if (r101 != r100) goto L7;
        return true;
    L7:
        return false;
    }
}
