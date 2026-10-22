package com.ss.android.ugc.bytex.code_shrinker.library;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes40.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface ShrinkWithDefault {
    String[] skipPatterns() default {};

    ShrinkType type() default ShrinkType.INVOKE;

    String value();
}
