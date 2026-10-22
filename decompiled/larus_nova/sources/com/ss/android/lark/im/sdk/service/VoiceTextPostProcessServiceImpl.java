package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientRequest;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientResponse;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceTextPostProcessServiceImpl implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f426059a;

    public static final class a {
    }

    static {
    }

    @Inject
    public VoiceTextPostProcessServiceImpl(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f426059a = r100;
    }

    @Override // com.ss.android.lark.im.sdk.service.e
    public final RichText a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r111, "recognitionText");
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        long r102 = CastLongProtector.parseLong(r110);     // Catch: Throwable -> L5
        com.bytedance.lark.rustclient.api.d r112 = new com.bytedance.lark.rustclient.api.d(new GetSpeechRecognitionPostProcessResultClientRequest.Builder().context_id(String.valueOf(r102)).recognition_text(r111).scene(GetSpeechRecognitionPostProcessResultClientRequest.Scene.DOUBAO_IM), GetSpeechRecognitionPostProcessResultClientResponse.ADAPTER, Command.GET_SPEECH_RECOGNITION_POSTPROCESS_RESULT, null, null, null, null, 248);     // Catch: Throwable -> L5
        Object r113 = Result.m9449constructorimpl((RichText) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f426059a.h(r112).execute(), VoiceTextPostProcessServiceImpl$postProcess$1$1.INSTANCE), null));     // Catch: Throwable -> L5
    L7:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L11;
        Log.e("VoiceTextPostProcessService", "postProcess failed", r114);
    L11:
        if (Result.m9455isFailureimpl(r113) == true) goto L15;
        r100 = r113;
    L15:
        return (RichText) r100;
    L5:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
