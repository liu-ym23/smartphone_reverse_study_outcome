package rv4;

import android.content.res.Resources;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes16.dex */
public final class a {
    public static int b(boolean r100, int r101, int r102) {
        if (r100 == true) goto L4;
        return r101;
    L4:
        if (r101 != 0) goto L7;
        return r102 - 1;
    L7:
        if (r101 != (r102 + 1)) goto L10;
        return 0;
    L10:
        return r101 - 1;
    }

    public static float a(float r100) {
        int r101 = com.larksuite.framework.utils.autoscale.a.f285947a;
        Resources r102 = Resources.getSystem();
        return TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
    }
}
