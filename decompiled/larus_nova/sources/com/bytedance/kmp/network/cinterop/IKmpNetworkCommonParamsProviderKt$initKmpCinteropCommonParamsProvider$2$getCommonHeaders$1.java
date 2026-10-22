package com.bytedance.kmp.network.cinterop;

import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1", f = "IKmpNetworkCommonParamsProvider.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
final class IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ jd6.c $request;
    int label;

    public IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1(jd6.c r100, Continuation<? super IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1(this.$request, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Map<String, ? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Map<String, String>> r101) {
        return ((IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L13:
        Map r103 = (Map) r100;
        if (r103 == null) goto L16;
        return r103;
    L16:
        return MapsKt.emptyMap();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        pd6.b r104 = pd6.c.f528682a;
        b r105 = (b) pd6.c.a(Reflection.getOrCreateKotlinClass(b.class));
        if (r105 == null) goto L16;
        String r106 = this.$request.f498624a;
        this.label = 1;
        r100 = r105.q();
        if (r100 != r101) goto L13;
        return r101;
    }
}
