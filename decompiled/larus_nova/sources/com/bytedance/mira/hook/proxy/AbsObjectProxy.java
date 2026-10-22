package com.bytedance.mira.hook.proxy;

import com.bytedance.mira.hook.MiraHook;
import com.bytedance.mira.log.MiraLogger;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsObjectProxy implements InvocationHandler, MiraHook {
    private static final String TAG = "AbsObjectProxy";
    protected static HashMap<String, AbsMethodDelegate> sDelegateMethods;
    private static final Map<Class<?>, Class<?>> sPrimitiveTypes = null;
    private boolean mCalled;
    private boolean mEnable;
    private Object mTarget;

    public boolean isCatchInvokeThrowable(Method r100) {
        return true;
    }

    static {
        sDelegateMethods = new HashMap();
        HashMap r100 = new HashMap();
        sPrimitiveTypes = r100;
        r100.put(Boolean.class, Boolean.TYPE);
        r100.put(Byte.class, Byte.TYPE);
        r100.put(Character.class, Character.TYPE);
        r100.put(Short.class, Short.TYPE);
        r100.put(Integer.class, Integer.TYPE);
        r100.put(Long.class, Long.TYPE);
        r100.put(Double.class, Double.TYPE);
        r100.put(Float.class, Float.TYPE);
    }

    public AbsObjectProxy() {
        this.mEnable = true;
    }

    public Object getTarget() {
        return this.mTarget;
    }

    public AbsMethodDelegate findMethodDelegate(String r100) {
        return sDelegateMethods.get(r100);
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public void setTarget(Object r100) {
        this.mCalled = true;
        this.mTarget = r100;
    }

    private Object publishResult(Object r100, Method r101) {
        if (r100 == null) goto L4;
        return r100;
    L4:
        Class<?> r102 = r101.getReturnType();
        if (r102.isPrimitive() == true) goto L12;
        r102 = sPrimitiveTypes.get(r102);
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102 != Boolean.TYPE) goto L16;
        return Boolean.FALSE;
    L16:
        if (r102 != Void.TYPE) goto L20;
        return new Object();
    L20:
        return 0;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws InvocationTargetException, IllegalAccessException {
        if (this.mCalled == false) goto L34;
        if (r101.isAccessible() == true) goto L8;
        r101.setAccessible(true);
    L8:
        if (this.mEnable == false) goto L10;
        AbsMethodDelegate r103 = findMethodDelegate(r101.getName());
        Object r104 = null;
        if (r103 != null) goto L35;
    L17:
        if (r104 == null) goto L39;
    L26:
        if (r103 == null) goto L32;
        MiraLogger.v(TAG, ">> " + r101.getName());     // Catch: Throwable -> L29
        r104 = r103.afterInvoke(this.mTarget, r101, r102, r104);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        MiraLogger.e(TAG, ">> failed.", th);
    L32:
        return publishResult(r104, r101);
    L39:
        MiraLogger.v(TAG, "invoke " + r101.getName());     // Catch: Throwable -> L20
        r104 = r101.invoke(this.mTarget, r102);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        if (isCatchInvokeThrowable(r101) == false) goto L25;
        MiraLogger.e(TAG, "invoke failed.", th);
        goto L26
    L25:
        throw new RuntimeException(th);
    L35:
        MiraLogger.v(TAG, "<< " + r101.getName());     // Catch: Throwable -> L15
        r104 = r103.beforeInvoke(this.mTarget, r101, r102);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        MiraLogger.e(TAG, "<< failed.", th);
        goto L17
    L10:
        return r101.invoke(this.mTarget, r102);
    L34:
        throw new IllegalStateException("setTarget must be invoked before this invoke");
    }
}
