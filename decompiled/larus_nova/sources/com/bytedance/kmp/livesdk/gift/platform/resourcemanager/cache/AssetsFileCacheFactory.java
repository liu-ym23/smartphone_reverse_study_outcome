package com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.e;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class AssetsFileCacheFactory implements com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f252396a;

    public static final class a {
    }

    static {
    }

    public final String c() {
        return (String) this.f252396a.getValue();
    }

    public AssetsFileCacheFactory() {
        this.f252396a = LazyKt.lazy(AssetsFileCacheFactory$cacheRootDir$2.INSTANCE);
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a
    public final String a() {
        return c();
    }

    @Override // com.bytedance.kmp.livesdk.gift.platform.resourcemanager.cache.a
    public final String b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        StringBuilder r101 = new StringBuilder(c());
        String r102 = File.separator;
        r101.append(r102);
        r101.append(r100.f129101k);
        r101.append(r102);
        return r101.toString();
    }
}
