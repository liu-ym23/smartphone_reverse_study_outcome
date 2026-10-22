package com.larus.common.account.platform.larkauth.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.util.AuthConfig", f = "AuthConfig.kt", i = {}, l = {55}, m = "refreshHostList", n = {}, s = {})
public final class AuthConfig$refreshHostList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthConfig this$0;

    public AuthConfig$refreshHostList$1(AuthConfig r100, Continuation<? super AuthConfig$refreshHostList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
