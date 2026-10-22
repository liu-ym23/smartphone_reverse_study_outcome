package com.huawei.hms.hihealthlite;

import android.content.Intent;
import com.huawei.hms.healthlite.aabd;

/* JADX INFO: loaded from: classes23.dex */
public class LoginFreeAuthController {

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private aabd f277491aab;

    public LoginFreeAuthController() {
        this.f277491aab = null;
        this.f277491aab = aabd.aab();
    }

    public Intent requestLoginFreeAuthorizationIntent(String[] r100, String r101, String r102, String r110, String r111) {
        return this.f277491aab.aab(r100, r101, r102, r110, r111);
    }
}
