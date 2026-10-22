package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StreamLayoutMode extends Enum<StreamLayoutMode> {
    private static final /* synthetic */ StreamLayoutMode[] $VALUES = null;
    public static final StreamLayoutMode AUTO = null;
    public static final StreamLayoutMode CUSTOM = null;
    private int mode;

    static {
        StreamLayoutMode r100 = new StreamLayoutMode("AUTO", 0, 0);
        AUTO = r100;
        StreamLayoutMode r101 = new StreamLayoutMode("CUSTOM", 1, 2);
        CUSTOM = r101;
        $VALUES = new StreamLayoutMode[]{r100, r101};
    }

    public static StreamLayoutMode[] values() {
        return (StreamLayoutMode[]) $VALUES.clone();
    }

    public int value() {
        return this.mode;
    }

    public static StreamLayoutMode valueOf(String r100) {
        return (StreamLayoutMode) a.a(StreamLayoutMode.class, r100);
    }

    private StreamLayoutMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
