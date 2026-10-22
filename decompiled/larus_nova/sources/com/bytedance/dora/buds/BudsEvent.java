package com.bytedance.dora.buds;

import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public final enum BudsEvent extends Enum<BudsEvent> {
    public static final BudsEvent ANTI_SOUND_LEAK_OFF = null;
    public static final BudsEvent ANTI_SOUND_LEAK_ON = null;
    public static final BudsEvent GET_ANTI_SOUND_LEAK_STATE = null;
    public static final BudsEvent KEY_DOWN = null;
    public static final BudsEvent KEY_MODE_LEFT_NONE = null;
    public static final BudsEvent KEY_MODE_LEFT_RADIO = null;
    public static final BudsEvent KEY_MODE_LEFT_WAKEUP = null;
    public static final BudsEvent KEY_MODE_NONE = null;
    public static final BudsEvent KEY_MODE_RADIO = null;
    public static final BudsEvent KEY_MODE_RIGHT_NONE = null;
    public static final BudsEvent KEY_MODE_RIGHT_RADIO = null;
    public static final BudsEvent KEY_MODE_RIGHT_WAKEUP = null;
    public static final BudsEvent KEY_MODE_WAKEUP = null;
    public static final BudsEvent KEY_UP = null;
    public static final BudsEvent LIVE_AI_MUTE = null;
    public static final BudsEvent LIVE_AI_UNMUTE = null;
    public static final BudsEvent LOCAL_SPEECH_END_TIME = null;
    public static final BudsEvent PRE_WAKE_OFF = null;
    public static final BudsEvent PRE_WAKE_ON = null;
    public static final BudsEvent SENSOR_OFF = null;
    public static final BudsEvent SENSOR_ON = null;
    public static final BudsEvent SIMUL_INTERPRET_CONFERENCE_MODE = null;
    public static final BudsEvent SIMUL_INTERPRET_FACE_TO_FACE_MODE = null;
    public static final BudsEvent VAD_OFF = null;
    public static final BudsEvent VAD_ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BudsEvent[] f204376a = null;
    public final int CID;
    public final int EVENT;
    public final int LEN;
    public final int SID;
    public final byte[] VALUE;

    static {
        BudsEvent r100 = new BudsEvent("SENSOR_OFF", 0, 4, 6, 1, 1, new byte[]{0});
        SENSOR_OFF = r100;
        BudsEvent r101 = new BudsEvent("SENSOR_ON", 1, 4, 6, 1, 1, new byte[]{1});
        SENSOR_ON = r101;
        BudsEvent r102 = new BudsEvent("KEY_DOWN", 2, 4, 6, 2, 2, new byte[]{1, 1});
        KEY_DOWN = r102;
        BudsEvent r103 = new BudsEvent("KEY_UP", 3, 4, 6, 2, 2, new byte[]{1, 0});
        KEY_UP = r103;
        BudsEvent r104 = new BudsEvent("KEY_MODE_NONE", 4, 4, 6, 3, 1, new byte[]{0});
        KEY_MODE_NONE = r104;
        BudsEvent r105 = new BudsEvent("KEY_MODE_RADIO", 5, 4, 6, 3, 1, new byte[]{1});
        KEY_MODE_RADIO = r105;
        BudsEvent r106 = new BudsEvent("KEY_MODE_WAKEUP", 6, 4, 6, 3, 1, new byte[]{2});
        KEY_MODE_WAKEUP = r106;
        BudsEvent r107 = new BudsEvent("KEY_MODE_LEFT_NONE", 7, 4, 6, 3, 2, new byte[]{0, 1});
        KEY_MODE_LEFT_NONE = r107;
        BudsEvent r110 = new BudsEvent("KEY_MODE_RIGHT_NONE", 8, 4, 6, 3, 2, new byte[]{0, 0});
        KEY_MODE_RIGHT_NONE = r110;
        BudsEvent r111 = new BudsEvent("KEY_MODE_LEFT_RADIO", 9, 4, 6, 3, 2, new byte[]{1, 1});
        KEY_MODE_LEFT_RADIO = r111;
        BudsEvent r112 = new BudsEvent("KEY_MODE_RIGHT_RADIO", 10, 4, 6, 3, 2, new byte[]{1, 0});
        KEY_MODE_RIGHT_RADIO = r112;
        BudsEvent r113 = new BudsEvent("KEY_MODE_LEFT_WAKEUP", 11, 4, 6, 3, 2, new byte[]{2, 1});
        KEY_MODE_LEFT_WAKEUP = r113;
        BudsEvent r114 = new BudsEvent("KEY_MODE_RIGHT_WAKEUP", 12, 4, 6, 3, 2, new byte[]{2, 0});
        KEY_MODE_RIGHT_WAKEUP = r114;
        BudsEvent r115 = new BudsEvent("VAD_OFF", 13, 2, 5, 7, 1, new byte[]{0});
        VAD_OFF = r115;
        BudsEvent r108 = new BudsEvent("VAD_ON", 14, 2, 5, 7, 1, new byte[]{1});
        VAD_ON = r108;
        BudsEvent r116 = new BudsEvent("PRE_WAKE_OFF", 15, 2, 5, 8, 1, new byte[]{0});
        PRE_WAKE_OFF = r116;
        BudsEvent r109 = new BudsEvent("PRE_WAKE_ON", 16, 2, 5, 8, 1, new byte[]{1});
        PRE_WAKE_ON = r109;
        BudsEvent r117 = new BudsEvent("LIVE_AI_MUTE", 17, 2, 5, 44, 1, new byte[]{0});
        LIVE_AI_MUTE = r117;
        BudsEvent r118 = new BudsEvent("LIVE_AI_UNMUTE", 18, 2, 5, 44, 1, new byte[]{1});
        LIVE_AI_UNMUTE = r118;
        BudsEvent r119 = new BudsEvent("LOCAL_SPEECH_END_TIME", 19, 2, 5, 49, 8, new byte[0]);
        LOCAL_SPEECH_END_TIME = r119;
        BudsEvent r120 = new BudsEvent("SIMUL_INTERPRET_FACE_TO_FACE_MODE", 20, 2, 5, 60, 1, new byte[]{0});
        SIMUL_INTERPRET_FACE_TO_FACE_MODE = r120;
        BudsEvent r121 = new BudsEvent("SIMUL_INTERPRET_CONFERENCE_MODE", 21, 2, 5, 60, 1, new byte[]{1});
        SIMUL_INTERPRET_CONFERENCE_MODE = r121;
        BudsEvent r122 = new BudsEvent("GET_ANTI_SOUND_LEAK_STATE", 22, 1, 5, 7, 0, new byte[0]);
        GET_ANTI_SOUND_LEAK_STATE = r122;
        BudsEvent r123 = new BudsEvent("ANTI_SOUND_LEAK_ON", 23, 1, 5, 7, 1, new byte[]{1});
        ANTI_SOUND_LEAK_ON = r123;
        BudsEvent r124 = new BudsEvent("ANTI_SOUND_LEAK_OFF", 24, 1, 5, 7, 1, new byte[]{0});
        ANTI_SOUND_LEAK_OFF = r124;
        f204376a = new BudsEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r109, r117, r118, r119, r120, r121, r122, r123, r124};
    }

    public static BudsEvent[] values() {
        return (BudsEvent[]) f204376a.clone();
    }

    public static BudsEvent valueOf(String r100) {
        return (BudsEvent) a.a(BudsEvent.class, r100);
    }

    public BudsEvent(String r100, int r101, int r102, int r103, int r104, int r105, byte[] r106) {
        super(r100, r101);
        this.SID = r102;
        this.CID = r103;
        this.EVENT = r104;
        this.LEN = r105;
        this.VALUE = r106;
    }
}
