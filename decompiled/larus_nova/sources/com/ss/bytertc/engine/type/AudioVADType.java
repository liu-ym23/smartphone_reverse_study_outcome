package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioVADType extends Enum<AudioVADType> {
    private static final /* synthetic */ AudioVADType[] $VALUES = null;
    public static final AudioVADType NO_SPEECH = null;
    public static final AudioVADType SPEECH = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.type.AudioVADType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioVADType = null;

        static {
            int[] r100 = new int[AudioVADType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioVADType = r100;
            r100[AudioVADType.NO_SPEECH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$type$AudioVADType[AudioVADType.SPEECH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        AudioVADType r100 = new AudioVADType("NO_SPEECH", 0, 0);
        NO_SPEECH = r100;
        AudioVADType r101 = new AudioVADType("SPEECH", 1, 1);
        SPEECH = r101;
        $VALUES = new AudioVADType[]{r100, r101};
    }

    public static AudioVADType[] values() {
        return (AudioVADType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioVADType[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioVADTypeNoSpeech";
    L5:
        if (r100 == 2) goto L8;
        return "valid";
    L8:
        return "kAudioVADTypeSpeech";
    }

    public int value() {
        return this.value;
    }

    public static AudioVADType fromId(int r100) {
        AudioVADType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioVADType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioVADType valueOf(String r100) {
        return (AudioVADType) a.a(AudioVADType.class, r100);
    }

    private AudioVADType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
