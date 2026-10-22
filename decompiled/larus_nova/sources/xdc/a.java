package xdc;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f563308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static float f563309b;

    public static int a(float r100) {
        return (int) ((r100 * f563309b) + 0.5f);
    }

    public static void b(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        DisplayMetrics r101 = new DisplayMetrics();
        ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r101);
        f563308a = r101.widthPixels;
        f563309b = r101.density;
    }
}
