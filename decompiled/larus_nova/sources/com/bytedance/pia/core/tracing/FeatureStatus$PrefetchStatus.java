package com.bytedance.pia.core.tracing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface FeatureStatus$PrefetchStatus {
    public static final int BOOT_TIMEOUT = 3;
    public static final int DATA_TIMEOUT = 7;
    public static final int DISABLE = 1;
    public static final int FETCH_DATA_CODE_ERROR = 8;
    public static final int HTML_ERROR = 6;
    public static final int MANIFEST_VERSION_NOT_MATCH = 5;
    public static final int SUCCESS = 0;
    public static final int UNKNOWN = -1;
    public static final int WORKER_BOOT_ERROR = 4;
    public static final int WORKER_RUNTIME_ERROR = 2;
}
