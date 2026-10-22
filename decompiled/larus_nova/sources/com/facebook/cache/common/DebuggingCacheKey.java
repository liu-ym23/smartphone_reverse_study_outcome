package com.facebook.cache.common;

import android.net.Uri;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class DebuggingCacheKey extends SimpleCacheKey {
    private final Object mCallerContext;
    private final Uri mSourceUri;

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public DebuggingCacheKey(String r100, @Nullable Object r101, Uri r102) {
        super(r100);
        this.mCallerContext = r101;
        this.mSourceUri = r102;
    }
}
