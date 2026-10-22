package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.baidu.mapapi.SDKInitializer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmCustomExceptionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MmCustomException f433914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MmCustomException f433915b = null;

    static {
        f433914a = new MmCustomException(10001, SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        f433915b = new MmCustomException(10002, "absent user network request skipped");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a1 -> B:17:0x0056). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00b6 -> B:17:0x0056). Please report as a decompilation issue!!! */
    public static final <T> Object a(int r110, Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r111, Continuation<? super Result<? extends T>> r112) {
        if ((r112 instanceof MmCustomExceptionKt$withRetry$1) == false) goto L7;
        MmCustomExceptionKt$withRetry$1 r100 = (MmCustomExceptionKt$withRetry$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        int r114 = r100.I$1;
        int r115 = r100.I$0;
        Throwable r104 = (Throwable) r100.L$1;
        Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r105 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L17:
        if (r114 >= r115) goto L37;
        Integer r116 = Boxing.boxInt(r114);
        r100.L$0 = r105;
        r100.L$1 = null;
        r100.I$0 = r115;
        r100.I$1 = r114;
        r100.label = 1;
        r113 = r105.invoke(r116, r100);
        if (r113 != r102) goto L21;
        return r102;
    L21:
        Object r117 = ((Result) r113).m9458unboximpl();
        if (Result.m9456isSuccessimpl(r117) == false) goto L24;
        return r117;
    L24:
        r104 = Result.m9452exceptionOrNullimpl(r117);
        MmCustomException r118 = f433915b;
        if (Intrinsics.areEqual(r104, r118) == false) goto L29;
        return Result.m9449constructorimpl(ResultKt.createFailure(r118));
    L29:
        if (com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.c.a() == true) goto L31;
        r114 = r114 + 1;
        if (r114 >= r115) goto L17;
        r100.L$0 = r105;
        r100.L$1 = r104;
        r100.I$0 = r115;
        r100.I$1 = r114;
        r100.label = 2;
        if (DelayKt.delay(((long) r114) * 2000, r100) != r102) goto L17;
        return r102;
    L31:
        return Result.m9449constructorimpl(ResultKt.createFailure(f433914a));
    L37:
        Result.Companion r119 = Result.Companion;
        if (r104 != null) goto L41;
        r104 = new Throwable("Unknown error after " + r115 + " attempts");
    L41:
        return Result.m9449constructorimpl(ResultKt.createFailure(r104));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r114 = r100.I$1;
        r115 = r100.I$0;
        Function2<? super Integer, ? super Continuation<? super Result<? extends T>>, ? extends Object> r106 = (Function2) r100.L$0;
        ResultKt.throwOnFailure(r113);
        r105 = r106;
        goto L21
    L16:
        ResultKt.throwOnFailure(r113);
        r105 = r111;
        r104 = null;
        r115 = r110;
        r114 = 0;
    L7:
        r100 = new MmCustomExceptionKt$withRetry$1(r112);
        goto L8
    }
}
