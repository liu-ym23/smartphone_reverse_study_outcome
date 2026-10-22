package ry2;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PThreadPoolExecutor f539897a;

    public static ExecutorService a() {
        if (f539897a != null) goto L5;
        f539897a = new PThreadPoolExecutor(4, 8, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("MonitorExecutor"), new ThreadPoolExecutor.DiscardPolicy());
    L5:
        PThreadPoolExecutor r100 = f539897a;
        if (r100 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return r100;
    }

    static {
    }

    public static void b(Runnable r100) {
        a().execute(new qy2.a(r100));
    }
}
