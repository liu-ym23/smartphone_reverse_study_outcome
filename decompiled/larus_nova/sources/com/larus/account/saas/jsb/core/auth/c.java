package com.larus.account.saas.jsb.core.auth;

import android.app.Activity;
import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.Request;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import y38.u;

/* JADX INFO: loaded from: classes24.dex */
public final class c {
    static {
    }

    public static void a(Activity r100, i.a r101, u r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "callback");
        IDouYin2Service r103 = (IDouYin2Service) AuthorizeFramework.getService(IDouYin2Service.class);
        if (r103 != null) goto L6;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("FlowAccountThirdPartyAuthCore", "douyin authorize service is not initialized.");
        FlowAccountThirdPartyAuthCore.Error r104 = FlowAccountThirdPartyAuthCore.Error.SERVICE_UNAVAILABLE;
        r102.a(new x38.a(r104.getCode(), r104.getMessage(), null));
        return;
    L6:
        Request.Builder r105 = new Request.Builder().setScopes(SetsKt.mutableSetOf(new String[]{"user_info"})).setState("dy_authorize").setCallerLocalEntry("com.larus.nova.douyinapi.DouYinEntryActivity");
        Bundle r106 = new Bundle();
        r106.putString("comment_id", r101.f17631b);
        if (r103.authorize(r100, r105.setExtra(r106).setAuthType(0).build(), new b(r102, r101)) == true) goto L10;
        FlowAccountThirdPartyAuthCore.Error r107 = FlowAccountThirdPartyAuthCore.Error.REQUEST_REJECTED;
        r102.a(new x38.a(r107.getCode(), r107.getMessage(), null));
        return;
    }
}
