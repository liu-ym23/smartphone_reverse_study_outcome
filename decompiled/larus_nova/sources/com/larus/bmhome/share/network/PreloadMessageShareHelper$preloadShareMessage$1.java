package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.PreloadMessageShareHelper$preloadShareMessage$1", f = "PreloadMessageShareHelper.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadMessageShareHelper$preloadShareMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f $request;
    int label;
    final /* synthetic */ PreloadMessageShareHelper this$0;

    public PreloadMessageShareHelper$preloadShareMessage$1(f r100, PreloadMessageShareHelper r101, Continuation<? super PreloadMessageShareHelper$preloadShareMessage$1> r102) {
        this.$request = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PreloadMessageShareHelper$preloadShareMessage$1(this.$request, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PreloadMessageShareHelper$preloadShareMessage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        dm9.a r103 = (dm9.a) r100;
        BizResponse<SaveMessageShareInfo> r104 = 0;
        if ((r103 instanceof dm9.a.b) == false) goto L18;
        PreloadMessageShareHelper r105 = this.this$0;
        dm9.a.b r106 = (dm9.a.b) r103;
        if (r106.f469231a.isSuccess() == false) goto L16;
        r104 = r106.f469231a;
    L16:
        r105.f313835a = r104;
    L21:
        return Unit.INSTANCE;
    L18:
        if ((r103 instanceof dm9.a.C5690a) == false) goto L21;
        this.this$0.f313835a = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MessageShareApi.Companion r107 = MessageShareApi.f313833a;
        f r108 = this.$request;
        this.label = 1;
        r107.getClass();
        r100 = MessageShareApi.Companion.a(r108, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
