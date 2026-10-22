package androidx.appcompat.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    private ViewUtils() {
    }

    static {
        Method r0 = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});     // Catch: NoSuchMethodException -> L6
        sComputeFitSystemWindowsMethod = r0;     // Catch: NoSuchMethodException -> L6
        if (r0.isAccessible() == true) goto L9;
        sComputeFitSystemWindowsMethod.setAccessible(true);     // Catch: NoSuchMethodException -> L6
        return;
    L9:
        return;
    }

    public static boolean isLayoutRtl(View r1) {
        if (ViewCompat.getLayoutDirection(r1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void makeOptionalFitsSystemWindows(View r4) {
        Method r0 = r4.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);     // Catch: Throwable -> L7
        if (r0.isAccessible() == true) goto L5;
        r0.setAccessible(true);     // Catch: Throwable -> L7
    L5:
        r0.invoke(r4, new Object[0]);     // Catch: Throwable -> L7
        return;
    }

    public static void computeFitSystemWindows(View r3, Rect r4, Rect r5) {
        Method r0 = sComputeFitSystemWindowsMethod;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.invoke(r3, new Object[]{r4, r5});     // Catch: Exception -> L7
        return;
    }
}
