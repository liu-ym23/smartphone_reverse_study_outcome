package com.larus.im.internal.utils;

import com.ss.bytertc.engine.data.AudioChannel;
import com.ss.bytertc.engine.data.AudioSampleRate;

/* JADX INFO: loaded from: classes30.dex */
public final class d {
    public static final AudioChannel a(int r100) {
        AudioChannel r101 = AudioChannel.fromId(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new RuntimeException("invalid channel vale = " + r100);
    }

    public static final AudioSampleRate b(int r100) {
        AudioSampleRate r101 = AudioSampleRate.fromId(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new RuntimeException("invalid sample rate vale = " + r100);
    }
}
