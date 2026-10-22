package com.bytedance.lego.init.annotation;

import com.bytedance.lego.init.model.DelayTime;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes20.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface DelayTask {
    DelayTime delayTime() default DelayTime.SECOND_60;

    String desc();

    int executePriority() default 0;

    String id() default "";

    String moduleName() default "";

    boolean mustRunInMainThread();

    String[] runInProcess();
}
