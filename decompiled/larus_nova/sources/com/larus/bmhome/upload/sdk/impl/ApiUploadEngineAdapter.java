package com.larus.bmhome.upload.sdk.impl;

import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.monitor.cloudmessage.consts.CloudControlInf;
import hs8.e;
import hs8.g;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class ApiUploadEngineAdapter implements com.larus.bmhome.upload.sdk.impl.engine.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f314843a;

    public ApiUploadEngineAdapter(ResourceUploadEngine r100) {
        Intrinsics.checkNotNullParameter(r100, "engine");
        this.f314843a = r100;
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final boolean a(is8.a r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return this.f314843a.a(r100);
    }

    @Override // com.larus.bmhome.upload.sdk.impl.engine.c
    public final Object b(String r100, is8.g r110, is8.a r111, js8.b r112, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> r113, Continuation<? super com.larus.bmhome.upload.sdk.impl.engine.b> r114) {
        if ((r114 instanceof ApiUploadEngineAdapter$upload$1) == false) goto L7;
        ApiUploadEngineAdapter$upload$1 r101 = (ApiUploadEngineAdapter$upload$1) r114;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ApiUploadEngineAdapter$upload$1 r103 = r101;
        Object r115 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L17:
        hs8.a r116 = (hs8.a) r115;
        return new com.larus.bmhome.upload.sdk.impl.engine.b(r116.f487071a, r116.f487072b);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        g r106 = this.f314843a;
        e r107 = new e(r112.f500233a, r112.f500234b);
        r103.label = 1;
        r115 = r106.b(r100, r110, r111, r107, r113, r103);
        if (r115 != r104) goto L17;
        return r104;
    L7:
        r101 = new ApiUploadEngineAdapter$upload$1(this, r114);
        goto L8
    }
}
