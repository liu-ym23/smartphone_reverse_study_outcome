package com.bytedance.bdp.appbase.json.annotation.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes11.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface IntRange {
    int from() default Integer.MIN_VALUE;

    boolean includeMax() default true;

    boolean includeMin() default true;

    int to() default Integer.MAX_VALUE;
}
