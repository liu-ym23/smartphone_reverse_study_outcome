package lp5;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static GradientDrawable c(int r100, float[] r101) {
        GradientDrawable r102 = new GradientDrawable();
        if (r100 == 0) goto L5;
        r102.setColor(r100);
    L5:
        if (r101 == null) goto L7;
        r102.setCornerRadii(r101);
    L7:
        r102.setShape(0);
        return r102;
    }

    public static GradientDrawable e(int r100, ColorStateList r101) {
        GradientDrawable r102 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r102.setColor(r100);
    L6:
        if (0.0f == 0.0f) goto L8;
        r102.setCornerRadius(0.0f);
    L8:
        if (r101 == null) goto L10;
        r102.setColor(r101);
    L10:
        r102.setShape(0);
        return r102;
    }

    public static GradientDrawable a(int r100, float r101, ColorStateList r102) {
        float[] r103 = {0.0f, 0.0f, 0.0f, 0.0f, r101, r101, r101, r101};
        GradientDrawable r104 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r104.setColor(r100);
    L6:
        if (0.0f == 0.0f) goto L8;
        r104.setCornerRadius(0.0f);
    L8:
        r104.setCornerRadii(r103);
        if (r102 == null) goto L11;
        r104.setColor(r102);
    L11:
        r104.setShape(0);
        return r104;
    }

    public static GradientDrawable b(int r100, float r101, ColorStateList r102) {
        GradientDrawable r103 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r103.setColor(r100);
    L6:
        if (r101 == 0.0f) goto L8;
        r103.setCornerRadius(r101);
    L8:
        if (r102 == null) goto L10;
        r103.setColor(r102);
    L10:
        r103.setShape(0);
        return r103;
    }

    public static GradientDrawable d(int r100, float r101, ColorStateList r102) {
        float[] r103 = {r101, r101, 0.0f, 0.0f, 0.0f, 0.0f, r101, r101};
        GradientDrawable r104 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r104.setColor(r100);
    L6:
        if (0.0f == 0.0f) goto L8;
        r104.setCornerRadius(0.0f);
    L8:
        r104.setCornerRadii(r103);
        if (r102 == null) goto L11;
        r104.setColor(r102);
    L11:
        r104.setShape(0);
        return r104;
    }

    public static GradientDrawable f(int r100, float r101, ColorStateList r102) {
        float[] r103 = {0.0f, 0.0f, r101, r101, r101, r101, 0.0f, 0.0f};
        GradientDrawable r104 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r104.setColor(r100);
    L6:
        if (0.0f == 0.0f) goto L8;
        r104.setCornerRadius(0.0f);
    L8:
        r104.setCornerRadii(r103);
        if (r102 == null) goto L11;
        r104.setColor(r102);
    L11:
        r104.setShape(0);
        return r104;
    }

    public static GradientDrawable g(int r100, float r101, ColorStateList r102) {
        float[] r103 = {r101, r101, r101, r101, 0.0f, 0.0f, 0.0f, 0.0f};
        GradientDrawable r104 = new GradientDrawable();
        if (r100 == 0) goto L6;
        r104.setColor(r100);
    L6:
        if (0.0f == 0.0f) goto L8;
        r104.setCornerRadius(0.0f);
    L8:
        r104.setCornerRadii(r103);
        if (r102 == null) goto L11;
        r104.setColor(r102);
    L11:
        r104.setShape(0);
        return r104;
    }
}
