package com.bytedance.mt.protector.annotation;

import com.bytedance.mt.protector.e;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface CatchAllException {
    Class<?> handleClass() default e.class;

    String handleStaticMethod() default "handlerThrowable";

    String tag() default "ProtectorExceptionHandlerTag";
}
