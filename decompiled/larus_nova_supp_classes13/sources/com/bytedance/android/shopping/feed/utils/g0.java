package com.bytedance.android.shopping.feed.utils;

import android.content.res.Resources;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(TextView r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "textView");
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return 0;
    L6:
        TextPaint r2 = r8.getPaint();
        Layout.Alignment r4 = Layout.Alignment.ALIGN_NORMAL;
        Resources r3 = Resources.getSystem();
        return new StaticLayout(r9, r2, r10, r4, 1.0f, MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()))), true).getHeight();
    }
}
