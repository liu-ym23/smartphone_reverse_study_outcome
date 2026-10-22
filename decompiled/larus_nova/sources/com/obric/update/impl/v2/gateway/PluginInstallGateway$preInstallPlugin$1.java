package com.obric.update.impl.v2.gateway;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.update.impl.v2.gateway.PluginInstallGateway", f = "PluginInstallGateway.kt", i = {}, l = {44}, m = "preInstallPlugin", n = {}, s = {})
public final class PluginInstallGateway$preInstallPlugin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginInstallGateway this$0;

    public PluginInstallGateway$preInstallPlugin$1(PluginInstallGateway r100, Continuation<? super PluginInstallGateway$preInstallPlugin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
