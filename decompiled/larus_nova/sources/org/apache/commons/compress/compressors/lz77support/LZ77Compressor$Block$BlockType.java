package org.apache.commons.compress.compressors.lz77support;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LZ77Compressor$Block$BlockType extends Enum<LZ77Compressor$Block$BlockType> {
    private static final /* synthetic */ LZ77Compressor$Block$BlockType[] $VALUES = null;
    public static final LZ77Compressor$Block$BlockType BACK_REFERENCE = null;
    public static final LZ77Compressor$Block$BlockType EOD = null;
    public static final LZ77Compressor$Block$BlockType LITERAL = null;

    static {
        LZ77Compressor$Block$BlockType r100 = new LZ77Compressor$Block$BlockType("LITERAL", 0);
        LITERAL = r100;
        LZ77Compressor$Block$BlockType r101 = new LZ77Compressor$Block$BlockType("BACK_REFERENCE", 1);
        BACK_REFERENCE = r101;
        LZ77Compressor$Block$BlockType r102 = new LZ77Compressor$Block$BlockType("EOD", 2);
        EOD = r102;
        $VALUES = new LZ77Compressor$Block$BlockType[]{r100, r101, r102};
    }

    public static LZ77Compressor$Block$BlockType[] values() {
        return (LZ77Compressor$Block$BlockType[]) $VALUES.clone();
    }

    public static LZ77Compressor$Block$BlockType valueOf(String r100) {
        return (LZ77Compressor$Block$BlockType) a.a(LZ77Compressor$Block$BlockType.class, r100);
    }

    private LZ77Compressor$Block$BlockType(String r100, int r101) {
        super(r100, r101);
    }
}
