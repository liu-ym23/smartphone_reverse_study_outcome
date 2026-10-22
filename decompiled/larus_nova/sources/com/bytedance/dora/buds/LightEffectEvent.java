package com.bytedance.dora.buds;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum LightEffectEvent extends Enum<LightEffectEvent> {
    public static final LightEffectEvent INDICATOR_RAPID_FLASHING = null;
    public static final LightEffectEvent INDICATOR_SLOWLY_FLASHING = null;
    public static final LightEffectEvent INDICATOR_TURN_OFF = null;
    public static final LightEffectEvent INDICATOR_TURN_ON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LightEffectEvent[] f204377a = null;
    public final int CID;
    public final int EVENT;
    public final int LEN;
    public final int SID;
    public final byte[] VALUE;

    static {
        LightEffectEvent r100 = new LightEffectEvent("INDICATOR_TURN_ON", 0, new byte[]{1, 2});
        INDICATOR_TURN_ON = r100;
        LightEffectEvent r101 = new LightEffectEvent("INDICATOR_SLOWLY_FLASHING", 1, new byte[]{2, 2});
        INDICATOR_SLOWLY_FLASHING = r101;
        LightEffectEvent r102 = new LightEffectEvent("INDICATOR_RAPID_FLASHING", 2, new byte[]{3, 2});
        INDICATOR_RAPID_FLASHING = r102;
        LightEffectEvent r103 = new LightEffectEvent("INDICATOR_TURN_OFF", 3, new byte[]{4, 2});
        INDICATOR_TURN_OFF = r103;
        f204377a = new LightEffectEvent[]{r100, r101, r102, r103};
    }

    public static LightEffectEvent[] values() {
        return (LightEffectEvent[]) f204377a.clone();
    }

    public static LightEffectEvent valueOf(String r100) {
        return (LightEffectEvent) a.a(LightEffectEvent.class, r100);
    }

    public byte[] valueWithBrightness(int r100) {
        return new byte[]{this.VALUE[0], (byte) r100};
    }

    public LightEffectEvent(String r100, int r101, byte[] r102) {
        super(r100, r101);
        this.SID = 2;
        this.CID = 5;
        this.EVENT = 47;
        this.LEN = 2;
        this.VALUE = r102;
    }
}
