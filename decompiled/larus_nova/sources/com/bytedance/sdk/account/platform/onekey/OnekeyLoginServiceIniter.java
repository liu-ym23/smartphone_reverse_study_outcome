package com.bytedance.sdk.account.platform.onekey;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;

/* JADX INFO: loaded from: classes3.dex */
public class OnekeyLoginServiceIniter implements AuthorizeIniter<IOnekeyLoginService> {
    private final OnekeyLoginConfig mConfig;

    public OnekeyLoginServiceIniter(OnekeyLoginConfig r100) {
        this.mConfig = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context r100) {
        AuthorizeFramework.registerService(IOnekeyLoginService.class, new OnekeyLoginServiceImpl(r100, this.mConfig));
    }
}
