package org.apache.commons.compress.compressors.lz4;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum BlockLZ4CompressorInputStream$State extends Enum<BlockLZ4CompressorInputStream$State> {
    private static final /* synthetic */ BlockLZ4CompressorInputStream$State[] $VALUES = null;
    public static final BlockLZ4CompressorInputStream$State EOF = null;
    public static final BlockLZ4CompressorInputStream$State IN_BACK_REFERENCE = null;
    public static final BlockLZ4CompressorInputStream$State IN_LITERAL = null;
    public static final BlockLZ4CompressorInputStream$State LOOKING_FOR_BACK_REFERENCE = null;
    public static final BlockLZ4CompressorInputStream$State NO_BLOCK = null;

    static {
        BlockLZ4CompressorInputStream$State r100 = new BlockLZ4CompressorInputStream$State("NO_BLOCK", 0);
        NO_BLOCK = r100;
        BlockLZ4CompressorInputStream$State r101 = new BlockLZ4CompressorInputStream$State("IN_LITERAL", 1);
        IN_LITERAL = r101;
        BlockLZ4CompressorInputStream$State r102 = new BlockLZ4CompressorInputStream$State("LOOKING_FOR_BACK_REFERENCE", 2);
        LOOKING_FOR_BACK_REFERENCE = r102;
        BlockLZ4CompressorInputStream$State r103 = new BlockLZ4CompressorInputStream$State("IN_BACK_REFERENCE", 3);
        IN_BACK_REFERENCE = r103;
        BlockLZ4CompressorInputStream$State r104 = new BlockLZ4CompressorInputStream$State("EOF", 4);
        EOF = r104;
        $VALUES = new BlockLZ4CompressorInputStream$State[]{r100, r101, r102, r103, r104};
    }

    public static BlockLZ4CompressorInputStream$State[] values() {
        return (BlockLZ4CompressorInputStream$State[]) $VALUES.clone();
    }

    public static BlockLZ4CompressorInputStream$State valueOf(String r100) {
        return (BlockLZ4CompressorInputStream$State) a.a(BlockLZ4CompressorInputStream$State.class, r100);
    }

    private BlockLZ4CompressorInputStream$State(String r100, int r101) {
        super(r100, r101);
    }
}
