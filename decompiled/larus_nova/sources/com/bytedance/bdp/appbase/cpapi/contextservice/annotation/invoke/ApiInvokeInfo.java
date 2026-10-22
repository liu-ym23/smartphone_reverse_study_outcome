package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.invoke;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param.ParamInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiInvokeInfo {
    Class invokeParamClass() default void.class;

    ParamInfo[] invokeParams() default {};

    String invoker() default "frontEndEnv";

    int poolCount() default -1;

    String scheduler() default "pool";
}
