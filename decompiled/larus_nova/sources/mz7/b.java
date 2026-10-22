package mz7;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f516538a = null;

    static {
        f516538a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100.run();
        return;
    L8:
        f516538a.post(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }
}
