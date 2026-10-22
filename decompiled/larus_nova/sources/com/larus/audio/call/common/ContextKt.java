package com.larus.audio.call.common;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.audio.call.aec.f;
import com.larus.audio.call.util.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
public final class ContextKt {
    public static final Object a(Context r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof ContextKt$FlowAVKit_prepareAecModel$1) == false) goto L7;
        ContextKt$FlowAVKit_prepareAecModel$1 r102 = (ContextKt$FlowAVKit_prepareAecModel$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L25
    L23:
        Object r107 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r104).booleanValue()));     // Catch: Throwable -> L25
    L27:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L31;
        e.f289645a.e("FlowAVKit_prepareAecModel", "[prepareAecModel] error: " + r108);
    L31:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L25
        int r110 = f.f288968l;     // Catch: Throwable -> L25
        PolarisFileWrapper r111 = new PolarisFileWrapper(f.a.a());     // Catch: Throwable -> L25
        if (r111.exists() == true) goto L19;
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Throwable -> L25
        ContextKt$FlowAVKit_prepareAecModel$2$1 r113 = new ContextKt$FlowAVKit_prepareAecModel$2$1(r111, r100, null);     // Catch: Throwable -> L25
        r102.label = 1;     // Catch: Throwable -> L25
        r104 = BuildersKt.withContext(r112, r113, r102);     // Catch: Throwable -> L25
        if (r104 != r105) goto L23;
        return r105;
    L19:
        return Unit.INSTANCE;
    L25:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ContextKt$FlowAVKit_prepareAecModel$1(r101);
        goto L8
    }
}
