package wr0;

import android.os.Looper;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static boolean a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L5;
        return true;
    L5:
        return false;
    }
}
