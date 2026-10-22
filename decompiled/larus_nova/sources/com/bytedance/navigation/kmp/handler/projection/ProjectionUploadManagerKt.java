package com.bytedance.navigation.kmp.handler.projection;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public final class ProjectionUploadManagerKt {
    public static final Object a(Function1<? super Continuation<? super Boolean>, ? extends Object> r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ProjectionUploadManagerKt$runUploadWithOneRetry$1) == false) goto L7;
        ProjectionUploadManagerKt$runUploadWithOneRetry$1 r102 = (ProjectionUploadManagerKt$runUploadWithOneRetry$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r104);
    L26:
        return r104;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (Function1) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        if (((Boolean) r104).booleanValue() == true) goto L22;
        r102.L$0 = null;
        r102.label = 2;
        r104 = b(r100, r102);
        if (r104 != r105) goto L26;
        return r105;
    L22:
        return Boxing.boxBoolean(true);
    L16:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = b(r100, r102);
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new ProjectionUploadManagerKt$runUploadWithOneRetry$1(r101);
        goto L8
    }

    public static final Object b(Function1<? super Continuation<? super Boolean>, ? extends Object> r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1) == false) goto L7;
        ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1 r102 = (ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L21
    L19:
        Object r107 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r104).booleanValue()));     // Catch: Throwable -> L21
    L23:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L30;
        d37.i r109 = d37.i.f466749a;
        d37.i.e("Projection upload attempt failed", r108);
        return Boxing.boxBoolean(false);
    L30:
        return r107;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L21
        r102.label = 1;     // Catch: Throwable -> L21
        r104 = r100.invoke(r102);     // Catch: Throwable -> L21
        if (r104 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ProjectionUploadManagerKt$runUploadWithOneRetry$attempt$1(r101);
        goto L8
    }
}
