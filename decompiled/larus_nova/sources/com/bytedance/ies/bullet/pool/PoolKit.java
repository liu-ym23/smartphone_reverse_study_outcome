package com.bytedance.ies.bullet.pool;

import com.bytedance.ies.bullet.service.base.k;
import com.bytedance.ies.bullet.service.base.o0;
import com.bytedance.ies.bullet.service.base.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class PoolKit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f247453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f247455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.ies.bullet.pool.impl.c f247456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.ies.bullet.pool.impl.f f247457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o0 f247458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f247459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f247460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f247461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f247462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f247463k;

    public static final class a {
    }

    static {
    }

    public PoolKit(z r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "bid");
        this.f247453a = r100;
        this.f247454b = r101;
        e.b r102 = r100.d();
        this.f247455c = r102;
        r100.c();
        this.f247456d = new com.bytedance.ies.bullet.pool.impl.c(3, r102);
        r100.a();
        this.f247457e = new com.bytedance.ies.bullet.pool.impl.f(3);
        this.f247458f = r100.b();
        this.f247459g = LazyKt.lazy(PoolKit$mainHandler$2.INSTANCE);
        this.f247460h = LazyKt.lazy(PoolKit$enableBulletPrerenderGovern$2.INSTANCE);
        this.f247461i = LazyKt.lazy(PoolKit$preRenderMinFreeMemory$2.INSTANCE);
        this.f247462j = LazyKt.lazy(PoolKit$preRenderMaxCacheTime$2.INSTANCE);
        this.f247463k = LazyKt.lazy(PoolKit$enableBulletPrerenderCallMonitor$2.INSTANCE);
    }
}
