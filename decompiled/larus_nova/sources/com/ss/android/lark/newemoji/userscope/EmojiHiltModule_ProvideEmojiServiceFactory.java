package com.ss.android.lark.newemoji.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import rsb.b;
import vsb.a;
import vsb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class EmojiHiltModule_ProvideEmojiServiceFactory implements Factory<b> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public b get() {
        return provideEmojiService(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public EmojiHiltModule_ProvideEmojiServiceFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static EmojiHiltModule_ProvideEmojiServiceFactory create(Provider<j> r100, Provider<v> r101) {
        return new EmojiHiltModule_ProvideEmojiServiceFactory(r100, r101);
    }

    public static b provideEmojiService(j r100, v r101) {
        int r102 = a.f557163a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (b) Preconditions.checkNotNullFromProvides(r103);
    }
}
