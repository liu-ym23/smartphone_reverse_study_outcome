package com.bytedance.android.shopping.collect.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final HandlerC0047a a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.collect.util.a$a, reason: collision with other inner class name */
    public static final class HandlerC0047a extends Handler {
        public HandlerC0047a(Looper r2) {
            Intrinsics.checkNotNullParameter(r2, "looper");
            super(r2);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);     // Catch: Exception -> L5
            return;
        }
    }

    public final class b implements Runnable {
        public final /* synthetic */ Function0 a;

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = new HandlerC0047a(Looper.getMainLooper());
    }

    public static void a(Function0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2.invoke();
        return;
    L8:
        a.post(new b(r2));
        return;
    L5:
        r0 = false;
        goto L6
    }
}
