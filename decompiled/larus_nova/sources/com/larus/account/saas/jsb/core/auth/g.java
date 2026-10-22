package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import b48.i;
import com.bytedance.sdk.account.platform.api.ILineService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import y38.u;

/* JADX INFO: loaded from: classes24.dex */
public final class g {
    static {
    }

    public static void a(Activity r100, final i.b r101, final u r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        final ILineService r103 = (ILineService) AuthorizeFramework.getService(ILineService.class);
        if (r103 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountThirdPartyAuthCore", "line authorize service is not initialized.");
        FlowAccountThirdPartyAuthCore.Error r104 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r102.a(new x38.a(r104.getCode(), r104.getMessage(), null));
        return;
    L6:
        ConcurrentHashMap<String, a.C3942a> r105 = a.f286380a;
        a.a(r100, new LineAuthorizer$authorize$1(r103, r102, r101), new LineAuthorizer$authorize$2(r102));
    }
}
