package fo5;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends PThreadPoolExecutor {
    public final String a;
    public volatile String b;
    public volatile String c;

    /* JADX WARN: Multi-variable type inference failed */
    public final void shutdown() {
        if (TextUtils.isEmpty(this.b) == false) goto L5;
        Throwable r0 = new Throwable("shutdown :" + System.currentTimeMillis());
        StringWriter r1 = new StringWriter();
        r0.printStackTrace(new PrintWriter(r1));
        this.b = r1.toString();
    L5:
        super/*java.util.concurrent.ThreadPoolExecutor*/.shutdown();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Runnable> shutdownNow() {
        if (TextUtils.isEmpty(this.c) == false) goto L6;
        Throwable r0 = new Throwable("shutdownNow :" + System.currentTimeMillis());
        StringWriter r1 = new StringWriter();
        r0.printStackTrace(new PrintWriter(r1));
        this.c = r1.toString();
    L6:
        return super/*java.util.concurrent.ThreadPoolExecutor*/.shutdownNow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        return "mExecutorName: " + this.a + " " + super/*java.util.concurrent.ThreadPoolExecutor*/.toString();
    }

    public final void execute(Runnable r1) {
        super.execute(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void afterExecute(Runnable r1, Throwable r2) {
        super/*java.util.concurrent.ThreadPoolExecutor*/.afterExecute(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void beforeExecute(Thread r1, Runnable r2) {
        super/*java.util.concurrent.ThreadPoolExecutor*/.beforeExecute(r1, r2);
    }

    public c(TimeUnit r9, BlockingQueue r10, b r11) {
        super(1, 1, 30, r9, r10, r11);
        this.b = "";
        this.c = "";
        this.a = "BEAR_SINGLE";
    }
}
