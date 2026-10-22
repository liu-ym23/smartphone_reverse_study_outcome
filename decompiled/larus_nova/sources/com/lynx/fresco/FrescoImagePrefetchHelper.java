package com.lynx.fresco;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import m8a.e;

/* JADX INFO: loaded from: classes32.dex */
public class FrescoImagePrefetchHelper {
    public static final String PRIORITY_HIGH = "high";
    public static final String PRIORITY_LOW = "low";

    public FrescoImagePrefetchHelper() {
    }

    public static DataSource<Void> prefetchImageToBitmapCache(String r100, Bitmap.Config r101, Object r102) {
        if (r100 != null) goto L5;
    L12:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L12;
        Uri r103 = UriProtector.parse(r100);
        if (r103.getScheme() != null) goto L10;
        return null;
    L10:
        ImageRequestBuilder r104 = ImageRequestBuilder.newBuilderWithSource(r103);
        e.b(r104, r101, false);
        return Fresco.getImagePipeline().prefetchToBitmapCache(r104.build(), r102);
    }
}
