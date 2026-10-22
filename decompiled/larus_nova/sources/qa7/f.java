package qa7;

import android.os.Looper;

/* JADX INFO: loaded from: classes19.dex */
public final class f {
    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException("This method must call on main thread");
    }
}
