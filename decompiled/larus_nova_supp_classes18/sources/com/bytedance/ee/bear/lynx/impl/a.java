package com.bytedance.ee.bear.lynx.impl;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.CCMLynxCacheManager;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.LynxCacheDatabase;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.h;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ee.util.io.FileUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements com.bytedance.ee.bear.lynx.api.a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.lynx.impl.a$a, reason: collision with other inner class name */
    public static final class C0037a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.lynx.api.a
    public final void clearCache() {
        ((CCMLynxCacheManager) CCMLynxCacheManager.a.getValue()).getClass();
        LynxCacheDatabase r0 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L7
        ((h) r0.c()).b();     // Catch: Exception -> L7
        LynxCacheDatabase r1 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L7
        if (r1.getOpenHelper().getWritableDatabase().inTransaction() == true) goto L12;
        LynxCacheDatabase r2 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r2);     // Catch: Exception -> L7
        r2.getOpenHelper().getWritableDatabase().execSQL("VACUUM");     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        iu5.d.c(e);
    }

    @Override // com.bytedance.ee.bear.lynx.api.a
    public final long getCacheSize() {
        long r0 = FileUtils.y(eu5.b.a.getDatabasePath(DBController.a().Aa(eu5.b.a, "lynx_cache.db")).getAbsolutePath());
        tt5.a.h("CCMLynxCacheServiceImpl", "getCacheSize()... size = " + r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.lynx.api.a
    public final void a(long r2) {
        ((CCMLynxCacheManager) CCMLynxCacheManager.a.getValue()).getClass();
        LynxCacheDatabase r0 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L7
        ((h) r0.c()).a(r2);     // Catch: Exception -> L7
        LynxCacheDatabase r3 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L7
        if (r3.getOpenHelper().getWritableDatabase().inTransaction() == true) goto L12;
        LynxCacheDatabase r4 = CCMLynxCacheManager.a();     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L7
        r4.getOpenHelper().getWritableDatabase().execSQL("VACUUM");     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        iu5.d.c(e);
    }
}
