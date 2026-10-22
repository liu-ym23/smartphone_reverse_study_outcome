package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param;

import com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value.ValueDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ParamInfo {
    boolean customize() default false;

    String desc();

    boolean justForCode() default false;

    String param();

    boolean required() default false;

    SubParam subParam() default @SubParam;

    String supportSdkVersion() default "";

    boolean templateCodeWithPrefix() default false;

    ValueDef valueDef();
}
