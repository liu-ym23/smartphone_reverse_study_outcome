package com.obric.assistant.ipc;

import com.bytedance.common.wschannel.WsConstants;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements com.larus.platform.api.y {
    public d() {
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
        boolean r103 = rna.b.a(r100);
        FLogger.f375446a.i("HostStateSyncManager", "appLogIdCallback save doubaoDid saved=" + r103 + " didLength=" + r100.length());
    }
}
