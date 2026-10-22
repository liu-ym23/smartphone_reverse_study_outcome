package com.ss.android.lark.profile_office.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import t1c.a;
import t1c.b;
import x1c.d;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory implements Factory<d> {
    private final a module;

    @Override // javax.inject.Provider
    public d get() {
        return provideOfficeProfileProtocol(this.module);
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory(a r100) {
        this.module = r100;
    }

    public static OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory create(a r100) {
        return new OfficeProfileHiltModule_ProvideOfficeProfileProtocolFactory(r100);
    }

    public static d provideOfficeProfileProtocol(a r100) {
        r100.getClass();
        return (d) Preconditions.checkNotNullFromProvides(new b());
    }
}
