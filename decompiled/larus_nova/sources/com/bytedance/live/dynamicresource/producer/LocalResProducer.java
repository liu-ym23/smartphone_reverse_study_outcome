package com.bytedance.live.dynamicresource.producer;

import com.bytedance.live.dynamicresource.client.ResourceClientContext;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class LocalResProducer<EntranceModel, LayoutConfig, RouterKey> implements a<EntranceModel, LayoutConfig, RouterKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<RouterKey, LayoutConfig> f255138a;

    public LocalResProducer() {
        this.f255138a = new LinkedHashMap();
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final LayoutConfig c(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f255138a.containsKey(r100) == true) goto L7;
        return null;
    L7:
        return (LayoutConfig) ((LinkedHashMap) this.f255138a).get(r100);
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final void a(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101, LayoutConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "res");
        this.f255138a.put(r100, r102);
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final Disposable b(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101, Function1<? super LayoutConfig, Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "onSuccess");
        Intrinsics.checkNotNullParameter(r103, "onFail");
        int r104 = h.f267513a;
        return h.a(LocalResProducer$produceAsync$1.INSTANCE);
    }
}
