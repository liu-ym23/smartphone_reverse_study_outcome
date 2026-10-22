package com.bytedance.bdp.appbase.cpapi.contextservice.annotation.value;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ValueDef {
    BooleanDec booleanDec() default @BooleanDec;

    DoubleDec doubleDec() default @DoubleDec;

    FloatDec floatDec() default @FloatDec;

    IntDec intDec() default @IntDec;

    LongDec longDec() default @LongDec;

    ObjectDec objectDec() default @ObjectDec;

    StringDec stringDec() default @StringDec;
}
