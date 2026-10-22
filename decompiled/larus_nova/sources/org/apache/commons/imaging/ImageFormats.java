package org.apache.commons.imaging;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ImageFormats extends Enum<ImageFormats> {
    private static final /* synthetic */ ImageFormats[] $VALUES = null;
    public static final ImageFormats BMP = null;
    public static final ImageFormats DCX = null;
    public static final ImageFormats GIF = null;
    public static final ImageFormats ICNS = null;
    public static final ImageFormats ICO = null;
    public static final ImageFormats JBIG2 = null;
    public static final ImageFormats JPEG = null;
    public static final ImageFormats PAM = null;
    public static final ImageFormats PBM = null;
    public static final ImageFormats PCX = null;
    public static final ImageFormats PGM = null;
    public static final ImageFormats PNG = null;
    public static final ImageFormats PNM = null;
    public static final ImageFormats PPM = null;
    public static final ImageFormats PSD = null;
    public static final ImageFormats RGBE = null;
    public static final ImageFormats TGA = null;
    public static final ImageFormats TIFF = null;
    public static final ImageFormats UNKNOWN = null;
    public static final ImageFormats WBMP = null;
    public static final ImageFormats XBM = null;
    public static final ImageFormats XPM = null;

    static {
        ImageFormats r100 = new ImageFormats("UNKNOWN", 0);
        UNKNOWN = r100;
        ImageFormats r101 = new ImageFormats("BMP", 1);
        BMP = r101;
        ImageFormats r102 = new ImageFormats("DCX", 2);
        DCX = r102;
        ImageFormats r103 = new ImageFormats("GIF", 3);
        GIF = r103;
        ImageFormats r104 = new ImageFormats("ICNS", 4);
        ICNS = r104;
        ImageFormats r105 = new ImageFormats("ICO", 5);
        ICO = r105;
        ImageFormats r110 = new ImageFormats("JBIG2", 6);
        JBIG2 = r110;
        ImageFormats r111 = new ImageFormats("JPEG", 7);
        JPEG = r111;
        ImageFormats r112 = new ImageFormats("PAM", 8);
        PAM = r112;
        ImageFormats r113 = new ImageFormats("PSD", 9);
        PSD = r113;
        ImageFormats r114 = new ImageFormats("PBM", 10);
        PBM = r114;
        ImageFormats r115 = new ImageFormats("PGM", 11);
        PGM = r115;
        ImageFormats r106 = new ImageFormats("PNM", 12);
        PNM = r106;
        ImageFormats r107 = new ImageFormats("PPM", 13);
        PPM = r107;
        ImageFormats r108 = new ImageFormats("PCX", 14);
        PCX = r108;
        ImageFormats r109 = new ImageFormats("PNG", 15);
        PNG = r109;
        ImageFormats r116 = new ImageFormats("RGBE", 16);
        RGBE = r116;
        ImageFormats r117 = new ImageFormats("TGA", 17);
        TGA = r117;
        ImageFormats r118 = new ImageFormats("TIFF", 18);
        TIFF = r118;
        ImageFormats r119 = new ImageFormats("WBMP", 19);
        WBMP = r119;
        ImageFormats r120 = new ImageFormats("XBM", 20);
        XBM = r120;
        ImageFormats r121 = new ImageFormats("XPM", 21);
        XPM = r121;
        $VALUES = new ImageFormats[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121};
    }

    public static ImageFormats[] values() {
        return (ImageFormats[]) $VALUES.clone();
    }

    public String getExtension() {
        return name();
    }

    public String getName() {
        return name();
    }

    public static ImageFormats valueOf(String r100) {
        return (ImageFormats) a.a(ImageFormats.class, r100);
    }

    private ImageFormats(String r100, int r101) {
        super(r100, r101);
    }
}
