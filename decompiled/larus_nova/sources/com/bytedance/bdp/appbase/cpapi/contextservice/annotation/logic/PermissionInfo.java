package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.logic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface PermissionInfo {
    int[] dependAppPermissions() default {};

    int[] dependPrivacyScopes() default {};

    String[] dependSystemPermissions() default {};

    boolean isWhitelistApi() default false;

    int[] runtimeAppPermissions() default {};

    String[] runtimeSystemPermissions() default {};
}
