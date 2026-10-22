package com.bytedance.lynx.service.network;

import android.content.Context;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.IServiceProvider;
import i8a.i;

/* JADX INFO: loaded from: classes21.dex */
public class LynxHttpServiceProvider implements ILynxHttpService {
    public LynxHttpServiceProvider() {
    }

    @Override // com.lynx.tasm.service.ILynxHttpService, com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ Class getServiceClass() {
        return ILynxHttpService.CC.$default$getServiceClass(this);
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    public final /* synthetic */ void onInitialize(Context r100) {
        IServiceProvider.CC.$default$onInitialize(this, r100);
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void request(HttpRequest r100, i r101) {
        LynxHttpService.getInstance().request(r100, r101);
    }

    @Override // com.lynx.tasm.service.ILynxHttpService
    public void requestStreaming(HttpRequest r100, i r101, z5a.a r102) {
        LynxHttpService.getInstance().requestStreaming(r100, r101, r102);
    }
}
