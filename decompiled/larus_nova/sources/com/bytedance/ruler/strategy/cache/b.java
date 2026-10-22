package com.bytedance.ruler.strategy.cache;

import com.bytedance.common.utility.DigestUtils;
import com.bytedance.ruler.d;
import com.bytedance.ruler.strategy.utils.EventCenter;
import com.bytedance.ruler.utils.g;
import com.bytedance.ruler.utils.h;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, a> f267711a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f267712b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f267713c = null;

    public b() {
    }

    static {
        f267713c = new b();
        f267711a = new HashMap();
        g r100 = d.f267686j;
        if (r100 == null) goto L5;
        fh7.d r101 = r100.b("source_rules_v416");
    L6:
        f267712b = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final a a(String r100) {
        HashMap<String, a> r101 = f267711a;
        a r102 = r101.get(r100);
        if (r102 != null) goto L16;
        r102 = new a(r100);
        monitor-enter(this);
        a r103 = r101.get(r100);     // Catch: Throwable -> L13
        if (r103 != null) goto L9;
        r101.put(r100, r102);     // Catch: Throwable -> L13
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        goto L16
    L9:
        r102 = r103;
    L13:
        th = move-exception;
        throw th;
    L16:
        return r102;
    }

    public static void b(final String r100, String r101) {
        final String r102 = DigestUtils.md5Hex(r101);
        h r103 = f267712b;
        if (r103 == null) goto L5;
        String r104 = r103.get(r100);
    L7:
        if (Intrinsics.areEqual(r104, r102) == false) goto L9;
        int r105 = EventCenter.f267745a;
        EventCenter.b(new StrategyCacheManagerFactory$initCache$1(r100), "com.bytedance.ruler.strategy.cache.StrategyCacheManager.sync");
        return;
    L9:
        int r106 = EventCenter.f267745a;
        EventCenter.b(new StrategyCacheManagerFactory$initCache$2(r100, r102), "com.bytedance.ruler.strategy.cache.StrategyCacheManager.rebuild");
        return;
    L5:
        r104 = null;
        goto L7
    }
}
