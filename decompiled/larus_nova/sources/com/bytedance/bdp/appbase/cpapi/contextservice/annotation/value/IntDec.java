package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface IntDec {
    IntDesc defaultValue() default @IntDesc(desc = "", value = 0);

    IntDesc[] invalidValues() default {};

    IntDesc maxValue() default @IntDesc(desc = "", value = Integer.MAX_VALUE);

    IntDesc minValue() default @IntDesc(desc = "", value = Integer.MIN_VALUE);

    IntDesc[] validValues() default {};
}
