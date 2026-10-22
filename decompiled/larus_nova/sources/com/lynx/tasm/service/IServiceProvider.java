package com.lynx.tasm.service;

import android.content.Context;

/* JADX INFO: loaded from: classes32.dex */
public interface IServiceProvider {

    /* JADX INFO: renamed from: com.lynx.tasm.service.IServiceProvider$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onInitialize(IServiceProvider r100, Context r101) {
        }
    }

    Class<? extends IServiceProvider> getServiceClass();

    void onInitialize(Context r100);
}
