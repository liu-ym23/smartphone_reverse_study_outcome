package com.ss.android.lark.feed.shared;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import heb.b;
import javax.inject.Provider;
import jeb.c;
import jeb.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        return provideFeedClickDataCache(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory create(Provider<j> r100, Provider<v> r101) {
        return new FeedSharedModuleInstances_ProvideFeedClickDataCacheFactory(r100, r101);
    }

    public static d provideFeedClickDataCache(j r100, v r101) {
        int r102 = b.f484904a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        c r103 = new c(r100, r101);
        h.a(r103);
        return (d) Preconditions.checkNotNullFromProvides(r103);
    }
}
