package com.bytedance.ug.sdk.deeplink.interfaces;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public interface IExecutor extends Executor {
    public static final IExecutor DEFAULT = null;

    public static class a implements IExecutor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            if (r100 == null) goto L5;
            li7.a.f509407a.submit(r100);
            return;
        }

        @Override // com.bytedance.ug.sdk.deeplink.interfaces.IExecutor
        public final void executeWithSingleThread(Runnable r100) {
            if (r100 == null) goto L4;
            li7.a.f509407a.submit(r100);
            return;
        L4:
            PThreadPoolExecutor r101 = li7.a.f509407a;
        }
    }

    void executeWithSingleThread(Runnable r100);

    static {
        DEFAULT = new a();
    }
}
