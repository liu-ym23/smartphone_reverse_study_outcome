package com.bytedance.android.shopping.prepurchase.arch.utils;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final Handler a = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.arch.utils.a$a, reason: collision with other inner class name */
    public final class RunnableC0157a implements Runnable {
        public final /* synthetic */ Function0 a;

        public RunnableC0157a(Function0 r1) {
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
        a = new Handler(Looper.getMainLooper());
    }

    public static final void a(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r2.invoke();
        return;
    L5:
        a.post(new RunnableC0157a(r2));
    }
}
