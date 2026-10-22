package com.bytedance.platform.godzilla.crash.boostcrash.impl;

import android.app.Instrumentation;
import android.os.Looper;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import r57.a;

/* JADX INFO: loaded from: classes21.dex */
public class InstrumentationWrapper extends Instrumentation {
    private static final String TAG = "InstrumentationWrapper";
    private static List<a> sExceptionCatchers;
    private static boolean sIsFixed;

    static {
        sExceptionCatchers = new ArrayList();
    }

    public static void startFix() {
        if (sIsFixed == false) goto L13;
        return;
    L13:
        Object r100 = p57.a.b();     // Catch: Exception -> L10
        Field r101 = r100.getClass().getDeclaredField("mInstrumentation");     // Catch: Exception -> L10
        r101.setAccessible(true);     // Catch: Exception -> L10
        if ((r101.get(r100) instanceof InstrumentationWrapper) == false) goto L8;
        return;
    L8:
        r101.set(r100, new InstrumentationWrapper());     // Catch: Exception -> L10
        Logger.Level r102 = Logger.f266614a;     // Catch: Exception -> L10
        Logger.c(TAG, "Fix success.", Logger.Level.DEBUG);     // Catch: Exception -> L10
        sIsFixed = true;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        String r103 = e.getMessage();
        Logger.Level r104 = Logger.f266614a;
        Logger.c(TAG, r103, Logger.Level.DEBUG);
    }

    public InstrumentationWrapper() {
    }

    public static void registerExceptionCatcher(a r100) {
        if (Logger.f266615b == true) goto L5;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.registerCondition() == true) goto L14;
        return;
    L14:
        if (sExceptionCatchers.contains(r100) == true) goto L18;
        sExceptionCatchers.add(r100);
        return;
    L18:
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("register only in UI thread.");
    }

    public static void unRegisterExceptionCatcher(a r100) {
        if (Logger.f266615b == true) goto L5;
    L9:
        if (r100 != null) goto L11;
        return;
    L11:
        sExceptionCatchers.remove(r100);
        return;
    L5:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L9;
        throw new RuntimeException("unRegister only in UI thread.");
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r100, Throwable r101) {
        Iterator<a> r102 = sExceptionCatchers.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        if (r102.next().a() == false) goto L4;
        return true;
    L10:
        return super.onException(r100, r101);
    }
}
