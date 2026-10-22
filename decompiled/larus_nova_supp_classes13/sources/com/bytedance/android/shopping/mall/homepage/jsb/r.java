package com.bytedance.android.shopping.mall.homepage.jsb;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.deepfeed.data.DeepFeedCouponResult;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends qf3.e {
    public final String d;

    public static final class a {
    }

    public static final class b extends com.bytedance.android.shopping.api.mall.common.tools.o {
        public final /* synthetic */ Ref.BooleanRef c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void a() {
            this.c.element = false;
            Lazy r0 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update failed, channel:" + this.d + ",ak:" + this.e);
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            JSONObject r2 = new JSONObject();     // Catch: Throwable -> L5
            r2.put("channel_name", this.d);     // Catch: Throwable -> L5
            r2.put("access_key", this.e);     // Catch: Throwable -> L5
            r2.put("preload_status", DeepFeedCouponResult.FAIL);     // Catch: Throwable -> L5
            r2.put("preload_type", "2");     // Catch: Throwable -> L5
            com.bytedance.android.shopping.api.mall.common.tools.l.a.getClass();     // Catch: Throwable -> L5
            com.bytedance.android.shopping.api.mall.common.tools.l.a(r2);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void b() {
            this.c.element = true;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L5
            r1.put("channel_name", this.d);     // Catch: Throwable -> L5
            r1.put("access_key", this.e);     // Catch: Throwable -> L5
            r1.put("preload_status", "success");     // Catch: Throwable -> L5
            r1.put("preload_type", "2");     // Catch: Throwable -> L5
            com.bytedance.android.shopping.api.mall.common.tools.l.a.getClass();     // Catch: Throwable -> L5
            com.bytedance.android.shopping.api.mall.common.tools.l.a(r1);     // Catch: Throwable -> L5
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Lazy r2 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.b, "gecko update success, channel:" + this.d + ",ak:" + this.e);
            return;
        L5:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }

        public b(Ref.BooleanRef r1, String r2, String r3, String r4, String r5) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            super(r4, r5);
        }
    }

    static {
    }

    public final String getName() {
        return this.d;
    }

    public r(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
        this.d = "ec.mall.updateGecko";
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r9, IBDXBridgeContext r10, Map<String, ? extends Object> r11, Map<String, Object> r12) {
        Intrinsics.checkNotNullParameter(r9, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "result");
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        r13.element = false;
        Object r14 = r11.get("channel");
        if ((r14 instanceof String) == true) goto L5;
        r14 = null;
    L5:
        String r2 = (String) r14;
        Object r15 = r11.get("access_key");
        if ((r15 instanceof String) == true) goto L8;
        r15 = null;
    L8:
        String r3 = (String) r15;
        GeckoClient r16 = com.bytedance.geckox.a.a(r3);
        Map r17 = MapsKt.mapOf(TuplesKt.to(r3, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r2))));
        OptionCheckUpdateParams r18 = new OptionCheckUpdateParams().setLazyUpdate(false).setChannelUpdatePriority(3);
        if (r3 != null) goto L11;
        String r4 = "";
    L12:
        if (r2 != null) goto L14;
        String r5 = "";
    L15:
        OptionCheckUpdateParams r19 = r18.setListener(new b(r13, r2, r3, r4, r5));
        if (r16 == null) goto L19;
        r16.checkUpdateMulti(null, r17, r19);
    L19:
        if (r13.element == false) goto L22;
        return qf3.e.f(this);
    L22:
        return qf3.e.c("gecko update failed");
    L14:
        r5 = r2;
        goto L15
    L11:
        r4 = r3;
        goto L12
    }
}
