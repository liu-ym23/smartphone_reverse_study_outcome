package com.ss.android.lark.applink;

import com.ss.android.lark.passportc.api.j;
import dagger.internal.Factory;
import javax.inject.Provider;
import ova.b;
import ova.f;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLinkInstance_Factory implements Factory<f> {
    private final Provider<b> depProvider;
    private final Provider<j> passportGlobalServiceProvider;

    @Override // javax.inject.Provider
    public f get() {
        return newInstance(this.passportGlobalServiceProvider.get(), this.depProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public AppLinkInstance_Factory(Provider<j> r100, Provider<b> r101) {
        this.passportGlobalServiceProvider = r100;
        this.depProvider = r101;
    }

    public static AppLinkInstance_Factory create(Provider<j> r100, Provider<b> r101) {
        return new AppLinkInstance_Factory(r100, r101);
    }

    public static f newInstance(j r100, b r101) {
        return new f(r100, r101);
    }
}
