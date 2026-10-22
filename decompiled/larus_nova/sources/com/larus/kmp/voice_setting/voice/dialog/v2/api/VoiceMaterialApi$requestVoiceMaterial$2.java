package com.larus.kmp.voice_setting.voice.dialog.v2.api;

import com.larus.im.FlowRuntime;
import gd9.t;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/kmp/voice_setting/voice/network/BizResponse;", "Lcom/larus/kmp/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.kmp.voice_setting.voice.dialog.v2.api.VoiceMaterialApi$requestVoiceMaterial$2", f = "VoiceMaterialApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMaterialApi$requestVoiceMaterial$2 extends SuspendLambda implements Function1<Continuation<? super com.larus.kmp.voice_setting.voice.network.a<d>>, Object> {
    int label;

    public VoiceMaterialApi$requestVoiceMaterial$2(Continuation<? super VoiceMaterialApi$requestVoiceMaterial$2> r100) {
        super(1, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new VoiceMaterialApi$requestVoiceMaterial$2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super com.larus.kmp.voice_setting.voice.network.a<d>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super com.larus.kmp.voice_setting.voice.network.a<d>> r100) {
        return ((VoiceMaterialApi$requestVoiceMaterial$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return com.larus.kmp.voice_setting.voice.network.c.a(t.a.a(FlowRuntime.b().c().h(), "/alice/user_voice/material", MapsKt.emptyMap(), null, null, 28), d.Companion.serializer());
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
