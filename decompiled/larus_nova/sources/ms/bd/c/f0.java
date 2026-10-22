package ms.bd.c;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f515138a;

    public static String a(Context r100) {
        if (r100 == null) goto L6;
        new DisplayMetrics();     // Catch: Throwable -> L7
        Resources r101 = r100.getResources();     // Catch: Throwable -> L7
        f515138a = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).densityDpi;     // Catch: Throwable -> L7
    L6:
        return "" + f515138a;
    }
}
