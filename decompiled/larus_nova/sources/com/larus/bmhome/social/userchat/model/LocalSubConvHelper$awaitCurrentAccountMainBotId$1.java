package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper", f = "LocalSubConvHelper.kt", i = {0, 0}, l = {73, 81}, m = "awaitCurrentAccountMainBotId", n = {"expectedSecUserId", "initialCoreResult"}, s = {"L$0", "L$1"})
public final class LocalSubConvHelper$awaitCurrentAccountMainBotId$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalSubConvHelper this$0;

    public LocalSubConvHelper$awaitCurrentAccountMainBotId$1(LocalSubConvHelper r100, Continuation<? super LocalSubConvHelper$awaitCurrentAccountMainBotId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
