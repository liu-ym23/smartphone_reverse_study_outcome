package com.bytedance.timonbase.sensitive.detect.cacher;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes22.dex */
public final class TMSensitiveContentCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270900a = null;

    static {
        f270900a = LazyKt.lazy(TMSensitiveContentCacheManager$cacheTable$2.INSTANCE);
        new ConcurrentHashMap();
    }
}
