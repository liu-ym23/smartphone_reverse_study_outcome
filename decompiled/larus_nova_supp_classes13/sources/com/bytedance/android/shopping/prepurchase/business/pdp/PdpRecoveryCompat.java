package com.bytedance.android.shopping.prepurchase.business.pdp;

import android.os.Bundle;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.SchemaPackRequest;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.k;
import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpRecoveryCompat {
    public final AnchorV4Param a;

    public static final class a {
    }

    static {
    }

    public PdpRecoveryCompat(AnchorV4Param r2) {
        Intrinsics.checkNotNullParameter(r2, "inputParams");
        this.a = r2;
    }

    public final boolean a(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "bundle");
        Pair r3 = r7.getSerializable("key_request_param");     // Catch: Exception -> L14
        if (r3 == null) goto L13;
        Pair r4 = r3;     // Catch: Exception -> L14
        int r5 = ((Number) r4.getFirst()).intValue();     // Catch: Exception -> L14
        if (r5 != 1) goto L8;
        int r6 = t0.a;     // Catch: Exception -> L14
        PdpPackRequestParam r8 = (PdpPackRequestParam) t0.a.a.fromJson((String) r4.getSecond(), AnchorV3PromotionRequestParam.class);     // Catch: Exception -> L14
    L17:
        if (r8 != null) goto L20;
        dm.a.a("PageRecoveryCompat").b("restore error. finish page", null);
        ECExceptionMonitor.c("param is null. " + r7.getSerializable("key_request_param"));
        return false;
    L20:
        k r9 = AnchorV4DataManager.a;
        String r10 = this.a.getSessionId();
        if (r10 == null) goto L24;
        AnchorV4DataManager.c.put(r10, r8);
    L24:
        AnchorV4DataManager.h(this.a.getSessionId(), PdpRecoveryCompat$restoreState$1.INSTANCE, null, true, 4);
        return true;
    L8:
        if (r5 != 2) goto L16;
        int r11 = t0.a;     // Catch: Exception -> L14
        r8 = (PdpPackRequestParam) t0.a.a.fromJson((String) r4.getSecond(), SchemaPackRequest.class);     // Catch: Exception -> L14
    L16:
        r8 = null;
        goto L17
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Pair<kotlin.Int, kotlin.String>");     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L16
    }

    public final void b(Bundle r7) {
        Intrinsics.checkNotNullParameter(r7, "bundle");
        k r1 = AnchorV4DataManager.a;
        PdpPackRequestParam r2 = AnchorV4DataManager.k(this.a.getSessionId());
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L4:
        if ((r2 instanceof AnchorV3PromotionRequestParam) == false) goto L7;
        Integer r3 = 1;     // Catch: Exception -> L16
    L10:
        dm.a.a("PageRecoveryCompat").b("saveSate: type = " + r3 + ", " + r2, null);     // Catch: Exception -> L16
        if (r3 != null) goto L14;
        ECExceptionMonitor.c("saveSate error, type is null");     // Catch: Exception -> L16
        return;
    L14:
        int r4 = t0.a;     // Catch: Exception -> L16
        r7.putSerializable("key_request_param", new Pair(r3, t0.a.a.toJson(r2)));     // Catch: Exception -> L16
        return;
    L7:
        if ((r2 instanceof SchemaPackRequest) == false) goto L9;
        r3 = 2;     // Catch: Exception -> L16
        goto L10
    L9:
        r3 = null;
        goto L10
    }
}
