package com.bytedance.sdk.account.platform.weixin;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.platform.base.AuthorizeCreator;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import dc7.a;

/* JADX INFO: loaded from: classes3.dex */
public class WeixinServiceIniter implements AuthorizeIniter<IWeixinService>, AuthorizeCreator<IWeixinService> {
    private String appId;

    public WeixinServiceIniter(String r100) {
        this.appId = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public IWeixinService createService(Context r100) {
        return new a(r100, this.appId);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context r100) {
        AuthorizeMonitorUtil.checkMonitorService();
        AuthorizeFramework.registerService(IWeixinService.class, new a(r100, this.appId));
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public /* bridge */ /* synthetic */ IAuthorizeService createService(Context r100) {
        return createService(r100);
    }
}
