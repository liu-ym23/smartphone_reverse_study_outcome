package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.param;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface SubParam {
    Class genericType() default JSONObject.class;

    SubParamInfo[] subParams() default {};
}
