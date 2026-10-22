package r17;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f535669a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f535670b = null;

    public static class a {
        public a() {
        }

        public final void a(Runnable r100, String r101) {
            f27.e r102 = new f27.e(r101, AsyncTaskType.IO, r100);
            Object r103 = f27.d.f475214f;
            f27.d.a.f475222a.h(r102);
        }
    }

    static {
        f535669a = PThreadExecutorsUtils.newScheduledThreadPool(1, new f());
        f535670b = new a();
    }
}
