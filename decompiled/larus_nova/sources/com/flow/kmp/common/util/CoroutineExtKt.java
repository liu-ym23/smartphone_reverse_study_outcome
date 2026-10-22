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

/* JADX INFO: loaded from: classes.dex */
public final class CoroutineExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f274143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f274144b = null;

    static {
        f274143a = LazyKt.lazy(new c());
        f274144b = LazyKt.lazy(new d());
    }

    public static final Job a(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return BuildersKt.launch$default((CoroutineScope) f274143a.getValue(), null, null, r100, 3, null);
    }

    public static final void b(Function2 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default((CoroutineScope) f274144b.getValue(), null, null, r100, 3, null);
    }

    public static final void c(kotlinx.coroutines.i r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.isActive() == true) goto L5;
        return;
    L5:
        r100.resumeWith(Result.m9449constructorimpl(r101));
    }

    public static final <R> Object d(long r100, Function3<? super Throwable, ? super Job, ? super Continuation<? super R>, ? extends Object> r101, Function1<? super kotlinx.coroutines.i<? super R>, Unit> r102, Continuation<? super R> r110) {
        if ((r110 instanceof CoroutineExtKt$waitOrTimeout$1) == false) goto L7;
        CoroutineExtKt$waitOrTimeout$1 r103 = (CoroutineExtKt$waitOrTimeout$1) r110;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r111 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L26:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function3) r103.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L22
    L27:
        goto L26
    L18:
        ResultKt.throwOnFailure(r111);
        CoroutineExtKt$waitOrTimeout$2 r112 = new CoroutineExtKt$waitOrTimeout$2(r102, null);     // Catch: Throwable -> L22
        r103.L$0 = r101;     // Catch: Throwable -> L22
        r103.label = 1;     // Catch: Throwable -> L22
        r111 = TimeoutKt.b(r100, r112, r103);     // Catch: Throwable -> L22
        if (r111 != r105) goto L27;
        return r105;
    L22:
        th = move-exception;
        CoroutineContext.Element r107 = r103.getContext().get(Job.Key);
        r103.L$0 = null;
        r103.label = 2;
        r111 = r101.invoke(th, r107, r103);
        if (r111 != r105) goto L26;
        return r105;
    L7:
        r103 = new CoroutineExtKt$waitOrTimeout$1(r110);
        goto L8
    }
}
