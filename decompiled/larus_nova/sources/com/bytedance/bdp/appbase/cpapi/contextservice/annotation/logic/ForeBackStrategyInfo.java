package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.logic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ForeBackStrategyInfo {
    boolean interceptWhenBackgroundOverLimitTime() default false;

    boolean notBlockWhenBackground() default false;
}
