package rcb;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f537198a = null;

    static {
        f537198a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100, long r101) {
        f537198a.postDelayed(r100, r101);
    }
}
