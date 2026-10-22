package com.bytedance.android.livesdk.livecommerce.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.FlashController;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/hybrid/bridges/ECAnchorFlashScreenShot;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECAnchorFlashScreenShot extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECAnchorFlashScreenShot() {
        this.e = "ec.AnchorFlashScreenShot";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r3, ECBaseBridgeMethod.a r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "iReturn");
        dm.a.a("ECAnchorFlashScreenShot").a("ECAnchorFlashScreenShot");
        r3.optInt("targetSize");
        String r0 = r3.optString("roomID");
        String r5 = r3.optString("roomUniqueKey");
        int r1 = FlashController.f;
        FlashController r6 = ControllerCenter.c(r0, r5).p;
        Objects.toString(r6);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_FLASH_SCREEN_SHOT_CONTEXT().booleanValue() == false) goto L5;
        Context r2 = getContext();
    L6:
        r6.H(r2, new ECAnchorFlashScreenShot$handle$1(this, r6, r4));
        return;
    L5:
        r2 = null;
        goto L6
    }
}
