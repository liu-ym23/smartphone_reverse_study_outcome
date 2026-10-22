package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.h;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes36.dex */
class CompressEngine {
    private final CompressImageCache imageCache;
    private final ICompressStrategy strategy;

    public CompressResult compress(CompressRequest r110) throws IOException, IllegalStateException {
        IImageSource r100 = r110.iImageSource;
        boolean r101 = false;
        ImageInfo r102 = b.d(r100.getPath(), true, false);
        if (r102 == null) goto L70;
        long r103 = r102.f426423c;
        int r104 = this.strategy.calcExpectShortSize(r102);
        int r111 = this.strategy.calcTargetQuality(r102);
        String r112 = ImageCacheKey.newBuilder().fileKey(r100.uniqueKey()).expectShortSize(r104).expectQuality(r111).toKey();
        File r113 = this.imageCache.getCacheFile(r112);
        if (r113 == null) goto L27;
        if (r113.exists() == false) goto L27;
        PolarisFileInputStreamWrapper r114 = new PolarisFileInputStreamWrapper(r113);     // Catch: Throwable -> L13 IOException -> L15
        ImageInfo r105 = b.d(r113.getPath(), true, false);     // Catch: IOException -> L11 Throwable -> L22
        IOUtils.closeSafety(r114);
    L19:
        if (r105 == null) goto L27;
        Log.i("ImageCompressor", "image cache hit, skip compress");
        return CompressResult.newBuilder().compressImageFile(r113).outWidth(r105.f426421a).outHeight(r105.f426422b).outSize(r113.length()).originWidth(r102.f426421a).originHeight(r102.f426422b).originSize(r103).build();
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L22
        IOUtils.closeSafety(r114);
        r105 = null;
        goto L19
    L15:
        e = e;
        r114 = null;
    L13:
        th = th;
        PolarisFileInputStreamWrapper r115 = null;
    L24:
        IOUtils.closeSafety(r115);
        throw th;
    L22:
        th = th;
        r115 = r114;
    L27:
        if (this.strategy.shouldSkipCompress(r102, r104, r111) == false) goto L30;
        Log.i("ImageCompressor", "not need compress, skipped, " + r102.toString() + " expect: " + r104 + "," + r111);
        return CompressResult.newBuilder().compressImageFile(new PolarisFileWrapper(r100.getPath())).outWidth(r102.f426421a).outHeight(r102.f426422b).outSize(r103).originWidth(r102.f426421a).originHeight(r102.f426422b).originSize(r103).build();
    L30:
        int r106 = this.strategy.calcSampleSize(r102);
        InputStream r107 = r100.open();     // Catch: Throwable -> L50 OutOfMemoryError -> L52
        Bitmap r116 = baseScaleBitmap(r107, r106);     // Catch: Throwable -> L46 OutOfMemoryError -> L48
        IOUtils.closeSafety(r107);     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        Bitmap r108 = TransformationUtilsKt.rotateImageExif(r116, r102.f426426f);     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        if (r116 == r108) goto L75;
        r116.recycle();     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        r116 = r108;
    L75:
    L42:
        e = e;
        r101 = true;
    L55:
        Log.e("ImageCompressor", "image compress out of memory :" + e.getMessage());     // Catch: Throwable -> L46
        if (r101 == true) goto L59;
        if (r116 == null) goto L59;
        r116.recycle();     // Catch: Throwable -> L46
        Bitmap r117 = null;
    L60:
        h.b("image_compress_oom", FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.crash.disable_oppo_android15_explicit_gc_guard"), true);     // Catch: Throwable -> L46
        IOUtils.closeSafety(r107);
        r116 = r117;
    L62:
        if (r116 == null) goto L66;
        int r109 = r116.getWidth();
        int r118 = r116.getHeight();
        File r119 = this.imageCache.createCacheFile(r112);
        Bitmap.CompressFormat r120 = this.strategy.getCompressFormat(r102.f426425e);
        PolarisFileOutputStreamWrapper r121 = new PolarisFileOutputStreamWrapper(r119);
        r116.compress(r120, r111, r121);
        r116.recycle();
        IOUtils.closeSafety(r121);
        return CompressResult.newBuilder().compressImageFile(r119).outWidth(r109).outHeight(r118).outSize(r119.length()).originWidth(r102.f426421a).originHeight(r102.f426422b).originSize(r103).build();
    L66:
        throw new IllegalStateException("image compress failed");
    L59:
        r117 = r116;
        goto L60
    L38:
        if (Math.min(r116.getWidth(), r116.getHeight()) <= (((double) r104) * 1.1d)) goto L41;
        Bitmap r122 = twiceScaleBitmap(r116, r104);     // Catch: OutOfMemoryError -> L42 Throwable -> L46
        r116.recycle();     // Catch: OutOfMemoryError -> L42 Throwable -> L46
        r116 = r122;
    L41:
        IOUtils.closeSafety(r107);
    L44:
        e = e;
    L48:
        e = e;
    L54:
        r116 = null;
    L46:
        th = th;
        InputStream r123 = r107;
    L67:
        IOUtils.closeSafety(r123);
        throw th;
    L52:
        e = e;
        r107 = null;
    L50:
        th = th;
        r123 = null;
        goto L67
    L70:
        throw new IllegalStateException("parse image file failed");
    }

    public CompressEngine(CompressImageCache r100, ICompressStrategy r101) {
        this.imageCache = r100;
        this.strategy = r101;
    }

    private Bitmap baseScaleBitmap(InputStream r100, int r101) {
        BitmapFactory.Options r102 = new BitmapFactory.Options();
        r102.inSampleSize = r101;
        return BitmapFactory.decodeStream(r100, null, r102);
    }

    private Bitmap twiceScaleBitmap(Bitmap r100, int r101) {
        int r102 = r100.getWidth();
        int r103 = r100.getHeight();
        float r104 = (r101 * 1.0f) / Math.min(r102, r103);
        return Bitmap.createScaledBitmap(r100, (int) (r102 * r104), (int) (r103 * r104), false);
    }
}
