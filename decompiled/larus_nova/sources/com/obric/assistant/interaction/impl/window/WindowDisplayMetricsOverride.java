package com.obric.assistant.interaction.impl.window;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class WindowDisplayMetricsOverride {
    private static final Map<Resources, Integer> WINDOW_WIDTHS = null;

    static {
        WINDOW_WIDTHS = Collections.synchronizedMap(new WeakHashMap());
    }

    private WindowDisplayMetricsOverride() {
    }

    public static DisplayMetrics apply(Resources r100, DisplayMetrics r101) {
        Integer r102 = WINDOW_WIDTHS.get(r100);
        if (r102 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r102.intValue() <= 0) goto L10;
        if (r101 == null) goto L10;
        DisplayMetrics r103 = new DisplayMetrics();
        r103.setTo(r101);
        r103.widthPixels = r102.intValue();
        return r103;
    }

    public static void update(Resources r100, Integer r101) {
        if (r101 != null) goto L4;
    L8:
        WINDOW_WIDTHS.remove(r100);
        return;
    L4:
        if (r101.intValue() <= 0) goto L8;
        WINDOW_WIDTHS.put(r100, r101);
    }
}
