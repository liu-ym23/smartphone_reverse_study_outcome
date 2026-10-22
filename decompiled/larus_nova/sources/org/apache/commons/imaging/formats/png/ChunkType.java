package org.apache.commons.imaging.formats.png;

import java.nio.charset.StandardCharsets;
import org.apache.commons.imaging.common.BinaryFunctions;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ChunkType extends Enum<ChunkType> {
    private static final /* synthetic */ ChunkType[] $VALUES = null;
    public static final ChunkType IDAT = null;
    public static final ChunkType IEND = null;
    public static final ChunkType IHDR = null;
    public static final ChunkType PLTE = null;
    public static final ChunkType bKGD = null;
    public static final ChunkType cHRM = null;
    public static final ChunkType gAMA = null;
    public static final ChunkType hIST = null;
    public static final ChunkType iCCP = null;
    public static final ChunkType iTXt = null;
    public static final ChunkType pHYs = null;
    public static final ChunkType sBIT = null;
    public static final ChunkType sCAL = null;
    public static final ChunkType sPLT = null;
    public static final ChunkType sRGB = null;
    public static final ChunkType tEXt = null;
    public static final ChunkType tIME = null;
    public static final ChunkType tRNS = null;
    public static final ChunkType zTXt = null;
    final byte[] array;
    final int value;

    static {
        ChunkType r100 = new ChunkType("IHDR", 0);
        IHDR = r100;
        ChunkType r101 = new ChunkType("PLTE", 1);
        PLTE = r101;
        ChunkType r102 = new ChunkType("IDAT", 2);
        IDAT = r102;
        ChunkType r103 = new ChunkType("IEND", 3);
        IEND = r103;
        ChunkType r104 = new ChunkType("tRNS", 4);
        tRNS = r104;
        ChunkType r105 = new ChunkType("cHRM", 5);
        cHRM = r105;
        ChunkType r110 = new ChunkType("gAMA", 6);
        gAMA = r110;
        ChunkType r111 = new ChunkType("iCCP", 7);
        iCCP = r111;
        ChunkType r112 = new ChunkType("sBIT", 8);
        sBIT = r112;
        ChunkType r113 = new ChunkType("sRGB", 9);
        sRGB = r113;
        ChunkType r114 = new ChunkType("tEXt", 10);
        tEXt = r114;
        ChunkType r115 = new ChunkType("zTXt", 11);
        zTXt = r115;
        ChunkType r106 = new ChunkType("iTXt", 12);
        iTXt = r106;
        ChunkType r107 = new ChunkType("bKGD", 13);
        bKGD = r107;
        ChunkType r108 = new ChunkType("hIST", 14);
        hIST = r108;
        ChunkType r109 = new ChunkType("pHYs", 15);
        pHYs = r109;
        ChunkType r116 = new ChunkType("sCAL", 16);
        sCAL = r116;
        ChunkType r117 = new ChunkType("sPLT", 17);
        sPLT = r117;
        ChunkType r118 = new ChunkType("tIME", 18);
        tIME = r118;
        $VALUES = new ChunkType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
    }

    public static ChunkType[] values() {
        return (ChunkType[]) $VALUES.clone();
    }

    public static ChunkType valueOf(String r100) {
        return (ChunkType) a.a(ChunkType.class, r100);
    }

    private ChunkType(String r100, int r101) {
        super(r100, r101);
        char[] r102 = name().toCharArray();
        this.array = name().getBytes(StandardCharsets.UTF_8);
        this.value = BinaryFunctions.charsToQuad(r102[0], r102[1], r102[2], r102[3]);
    }
}
