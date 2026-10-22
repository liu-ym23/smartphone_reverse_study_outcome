package glc;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ugc.effectplatform.k;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    static {
    }

    public static k a(int r100, long r110) {
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(r100, r100, r110, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("or/ThreadPool"));
        if (r110 <= 0) goto L5;
        boolean r102 = true;
    L6:
        r101.allowCoreThreadTimeOut(r102);
        return new k(r101);
    L5:
        r102 = false;
        goto L6
    }
}
