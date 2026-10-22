package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import androidx.room.RoomDatabase;
import com.bytedance.ee.util.db.DBController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CCMLynxCacheManager {
    public static final Lazy<CCMLynxCacheManager> a = null;

    public static final class a {
    }

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CCMLynxCacheManager$Companion$instance$2.INSTANCE);
    }

    public CCMLynxCacheManager() {
        RoomDatabase.Callback r0 = new CCMLynxCacheManager$mCallback$1();
        DBController.a r1 = new DBController.a(eu5.b.a);
        r1.a = "lynx_cache.db";
        r1.b = LynxCacheDatabase.class;
        r1.d = r0;
        DBController.a().W3("lynx_cache.db", r1);
    }

    public static LynxCacheDatabase a() {
        return (LynxCacheDatabase) DBController.a().r1("lynx_cache.db");
    }
}
