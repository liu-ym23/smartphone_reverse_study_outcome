package com.bytedance.observer;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.bytedance.apm.block.j;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public class ObserverWrapper extends j.a implements Looper.Observer {
    private Looper.Observer mOriginObserver;

    static {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return;
    L6:
        throw new IllegalStateException("load class error");
    }

    public Object messageDispatchStarting() {
        if (j.f190351c == null) goto L13;
        Looper.Observer r100 = this.mOriginObserver;
        if (r100 == null) goto L18;
        Object r101 = r100.messageDispatchStarting();
    L15:
        if (j.f190355g != ThreadMethodProxy.currentThread()) goto L17;
        messageDispatchStarting(">>>>> Dispatching to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee: 0");
    L17:
        return r101;
    L18:
        r101 = j.f190352d.invoke(j.f190351c, new Object[0]);     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L13:
        r101 = null;
        goto L15
    }

    public ObserverWrapper() {
    }

    @Override // com.bytedance.apm.block.j.a
    public void setup(Object r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Looper.Observer) == false) goto L8;
        this.mOriginObserver = (Looper.Observer) r100;
        return;
    }

    public void messageDispatched(Object r100, Message r101) {
        if (j.f190351c == null) goto L14;
        Looper.Observer r102 = this.mOriginObserver;
        if (r102 == null) goto L17;
        r102.messageDispatched(r100, r101);
        goto L14
    L17:
        j.f190353e.invoke(j.f190351c, new Object[]{r100, r101});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        if (j.f190355g != ThreadMethodProxy.currentThread()) goto L19;
        messageDispatched("<<<<< Finished to Handler (com.bytedance.apm.block.LooperObserverMonitor) {57c1969} com.bytedance.apm.block.LooperObserverMonitor@5caffee", r101);
        return;
    }

    public void dispatchingThrewException(Object r100, Message r101, Exception r102) {
        if (j.f190351c == null) goto L16;
        Looper.Observer r103 = this.mOriginObserver;
        if (r103 == null) goto L14;
        r103.dispatchingThrewException(r100, r101, r102);
        return;
    L14:
        j.f190354f.invoke(j.f190351c, new Object[]{r100, r101, r102});     // Catch: InvocationTargetException -> L9 IllegalAccessException -> L11
    L19:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
