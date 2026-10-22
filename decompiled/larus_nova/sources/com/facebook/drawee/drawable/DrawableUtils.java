package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableUtils {
    public DrawableUtils() {
    }

    public static int getOpacityFromColor(int r100) {
        int r101 = r100 >>> 24;
        if (r101 != 255) goto L6;
        return -1;
    L6:
        if (r101 != 0) goto L9;
        return -2;
    L9:
        return -3;
    }

    public static int multiplyColorAlpha(int r100, int r101) {
        if (r101 != 255) goto L6;
        return r100;
    L6:
        if (r101 == 0) goto L8;
        int r102 = r101 + (r101 >> 7);
        int r103 = (((r100 >>> 24) * r102) >> 8) << 24;
        return (r100 & 16777215) | r103;
    L8:
        return r100 & 16777215;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static Drawable cloneDrawable(Drawable r100) {
        if ((r100 instanceof CloneableDrawable) == true) goto L5;
        Drawable.ConstantState r101 = r100.getConstantState();
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.newDrawable();
    L5:
        return ((CloneableDrawable) r100).cloneDrawable();
    }

    public static void copyProperties(@Nullable Drawable r100, @Nullable Drawable r101) {
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        if (r100 == r101) goto L10;
        r100.setBounds(r101.getBounds());
        r100.setChangingConfigurations(r101.getChangingConfigurations());
        r100.setLevel(r101.getLevel());
        r100.setVisible(r101.isVisible(), false);
        r100.setState(r101.getState());
        return;
    L10:
        return;
    L9:
        return;
    }

    public static void setDrawableProperties(@Nullable Drawable r100, @Nullable DrawableProperties r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r101.applyTo(r100);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCallbacks(@Nullable Drawable r100, @Nullable Drawable.Callback r101, @Nullable TransformCallback r102) {
        if (r100 == 0) goto L7;
        r100.setCallback(r101);
        if ((r100 instanceof TransformAwareDrawable) == false) goto L8;
        ((TransformAwareDrawable) r100).setTransformCallback(r102);
        return;
    L8:
        return;
    }
}
