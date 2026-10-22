package com.ss.android.lark.widget.photo.preview.video;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ucc.a;
import ucc.b;
import ucc.d;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoGlobalContainerModule_ProvideVideoProgressContainerFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideVideoProgressContainer(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VideoGlobalContainerModule_ProvideVideoProgressContainerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static VideoGlobalContainerModule_ProvideVideoProgressContainerFactory create(Provider<j> r100, Provider<v> r101) {
        return new VideoGlobalContainerModule_ProvideVideoProgressContainerFactory(r100, r101);
    }

    public static a provideVideoProgressContainer(j r100, v r101) {
        int r102 = b.f549699a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        d r103 = new d(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
