package com.larksuite.framework.launch.annotation;

import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.LaunchMode;
import com.larksuite.framework.launch.task.Period;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes24.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface LaunchTask {
    Class<? extends ILaunchTask>[] dependencyOf() default {};

    Period earliestPeriod() default Period.APP_ONATTACHBASECONTEXT_END;

    Period latestPeriod() default Period.APP_ONCREATE_END;

    LaunchMode[] runInLaunchMode() default {LaunchMode.ALL};

    String[] runInProcess() default {"O^"};
}
