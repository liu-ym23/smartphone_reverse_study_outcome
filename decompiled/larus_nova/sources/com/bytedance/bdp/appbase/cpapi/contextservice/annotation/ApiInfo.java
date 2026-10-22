package com.bytedance.bdp.appbase.cpapi.contextservice.annotation;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.callback.ApiCallbackInfo;
import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.desc.ApiDescInfo;
import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.invoke.ApiInvokeInfo;
import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.logic.ApiLogicInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiInfo {
    ApiCallbackInfo callbackInfo();

    boolean dependAppContext() default true;

    ApiDescInfo descInfo();

    ApiInvokeInfo invokeInfo();

    ApiLogicInfo logicInfo() default @ApiLogicInfo;
}
