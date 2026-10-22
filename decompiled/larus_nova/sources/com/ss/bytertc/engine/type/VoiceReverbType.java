package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum VoiceReverbType extends Enum<VoiceReverbType> {
    private static final /* synthetic */ VoiceReverbType[] $VALUES = null;
    public static final VoiceReverbType VOICE_REVERB_3D = null;
    public static final VoiceReverbType VOICE_REVERB_BLUES = null;
    public static final VoiceReverbType VOICE_REVERB_CHAMBER = null;
    public static final VoiceReverbType VOICE_REVERB_CONCERT = null;
    public static final VoiceReverbType VOICE_REVERB_DISCO = null;
    public static final VoiceReverbType VOICE_REVERB_ECHO = null;
    public static final VoiceReverbType VOICE_REVERB_ELECTRONIC = null;
    public static final VoiceReverbType VOICE_REVERB_ETHEREAL = null;
    public static final VoiceReverbType VOICE_REVERB_HARMONY = null;
    public static final VoiceReverbType VOICE_REVERB_JAZZ = null;
    public static final VoiceReverbType VOICE_REVERB_KTV = null;
    public static final VoiceReverbType VOICE_REVERB_OLDRECORD = null;
    public static final VoiceReverbType VOICE_REVERB_ORIGINAL = null;
    public static final VoiceReverbType VOICE_REVERB_POP = null;
    public static final VoiceReverbType VOICE_REVERB_ROCK = null;
    public static final VoiceReverbType VOICE_REVERB_SPACIOUS = null;
    public static final VoiceReverbType VOICE_REVERB_STUDIO = null;
    public static final VoiceReverbType VOICE_REVERB_VINYL = null;
    public static final VoiceReverbType VOICE_REVERB_VIRTUAL_STEREO = null;
    private final int value;

    static {
        VoiceReverbType r100 = new VoiceReverbType("VOICE_REVERB_ORIGINAL", 0, 0);
        VOICE_REVERB_ORIGINAL = r100;
        VoiceReverbType r101 = new VoiceReverbType("VOICE_REVERB_ECHO", 1, 1);
        VOICE_REVERB_ECHO = r101;
        VoiceReverbType r102 = new VoiceReverbType("VOICE_REVERB_CONCERT", 2, 2);
        VOICE_REVERB_CONCERT = r102;
        VoiceReverbType r103 = new VoiceReverbType("VOICE_REVERB_ETHEREAL", 3, 3);
        VOICE_REVERB_ETHEREAL = r103;
        VoiceReverbType r104 = new VoiceReverbType("VOICE_REVERB_KTV", 4, 4);
        VOICE_REVERB_KTV = r104;
        VoiceReverbType r105 = new VoiceReverbType("VOICE_REVERB_STUDIO", 5, 5);
        VOICE_REVERB_STUDIO = r105;
        VoiceReverbType r110 = new VoiceReverbType("VOICE_REVERB_VIRTUAL_STEREO", 6, 6);
        VOICE_REVERB_VIRTUAL_STEREO = r110;
        VoiceReverbType r111 = new VoiceReverbType("VOICE_REVERB_SPACIOUS", 7, 7);
        VOICE_REVERB_SPACIOUS = r111;
        VoiceReverbType r112 = new VoiceReverbType("VOICE_REVERB_3D", 8, 8);
        VOICE_REVERB_3D = r112;
        VoiceReverbType r113 = new VoiceReverbType("VOICE_REVERB_POP", 9, 9);
        VOICE_REVERB_POP = r113;
        VoiceReverbType r114 = new VoiceReverbType("VOICE_REVERB_DISCO", 10, 10);
        VOICE_REVERB_DISCO = r114;
        VoiceReverbType r115 = new VoiceReverbType("VOICE_REVERB_OLDRECORD", 11, 11);
        VOICE_REVERB_OLDRECORD = r115;
        VoiceReverbType r106 = new VoiceReverbType("VOICE_REVERB_HARMONY", 12, 12);
        VOICE_REVERB_HARMONY = r106;
        VoiceReverbType r107 = new VoiceReverbType("VOICE_REVERB_ROCK", 13, 13);
        VOICE_REVERB_ROCK = r107;
        VoiceReverbType r108 = new VoiceReverbType("VOICE_REVERB_BLUES", 14, 14);
        VOICE_REVERB_BLUES = r108;
        VoiceReverbType r109 = new VoiceReverbType("VOICE_REVERB_JAZZ", 15, 15);
        VOICE_REVERB_JAZZ = r109;
        VoiceReverbType r116 = new VoiceReverbType("VOICE_REVERB_ELECTRONIC", 16, 16);
        VOICE_REVERB_ELECTRONIC = r116;
        VoiceReverbType r117 = new VoiceReverbType("VOICE_REVERB_VINYL", 17, 17);
        VOICE_REVERB_VINYL = r117;
        VoiceReverbType r118 = new VoiceReverbType("VOICE_REVERB_CHAMBER", 18, 18);
        VOICE_REVERB_CHAMBER = r118;
        $VALUES = new VoiceReverbType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public static VoiceReverbType[] values() {
        return (VoiceReverbType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static VoiceReverbType fromId(int r100) {
        VoiceReverbType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        VoiceReverbType r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return VOICE_REVERB_ORIGINAL;
    }

    public static VoiceReverbType valueOf(String r100) {
        return (VoiceReverbType) a.a(VoiceReverbType.class, r100);
    }

    private VoiceReverbType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
