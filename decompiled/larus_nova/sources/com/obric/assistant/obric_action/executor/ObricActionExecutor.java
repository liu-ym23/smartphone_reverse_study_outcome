package com.obric.assistant.obric_action.executor;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.obric_action.IObricActionHandler;
import com.obric.assistant.obric_action.h;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricActionExecutor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f390439b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, IObricActionHandler<?, ?>> f390440a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricActionExecutor(Map<String, ? extends IObricActionHandler<?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "handlerMap");
        this.f390440a = r100;
    }

    public final Object a(Context r100, efa.a r101, Continuation<? super h<? extends Object>> r102) {
        String r103 = r101.f472594a;
        IObricActionHandler<?, ?> r104 = this.f390440a.get(r103);
        if (r104 != null) goto L6;
        FLogger.f375446a.w("ObricActionExecutor", "execute: host " + r103 + " not support");
        return h.a.a(h.f390443d, "host " + r103 + " not support", 2);
    L6:
        String r105 = r101.f472595b;
        if (r105 != null) goto L10;
        r105 = "";
    L10:
        return b(r100, r104, r105, r102);
    }

    public final Object b(Context r100, IObricActionHandler<?, ?> r101, String r102, Continuation<? super h<? extends Object>> r110) {
        if ((r110 instanceof ObricActionExecutor$executeHandler$1) == false) goto L7;
        ObricActionExecutor$executeHandler$1 r103 = (ObricActionExecutor$executeHandler$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r107 = true;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L21
    L19:
        FLogger.f375446a.i("ObricActionExecutor", "executeHandler result: " + ((h) r111));     // Catch: Throwable -> L21
        Object r108 = Result.m9449constructorimpl((h) r111);     // Catch: Throwable -> L21
    L23:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        FLogger.f375446a.e("ObricActionExecutor", "execute action failed. " + r109.getMessage(), r109);
    L26:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r108);
        if (r112 == null) goto L42;
        h.a r113 = h.f390443d;
        String r114 = r112.getMessage();
        if (r114 != null) goto L33;
        r114 = "";
    L33:
        if (r114.length() == 0) goto L36;
        r107 = false;
    L36:
        if (r107 == false) goto L39;
        r114 = "execute action failed";
    L39:
        return h.a.a(r113, r114, 2);
    L42:
        return r108;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.obric.assistant.obric_action.IObricActionHandler<kotlin.Any?, kotlin.Any?>");     // Catch: Throwable -> L21
        Object r116 = r101.a(r100, r102);     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        r111 = r101.d(r100, r116, r103);     // Catch: Throwable -> L21
        if (r111 != r105) goto L19;
        return r105;
    L21:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new ObricActionExecutor$executeHandler$1(this, r110);
        goto L8
    }
}
