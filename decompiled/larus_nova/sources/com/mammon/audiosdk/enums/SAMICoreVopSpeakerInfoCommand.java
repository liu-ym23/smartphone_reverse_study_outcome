package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreVopSpeakerInfoCommand extends Enum<SAMICoreVopSpeakerInfoCommand> {
    private static final /* synthetic */ SAMICoreVopSpeakerInfoCommand[] $VALUES = null;
    public static final SAMICoreVopSpeakerInfoCommand BIND_VOICE = null;
    public static final SAMICoreVopSpeakerInfoCommand DELETE = null;
    public static final SAMICoreVopSpeakerInfoCommand DISCARD_VOICE = null;
    public static final SAMICoreVopSpeakerInfoCommand SET_PRIVATE = null;
    public static final SAMICoreVopSpeakerInfoCommand SET_PUBLIC = null;
    public static final SAMICoreVopSpeakerInfoCommand SIGN_AGREEMENT = null;
    public static final SAMICoreVopSpeakerInfoCommand START_BUILD_TASK = null;
    public static final SAMICoreVopSpeakerInfoCommand START_RECORD_TASK = null;
    private int value;

    static {
        SAMICoreVopSpeakerInfoCommand r100 = new SAMICoreVopSpeakerInfoCommand("SIGN_AGREEMENT", 0, 0);
        SIGN_AGREEMENT = r100;
        SAMICoreVopSpeakerInfoCommand r101 = new SAMICoreVopSpeakerInfoCommand("START_RECORD_TASK", 1, 1);
        START_RECORD_TASK = r101;
        SAMICoreVopSpeakerInfoCommand r102 = new SAMICoreVopSpeakerInfoCommand("START_BUILD_TASK", 2, 2);
        START_BUILD_TASK = r102;
        SAMICoreVopSpeakerInfoCommand r103 = new SAMICoreVopSpeakerInfoCommand("SET_PUBLIC", 3, 3);
        SET_PUBLIC = r103;
        SAMICoreVopSpeakerInfoCommand r104 = new SAMICoreVopSpeakerInfoCommand("SET_PRIVATE", 4, 4);
        SET_PRIVATE = r104;
        SAMICoreVopSpeakerInfoCommand r105 = new SAMICoreVopSpeakerInfoCommand("DELETE", 5, 5);
        DELETE = r105;
        SAMICoreVopSpeakerInfoCommand r110 = new SAMICoreVopSpeakerInfoCommand("BIND_VOICE", 6, 6);
        BIND_VOICE = r110;
        SAMICoreVopSpeakerInfoCommand r111 = new SAMICoreVopSpeakerInfoCommand("DISCARD_VOICE", 7, 7);
        DISCARD_VOICE = r111;
        $VALUES = new SAMICoreVopSpeakerInfoCommand[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static SAMICoreVopSpeakerInfoCommand[] values() {
        return (SAMICoreVopSpeakerInfoCommand[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopSpeakerInfoCommand valueOf(String r100) {
        return (SAMICoreVopSpeakerInfoCommand) a.a(SAMICoreVopSpeakerInfoCommand.class, r100);
    }

    private SAMICoreVopSpeakerInfoCommand(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
