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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocsSdkCompatModule_ProvideDocsSdkFactory implements Factory<a> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportServiceProvider;

    public a get() {
        return provideDocsSdk((j) this.passportServiceProvider.get(), (v) this.accessorProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m163get() {
        return get();
    }

    public DocsSdkCompatModule_ProvideDocsSdkFactory(Provider<j> r1, Provider<v> r2) {
        this.passportServiceProvider = r1;
        this.accessorProvider = r2;
    }

    public static DocsSdkCompatModule_ProvideDocsSdkFactory create(Provider<j> r1, Provider<v> r2) {
        return new DocsSdkCompatModule_ProvideDocsSdkFactory(r1, r2);
    }

    public static a provideDocsSdk(j r1, v r2) {
        int r0 = c.a;
        Intrinsics.checkNotNullParameter(r1, "passportService");
        Intrinsics.checkNotNullParameter(r2, "accessor");
        e r3 = new e(r1, r2);
        h.a(r3);
        return (a) Preconditions.checkNotNullFromProvides(r3);
    }
}
