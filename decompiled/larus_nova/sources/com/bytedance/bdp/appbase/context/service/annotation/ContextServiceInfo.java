package com.bytedance.bdp.appbase.context.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes11.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface ContextServiceInfo {
    String category() default "BDP";

    String desc() default "not configured Service info";

    String owner() default "BDP";

    String since() default "unknown";

    String title() default "BDP";
}
