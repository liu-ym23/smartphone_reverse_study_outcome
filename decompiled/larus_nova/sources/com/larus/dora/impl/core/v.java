package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.feature.DoraFeature;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f332284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f332285b = null;

    public v() {
    }

    static {
        f332284a = new v();
        f332285b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public static final Object a(v r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1) == false) goto L7;
        DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1 r102 = (DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L19
    L37:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        DoraFeature r108 = DoraFeature.f335550a;     // Catch: Throwable -> L19
        r102.label = 1;     // Catch: Throwable -> L19
        if (r108.b(r102) != r105) goto L37;
        return r105;
    L20:
        DoraDevice r109 = DoraAdapterExtKt.h(kj4.a.g());
        if (r109 != null) goto L24;
        return Unit.INSTANCE;
    L24:
        if (o59.a.q(r109) == false) goto L36;
        sk4.e r110 = o0.f332223a;
        if (o0.c("natural_wakup") == false) goto L36;
        if (o0.b(r109) == true) goto L33;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        if (com.larus.dora.impl.util.b0.w() == false) goto L33;
    L34:
        g49.d.d("DoraConnectionInitializer", "sync quick continuous conversation switch on connect, isOpen=" + r107 + ", ret=" + kj4.a.g().v(r107));
        return Unit.INSTANCE;
    L33:
        r107 = false;
    L36:
        return Unit.INSTANCE;
    L7:
        r102 = new DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1(r100, r101);
        goto L8
    }
}
