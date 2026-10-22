package com.larus.bot.impl.common.util;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes26.dex */
public final class j {
    public static final void a(final AppCompatEditText r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setOnTouchListener(new i(r100));
    }

    public static final ObjectAnimator c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.7f, 1.0f, 0.7f});
        if (r101 == null) goto L5;
        r101.setRepeatCount(-1);
    L5:
        if (r101 == null) goto L7;
        r101.setDuration(1000);
    L7:
        if (r101 == null) goto L9;
        r101.start();
    L9:
        return r101;
    }

    public static final StaticLayout b(TextView r100, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "text");
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 23) goto L8;
        StaticLayout.Builder r102 = StaticLayout.Builder.obtain(r110, 0, r110.length(), r100.getPaint(), RangesKt.coerceAtLeast(0, r111));
        if (r101 < 28) goto L7;
        r102.setUseLineSpacingFromFallbacks(true);
    L7:
        StaticLayout r103 = r102.build();
    L9:
        Intrinsics.checkNotNull(r103);
        return r103;
    L8:
        r103 = new StaticLayout(r110, r100.getPaint(), RangesKt.coerceAtLeast(0, r111), Layout.Alignment.ALIGN_NORMAL, r100.getLineSpacingMultiplier(), r100.getLineSpacingExtra(), r100.getIncludeFontPadding());
        goto L9
    }
}
