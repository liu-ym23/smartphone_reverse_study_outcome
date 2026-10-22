package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes36.dex */
public final class ExternalForwardSendHelperKt {
    public static final Object a(long r100, Function2<? super CoroutineScope, ? super IExternalForwardExecutor.a, Unit> r101, Continuation<? super a> r102) {
        if ((r102 instanceof ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1) == false) goto L7;
        ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1 r103 = (ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        a r108 = (a) r105;
        if (r108 == null) goto L20;
        return r108;
    L20:
        return a.c.f425124a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2 r109 = new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2(r101, null);
        r103.label = 1;
        r105 = TimeoutKt.c(r100, r109, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$1(r102);
        goto L8
    }
}
