package com.bytedance.android.shopping.cart_common;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PostFrameTask implements Choreographer.FrameCallback {
    public int a;
    public final Handler b;
    public final Function0<Unit> c;

    public PostFrameTask(Function0 r2) {
        this.c = r2;
        this.b = new Handler(Looper.getMainLooper());
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r3) {
        boolean r4 = true;
        int r5 = this.a + 1;
        this.a = r5;
        if (r5 != 2) goto L7;
        Function0<Unit> r6 = this.c;
        if (r6 == null) goto L15;
        Unit r7 = (Unit) r6.invoke();
        return;
    L15:
        return;
    L7:
        Function0<Unit> r8 = new AnonymousClass1(this);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L11;
        r4 = false;
    L11:
        if (r4 == false) goto L13;
        r8.invoke();
        return;
    L13:
        this.b.post(new c(r8));
    }
}
