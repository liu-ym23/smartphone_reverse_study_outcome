package com.optimize.statistics;

import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.platform.model.upload.ResourceUploadError;
import java.io.IOException;

/* JADX INFO: loaded from: classes34.dex */
class ImageMonitorUtils {
    private static final int CACHE_CHOICE_DEFAULT = 0;
    private static final int CACHE_CHOICE_SMALL = 1;
    private static final int DECODE = 300;
    private static final int DECODE_ARGUMENT_BYTEBUFFER = 301;
    private static final int DECODE_ARGUMENT_DEMUXER = 302;
    private static final int DECODE_ARGUMENT_EXIST_BITMAP = 304;
    private static final int DECODE_ARGUMENT_NEGATIVE = 303;
    private static final int DECODE_RUNTIME_MALFORMED = 317;
    private static final int DECODE_RUNTIME_PIXEL = 318;
    private static final int DECODE_STATE_BAD_BITMAP = 310;
    private static final int DECODE_STATE_DIMENSIONS = 305;
    private static final int DECODE_STATE_DISPOSED = 308;
    private static final int DECODE_STATE_FORMAT = 312;
    private static final int DECODE_STATE_FRAME = 315;
    private static final int DECODE_STATE_GET_FAME = 309;
    private static final int DECODE_STATE_NO_FAMES = 307;
    private static final int DECODE_STATE_SLURP = 306;
    private static final int DECODE_STATE_SMALL = 311;
    private static final int DECODE_STATE_WEBP_FACTORY = 316;
    private static final int DECODE_STATE_WEBP_FEATURES = 314;
    private static final int DECODE_STATE_WEBP_INIT = 313;
    static final int IMAGE_ORIGIN_UNKNOWN = 7;
    private static final int IO = 200;
    private static final int IO_EXCEPTION = 201;
    private static final int NETWORK = 100;
    private static final int OTHER = 600;
    private static final int OTHER_MEMORY = 602;
    private static final int OTHER_TOOMANYBITMAPS_EXCEPTION = 601;
    private static final int STATUS_CANCEL = 2;
    private static final int STATUS_ERROR = 1;
    private static final int STATUS_NETWORK_NOT_AVAILABLE = 3;
    static final int STATUS_SUCCESS = 0;
    private static final int THREAD = 500;
    private static final int THREAD_INTERRUPTED_EXCEPTION = 501;
    private static final int TRANSCODE = 400;
    private static final int TRANSCODE_PIXEL = 401;
    private static final int TRANSCODE_SCANLINE = 402;
    private static final int UNKNOWN = 700;

    public ImageMonitorUtils() {
    }

    public static int getImageMonitorDataStatus(Throwable r100) {
        if (r100 == null) goto L18;
        String r101 = r100.getMessage();
        if (r101 != null) goto L6;
        return 1;
    L6:
        if (r101.length() != 0) goto L8;
        return 1;
    L8:
        if (r101.contains(ResourceUploadError.CANCELED) == false) goto L10;
        return 2;
    L10:
        if (r101.contains("Canceled") == false) goto L13;
        return 2;
    L13:
        if (r101.contains("network not available") == false) goto L23;
        return 3;
    L23:
        return 1;
    L18:
        return 1;
    }

    public static int mapCacheChoiceToDiskCacheType(ImageRequest.CacheChoice r100) {
        if (r100.equals(ImageRequest.CacheChoice.DEFAULT) == false) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int mapProducerNameToImageMonitorOrigin(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1914072202: goto L30;
            case -1307634203: goto L26;
            case -1224383234: goto L22;
            case 656304759: goto L18;
            case 957714404: goto L14;
            case 1023071510: goto L10;
            case 2109593398: goto L6;
            default: goto L33;
        };
    L33:
        switch(r101) {
            case 0: goto L39;
            case 1: goto L38;
            case 2: goto L37;
            case 3: goto L36;
            case 4: goto L39;
            case 5: goto L41;
            case 6: goto L35;
            default: goto L34;
        };
    L34:
        return 7;
    L35:
        return 2;
    L36:
        return 3;
    L37:
        return 1;
    L38:
        return 4;
    L39:
        return 5;
    L41:
        return 6;
    L6:
        if (r100.equals(PartialDiskCacheProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 6;
        goto L33
    L10:
        if (r100.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 5;
        goto L33
    L14:
        if (r100.equals(BitmapMemoryCacheProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 4;
        goto L33
    L18:
        if (r100.equals(DiskCacheReadProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 3;
        goto L33
    L22:
        if (r100.equals(NetworkFetchProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 2;
        goto L33
    L26:
        if (r100.equals(EncodedMemoryCacheProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 1;
        goto L33
    L30:
        if (r100.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME) == false) goto L33;
        r101 = 0;
        goto L33
    }

    public static int getImageLoadErrorCode(Throwable r100, boolean r101) {
        if (r100 != null) goto L5;
        return 700;
    L5:
        String r102 = r100.getMessage();
        if (r101 == false) goto L9;
        return 100;
    L9:
        if ((r100 instanceof IOException) == false) goto L12;
        return 201;
    L12:
        if ((r100 instanceof InterruptedException) == false) goto L15;
        return 501;
    L15:
        if ((r100 instanceof TooManyBitmapsException) == false) goto L18;
        return 601;
    L18:
        if ((r100 instanceof IllegalArgumentException) == false) goto L32;
        if (r102.contains("ByteBuffer must be direct") == false) goto L23;
        return 301;
    L23:
        if (r102.contains("Failed to create demuxer") == false) goto L26;
        return 302;
    L26:
        if (r102.contains("Width or height is negative") == false) goto L29;
        return 303;
    L29:
        if (r102.contains("Problem decoding into existing bitmap") == false) goto L94;
        return 304;
    L94:
        return 700;
    L32:
        if ((r100 instanceof IllegalStateException) == false) goto L70;
        if (r102.contains("Invalid dimensions") == false) goto L37;
        return 305;
    L37:
        if (r102.contains("Failed to slurp image") == false) goto L40;
        return 306;
    L40:
        if (r102.contains("No fames in image") == false) goto L43;
        return 307;
    L43:
        if (r102.contains("Already disposed") == false) goto L46;
        return 308;
    L46:
        if (r102.contains("unable to get frame") == false) goto L49;
        return 309;
    L49:
        if (r102.contains("Bad bitmap") == false) goto L52;
        return 310;
    L52:
        if (r102.contains("Width or height is too small") == false) goto L55;
        return 311;
    L55:
        if (r102.contains("Wrong color format") == false) goto L58;
        return 312;
    L58:
        if (r102.contains("WebPInitDecoderConfig failed") == false) goto L61;
        return 313;
    L61:
        if (r102.contains("WebPGetFeatures failed") == false) goto L64;
        return 314;
    L64:
        if (r102.contains("Failed to decode frame. VP8StatusCode:") == false) goto L67;
        return 315;
    L67:
        if (r102.contains("WebpBitmapFactory is null") == false) goto L107;
        return 316;
    L107:
        return 700;
    L70:
        if ((r100 instanceof RuntimeException) == true) goto L72;
        return 700;
    L72:
        if (r102.contains("Could not create WebPDemux from image. This webp might be malformed") == false) goto L75;
        return 317;
    L75:
        if (r102.contains("unrecognized pixel format") == false) goto L78;
        return 318;
    L78:
        if (r102.contains("Wrong pixel format for jpeg encoding") == false) goto L81;
        return 401;
    L81:
        if (r102.contains("Could not write scanline") == false) goto L84;
        return 402;
    L84:
        if (r102.contains("could not allocate memory") == false) goto L114;
        return 602;
    L114:
        return 700;
    }
}
