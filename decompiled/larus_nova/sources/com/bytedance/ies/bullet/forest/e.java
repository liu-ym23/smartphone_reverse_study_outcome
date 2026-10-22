package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.GeckoConfig;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {
    public static final GeckoConfig a(com.bytedance.ies.bullet.service.base.resourceloader.config.GeckoConfig r110, String r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "appId");
        Intrinsics.checkNotNullParameter(r112, "appVersion");
        Intrinsics.checkNotNullParameter(r113, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r114, EffectConfiguration.KEY_REGION);
        String r100 = r110.getAccessKey();
        String r101 = r110.getOfflineDir();
        boolean r102 = r110.isRelativePath();
        Long r115 = StringsKt.toLongOrNull(r111);
        if (r115 == null) goto L5;
        long r116 = r115.longValue();
    L7:
        return new GeckoConfig(r100, r101, r116, r112, r113, r114, r102);
    L5:
        r116 = 0;
        goto L7
    }
}
