package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.logic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LoginStatusInfo {
    boolean dependHostLogin() default false;

    boolean dependPlatformLogin() default false;
}
