package com.obric.assistant.onelogin;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginUtilsKt$awaitOAccountChanged$2", f = "ObricOneLoginUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricOneLoginUtilsKt$awaitOAccountChanged$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    int label;

    public ObricOneLoginUtilsKt$awaitOAccountChanged$2(Continuation<? super ObricOneLoginUtilsKt$awaitOAccountChanged$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricOneLoginUtilsKt$awaitOAccountChanged$2 r102 = new ObricOneLoginUtilsKt$awaitOAccountChanged$2(r101);
        r102.Z$0 = ((Boolean) r100).booleanValue();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Continuation<? super Boolean> r101) {
        return invoke(r100.booleanValue(), r101);
    }

    public final Object invoke(boolean r100, Continuation<? super Boolean> r101) {
        return ((ObricOneLoginUtilsKt$awaitOAccountChanged$2) create(Boolean.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return Boxing.boxBoolean(!this.Z$0);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
