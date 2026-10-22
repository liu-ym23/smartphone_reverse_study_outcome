package com.ss.android.lark.voiceinput.impl.service.repository;

import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientRequest;
import com.bytedance.lark.pb.voice.GetSpeechRecognitionPostProcessResultClientResponse;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;

/* JADX INFO: loaded from: classes38.dex */
public interface a {
    @SdkCall(40403)
    RucketJob<GetSpeechRecognitionPostProcessResultClientResponse> handleSpeechRecognitionResult(GetSpeechRecognitionPostProcessResultClientRequest r100);
}
