package com.larus.voice_setting.voice;

import com.larus.network.bean.BizResponse;
import com.larus.voice_setting.voice.dialog.v2.api.VoiceMaterialApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialResponse;", "Lcom/larus/voice_setting/voice/dialog/v2/api/VoiceMaterialApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1", f = "TtsSpeakerSettingViewModel.kt", i = {}, l = {611}, m = "invokeSuspend", n = {}, s = {})
public final class TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1 extends SuspendLambda implements Function2<VoiceMaterialApi, Continuation<? super BizResponse<s2a.a>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1(Continuation<? super TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1 r102 = new TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(VoiceMaterialApi r100, Continuation<? super BizResponse<s2a.a>> r101) {
        return ((TtsSpeakerSettingViewModel$tryRequestVoiceMaterial$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(VoiceMaterialApi r100, Continuation<? super BizResponse<s2a.a>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        VoiceMaterialApi r103 = (VoiceMaterialApi) this.L$0;
        this.label = 1;
        r100 = r103.userVoiceMaterial(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
