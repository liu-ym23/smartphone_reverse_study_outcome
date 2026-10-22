package com.larus.profile.impl.bind_phone;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.profile.impl.bind_phone.BindPhoneManager", f = "BindPhoneManager.kt", i = {0}, l = {63}, m = "checkBindPhoneInfo", n = {"showDialog"}, s = {"L$0"})
final class BindPhoneManager$checkBindPhoneInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public BindPhoneManager$checkBindPhoneInfo$1(c r100, Continuation<? super BindPhoneManager$checkBindPhoneInfo$1> r101) {
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
