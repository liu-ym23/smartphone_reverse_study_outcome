package io.reactivex.android.schedulers;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class AndroidSchedulers {
    private static final Scheduler MAIN_THREAD = null;

    public static class a implements Callable<Scheduler> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Scheduler call() throws Exception {
            return call();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Scheduler call() throws Exception {
            return b.f492830a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final rtc.a f492830a = null;

        static {
            f492830a = new rtc.a(new Handler(Looper.getMainLooper()), false);
        }
    }

    static {
        Scheduler r100 = new a().call();     // Catch: Throwable -> L9
        if (r100 == null) goto L8;
        MAIN_THREAD = r100;
        return;
    L8:
        throw new NullPointerException("Scheduler Callable returned null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw Exceptions.propagate(th);
    }

    public static Scheduler mainThread() {
        Scheduler r100 = MAIN_THREAD;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("scheduler == null");
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler from(Looper r100) {
        return from(r100, false);
    }

    public static Scheduler from(Looper r100, boolean r101) {
        if (r100 == null) goto L15;
        int r102 = Build.VERSION.SDK_INT;
        if (r101 == false) goto L13;
        if (r102 >= 22) goto L13;
        Message r103 = Message.obtain();
        r103.setAsynchronous(true);     // Catch: NoSuchMethodError -> L10
    L11:
        r103.recycle();
    L10:
        r101 = false;
    L13:
        return new rtc.a(new Handler(r100), r101);
    L15:
        throw new NullPointerException("looper == null");
    }
}
