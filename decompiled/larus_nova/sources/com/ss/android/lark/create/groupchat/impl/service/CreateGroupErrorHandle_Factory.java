package com.ss.android.lark.create.groupchat.impl.service;

import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes35.dex */
public final class CreateGroupErrorHandle_Factory implements Factory<b> {
    private final Provider<Map<InterceptorType, Provider<c>>> mapProvider;

    @Override // javax.inject.Provider
    public b get() {
        return newInstance(this.mapProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public CreateGroupErrorHandle_Factory(Provider<Map<InterceptorType, Provider<c>>> r100) {
        this.mapProvider = r100;
    }

    public static CreateGroupErrorHandle_Factory create(Provider<Map<InterceptorType, Provider<c>>> r100) {
        return new CreateGroupErrorHandle_Factory(r100);
    }

    public static b newInstance(Map<InterceptorType, Provider<c>> r100) {
        return new b(r100);
    }
}
