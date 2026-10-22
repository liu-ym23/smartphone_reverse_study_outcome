package com.bytedance.map.api.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.text.TextUtils;
import com.bytedance.map.api.exception.BDMapException;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
public class MapImageLoader {

    public static abstract class PriorityImageCallback implements ImageCallback {
        private int mPriority;

        private PriorityImageCallback() {
        }

        public int getPriority() {
            return this.mPriority;
        }

        public PriorityImageCallback(int r100) {
            this.mPriority = r100;
        }
    }

    public MapImageLoader() {
    }

    public static /* synthetic */ Bitmap access$000(List r100) {
        return mergeBitmaps(r100);
    }

    private static Bitmap mergeBitmaps(List<Bitmap> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = 1;
        if (r100.size() == 1) goto L8;
        Bitmap r102 = (Bitmap) ListProtector.get(r100, 0);
    L11:
        if (r101 >= r100.size()) goto L13;
        r102 = mergeTwoBitmaps(r102, (Bitmap) ListProtector.get(r100, r101));
        r101 = r101 + 1;
        goto L11
    L13:
        return r102;
    L8:
        return (Bitmap) ListProtector.get(r100, 0);
    }

    public static void loadAndMergeBitmaps(List<ImageOptions> r100, final ImageCallback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
    L10:
        r101.onFail(new BDMapException("2", "option is null"));
        return;
    L6:
        if (r100.size() == 0) goto L10;
        loadBitmaps(r100, new AnonymousClass1(r101));
    }

    public static void loadBitmap(final ImageOptions r100, final ImageCallback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L8;
        r101.onFail(new BDMapException("2", "option is null"));
        return;
    L8:
        if (TextUtils.isEmpty(r100.getUrl()) == false) goto L10;
    L14:
        ImageRequest r102 = ImageRequest.fromUri(r100.getUrl());
    L15:
        Fresco.getImagePipeline().fetchDecodedImage(r102, null).subscribe(new AnonymousClass3(r100, r101), UiThreadImmediateExecutorService.getInstance());
        return;
    L10:
        if (r100.getWidth() == 0) goto L14;
        if (r100.getHeight() == 0) goto L14;
        r102 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r100.getUrl())).setResizeOptions(new ResizeOptions(r100.getWidth(), r100.getHeight())).build();
        goto L15
    }

    public static void loadBitmaps(List<ImageOptions> r100, final ImageCallback r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L7;
        r101.onFail(new BDMapException("2", "option is null"));
        return;
    L7:
        final ArrayList r102 = new ArrayList();
        final CountDownLatch r103 = new CountDownLatch(r100.size());
        Iterator<ImageOptions> r104 = r100.iterator();
    L9:
        if (r104.hasNext() == false) goto L23;
        ImageOptions r105 = r104.next();
        final int r106 = r105.getIndex();
        loadBitmap(r105, new AnonymousClass2(r106, r102, r103, r101));
        goto L9
    L23:
        r103.await(3, TimeUnit.SECONDS);     // Catch: InterruptedException -> L13
    L16:
        if (r103.getCount() != 0) goto L26;
        Collections.sort(r102);
        ArrayList r107 = new ArrayList();
        Iterator r108 = r102.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        r107.add(((BitmapWrapper) r108.next()).getBitmap());
        goto L19
    L21:
        r101.onSuccess(r107);
        return;
    L26:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private static Bitmap mergeTwoBitmaps(Bitmap r110, Bitmap r111) {
        if (r110 != null) goto L4;
    L13:
        return r111;
    L4:
        if (r110.isRecycled() == true) goto L13;
        if (r111 != null) goto L8;
    L12:
        return r110;
    L8:
        if (r111.isRecycled() == true) goto L12;
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        int r102 = r111.getWidth();
        int r103 = r111.getHeight();
        int r104 = Math.max(r100, r102);
        int r105 = Math.max(r101, r103);
        Bitmap r106 = Bitmap.createBitmap(r104, r105, Bitmap.Config.ARGB_8888);
        Canvas r107 = new Canvas(r106);
        r107.drawBitmap(r110, (r104 - r100) / 2.0f, (r105 - r101) / 2.0f, null);
        r107.drawBitmap(r111, (r104 - r102) / 2.0f, (r105 - r103) / 2.0f, null);
        return r106;
    }

    public static Bitmap zoomBitmap(Bitmap r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 == 0) goto L10;
        if (r102 == 0) goto L10;
        float r103 = (r101 * 1.0f) / r100.getWidth();
        float r104 = (r102 * 1.0f) / r100.getHeight();
        Matrix r105 = new Matrix();
        r105.postScale(r103, r104, 0.0f, 0.0f);
        Bitmap r106 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        new Canvas(r106).drawBitmap(r100, r105, new Paint());
        return r106;
    L10:
        return r100;
    }
}
