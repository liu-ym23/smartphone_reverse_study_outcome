package com.larus.uaigc.spring.utils;

import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.spring.utils.SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2", f = "SpringMainVenueAIVideoExt.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<com.larus.uaigc.api.a> $aiReplicaInfo;
    int label;

    public SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2(Ref.ObjectRef<com.larus.uaigc.api.a> r100, Continuation<? super SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2> r101) {
        this.$aiReplicaInfo = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2(this.$aiReplicaInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SpringMainVenueAIVideoExtKt$tryChangeToAvatarParam$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.larus.uaigc.api.a] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        Ref.ObjectRef<com.larus.uaigc.api.a> r103 = this.$aiReplicaInfo;
        DigitalAvatarInfoManager.f371542a.getClass();
        r103.element = DigitalAvatarInfoManager.f371550i;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DigitalAvatarInfoManager r104 = DigitalAvatarInfoManager.f371542a;
        this.label = 1;
        if (DigitalAvatarInfoManager.d(r104, this) != r101) goto L11;
        return r101;
    }
}
