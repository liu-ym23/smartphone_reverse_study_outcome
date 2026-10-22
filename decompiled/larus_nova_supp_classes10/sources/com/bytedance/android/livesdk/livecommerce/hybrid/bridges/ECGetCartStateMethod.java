package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECGetCartStateMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetCartStateMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECGetCartStateMethod() {
        this.e = "ecGetCartState";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r3, ECBaseBridgeMethod.a r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "iReturn");
        JSONObject r5 = new JSONObject();
        int r0 = RoomContextController.h;
        ECContext r1 = RoomContextController.a.a().r();
        if (r1 == null) goto L9;
        m<Boolean> r2 = r1.isCartShow();
        if (r2 == null) goto L9;
        Boolean r6 = (Boolean) r2.getValue();
        if (r6 == null) goto L9;
        boolean r7 = r6.booleanValue();
    L10:
        r5.put("is_show", r7);
        Unit r8 = Unit.INSTANCE;
        r4.onSuccess(r5);
        return;
    L9:
        r7 = false;
        goto L10
    }
}
