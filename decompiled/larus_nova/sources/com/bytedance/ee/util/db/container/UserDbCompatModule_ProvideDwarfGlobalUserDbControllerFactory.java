package com.bytedance.ee.util.db.container;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class UserDbCompatModule_ProvideDwarfGlobalUserDbControllerFactory implements Factory<com.bytedance.ee.util.db.a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public com.bytedance.ee.util.db.a get() {
        return provideDwarfGlobalUserDbController(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public UserDbCompatModule_ProvideDwarfGlobalUserDbControllerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static UserDbCompatModule_ProvideDwarfGlobalUserDbControllerFactory create(Provider<j> r100, Provider<v> r101) {
        return new UserDbCompatModule_ProvideDwarfGlobalUserDbControllerFactory(r100, r101);
    }

    public static com.bytedance.ee.util.db.a provideDwarfGlobalUserDbController(j r100, v r101) {
        int r102 = b.f243121a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        DBControllerProxy r103 = new DBControllerProxy(r100, r101);
        h.a(r103);
        return (com.bytedance.ee.util.db.a) Preconditions.checkNotNullFromProvides(r103);
    }
}
