package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static gl.a a(EnumEntranceInfoScene r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        int r0 = ECSdk.a;
        IEntranceInfoService r1 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.initEntranceInfo(new EntranceInfoScene("ecomLive", r3.getValue()), r4);
    }
}
