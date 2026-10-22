package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes22.dex */
public class StackLeakChecker {
    public static final long CHECK_INTERVAL_10_SEC = 10000000;
    private static final int LEAK_THREAD_THRESHOLD = 10;
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mCheckerEnabled = false;
    private static ArrayList<StackLeakItem> mLeakList = null;
    private static int mLeakThreadThreshold = 10;
    private static ArrayList<StackLeakListener> mListeners = null;
    private static long mStackCheckInterval = 60000000;

    public interface StackLeakListener {
        void onLeakReport(ArrayList<StackLeakItem> r100);
    }

    private StackLeakChecker() {
    }

    private static native boolean setEnable(boolean r100, int r101, int r102, long r103, String[] r104);

    static {
        mLeakList = new ArrayList();
        mListeners = new ArrayList();
    }

    public static synchronized void disableChecker() {
        monitor-enter(StackLeakChecker.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L7;
        setEnable(false, 0, 0, 0, null);     // Catch: Throwable -> L9
    L7:
        monitor-exit(StackLeakChecker.class);
    }

    private static void reportLeak() {
        Iterator<StackLeakListener> r100 = mListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onLeakReport(mLeakList);
        goto L4
    L6:
        mLeakList.clear();
    }

    private static boolean loadOptimizerOnNeed(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 23) goto L5;
        return false;
    L5:
        if (r101 <= 29) goto L8;
        return false;
    L8:
        return SysOptimizer.loadOptimizerLibrary(r100);
    }

    public static synchronized void registerStackLeakListener(StackLeakListener r100) {
        monitor-enter(StackLeakChecker.class);
        if (r100 != null) goto L12;
    L10:
        monitor-exit(StackLeakChecker.class);
        return;
    L12:
        mListeners.add(r100);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean enableChecker(Context r100, String[] r101) {
        monitor-enter(StackLeakChecker.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (mCheckerEnabled == false) goto L11;
        monitor-exit(StackLeakChecker.class);
        return true;
    L11:
        if (loadOptimizerOnNeed(r100) == true) goto L23;
        monitor-exit(StackLeakChecker.class);
        return false;
    L23:
        boolean r102 = setEnable(true, Build.VERSION.SDK_INT, mLeakThreadThreshold, mStackCheckInterval, r101);     // Catch: UnsatisfiedLinkError -> L16 Throwable -> L20
        mCheckerEnabled = r102;     // Catch: UnsatisfiedLinkError -> L16 Throwable -> L20
        monitor-exit(StackLeakChecker.class);
        return r102;
    L17:
        return false;
    }

    public static synchronized void setInterval(int r100, long r101) {
        monitor-enter(StackLeakChecker.class);
        if (r100 <= 0) goto L6;
        int r102 = r100;
    L19:
        mLeakThreadThreshold = r102;     // Catch: Throwable -> L16
        if (r101 <= CHECK_INTERVAL_10_SEC) goto L10;
        long r103 = (r101 / CHECK_INTERVAL_10_SEC) * CHECK_INTERVAL_10_SEC;     // Catch: Throwable -> L16
    L11:
        mStackCheckInterval = r103;     // Catch: Throwable -> L16
        if (mCheckerEnabled == false) goto L14;
        setEnable(true, 0, r102, r103, null);     // Catch: Throwable -> L16
    L14:
        monitor-exit(StackLeakChecker.class);
        return;
    L10:
        r103 = 10000000;
    L16:
        th = move-exception;
        throw th;
    L6:
        r102 = 10;
        goto L19
    }

    private static void addLeakItem(int r110, long r111, long r112, long r113, String r114, String r210) {
        mLeakList.add(new StackLeakItem(r110, r111, r112, r113, r114, r210));
    }
}
