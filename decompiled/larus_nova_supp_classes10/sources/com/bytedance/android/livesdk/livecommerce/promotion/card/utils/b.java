package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
        new Handler(Looper.getMainLooper());
    }

    @JvmStatic
    public static final int c(float r2) {
        Resources r0 = Resources.getSystem();
        return (int) ((r2 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static float[] d(View r6) {
        Intrinsics.checkNotNullParameter(r6, "view");
        int[] r1 = new int[2];
        r6.getLocationOnScreen(r1);
        return new float[]{r1[0] + (r6.getWidth() / 2), r1[1] + (r6.getHeight() / 2)};
    }

    public static void a(int r4, int r5, String r6, TextView r7) {
        Intrinsics.checkNotNullParameter(r6, "showText");
        Intrinsics.checkNotNullParameter(r7, "textView");
        if (r4 < 1) goto L9;
    L4:
        Paint r1 = new Paint();
        float r2 = r4;
        r1.setTextSize(c(r2));
        if ((r5 + 0) > r1.measureText(r6)) goto L6;
        if (r4 == 1) goto L9;
        r4 = r4 - 1;
        goto L4
    L6:
        r7.setTextSize(1, r2);
        return;
    L9:
        r7.setTextSize(1);
    }

    public static void b(int r3, int r4, int r5, String r6, TextView r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "showText");
        Intrinsics.checkNotNullParameter(r7, "textView");
        if (r3 < r4) goto L10;
    L4:
        Paint r0 = new Paint();
        float r1 = r3;
        r0.setTextSize(c(r1));
        if ((r5 - r8) > r0.measureText(r6)) goto L6;
        if (r3 == r4) goto L10;
        r3 = r3 - 1;
        goto L4
    L6:
        r7.setTextSize(r1);
        return;
    L10:
        r7.setTextSize(r4);
    }
}
