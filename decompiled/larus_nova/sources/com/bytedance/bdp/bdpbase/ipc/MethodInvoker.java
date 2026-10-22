package com.bytedance.bdp.bdpbase.ipc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes11.dex */
public final class MethodInvoker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f201108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f201109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f201110c;

    public static class MethodInvokeException extends RuntimeException {
        public MethodInvokeException() {
        }

        public MethodInvokeException(String r100) {
            super(r100);
        }

        public MethodInvokeException(Throwable r100) {
            super(r100);
        }

        public MethodInvokeException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public final void b(q<?> r100, Throwable r101) {
        g94.b.d("IPC_MethodInvoker", new Object[]{"invoker find callback object"});
        g94.b.b("IPC_MethodInvoker", new Object[]{"error occur in " + m.b("method_invocation_fail") + ", error message: " + ("Exception occur when invoking method '" + this.f201109b.getName() + "', exception: {" + t.c(r101) + com.alipay.sdk.m.u.i.f25855d)});
        r100.a();
    }

    public MethodInvoker(Object r100, Method r101, boolean r102) {
        this.f201110c = r102;
        boolean r103 = t.f201195a;
        if (r100 == null) goto L7;
        this.f201108a = r100;
        this.f201109b = r101;
        r101.setAccessible(true);
        return;
    L7:
        throw new NullPointerException("Target cannot be null.");
    }

    public final Response<Object> a(Object[] r110, long r111, boolean r210, boolean r211, String r212) {
        Object[] r100 = new Object[1];
        StringBuilder r101 = new StringBuilder("MethodInvoker execute ");
        if (r210 == false) goto L5;
        String r102 = "callback ";
    L6:
        r101.append(r102);
        r101.append("method: '");
        r101.append(r212);
        r101.append("', requestId='");
        r101.append(r111);
        r101.append("'");
        r100[0] = r101.toString();
        g94.b.d("IPC_MethodInvoker", r100);
        String r103 = String.format("Call method '%s' successfully!", new Object[]{r212});
        Object r104 = null;
        int r105 = 200;
        r104 = this.f201109b.invoke(this.f201108a, r110);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L26
    L37:
        if (r104 == null) goto L43;
        String r106 = "Exception occur when execute method: " + r212 + ", exception: " + r104;
        if (r105 != 401) goto L41;
        String r107 = "method_invocation_fail";
    L42:
        t.o(r107, r212.substring(0, r212.indexOf(45)), r212, r104.getClass().getName());
        String r108 = r106;
    L45:
        return new Response(r105, r108, r104, r111, r210);
    L41:
        r107 = "method_illegal_access";
        goto L42
    L43:
        r108 = r103;
        goto L45
    L26:
        Throwable e100 = e;
        g94.b.b("IPC_MethodInvoker", new Object[]{"method: " + r212 + " catch exception: " + e100});
        if (r211 == false) goto L35;
        if (r110 == null) goto L35;
        if (r110.length <= 0) goto L35;
        Object r109 = r110[r110.length - 1];
        if ((r109 instanceof q) == false) goto L35;
        b((q) r109, e100);
    L35:
        r105 = 400;
    L36:
        r104 = e100;
    L9:
        e = move-exception;
        e100 = e.getTargetException();
        if (e100 == null) goto L13;
        String r112 = "catch exception " + t.c(e100);
    L14:
        g94.b.b("IPC_MethodInvoker", new Object[]{"invoke method '" + r212 + "' fail, " + r112});
        if (t.j() == true) goto L25;
        if (r211 == false) goto L23;
        if (r110 == null) goto L23;
        if (r110.length <= 0) goto L23;
        Object r113 = r110[r110.length - 1];
        if ((r113 instanceof q) == false) goto L23;
        b((q) r113, e100);
    L23:
        r105 = 401;
        goto L36
    L25:
        throw new MethodInvokeException(e100);
    L13:
        r112 = "but not caught exception";
        goto L14
    L5:
        r102 = "";
        goto L6
    }
}
