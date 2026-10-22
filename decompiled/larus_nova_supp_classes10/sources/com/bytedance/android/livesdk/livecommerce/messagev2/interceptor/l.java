package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.PromotionListController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l extends a {
    public l() {
        super(false);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final void e(String r1, boolean r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.messagev2.interceptor.a
    public final boolean c(sg2.a r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        if ((r3 instanceof si2.z) == true) goto L6;
        return false;
    L6:
        if (((si2.z) r3).taskInfo == null) goto L9;
        PromotionListController.T.getClass();
        PromotionListController.a.a().getClass();
        return true;
    L9:
        return false;
    }
}
