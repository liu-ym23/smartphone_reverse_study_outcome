package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallGetBCMFullChainJSB extends qf3.e {
    public final String getName() {
        return "ec.getBCMFullChain";
    }

    public ECMallGetBCMFullChainJSB(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r3, IBDXBridgeContext r4, final Map<String, ? extends Object> r5, Map<String, Object> r6) {
        Intrinsics.checkNotNullParameter(r3, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r4, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "result");
        ALogger.c(ALogger.d, "ec.getBCMFullChain", new ECMallGetBCMFullChainJSB$handleCall$1(r5));
        Object r7 = r5.get("chainLength");
        JSONObject r0 = null;
        if ((r7 instanceof Integer) == true) goto L5;
        r7 = null;
    L5:
        Integer r8 = (Integer) r7;
        if (r8 == null) goto L8;
        int r9 = r8.intValue();
    L9:
        Object r10 = r5.get("isDomainStandard");
        if ((r10 instanceof Boolean) == true) goto L12;
        r10 = null;
    L12:
        kc.a r11 = com.bytedance.android.bcm.api.b.a.getBcmChainByFinder(null, CollectionsKt.listOf("ecom_entrance"), r9, Intrinsics.areEqual((Boolean) r10, Boolean.TRUE));
        if (r11 == null) goto L15;
        r0 = r11.a();
    L15:
        if (r0 != null) goto L17;
        r6.put("err_message", "params is empty");
    L19:
        return qf3.e.f(this);
    L17:
        r6.put("content", r0);
        goto L19
    L8:
        r9 = 20;
        goto L9
    }
}
