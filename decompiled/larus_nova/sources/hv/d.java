package hv;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f487273a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f487274b = null;

    /* JADX WARN: Type inference failed for: r0v1, types: [hv.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [hv.c] */
    static {
        new iv.a(new Handler(Looper.getMainLooper()));
        f487273a = new b();
        f487274b = new c();
    }

    public static <T> T call(Callable<T> r100) {
        return r100.call();
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
