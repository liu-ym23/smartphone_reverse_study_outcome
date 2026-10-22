package fjc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.bytedance.common.utility.Logger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes40.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f477550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f477551b;

    public static boolean e(int r100) {
        if (r100 != 0) goto L4;
    L11:
        return true;
    L4:
        if (r100 == 6) goto L11;
        if (r100 == 8) goto L11;
        if (r100 == 11) goto L11;
        return false;
    }

    public static boolean f(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 7) goto L7;
        return true;
    L7:
        if (r100 != 9) goto L9;
        return true;
    L9:
        if (r100 == 12) goto L16;
        return false;
    L16:
        return true;
    }

    public static void a(View r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.getParent() == null) goto L27;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == true) goto L23;
        ajc.b.b("VideoUIUtils", "parent isnot ViewGroup. view.context: " + r100.getContext() + ", parent: " + r101);
        return;
    L23:
        ((ViewGroup) r101).removeView(r100);     // Catch: Exception -> L12
    L14:
        ViewParent r102 = r100.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L26;
        ((ViewGroup) r102).endViewTransition(r100);     // Catch: Exception -> L18
        ((ViewGroup) r102).removeView(r100);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Logger.throwException(e);
        ajc.b.b("VideoUIUtils", "second remove crash. view.context: " + r100.getContext() + ", parent: " + r102);
        return;
    L26:
        return;
    L12:
        e = move-exception;
        Logger.throwException(e);
        ajc.b.b("VideoUIUtils", "first remove crash. view.context: " + r100.getContext() + ", parent: " + r101);
        goto L14
    }

    public static int b(Context r100) {
        Activity r101 = d.a(r100);     // Catch: Exception -> L25
        if (r101 == null) goto L6;
        WindowManager r102 = r101.getWindowManager();     // Catch: Exception -> L25
    L7:
        if (r102 == null) goto L24;
        int r103 = r102.getDefaultDisplay().getRotation();     // Catch: Exception -> L25
        if (r103 == 0) goto L23;
        if (r103 != 1) goto L13;
        return 0;
    L13:
        if (r103 != 2) goto L15;
        return 9;
    L15:
        if (r103 == 3) goto L17;
        return -1;
    L17:
        return 8;
    L23:
        return 1;
    L6:
        r102 = null;
    L24:
        return -1;
    }

    public static int c(Context r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (f477550a > 0) goto L16;
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Exception -> L17
        Activity r103 = getActivity(r100);     // Catch: Exception -> L17
        if (r103 == null) goto L10;
        r103.getWindowManager().getDefaultDisplay().getRealMetrics(r102);     // Catch: Exception -> L17
    L11:
        if (r102 == null) goto L14;
        r101 = Math.max(r102.heightPixels, r102.widthPixels);     // Catch: Exception -> L17
    L14:
        f477550a = r101;     // Catch: Exception -> L17
        goto L16
    L10:
        Resources r104 = r100.getResources();     // Catch: Exception -> L17
        r102 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Exception -> L17
    L16:
        return f477550a;
    }

    public static int d(Context r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (f477551b > 0) goto L16;
        DisplayMetrics r102 = new DisplayMetrics();     // Catch: Exception -> L17
        Activity r103 = getActivity(r100);     // Catch: Exception -> L17
        if (r103 == null) goto L10;
        r103.getWindowManager().getDefaultDisplay().getRealMetrics(r102);     // Catch: Exception -> L17
    L11:
        if (r102 == null) goto L14;
        r101 = Math.min(r102.widthPixels, r102.heightPixels);     // Catch: Exception -> L17
    L14:
        f477551b = r101;     // Catch: Exception -> L17
        goto L16
    L10:
        Resources r104 = r100.getResources();     // Catch: Exception -> L17
        r102 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Exception -> L17
    L16:
        return f477551b;
    }

    public static Activity getActivity(Context r100) {
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L8;
        if ((r100 instanceof Activity) == true) goto L12;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L3
    L12:
        return (Activity) r100;
    L8:
        return null;
    }
}
