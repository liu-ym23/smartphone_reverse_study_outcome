package com.larus.bmhome.upload;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f314760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, mr9.e> f314761b = null;

    public h() {
    }

    static {
        f314760a = new h();
        f314761b = new ConcurrentHashMap();
    }

    public final mr9.e query(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        mr9.e r101 = f314761b.get(r100);
        FLogger.f375446a.i("VideoResourceMetaStore", "[query] " + r100 + ':' + r101);
        return r101;
    }

    public static void a(String r100, mr9.e r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r101, "meta");
        Intrinsics.checkNotNullParameter(r102, "from");
        FLogger.f375446a.i("VideoResourceMetaStore", "[record] identifier:" + r100 + ", from:" + r102 + ", meta:" + r101);
        f314761b.put(r100, r101);
    }
}
