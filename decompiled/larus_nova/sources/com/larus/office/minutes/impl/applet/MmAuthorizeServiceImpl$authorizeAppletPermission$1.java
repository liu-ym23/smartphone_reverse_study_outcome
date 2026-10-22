package com.larus.office.minutes.impl.applet;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.minutes.impl.applet.MmAuthorizeServiceImpl", f = "MmAuthorizeServiceImpl.kt", i = {0}, l = {44}, m = "authorizeAppletPermission", n = {"scope"}, s = {"L$0"})
public final class MmAuthorizeServiceImpl$authorizeAppletPermission$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmAuthorizeServiceImpl this$0;

    public MmAuthorizeServiceImpl$authorizeAppletPermission$1(MmAuthorizeServiceImpl r100, Continuation<? super MmAuthorizeServiceImpl$authorizeAppletPermission$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c1(null, this);
    }
}
