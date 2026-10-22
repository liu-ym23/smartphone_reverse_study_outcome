package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECOpenRecommendMall;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOpenRecommendMall extends ECBaseBridgeMethod {
    public final String e;

    public ECOpenRecommendMall() {
        this.e = "ecOpenRecommendMall";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(final JSONObject r8, final ECBaseBridgeMethod.a r9) {
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r9, "iReturn");
        String r0 = r8.optString("btm");
        String r1 = r8.optString("bcm");
        Context r2 = getContext();
        String r3 = r8.optString("mallScheme");
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L10;
        r3 = null;
    L10:
        BcmParams.Companion.getClass();
        d r5 = BtmUtilsKt.d(r0, BcmParams.a.a(r1), PageFinder.via(b().a));
        if (r3 == null) goto L13;
        String r6 = BtmUtilsKt.b(r3, r5);
    L15:
        if (((Unit) UtilityKotlinExtentionsKt.f(r2, r6, new ECOpenRecommendMall$handle$3(r8, r9))) != null) goto L18;
        r9.onFailed(0, null);
        Unit r10 = Unit.INSTANCE;
        return;
    L18:
        return;
    L13:
        r6 = null;
        goto L15
    L5:
        r4 = false;
        goto L7
    }
}
