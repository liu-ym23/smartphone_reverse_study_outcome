package com.ss.android.lark.statistics.internal;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import o5c.b;
import x5c.c;
import x5c.d;

/* JADX INFO: loaded from: classes38.dex */
public final class StatisticsModule_ProvideStatisticsFactory implements Factory<b> {
    private final Provider<v> accessorProvider;
    private final d module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideStatistics(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public StatisticsModule_ProvideStatisticsFactory(d r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static StatisticsModule_ProvideStatisticsFactory create(d r100, Provider<j> r101, Provider<v> r102) {
        return new StatisticsModule_ProvideStatisticsFactory(r100, r101, r102);
    }

    public static b provideStatistics(d r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        c r103 = new c(r101, r102);
        h.a(r103);
        return (b) Preconditions.checkNotNullFromProvides(r103);
    }
}
