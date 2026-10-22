package com.ss.android.lark.passportc.impl.v2;

import com.ss.android.lark.passportc.api.f;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.internal.p;
import com.ss.android.lark.passportc.internal.t;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes37.dex */
public final class PassportStateManagerImpl2_Factory implements Factory<PassportStateManagerImpl2> {
    private final Provider<f> backgroundUserServiceProvider;
    private final Provider<t> executorsProvider;
    private final Provider<i> multiOnlineFGProvider;
    private final Provider<com.ss.android.lark.passportc.impl.v2.state.a> stateMachineFactoryProvider;
    private final Provider<d> updateVisitorProvider;
    private final Provider<p> userDataSourceProvider;

    @Override // javax.inject.Provider
    public PassportStateManagerImpl2 get() {
        return newInstance(this.userDataSourceProvider.get(), this.executorsProvider.get(), this.multiOnlineFGProvider.get(), this.backgroundUserServiceProvider.get(), this.stateMachineFactoryProvider.get(), this.updateVisitorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public PassportStateManagerImpl2_Factory(Provider<p> r100, Provider<t> r101, Provider<i> r102, Provider<f> r103, Provider<com.ss.android.lark.passportc.impl.v2.state.a> r104, Provider<d> r105) {
        this.userDataSourceProvider = r100;
        this.executorsProvider = r101;
        this.multiOnlineFGProvider = r102;
        this.backgroundUserServiceProvider = r103;
        this.stateMachineFactoryProvider = r104;
        this.updateVisitorProvider = r105;
    }

    public static PassportStateManagerImpl2_Factory create(Provider<p> r100, Provider<t> r101, Provider<i> r110, Provider<f> r111, Provider<com.ss.android.lark.passportc.impl.v2.state.a> r112, Provider<d> r113) {
        return new PassportStateManagerImpl2_Factory(r100, r101, r110, r111, r112, r113);
    }

    public static PassportStateManagerImpl2 newInstance(p r100, t r101, i r110, f r111, com.ss.android.lark.passportc.impl.v2.state.a r112, d r113) {
        return new PassportStateManagerImpl2(r100, r101, r110, r111, r112, r113);
    }
}
