package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.callback;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param.ParamInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CallbackFailScene {
    String alias();

    ParamInfo[] callbackParams() default {};

    String desc();

    int errCode() default 0;

    int errNo();

    String errType() default "";

    String extraInfo();

    String[] extraInfoArgsDesc() default {};

    boolean isDeveloperError() default false;

    String repairSuggestion();

    boolean supportExtra() default false;
}
