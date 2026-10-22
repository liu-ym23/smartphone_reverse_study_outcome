package org.apache.commons.imaging;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ImageInfo$ColorType extends Enum<ImageInfo$ColorType> {
    private static final /* synthetic */ ImageInfo$ColorType[] $VALUES = null;
    public static final ImageInfo$ColorType BW = null;
    public static final ImageInfo$ColorType CMYK = null;
    public static final ImageInfo$ColorType GRAYSCALE = null;
    public static final ImageInfo$ColorType OTHER = null;
    public static final ImageInfo$ColorType RGB = null;
    public static final ImageInfo$ColorType UNKNOWN = null;
    public static final ImageInfo$ColorType YCC = null;
    public static final ImageInfo$ColorType YCCK = null;
    public static final ImageInfo$ColorType YCbCr = null;
    private String description;

    static {
        ImageInfo$ColorType r100 = new ImageInfo$ColorType("BW", 0, "Black and White");
        BW = r100;
        ImageInfo$ColorType r101 = new ImageInfo$ColorType("GRAYSCALE", 1, "Grayscale");
        GRAYSCALE = r101;
        ImageInfo$ColorType r102 = new ImageInfo$ColorType("RGB", 2, "RGB");
        RGB = r102;
        ImageInfo$ColorType r103 = new ImageInfo$ColorType("CMYK", 3, "CMYK");
        CMYK = r103;
        ImageInfo$ColorType r104 = new ImageInfo$ColorType("YCbCr", 4, "YCbCr");
        YCbCr = r104;
        ImageInfo$ColorType r105 = new ImageInfo$ColorType("YCCK", 5, "YCCK");
        YCCK = r105;
        ImageInfo$ColorType r110 = new ImageInfo$ColorType("YCC", 6, "YCC");
        YCC = r110;
        ImageInfo$ColorType r111 = new ImageInfo$ColorType(FlowDoraWifiScene.OTHER, 7, "Other");
        OTHER = r111;
        ImageInfo$ColorType r112 = new ImageInfo$ColorType("UNKNOWN", 8, "Unknown");
        UNKNOWN = r112;
        $VALUES = new ImageInfo$ColorType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public static ImageInfo$ColorType[] values() {
        return (ImageInfo$ColorType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }

    public static ImageInfo$ColorType valueOf(String r100) {
        return (ImageInfo$ColorType) a.a(ImageInfo$ColorType.class, r100);
    }

    private ImageInfo$ColorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
