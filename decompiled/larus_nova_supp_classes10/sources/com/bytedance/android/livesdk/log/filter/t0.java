package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t0 {
    public static final boolean a(s0 r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$isAnchor");
        if (r2.a(r2) == false) goto L16;
        IHostService r3 = TTLiveSDK.hostService();
        if (r3 == null) goto L12;
        IHostUser r4 = r3.user();
        if (r4 == null) goto L12;
        IUser r5 = r4.getCurUser();
        if (r5 == null) goto L12;
        String r6 = r5.getUserId();
        if (r6 == null) goto L12;
    L14:
        if (Intrinsics.areEqual(r2, r6) == false) goto L16;
        return true;
    L12:
        r6 = "";
    L16:
        return false;
    }
}
