package com.lynx.base.memory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes32.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface MemoryPressureLevel {
    public static final int CRITICAL = 2;
    public static final int MAX_VALUE = 2;
    public static final int MODERATE = 1;
    public static final int NONE = 0;
}
