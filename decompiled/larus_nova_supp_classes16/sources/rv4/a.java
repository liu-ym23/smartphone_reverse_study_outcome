package rv4;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static int b(boolean r0, int r1, int r2) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        if (r1 != 0) goto L7;
        return r2 - 1;
    L7:
        if (r1 != (r2 + 1)) goto L10;
        return 0;
    L10:
        return r1 - 1;
    }

    public static float a(float r2) {
        int r0 = com.larksuite.framework.utils.autoscale.a.a;
        Resources r1 = Resources.getSystem();
        return TypedValue.applyDimension(1, r2, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }
}
