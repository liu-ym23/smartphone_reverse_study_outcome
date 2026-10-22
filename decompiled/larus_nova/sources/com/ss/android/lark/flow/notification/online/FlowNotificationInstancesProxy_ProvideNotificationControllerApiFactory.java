package com.ss.android.lark.flow.notification.online;

import com.ss.android.lark.flow.notification.online.proxy.a;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import ohb.b;
import zsb.c;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory implements Factory<c> {
    private final Provider<v> accessorProvider;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public c get() {
        return provideNotificationControllerApi(this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory(Provider<j> r100, Provider<v> r101) {
        this.passportProvider = r100;
        this.accessorProvider = r101;
    }

    public static FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory create(Provider<j> r100, Provider<v> r101) {
        return new FlowNotificationInstancesProxy_ProvideNotificationControllerApiFactory(r100, r101);
    }

    public static c provideNotificationControllerApi(j r100, v r101) {
        int r102 = b.f523341a;
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        a r103 = new a(r100, r101);
        h.a(r103);
        return (c) Preconditions.checkNotNullFromProvides(r103);
    }
}
