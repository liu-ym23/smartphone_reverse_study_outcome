package org.apache.commons.compress.compressors.deflate64;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum HuffmanState extends Enum<HuffmanState> {
    private static final /* synthetic */ HuffmanState[] $VALUES = null;
    public static final HuffmanState DYNAMIC_CODES = null;
    public static final HuffmanState FIXED_CODES = null;
    public static final HuffmanState INITIAL = null;
    public static final HuffmanState STORED = null;

    static {
        HuffmanState r100 = new HuffmanState("INITIAL", 0);
        INITIAL = r100;
        HuffmanState r101 = new HuffmanState("STORED", 1);
        STORED = r101;
        HuffmanState r102 = new HuffmanState("DYNAMIC_CODES", 2);
        DYNAMIC_CODES = r102;
        HuffmanState r103 = new HuffmanState("FIXED_CODES", 3);
        FIXED_CODES = r103;
        $VALUES = new HuffmanState[]{r100, r101, r102, r103};
    }

    public static HuffmanState[] values() {
        return (HuffmanState[]) $VALUES.clone();
    }

    public static HuffmanState valueOf(String r100) {
        return (HuffmanState) a.a(HuffmanState.class, r100);
    }

    private HuffmanState(String r100, int r101) {
        super(r100, r101);
    }
}
