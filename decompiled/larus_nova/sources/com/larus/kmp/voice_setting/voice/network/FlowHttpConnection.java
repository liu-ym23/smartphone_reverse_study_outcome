package com.larus.kmp.voice_setting.voice.network;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowHttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowHttpConnection f353982a = null;

    static {
        f353982a = new FlowHttpConnection();
    }

    public FlowHttpConnection() {
    }

    public final <T> Object a(Function1<? super Continuation<? super a<T>>, ? extends Object> r100, Continuation<? super b<? extends T>> r101) {
        if ((r101 instanceof FlowHttpConnection$safeCall$1) == false) goto L7;
        FlowHttpConnection$safeCall$1 r102 = (FlowHttpConnection$safeCall$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L27
    L19:
        a r107 = (a) r104;     // Catch: Exception -> L27
        if (r107 == null) goto L34;
        Object r108 = c.b(r107, null);     // Catch: Exception -> L27
        if (r108 != null) goto L35;
        r108 = new b.C4393b(r107, null);     // Catch: Exception -> L27
    L35:
        return r108;
    L34:
        return new b.a(-1005, "ssResponse is null", new Exception("ssResponse is null"));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;     // Catch: Exception -> L27
        r104 = r100.invoke(r102);     // Catch: Exception -> L27
        if (r104 != r105) goto L19;
        return r105;
    L27:
        e = move-exception;
        String r109 = e.getMessage();
        if (r109 != null) goto L32;
        r109 = "";
    L32:
        return new b.a(-1000, r109, e);
    L7:
        r102 = new FlowHttpConnection$safeCall$1(this, r101);
        goto L8
    }
}
