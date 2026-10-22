package com.larus.common.location.impl;

import com.bytedance.bdlocation.event.IEventManager;
import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class q implements IEventManager {
    public q() {
    }

    @Override // com.bytedance.bdlocation.event.IEventManager
    public final void onEventV3(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
