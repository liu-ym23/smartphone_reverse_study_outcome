package com.bytedance.locallife.adapter.live.impl.host.live;

import it6.k;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class LifeLivePluginJsbService implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f256505a;

    @Override // it6.k
    public final JSONObject c() {
        return ((com.bytedance.locallife.live.service.a) this.f256505a.getValue()).getRoomInfo();
    }

    public LifeLivePluginJsbService() {
        this.f256505a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, LifeLivePluginJsbService$poiLiveService$2.INSTANCE);
    }

    @Override // it6.k
    public final void b(HashMap<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        ((com.bytedance.locallife.live.service.a) this.f256505a.getValue()).openLiveLifeGrouponPage(r100);
    }

    @Override // it6.k
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "paramsJson");
        ((com.bytedance.locallife.live.service.a) this.f256505a.getValue()).j(r100, r101);
    }
}
