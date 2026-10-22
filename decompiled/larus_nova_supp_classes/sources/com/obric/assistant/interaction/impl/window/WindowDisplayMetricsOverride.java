package com.obric.assistant.interaction.impl.window;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class WindowDisplayMetricsOverride {
    private static final Map<Resources, Integer> WINDOW_WIDTHS = null;

    static {
        WINDOW_WIDTHS = Collections.synchronizedMap(new WeakHashMap());
    }

    private WindowDisplayMetricsOverride() {
    }

    public static DisplayMetrics apply(Resources r1, DisplayMetrics r2) {
        Integer r3 = WINDOW_WIDTHS.get(r1);
        if (r3 != null) goto L5;
    L10:
        return r2;
    L5:
        if (r3.intValue() <= 0) goto L10;
        if (r2 == null) goto L10;
        DisplayMetrics r0 = new DisplayMetrics();
        r0.setTo(r2);
        r0.widthPixels = r3.intValue();
        return r0;
    }

    public static void update(Resources r1, Integer r2) {
        if (r2 != null) goto L4;
    L8:
        WINDOW_WIDTHS.remove(r1);
        return;
    L4:
        if (r2.intValue() <= 0) goto L8;
        WINDOW_WIDTHS.put(r1, r2);
    }
}
