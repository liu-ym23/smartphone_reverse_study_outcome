package dv7;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f470161b = null;

    public static final class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f470162a;

        public a() {
            this.f470162a = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable r100) {
            this.f470162a.post(r100);
        }
    }

    static {
        f470160a = new a();
        f470161b = new u();
    }
}
