package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.livesdk.livecommerce.room.coupon.EnterRequestHandler;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECInsertCartIconAnimationMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECInsertCartIconAnimationMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECInsertCartIconAnimationMethod() {
        this.e = "ecInsertCartIconAnimation";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r2, ECBaseBridgeMethod.a r3) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "iReturn");
        String r4 = a2.d(r2.optString("icon"));
        if (r4 == null) goto L5;
        Lazy r0 = EnterRequestHandler.a;
        int r1 = w0.a;
        EnterRequestHandler.d = (IconItem) w0.b(r4, IconItem.class);
    L5:
        r3.onSuccess(null);
    }
}
