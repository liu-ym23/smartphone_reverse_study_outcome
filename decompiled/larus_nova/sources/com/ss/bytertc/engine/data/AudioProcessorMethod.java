package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioProcessorMethod extends Enum<AudioProcessorMethod> {
    private static final /* synthetic */ AudioProcessorMethod[] $VALUES = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_EAR_MONITOR = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_PLAYBACK = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_RECORD = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_RECORD_WITH_REF = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_REMOTE_USER = null;
    public static final AudioProcessorMethod AUDIO_FRAME_PROCESSOR_SCREEN = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.data.AudioProcessorMethod$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod = null;

        static {
            int[] r100 = new int[AudioProcessorMethod.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod = r100;
            r100[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_PLAYBACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_REMOTE_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_EAR_MONITOR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[AudioProcessorMethod.AUDIO_FRAME_PROCESSOR_SCREEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        AudioProcessorMethod r100 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_RECORD", 0, 0);
        AUDIO_FRAME_PROCESSOR_RECORD = r100;
        AudioProcessorMethod r101 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_PLAYBACK", 1, 1);
        AUDIO_FRAME_PROCESSOR_PLAYBACK = r101;
        AudioProcessorMethod r102 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_REMOTE_USER", 2, 2);
        AUDIO_FRAME_PROCESSOR_REMOTE_USER = r102;
        AudioProcessorMethod r103 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_EAR_MONITOR", 3, 3);
        AUDIO_FRAME_PROCESSOR_EAR_MONITOR = r103;
        AudioProcessorMethod r104 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_SCREEN", 4, 4);
        AUDIO_FRAME_PROCESSOR_SCREEN = r104;
        AudioProcessorMethod r105 = new AudioProcessorMethod("AUDIO_FRAME_PROCESSOR_RECORD_WITH_REF", 5, 5);
        AUDIO_FRAME_PROCESSOR_RECORD_WITH_REF = r105;
        $VALUES = new AudioProcessorMethod[]{r100, r101, r102, r103, r104, r105};
    }

    public static AudioProcessorMethod[] values() {
        return (AudioProcessorMethod[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$AudioProcessorMethod[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_FRAME_PROCESSOR_RECORD";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_FRAME_PROCESSOR_PLAYBACK";
    L7:
        if (r100 != 3) goto L9;
        return "AUDIO_FRAME_PROCESSOR_REMOTE_USER";
    L9:
        if (r100 != 4) goto L11;
        return "AUDIO_FRAME_PROCESSOR_EAR_MONITOR";
    L11:
        if (r100 == 5) goto L13;
        return "";
    L13:
        return "AUDIO_FRAME_PROCESSOR_SCREEN";
    }

    public int value() {
        return this.value;
    }

    public static AudioProcessorMethod fromId(int r100) {
        AudioProcessorMethod[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioProcessorMethod r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioProcessorMethod valueOf(String r100) {
        return (AudioProcessorMethod) a.a(AudioProcessorMethod.class, r100);
    }

    private AudioProcessorMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
