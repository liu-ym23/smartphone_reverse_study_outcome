package com.bytedance.applet.aibridge.auth;

import com.larus.platform.api.c5;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e implements c5 {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ h<AbsStartDouyinOpenAuthMethodIDL.b> b;

    public e(JSONObject r1, h<AbsStartDouyinOpenAuthMethodIDL.b> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(boolean r15, Integer r16, String r17, String r18) {
        FLogger.a.i("StartDouyinOpenAuthMethod", "onResult, isAuthorized:" + r15 + ", errorCode:" + r16 + ", errorMsg: " + r17 + '.');
        w0.d(null, null, null, r15 ? 1 : 0, r18, null, null, null, null, null, this.a, 3047);
        h<AbsStartDouyinOpenAuthMethodIDL.b> r1 = this.b;
        Intrinsics.checkNotNullParameter(AbsStartDouyinOpenAuthMethodIDL.b.class, "<this>");
        AbsStartDouyinOpenAuthMethodIDL.b r2 = k3.c.a(AbsStartDouyinOpenAuthMethodIDL.b.class);
        r2.setAuthorized(r15);
        h.a.b(r1, r2);
    }
}
