package com.lynx.tasm.service;

import com.lynx.jsbridge.network.HttpRequest;
import i8a.i;
import z5a.a;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxHttpService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxHttpService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxHttpService r100) {
            return ILynxHttpService.class;
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    void request(HttpRequest r100, i r101);

    void requestStreaming(HttpRequest r100, i r101, a r102);
}
