package com.bytedance.ee.bear.list.cache;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import mc5.j;
import mc5.l;
import mc5.w1;

/* JADX INFO: loaded from: classes18.dex */
public final class ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory implements Factory<j> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    @Override // javax.inject.Provider
    public j get() {
        return provideDwarfGlobalUserListDBService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory create(Provider<com.ss.android.lark.passportc.api.j> r100, Provider<v> r101) {
        return new ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory(r100, r101);
    }

    public static j provideDwarfGlobalUserListDBService(com.ss.android.lark.passportc.api.j r100, v r101) {
        int r102 = w1.f513217a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        l r103 = new l(r100, r101);
        h.a(r103);
        return (j) Preconditions.checkNotNullFromProvides(r103);
    }
}
