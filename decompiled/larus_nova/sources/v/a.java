package v;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f552259b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f552260c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f552261d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorC7951a f552262a;

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    public static class ExecutorC7951a implements Executor {
        public ExecutorC7951a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            new Handler(Looper.getMainLooper()).post(r100);
        }
    }

    static {
        f552259b = new a();
        int r100 = Runtime.getRuntime().availableProcessors();
        f552260c = r100 + 1;
        f552261d = (r100 * 2) + 1;
    }

    public a() {
        this.f552262a = new ExecutorC7951a();
    }
}
