package com.larus.bmhome.chat.auth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginAuthRepository", f = "PluginAuthRepository.kt", i = {}, l = {36}, m = "requestPluginList", n = {}, s = {})
public final class PluginAuthRepository$requestPluginList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PluginAuthRepository this$0;

    public PluginAuthRepository$requestPluginList$1(PluginAuthRepository r100, Continuation<? super PluginAuthRepository$requestPluginList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, 0, 0, null, this);
    }
}
