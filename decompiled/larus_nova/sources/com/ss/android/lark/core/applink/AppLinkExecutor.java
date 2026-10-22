package com.ss.android.lark.core.applink;

import android.content.Context;
import com.ss.android.lark.alchemy.applink.IAppLinkApi;
import ova.f;

/* JADX INFO: loaded from: classes35.dex */
public class AppLinkExecutor implements IAppLinkApi {
    public AppLinkExecutor() {
    }

    @Override // com.ss.android.lark.alchemy.applink.IAppLinkApi
    public boolean openAppLink(Context r100, String r101) {
        return f.m().C(r100, r101, 13, null, null);
    }
}
