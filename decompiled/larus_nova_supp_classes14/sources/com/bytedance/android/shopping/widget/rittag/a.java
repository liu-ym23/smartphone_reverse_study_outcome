package com.bytedance.android.shopping.widget.rittag;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.shopping.extensions.k;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final int a() {
        return b(Float.valueOf(0.5f));
    }

    public static final int b(Number r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$dpCeil");
        float r3 = r2.floatValue();
        Resources r0 = uf4.a.a().getResources();
        return (int) Math.ceil(TypedValue.applyDimension(1, r3, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
    }

    public static final Drawable c(float[] r11, float r12, String r13, String r14) {
        if (r11 == null) goto L16;
        int r2 = r11.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        if (r11[r3] <= 0.0f) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L11;
        r3 = r3 + 1;
        goto L5
    L11:
        boolean r5 = true;
    L14:
        if (r5 != true) goto L16;
        boolean r6 = true;
    L17:
        if (r13 != null) goto L19;
    L21:
        boolean r7 = false;
    L22:
        if (r6 == true) goto L26;
        if (r7 == true) goto L26;
        return new ColorDrawable(s.a(r14, 0));
    L26:
        int r15 = s.a(r14, 0);
        GradientDrawable r8 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r15, r15});
        r8.setShape(0);
        float[] r16 = null;
        if (r11 == null) goto L38;
        int r9 = r11.length;
        if (r9 == 1) goto L35;
        if (r9 == 4) goto L34;
        if (r9 != 8) goto L36;
    L37:
        r16 = r11;
    L36:
        r11 = r16;
        goto L37
    L34:
        float r1 = r11[1];
        float r10 = r11[2];
        float r17 = r11[3];
        r16 = new float[]{r11[0], r11[0], r1, r1, r10, r10, r17, r17};
        goto L36
    L35:
        float r18 = r11[0];
        r16 = new float[]{r11[0], r18, r18, r18, r18, r18, r18, r18};
    L38:
        if (r16 == null) goto L42;
        int r19 = r16.length;
        int r20 = 0;
        int r21 = 0;
    L40:
        if (r20 >= r19) goto L42;
        r16[r21] = q.a(Float.valueOf(r16[r20]));
        r20 = r20 + 1;
        r21 = r21 + 1;
    L42:
        if (r16 == null) goto L46;
        int r110 = r16.length;
        int r22 = 0;
        int r23 = 0;
    L44:
        if (r22 >= r110) goto L46;
        r16[r23] = RangesKt.coerceAtMost(r16[r22], r12);
        r22 = r22 + 1;
        r23 = r23 + 1;
    L46:
        r8.setCornerRadii(r16);
        if (k.c(r13) == false) goto L50;
        r8.setStroke(a(), s.a(r13, 0));
    L50:
        return r8;
    L19:
        if ((!StringsKt.isBlank(r13)) != true) goto L21;
        r7 = true;
        goto L22
    L9:
        r4 = false;
        goto L10
    L13:
        r5 = false;
    L16:
        r6 = false;
        goto L17
    }
}
