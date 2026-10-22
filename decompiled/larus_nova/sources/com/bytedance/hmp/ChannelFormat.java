package com.bytedance.hmp;

import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final enum ChannelFormat extends Enum<ChannelFormat> {
    private static final /* synthetic */ ChannelFormat[] $VALUES = null;
    public static final ChannelFormat kNCHW = null;
    public static final ChannelFormat kNHWC = null;
    private final int value;

    static {
        ChannelFormat r100 = new ChannelFormat("kNCHW", 0, 0);
        kNCHW = r100;
        ChannelFormat r101 = new ChannelFormat("kNHWC", 1, 1);
        kNHWC = r101;
        $VALUES = new ChannelFormat[]{r100, r101};
    }

    public static ChannelFormat[] values() {
        return (ChannelFormat[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static ChannelFormat valueOf(String r100) {
        return (ChannelFormat) a.a(ChannelFormat.class, r100);
    }

    private ChannelFormat(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
