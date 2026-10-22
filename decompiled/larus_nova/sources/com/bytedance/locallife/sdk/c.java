package com.bytedance.locallife.sdk;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f264341a = null;

    static {
        f264341a = new c();
    }

    public c() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "locallife_pending_task_queue");
        r101.setDaemon(true);
        return r101;
    }
}
