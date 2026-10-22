package com.larksuite.framework.callback;

import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes24.dex */
public class UICallbackExecutor {
    private static a executor;
    private static WeakHashMap<Runnable, WeakReference<Runnable>> runnableMap;
    private static final Handler sHandler = null;

    public UICallbackExecutor() {
    }

    static {
        sHandler = new Handler(Looper.getMainLooper());
        runnableMap = new WeakHashMap();
    }

    private static void initIfNeed() {
        if (executor == null) goto L5;
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (executor != null) goto L9;
        executor = new a(sHandler);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    }

    public static void execute(Runnable r100) {
        initIfNeed();
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        r100.run();
        return;
    L5:
        executor.a(toTraceable(r100));
    }

    public static void post(Runnable r100) {
        initIfNeed();
        executor.a(toTraceable(r100));
    }

    public static void removeCallbacks(Runnable r100) {
        monitor-enter(UICallbackExecutor.class);
        WeakReference<Runnable> r101 = runnableMap.remove(r100);     // Catch: Throwable -> L18
        if (r101 != null) goto L8;
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L18
        return;
    L8:
        Runnable r102 = r101.get();     // Catch: Throwable -> L18
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L18
        if (r102 == null) goto L22;
        a r103 = executor;
        if (r103 == null) goto L24;
        Handler r104 = r103.f285564a;
        if (r104 == null) goto L23;
        r104.removeCallbacks(r102);
        return;
    L23:
        return;
    L24:
        return;
    L22:
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private static Runnable toTraceable(Runnable r100) {
        Function<? super Runnable, ? extends Runnable> r101 = b.f285565a;
        if (r101 == null) goto L5;
        Runnable r102 = r101.apply(r100);
    L7:
        monitor-enter(UICallbackExecutor.class);
        runnableMap.put(r100, new WeakReference(r102));     // Catch: Throwable -> L11
        monitor-exit(UICallbackExecutor.class);     // Catch: Throwable -> L11
        return r102;
    L11:
        th = move-exception;
        throw th;
    L5:
        r102 = r100;
        goto L7
    }

    public static void executeDelayed(Runnable r100, long r101) {
        initIfNeed();
        executor.b(toTraceable(r100), r101);
    }
}
