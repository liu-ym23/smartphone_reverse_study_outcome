package com.larus.office.minutes.impl;

import com.larus.applog.api.IApplog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes29.dex */
public final class c implements kub.d {
    public c() {
    }

    @Override // kub.d
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        IApplog.f287053a.reportEvent(r100, r101);
    }
}
