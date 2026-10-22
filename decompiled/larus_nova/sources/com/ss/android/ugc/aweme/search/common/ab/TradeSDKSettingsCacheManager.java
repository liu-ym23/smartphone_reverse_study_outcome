package com.ss.android.ugc.aweme.search.common.ab;

import com.google.gson.Gson;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/TradeSDKSettingsCacheManager;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class TradeSDKSettingsCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TradeSDKSettingsCacheManager f451417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f451418b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f451419c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f451420d = null;

    private TradeSDKSettingsCacheManager() {
    }

    static {
        f451417a = new TradeSDKSettingsCacheManager();
        f451418b = new ConcurrentHashMap();
        f451419c = new ConcurrentHashMap();
        new WeakHashMap();
        f451420d = LazyKt.lazy(TradeSDKSettingsCacheManager$gson$2.INSTANCE);
    }

    public static Gson a() {
        return (Gson) f451420d.getValue();
    }

    public static void b(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f451418b.put(r100, r101);
    }
}
