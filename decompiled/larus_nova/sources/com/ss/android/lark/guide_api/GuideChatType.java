package com.ss.android.lark.guide_api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes36.dex */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface GuideChatType {
    public static final int TO_CUSTOMER_GROUP = 2;
    public static final int TO_FLOW = 3;
    public static final int TO_GROUP = 1;
    public static final int TO_SELF = 0;
}
