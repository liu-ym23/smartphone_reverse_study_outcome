package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10461p extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C10461p f199133a = null;

    static {
        f199133a = new C10461p();
    }

    public C10461p() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        PThreadScheduledThreadPoolExecutor r100 = new PThreadScheduledThreadPoolExecutor(4, new r0(), new ThreadPoolExecutor.AbortPolicy());
        r100.setRemoveOnCancelPolicy(true);
        r100.setMaximumPoolSize(10);
        r100.setKeepAliveTime(60, TimeUnit.SECONDS);
        r100.allowCoreThreadTimeOut(true);
        return r100;
    }
}
