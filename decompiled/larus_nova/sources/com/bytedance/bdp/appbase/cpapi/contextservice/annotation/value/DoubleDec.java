package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface DoubleDec {
    DoubleDesc defaultValue() default @DoubleDesc(desc = "", value = 0.0d);

    DoubleDesc[] invalidValues() default {};

    DoubleDesc maxValue() default @DoubleDesc(desc = "", value = Double.MAX_VALUE);

    DoubleDesc minValue() default @DoubleDesc(desc = "", value = Double.MIN_VALUE);

    DoubleDesc[] validValues() default {};
}
