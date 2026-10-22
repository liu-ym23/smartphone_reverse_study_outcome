package com.bytedance.android.livesdk.livecommerce.iron.navigate;

import com.bytedance.android.ec.model.g;
import com.bytedance.android.ec.sdk.helper.l;
import com.bytedance.android.livesdk.livecommerce.utils.ECEnterRoomJumpLogUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements yk.a {
    public final /* synthetic */ String a;

    public c(String r1) {
        this.a = r1;
    }

    public final <T extends g> void a(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "path");
        IronNavigator.a.getClass();
        l.a(new IronNavigator$logOnNetworkRequestSuccess$1(r2, r3));
        ECEnterRoomJumpLogUtils.b(r2, true, null);
    }

    public final void onFailure(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "path");
        IronNavigator.a(IronNavigator.a, this.a, r4, "ec_live_buy", r5);
    }
}
