package com.bytedance.android.shopping.mall.homepage.jsb;

import android.content.res.Resources;
import android.view.View;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public static final int a(int r2) {
        Resources r0 = Resources.getSystem();
        return MathKt.roundToInt(r2 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
    }

    public static final void b(Map<String, Object> r9, Function0<? extends View> r10) {
        Intrinsics.checkNotNullParameter(r9, "result");
        Intrinsics.checkNotNullParameter(r10, "tabViewProvider");
        HashMap r0 = new HashMap();
        r0.put("x", 0);
        r0.put("y", 0);
        r0.put("width", 0);
        r0.put("height", 0);
        Gson r2 = new Gson();
        View r11 = (View) r10.invoke();     // Catch: Exception -> L8
        if (r11 == null) goto L6;
        int[] r7 = {0, 0};     // Catch: Exception -> L8
        r11.getLocationOnScreen(r7);     // Catch: Exception -> L8
        r0.put("x", Integer.valueOf(a(r7[0])));     // Catch: Exception -> L8
        r0.put("y", Integer.valueOf(a(r7[1])));     // Catch: Exception -> L8
        r0.put("width", Integer.valueOf(a(r11.getWidth())));     // Catch: Exception -> L8
        r0.put("height", Integer.valueOf(a(r11.getHeight())));     // Catch: Exception -> L8
    L6:
        r9.put("tabFrame", GsonProtectorUtils.toJson(r2, r0));
    }
}
