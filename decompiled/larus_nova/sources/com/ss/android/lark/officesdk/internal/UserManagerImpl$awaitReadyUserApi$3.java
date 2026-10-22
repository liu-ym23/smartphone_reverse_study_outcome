package com.ss.android.lark.officesdk.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitReadyUserApi$3", f = "UserManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserManagerImpl$awaitReadyUserApi$3 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $version;
    /* synthetic */ int I$0;
    int label;

    public UserManagerImpl$awaitReadyUserApi$3(int r100, Continuation<? super UserManagerImpl$awaitReadyUserApi$3> r101) {
        this.$version = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        UserManagerImpl$awaitReadyUserApi$3 r102 = new UserManagerImpl$awaitReadyUserApi$3(this.$version, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Boolean> r101) {
        return ((UserManagerImpl$awaitReadyUserApi$3) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Boolean> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        if (this.I$0 == this.$version) goto L7;
        boolean r101 = true;
    L9:
        return Boxing.boxBoolean(r101);
    L7:
        r101 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
