package com.bytedance.android.shopping.mall.feed.ability;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.entity.ECHybridNetworkVO;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.list.ability.i0;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.i;
import com.bytedance.android.shopping.api.mall.common.tools.p;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements i0 {
    public final ECHybridDataEngine a;

    public static final class a implements ECHybridNetworkTask.a {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ Map c;

        public a(Function1 r1, Map r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void c(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.c(r1, r2, r3);
        }

        public final void d(String r5, String r6, ECHybridNetworkVO r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r5, "apiKey");
            Intrinsics.checkNotNullParameter(r6, "result");
            Intrinsics.checkNotNullParameter(r7, "requestVO");
            Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L5
            Object r10 = Result.constructor-impl((Map) p.b().fromJson(r6, Map.class));     // Catch: Throwable -> L5
        L8:
            if (Result.isFailure-impl(r10) == false) goto L10;
            r10 = null;
        L10:
            Map r11 = (Map) r10;
            Function1 r12 = this.a;
            Pair[] r0 = new Pair[4];
            r0[0] = TuplesKt.to("code", 1);
            r0[1] = TuplesKt.to("httpCode", 200);
            r0[2] = TuplesKt.to("header", "");
            Object r13 = r6;
            if (r11 == null) goto L14;
            r13 = r11;
        L14:
            r0[3] = TuplesKt.to("response", r13);
            r12.invoke(MapsKt.mutableMapOf(r0));
            Lazy r14 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.b, "dynamic request success apikey : " + r5);
            return;
        L5:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L8
        }

        public final void e(String r4, Throwable r5, ECHybridNetworkVO r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "apiKey");
            Intrinsics.checkNotNullParameter(r5, "t");
            this.a.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1), TuplesKt.to("httpCode", -1)}));
            Lazy r8 = ECMallLogUtil.a;
            Map r9 = this.b;
            Map r10 = this.c;
            Intrinsics.checkNotNullParameter(r4, "apiKey");
            Intrinsics.checkNotNullParameter("sendDynamicRequest failed", "prefix");
            com.bytedance.android.ec.hybrid.a.i(new i(r9, r10, "sendDynamicRequest failed", r4));
        }

        public final void f(String r1, String r2, ECHybridNetworkVO r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r1, "apiKey");
            Intrinsics.checkNotNullParameter(r2, "result");
            Intrinsics.checkNotNullParameter(r3, "requestVO");
            ECHybridNetworkTask.a.a.b(r1, r2, r3);
        }
    }

    public final void release() {
    }

    public g(ECHybridDataEngine r1) {
        this.a = r1;
    }

    public final void bq(String r3, Map<String, ? extends Object> r4, Map<String, String> r5, Function1<? super Map<String, ? extends Object>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "apiKey");
        Intrinsics.checkNotNullParameter(r6, "callback");
        ECHybridDataEngine r0 = this.a;
        if (r0 == null) goto L6;
        r0.i(r3, r4, r5, new a(r6, r4, r5));
        return;
    }
}
