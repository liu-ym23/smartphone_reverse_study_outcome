package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioChannel extends Enum<AudioChannel> {
    private static final /* synthetic */ AudioChannel[] $VALUES = null;
    public static final AudioChannel AUDIO_CHANNEL_AUTO = null;
    public static final AudioChannel AUDIO_CHANNEL_MONO = null;
    public static final AudioChannel AUDIO_CHANNEL_STEREO = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioChannel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioChannel = null;

        static {
            int[] r100 = new int[AudioChannel.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioChannel = r100;
            r100[AudioChannel.AUDIO_CHANNEL_AUTO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$engine$data$AudioChannel[AudioChannel.AUDIO_CHANNEL_MONO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$engine$data$AudioChannel[AudioChannel.AUDIO_CHANNEL_STEREO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        AudioChannel r100 = new AudioChannel("AUDIO_CHANNEL_AUTO", 0, -1);
        AUDIO_CHANNEL_AUTO = r100;
        AudioChannel r101 = new AudioChannel("AUDIO_CHANNEL_MONO", 1, 1);
        AUDIO_CHANNEL_MONO = r101;
        AudioChannel r102 = new AudioChannel("AUDIO_CHANNEL_STEREO", 2, 2);
        AUDIO_CHANNEL_STEREO = r102;
        $VALUES = new AudioChannel[]{r100, r101, r102};
    }

    public static AudioChannel[] values() {
        return (AudioChannel[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioChannel[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioChannelAuto";
    L5:
        if (r100 != 2) goto L7;
        return "kAudioChannelMono";
    L7:
        if (r100 == 3) goto L9;
        return "kAudioChannelUnknown";
    L9:
        return "kAudioChannelStereo";
    }

    public int value() {
        return this.value;
    }

    public static AudioChannel fromId(int r100) {
        AudioChannel[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioChannel r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioChannel valueOf(String r100) {
        return (AudioChannel) a.a(AudioChannel.class, r100);
    }

    private AudioChannel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
