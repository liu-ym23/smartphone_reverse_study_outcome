package com.bytedance.android.shopping.mall.homepage;

import com.bytedance.android.shopping.api.mall.homepage.ECMallDeliveryReduceConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class ECMallFragment$handleCacheData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $reduceRenderStart;
    final /* synthetic */ ECMallFragment this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallFragment$handleCacheData$1 a;

        public a(ECMallFragment$handleCacheData$1 r1) {
            this.a = r1;
        }

        public final void a() {
            long r0 = System.currentTimeMillis();
            ECMallDeliveryReduceConfig r2 = com.bytedance.android.shopping.mall.homepage.tools.g.a;
            ECMallFragment r3 = this.a.this$0;
            int r4 = ECMallFragment.h4;
            r3.getClass();
            LinkedHashMap r5 = new LinkedHashMap();
            Map r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("delivery_reduce_render_start", Long.valueOf(this.a.$reduceRenderStart)), TuplesKt.to("delivery_reduce_render_end", Long.valueOf(r0))});
            Intrinsics.checkNotNullParameter(r5, "deliveryParams");
            Intrinsics.checkNotNullParameter(r1, "reportParams");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallFragment$handleCacheData$1(ECMallFragment r1, long r2) {
        this.this$0 = r1;
        this.$reduceRenderStart = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1158invoke() {
        t93.a.b().postAtFrontOfQueue(new a(this));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1158invoke();
        return Unit.INSTANCE;
    }
}
