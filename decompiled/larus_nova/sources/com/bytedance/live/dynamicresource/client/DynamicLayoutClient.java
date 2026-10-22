package com.bytedance.live.dynamicresource.client;

import com.bytedance.live.dynamicresource.producer.GeckoResProducer;
import com.bytedance.live.dynamicresource.producer.a;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o51.f;

/* JADX INFO: loaded from: classes19.dex */
public final class DynamicLayoutClient<EntranceModel, LayoutConfig, RouterKey> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> f255108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<RouterKey, Integer> f255109b;

    public DynamicLayoutClient(ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f255108a = r100;
        this.f255109b = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<LayoutConfig, Disposable> b(RouterKey r100, Function1<? super LayoutConfig, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, "onGeckoUpdate");
        Iterator r102 = ((ArrayList) this.f255108a.f255118i).iterator();
        Object r103 = null;
        Disposable r104 = null;
    L4:
        if (r102.hasNext() == false) goto L22;
        a r105 = (a) r102.next();
        Object r106 = r105.c(r100, this.f255108a);
        if (r106 != null) goto L7;
        if ((r105 instanceof GeckoResProducer) == false) goto L4;
        LinkedHashMap r107 = (LinkedHashMap) this.f255109b;
        Object r108 = r107.get(r100);
        if (r108 != null) goto L17;
        r108 = 0;
        r107.put(r100, r108);
    L17:
        int r109 = ((Number) r108).intValue();
        if (r109 > this.f255108a.f255115f) goto L4;
        this.f255109b.put(r100, Integer.valueOf(r109 + 1));
        r104 = r105.b(r100, this.f255108a, r101, DynamicLayoutClient$produce$3.INSTANCE);
        goto L4
    L7:
        Iterator r110 = ((ArrayList) this.f255108a.f255118i).iterator();
    L9:
        if (r110.hasNext() == false) goto L11;
        ((a) r110.next()).a(r100, this.f255108a, r106);
        goto L9
    L11:
        r103 = r106;
    L22:
        return TuplesKt.to(r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Disposable c(final f.n r100, final Function1 r101, final Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "routerKey");
        Intrinsics.checkNotNullParameter(r101, "onSuccess");
        Intrinsics.checkNotNullParameter(r110, "onFail");
        int r102 = h.f267513a;
        final Disposable r103 = h.a(DynamicLayoutClient$produceAsync$disposable$1.INSTANCE);
        a(r100, 0, this.f255108a, new DynamicLayoutClient$produceAsync$1(r103, this, r101, r100), new DynamicLayoutClient$produceAsync$2(r103, r110));
        return r103;
    }

    public final void a(final RouterKey r110, final int r111, final ResourceClientContext<EntranceModel, LayoutConfig, RouterKey> r112, final Function1<? super LayoutConfig, Unit> r113, final Function1<? super Throwable, Unit> r114) {
        if (r111 >= 0) goto L4;
    L5:
        r114.invoke(new Error("index out of bound"));
    L6:
        ((a) ListProtector.get(this.f255108a.f255118i, r111)).b(r110, r112, r113, new DynamicLayoutClient$doProduceAsync$1(this, r110, r111, r112, r113, r114));
        return;
    L4:
        if (r111 < ((ArrayList) this.f255108a.f255118i).size()) goto L6;
        goto L5
    }
}
