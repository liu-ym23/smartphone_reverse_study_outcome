package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SEIStreamUpdateEvent extends Enum<SEIStreamUpdateEvent> {
    private static final /* synthetic */ SEIStreamUpdateEvent[] $VALUES = null;
    public static final SEIStreamUpdateEvent STREAM_ADD = null;
    public static final SEIStreamUpdateEvent STREAM_REMOVE = null;
    int value;

    static {
        SEIStreamUpdateEvent r100 = new SEIStreamUpdateEvent("STREAM_ADD", 0, 0);
        STREAM_ADD = r100;
        SEIStreamUpdateEvent r101 = new SEIStreamUpdateEvent("STREAM_REMOVE", 1, 1);
        STREAM_REMOVE = r101;
        $VALUES = new SEIStreamUpdateEvent[]{r100, r101};
    }

    public static SEIStreamUpdateEvent[] values() {
        return (SEIStreamUpdateEvent[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SEIStreamUpdateEvent valueOf(String r100) {
        return (SEIStreamUpdateEvent) a.a(SEIStreamUpdateEvent.class, r100);
    }

    private SEIStreamUpdateEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
