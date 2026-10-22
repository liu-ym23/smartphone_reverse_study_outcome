package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.preload.net.MobileViewCacheParser;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetResourceLoader f214539a;

    public g(NetResourceLoader r100) {
        this.f214539a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Result r101 = (Result) r100;
        if (r101.code != 0) goto L8;
        this.f214539a.m(NetResourceLoader.ResourceType.ClientVars, ((MobileViewCacheParser.MobileViewResult) r101.data).getClientVarsData(), null);
        if (((MobileViewCacheParser.MobileViewResult) r101.data).getMobileViewCode() != 0) goto L7;
        this.f214539a.m(NetResourceLoader.ResourceType.MainPage, ((MobileViewCacheParser.MobileViewResult) r101.data).getMobileViewData(), null);
        return;
    L7:
        this.f214539a.m(NetResourceLoader.ResourceType.MainPage, ((MobileViewCacheParser.MobileViewResult) r101.data).getMobileViewData(), new Exception(((MobileViewCacheParser.MobileViewResult) r101.data).getMobileViewMessage()));
        return;
    L8:
        Exception r102 = new Exception(r101.code + ',' + r101.msg);
        this.f214539a.m(NetResourceLoader.ResourceType.ClientVars, new BitableResourceData(), r102);
        this.f214539a.m(NetResourceLoader.ResourceType.MainPage, new BitableResourceData(), r102);
    }
}
