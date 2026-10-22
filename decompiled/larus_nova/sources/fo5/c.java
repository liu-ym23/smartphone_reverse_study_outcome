package fo5;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends PThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f478126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f478127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f478128c;

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
        if (TextUtils.isEmpty(this.f478127b) == false) goto L5;
        Throwable r100 = new Throwable("shutdown :" + System.currentTimeMillis());
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        this.f478127b = r101.toString();
    L5:
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        if (TextUtils.isEmpty(this.f478128c) == false) goto L6;
        Throwable r100 = new Throwable("shutdownNow :" + System.currentTimeMillis());
        StringWriter r101 = new StringWriter();
        r100.printStackTrace(new PrintWriter(r101));
        this.f478128c = r101.toString();
    L6:
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final String toString() {
        return "mExecutorName: " + this.f478126a + " " + super.toString();
    }

    @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        super.execute(r100);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable r100, Throwable r101) {
        super.afterExecute(r100, r101);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread r100, Runnable r101) {
        super.beforeExecute(r100, r101);
    }

    public c(TimeUnit r100, BlockingQueue r110, b r111) {
        super(1, 1, 30, r100, r110, r111);
        this.f478127b = "";
        this.f478128c = "";
        this.f478126a = "BEAR_SINGLE";
    }
}
