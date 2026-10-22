package com.ss.android.lark.framework.assembly.rust.bridge;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.framework.assembly.rust.bridge.OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1", f = "OfficeSdkFeedCardProviderImpl.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ byte[] $payload;
    int label;
    final /* synthetic */ OfficeSdkFeedCardProviderImpl this$0;

    public OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(OfficeSdkFeedCardProviderImpl r100, byte[] r101, Continuation<? super OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1> r102) {
        this.this$0 = r100;
        this.$payload = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1(this.this$0, this.$payload, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super byte[]> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super byte[]> r101) {
        return ((OfficeSdkFeedCardProviderImpl$packFeedPreview$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return (byte[]) r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        OfficeSdkFeedCardProviderImpl r103 = this.this$0;
        int r104 = OfficeSdkFeedCardProviderImpl.f425688b;
        qtb.b r105 = r103.b();
        if (r105 == null) goto L14;
        byte[] r106 = this.$payload;
        this.label = 1;
        r100 = r105.g0(r106, this);
        if (r100 != r101) goto L16;
        return r101;
    L14:
        return null;
    }
}
