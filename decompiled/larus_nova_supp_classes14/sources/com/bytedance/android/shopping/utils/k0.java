package com.bytedance.android.shopping.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k0 {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = k0.a;     // Catch: Throwable -> L4
            k0.c(this.a, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public static String a(long r5) {
        if (r5 < 100000000) goto L7;
        DecimalFormat r1 = new DecimalFormat("0.0");
        r1.setRoundingMode(RoundingMode.HALF_UP);
        return com.bytedance.android.shopping.extensions.j.d(2131895787, r1.format(Float.valueOf(r5 / 100000000)));
    L7:
        if (r5 < 10000) goto L11;
        DecimalFormat r2 = new DecimalFormat("0.0");
        r2.setRoundingMode(RoundingMode.HALF_UP);
        return com.bytedance.android.shopping.extensions.j.d(2131895789, r2.format(Float.valueOf(r5 / 10000)));
    L11:
        return String.valueOf(r5);
    }

    public static String b(long r8) {
        long r1 = 10000;
        float r2 = r8;
        if (r8 < r1) goto L6;
        r2 = r2 + 0.5f;
    L6:
        if (r8 < 100000000) goto L9;
        DecimalFormat r9 = new DecimalFormat("0.0");
        r9.setRoundingMode(RoundingMode.FLOOR);
        return com.bytedance.android.shopping.extensions.j.d(2131895788, r9.format(Float.valueOf(r2 / 100000000)));
    L9:
        if (r8 < r1) goto L13;
        DecimalFormat r10 = new DecimalFormat("0.0");
        r10.setRoundingMode(RoundingMode.FLOOR);
        return com.bytedance.android.shopping.extensions.j.d(2131895790, r10.format(Float.valueOf(r2 / 10000)));
    L13:
        return String.valueOf(r8);
    }

    public static void c(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Drawable r0 = r3.getBackground();
        if ((r0 instanceof GradientDrawable) == true) goto L5;
        r0 = null;
    L5:
        GradientDrawable r1 = (GradientDrawable) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        float r2 = RangesKt.coerceAtMost(r3.getWidth(), r3.getHeight()) / 2.0f;
        if (r2 > 0) goto L13;
        if (r4 == false) goto L15;
        r3.post(new a(r3));
        return;
    L15:
        return;
    L13:
        r1.setCornerRadius(r2);
    }

    public static void d(TextView r6, String r7, float r8) {
        Intrinsics.checkNotNullParameter(r6, "textView");
        if (r7 != null) goto L5;
        return;
    L5:
        TextPaint r0 = r6.getPaint();
        int r1 = g1.a;
        if (r6.getPaint().measureText(r7) > (r8 - r0.measureText(g1.a.c(r6.getContext(), 2131895741, new Object[]{""})))) goto L9;
        r6.setText(r7);
        return;
    L9:
        String r2 = r7;
    L11:
        if (r6.getPaint().measureText(r7) <= r8) goto L18;
        if (a2.b(r2) == false) goto L18;
        if (r2 == null) goto L16;
        String r9 = r2.substring(0, r2.length() - 1);
    L17:
        r2 = r9;
        int r10 = g1.a;
        r7 = g1.a.c(r6.getContext(), 2131895741, new Object[]{r2});
        goto L11
    L16:
        r9 = null;
    L18:
        r6.setText(r7);
    }
}
