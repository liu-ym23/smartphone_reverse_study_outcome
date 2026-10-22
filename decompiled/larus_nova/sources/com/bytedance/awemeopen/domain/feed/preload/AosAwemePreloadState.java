package com.bytedance.awemeopen.domain.feed.preload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes44.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AosAwemePreloadState {
    public static final int PRELOADED = 1;
    public static final int PRELOAD_CACHE_INVALIDATE = -2;
    public static final int PRELOAD_FAIL_NONE = -1;
    public static final int PRELOAD_FAIL_PRIVACY = -100;
}
