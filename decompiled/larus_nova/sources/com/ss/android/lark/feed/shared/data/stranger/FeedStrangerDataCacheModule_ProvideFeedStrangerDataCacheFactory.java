package com.ss.android.lark.feed.shared.data.stranger;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import oeb.b;
import oeb.c;
import oeb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedStrangerDataCacheModule_ProvideFeedStrangerDataCacheFactory implements Factory<d> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public d get() {
        return provideFeedStrangerDataCache(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedStrangerDataCacheModule_ProvideFeedStrangerDataCacheFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static FeedStrangerDataCacheModule_ProvideFeedStrangerDataCacheFactory create(Provider<j> r100, Provider<v> r101) {
        return new FeedStrangerDataCacheModule_ProvideFeedStrangerDataCacheFactory(r100, r101);
    }

    public static d provideFeedStrangerDataCache(j r100, v r101) {
        int r102 = b.f523050a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        c r103 = new c(r100, r101);
        h.a(r103);
        return (d) Preconditions.checkNotNullFromProvides(r103);
    }
}
