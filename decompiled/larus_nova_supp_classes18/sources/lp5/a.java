package lp5;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static GradientDrawable c(int r1, float[] r2) {
        GradientDrawable r0 = new GradientDrawable();
        if (r1 == 0) goto L5;
        r0.setColor(r1);
    L5:
        if (r2 == null) goto L7;
        r0.setCornerRadii(r2);
    L7:
        r0.setShape(0);
        return r0;
    }

    public static GradientDrawable e(int r2, ColorStateList r3) {
        GradientDrawable r0 = new GradientDrawable();
        if (r2 == 0) goto L6;
        r0.setColor(r2);
    L6:
        if (0.0f == 0.0f) goto L8;
        r0.setCornerRadius(0.0f);
    L8:
        if (r3 == null) goto L10;
        r0.setColor(r3);
    L10:
        r0.setShape(0);
        return r0;
    }

    public static GradientDrawable a(int r4, float r5, ColorStateList r6) {
        float[] r0 = {0.0f, 0.0f, 0.0f, 0.0f, r5, r5, r5, r5};
        GradientDrawable r7 = new GradientDrawable();
        if (r4 == 0) goto L6;
        r7.setColor(r4);
    L6:
        if (0.0f == 0.0f) goto L8;
        r7.setCornerRadius(0.0f);
    L8:
        r7.setCornerRadii(r0);
        if (r6 == null) goto L11;
        r7.setColor(r6);
    L11:
        r7.setShape(0);
        return r7;
    }

    public static GradientDrawable b(int r1, float r2, ColorStateList r3) {
        GradientDrawable r0 = new GradientDrawable();
        if (r1 == 0) goto L6;
        r0.setColor(r1);
    L6:
        if (r2 == 0.0f) goto L8;
        r0.setCornerRadius(r2);
    L8:
        if (r3 == null) goto L10;
        r0.setColor(r3);
    L10:
        r0.setShape(0);
        return r0;
    }

    public static GradientDrawable d(int r4, float r5, ColorStateList r6) {
        float[] r0 = {r5, r5, 0.0f, 0.0f, 0.0f, 0.0f, r5, r5};
        GradientDrawable r7 = new GradientDrawable();
        if (r4 == 0) goto L6;
        r7.setColor(r4);
    L6:
        if (0.0f == 0.0f) goto L8;
        r7.setCornerRadius(0.0f);
    L8:
        r7.setCornerRadii(r0);
        if (r6 == null) goto L11;
        r7.setColor(r6);
    L11:
        r7.setShape(0);
        return r7;
    }

    public static GradientDrawable f(int r4, float r5, ColorStateList r6) {
        float[] r0 = {0.0f, 0.0f, r5, r5, r5, r5, 0.0f, 0.0f};
        GradientDrawable r7 = new GradientDrawable();
        if (r4 == 0) goto L6;
        r7.setColor(r4);
    L6:
        if (0.0f == 0.0f) goto L8;
        r7.setCornerRadius(0.0f);
    L8:
        r7.setCornerRadii(r0);
        if (r6 == null) goto L11;
        r7.setColor(r6);
    L11:
        r7.setShape(0);
        return r7;
    }

    public static GradientDrawable g(int r3, float r4, ColorStateList r5) {
        float[] r0 = {r4, r4, r4, r4, 0.0f, 0.0f, 0.0f, 0.0f};
        GradientDrawable r6 = new GradientDrawable();
        if (r3 == 0) goto L6;
        r6.setColor(r3);
    L6:
        if (0.0f == 0.0f) goto L8;
        r6.setCornerRadius(0.0f);
    L8:
        r6.setCornerRadii(r0);
        if (r5 == null) goto L11;
        r6.setColor(r5);
    L11:
        r6.setShape(0);
        return r6;
    }
}
