package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.logic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiLogicInfo {
    boolean dependHost() default false;

    ForeBackStrategyInfo foreBackStrategyInfo() default @ForeBackStrategyInfo;

    LoginStatusInfo loginStatusInfo() default @LoginStatusInfo;

    PermissionInfo permissionInfo() default @PermissionInfo;

    String[] relatedApi() default {};

    boolean uiRelated() default false;
}
