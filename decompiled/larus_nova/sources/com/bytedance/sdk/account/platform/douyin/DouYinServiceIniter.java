package com.bytedance.sdk.account.platform.douyin;

import android.content.Context;
import com.bytedance.sdk.account.platform.api.IAuthorizeService;
import com.bytedance.sdk.account.platform.api.IDouYin2Service;
import com.bytedance.sdk.account.platform.base.AuthorizeCreator;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.bytedance.sdk.account.platform.base.AuthorizeIniter;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DouYinServiceIniter implements AuthorizeIniter<IDouYin2Service>, AuthorizeCreator<IDouYin2Service> {
    private String clientKey;

    public DouYinServiceIniter(String r100) {
        this.clientKey = r100;
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public IDouYin2Service createService(Context r100) {
        return new DouYin2ServiceImpl(this.clientKey);
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeIniter
    public void init(Context r100) {
        AuthorizeMonitorUtil.checkMonitorService();
        AuthorizeFramework.registerService(IDouYin2Service.class, new DouYin2ServiceImpl(this.clientKey));
    }

    @Override // com.bytedance.sdk.account.platform.base.AuthorizeCreator
    public /* bridge */ /* synthetic */ IAuthorizeService createService(Context r100) {
        return createService(r100);
    }
}
