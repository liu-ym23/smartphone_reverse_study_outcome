package com.ss.bytertc.ktv.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioTrackType extends Enum<AudioTrackType> {
    private static final /* synthetic */ AudioTrackType[] $VALUES = null;
    public static final AudioTrackType ACCOMPANY = null;
    public static final AudioTrackType ORIGINAL = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.AudioTrackType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType = null;

        static {
            int[] r100 = new int[AudioTrackType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType = r100;
            r100[AudioTrackType.ACCOMPANY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType[AudioTrackType.ORIGINAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        AudioTrackType r100 = new AudioTrackType("ORIGINAL", 0, 1);
        ORIGINAL = r100;
        AudioTrackType r101 = new AudioTrackType("ACCOMPANY", 1, 2);
        ACCOMPANY = r101;
        $VALUES = new AudioTrackType[]{r100, r101};
    }

    public static AudioTrackType[] values() {
        return (AudioTrackType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$AudioTrackType[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_TRACK_TYPE_ACCOMPANY";
    L5:
        if (r100 == 2) goto L7;
        return "";
    L7:
        return "AUDIO_TRACK_TYPE_ORIGINAL";
    }

    public int value() {
        return this.value;
    }

    public static AudioTrackType fromId(int r100) {
        AudioTrackType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioTrackType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioTrackType valueOf(String r100) {
        return (AudioTrackType) a.a(AudioTrackType.class, r100);
    }

    private AudioTrackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
