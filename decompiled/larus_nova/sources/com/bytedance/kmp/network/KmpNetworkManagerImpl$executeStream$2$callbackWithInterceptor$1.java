package com.bytedance.kmp.network;

import com.bytedance.kmp.network.response.i;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1 implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f252472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KmpNetworkManagerImpl f252473b;

    public KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1(i r100, KmpNetworkManagerImpl r101) {
        this.f252472a = r100;
        this.f252473b = r101;
    }

    @Override // com.bytedance.kmp.network.response.i
    public final Object a(com.bytedance.kmp.network.response.d r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1) == false) goto L7;
        KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1 r102 = (KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1) r101;
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
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
    L19:
        i r107 = this.f252472a;
        r102.label = 2;
        if (r107.a((com.bytedance.kmp.network.response.d) r104, r102) != r105) goto L23;
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        KmpNetworkManagerImpl r108 = this.f252473b;
        r102.label = 1;
        r104 = r108.b(r100, r102);
        if (r104 != r105) goto L19;
        return r105;
    L7:
        r102 = new KmpNetworkManagerImpl$executeStream$2$callbackWithInterceptor$1$onResponseStart$1(this, r101);
        goto L8
    }
}
