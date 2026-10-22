package com.bytedance.frameworks.baselib.network.http.util;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f244794b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f244795a;

    /* JADX INFO: loaded from: classes19.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f244796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f244797b;

        @Override // java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);     // Catch: Throwable -> L9
            this.f244796a.run();     // Catch: Throwable -> L6
        L14:
            return;
        L6:
            th = move-exception;
            Logger.e(k.f244794b, "WsThreadFactory error when running in thread " + this.f244797b.f244795a, th);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }

        public a(k r100, Runnable r101) {
            this.f244797b = r100;
            this.f244796a = r101;
        }
    }

    static {
        f244794b = k.class.getSimpleName();
    }

    public k() {
        this.f244795a = "ttnet-io";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f244794b, "creating newThread " + this.f244795a);
    L6:
        return new PthreadThreadV2(new a(this, r100), this.f244795a);
    }
}
