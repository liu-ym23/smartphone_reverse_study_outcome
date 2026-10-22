package com.ss.android.vesdk.audio;

import android.media.AudioTrack;
import android.os.Build;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class TEAudioTrack {
    private static final String TAG = "TEAudioTrack";
    private AudioTrack mAudioTrack;
    private int mMinBufferSize;

    public int getBufferSizeInFrames() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return this.mAudioTrack.getBufferSizeInFrames();
    L7:
        return this.mMinBufferSize;
    }

    public int pause() {
        VELogUtil.i(TAG, "pause()");
        if (this.mAudioTrack.getState() == 1) goto L6;
        return -1;
    L6:
        INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_pause(this.mAudioTrack);
        return 0;
    }

    public void release() {
        VELogUtil.i(TAG, "release()");
        this.mAudioTrack.release();
    }

    public int start() {
        VELogUtil.i(TAG, "start()");
        if (this.mAudioTrack.getState() == 1) goto L6;
        return -1;
    L6:
        INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(this.mAudioTrack);
        return 0;
    }

    public int stop() {
        VELogUtil.i(TAG, "stop()");
        if (this.mAudioTrack.getState() == 1) goto L6;
        return -1;
    L6:
        INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(this.mAudioTrack);
        this.mAudioTrack.flush();
        return 0;
    }

    public int getMinBufferSize() {
        return this.mMinBufferSize;
    }

    public TEAudioTrack(int r100) {
        VELogUtil.i(TAG, "new()");
        this.mMinBufferSize = AudioTrack.getMinBufferSize(r100, 12, 2);
        this.mAudioTrack = new AudioTrack(3, r100, 12, 2, this.mMinBufferSize, 1);
    }

    public static void INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_pause(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        gna.a.a(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_play(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.play();
        return;
    L6:
        r100.play();
        gna.a.c(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_ss_android_vesdk_audio_TEAudioTrack_com_obric_performance_power_monitor_audio_AudioTrackLancet_stop(AudioTrack r100) {
        if (fna.g.d() == true) goto L6;
        r100.stop();
        return;
    L6:
        r100.stop();
        gna.a.a(r100.hashCode());
    }

    public int setVolume(float r100) {
        return this.mAudioTrack.setVolume(r100);
    }

    public int write(byte[] r100, int r101) {
        return this.mAudioTrack.write(r100, 0, r101);
    }
}
