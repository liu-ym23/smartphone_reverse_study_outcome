package com.heytap.msp.push.notification;

import com.heytap.mcssdk.d.b;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public class PushNotificationManager {
    private PushNotification.Builder builder;
    private Executor executor;

    public static class SingletonHolder {
        private static final PushNotificationManager INSTANCE = null;

        static {
            INSTANCE = new PushNotificationManager();
        }

        private SingletonHolder() {
        }

        public static /* synthetic */ PushNotificationManager access$100() {
            return INSTANCE;
        }
    }

    public PushNotificationManager() {
    }

    public static /* synthetic */ PushNotification.Builder access$000(PushNotificationManager r100) {
        return r100.builder;
    }

    public static PushNotificationManager getInstance() {
        return SingletonHolder.access$100();
    }

    public void enqueue(final ISortListener r110) {
        if (this.executor != null) goto L5;
        this.executor = new PThreadPoolExecutor(1, 0, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(16), new DefaultThreadFactory("PushNotificationManager"), new ThreadPoolExecutor.DiscardPolicy());
    L5:
        this.executor.execute(new AnonymousClass1(this, r110));
    }

    public void execute(ISortListener r100) {
        b.a().a(this.builder, r100);
    }

    public PushNotificationManager with(PushNotification.Builder r100) {
        this.builder = r100;
        return this;
    }
}
