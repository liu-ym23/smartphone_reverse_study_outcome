package com.larus.init.task.firstframe;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.video.api.VideoEngineInitServiceDelegate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a0 implements com.larus.platform.api.y {
    public a0() {
    }

    @Override // com.larus.platform.api.y
    public final boolean a() {
        return true;
    }

    @Override // com.larus.platform.api.y
    public final void onGetId(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_INSTALL_ID);
        Intrinsics.checkNotNullParameter(r102, "ssid");
        VideoEngineInitServiceDelegate.f375655a.a();
    }
}
