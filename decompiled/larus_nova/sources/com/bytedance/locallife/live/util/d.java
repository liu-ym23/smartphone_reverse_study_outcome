package com.bytedance.locallife.live.util;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f260695a = 0;

    static {
    }

    public static Bitmap a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        DefaultCacheKeyFactory r101 = DefaultCacheKeyFactory.getInstance();
        ImageRequestBuilder r102 = ImageRequestBuilder.newBuilderWithSource(r100);
        ImageDecodeOptions r103 = ImageDecodeOptions.defaults();
        r103.isSelectBitmapConfig = true;
        Unit r104 = Unit.INSTANCE;
        CacheKey r105 = r101.getBitmapCacheKey(r102.setImageDecodeOptions(r103).build(), null);
        CacheKey r106 = DefaultCacheKeyFactory.getInstance().getBitmapCacheKey(ImageRequest.fromUri(r100), null);
        CloseableReference<CloseableImage> r107 = Fresco.getImagePipelineFactory().getBitmapMemoryCache().get(r105);
        if (r107 != null) goto L5;
        r107 = Fresco.getImagePipelineFactory().getBitmapMemoryCache().get(r106);
    L5:
        if (r107 != null) goto L12;
        return null;
    L12:
        CloseableImage r108 = r107.get();     // Catch: Exception -> L11
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");     // Catch: Exception -> L11
        Bitmap r109 = ((CloseableBitmap) r108).getUnderlyingBitmap().copy(Bitmap.Config.ARGB_8888, true);     // Catch: Exception -> L11
        r107.close();     // Catch: Exception -> L11
        return r109;
    L14:
        return null;
    }
}
