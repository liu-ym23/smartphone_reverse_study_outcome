package com.lynx.animax.service;

import u4a.i;
import u4a.l;
import u4a.m;
import w4a.e;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXFrescoImageService implements IAnimaXImageService, IAutoRegisterAnimaXService {
    public AnimaXFrescoImageService() {
    }

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public final /* synthetic */ e getAutoRegisterServiceScope() {
        return IAutoRegisterAnimaXService.CC.$default$getAutoRegisterServiceScope(this);
    }

    @Override // com.lynx.animax.service.IAutoRegisterAnimaXService
    public Class<? extends IAnimaXService> getServiceClass() {
        return IAnimaXImageService.class;
    }

    @Override // com.lynx.animax.service.IAnimaXImageService
    public boolean loadImage(m r100, l r101) {
        return i.a(r100, r101);
    }
}
