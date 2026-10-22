package com.larus.api.bussiness;

import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.u;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;

/* JADX INFO: loaded from: classes24.dex */
public final class i implements u {
    public i() {
    }

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        qr9.b r100 = VideoFeedProviderDelegate.f365695b.getTopPlayerController();
        if (r100 == null) goto L5;
        r100.playPlayer();
    L5:
        Keva r101 = a.f286896a;
        a.a(AppHost.f326268a.getAppClock().currentTimeMillis());
    }
}
