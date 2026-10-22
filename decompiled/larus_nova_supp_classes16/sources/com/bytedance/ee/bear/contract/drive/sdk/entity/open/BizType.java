package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
public @interface BizType {
    public static final int BIZ_TYPE_IM_FILE = 3;
    public static final int BIZ_TYPE_LOCAL = 1;
    public static final int BIZ_TYPE_SPACE_ATTACHMENT = 4;
    public static final int BIZ_TYPE_SPACE_FILE = 2;
    public static final int BIZ_TYPE_SPACE_THIRDPARTY_ATTACHMENT = 5;
}
