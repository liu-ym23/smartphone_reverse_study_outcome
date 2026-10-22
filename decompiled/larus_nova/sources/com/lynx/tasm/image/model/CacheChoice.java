package com.lynx.tasm.image.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes32.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CacheChoice {
    public static final int BITMAP = 1;
    public static final int DISK = 0;
}
