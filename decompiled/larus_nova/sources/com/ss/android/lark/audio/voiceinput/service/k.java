package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.GetAudioMessageRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionRequest;
import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import com.bytedance.lark.pb.media.v1.AbortUploadAudioRequest;
import com.bytedance.lark.pb.media.v1.GetUploadIdRequest;
import com.bytedance.lark.pb.media.v1.UploadAudioDataRequest;
import com.bytedance.lark.pb.media.v1.UploadAudioDataResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.audio.voiceinput.utils.VoiceUtils$abortUploadAudio$1;

/* JADX INFO: loaded from: classes34.dex */
public interface k {
    boolean a(CheckChattersInChatRequest.Builder r100, f r101);

    String b(GetUploadIdRequest.Builder r100, g r101);

    void c(SendSpeechRecognitionRequest.Builder r100, IGetDataCallback<SendSpeechRecognitionResponse> r101);

    void d(UploadAudioDataRequest.Builder r100, IGetDataCallback<UploadAudioDataResponse> r101);

    void e(GetAudioMessageRecognitionRequest.Builder r100, h r101, IGetDataCallback r102);

    void f(AbortUploadAudioRequest.Builder r100, e r101, VoiceUtils$abortUploadAudio$1 r102);
}
