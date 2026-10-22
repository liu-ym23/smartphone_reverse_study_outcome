package vz3;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final int a = 0;
    public static final int b = 0;

    static {
        Resources r1 = Resources.getSystem();
        a = MathKt.roundToInt(TypedValue.applyDimension(1, 10, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics())));
        Resources r2 = Resources.getSystem();
        b = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
    }

    public static int a(Activity r0, boolean r1, boolean r2, int r3) {
        if (r2 == false) goto L10;
        boolean r4 = d0.e(y54.a.a());
        boolean r5 = d0.f(r0);
        if (r1 == true) goto L13;
        if (r4 == false) goto L9;
        if (r5 == true) goto L9;
        return a;
    L9:
        return 0;
    L13:
        return b;
    L10:
        if (r1 == true) goto L12;
        return r3;
    L12:
        return r3 + b;
    }

    public static int b(Activity r0, boolean r1, boolean r2, int r3) {
        if (r2 == false) goto L9;
        boolean r4 = d0.e(y54.a.a());
        boolean r5 = d0.f(r0);
        if (r1 == true) goto L10;
        if (r4 == false) goto L10;
        if (r5 == true) goto L10;
        return a;
    L10:
        return 0;
    L9:
        if (r1 == true) goto L10;
        return r3;
    }
}
