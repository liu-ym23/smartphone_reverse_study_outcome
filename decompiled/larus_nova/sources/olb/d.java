package olb;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f524194a = null;

    static {
        f524194a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100) {
        f524194a.removeCallbacks(r100);
    }
}
