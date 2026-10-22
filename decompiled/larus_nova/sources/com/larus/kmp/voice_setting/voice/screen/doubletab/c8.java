package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;

/* JADX INFO: loaded from: classes30.dex */
public final class c8 {
    public static final com.larus.kmp.voice_setting.voice.editvoice.f a(SpeakerVoice r100) {
        int r101 = com.larus.kmp.voice_setting.voice.editvoice.g.f353259a;
        Float r102 = null;
        if (r100 == null) goto L5;
        Float r103 = Float.valueOf(r100.getPitchF64());
    L6:
        if (r100 == null) goto L8;
        r102 = Float.valueOf(r100.getSpeechRateF64());
    L8:
        com.larus.kmp.voice_setting.voice.editvoice.f r104 = com.larus.kmp.voice_setting.voice.editvoice.g.b(r103, r102);
        if (r104 == null) goto L11;
        return r104;
    L11:
        return new com.larus.kmp.voice_setting.voice.editvoice.f(0);
    L5:
        r103 = null;
        goto L6
    }
}
