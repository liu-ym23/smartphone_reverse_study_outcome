package com.facebook.imageformat;

import com.facebook.common.internal.ImmutableList;
import com.facebook.imageutils.AvifFormatUtil;
import com.facebook.imageutils.HeifFormatUtil;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class DefaultImageFormats {
    public static final ImageFormat BMP = null;
    public static final ImageFormat DNG = null;
    public static final ImageFormat GIF = null;
    public static final ImageFormat HEIF = null;
    public static final ImageFormat HEIF_FORMAT = null;
    public static final ImageFormat ICO = null;
    public static final ImageFormat JPEG = null;
    public static final ImageFormat PNG = null;
    public static final ImageFormat VVIC_FORMAT = null;
    public static final ImageFormat WEBP_ANIMATED = null;
    public static final ImageFormat WEBP_EXTENDED = null;
    public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA = null;
    public static final ImageFormat WEBP_LOSSLESS = null;
    public static final ImageFormat WEBP_SIMPLE = null;
    private static ImmutableList<ImageFormat> sAllDefaultFormats;

    static {
        JPEG = new ImageFormat("JPEG", LoadParams.ImageFormat.JPEG);
        PNG = new ImageFormat("PNG", LoadParams.ImageFormat.PNG);
        GIF = new ImageFormat("GIF", "gif");
        BMP = new ImageFormat("BMP", "bmp");
        ICO = new ImageFormat("ICO", "ico");
        WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", "webp");
        WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", "webp");
        WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", "webp");
        WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", "webp");
        WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", "webp");
        HEIF = new ImageFormat("HEIF", "heif");
        HEIF_FORMAT = new ImageFormat("HEIF_FORMAT", "heic");
        VVIC_FORMAT = new ImageFormat("VVIC_FORMAT", "vvic");
        DNG = new ImageFormat("DNG", "dng");
    }

    public static List<ImageFormat> getDefaultFormats() {
        if (sAllDefaultFormats != null) goto L6;
        ArrayList r100 = new ArrayList(9);
        r100.add(JPEG);
        r100.add(PNG);
        r100.add(GIF);
        r100.add(BMP);
        r100.add(ICO);
        r100.add(WEBP_SIMPLE);
        r100.add(WEBP_LOSSLESS);
        r100.add(WEBP_EXTENDED);
        r100.add(WEBP_EXTENDED_WITH_ALPHA);
        r100.add(WEBP_ANIMATED);
        r100.add(HEIF);
        sAllDefaultFormats = ImmutableList.copyOf(r100);
    L6:
        return sAllDefaultFormats;
    }

    private DefaultImageFormats() {
    }

    public static boolean isAvifFormat(ImageFormat r100) {
        if (r100 != AvifFormatUtil.getAvifFormat()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAvifFormatAnimated(ImageFormat r100) {
        if (r100 != AvifFormatUtil.getAvifFormatAnimated()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAvifOrAvis(ImageFormat r100) {
        if (isAvifFormat(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (isAvifFormatAnimated(r100) == true) goto L8;
        return false;
    }

    public static boolean isHeifFormat(ImageFormat r100) {
        ImageFormat r101 = HeifFormatUtil.getHeifFormat();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isHeifFormatAnimated(ImageFormat r100) {
        ImageFormat r101 = HeifFormatUtil.getHeifFormatAnimated();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isStaticWebpFormat(ImageFormat r100) {
        if (r100 != WEBP_SIMPLE) goto L5;
    L12:
        return true;
    L5:
        if (r100 == WEBP_LOSSLESS) goto L12;
        if (r100 == WEBP_EXTENDED) goto L12;
        if (r100 == WEBP_EXTENDED_WITH_ALPHA) goto L12;
        return false;
    }

    public static boolean isVvifFormat(ImageFormat r100) {
        ImageFormat r101 = HeifFormatUtil.getVvifFormat();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r100 != r101) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean isWebpFormat(ImageFormat r100) {
        if (isStaticWebpFormat(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == WEBP_ANIMATED) goto L8;
        return false;
    }
}
