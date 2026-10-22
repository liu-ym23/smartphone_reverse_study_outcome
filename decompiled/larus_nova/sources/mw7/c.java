package mw7;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f515974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f515975c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f515976d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static c f515977e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PThreadPoolExecutor f515978a;

    static {
        f515974b = new LinkedBlockingQueue();
        int r100 = Runtime.getRuntime().availableProcessors();
        f515975c = Math.max(2, Math.min(r100 - 1, 4));
        f515976d = (r100 * 2) + 1;
    }

    public c() {
        new Handler(Looper.getMainLooper());
        this.f515978a = new PThreadPoolExecutor(f515975c, f515976d, 30, TimeUnit.SECONDS, f515974b, new DefaultThreadFactory("nor/honorid/d"));
    }
}
