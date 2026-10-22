package com.ss.android.ugc.aweme.search.common.ab.host;

import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/host/TradeHostSettingsCacheManger;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class TradeHostSettingsCacheManger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TradeHostSettingsCacheManger f451423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f451424b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f451425c = null;

    private TradeHostSettingsCacheManger() {
    }

    static {
        f451423a = new TradeHostSettingsCacheManger();
        f451424b = new ConcurrentHashMap();
        new WeakHashMap();
        f451425c = new ConcurrentHashMap();
    }

    public static void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        f451424b.put(r100, r101);
    }
}
