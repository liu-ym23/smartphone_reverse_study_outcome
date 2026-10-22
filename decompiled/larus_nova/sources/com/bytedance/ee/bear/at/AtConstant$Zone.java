package com.bytedance.ee.bear.at;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes15.dex */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface AtConstant$Zone {
    public static final String DEFAULT = "default";
    public static final String FULL_COMMENT = "full_comment";
    public static final String FULL_SCREEN_TOOLBAR = "full_screen_toolbar";
    public static final String FX_BAR = "fx_bar";
    public static final String PART_COMMENT = "part_comment";
}
