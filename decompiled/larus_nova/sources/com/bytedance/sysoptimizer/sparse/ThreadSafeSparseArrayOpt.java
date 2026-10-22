package com.bytedance.sysoptimizer.sparse;

import android.graphics.Typeface;
import android.os.Build;
import android.util.LongSparseArray;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadSafeSparseArrayOpt {
    private static final String TAG = "SafeSparseArrayOpt";

    public ThreadSafeSparseArrayOpt() {
    }

    public static boolean apply() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 24) goto L5;
    L15:
        return false;
    L5:
        if (r100 > 27) goto L15;
        Field r101 = Typeface.class.getDeclaredField("sTypefaceCache");     // Catch: Throwable -> L16
        if (r101 != null) goto L10;
        return false;
    L10:
        r101.setAccessible(true);     // Catch: Throwable -> L16
        Object r102 = r101.get(null);     // Catch: Throwable -> L16
        if (r102 != null) goto L13;
        return false;
    L13:
        r101.set(null, new ThreadSafeLongSparseArray((LongSparseArray) r102));     // Catch: Throwable -> L16
        return true;
    }
}
