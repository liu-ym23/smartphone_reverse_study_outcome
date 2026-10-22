package com.bytedance.webx.seclink.setting;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f272644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f272645b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f272646a = null;

        static {
            f272646a = new e();
        }
    }

    public e() {
        if (this.f272644a == null) goto L5;
        return;
    L5:
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f272644a != null) goto L9;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("sec_link_setting_thread");     // Catch: Throwable -> L11
        this.f272644a = r100;     // Catch: Throwable -> L11
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L11
        this.f272645b = new Handler(this.f272644a.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    }
}
