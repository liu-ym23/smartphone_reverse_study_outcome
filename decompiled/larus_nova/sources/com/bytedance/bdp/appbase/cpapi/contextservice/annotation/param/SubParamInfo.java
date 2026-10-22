package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value.ValueDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface SubParamInfo {
    boolean customize() default false;

    String desc();

    String param();

    boolean required() default false;

    String supportSdkVersion() default "";

    ValueDef valueDef();
}
