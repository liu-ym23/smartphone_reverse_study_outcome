package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface LongDec {
    LongDesc defaultValue() default @LongDesc(desc = "", value = 0);

    LongDesc[] invalidValues() default {};

    LongDesc maxValue() default @LongDesc(desc = "", value = Long.MAX_VALUE);

    LongDesc minValue() default @LongDesc(desc = "", value = Long.MIN_VALUE);

    LongDesc[] validValues() default {};
}
