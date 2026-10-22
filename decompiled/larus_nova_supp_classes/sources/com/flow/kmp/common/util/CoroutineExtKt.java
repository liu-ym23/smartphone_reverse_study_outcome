package com.flow.kmp.common.util;

import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class CoroutineExtKt {
    public static final Lazy a = null;
    public static final Lazy b = null;

    static {
        a = LazyKt.lazy(new c());
        b = LazyKt.lazy(new d());
    }

    public static final Job a(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        return BuildersKt.launch$default((CoroutineScope) a.getValue(), null, null, r7, 3, null);
    }

    public static final void b(Function2 r7) {
        Intrinsics.checkNotNullParameter(r7, "block");
        BuildersKt.launch$default((CoroutineScope) b.getValue(), null, null, r7, 3, null);
    }

    public static final void c(i r1, Message r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isActive() == true) goto L5;
        return;
    L5:
        r1.resumeWith(Result.m49constructorimpl(r2));
    }

    public static final <R> Object d(long r6, Function3<? super Throwable, ? super Job, ? super Continuation<? super R>, ? extends Object> r8, Function1<? super i<? super R>, Unit> r9, Continuation<? super R> r10) {
        if ((r10 instanceof waitOrTimeout.1) == false) goto L7;
        waitOrTimeout.1 r0 = (waitOrTimeout.1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L26:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (Function3) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L22
    L27:
        goto L26
    L18:
        ResultKt.throwOnFailure(r11);
        waitOrTimeout.2 r12 = new waitOrTimeout.2(r9, null);     // Catch: Throwable -> L22
        r0.L$0 = r8;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r11 = TimeoutKt.b(r6, r12, r0);     // Catch: Throwable -> L22
        if (r11 != r2) goto L27;
        return r2;
    L22:
        th = move-exception;
        CoroutineContext.Element r7 = r0.getContext().get(Job.Key);
        r0.L$0 = null;
        r0.label = 2;
        r11 = r8.invoke(th, r7, r0);
        if (r11 != r2) goto L26;
        return r2;
    L7:
        r0 = new waitOrTimeout.1(r10);
        goto L8
    }
}
