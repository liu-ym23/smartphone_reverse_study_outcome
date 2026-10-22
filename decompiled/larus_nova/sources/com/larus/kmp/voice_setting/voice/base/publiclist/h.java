package com.larus.kmp.voice_setting.voice.base.publiclist;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class h<T> implements Comparator {
    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        SpeakerVoice r102 = ((hh9.a) r101).f485236a;
        long r103 = 0;
        if (r102 == null) goto L5;
        long r104 = r102.getCreateTime();
    L6:
        Long r105 = Long.valueOf(r104);
        SpeakerVoice r106 = ((hh9.a) r100).f485236a;
        if (r106 == null) goto L10;
        r103 = r106.getCreateTime();
    L10:
        return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
    L5:
        r104 = 0;
        goto L6
    }
}
