package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatResponse;
import com.bytedance.lark.pb.im.v1.GetAudioMessageRecognitionRequest;
import com.bytedance.lark.pb.im.v1.GetAudioMessageRecognitionResponse;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import com.bytedance.lark.pb.media.v1.AbortUploadAudioRequest;
import com.bytedance.lark.pb.media.v1.AbortUploadAudioResponse;
import com.bytedance.lark.pb.media.v1.GetUploadIdRequest;
import com.bytedance.lark.pb.media.v1.GetUploadIdResponse;
import com.bytedance.lark.pb.media.v1.UploadAudioDataRequest;
import com.bytedance.lark.pb.media.v1.UploadAudioDataResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1;
import com.ss.android.lark.passportc.dwarf.UserScope;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@UserScope
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f409421a;

    @Inject
    public d(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f409421a = r100;
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final boolean a(CheckChattersInChatRequest.Builder r110, final f r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, CheckChattersInChatResponse.ADAPTER, Command.CHECK_CHATTERS_IN_CHAT, null, null, null, null, 248);
        Boolean r112 = (Boolean) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f409421a.h(r100).execute(), new AudioRepositoryV2$syncCheckUserIsInChat$1(r111)), null);
        if (r112 != null) goto L5;
        return false;
    L5:
        return r112.booleanValue();
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final String b(GetUploadIdRequest.Builder r110, final g r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetUploadIdResponse.ADAPTER, Command.GET_UPLOAD_ID, null, null, null, null, 248);
        return (String) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.f409421a.h(r100).execute(), new AudioRepositoryV2$getAudioUploadId$1(r111)), null);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final void c(SendSpeechRecognitionRequest.Builder r110, IGetDataCallback<SendSpeechRecognitionResponse> r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, SendSpeechRecognitionResponse.ADAPTER, Command.SEND_SPEECH_RECOGNITION, null, null, null, null, 248);
        com.ss.android.lark.audio.voiceinput.utils.c.c(this.f409421a.h(r100).a(), r111);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final void d(UploadAudioDataRequest.Builder r110, IGetDataCallback<UploadAudioDataResponse> r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, UploadAudioDataResponse.ADAPTER, Command.SEND_AUDIO_DATA, null, null, null, null, 248);
        com.ss.android.lark.audio.voiceinput.utils.c.c(this.f409421a.h(r100).a(), r111);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final void e(GetAudioMessageRecognitionRequest.Builder r110, h r111, IGetDataCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, GetAudioMessageRecognitionResponse.ADAPTER, Command.GET_AUDIO_MESSAGE_RECOGNITION, null, null, null, null, 248);
        com.ss.android.lark.audio.voiceinput.utils.c.c(this.f409421a.h(r100).a().map(new c(r111)), r112);
    }

    @Override // com.ss.android.lark.audio.voiceinput.service.k
    public final void f(AbortUploadAudioRequest.Builder r110, e r111, VoiceUtils$abortUploadAudio$1 r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        com.bytedance.lark.rustclient.api.d r100 = new com.bytedance.lark.rustclient.api.d(r110, AbortUploadAudioResponse.ADAPTER, Command.ABORT_UPLOAD_AUDIO, null, null, null, null, 248);
        com.ss.android.lark.audio.voiceinput.utils.c.c(this.f409421a.h(r100).a().map(new b(r111)), r112);
    }
}
