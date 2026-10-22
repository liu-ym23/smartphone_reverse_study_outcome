package com.larus.push.impl;

import com.bytedance.push.PushBody;
import com.larus.account.saas.security.api.IAccountSecurityService;
import com.larus.common.apphost.AppHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p implements v67.l {
    public p() {
    }

    @Override // v67.l
    public final void a() {
    }

    @Override // v67.l
    public final boolean b(PushBody r100) {
        if (AppHost.f326268a.a().isAppBackground() == false) goto L6;
        return false;
    L6:
        IAccountSecurityService.Companion r101 = IAccountSecurityService.f286489a;
        JSONObject r102 = null;
        if (r100 == null) goto L9;
        String r103 = r100.f266727p;
    L10:
        if (r100 == null) goto L12;
        r102 = r100.f266722k;
    L12:
        r101.g(r101.f(r103, r102));
        return true;
    L9:
        r103 = null;
        goto L10
    }
}
