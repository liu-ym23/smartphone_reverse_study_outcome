package com.lynx.tasm.service;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxTrailService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxTrailService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxTrailService r100) {
            return ILynxTrailService.class;
        }
    }

    Map<String, Object> getAllValues();

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    Object objectValueForTrailKey(String r100);

    String stringValueForTrailKey(String r100);
}
