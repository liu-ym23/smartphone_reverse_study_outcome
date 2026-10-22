package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes30.dex */
public interface m6 {
    boolean a();

    boolean b(SpeakerVoice r100);

    p6 c(com.larus.kmp.voice_setting.voice.component.v4 r100);

    void d(SpeakerVoice r100, com.larus.kmp.voice_setting.voice.editvoice.f r101, String r102, b7 r103, c7 r104, d7 r105);

    void e(com.larus.kmp.voice_setting.platform.l0 r100, y6 r101, z6 r102, a7 r103);

    Object f(n6 r100, Continuation<? super o6> r101);

    boolean g();

    void h(com.larus.kmp.voice_setting.voice.component.v4 r100, SpeakerVoice r101, boolean r102);

    void i();

    void j(com.larus.kmp.voice_setting.voice.component.v4 r100);

    int k();

    void showToast(String r100);

    void stopAudio();
}
