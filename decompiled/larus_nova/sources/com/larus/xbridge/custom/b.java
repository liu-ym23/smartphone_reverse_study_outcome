package com.larus.xbridge.custom;

import android.os.Bundle;
import com.bytedance.sdk.account.platform.AuthorizeAdapter;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends AuthorizeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IvyBridgeMethod.a f379697a;

    public b(ux7.d.C7943d r100) {
        this.f379697a = r100;
        super("aweme_v2");
    }

    @Override // com.bytedance.sdk.account.platform.AuthorizeAdapter
    public final void onAuthError(AuthorizeErrorResponse r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("updateToken onAuthError, errorCode:");
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.platformErrorCode;
    L6:
        r102.append(r104);
        r102.append(", errorMsg: ");
        if (r100 == null) goto L9;
        r103 = r100.platformErrorMsg;
    L9:
        r102.append(r103);
        r101.i("AccountThirdPartyAuthMethod", r102.toString());
        IvyBridgeMethod.a r105 = this.f379697a;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("code", 0);
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("code", "");
        r107.put("platform", "douyin");
        int r108 = a.f379685c;
        r107.put("platformAppId", "8943");
        if (r100 == null) goto L13;
        Comparable r109 = r100.platformErrorCode;
        if (r109 == null) goto L13;
    L14:
        r107.put("errorCode", r109);
        Unit r110 = Unit.INSTANCE;
        r106.put("data", r107);
        r105.invoke(r106);
        return;
    L13:
        r109 = -1;
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.platform.AuthorizeAdapter
    public final void onAuthSuccess(Bundle r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getString("auth_code");
        if (r101 == null) goto L5;
    L6:
        IvyBridgeMethod.a r102 = this.f379697a;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("code", 1);
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", r101);
        r104.put("platform", "douyin");
        int r105 = a.f379685c;
        r104.put("platformAppId", "8943");
        Unit r106 = Unit.INSTANCE;
        r103.put("data", r104);
        r102.invoke(r103);
        return;
    L5:
        r101 = "";
        goto L6
    }
}
