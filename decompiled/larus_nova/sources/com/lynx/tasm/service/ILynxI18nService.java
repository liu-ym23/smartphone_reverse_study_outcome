package com.lynx.tasm.service;

import com.lynx.tasm.INativeLibraryLoader;

/* JADX INFO: loaded from: classes32.dex */
public interface ILynxI18nService extends IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.ILynxI18nService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Class $default$getServiceClass(ILynxI18nService r100) {
            return ILynxI18nService.class;
        }
    }

    @Override // com.lynx.tasm.service.IServiceProvider
    Class<? extends IServiceProvider> getServiceClass();

    boolean loadLibrary(INativeLibraryLoader r100);

    boolean registerNapiEnv(long r100);
}
