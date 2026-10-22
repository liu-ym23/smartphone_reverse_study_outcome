package com.larus.account.saas.jsb.core.auth;

import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.api.IAppAuthService;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements AuthorizeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityResultAuthProxyActivity f286385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x38.g<FlowAccountThirdPartyAuthCore.a> f286386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i.b f286387c;

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onError(AuthorizeErrorResponse r110) {
        this.f286385a.b();
        com.larus.account.saas.runtime.internal.delegate.a r100 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r101 = new StringBuilder("google auth error, errorCode=");
        String r102 = null;
        if (r110 == null) goto L5;
        String r103 = r110.platformErrorCode;
    L6:
        r101.append(r103);
        r101.append(", errorMsg=");
        if (r110 == null) goto L9;
        r102 = r110.platformErrorMsg;
    L9:
        r101.append(r102);
        r100.d("FlowAccountThirdPartyAuthCore", r101.toString());
        x38.g<FlowAccountThirdPartyAuthCore.a> r104 = this.f286386b;
        String r105 = this.f286387c.f17632a;
        if (r110 == null) goto L16;
        String r111 = r110.platformErrorCode;
        if (r111 == null) goto L16;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L16;
        int r113 = r112.intValue();
    L17:
        r104.onSuccess(new FlowAccountThirdPartyAuthCore.a("google", r105, null, null, null, "", null, Integer.valueOf(r113), 348));
        return;
    L16:
        r113 = -1;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCallback
    public final void onSuccess(Bundle r110) {
        this.f286385a.b();
        String r100 = null;
        if (r110 == null) goto L5;
        String r101 = r110.getString("idToken");
    L6:
        String r102 = "";
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        boolean r103 = false;
        if (r101.length() != 0) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L21;
        if (r110 == null) goto L16;
        String r105 = r110.getString("id_token");
    L17:
        if (r105 == null) goto L20;
        r102 = r105;
    L20:
        String r111 = r102;
    L23:
        if (r110 != null) goto L25;
    L27:
        boolean r106 = false;
    L28:
        if (r106 == false) goto L32;
        r100 = String.valueOf(r110.getLong("expire_in"));
    L38:
        this.f286386b.onSuccess(new FlowAccountThirdPartyAuthCore.a("google", this.f286387c.f17632a, null, null, null, r111, r100, null, 412));
        return;
    L32:
        if (r110 != null) goto L34;
    L36:
        if (r103 == false) goto L38;
        r100 = String.valueOf(r110.getLong(IAppAuthService.ResponseKey.ACCESS_TOKEN_EXPIRATION_TIME));
        goto L38
    L34:
        if (r110.containsKey(IAppAuthService.ResponseKey.ACCESS_TOKEN_EXPIRATION_TIME) != true) goto L36;
        r103 = true;
        goto L36
    L25:
        if (r110.containsKey("expire_in") != true) goto L27;
        r106 = true;
        goto L28
    L16:
        r105 = null;
        goto L17
    L21:
        r111 = r101;
        goto L23
    L12:
        r104 = false;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public e(ActivityResultAuthProxyActivity r100, x38.g<FlowAccountThirdPartyAuthCore.a> r101, i.b r102) {
        this.f286385a = r100;
        this.f286386b = r101;
        this.f286387c = r102;
    }
}
