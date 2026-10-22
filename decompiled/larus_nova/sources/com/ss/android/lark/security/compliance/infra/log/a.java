package com.ss.android.lark.security.compliance.infra.log;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes38.dex */
public final class a {
    public static final Object a(CoroutineScope r100, String r101, Function2 r102, Continuation r103) {
        if ((r103 instanceof ScsLoggerKt$withContext$resumeTraceBlock$1) == false) goto L7;
        ScsLoggerKt$withContext$resumeTraceBlock$1 r104 = (ScsLoggerKt$withContext$resumeTraceBlock$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L18;
        if (r108 != 1) goto L17;
        String r109 = (String) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L14
    L24:
        qqb.a.a();
        qqb.a.f(r109);
        return r106;
    L14:
        th = th;
    L30:
        qqb.a.a();
        qqb.a.f(r109);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r106);
        String r110 = qqb.a.d();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r101, "traceId");     // Catch: Throwable -> L26
        qqb.a.g(r101);     // Catch: Throwable -> L26
        r104.L$0 = r110;     // Catch: Throwable -> L26
        r104.label = 1;     // Catch: Throwable -> L26
        Object r111 = r102.invoke(r100, r104);     // Catch: Throwable -> L26
        if (r111 == r107) goto L38;
        r106 = r111;
        r109 = r110;
        goto L24
    L38:
        return r107;
    L26:
        th = move-exception;
        th = th;
        r109 = r110;
    L28:
        th = th;
        r109 = "";
    L7:
        r104 = new ScsLoggerKt$withContext$resumeTraceBlock$1(r103);
        goto L8
    }

    public static final Object b(String r100, MainCoroutineDispatcher r101, Function2 r102, Continuation r103) {
        return BuildersKt.withContext(r101, new ScsLoggerKt$withContext$2(r100, r102, null), r103);
    }
}
