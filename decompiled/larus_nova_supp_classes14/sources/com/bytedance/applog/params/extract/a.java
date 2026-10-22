package com.bytedance.applog.params.extract;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends LruCache<String, ParamsExtractDao.a> {
    public a() {
        super(128);
    }

    @Override // android.util.LruCache
    public final int sizeOf(String r2, ParamsExtractDao.a r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        return 1;
    }
}
