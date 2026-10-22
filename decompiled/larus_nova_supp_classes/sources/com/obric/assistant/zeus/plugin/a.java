package com.obric.assistant.zeus.plugin;

import com.larus.applog.api.IApplog;
import com.larus.platform.service.g;
import com.volcengine.zeus.apm.AbsApm;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a extends AbsApm {
    @Override // com.volcengine.zeus.apm.AbsApm
    public final void init() {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final String getDid() {
        return IApplog.a.getDeviceId();
    }

    public a() {
    }

    @Override // com.volcengine.zeus.apm.AbsApm
    public final void reportError(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "throwable");
        g r0 = g.a;
        if (r2 != null) goto L5;
        r2 = XmlPullParser.NO_NAMESPACE;
    L5:
        r0.ensureNotReachHere(r3, r2);
    }
}
