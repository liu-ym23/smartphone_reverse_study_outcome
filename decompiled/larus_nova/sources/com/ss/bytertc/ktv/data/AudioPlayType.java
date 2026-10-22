package com.ss.bytertc.ktv.data;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioPlayType extends Enum<AudioPlayType> {
    private static final /* synthetic */ AudioPlayType[] $VALUES = null;
    public static final AudioPlayType LOCAL = null;
    public static final AudioPlayType LOCAL_AND_REMOTE = null;
    public static final AudioPlayType REMOTE = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.ktv.data.AudioPlayType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType = null;

        static {
            int[] r100 = new int[AudioPlayType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType = r100;
            r100[AudioPlayType.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.REMOTE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[AudioPlayType.LOCAL_AND_REMOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        AudioPlayType r100 = new AudioPlayType(AccountType.LOCAL, 0, 0);
        LOCAL = r100;
        AudioPlayType r101 = new AudioPlayType("REMOTE", 1, 1);
        REMOTE = r101;
        AudioPlayType r102 = new AudioPlayType("LOCAL_AND_REMOTE", 2, 2);
        LOCAL_AND_REMOTE = r102;
        $VALUES = new AudioPlayType[]{r100, r101, r102};
    }

    public static AudioPlayType[] values() {
        return (AudioPlayType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$AudioPlayType[ordinal()];
        if (r100 != 1) goto L5;
        return "AUDIO_PLAY_TYPE_LOCAL";
    L5:
        if (r100 != 2) goto L7;
        return "AUDIO_PLAY_TYPE_REMOTE";
    L7:
        if (r100 == 3) goto L9;
        return "";
    L9:
        return "AUDIO_PLAY_TYPE_LOCAL_AND_REMOTE";
    }

    public int value() {
        return this.value;
    }

    public static AudioPlayType fromId(int r100) {
        AudioPlayType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioPlayType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioPlayType valueOf(String r100) {
        return (AudioPlayType) a.a(AudioPlayType.class, r100);
    }

    private AudioPlayType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
