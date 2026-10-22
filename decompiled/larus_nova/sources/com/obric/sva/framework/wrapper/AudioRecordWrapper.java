package com.obric.sva.framework.wrapper;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRecord;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes34.dex */
public class AudioRecordWrapper {
    private AudioRecord mAudioRecord;

    @JvmStatic
    public static Class<?> getWrapperClazz() {
        return AudioRecord.class;
    }

    public AudioRecord getAudioRecordInstance() {
        return this.mAudioRecord;
    }

    public AudioRecordWrapper(AudioAttributes r100, AudioFormat r101, int r102, int r103) throws IllegalArgumentException {
        this.mAudioRecord = new AudioRecord.Builder().setAudioFormat(new AudioFormat.Builder().setSampleRate(r101.getSampleRate()).setEncoding(r101.getEncoding()).setChannelMask(r101.getChannelMask()).build()).setBufferSizeInBytes(r102).setSessionId(r103).setAudioAttributes(r100).setMaxSharedAudioHistoryMillis(AudioRecord.getMaxSharedAudioHistoryMillis() - 1).build();
    }
}
