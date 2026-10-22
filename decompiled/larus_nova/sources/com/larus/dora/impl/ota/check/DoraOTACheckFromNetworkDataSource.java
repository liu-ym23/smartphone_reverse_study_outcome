package com.larus.dora.impl.ota.check;

import com.larus.dora.impl.ota.DoraOTARequest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DoraOTACheckFromNetworkDataSource implements d {
    public DoraOTACheckFromNetworkDataSource() {
    }

    @Override // com.larus.dora.impl.ota.check.d
    public final Object a(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, Continuation<? super Result<e49.a>> r212) {
        if ((r212 instanceof DoraOTACheckFromNetworkDataSource$checkUpdate$1) == false) goto L7;
        DoraOTACheckFromNetworkDataSource$checkUpdate$1 r100 = (DoraOTACheckFromNetworkDataSource$checkUpdate$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        DoraOTACheckFromNetworkDataSource$checkUpdate$1 r116 = r100;
        Object r102 = r116.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r116.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        return ((Result) r102).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        DoraOTARequest r105 = DoraOTARequest.f337377a;
        r116.label = 1;
        Object r106 = r105.a(r110, r111, r112, r113, r114, r115, r210, r211, r116);
        if (r106 != r103) goto L18;
        return r103;
    L18:
        return r106;
    L7:
        r100 = new DoraOTACheckFromNetworkDataSource$checkUpdate$1(this, r212);
        goto L8
    }
}
