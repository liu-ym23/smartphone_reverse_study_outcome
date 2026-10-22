package com.ss.android.ugc.aweme.search.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/utils/BitmapUtil;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BitmapUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BitmapUtil f453398a = null;

    private BitmapUtil() {
    }

    static {
        f453398a = new BitmapUtil();
    }

    public static byte[] a(BitmapUtil r100, Bitmap r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "originBitmap");
        int r102 = r101.getWidth();
        int r103 = r101.getHeight();
        if (r102 <= r103) goto L5;
        float r104 = r103;
    L6:
        float r105 = 720.0f / r104;
        if (r105 <= 1) goto L10;
        r105 = 1.0f;
    L10:
        if (r105 >= 1.0f) goto L13;
        Matrix r106 = new Matrix();
        r106.postScale(r105, r105);
        r101 = Bitmap.createBitmap(r101, 0, 0, r102, r103, r106, true);
    L13:
        r101.getWidth();
        r101.getHeight();
        ByteArrayOutputStream r107 = new ByteArrayOutputStream();
        r101.compress(Bitmap.CompressFormat.JPEG, 95, r107);
        return r107.toByteArray();
    L5:
        r104 = r102;
        goto L6
    }

    public static Bitmap b(BitmapUtil r100, Uri r101, Object r102) {
        r100.getClass();
        Bitmap r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        DataSource<CloseableReference<CloseableImage>> r104 = null;
        r103 = null;
        if (r101 == null) goto L27;
        if (r102 == null) goto L27;
        DataSource<CloseableReference<CloseableImage>> r105 = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(r101).build(), r102);     // Catch: Throwable -> L20 Exception -> L24
        Object r106 = DataSources.waitForFinalResult(r105);     // Catch: Throwable -> L18 Exception -> L28
        if ((r106 instanceof CloseableReference) == true) goto L11;
        r106 = null;
    L11:
        CloseableReference r107 = (CloseableReference) r106;     // Catch: Throwable -> L18 Exception -> L28
        if (r107 == null) goto L16;
        CloseableBitmap r108 = (CloseableBitmap) r107.get();     // Catch: Throwable -> L18 Exception -> L28
        if (r108 == null) goto L16;
        r103 = r108.getUnderlyingBitmap();     // Catch: Throwable -> L18 Exception -> L28
    L16:
        if (r105 == null) goto L27;
    L26:
        r105.close();
    L18:
        th = move-exception;
        th = th;
        r104 = r105;
    L21:
        if (r104 == null) goto L23;
        r104.close();
    L23:
        throw th;
    L25:
        if (r105 == null) goto L27;
    L24:
        r105 = null;
    L20:
        th = th;
    L27:
        return r103;
    }
}
