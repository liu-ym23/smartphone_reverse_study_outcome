package com.ss.android.vesdk;

import android.util.Pair;
import com.ss.android.ttve.nativePort.TESystemUtils;

/* JADX INFO: loaded from: classes40.dex */
public class VEAudioCaptureSettings {
    public static final int AUDIO_DATA_STORE_BYTE_ARRAY = 0;
    public static final int AUDIO_DATA_STORE_BYTE_BUFFER = 1;
    public static final int AUDIO_SOURCE_CAMCORDER = 5;
    public static final int AUDIO_SOURCE_DEFAULT = 0;
    public static final int AUDIO_SOURCE_MIC = 1;
    public static final int AUDIO_SOURCE_VOICE_RECOGNITION = 6;
    private static final int DEFAULT_BITS_PER_SAMPLE = 16;
    private static final int DEFAULT_CHANNEL = 2;
    private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLE_RATE = 44100;
    private static final String TAG = "VEAudioCaptureSettings";
    private int audioSource;
    private int bitSamples;
    private int channel;
    private int dataStore;
    private boolean enableSysKaraoke;
    private int framesPerBuffer;
    private boolean lowLatency;
    private boolean preferBuiltinMicInBluetoothScene;
    private int sampleRate;

    public static class Builder {
        VEAudioCaptureSettings settings;

        public Builder() {
            this.settings = new VEAudioCaptureSettings(null);
        }

        public VEAudioCaptureSettings build() {
            return this.settings;
        }

        public Builder(VEAudioCaptureSettings r100) {
            new VEAudioCaptureSettings(null);
            this.settings = r100;
        }

        public Builder enableSysKaraoke(boolean r100) {
            VEAudioCaptureSettings.access$802(this.settings, r100);
            return this;
        }

        public Builder preferBuiltinMicInBluetoothScene(boolean r100) {
            VEAudioCaptureSettings.access$902(this.settings, r100);
            return this;
        }

        public Builder setAudioCaptureLowLatency(boolean r100) {
            if (VEConfigCenter.getInstance().getValue("ve_enable_recorder_disable_audio_capture_low_latency", false).booleanValue() == false) goto L5;
            VELogUtil.i(VEAudioCaptureSettings.TAG, "disable audio capture low latency");
            r100 = false;
        L5:
            if (r100 == false) goto L9;
            Pair<Integer, Integer> r101 = TESystemUtils.getSuggestedOutputProperty();
            if (r101 == null) goto L10;
            VEAudioCaptureSettings.access$202(this.settings, ((Integer) r101.first).intValue());
            VEAudioCaptureSettings.access$602(this.settings, ((Integer) r101.second).intValue());
        L10:
            VEAudioCaptureSettings.access$702(this.settings, r100);
            return this;
        L9:
            VEAudioCaptureSettings.access$202(this.settings, VEAudioCaptureSettings.DEFAULT_SAMPLE_RATE);
            VEAudioCaptureSettings.access$602(this.settings, 256);
            goto L10
        }

        public Builder setAudioDataStore(int r100) {
            VEAudioCaptureSettings.access$502(this.settings, r100);
            return this;
        }

        public Builder setAudioSource(int r100) {
            VEAudioCaptureSettings.access$402(this.settings, r100);
            return this;
        }

        public Builder setBitSamples(int r100) {
            VEAudioCaptureSettings.access$302(this.settings, r100);
            return this;
        }

        public Builder setChannel(int r100) {
            VEAudioCaptureSettings.access$102(this.settings, r100);
            return this;
        }

        public Builder setSampleRate(int r100) {
            VEAudioCaptureSettings.access$202(this.settings, r100);
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    private VEAudioCaptureSettings() {
        this.channel = 2;
        this.sampleRate = DEFAULT_SAMPLE_RATE;
        this.bitSamples = 16;
        this.audioSource = 1;
        this.dataStore = 0;
        this.framesPerBuffer = 256;
        this.lowLatency = false;
        this.enableSysKaraoke = false;
        this.preferBuiltinMicInBluetoothScene = true;
    }

    public int getAudioSource() {
        return this.audioSource;
    }

    public int getBitSamples() {
        return this.bitSamples;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getDataStore() {
        return this.dataStore;
    }

    public int getFramesPerBuffer() {
        return this.framesPerBuffer;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean isEnableSysKaraoke() {
        return this.enableSysKaraoke;
    }

    public boolean isLowLatency() {
        return this.lowLatency;
    }

    public boolean isPreferBuiltinMicInBluetoothScene() {
        return this.preferBuiltinMicInBluetoothScene;
    }

    public /* synthetic */ VEAudioCaptureSettings(a r100) {
        this();
    }

    public static /* synthetic */ int access$102(VEAudioCaptureSettings r100, int r101) {
        r100.channel = r101;
        return r101;
    }

    public static /* synthetic */ int access$202(VEAudioCaptureSettings r100, int r101) {
        r100.sampleRate = r101;
        return r101;
    }

    public static /* synthetic */ int access$302(VEAudioCaptureSettings r100, int r101) {
        r100.bitSamples = r101;
        return r101;
    }

    public static /* synthetic */ int access$402(VEAudioCaptureSettings r100, int r101) {
        r100.audioSource = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(VEAudioCaptureSettings r100, int r101) {
        r100.dataStore = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(VEAudioCaptureSettings r100, int r101) {
        r100.framesPerBuffer = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(VEAudioCaptureSettings r100, boolean r101) {
        r100.lowLatency = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$802(VEAudioCaptureSettings r100, boolean r101) {
        r100.enableSysKaraoke = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$902(VEAudioCaptureSettings r100, boolean r101) {
        r100.preferBuiltinMicInBluetoothScene = r101;
        return r101;
    }
}
