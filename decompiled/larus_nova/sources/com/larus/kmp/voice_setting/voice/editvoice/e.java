package com.larus.kmp.voice_setting.voice.editvoice;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;

/* JADX INFO: loaded from: classes30.dex */
public final class e {
    public static final SpeakerVoice a(SpeakerVoice r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getConfStatus() != 2) goto L8;
        return null;
    L8:
        List<MixVoice> r101 = r100.getMixVoiceList();
        if (r101 != null) goto L11;
        return r100;
    L11:
        if (r101.isEmpty() == false) goto L14;
        return r100;
    L14:
        if (r101.size() == 1) goto L16;
        return r100;
    L16:
        if (((MixVoice) ListProtector.get(r101, 0)).isEnable() == false) goto L19;
        return ((MixVoice) ListProtector.get(r101, 0)).getVoiceItem();
    L19:
        return null;
    }
}
