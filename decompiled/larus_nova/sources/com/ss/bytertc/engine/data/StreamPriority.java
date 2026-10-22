package com.ss.bytertc.engine.data;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum StreamPriority extends Enum<StreamPriority> {
    private static final /* synthetic */ StreamPriority[] $VALUES = null;
    public static final StreamPriority STREAM_PRIORITY_HIGH = null;
    public static final StreamPriority STREAM_PRIORITY_LOW = null;
    public static final StreamPriority STREAM_PRIORITY_MEDIAM = null;
    private int value;

    static {
        StreamPriority r100 = new StreamPriority("STREAM_PRIORITY_LOW", 0, 0);
        STREAM_PRIORITY_LOW = r100;
        StreamPriority r101 = new StreamPriority("STREAM_PRIORITY_MEDIAM", 1, 1);
        STREAM_PRIORITY_MEDIAM = r101;
        StreamPriority r102 = new StreamPriority("STREAM_PRIORITY_HIGH", 2, 2);
        STREAM_PRIORITY_HIGH = r102;
        $VALUES = new StreamPriority[]{r100, r101, r102};
    }

    public static StreamPriority[] values() {
        return (StreamPriority[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static StreamPriority fromId(int r100) {
        StreamPriority[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        StreamPriority r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static StreamPriority valueOf(String r100) {
        return (StreamPriority) a.a(StreamPriority.class, r100);
    }

    private StreamPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
