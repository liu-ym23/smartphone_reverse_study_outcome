package com.relax.embedding.module;

import com.relax.embedding.InvokeMethod;
import com.relax.embedding.LLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import jpa.a;

/* JADX INFO: loaded from: classes34.dex */
public class NativeModuleRegistry {
    public NativeModuleRegistry() {
    }

    private static native void nativeRegisterObject(long r100, String r101, Object[] r102);

    private static native void nativeUnregisterObject(long r100, String r101);

    public static void registerFunction(String r100, Class<?> r101) {
        Method[] r102 = r101.getMethods();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L14:
    L11:
        e = move-exception;
        LLog.e("registerFunction error: " + r100 + " , exception: " + e);
        return;
    L4:
        if (r104 >= r102.length) goto L9;
        String r105 = r102[r104].getName();     // Catch: Exception -> L11
        if (r102[r104].isAnnotationPresent(InvokeMethod.class) == false) goto L8;
        r103.add(new NativeModuleStateful(r101, r102[r104], r105));     // Catch: Exception -> L11
    L8:
        r104 = r104 + 1;     // Catch: Exception -> L11
        goto L14
    L9:
        nativeRegisterObject(0, r100, r103.toArray());     // Catch: Exception -> L11
    }

    public static void unregisterFunction(long r100, String r101) {
        nativeUnregisterObject(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("unregisterFunction error: " + r101 + " , exception: " + e);
    }

    public static void registerObject(long r100, String r101, Object r102) {
        ArrayList r103 = new ArrayList();
        Method[] r104 = r102.getClass().getMethods();
        int r105 = 0;
    L14:
    L11:
        e = move-exception;
        LLog.e("registerFunction error: " + r101 + " , exception: " + e);
        return;
    L4:
        if (r105 >= r104.length) goto L9;
        String r106 = r104[r105].getName();     // Catch: Exception -> L11
        if (r104[r105].isAnnotationPresent(InvokeMethod.class) == false) goto L8;
        r103.add(new a(r102, r104[r105], r106));     // Catch: Exception -> L11
    L8:
        r105 = r105 + 1;     // Catch: Exception -> L11
        goto L14
    L9:
        nativeRegisterObject(r100, r101, r103.toArray());     // Catch: Exception -> L11
    }
}
