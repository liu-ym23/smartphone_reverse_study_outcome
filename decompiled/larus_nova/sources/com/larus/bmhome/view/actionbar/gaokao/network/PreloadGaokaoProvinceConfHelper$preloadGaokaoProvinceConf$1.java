package com.larus.bmhome.view.actionbar.gaokao.network;

import com.larus.network.bean.BizResponse;
import dm9.a;
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
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.network.PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1", f = "PreloadGaokaoProvinceConfHelper.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(Continuation<? super PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        BizResponse<GaokaoProvinceConfResponse> r103 = 0;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        a r104 = (a) r100;
        if ((r104 instanceof a.b) == false) goto L18;
        PreloadGaokaoProvinceConfHelper r105 = PreloadGaokaoProvinceConfHelper.f316793a;
        a.b r106 = (a.b) r104;
        if (r106.f469231a.isSuccess() == false) goto L16;
        r103 = r106.f469231a;
    L16:
        PreloadGaokaoProvinceConfHelper.f316794b = r103;
    L21:
        return Unit.INSTANCE;
    L18:
        if ((r104 instanceof a.C5690a) == false) goto L21;
        PreloadGaokaoProvinceConfHelper.f316794b = null;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        GaokaoApi.a r107 = GaokaoApi.f316791a;
        PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1$result$1 r108 = new PreloadGaokaoProvinceConfHelper$preloadGaokaoProvinceConf$1$result$1(null);
        this.label = 1;
        r107.getClass();
        r100 = GaokaoApi.a.a(r108, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
