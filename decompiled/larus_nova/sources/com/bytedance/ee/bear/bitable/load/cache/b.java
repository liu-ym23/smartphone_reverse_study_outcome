package com.bytedance.ee.bear.bitable.load.cache;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.preload.BitablePreloadConfig;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements com.bytedance.ee.bear.bitable.load.cache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f214474a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.load.cache.a
    public final void clearAll() {
        tt5.a.h("MemPreloadDataManager", "clearAll memPreloadData");
        this.f214474a.evictAll();
    }

    public b() {
        BitablePreloadConfig.Companion.getClass();
        this.f214474a = new c(BitablePreloadConfig.a.a().getResourceMaxMemoryCacheSize());
    }

    @Override // com.bytedance.ee.bear.bitable.load.cache.a
    public final void b(BitableResourceData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = r100.getResValue().length();
        BitablePreloadConfig.Companion.getClass();
        if (r101 <= BitablePreloadConfig.a.a().getResourcePutInCacheLimitLength()) goto L6;
        tt5.a.k("MemPreloadDataManager", "setResourceData(size:" + r100.getResValue().length() + ") is too big, return.");
        return;
    L6:
        this.f214474a.put(new c.a(r100.getBaseToken(), r100.getBlockId(), r100.getResKey(), r100.getObjToken()), r100);
    }

    @Override // com.bytedance.ee.bear.bitable.load.cache.a
    public final BitableResourceData a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "baseToken");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r102, "resKey");
        Intrinsics.checkNotNullParameter(r103, "objToken");
        return this.f214474a.get(new c.a(r100, r101, r102, r103));
    }
}
