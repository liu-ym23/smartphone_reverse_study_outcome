package bt3;

import com.bytedance.apm.d;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c {
    public volatile ExecutorService a;

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            return new PthreadThreadV2(r3, "Apm_Log_Bypass_Store");
        }
    }

    public static class b {
        public static final c a = null;

        static {
            a = new c();
        }
    }

    public static c a() {
        if (d.c == true) goto L5;
        return null;
    L5:
        return b.a;
    }

    public c() {
        this.a = PThreadExecutorsUtils.newFixedThreadPool(1, new a());
    }

    public final void b(Runnable r2) {
        this.a.submit(r2);
    }
}
