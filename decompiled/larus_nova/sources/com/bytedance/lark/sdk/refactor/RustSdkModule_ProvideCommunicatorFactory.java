package com.bytedance.lark.sdk.refactor;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class RustSdkModule_ProvideCommunicatorFactory implements Factory<k> {
    private final Provider<Context> contextProvider;
    private final Provider<o> definitionProvider;
    private final Provider<i> receiverProvider;

    @Override // javax.inject.Provider
    public k get() {
        return provideCommunicator(this.contextProvider.get(), this.definitionProvider.get(), this.receiverProvider.get());
    }

    @Override // javax.inject.Provider
    public /* bridge */ /* synthetic */ Object get() {
        return get();
    }

    public RustSdkModule_ProvideCommunicatorFactory(Provider<Context> r100, Provider<o> r101, Provider<i> r102) {
        this.contextProvider = r100;
        this.definitionProvider = r101;
        this.receiverProvider = r102;
    }

    public static RustSdkModule_ProvideCommunicatorFactory create(Provider<Context> r100, Provider<o> r101, Provider<i> r102) {
        return new RustSdkModule_ProvideCommunicatorFactory(r100, r101, r102);
    }

    public static k provideCommunicator(Context r100, o r101, i r102) {
        int r103 = h0.f254272a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "definition");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_RECEIVER);
        RustCommunicator r104 = new RustCommunicator(r100, r101);
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_RECEIVER);
        r104.f254214b.addIfAbsent(r102);
        return (k) Preconditions.checkNotNullFromProvides(r104);
    }
}
