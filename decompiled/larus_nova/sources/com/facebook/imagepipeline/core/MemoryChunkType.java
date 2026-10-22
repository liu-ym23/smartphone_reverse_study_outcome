package com.facebook.imagepipeline.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface MemoryChunkType {
    public static final int BUFFER_MEMORY = 1;
    public static final int NATIVE_MEMORY = 0;
}
