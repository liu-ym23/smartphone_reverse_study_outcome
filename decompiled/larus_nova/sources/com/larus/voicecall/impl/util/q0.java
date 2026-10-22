package com.larus.voicecall.impl.util;

import com.larus.common.apphost.AppHost;
import com.larus.platform.api.IAudioAutoTestPlatform;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class q0 {
    public static final void a() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isTestChannel() == false) goto L5;
    L8:
        String r101 = new SimpleDateFormat("yyyy_MMdd_HH_mm_ss").format(new Date());
        IAudioAutoTestPlatform r102 = (IAudioAutoTestPlatform) ServiceManager.get().getService(IAudioAutoTestPlatform.class);
        if (r102 == null) goto L11;
        Intrinsics.checkNotNull(r101);
        r102.a();
    L11:
        int r103 = com.larus.im.a.f346406a;
        gd9.o r104 = com.larus.im.internal.d.f347913a;
        com.larus.im.internal.audio.u.f347501c.getClass();
        com.larus.im.internal.utils.x r105 = com.larus.im.internal.utils.x.f350563a;
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "timestamp");
        com.larus.im.internal.utils.x.f350564b = r101;
        FLogger.f375446a.d("RealtimeCall", "setCurrentEnterRoomTimestamp: " + r101);
        return;
    L5:
        if (Intrinsics.areEqual(r100.getBuildChannel(), "auto_test") == true) goto L8;
        if (c78.a.f22657a == true) goto L8;
    }
}
