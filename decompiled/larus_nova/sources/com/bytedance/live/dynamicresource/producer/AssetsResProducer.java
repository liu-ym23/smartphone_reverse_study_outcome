package com.bytedance.live.dynamicresource.producer;

import com.bytedance.live.dynamicresource.client.ResourceClientContext;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import th6.c;

/* JADX INFO: loaded from: classes19.dex */
public final class AssetsResProducer<EntranceModel, LayoutConfig, RouterKey> implements a<EntranceModel, LayoutConfig, RouterKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f255133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public EntranceModel f255134b;

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final void a(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101, LayoutConfig r102) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "res");
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final LayoutConfig c(RouterKey r100, ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r101) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public AssetsResProducer(th6.a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f255133a = r100;
    }

    @Override // com.bytedance.live.dynamicresource.producer.a
    public final Disposable b(final RouterKey r110, final ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r111, final Function1<? super LayoutConfig, Unit> r112, final Function1<? super Throwable, Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, "routerKey");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        Intrinsics.checkNotNullParameter(r113, "onFail");
        int r100 = h.f267513a;
        final Disposable r101 = h.a(AssetsResProducer$produceAsync$disposable$1.INSTANCE);
        EntranceModel r102 = this.f255134b;
        final Function1<EntranceModel, Unit> r103 = new AssetsResProducer$produceAsync$doGetRes$1(this, r110, r111, r101, r112, r113);
        if (r102 != null) goto L5;
        c r114 = this.f255133a;
        String r115 = r111.f255114e;
        Intrinsics.checkNotNullParameter(r115, "fileName");
        r114.getResAsync(r111.f255112c + '/' + r111.f255113d + '/' + r115, r111.f255116g, new AssetsResProducer$getEntranceFile$1(this, r103), new AssetsResProducer$getEntranceFile$2(r113));
    L6:
        return r101;
    L5:
        r103.invoke(r102);
        goto L6
    }
}
