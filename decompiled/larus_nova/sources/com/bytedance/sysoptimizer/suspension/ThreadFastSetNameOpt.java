package com.bytedance.sysoptimizer.suspension;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadFastSetNameOpt {
    private static final String TAG = "ThreadFastSetNameOpt";
    private static final AtomicBoolean mInitFlag = null;

    public ThreadFastSetNameOpt() {
    }

    private static native boolean applyNative(Field r100, Method r101);

    static {
        mInitFlag = new AtomicBoolean(false);
    }

    public static boolean apply(Context r100) {
        if (ensureLoaded(r100) == true) goto L18;
        return false;
    L18:
        Method r101 = Thread.class.getDeclaredMethod("setNativeName", new Class[]{String.class});     // Catch: Throwable -> L8
    L9:
        if (r101 == null) goto L20;
    L13:
        if (r101 != null) goto L22;
        return false;
    L22:
        return applyNative(Thread.class.getDeclaredField("nativePeer"), r101);
    L17:
        return false;
    L20:
        r101 = Thread.class.getDeclaredMethod("nativeSetName", new Class[]{String.class});     // Catch: Throwable -> L12
    L8:
        r101 = null;
        goto L9
    }

    private static synchronized boolean ensureLoaded(Context r100) {
        monitor-enter(ThreadFastSetNameOpt.class);
        AtomicBoolean r101 = mInitFlag;     // Catch: Throwable -> L24
        if (r101.get() == false) goto L10;
        monitor-exit(ThreadFastSetNameOpt.class);
        return true;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        monitor-exit(ThreadFastSetNameOpt.class);
        return false;
    L15:
        if (Process.is64Bit() == true) goto L28;
        monitor-exit(ThreadFastSetNameOpt.class);
        return false;
    L28:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L21;
        ShadowHook.access$000();     // Catch: Throwable -> L27
        ShadowHook.access$100();     // Catch: Throwable -> L27
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L27
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L27
        r103.f270294a = r102;     // Catch: Throwable -> L27
        r103.f270295b = true;     // Catch: Throwable -> L27
        r103.f270296c = false;     // Catch: Throwable -> L27
        r103.f270297d = false;     // Catch: Throwable -> L27
        ShadowHook.init(r103);     // Catch: Throwable -> L27
        r101.set(true);     // Catch: Throwable -> L27
    L21:
        boolean r104 = mInitFlag.get();     // Catch: Throwable -> L24
        monitor-exit(ThreadFastSetNameOpt.class);
        return r104;
    L24:
        th = move-exception;
        throw th;
    }
}
