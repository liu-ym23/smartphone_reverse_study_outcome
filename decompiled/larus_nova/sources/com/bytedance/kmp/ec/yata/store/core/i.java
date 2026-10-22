package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class i implements com.bytedance.kmp.ec.yata.store.redux.d<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ YataStoreWrapper f251743a;

    public i(YataStoreWrapper r100) {
        this.f251743a = r100;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.kmp.ec.yata.store.core.YataMiddlewareKt$createMainDispatcherMiddleWare$middleware$1$createDispatcherEnhancer$1] */
    @Override // com.bytedance.kmp.ec.yata.store.redux.d
    public final YataMiddlewareKt$createMainDispatcherMiddleWare$middleware$1$createDispatcherEnhancer$1 a(com.bytedance.kmp.ec.yata.store.redux.h r100) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        final YataStoreWrapper r101 = this.f251743a;
        return new YataMiddlewareKt$createMainDispatcherMiddleWare$middleware$1$createDispatcherEnhancer$1(r101);
    }
}
