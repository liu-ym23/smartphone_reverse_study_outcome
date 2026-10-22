package com.facebook.imageformat;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.facebook.common.internal.Ints;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    private static final byte[] BMP_HEADER = null;
    private static final int BMP_HEADER_LENGTH = 0;
    private static final byte[] DNG_HEADER_II = null;
    private static final byte[] DNG_HEADER_MM = null;
    private static final int EXTENDED_WEBP_HEADER_LENGTH = 21;
    private static final byte[] GIF_HEADER_87A = null;
    private static final byte[] GIF_HEADER_89A = null;
    private static final int GIF_HEADER_LENGTH = 6;
    private static final int HEIF_HEADER_LENGTH = 0;
    private static final String HEIF_HEADER_PREFIX = "ftyp";
    private static final String[] HEIF_HEADER_SUFFIXES = null;
    private static final byte[] ICO_HEADER = null;
    private static final int ICO_HEADER_LENGTH = 0;
    private static final byte[] JPEG_HEADER = null;
    private static final int JPEG_HEADER_LENGTH = 0;
    private static final byte[] PNG_HEADER = null;
    private static final int PNG_HEADER_LENGTH = 0;
    private static final int SIMPLE_WEBP_HEADER_LENGTH = 20;
    final int MAX_HEADER_LENGTH;

    static {
        byte[] r100 = {-1, -40, -1};
        JPEG_HEADER = r100;
        JPEG_HEADER_LENGTH = r100.length;
        byte[] r101 = {-119, 80, 78, 71, HTTP.CR, 10, 26, 10};
        PNG_HEADER = r101;
        PNG_HEADER_LENGTH = r101.length;
        GIF_HEADER_87A = ImageFormatCheckerUtils.asciiBytes("GIF87a");
        GIF_HEADER_89A = ImageFormatCheckerUtils.asciiBytes("GIF89a");
        byte[] r102 = ImageFormatCheckerUtils.asciiBytes("BM");
        BMP_HEADER = r102;
        BMP_HEADER_LENGTH = r102.length;
        byte[] r103 = {0, 0, 1, 0};
        ICO_HEADER = r103;
        ICO_HEADER_LENGTH = r103.length;
        String[] r104 = {"heic", "heix", "hevc", "hevx", "mif1", "msf1"};
        HEIF_HEADER_SUFFIXES = r104;
        HEIF_HEADER_LENGTH = ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + r104[0]).length;
        DNG_HEADER_II = new byte[]{73, 73, 42, 0};
        DNG_HEADER_MM = new byte[]{77, 77, 0, 42};
    }

    public DefaultImageFormatChecker() {
        this.MAX_HEADER_LENGTH = Ints.max(new int[]{21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, HEIF_HEADER_LENGTH});
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.MAX_HEADER_LENGTH;
    }

    private static ImageFormat getWebpFormat(byte[] r100, int r101) {
        Preconditions.checkArgument(WebpSupportStatus.isWebpHeader(r100, 0, r101));
        if (WebpSupportStatus.isSimpleWebpHeader(r100, 0) == false) goto L7;
        return DefaultImageFormats.WEBP_SIMPLE;
    L7:
        if (WebpSupportStatus.isLosslessWebpHeader(r100, 0) == false) goto L11;
        return DefaultImageFormats.WEBP_LOSSLESS;
    L11:
        if (WebpSupportStatus.isExtendedWebpHeader(r100, 0, r101) == false) goto L23;
        if (WebpSupportStatus.isAnimatedWebpHeader(r100, 0) == false) goto L17;
        return DefaultImageFormats.WEBP_ANIMATED;
    L17:
        if (WebpSupportStatus.isExtendedWebpHeaderWithAlpha(r100, 0) == false) goto L21;
        return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
    L21:
        return DefaultImageFormats.WEBP_EXTENDED;
    L23:
        return ImageFormat.UNKNOWN;
    }

    private static boolean isBmpHeader(byte[] r100, int r101) {
        byte[] r102 = BMP_HEADER;
        if (r101 >= r102.length) goto L7;
        return false;
    L7:
        return ImageFormatCheckerUtils.startsWithPattern(r100, r102);
    }

    private static boolean isDngHeader(byte[] r100, int r101) {
        byte[] r102 = DNG_HEADER_II;
        if (r101 >= r102.length) goto L8;
        if (r101 >= DNG_HEADER_MM.length) goto L8;
        return false;
    L8:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, r102) == false) goto L10;
    L11:
        return true;
    L10:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, DNG_HEADER_MM) == true) goto L11;
        return false;
    }

    private static boolean isGifHeader(byte[] r100, int r101) {
        if (r101 >= 6) goto L6;
        return false;
    L6:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, GIF_HEADER_87A) == false) goto L8;
    L9:
        return true;
    L8:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, GIF_HEADER_89A) == true) goto L9;
        return false;
    }

    private static boolean isHeifHeader(byte[] r100, int r101) {
        if (r101 >= HEIF_HEADER_LENGTH) goto L6;
        return false;
    L6:
        if (r100[3] >= 8) goto L8;
        return false;
    L8:
        String[] r102 = HEIF_HEADER_SUFFIXES;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        String r105 = r102[r104];
        if (ImageFormatCheckerUtils.indexOfPattern(r100, r100.length, ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + r105), HEIF_HEADER_LENGTH) > (-1)) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    private static boolean isIcoHeader(byte[] r100, int r101) {
        byte[] r102 = ICO_HEADER;
        if (r101 >= r102.length) goto L7;
        return false;
    L7:
        return ImageFormatCheckerUtils.startsWithPattern(r100, r102);
    }

    private static boolean isJpegHeader(byte[] r100, int r101) {
        byte[] r102 = JPEG_HEADER;
        if (r101 >= r102.length) goto L5;
    L7:
        return false;
    L5:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, r102) == false) goto L7;
        return true;
    }

    private static boolean isPngHeader(byte[] r100, int r101) {
        byte[] r102 = PNG_HEADER;
        if (r101 >= r102.length) goto L5;
    L7:
        return false;
    L5:
        if (ImageFormatCheckerUtils.startsWithPattern(r100, r102) == false) goto L7;
        return true;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    @Nullable
    public final ImageFormat determineFormat(byte[] r100, int r101) {
        Preconditions.checkNotNull(r100);
        if (WebpSupportStatus.isWebpHeader(r100, 0, r101) == false) goto L7;
        return getWebpFormat(r100, r101);
    L7:
        if (isJpegHeader(r100, r101) == false) goto L11;
        return DefaultImageFormats.JPEG;
    L11:
        if (isPngHeader(r100, r101) == false) goto L15;
        return DefaultImageFormats.PNG;
    L15:
        if (isGifHeader(r100, r101) == false) goto L19;
        return DefaultImageFormats.GIF;
    L19:
        if (isBmpHeader(r100, r101) == false) goto L23;
        return DefaultImageFormats.BMP;
    L23:
        if (isIcoHeader(r100, r101) == false) goto L27;
        return DefaultImageFormats.ICO;
    L27:
        if (isHeifHeader(r100, r101) == false) goto L31;
        return DefaultImageFormats.HEIF;
    L31:
        if (isDngHeader(r100, r101) == false) goto L35;
        return DefaultImageFormats.DNG;
    L35:
        return ImageFormat.UNKNOWN;
    }
}
