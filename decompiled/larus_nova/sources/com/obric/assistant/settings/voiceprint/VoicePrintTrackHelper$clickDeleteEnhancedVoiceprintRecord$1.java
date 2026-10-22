package com.obric.assistant.settings.voiceprint;

import com.larus.applog.api.IApplog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.voiceprint.VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1", f = "VoicePrintTrackHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardContentType;
    final /* synthetic */ String $cardType;
    int label;

    public VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1(String r100, String r101, Continuation<? super VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1> r102) {
        this.$cardType = r100;
        this.$cardContentType = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1(this.$cardType, this.$cardContentType, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoicePrintTrackHelper$clickDeleteEnhancedVoiceprintRecord$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        JSONObject r101 = new JSONObject();
        String r102 = this.$cardType;
        String r103 = this.$cardContentType;
        r101.put("action_type", "click_delete_enhanced_voiceprint_record");
        r101.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, r102);
        if (r103 == null) goto L7;
        r101.put("card_content_type", r103);
    L7:
        IApplog.f287053a.reportEvent("dora_card_click", r101);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
