package com.larus.dora.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor", f = "DoraRouterInterceptor.kt", i = {}, l = {250}, m = "buildLynxVolumeSettingsPageUrl", n = {}, s = {})
final class DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1(DoraRouterInterceptor r100, Continuation<? super DoraRouterInterceptor$buildLynxVolumeSettingsPageUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraRouterInterceptor.c(this.this$0, this);
    }
}
