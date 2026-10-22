package lw7;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f511037b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f511038c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f511039d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f511040a;

    public static class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            new Handler(Looper.getMainLooper()).post(r100);
        }
    }

    static {
        f511037b = new c();
        int r100 = Runtime.getRuntime().availableProcessors();
        f511038c = r100 + 1;
        f511039d = (r100 * 2) + 1;
    }

    public c() {
        this.f511040a = new a();
    }
}
