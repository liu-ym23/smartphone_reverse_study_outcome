package com.ss.android.lark.im.sdk;

import com.ss.android.lark.im.sdk.usercontainer.ImSdkMessagePushProxy;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.internal.v;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import m6b.u;

/* JADX INFO: loaded from: classes36.dex */
public final class ImSdkServiceModule_ProvideMessagePushFactory implements Factory<u> {
    private final Provider<v> accessorProvider;
    private final b module;
    private final Provider<j> passportProvider;

    @Override // javax.inject.Provider
    public u get() {
        return provideMessagePush(this.module, this.passportProvider.get(), this.accessorProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public ImSdkServiceModule_ProvideMessagePushFactory(b r100, Provider<j> r101, Provider<v> r102) {
        this.module = r100;
        this.passportProvider = r101;
        this.accessorProvider = r102;
    }

    public static ImSdkServiceModule_ProvideMessagePushFactory create(b r100, Provider<j> r101, Provider<v> r102) {
        return new ImSdkServiceModule_ProvideMessagePushFactory(r100, r101, r102);
    }

    public static u provideMessagePush(b r100, j r101, v r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "passport");
        Intrinsics.checkNotNullParameter(r102, "accessor");
        String r103 = r101.g();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Log.i("ImSdkServiceModule", "provide ImSdkMessagePush, foregroundUid is ".concat(r103));
        ImSdkMessagePushProxy r104 = new ImSdkMessagePushProxy(r101, r102);
        h.a(r104);
        return (u) Preconditions.checkNotNullFromProvides(r104);
    }
}
