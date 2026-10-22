package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.callback;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param.ParamInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CallbackOkScene {
    ParamInfo[] callbackParams();

    String callbackParamsWarpKey() default "";

    boolean customizeCallbackParams() default false;

    String desc();
}
