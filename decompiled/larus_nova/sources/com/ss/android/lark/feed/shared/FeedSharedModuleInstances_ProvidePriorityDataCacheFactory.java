package com.ss.android.lark.feed.shared;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import heb.b;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import neb.a;
import neb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedSharedModuleInstances_ProvidePriorityDataCacheFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return providePriorityDataCache(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FeedSharedModuleInstances_ProvidePriorityDataCacheFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static FeedSharedModuleInstances_ProvidePriorityDataCacheFactory create(Provider<j> r100, Provider<v> r101) {
        return new FeedSharedModuleInstances_ProvidePriorityDataCacheFactory(r100, r101);
    }

    public static a providePriorityDataCache(j r100, v r101) {
        int r102 = b.f484904a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
