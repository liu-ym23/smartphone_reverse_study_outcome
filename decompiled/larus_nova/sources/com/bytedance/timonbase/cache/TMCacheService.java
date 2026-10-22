package com.bytedance.timonbase.cache;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.timon.foundation.interfaces.IStoreRepo;
import com.bytedance.timonbase.TMInjection;
import com.bytedance.timonbase.network.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class TMCacheService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f270800a = null;

    public static IStoreRepo b() {
        return (IStoreRepo) f270800a.getValue();
    }

    static {
        f270800a = LazyKt.lazy(TMCacheService$repo$2.INSTANCE);
    }

    public static b a() {
        String r100 = b().getString("item_config", null);
        if (r100 != null) goto L5;
        return null;
    L5:
        return (b) GsonProtectorUtils.fromJson(TMInjection.a(), r100, b.class);
    }
}
