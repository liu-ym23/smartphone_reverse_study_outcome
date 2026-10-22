package com.ss.android.lark.widget.photo.preview.video;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.widget.photo.preview.video.pip.b;
import com.ss.android.lark.widget.photo.preview.video.pip.g;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoGlobalContainerModule_ProvidePipGlobalContainerFactory implements Factory<b> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public b get() {
        return providePipGlobalContainer(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public VideoGlobalContainerModule_ProvidePipGlobalContainerFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static VideoGlobalContainerModule_ProvidePipGlobalContainerFactory create(Provider<j> r100, Provider<v> r101) {
        return new VideoGlobalContainerModule_ProvidePipGlobalContainerFactory(r100, r101);
    }

    public static b providePipGlobalContainer(j r100, v r101) {
        int r102 = ucc.b.f549699a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        g r103 = new g(r100, r101);
        h.a(r103);
        return (b) Preconditions.checkNotNullFromProvides(r103);
    }
}
