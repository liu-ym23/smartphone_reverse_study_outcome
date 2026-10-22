package com.ss.android.lark.officesdk.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl", f = "UserManagerImpl.kt", i = {0}, l = {568}, m = "awaitUserApiForSession$officesdk_core_release", n = {"timeoutMs"}, s = {"J$0"})
public final class UserManagerImpl$awaitUserApiForSession$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$awaitUserApiForSession$1(UserManagerImpl r100, Continuation<? super UserManagerImpl$awaitUserApiForSession$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, 0, this);
    }
}
