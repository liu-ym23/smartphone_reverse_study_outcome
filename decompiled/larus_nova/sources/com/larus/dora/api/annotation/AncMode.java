package com.larus.dora.api.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AncMode {
    public static final int NOISE_CANCELLING = 1;
    public static final int OFF = 0;
    public static final int TRANSPARENCY = 2;
    public static final int UNKNOWN = -1;
}
