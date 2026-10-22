package com.ss.bytertc.engine.type;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AudioCodecType extends Enum<AudioCodecType> {
    private static final /* synthetic */ AudioCodecType[] $VALUES = null;
    public static final AudioCodecType AAC = null;
    public static final AudioCodecType AACHEV1 = null;
    public static final AudioCodecType AACHEV2 = null;
    public static final AudioCodecType AACLC = null;
    public static final AudioCodecType AACLCADTS = null;
    public static final AudioCodecType NONE = null;
    public static final AudioCodecType OPUS = null;
    private int value;

    /* JADX INFO: renamed from: com.ss.bytertc.engine.type.AudioCodecType$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType = null;

        static {
            int[] r100 = new int[AudioCodecType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType = r100;
            r100[AudioCodecType.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.OPUS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AAC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACLC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACHEV1.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACHEV2.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[AudioCodecType.AACLCADTS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    static {
        AudioCodecType r100 = new AudioCodecType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        AudioCodecType r101 = new AudioCodecType("OPUS", 1, 1);
        OPUS = r101;
        AudioCodecType r102 = new AudioCodecType("AAC", 2, 2);
        AAC = r102;
        AudioCodecType r103 = new AudioCodecType("AACLC", 3, 3);
        AACLC = r103;
        AudioCodecType r104 = new AudioCodecType("AACHEV1", 4, 4);
        AACHEV1 = r104;
        AudioCodecType r105 = new AudioCodecType("AACHEV2", 5, 5);
        AACHEV2 = r105;
        AudioCodecType r110 = new AudioCodecType("AACLCADTS", 6, 6);
        AACLCADTS = r110;
        $VALUES = new AudioCodecType[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public static AudioCodecType[] values() {
        return (AudioCodecType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        switch(AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$AudioCodecType[ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "kAudioCodecTypeAACLCadts";
    L6:
        return "kAudioCodecTypeAACHEv2";
    L7:
        return "kAudioCodecTypeAACHEv1";
    L8:
        return "kAudioCodecTypeAACLC";
    L9:
        return "kAudioCodecTypeAAC";
    L10:
        return "kAudioCodecTypeOpus";
    L11:
        return "kAudioCodecTypeNone";
    }

    public int value() {
        return this.value;
    }

    public static AudioCodecType fromId(int r100) {
        AudioCodecType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        AudioCodecType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static AudioCodecType valueOf(String r100) {
        return (AudioCodecType) a.a(AudioCodecType.class, r100);
    }

    private AudioCodecType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
