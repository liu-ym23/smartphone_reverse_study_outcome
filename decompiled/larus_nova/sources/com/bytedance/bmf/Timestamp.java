package com.bytedance.bmf;

import r27.a;

/* JADX INFO: loaded from: classes43.dex */
public final enum Timestamp extends Enum<Timestamp> {
    private static final /* synthetic */ Timestamp[] $VALUES = null;
    public static final Timestamp BMF_PAUSE = null;
    public static final Timestamp DONE = null;
    public static final Timestamp EOF = null;
    public static final Timestamp EOS = null;
    public static final Timestamp INF_SRC = null;
    public static final Timestamp UNSET = null;
    private long value;

    static {
        Timestamp r100 = new Timestamp("UNSET", 0, -1);
        UNSET = r100;
        Timestamp r101 = new Timestamp("BMF_PAUSE", 1, 9223372036854775802L);
        BMF_PAUSE = r101;
        Timestamp r102 = new Timestamp("EOF", 2, 9223372036854775804L);
        EOF = r102;
        Timestamp r103 = new Timestamp("EOS", 3, 9223372036854775805L);
        EOS = r103;
        Timestamp r104 = new Timestamp("INF_SRC", 4, 9223372036854775806L);
        INF_SRC = r104;
        Timestamp r105 = new Timestamp("DONE", 5, Long.MAX_VALUE);
        DONE = r105;
        $VALUES = new Timestamp[]{r100, r101, r102, r103, r104, r105};
    }

    public static Timestamp[] values() {
        return (Timestamp[]) $VALUES.clone();
    }

    public long getValue() {
        return this.value;
    }

    public static Timestamp valueOf(String r100) {
        return (Timestamp) a.a(Timestamp.class, r100);
    }

    private Timestamp(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
