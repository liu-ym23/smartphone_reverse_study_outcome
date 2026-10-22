package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioAEDType extends Enum<AudioAEDType> {
    private static final /* synthetic */ AudioAEDType[] $VALUES = null;
    public static final AudioAEDType MUSIC = null;
    public static final AudioAEDType NO_MUSIC = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.type.AudioAEDType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType = null;

        static {
            int[] r100 = new int[AudioAEDType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType = r100;
            r100[AudioAEDType.NO_MUSIC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$engine$type$AudioAEDType[AudioAEDType.MUSIC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        AudioAEDType r100 = new AudioAEDType("NO_MUSIC", 0, 0);
        NO_MUSIC = r100;
        AudioAEDType r101 = new AudioAEDType("MUSIC", 1, 1);
        MUSIC = r101;
        $VALUES = new AudioAEDType[]{r100, r101};
    }

    public static AudioAEDType[] values() {
        return (AudioAEDType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioAEDType[ordinal()];
        if (r100 != 1) goto L5;
        return "kAudioAEDTypeNoMusic";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "kAudioAEDTypeMusic";
    }

    public int value() {
        return this.value;
    }

    public static AudioAEDType fromId(int r100) {
        AudioAEDType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioAEDType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioAEDType valueOf(String r100) {
        return (AudioAEDType) a.a(AudioAEDType.class, r100);
    }

    private AudioAEDType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
