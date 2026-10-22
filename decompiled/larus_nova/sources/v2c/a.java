package v2c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static int d(Context r100) {
        DesktopUtil.a(r100);
        WindowManager r101 = (WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        DisplayMetrics r102 = new DisplayMetrics();
        r101.getDefaultDisplay().getRealMetrics(r102);
        return r102.heightPixels;
    }

    public static Resources getResources(Context r100) {
        return r100.getResources();
    }

    public static int a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }

    public static int b(Context r100, int r101) {
        return getResources(r100).getColor(r101);
    }

    public static Drawable c(Context r100, int r101) {
        return getResources(r100).getDrawable(r101);
    }

    public static String e(Context r100, String r101) {
        String r102 = getResources(r100).getString(R.string.Lark_Legacy_PostReactionAppend);
        if (r101 != null) goto L6;
        return r102;
    L6:
        return r102.replace(String.format("{{%s}}", new Object[]{"count"}), r101);
    }
}
