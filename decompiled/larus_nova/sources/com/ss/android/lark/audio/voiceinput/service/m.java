package com.ss.android.lark.audio.voiceinput.service;

import com.bytedance.lark.pb.im.v1.SendSpeechRecognitionResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public interface m {
    void a();

    void b(Function1<? super SendSpeechRecognitionResponse, Unit> r100, Function1<? super Throwable, Unit> r101);
}
