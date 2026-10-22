package com.larus.dora.impl.serviceimpl;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.util.b0;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: classes4.dex */
public final class NetworkService {
    public NetworkService() {
    }

    public final Object b(Continuation<? super Result<a49.h>> r100) {
        if ((r100 instanceof NetworkService$fetchLatestDiaryCardContent$1) == false) goto L7;
        NetworkService$fetchLatestDiaryCardContent$1 r101 = (NetworkService$fetchLatestDiaryCardContent$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
        return ((Result) r103).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        DoraAdapterExtKt.k(kj4.a.g()).isEmpty();
        DoraDevice r106 = DoraAdapterExtKt.h(kj4.a.g());
        b0.f338123a.getClass();
        DoraSimpleDevice r107 = b0.k();
        String r108 = null;
        if (r106 == null) goto L19;
        String r109 = o59.a.A(r106.getSerialNumber(), r106.f204389mac, Boxing.boxInt(r106.productId));
        if (r109 == null) goto L22;
    L24:
        if (r106 == null) goto L26;
        r108 = String.valueOf(r106.productId);
    L28:
        if (r109 == null) goto L34;
        if (r108 == null) goto L34;
        List<String> r110 = CollectionsKt.listOf("diary");
        DoraNetworkApi r111 = DoraNetworkApi.f336157a;
        r101.label = 1;
        Object r112 = r111.k(r109, r108, r110, r101);
        if (r112 != r104) goto L36;
        return r104;
    L36:
        return r112;
    L34:
        Result.Companion r113 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new Throwable("no content")));
    L26:
        if (r107 == null) goto L28;
        r108 = Boxing.boxInt(r107.getType()).toString();
    L22:
        r109 = "";
        goto L24
    L19:
        if (r107 == null) goto L23;
        r109 = o59.a.A(r107.getSerialNumber(), r107.getMac(), Boxing.boxInt(r107.getType()));
        if (r109 != null) goto L24;
    L23:
        r109 = null;
    L7:
        r101 = new NetworkService$fetchLatestDiaryCardContent$1(this, r100);
        goto L8
    }

    public final Object a(List<String> r100, Continuation<? super Result<a49.c>> r101) {
        if ((r101 instanceof NetworkService$fetchDiaryBetaLatestCard$1) == false) goto L7;
        NetworkService$fetchDiaryBetaLatestCard$1 r102 = (NetworkService$fetchDiaryBetaLatestCard$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        return ((Result) r104).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        DoraDevice r107 = DoraAdapterExtKt.h(kj4.a.g());
        Integer r108 = null;
        if (r107 == null) goto L17;
        int r109 = r107.productId;
    L20:
        Integer r110 = Boxing.boxInt(r109);
    L22:
        FlowDoraSubBizType.Companion.getClass();
        Integer r111 = Boxing.boxInt(FlowDoraSubBizType.a.b(r110));
        if (r111.intValue() <= 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L28;
        r108 = r111;
    L28:
        if (r108 == null) goto L30;
        int r113 = r108.intValue();
    L31:
        DoraNetworkApi r114 = DoraNetworkApi.f336157a;
        r102.label = 1;
        Object r115 = r114.j(r113, r100, r102);
        if (r115 != r105) goto L35;
        return r105;
    L35:
        return r115;
    L30:
        r113 = FlowDoraSubBizType.G1_G2.getValue();
        goto L31
    L25:
        r112 = false;
        goto L26
    L17:
        b0.f338123a.getClass();
        DoraSimpleDevice r116 = b0.k();
        if (r116 == null) goto L21;
        r109 = r116.getType();
        goto L20
    L21:
        r110 = null;
    L7:
        r102 = new NetworkService$fetchDiaryBetaLatestCard$1(this, r101);
        goto L8
    }
}
