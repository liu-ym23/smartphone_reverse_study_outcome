package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioPlaybackDevice extends Enum<AudioPlaybackDevice> {
    private static final /* synthetic */ AudioPlaybackDevice[] $VALUES = null;
    public static final AudioPlaybackDevice AUDIO_PLAYBACK_DEVICE_EARPIECE = null;
    public static final AudioPlaybackDevice AUDIO_PLAYBACK_DEVICE_HEADSET = null;
    public static final AudioPlaybackDevice AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH = null;
    public static final AudioPlaybackDevice AUDIO_PLAYBACK_DEVICE_HEADSET_USB = null;
    public static final AudioPlaybackDevice AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioPlaybackDevice$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice = null;

        static {
            int[] r100 = new int[AudioPlaybackDevice.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice = r100;
            r100[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_EARPIECE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[AudioPlaybackDevice.AUDIO_PLAYBACK_DEVICE_HEADSET_USB.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        AudioPlaybackDevice r100 = new AudioPlaybackDevice("AUDIO_PLAYBACK_DEVICE_HEADSET", 0, 1);
        AUDIO_PLAYBACK_DEVICE_HEADSET = r100;
        AudioPlaybackDevice r101 = new AudioPlaybackDevice("AUDIO_PLAYBACK_DEVICE_EARPIECE", 1, 2);
        AUDIO_PLAYBACK_DEVICE_EARPIECE = r101;
        AudioPlaybackDevice r102 = new AudioPlaybackDevice("AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE", 2, 3);
        AUDIO_PLAYBACK_DEVICE_SPEAKERPHONE = r102;
        AudioPlaybackDevice r103 = new AudioPlaybackDevice("AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH", 3, 4);
        AUDIO_PLAYBACK_DEVICE_HEADSET_BLUETOOTH = r103;
        AudioPlaybackDevice r104 = new AudioPlaybackDevice("AUDIO_PLAYBACK_DEVICE_HEADSET_USB", 4, 5);
        AUDIO_PLAYBACK_DEVICE_HEADSET_USB = r104;
        $VALUES = new AudioPlaybackDevice[]{r100, r101, r102, r103, r104};
    }

    public static AudioPlaybackDevice[] values() {
        return (AudioPlaybackDevice[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioPlaybackDevice[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioPlaybackDeviceSpeakerphone";
    L5:
        if (r100 != 2) goto L7;
        return "kAudioPlaybackDeviceEarpiece";
    L7:
        if (r100 != 3) goto L9;
        return "kAudioPlaybackDeviceHeadset";
    L9:
        if (r100 != 4) goto L11;
        return "kAudioPlaybackDeviceHeadsetBluetooth";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "kAudioPlaybackDeviceHeadsetUSB";
    }

    public int value() {
        return this.value;
    }

    public static AudioPlaybackDevice fromId(int r100) {
        AudioPlaybackDevice[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioPlaybackDevice r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioPlaybackDevice valueOf(String r100) {
        return (AudioPlaybackDevice) a.a(AudioPlaybackDevice.class, r100);
    }

    private AudioPlaybackDevice(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
