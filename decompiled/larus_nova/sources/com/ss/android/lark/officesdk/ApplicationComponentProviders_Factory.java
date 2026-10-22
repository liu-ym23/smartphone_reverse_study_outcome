package com.ss.android.lark.officesdk;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class ApplicationComponentProviders_Factory implements Factory<a> {
    private final Provider<Application> applicationProvider;

    @Override // javax.inject.Provider
    public a get() {
        return newInstance(this.applicationProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ApplicationComponentProviders_Factory(Provider<Application> r100) {
        this.applicationProvider = r100;
    }

    public static ApplicationComponentProviders_Factory create(Provider<Application> r100) {
        return new ApplicationComponentProviders_Factory(r100);
    }

    public static a newInstance(Application r100) {
        return new a(r100);
    }
}
