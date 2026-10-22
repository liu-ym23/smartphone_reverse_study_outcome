package com.bytedance.ee.bear.docs;

import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import ik5.a;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import tz4.c;
import tz4.e;

/* JADX INFO: loaded from: classes16.dex */
public final class DocsSdkCompatModule_ProvideDocsSdkFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportServiceProvider;

    @Override // javax.inject.Provider
    public a get() {
        return provideDocsSdk(this.passportServiceProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public DocsSdkCompatModule_ProvideDocsSdkFactory(Provider<j> r100, Provider<v> r101) {
        this.passportServiceProvider = r100;
        this.accessorProvider = r101;
    }

    public static DocsSdkCompatModule_ProvideDocsSdkFactory create(Provider<j> r100, Provider<v> r101) {
        return new DocsSdkCompatModule_ProvideDocsSdkFactory(r100, r101);
    }

    public static a provideDocsSdk(j r100, v r101) {
        int r102 = c.f548047a;
        Intrinsics.checkNotNullParameter(r100, "passportService");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        e r103 = new e(r100, r101);
        h.a(r103);
        return (a) Preconditions.checkNotNullFromProvides(r103);
    }
}
