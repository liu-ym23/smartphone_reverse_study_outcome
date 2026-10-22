package com.bytedance.ee.bear.operation.api.event;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface OperationName {
    public static final String OPERATION_DOWNLOAD = "download";
    public static final String OPERATION_OFFLINE_AVAILABLE = "offline";
    public static final String OPERATION_OPEN_WITH_THIRD_APP = "open_with_other_app";
    public static final String OPERATION_SAVE_TO_LOCAL = "save_to_local";
    public static final String OPERATION_UNKNOWN = "unknown";
}
