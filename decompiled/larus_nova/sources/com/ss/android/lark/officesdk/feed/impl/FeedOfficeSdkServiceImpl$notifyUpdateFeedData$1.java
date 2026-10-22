package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.office_sdk_im_android.OfficeSdkIm;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.feed.impl.FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1", f = "FeedOfficeSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $request;
    final /* synthetic */ long $sdkSession;
    final /* synthetic */ long $uid;
    int label;

    public FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(long r100, long r101, byte[] r102, Continuation<? super FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1> r103) {
        this.$uid = r100;
        this.$sdkSession = r101;
        this.$request = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(this.$uid, this.$sdkSession, this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        OfficeSdkIm r101 = OfficeSdkIm.Companion.m8443newPWzV0Is(this.$uid, this.$sdkSession);
        byte[] r102 = this.$request;
        Intrinsics.checkNotNull(r102);
        r101.updateFeed(r102);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
