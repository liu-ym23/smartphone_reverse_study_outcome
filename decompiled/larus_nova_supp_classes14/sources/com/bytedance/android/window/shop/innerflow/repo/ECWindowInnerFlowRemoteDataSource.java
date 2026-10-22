package com.bytedance.android.window.shop.innerflow.repo;

import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowCartInfoDTO;
import com.bytedance.android.window.shop.innerflow.entity.dto.ECShopInnerFlowDTO;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECWindowInnerFlowRemoteDataSource {
    public ECWindowInnerFlowRemoteDataSource() {
    }

    public final Object b(Continuation<? super ECShopInnerFlowCartInfoDTO> r6) {
        if ((r6 instanceof ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1) == false) goto L7;
        ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1 r0 = (ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L14;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L25
    L21:
        ECShopInnerFlowCartInfoDTO r8 = (ECShopInnerFlowCartInfoDTO) r7;     // Catch: Throwable -> L25
    L23:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r9) == false) goto L31;
        return null;
    L31:
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L25
        ECWindowInnerFlowApi.a.getClass();     // Catch: Throwable -> L25
        ECWindowInnerFlowApi r11 = ECWindowInnerFlowApi.a.a;     // Catch: Throwable -> L25
        if (r11 == null) goto L22;
        r0.label = 1;     // Catch: Throwable -> L25
        r7 = r11.getInnerFlowCartInfo(r0);     // Catch: Throwable -> L25
        if (r7 != r2) goto L21;
        return r2;
    L22:
        r8 = null;
    L25:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ECWindowInnerFlowRemoteDataSource$getShopCartInfo$1(this, r6);
        goto L8
    }

    public final Object a(ECWindowInnerFlowReqParam r18, Continuation<? super ECShopInnerFlowDTO> r19) {
        if ((r19 instanceof ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1) == false) goto L7;
        ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1 r1 = (ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1) r19;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1 r15 = r1;
        Object r0 = r15.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r15.label;
        if (r4 == 0) goto L15;
        if (r4 != 1) goto L14;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L25
    L21:
        ECShopInnerFlowDTO r5 = (ECShopInnerFlowDTO) r0;     // Catch: Throwable -> L25
    L23:
        Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r6) == false) goto L31;
        return null;
    L31:
        return r6;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r0);
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L25
        ECWindowInnerFlowApi.a.getClass();     // Catch: Throwable -> L25
        ECWindowInnerFlowApi r8 = ECWindowInnerFlowApi.a.a;     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
        String r9 = r18.getSecAuthorId();     // Catch: Throwable -> L25
        int r10 = r18.getInnerFlowType();     // Catch: Throwable -> L25
        String r11 = r18.getCustomId();     // Catch: Throwable -> L25
        String r12 = r18.getPromotionId();     // Catch: Throwable -> L25
        String r13 = r18.getFilterPromotionIds().toString();     // Catch: Throwable -> L25
        long r14 = r18.getPageNum();     // Catch: Throwable -> L25
        Integer r16 = Boxing.boxInt(r18.getPageSize());     // Catch: Throwable -> L25
        String r17 = r18.getPassThroughApi();     // Catch: Throwable -> L25
        r15.label = 1;     // Catch: Throwable -> L25
        r0 = r8.getInnerFlowData(r9, r10, r11, r12, r13, r14, r16, r17, null, null, r15);     // Catch: Throwable -> L25
        if (r0 != r3) goto L21;
        return r3;
    L22:
        r5 = null;
    L25:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r1 = new ECWindowInnerFlowRemoteDataSource$getInnerFlowData$1(this, r19);
        goto L8
    }
}
