package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes23.dex */
public class AlphaChecker {
    private AlphaChecker() {
    }

    private static boolean hasAlphaForAWebp(InputStream r100) throws IOException {
        int r101 = ImageFormatChecker.getInstance().getMaxHeaderLength();
        byte[] r102 = new byte[r101];
        readHeaderFromStream(r101, r100, r102);
        return WebpSupportStatus.isExtendedWebpHeaderWithAlpha(r102, 0);
    }

    public static boolean hasAlphaForHeif(InputStream r100) {
        boolean r101 = true;
        int[] r102 = HeifFormatUtil.readHeifFormatImageSizeForSimple(r100);     // Catch: IOException -> L11
        if (r102 != null) goto L6;
    L9:
        r100.reset();     // Catch: IOException -> L11
        goto L10
    L6:
        if (r102[8] != 0) goto L9;
        r101 = false;
    L10:
        return r101;
    }

    private static boolean hasAlphaForPNG(InputStream r100) throws IOException {
        byte[] r101 = new byte[29];
        readHeaderFromStream(29, r100, r101);
        byte r102 = r101[25];
        if (r102 != 4) goto L5;
    L8:
        return true;
    L5:
        if (r102 == 6) goto L8;
        return false;
    }

    public static boolean hasAlphaForHeif(long r100, int r101) {
        int[] r102 = HeifFormatUtil.readHeifFormatImageSizeForSimple(r100, r101);
        if (r102 != null) goto L5;
        return true;
    L5:
        if (r102[8] == 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean hasAlpha(ImageFormat r100, InputStream r101, boolean r102) {
    L50:
        return true;
    L4:
        if (r100 != DefaultImageFormats.JPEG) goto L6;
        return false;
    L6:
        if (r100 != DefaultImageFormats.WEBP_SIMPLE) goto L8;
        return false;
    L8:
        if (r100 == DefaultImageFormats.WEBP_EXTENDED) goto L53;
        if (r102 == false) goto L27;
        if (r100 == null) goto L27;
        if (r100 == DefaultImageFormats.HEIF_FORMAT) goto L25;
        if (r100 == DefaultImageFormats.HEIF) goto L25;
        if ("HEIF_FORMAT".equals(r100.toString()) == true) goto L25;
        if ("HEIF".equals(r100.toString()) == true) goto L25;
        if (r100 == DefaultImageFormats.VVIC_FORMAT) goto L25;
        if ("VVIC_FORMAT".equals(r100.toString()) == false) goto L27;
    L25:
        return hasAlphaForHeif(r101);
    L27:
        if (r100 != DefaultImageFormats.HEIF_FORMAT) goto L29;
    L47:
        return true;
    L29:
        if (r100 == DefaultImageFormats.GIF) goto L47;
        if (r100 == DefaultImageFormats.HEIF) goto L47;
        if (r100 == DefaultImageFormats.BMP) goto L47;
        if (r100 == DefaultImageFormats.ICO) goto L47;
        if (r100 == DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) goto L47;
        if (r100 != DefaultImageFormats.PNG) goto L44;
        return hasAlphaForPNG(r101);
    L44:
        if (r100 != DefaultImageFormats.WEBP_ANIMATED) goto L47;
        return hasAlphaForAWebp(r101);
    L53:
        return false;
    }

    private static int readHeaderFromStream(int r100, InputStream r101, byte[] r102) throws IOException {
        Preconditions.checkNotNull(r101);
        Preconditions.checkNotNull(r102);
        if (r102.length < r100) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103);
        if (r101.markSupported() == false) goto L15;
        r101.mark(r100);     // Catch: Throwable -> L11
        int r104 = ByteStreams.read(r101, r102, 0, r100);     // Catch: Throwable -> L11
        r101.reset();
        return r104;
    L11:
        th = move-exception;
        r101.reset();
        throw th;
    L15:
        return ByteStreams.read(r101, r102, 0, r100);
    L5:
        r103 = false;
        goto L6
    }
}
