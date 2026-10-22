package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class StraightOutPrefetchTask extends com.bytedance.android.shopping.mall.homepage.preload.a<Pair<? extends HomePageDTO, ? extends com.bytedance.android.ec.hybrid.list.entity.k>> {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;

    public static final class a {
    }

    static {
        new LinkedHashMap();
        new LinkedHashMap();
        a = LazyKt.lazy(StraightOutPrefetchTask$Companion$imagePrefetchOpt$2.INSTANCE);
        b = LazyKt.lazy(StraightOutPrefetchTask$Companion$imagePrefetchStrategy$2.INSTANCE);
        c = LazyKt.lazy(StraightOutPrefetchTask$Companion$domainConnectOptEnable$2.INSTANCE);
        d = LazyKt.lazy(StraightOutPrefetchTask$Companion$preloadCacheDataStrategy$2.INSTANCE);
    }
}
