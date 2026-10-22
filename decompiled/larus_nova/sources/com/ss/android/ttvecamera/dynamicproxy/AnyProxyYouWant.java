package com.ss.android.ttvecamera.dynamicproxy;

import com.ss.android.ttvecamera.TELogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes38.dex */
public class AnyProxyYouWant implements InvocationHandler {
    private final String mProxyName;
    private final Object mTarget;
    private boolean mbNeedHandleException;

    public void setNeedHandleException(boolean r100) {
        TELogUtils.i(this.mProxyName, "setNeedHandleException, needHandleException: " + r100);
        this.mbNeedHandleException = r100;
    }

    public AnyProxyYouWant(Object r100, String r101) {
        this.mbNeedHandleException = false;
        this.mTarget = r100;
        this.mProxyName = r101;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
        TELogUtils.i(this.mProxyName, "method: " + r101.getName() + " has been invoked.");     // Catch: Exception -> L5
        return r101.invoke(this.mTarget, r102);
    L5:
        e = move-exception;
        String r103 = this.mProxyName;
        StringBuilder r104 = new StringBuilder("exception occurred：");
        r104.append(e.getClass().getName());
        r104.append(", message: ");
        r104.append(e.getMessage());
        r104.append(", cause: ");
        r104.append(e.getCause());
        r104.append(", cause message: ");
        if (e.getCause() == null) goto L9;
        String r105 = e.getCause().getMessage();
    L10:
        r104.append(r105);
        TELogUtils.e(r103, r104.toString());
        if ((e instanceof InvocationTargetException) == false) goto L37;
        Throwable r106 = e.getCause();
        if (this.mProxyName.equals("ICameraDeviceUser") == false) goto L34;
        if (r106 == null) goto L34;
        if (r106.getClass().getName().equals("android.os.ServiceSpecificException") == false) goto L34;
        if (r106.getMessage() == null) goto L34;
        if (r106.getMessage().contains("Attempt to use camera from a different process than original client") == false) goto L34;
        if (this.mbNeedHandleException == false) goto L34;
        if (r101.getName() == null) goto L34;
        if (r101.getName().equals("endConfigure") == true) goto L33;
        if (r101.getName().equals("deleteStream") == true) goto L33;
        if (r101.getName().equals("waitUntilIdle") == false) goto L34;
    L33:
        throw new IllegalArgumentException("The multi-process exception occurred when closed preview session on some special devices, so convert the exception to IllegalArgumentException.", r106);
    L34:
        if (r106 != null) goto L36;
        throw e;
    L36:
        throw r106;
    L37:
        throw e;
    L9:
        r105 = null;
        goto L10
    }
}
