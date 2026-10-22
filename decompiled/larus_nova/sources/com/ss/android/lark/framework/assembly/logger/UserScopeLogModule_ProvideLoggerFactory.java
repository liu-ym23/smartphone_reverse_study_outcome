package com.ss.android.lark.framework.assembly.logger;

import com.suite.component.logger.Log;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class UserScopeLogModule_ProvideLoggerFactory implements Factory<com.ss.android.lark.log.c> {
    private final Provider<String> userIdProvider;

    @Override // javax.inject.Provider
    public com.ss.android.lark.log.c get() {
        return provideLogger(this.userIdProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserScopeLogModule_ProvideLoggerFactory(Provider<String> r100) {
        this.userIdProvider = r100;
    }

    public static UserScopeLogModule_ProvideLoggerFactory create(Provider<String> r100) {
        return new UserScopeLogModule_ProvideLoggerFactory(r100);
    }

    public static com.ss.android.lark.log.c provideLogger(String r100) {
        int r101 = e.f425664a;
        Intrinsics.checkNotNullParameter(r100, "userId");
        com.suite.component.logger.api.b r102 = Log.f460087a.b();
        d r103 = new d(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "interceptor");
        r102.f460103e.add(r103);
        return (com.ss.android.lark.log.c) Preconditions.checkNotNullFromProvides(new com.ss.android.lark.log.d(r102.a()));
    }
}
