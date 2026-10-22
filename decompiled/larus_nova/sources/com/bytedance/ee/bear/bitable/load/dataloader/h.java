package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetResourceLoader f214540a;

    public h(NetResourceLoader r100) {
        this.f214540a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f214540a.m(NetResourceLoader.ResourceType.ClientVars, new BitableResourceData(), r101);
        this.f214540a.m(NetResourceLoader.ResourceType.MainPage, new BitableResourceData(), r101);
    }
}
