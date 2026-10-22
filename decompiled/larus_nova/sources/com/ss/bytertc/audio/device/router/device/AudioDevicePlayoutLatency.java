package com.ss.bytertc.audio.device.router.device;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import com.bytedance.realx.base.RXLogging;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes40.dex */
public class AudioDevicePlayoutLatency {
    private static final String TAG = "AudioDevicePlayoutLatency";
    private AudioTrack mAudioTrack;
    private int performanceMode;
    private int playoutChannel;

    public AudioDevicePlayoutLatency() {
        this.mAudioTrack = null;
        this.performanceMode = 2;
        this.playoutChannel = 4;
        RXLogging.e(TAG, "AudioDevicePlayoutLatency Created");
    }

    public int getPlayoutLatency(int r110, int r111, int r112) {
        if (r110 == 8000) goto L14;
        if (r110 == 16000) goto L14;
        if (r110 == 32000) goto L14;
        if (r110 == 44100) goto L14;
        if (r110 == 48000) goto L14;
        return 0;
    L14:
        if (r112 == 1) goto L18;
        if (r112 == 3) goto L17;
        this.performanceMode = 1;
    L20:
        if (r111 == 1) goto L24;
        if (r111 == 2) goto L23;
        this.playoutChannel = 4;
    L25:
        int r100 = (((int) Math.ceil(((double) r110) / 200.0d)) * 2) * r111;
        if (r100 > 0) goto L48;
        return 0;
    L48:
        if (Build.VERSION.SDK_INT < 26) goto L31;
        this.mAudioTrack = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(r110).setChannelMask(this.playoutChannel).build()).setTransferMode(1).setBufferSizeInBytes(r100).setPerformanceMode(this.performanceMode).build();     // Catch: Exception -> L47
    L32:
        AudioTrack r113 = this.mAudioTrack;
        if (r113 != null) goto L49;
        return 0;
    L49:
        Method r114 = r113.getClass().getDeclaredMethod("getLatency", new Class[0]);     // Catch: NoSuchMethodException -> L45
        r114.setAccessible(true);
        int r115 = Math.max(((Integer) r114.invoke(this.mAudioTrack, new Object[0])).intValue(), 0);
        this.mAudioTrack.release();
        return r115;
    L43:
        this.mAudioTrack.release();
        return 0;
    L41:
        this.mAudioTrack.release();
        return 0;
    L45:
        this.mAudioTrack.release();
        goto L46
    L31:
        this.mAudioTrack = new AudioTrack(3, r110, this.playoutChannel, 2, r100, 1);     // Catch: Exception -> L47
    L46:
        return 0;
    L23:
        this.playoutChannel = 12;
        goto L25
    L24:
        this.playoutChannel = 4;
        goto L25
    L17:
        this.performanceMode = 2;
        goto L20
    L18:
        this.performanceMode = 1;
        goto L20
    }
}
