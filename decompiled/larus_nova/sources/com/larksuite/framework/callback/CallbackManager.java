package com.larksuite.framework.callback;

import androidx.camera.video.AudioStats;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class CallbackManager {
    private List<ICancelableCallback> callBackList;
    private boolean isCanceled;
    private final Object isCanceledLock;

    public static class CallbackInvocationHandler<T extends ICallback> implements InvocationHandler {
        private boolean isICancelableExisted;
        private T realCallback;

        private void cancel() {
            this.realCallback = null;
        }

        private boolean isCanceled() {
            if (this.realCallback != null) goto L5;
            return true;
        L5:
            return false;
        }

        public CallbackInvocationHandler(T r100, boolean r101) {
            this.realCallback = r100;
            this.isICancelableExisted = r101;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            boolean r103 = false;
            if (isCanceled() == false) goto L56;
            Class<?> r104 = r101.getReturnType();
            if (r104 != null) goto L8;
            return null;
        L8:
            if (r104 == Boolean.TYPE) goto L54;
            if (r104 == Boolean.class) goto L54;
            if (r104 == Byte.TYPE) goto L87;
            if (r104 == Byte.class) goto L87;
            if (r104 == Character.TYPE) goto L86;
            if (r104 == Character.class) goto L86;
            if (r104 == Short.TYPE) goto L85;
            if (r104 == Short.class) goto L85;
            if (r104 == Integer.TYPE) goto L84;
            if (r104 == Integer.class) goto L84;
            if (r104 == Long.TYPE) goto L83;
            if (r104 == Long.class) goto L83;
            if (r104 == Float.TYPE) goto L82;
            if (r104 == Float.class) goto L82;
            if (r104 == Double.TYPE) goto L81;
            if (r104 == Double.class) goto L81;
            return null;
        L81:
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        L82:
            return Float.valueOf(0.0f);
        L83:
            return 0L;
        L84:
            return 0;
        L85:
            return (short) 0;
        L86:
            return (char) 0;
        L87:
            return (byte) 0;
        L54:
            return Boolean.FALSE;
        L56:
            if (r101.equals(ICancelable.class.getMethod("cancel", new Class[0])) == false) goto L63;
            T r105 = this.realCallback;
            cancel();
            if (this.isICancelableExisted == true) goto L60;
            return null;
        L60:
            return r101.invoke(r105, r102);
        L63:
            if (r101.equals(ICancelable.class.getMethod("isCanceled", new Class[0])) == true) goto L65;
            T r106 = this.realCallback;
            if (r106 != null) goto L78;
            return null;
        L78:
            return r101.invoke(r106, r102);
        L65:
            if (this.isICancelableExisted == false) goto L74;
            if (isCanceled() == false) goto L69;
        L70:
            r103 = true;
        L72:
            return Boolean.valueOf(r103);
        L69:
            if (((Boolean) r101.invoke(this.realCallback, r102)).booleanValue() == false) goto L72;
        L74:
            return Boolean.valueOf(isCanceled());
        }
    }

    public void cancelCallbacks() {
        Object r100 = this.isCanceledLock;
        monitor-enter(r100);
        this.isCanceled = true;     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        Iterator<ICancelableCallback> r101 = this.callBackList.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        ICancelableCallback r102 = r101.next();
        if (r102 == null) goto L9;
        r102.cancel();
        goto L9
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public CallbackManager() {
        this.isCanceledLock = new Object();
        this.callBackList = new ArrayList();
    }

    private <Data> UIGetDataCallback<Data> wrapGetDataCallback(IGetDataCallback<Data> r100) {
        return new UIGetDataCallback(r100);
    }

    public <T extends ICancelableCallback> void addCancelableCallback(T r100) {
        Object r101 = this.isCanceledLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.isCanceled == true) goto L7;
        this.callBackList.add(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L7:
        r100.cancel();     // Catch: Throwable -> L10
        goto L8
    }

    public <T extends ICallback> T wrapAndAddCallback(T r100) {
        ICancelableCallback r101 = (T) wrapCallback(r100);
        addCancelableCallback(r101);
        return r101;
    }

    public <Data> UIGetDataCallback<Data> wrapAndAddGetDataCallback(IGetDataCallback<Data> r100) {
        UIGetDataCallback<Data> r101 = wrapGetDataCallback(r100);
        addCancelableCallback(r101);
        return r101;
    }

    public <T extends ICallback> T wrapCallback(T r110) {
        if (r110 != null) goto L23;
        return null;
    L23:
        Class<?> r100 = r110.getClass();     // Catch: Throwable -> L22
        Class<?>[] r101 = r100.getInterfaces();     // Catch: Throwable -> L22
        int r102 = 0;
        boolean r103 = false;
        boolean r104 = false;
    L7:
        if (r102 >= r101.length) goto L12;
        if (ICancelableCallback.class.equals(r101[r102]) == false) goto L11;
        r103 = true;
        r104 = true;
    L11:
        r102 = r102 + 1;     // Catch: Throwable -> L22
        goto L7
    L12:
        if (r103 == false) goto L14;
    L16:
        if (r103 == true) goto L19;
        r101 = (Class[]) Arrays.copyOf(r101, r101.length + 1);     // Catch: Throwable -> L22
        r101[r101.length - 1] = ICancelableCallback.class;     // Catch: Throwable -> L22
    L19:
        return (T) Proxy.newProxyInstance(r100.getClassLoader(), r101, new CallbackInvocationHandler(r110, r104));
    L14:
        if (ICancelable.class.isAssignableFrom(r100) == false) goto L16;
        r104 = true;
    L28:
        return null;
    }
}
