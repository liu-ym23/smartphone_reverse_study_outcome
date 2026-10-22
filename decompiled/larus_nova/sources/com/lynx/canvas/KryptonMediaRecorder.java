package com.lynx.canvas;

import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public interface KryptonMediaRecorder {

    public interface Listener {
        void onClipVideoEnd(KryptonMediaRecorder r100, String r101, String r102, float r103, long r104);

        void onClipVideoEndWithError(KryptonMediaRecorder r100, String r101);

        void onRecordFlush(KryptonMediaRecorder r100);

        void onRecordStartError(KryptonMediaRecorder r100, String r101);

        void onRecordStop(KryptonMediaRecorder r100, String r101, String r102, float r103, long r104);

        void onRecordStopWithError(KryptonMediaRecorder r100, String r101);
    }

    boolean clipVideo(long[] r100);

    void configAudio(int r100, int r101, int r102);

    void configVideo(String r100, int r101, int r102, int r103, int r104, int r105);

    void destroy(boolean r100);

    long lastPresentationTime();

    void onAudioSample(ByteBuffer r100, int r101);

    void pauseRecord();

    void resumeRecord();

    void setListener(Listener r100);

    Surface startRecord();

    void stopRecord();
}
