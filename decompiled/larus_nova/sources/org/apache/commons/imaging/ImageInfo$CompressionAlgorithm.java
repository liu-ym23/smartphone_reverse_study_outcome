package org.apache.commons.imaging;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ImageInfo$CompressionAlgorithm extends Enum<ImageInfo$CompressionAlgorithm> {
    private static final /* synthetic */ ImageInfo$CompressionAlgorithm[] $VALUES = null;
    public static final ImageInfo$CompressionAlgorithm ADAPTIVE_RLE = null;
    public static final ImageInfo$CompressionAlgorithm CCITT_1D = null;
    public static final ImageInfo$CompressionAlgorithm CCITT_GROUP_3 = null;
    public static final ImageInfo$CompressionAlgorithm CCITT_GROUP_4 = null;
    public static final ImageInfo$CompressionAlgorithm JPEG = null;
    public static final ImageInfo$CompressionAlgorithm LZW = null;
    public static final ImageInfo$CompressionAlgorithm NONE = null;
    public static final ImageInfo$CompressionAlgorithm PACKBITS = null;
    public static final ImageInfo$CompressionAlgorithm PNG_FILTER = null;
    public static final ImageInfo$CompressionAlgorithm PSD = null;
    public static final ImageInfo$CompressionAlgorithm RLE = null;
    public static final ImageInfo$CompressionAlgorithm UNKNOWN = null;
    private String description;

    static {
        ImageInfo$CompressionAlgorithm r100 = new ImageInfo$CompressionAlgorithm("UNKNOWN", 0, "Unknown");
        UNKNOWN = r100;
        ImageInfo$CompressionAlgorithm r101 = new ImageInfo$CompressionAlgorithm(UserProfileEvent.POSITION_NONE, 1, "None");
        NONE = r101;
        ImageInfo$CompressionAlgorithm r102 = new ImageInfo$CompressionAlgorithm("LZW", 2, "LZW");
        LZW = r102;
        ImageInfo$CompressionAlgorithm r103 = new ImageInfo$CompressionAlgorithm("PACKBITS", 3, "PackBits");
        PACKBITS = r103;
        ImageInfo$CompressionAlgorithm r104 = new ImageInfo$CompressionAlgorithm("JPEG", 4, "JPEG");
        JPEG = r104;
        ImageInfo$CompressionAlgorithm r105 = new ImageInfo$CompressionAlgorithm("RLE", 5, "RLE: Run-Length Encoding");
        RLE = r105;
        ImageInfo$CompressionAlgorithm r110 = new ImageInfo$CompressionAlgorithm("ADAPTIVE_RLE", 6, "Adaptive RLE");
        ADAPTIVE_RLE = r110;
        ImageInfo$CompressionAlgorithm r111 = new ImageInfo$CompressionAlgorithm("PSD", 7, "Photoshop");
        PSD = r111;
        ImageInfo$CompressionAlgorithm r112 = new ImageInfo$CompressionAlgorithm("PNG_FILTER", 8, "PNG Filter");
        PNG_FILTER = r112;
        ImageInfo$CompressionAlgorithm r113 = new ImageInfo$CompressionAlgorithm("CCITT_GROUP_3", 9, "CCITT Group 3 1-Dimensional Modified Huffman run-length encoding.");
        CCITT_GROUP_3 = r113;
        ImageInfo$CompressionAlgorithm r114 = new ImageInfo$CompressionAlgorithm("CCITT_GROUP_4", 10, "CCITT Group 4");
        CCITT_GROUP_4 = r114;
        ImageInfo$CompressionAlgorithm r106 = new ImageInfo$CompressionAlgorithm("CCITT_1D", 11, "CCITT 1D");
        CCITT_1D = r106;
        $VALUES = new ImageInfo$CompressionAlgorithm[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
    }

    public static ImageInfo$CompressionAlgorithm[] values() {
        return (ImageInfo$CompressionAlgorithm[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.description;
    }

    public static ImageInfo$CompressionAlgorithm valueOf(String r100) {
        return (ImageInfo$CompressionAlgorithm) a.a(ImageInfo$CompressionAlgorithm.class, r100);
    }

    private ImageInfo$CompressionAlgorithm(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
