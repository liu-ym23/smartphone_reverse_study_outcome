package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallPreloadTaskManager implements com.bytedance.android.shopping.api.mall.m {
    public final Lazy a;
    public final ConcurrentHashMap<String, com.bytedance.android.shopping.api.mall.l<? extends Object>> b;
    public final List<String> c;
    public final Object d;
    public volatile int e;
    public volatile Boolean f;
    public final List<com.bytedance.android.shopping.api.mall.m.b> g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final void a() {
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final void b() {
        this.e = 4;
        if (this.e == 1) goto L6;
        this.b.clear();
        return;
    }

    public MallPreloadTaskManager() {
        r.a r0 = r.a.b;
        this.a = LazyKt.lazy(MallPreloadTaskManager$preloadCachedDataOptEnable$2.INSTANCE);
        this.b = new ConcurrentHashMap();
        this.c = new ArrayList();
        this.d = new Object();
        this.g = new ArrayList();
        new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final Boolean c() {
        return this.f;
    }

    @Override // com.bytedance.android.shopping.api.mall.m
    public final <T> T d(String r4, Map<String, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "name");
        T r1 = null;
        if (this.e != 4) goto L5;
        return null;
    L5:
        Object r6 = this.d;
        monitor-enter(r6);
    L23:
        th = move-exception;
        throw th;
    L8:
        if (((ArrayList) this.c).contains(r4) == false) goto L11;
        monitor-exit(r6);
        return null;
    L11:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r6);
        com.bytedance.android.shopping.api.mall.l<? extends Object> r7 = this.b.get(r4);
        if (r7 == null) goto L16;
        Object r8 = r7.a();
    L18:
        if ((r8 instanceof Object) == false) goto L21;
        r1 = (T) r8;
    L21:
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.a.b, "preload task " + r4 + " result is " + r1);
        this.b.remove(r4);
        return r1;
    L16:
        r8 = null;
        goto L18
    }
}
