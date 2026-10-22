package org.apache.commons.imaging.formats.icns;

import java.nio.charset.StandardCharsets;
import kotlin.UByte;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum IcnsType extends Enum<IcnsType> {
    private static final /* synthetic */ IcnsType[] $VALUES = null;
    private static final IcnsType[] ALL_IMAGE_TYPES = null;
    private static final IcnsType[] ALL_MASK_TYPES = null;
    public static final IcnsType ICNS_128x128_32BIT_IMAGE = null;
    public static final IcnsType ICNS_128x128_8BIT_MASK = null;
    public static final IcnsType ICNS_16x12_1BIT_IMAGE_AND_MASK = null;
    public static final IcnsType ICNS_16x12_4BIT_IMAGE = null;
    public static final IcnsType ICNS_16x12_8BIT_IMAGE = null;
    public static final IcnsType ICNS_16x16_1BIT_IMAGE_AND_MASK = null;
    public static final IcnsType ICNS_16x16_32BIT_IMAGE = null;
    public static final IcnsType ICNS_16x16_4BIT_IMAGE = null;
    public static final IcnsType ICNS_16x16_8BIT_IMAGE = null;
    public static final IcnsType ICNS_16x16_8BIT_MASK = null;
    public static final IcnsType ICNS_256x256_32BIT_ARGB_IMAGE = null;
    public static final IcnsType ICNS_32x32_1BIT_IMAGE_AND_MASK = null;
    public static final IcnsType ICNS_32x32_32BIT_IMAGE = null;
    public static final IcnsType ICNS_32x32_4BIT_IMAGE = null;
    public static final IcnsType ICNS_32x32_8BIT_IMAGE = null;
    public static final IcnsType ICNS_32x32_8BIT_MASK = null;
    public static final IcnsType ICNS_48x48_1BIT_IMAGE_AND_MASK = null;
    public static final IcnsType ICNS_48x48_32BIT_IMAGE = null;
    public static final IcnsType ICNS_48x48_4BIT_IMAGE = null;
    public static final IcnsType ICNS_48x48_8BIT_IMAGE = null;
    public static final IcnsType ICNS_48x48_8BIT_MASK = null;
    public static final IcnsType ICNS_512x512_32BIT_ARGB_IMAGE = null;
    private final int bitsPerPixel;
    private final boolean hasMask;
    private final int height;
    private final int type;
    private final int width;

    static {
        IcnsType r100 = new IcnsType("ICNS_16x12_1BIT_IMAGE_AND_MASK", 0, "icm#", 16, 12, 1, true);
        ICNS_16x12_1BIT_IMAGE_AND_MASK = r100;
        IcnsType r101 = new IcnsType("ICNS_16x12_4BIT_IMAGE", 1, "icm4", 16, 12, 4, false);
        ICNS_16x12_4BIT_IMAGE = r101;
        IcnsType r102 = new IcnsType("ICNS_16x12_8BIT_IMAGE", 2, "icm8", 16, 12, 8, false);
        ICNS_16x12_8BIT_IMAGE = r102;
        IcnsType r103 = new IcnsType("ICNS_16x16_8BIT_MASK", 3, "s8mk", 16, 16, 8, true);
        ICNS_16x16_8BIT_MASK = r103;
        IcnsType r104 = new IcnsType("ICNS_16x16_1BIT_IMAGE_AND_MASK", 4, "ics#", 16, 16, 1, true);
        ICNS_16x16_1BIT_IMAGE_AND_MASK = r104;
        IcnsType r105 = new IcnsType("ICNS_16x16_4BIT_IMAGE", 5, "ics4", 16, 16, 4, false);
        ICNS_16x16_4BIT_IMAGE = r105;
        IcnsType r106 = new IcnsType("ICNS_16x16_8BIT_IMAGE", 6, "ics8", 16, 16, 8, false);
        ICNS_16x16_8BIT_IMAGE = r106;
        IcnsType r107 = new IcnsType("ICNS_16x16_32BIT_IMAGE", 7, "is32", 16, 16, 32, false);
        ICNS_16x16_32BIT_IMAGE = r107;
        IcnsType r108 = new IcnsType("ICNS_32x32_8BIT_MASK", 8, "l8mk", 32, 32, 8, true);
        ICNS_32x32_8BIT_MASK = r108;
        IcnsType r110 = new IcnsType("ICNS_32x32_1BIT_IMAGE_AND_MASK", 9, "ICN#", 32, 32, 1, true);
        ICNS_32x32_1BIT_IMAGE_AND_MASK = r110;
        IcnsType r109 = new IcnsType("ICNS_32x32_4BIT_IMAGE", 10, "icl4", 32, 32, 4, false);
        ICNS_32x32_4BIT_IMAGE = r109;
        IcnsType r111 = new IcnsType("ICNS_32x32_8BIT_IMAGE", 11, "icl8", 32, 32, 8, false);
        ICNS_32x32_8BIT_IMAGE = r111;
        IcnsType r112 = new IcnsType("ICNS_32x32_32BIT_IMAGE", 12, "il32", 32, 32, 32, false);
        ICNS_32x32_32BIT_IMAGE = r112;
        IcnsType r113 = new IcnsType("ICNS_48x48_8BIT_MASK", 13, "h8mk", 48, 48, 8, true);
        ICNS_48x48_8BIT_MASK = r113;
        IcnsType r114 = new IcnsType("ICNS_48x48_1BIT_IMAGE_AND_MASK", 14, "ich#", 48, 48, 1, true);
        ICNS_48x48_1BIT_IMAGE_AND_MASK = r114;
        IcnsType r115 = new IcnsType("ICNS_48x48_4BIT_IMAGE", 15, "ich4", 48, 48, 4, false);
        ICNS_48x48_4BIT_IMAGE = r115;
        IcnsType r116 = new IcnsType("ICNS_48x48_8BIT_IMAGE", 16, "ich8", 48, 48, 8, false);
        ICNS_48x48_8BIT_IMAGE = r116;
        IcnsType r117 = new IcnsType("ICNS_48x48_32BIT_IMAGE", 17, "ih32", 48, 48, 32, false);
        ICNS_48x48_32BIT_IMAGE = r117;
        IcnsType r210 = new IcnsType("ICNS_128x128_8BIT_MASK", 18, "t8mk", 128, 128, 8, true);
        ICNS_128x128_8BIT_MASK = r210;
        IcnsType r118 = new IcnsType("ICNS_128x128_32BIT_IMAGE", 19, "it32", 128, 128, 32, false);
        ICNS_128x128_32BIT_IMAGE = r118;
        IcnsType r119 = new IcnsType("ICNS_256x256_32BIT_ARGB_IMAGE", 20, "ic08", 256, 256, 32, false);
        ICNS_256x256_32BIT_ARGB_IMAGE = r119;
        IcnsType r211 = new IcnsType("ICNS_512x512_32BIT_ARGB_IMAGE", 21, "ic09", 512, 512, 32, false);
        ICNS_512x512_32BIT_ARGB_IMAGE = r211;
        $VALUES = new IcnsType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r109, r111, r112, r113, r114, r115, r116, r117, r210, r118, r119, r211};
        ALL_IMAGE_TYPES = new IcnsType[]{r100, r101, r102, r104, r105, r106, r107, r110, r109, r111, r112, r114, r115, r116, r117, r118, r119, r211};
        ALL_MASK_TYPES = new IcnsType[]{r100, r104, r103, r110, r108, r114, r113, r210};
    }

    public static IcnsType[] values() {
        return (IcnsType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return IcnsType.class.getName() + "[width=" + this.width + ",height=" + this.height + ",bpp=" + this.bitsPerPixel + ",hasMask=" + this.hasMask + "]";
    }

    public int getBitsPerPixel() {
        return this.bitsPerPixel;
    }

    public int getHeight() {
        return this.height;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasMask() {
        return this.hasMask;
    }

    public static String describeType(int r100) {
        return new String(new byte[]{(byte) ((r100 >> 24) & 255), (byte) ((r100 >> 16) & 255), (byte) ((r100 >> 8) & 255), (byte) (r100 & 255)}, StandardCharsets.US_ASCII);
    }

    public static IcnsType find1BPPMaskType(IcnsType r100) {
        IcnsType[] r101 = ALL_MASK_TYPES;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        IcnsType r104 = r101[r103];
        if (r104.getBitsPerPixel() != 1) goto L11;
        if (r104.getWidth() != r100.getWidth()) goto L11;
        if (r104.getHeight() != r100.getHeight()) goto L11;
        return r104;
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return null;
    }

    public static IcnsType find8BPPMaskType(IcnsType r100) {
        IcnsType[] r101 = ALL_MASK_TYPES;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        IcnsType r104 = r101[r103];
        if (r104.getBitsPerPixel() != 8) goto L11;
        if (r104.getWidth() != r100.getWidth()) goto L11;
        if (r104.getHeight() != r100.getHeight()) goto L11;
        return r104;
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        return null;
    }

    public static IcnsType findAnyType(int r100) {
        IcnsType[] r101 = ALL_IMAGE_TYPES;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        IcnsType r105 = r101[r104];
        if (r105.getType() == r100) goto L6;
        r104 = r104 + 1;
        goto L3
    L6:
        return r105;
    L8:
        IcnsType[] r106 = ALL_MASK_TYPES;
        int r107 = r106.length;
    L9:
        if (r103 >= r107) goto L14;
        IcnsType r108 = r106[r103];
        if (r108.getType() == r100) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r108;
    L14:
        return null;
    }

    public static IcnsType findImageType(int r100) {
        IcnsType[] r101 = ALL_IMAGE_TYPES;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        IcnsType r104 = r101[r103];
        if (r104.getType() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static int typeAsInt(String r100) {
        byte[] r101 = r100.getBytes(StandardCharsets.US_ASCII);
        if (r101.length != 4) goto L7;
        int r102 = (((r101[0] & UByte.MAX_VALUE) << 24) | ((r101[1] & UByte.MAX_VALUE) << 16)) | ((r101[2] & UByte.MAX_VALUE) << 8);
        return (r101[3] & UByte.MAX_VALUE) | r102;
    L7:
        throw new IllegalArgumentException("Invalid ICNS type");
    }

    public static IcnsType valueOf(String r100) {
        return (IcnsType) a.a(IcnsType.class, r100);
    }

    private IcnsType(String r100, int r101, String r102, int r103, int r104, int r105, boolean r106) {
        super(r100, r101);
        this.type = typeAsInt(r102);
        this.width = r103;
        this.height = r104;
        this.bitsPerPixel = r105;
        this.hasMask = r106;
    }
}
