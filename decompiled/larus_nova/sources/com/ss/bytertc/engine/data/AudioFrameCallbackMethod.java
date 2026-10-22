package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioFrameCallbackMethod extends Enum<AudioFrameCallbackMethod> {
    private static final /* synthetic */ AudioFrameCallbackMethod[] $VALUES = null;
    public static final AudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = null;
    public static final AudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_MIXED = null;
    public static final AudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_PLAYBACK = null;
    public static final AudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_RECORD = null;
    public static final AudioFrameCallbackMethod AUDIO_FRAME_CALLBACK_REMOTE_USER = null;
    private int value;

    static {
        AudioFrameCallbackMethod r100 = new AudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_RECORD", 0, 0);
        AUDIO_FRAME_CALLBACK_RECORD = r100;
        AudioFrameCallbackMethod r101 = new AudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_PLAYBACK", 1, 1);
        AUDIO_FRAME_CALLBACK_PLAYBACK = r101;
        AudioFrameCallbackMethod r102 = new AudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_MIXED", 2, 2);
        AUDIO_FRAME_CALLBACK_MIXED = r102;
        AudioFrameCallbackMethod r103 = new AudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_REMOTE_USER", 3, 3);
        AUDIO_FRAME_CALLBACK_REMOTE_USER = r103;
        AudioFrameCallbackMethod r104 = new AudioFrameCallbackMethod("AUDIO_FRAME_CALLBACK_CAPTURE_MIXED", 4, 5);
        AUDIO_FRAME_CALLBACK_CAPTURE_MIXED = r104;
        $VALUES = new AudioFrameCallbackMethod[]{r100, r101, r102, r103, r104};
    }

    public static AudioFrameCallbackMethod[] values() {
        return (AudioFrameCallbackMethod[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AudioFrameCallbackMethod fromId(int r100) {
        AudioFrameCallbackMethod[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioFrameCallbackMethod r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioFrameCallbackMethod valueOf(String r100) {
        return (AudioFrameCallbackMethod) a.a(AudioFrameCallbackMethod.class, r100);
    }

    private AudioFrameCallbackMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
