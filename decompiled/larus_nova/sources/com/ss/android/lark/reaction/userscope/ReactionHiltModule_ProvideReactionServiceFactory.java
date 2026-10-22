package com.ss.android.lark.reaction.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class ReactionHiltModule_ProvideReactionServiceFactory implements Factory<m2c.b> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public m2c.b get() {
        return provideReactionService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ReactionHiltModule_ProvideReactionServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static ReactionHiltModule_ProvideReactionServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new ReactionHiltModule_ProvideReactionServiceFactory(r100, r101);
    }

    public static m2c.b provideReactionService(j r100, v r101) {
        int r102 = a.f439190a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        c r103 = new c(r100, r101);
        h.a(r103);
        return (m2c.b) Preconditions.checkNotNullFromProvides(r103);
    }
}
