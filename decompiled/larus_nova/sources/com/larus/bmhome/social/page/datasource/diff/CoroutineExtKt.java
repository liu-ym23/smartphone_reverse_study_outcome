package com.larus.bmhome.social.page.datasource.diff;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public final class CoroutineExtKt {
    public static final Object a(CoroutineContext r100, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Job> r102) {
        if ((r102 instanceof CoroutineExtKt$launchChild$1) == false) goto L7;
        CoroutineExtKt$launchChild$1 r103 = (CoroutineExtKt$launchChild$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        return r108.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        Ref.ObjectRef r109 = new Ref.ObjectRef();
        CoroutineExtKt$launchChild$2 r110 = new CoroutineExtKt$launchChild$2(r109, r100, r101, null);
        r103.L$0 = r109;
        r103.label = 1;
        if (CoroutineScopeKt.coroutineScope(r110, r103) != r106) goto L17;
        return r106;
    L17:
        r108 = r109;
    L7:
        r103 = new CoroutineExtKt$launchChild$1(r102);
        goto L8
    }
}
