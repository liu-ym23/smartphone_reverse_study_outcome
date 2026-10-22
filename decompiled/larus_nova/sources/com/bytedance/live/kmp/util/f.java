package com.bytedance.live.kmp.util;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f255170a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f255171a;

        public a(Function0 r100) {
            this.f255171a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f255171a.invoke();     // Catch: Throwable -> L4
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
        f255170a = new Handler(Looper.getMainLooper());
    }

    public static final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        f255170a.post(new a(r100));
    }
}
