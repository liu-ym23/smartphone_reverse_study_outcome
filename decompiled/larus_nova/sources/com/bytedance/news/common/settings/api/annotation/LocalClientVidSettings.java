package com.bytedance.news.common.settings.api.annotation;

/* JADX INFO: loaded from: classes21.dex */
public @interface LocalClientVidSettings {
    double percent();

    boolean resultBoolean() default false;

    double resultDouble() default 0.0d;

    float resultFloat() default 0.0f;

    int resultInt() default 0;

    long resultLong() default 0;

    String resultString() default "";

    String vid() default "";
}
