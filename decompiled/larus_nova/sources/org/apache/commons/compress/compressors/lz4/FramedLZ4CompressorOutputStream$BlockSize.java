package org.apache.commons.compress.compressors.lz4;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum FramedLZ4CompressorOutputStream$BlockSize extends Enum<FramedLZ4CompressorOutputStream$BlockSize> {
    private static final /* synthetic */ FramedLZ4CompressorOutputStream$BlockSize[] $VALUES = null;
    public static final FramedLZ4CompressorOutputStream$BlockSize K256 = null;
    public static final FramedLZ4CompressorOutputStream$BlockSize K64 = null;
    public static final FramedLZ4CompressorOutputStream$BlockSize M1 = null;
    public static final FramedLZ4CompressorOutputStream$BlockSize M4 = null;
    private final int index;
    private final int size;

    static {
        FramedLZ4CompressorOutputStream$BlockSize r100 = new FramedLZ4CompressorOutputStream$BlockSize("K64", 0, 65536, 4);
        K64 = r100;
        FramedLZ4CompressorOutputStream$BlockSize r101 = new FramedLZ4CompressorOutputStream$BlockSize("K256", 1, 262144, 5);
        K256 = r101;
        FramedLZ4CompressorOutputStream$BlockSize r102 = new FramedLZ4CompressorOutputStream$BlockSize("M1", 2, 1048576, 6);
        M1 = r102;
        FramedLZ4CompressorOutputStream$BlockSize r103 = new FramedLZ4CompressorOutputStream$BlockSize("M4", 3, 4194304, 7);
        M4 = r103;
        $VALUES = new FramedLZ4CompressorOutputStream$BlockSize[]{r100, r101, r102, r103};
    }

    public static FramedLZ4CompressorOutputStream$BlockSize[] values() {
        return (FramedLZ4CompressorOutputStream$BlockSize[]) $VALUES.clone();
    }

    public int getIndex() {
        return this.index;
    }

    public int getSize() {
        return this.size;
    }

    public static FramedLZ4CompressorOutputStream$BlockSize valueOf(String r100) {
        return (FramedLZ4CompressorOutputStream$BlockSize) a.a(FramedLZ4CompressorOutputStream$BlockSize.class, r100);
    }

    private FramedLZ4CompressorOutputStream$BlockSize(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.size = r102;
        this.index = r103;
    }
}
