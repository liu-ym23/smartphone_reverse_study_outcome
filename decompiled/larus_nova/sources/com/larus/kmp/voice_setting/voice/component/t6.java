package com.larus.kmp.voice_setting.voice.component;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class t6<T> implements Comparator {
    public t6() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        return ComparisonsKt.compareValues(Long.valueOf(((SpeakerVoice) r101).getCreateTime()), Long.valueOf(((SpeakerVoice) r100).getCreateTime()));
    }
}
