package com.bytedance.pia.core.tracing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface FeatureStatus$NSRStatus {
    public static final int BUILD_FLAG_ERROR = 2;
    public static final int CACHE_CAN_NOT_USE = 5;
    public static final int DISABLE = 1;
    public static final int MANIFEST_VERSION_NOT_MATCH = 4;
    public static final int NO_VALID_CACHE = 3;
    public static final int SUCCESS = 0;
    public static final int SWITCH_NOT_MATCH = 6;
    public static final int UNKNOWN = -1;
}
