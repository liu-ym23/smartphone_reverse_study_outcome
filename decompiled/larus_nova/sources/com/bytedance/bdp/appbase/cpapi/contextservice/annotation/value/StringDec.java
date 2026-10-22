package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface StringDec {
    StringDesc defaultValue() default @StringDesc(desc = "", value = "");

    StringDesc[] invalidValues() default {};

    StringDesc[] validValues() default {};
}
