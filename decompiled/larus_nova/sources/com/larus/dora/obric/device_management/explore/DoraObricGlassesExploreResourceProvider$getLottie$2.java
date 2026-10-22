package com.larus.dora.obric.device_management.explore;

import com.larus.dora.impl.util.DoraResourceUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/obric/device_management/explore/DoraObricGlassesLottieResource;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesExploreResourceProvider$getLottie$2", f = "DoraObricGlassesExploreResourceProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGlassesExploreResourceProvider$getLottie$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b1>, Object> {
    final /* synthetic */ c1 $spec;
    int label;

    public DoraObricGlassesExploreResourceProvider$getLottie$2(c1 r100, Continuation<? super DoraObricGlassesExploreResourceProvider$getLottie$2> r101) {
        this.$spec = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraObricGlassesExploreResourceProvider$getLottie$2(this.$spec, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super b1> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super b1> r101) {
        return ((DoraObricGlassesExploreResourceProvider$getLottie$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r100);
        String r101 = this.$spec.f339510a;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) == true) goto L9;
        r101 = null;
    L9:
        if (r101 != null) goto L11;
    L14:
        boolean r103 = true;
    L16:
        if (r103 == false) goto L19;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "lottie resourceName is empty");
        return null;
    L19:
        String r104 = DoraResourceUtil.f(r101);
        if ((!StringsKt.isBlank(r104)) == true) goto L23;
        r104 = null;
    L23:
        if (r104 != null) goto L25;
    L28:
        if (r102 == false) goto L32;
        g49.d.e("DoraObricGlassesExploreResourceProvider", "resolve lottie failed: resourceName=" + this.$spec.f339510a);
        return null;
    L32:
        return new b1(r104);
    L25:
        if (StringsKt.isBlank(r104) == true) goto L28;
        r102 = false;
        goto L28
    L11:
        if (StringsKt.isBlank(r101) == true) goto L14;
        r103 = false;
        goto L16
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
