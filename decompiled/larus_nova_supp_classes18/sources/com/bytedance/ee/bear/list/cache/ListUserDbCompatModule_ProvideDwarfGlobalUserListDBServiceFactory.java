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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory implements Factory<j> {
    private final Provider<v> accessorProvider;
    private final Provider<com.ss.android.lark.passportc.api.j> passportProvider;

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public j m7get() {
        return provideDwarfGlobalUserListDBService((com.ss.android.lark.passportc.api.j) this.passportProvider.get(), (v) this.accessorProvider.get());
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m7get();
    }

    public ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<v> r2) {
        this.passportProvider = r1;
        this.accessorProvider = r2;
    }

    public static ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory create(Provider<com.ss.android.lark.passportc.api.j> r1, Provider<v> r2) {
        return new ListUserDbCompatModule_ProvideDwarfGlobalUserListDBServiceFactory(r1, r2);
    }

    public static j provideDwarfGlobalUserListDBService(com.ss.android.lark.passportc.api.j r1, v r2) {
        int r0 = w1.a;
        Intrinsics.checkNotNullParameter(r1, "passport");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        l r3 = new l(r1, r2);
        h.a(r3);
        return (j) Preconditions.checkNotNullFromProvides(r3);
    }
}
