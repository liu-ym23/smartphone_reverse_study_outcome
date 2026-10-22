package com.facebook.drawee.backends.pipeline.info;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.apm.constant.UploadTypeInf;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;

/* JADX INFO: loaded from: classes23.dex */
public class ImageOriginUtils {
    private ImageOriginUtils() {
    }

    public static String toString(int r100) {
        if (r100 != 2) goto L5;
        return "network";
    L5:
        if (r100 != 3) goto L7;
        return UploadTypeInf.DISK;
    L7:
        if (r100 != 4) goto L9;
        return "memory_encoded";
    L9:
        if (r100 != 5) goto L11;
        return "memory_bitmap";
    L11:
        if (r100 == 6) goto L14;
        return "unknown";
    L14:
        return "local";
    }

    public static int mapProducerNameToImageOrigin(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1917159454: goto L66;
            case -1914072202: goto L62;
            case -1683996557: goto L58;
            case -1579985851: goto L54;
            case -1307634203: goto L50;
            case -1224383234: goto L46;
            case 473552259: goto L42;
            case 656304759: goto L38;
            case 752843298: goto L34;
            case 957714404: goto L30;
            case 1019542023: goto L26;
            case 1023071510: goto L22;
            case 1721672898: goto L18;
            case 1793127518: goto L14;
            case 2109593398: goto L10;
            case 2113652014: goto L6;
            default: goto L69;
        };
    L69:
        switch(r101) {
            case 0: goto L75;
            case 1: goto L74;
            case 2: goto L75;
            case 3: goto L75;
            case 4: goto L73;
            case 5: goto L72;
            case 6: goto L75;
            case 7: goto L71;
            case 8: goto L75;
            case 9: goto L74;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L75;
            case 13: goto L75;
            case 14: goto L71;
            case 15: goto L75;
            default: goto L70;
        };
    L70:
        return 1;
    L71:
        return 3;
    L72:
        return 2;
    L73:
        return 4;
    L74:
        return 5;
    L75:
        return 6;
    L6:
        if (r100.equals(LocalContentUriFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 15;
        goto L69
    L10:
        if (r100.equals(PartialDiskCacheProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 14;
        goto L69
    L14:
        if (r100.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = HTTP.CR;
        goto L69
    L18:
        if (r100.equals(DataFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 12;
        goto L69
    L22:
        if (r100.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 11;
        goto L69
    L26:
        if (r100.equals(LocalAssetFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 10;
        goto L69
    L30:
        if (r100.equals(BitmapMemoryCacheProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 9;
        goto L69
    L34:
        if (r100.equals(LocalContentUriThumbnailProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 8;
        goto L69
    L38:
        if (r100.equals(DiskCacheReadProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 7;
        goto L69
    L42:
        if (r100.equals(LocalVideoThumbnailProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 6;
        goto L69
    L46:
        if (r100.equals(NetworkFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 5;
        goto L69
    L50:
        if (r100.equals(EncodedMemoryCacheProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 4;
        goto L69
    L54:
        if (r100.equals(LocalFileFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 3;
        goto L69
    L58:
        if (r100.equals(LocalResourceFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 2;
        goto L69
    L62:
        if (r100.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 1;
        goto L69
    L66:
        if (r100.equals(QualifiedResourceFetchProducer.PRODUCER_NAME) == false) goto L69;
        r101 = 0;
        goto L69
    }
}
