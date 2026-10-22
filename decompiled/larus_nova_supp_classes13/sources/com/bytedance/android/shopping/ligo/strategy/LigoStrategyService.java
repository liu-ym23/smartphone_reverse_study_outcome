package com.bytedance.android.shopping.ligo.strategy;

import b93.b;
import b93.c;
import com.bytedance.android.livesdk.livecommerce.eventcenter.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LigoStrategyService implements c {
    public final ConcurrentHashMap<String, Object> a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Override // b93.c
    public final b b() {
        String r0 = "custom_event_".concat("live");
        xe3.a r1 = (xe3.a) this.b.getValue();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "sourceName");
        return r1;
    }

    public LigoStrategyService() {
        this.a = new ConcurrentHashMap();
        this.b = LazyKt.lazy(LigoStrategyService$eventSource$2.INSTANCE);
    }

    @Override // b93.c
    public final void a(f r3) {
        Intrinsics.checkNotNullParameter(r3, "handler");
        this.a.put("", r3);
    }
}
