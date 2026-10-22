package org.apache.commons.imaging.formats.png;

import java.util.Arrays;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PngColorType extends Enum<PngColorType> {
    private static final /* synthetic */ PngColorType[] $VALUES = null;
    public static final PngColorType GREYSCALE = null;
    public static final PngColorType GREYSCALE_WITH_ALPHA = null;
    public static final PngColorType INDEXED_COLOR = null;
    public static final PngColorType TRUE_COLOR = null;
    public static final PngColorType TRUE_COLOR_WITH_ALPHA = null;
    private final int[] allowedBitDepths;
    private final boolean alpha;
    private final boolean greyscale;
    private final int samplesPerPixel;
    private final int value;

    static {
        PngColorType r100 = new PngColorType("GREYSCALE", 0, 0, true, false, 1, new int[]{1, 2, 4, 8, 16});
        GREYSCALE = r100;
        PngColorType r101 = new PngColorType("TRUE_COLOR", 1, 2, false, false, 3, new int[]{8, 16});
        TRUE_COLOR = r101;
        PngColorType r102 = new PngColorType("INDEXED_COLOR", 2, 3, false, false, 1, new int[]{1, 2, 4, 8});
        INDEXED_COLOR = r102;
        PngColorType r103 = new PngColorType("GREYSCALE_WITH_ALPHA", 3, 4, true, true, 2, new int[]{8, 16});
        GREYSCALE_WITH_ALPHA = r103;
        PngColorType r104 = new PngColorType("TRUE_COLOR_WITH_ALPHA", 4, 6, false, true, 4, new int[]{8, 16});
        TRUE_COLOR_WITH_ALPHA = r104;
        $VALUES = new PngColorType[]{r100, r101, r102, r103, r104};
    }

    public static PngColorType[] values() {
        return (PngColorType[]) $VALUES.clone();
    }

    public int getSamplesPerPixel() {
        return this.samplesPerPixel;
    }

    public int getValue() {
        return this.value;
    }

    public boolean hasAlpha() {
        return this.alpha;
    }

    public boolean isGreyscale() {
        return this.greyscale;
    }

    public static PngColorType getColorType(int r100) {
        PngColorType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PngColorType r104 = r101[r103];
        if (r104.value == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PngColorType valueOf(String r100) {
        return (PngColorType) a.a(PngColorType.class, r100);
    }

    public boolean isBitDepthAllowed(int r100) {
        if (Arrays.binarySearch(this.allowedBitDepths, r100) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static PngColorType getColorType(boolean r100, boolean r101) {
        if (r101 == false) goto L8;
        if (r100 == false) goto L7;
        return GREYSCALE_WITH_ALPHA;
    L7:
        return GREYSCALE;
    L8:
        if (r100 == false) goto L12;
        return TRUE_COLOR_WITH_ALPHA;
    L12:
        return TRUE_COLOR;
    }

    private PngColorType(String r100, int r101, int r102, boolean r103, boolean r104, int r105, int[] r106) {
        super(r100, r101);
        this.value = r102;
        this.greyscale = r103;
        this.alpha = r104;
        this.samplesPerPixel = r105;
        this.allowedBitDepths = r106;
    }
}
