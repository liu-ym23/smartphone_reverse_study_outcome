package i94;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f488780a;

    /* JADX INFO: renamed from: i94.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC6244a extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f488781c;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, com.ss.android.ugc.bytex.pthread.base.convergence.hook.HandlerThreadProxyWrapper, java.lang.Thread
        public final synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f488781c == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f488781c = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public HandlerThreadC6244a() {
            super("platform-handler");
            this.f488781c = false;
        }
    }

    public static class b extends HandlerThreadC6244a {
        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread
        public final boolean quit() {
            return true;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2, android.os.HandlerThread
        public final boolean quitSafely() {
            return true;
        }

        public b() {
        }
    }

    public a() {
    }
}
