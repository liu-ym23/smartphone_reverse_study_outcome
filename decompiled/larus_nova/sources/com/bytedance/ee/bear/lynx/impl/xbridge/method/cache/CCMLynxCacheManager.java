package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import androidx.room.RoomDatabase;
import com.bytedance.ee.util.db.DBController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes18.dex */
public final class CCMLynxCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<CCMLynxCacheManager> f229935a = null;

    public static final class a {
    }

    static {
        f229935a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, CCMLynxCacheManager$Companion$instance$2.INSTANCE);
    }

    public CCMLynxCacheManager() {
        RoomDatabase.Callback r100 = new CCMLynxCacheManager$mCallback$1();
        DBController.a r101 = new DBController.a(eu5.b.f474075a);
        r101.f243099a = "lynx_cache.db";
        r101.f243100b = LynxCacheDatabase.class;
        r101.f243102d = r100;
        DBController.a().W3("lynx_cache.db", r101);
    }

    public static LynxCacheDatabase a() {
        return (LynxCacheDatabase) DBController.a().r1("lynx_cache.db");
    }
}
