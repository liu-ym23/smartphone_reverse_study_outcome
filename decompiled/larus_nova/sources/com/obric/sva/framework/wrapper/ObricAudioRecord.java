package com.obric.sva.framework.wrapper;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRecord;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class ObricAudioRecord extends AudioRecord {
    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return AudioRecord.class;
    }

    public ObricAudioRecord(AudioAttributes r100, AudioFormat r101, int r102, int r103) throws IllegalArgumentException {
        super(r100, r101, r102, r103);
    }
}
