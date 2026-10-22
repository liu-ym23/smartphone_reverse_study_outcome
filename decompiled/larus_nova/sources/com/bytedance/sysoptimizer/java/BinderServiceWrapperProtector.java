package com.bytedance.sysoptimizer.java;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes22.dex */
public final class BinderServiceWrapperProtector {
    public static final AdminResult VOID_ADMIN_RESULT = null;
    private static boolean sDebug;

    public interface AdminResult {
        Object getDefaultResult(Object r100, Method r101, Object[] r102);
    }

    public static final class VoidAdminResult implements AdminResult {
        public VoidAdminResult() {
        }

        @Override // com.bytedance.sysoptimizer.java.BinderServiceWrapperProtector.AdminResult
        public Object getDefaultResult(Object r100, Method r101, Object[] r102) {
            return 1;
        }
    }

    public BinderServiceWrapperProtector() {
    }

    static {
        VOID_ADMIN_RESULT = new VoidAdminResult();
    }

    public static /* synthetic */ boolean access$000() {
        return sDebug;
    }

    public static void setDebug(boolean r100) {
        sDebug = r100;
    }

    private static void setProxy(Object r100, Object r101, Field r102, String r103) {
        r102.set(r101, r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.getStackTraceString(th);
    }

    public static boolean install(Context r100, String r101, final List<String> r102, final String r103, final AdminResult r110) {
        Object r104 = r100.getSystemService(r101);     // Catch: Throwable -> L11
        if (r104 != null) goto L6;
        return false;
    L6:
        Field r105 = r104.getClass().getDeclaredField("mService");     // Catch: Throwable -> L11
        r105.setAccessible(true);     // Catch: Throwable -> L11
        final Object r106 = r105.get(r104);     // Catch: Throwable -> L11
        if (r106 != null) goto L9;
        return false;
    L9:
        r106.toString();     // Catch: Throwable -> L11
        setProxy(Proxy.newProxyInstance(r106.getClass().getClassLoader(), r106.getClass().getInterfaces(), new AnonymousClass1(r102, r103, r106, r110)), r104, r105, r103);     // Catch: Throwable -> L11
        Objects.toString(r105.get(r104));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        Log.getStackTraceString(th);
        return false;
    }
}
