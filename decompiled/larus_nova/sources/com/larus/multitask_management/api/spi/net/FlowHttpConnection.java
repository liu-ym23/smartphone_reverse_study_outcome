package com.larus.multitask_management.api.spi.net;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class FlowHttpConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowHttpConnection f359391a = null;

    static {
        f359391a = new FlowHttpConnection();
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
        String r107 = "";
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L34
    L19:
        a r108 = (a) r104;     // Catch: Exception -> L34
        if (r108 != null) goto L23;
        return new b.a(-1005, "ssResponse is null", new Exception("ssResponse is null"));
    L23:
        if (r108.a() == true) goto L43;
        Integer r109 = StringsKt.toIntOrNull(String.valueOf(r108.f359393a));     // Catch: Exception -> L34
        if (r109 == null) goto L28;
        int r110 = r109.intValue();     // Catch: Exception -> L34
    L29:
        String r111 = r108.f359394b;     // Catch: Exception -> L34
        if (r111 != null) goto L44;
        r111 = "";
    L44:
        return new b.a(r110, r111, new Exception("BizResponse is not success"));
    L28:
        r110 = -1000;
        goto L29
    L43:
        return new b.C4423b(r108);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        r102.label = 1;     // Catch: Exception -> L34
        r104 = r100.invoke(r102);     // Catch: Exception -> L34
        if (r104 != r105) goto L19;
        return r105;
    L34:
        e = move-exception;
        String r112 = e.getMessage();
        if (r112 == null) goto L40;
        r107 = r112;
    L40:
        return new b.a(-1000, r107, e);
    L7:
        r102 = new FlowHttpConnection$safeCall$1(this, r101);
        goto L8
    }
}
