package com.ss.android.lark.chat.api.service.impl.secret;

import a2b.i;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory implements Factory<i> {
    private final Provider<v> accessorProvider;
    private final a module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public i get() {
        return provideSecretChatDataCorruptPush(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory(a r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory create(a r100, Provider<j> r101, Provider<v> r102) {
        return new SecretChatDataCorruptPushModule_ProvideSecretChatDataCorruptPushFactory(r100, r101, r102);
    }

    public static i provideSecretChatDataCorruptPush(a r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        SecretChatDataCorruptPushProxy r103 = new SecretChatDataCorruptPushProxy(r101, r102);
        h.a(r103);
        return (i) Preconditions.checkNotNullFromProvides(r103);
    }
}
