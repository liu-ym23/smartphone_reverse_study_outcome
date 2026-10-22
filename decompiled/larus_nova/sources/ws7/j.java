package ws7;

import android.content.Context;
import android.content.res.Resources;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public final class j {
    public static String b() {
        String r100 = Locale.getDefault().toLanguageTag();     // Catch: Throwable -> L4
    L6:
        if (t.a(r100) == false) goto L8;
        return r100;
    L8:
        if (r100.split("-").length > 2) goto L10;
        return r100;
    L10:
        return r100.substring(0, r100.lastIndexOf("-"));
    L4:
        r100 = "";
        goto L6
    }

    public static int a(Context r100, float r101) {
        if (r100 == null) goto L6;
        Resources r102 = r100.getResources();     // Catch: Throwable -> L7
        return Math.round((WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).densityDpi / 160.0f) * r101);
    L6:
        return (int) r101;
    }
}
