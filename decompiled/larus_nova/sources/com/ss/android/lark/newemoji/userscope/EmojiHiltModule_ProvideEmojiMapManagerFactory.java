package com.ss.android.lark.newemoji.userscope;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import rsb.a;
import vsb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class EmojiHiltModule_ProvideEmojiMapManagerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideEmojiMapManager(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public EmojiHiltModule_ProvideEmojiMapManagerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static EmojiHiltModule_ProvideEmojiMapManagerFactory create(Provider<j> r100, Provider<v> r101) {
        return new EmojiHiltModule_ProvideEmojiMapManagerFactory(r100, r101);
    }

    public static a provideEmojiMapManager(j r100, v r101) {
        int r102 = vsb.a.f557163a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        c r103 = new c(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
