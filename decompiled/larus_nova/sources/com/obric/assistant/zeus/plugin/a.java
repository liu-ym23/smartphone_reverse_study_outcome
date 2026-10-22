package com.obric.assistant.zeus.plugin;

import com.larus.applog.api.IApplog;
import com.lynx.tasm.LynxError;
import com.volcengine.zeus.apm.AbsApm;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class a extends AbsApm {
    @Override // com.volcengine.zeus.apm.AbsApm
    public final void init() {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final String getDid() {
        return IApplog.f287053a.getDeviceId();
    }

    public a() {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final void reportError(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        com.larus.platform.service.g r102 = com.larus.platform.service.g.f365738a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.ensureNotReachHere(r101, r100);
    }
}
