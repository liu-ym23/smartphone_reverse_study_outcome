package com.bytedance.article.common.jsbridge.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface JsMethodPrivilege {
    public static final String PRIVILEGE_LEGACY = "legacy";
    public static final String PRIVILEGE_PROTECTED = "protected";
    public static final String PRIVILEGE_PUBLIC = "public";
}
