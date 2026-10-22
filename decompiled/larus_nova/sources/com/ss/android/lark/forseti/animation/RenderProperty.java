package com.ss.android.lark.forseti.animation;

import android.util.Property;
import android.view.View;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes36.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface RenderProperty {
    public static final int ALPHA = 11;
    public static final int ROTATION = 5;
    public static final int ROTATION_X = 6;
    public static final int ROTATION_Y = 7;
    public static final int SCALE_X = 3;
    public static final int SCALE_Y = 4;
    public static final int TRANSLATION_X = 0;
    public static final int TRANSLATION_Y = 1;
    public static final int TRANSLATION_Z = 2;
    public static final Property<View, Float>[] VIEW_PROPERTY = null;
    public static final int X = 8;
    public static final int Y = 9;
    public static final int Z = 10;

    static {
        VIEW_PROPERTY = new Property[]{View.TRANSLATION_X, View.TRANSLATION_Y, View.TRANSLATION_Z, View.SCALE_X, View.SCALE_Y, View.ROTATION, View.ROTATION_X, View.ROTATION_Y, View.X, View.Y, View.Z, View.ALPHA};
    }
}
