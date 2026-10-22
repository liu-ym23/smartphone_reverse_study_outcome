package com.ss.android.lark.feed.molten;

import com.bytedance.lark.view_flow_wrapper.v;
import com.ss.android.lark.passportc.api.m;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import eeb.a;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import yrb.b;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory implements Factory<v> {
    private final a module;
    private final Provider<m> passportProvider;

    @Override // javax.inject.Provider
    public v get() {
        return providesSuspendStrategy(this.module, this.passportProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory(a r100, Provider<m> r101) {
        this.module = r100;
        this.passportProvider = r101;
    }

    public static FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory create(a r100, Provider<m> r101) {
        return new FeedMoltenModuleIncluded_ProvidesSuspendStrategyFactory(r100, r101);
    }

    public static v providesSuspendStrategy(a r100, m r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        if (r101 != null) goto L5;
        v.f254467a.getClass();
        Object r102 = v.b.f254469b;
    L7:
        return (v) Preconditions.checkNotNullFromProvides(r102);
    L5:
        r102 = new b(r101);
        goto L7
    }
}
