package j08;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes24.dex */
public final class d {
    public static c c(Context r100) {
        Display r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
        Point r102 = new Point();
        r101.getSize(r102);
        return new c(r102.x, r102.y);
    }

    public static float a(Context r100, float r101) {
        Resources r102 = r100.getResources();
        return TypedValue.applyDimension(1, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }

    public static Drawable b(Context r100, int r101) {
        if (r101 != 0) goto L5;
        return null;
    L5:
        return r100.getResources().getDrawable(r101);
    }
}
