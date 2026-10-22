package com.bytedance.pia.core.tracing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes21.dex */
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
public @interface FeatureStatus$SSRStatus {
    public static final int BUILD_FLAG_ERROR = 2;
    public static final int DISABLE = 1;
    public static final int DOWNGRADE_CSR = 3;
    public static final int FALLBACK_CUSTOM = 15;
    public static final int FALLBACK_ERROR = 13;
    public static final int FALLBACK_HEADER = 12;
    public static final int FALLBACK_MIDDLEWARE = 14;
    public static final int FALLBACK_QUERY = 11;
    public static final int SUCCESS = 0;
    public static final int UNKNOWN = -1;
}
