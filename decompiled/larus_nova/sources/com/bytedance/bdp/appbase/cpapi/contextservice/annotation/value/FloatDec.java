package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface FloatDec {
    FloatDesc defaultValue() default @FloatDesc(desc = "", value = 0.0f);

    FloatDesc[] invalidValues() default {};

    FloatDesc maxValue() default @FloatDesc(desc = "", value = Float.MAX_VALUE);

    FloatDesc minValue() default @FloatDesc(desc = "", value = Float.MIN_VALUE);

    FloatDesc[] validValues() default {};
}
