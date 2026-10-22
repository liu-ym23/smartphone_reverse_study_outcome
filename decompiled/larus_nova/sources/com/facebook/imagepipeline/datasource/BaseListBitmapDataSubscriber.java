package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    public abstract void onNewResultListImpl(List<Bitmap> r100);

    public BaseListBitmapDataSubscriber() {
    }

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> r100) {
        if (r100.isFinished() == true) goto L5;
        return;
    L5:
        List<CloseableReference<CloseableImage>> r101 = r100.getResult();
        if (r101 != null) goto L30;
        onNewResultListImpl(null);
        return;
    L30:
        ArrayList r102 = new ArrayList(r101.size());     // Catch: Throwable -> L24
        Iterator<CloseableReference<CloseableImage>> r103 = r101.iterator();     // Catch: Throwable -> L24
    L11:
        if (r103.hasNext() == false) goto L18;
        CloseableReference<CloseableImage> r104 = r103.next();     // Catch: Throwable -> L24
        if (r104 == null) goto L17;
        if ((r104.get() instanceof CloseableBitmap) == false) goto L17;
        r102.add(((CloseableBitmap) r104.get()).getUnderlyingBitmap());     // Catch: Throwable -> L24
    L17:
        r102.add(null);     // Catch: Throwable -> L24
        goto L11
    L18:
        onNewResultListImpl(r102);     // Catch: Throwable -> L24
        Iterator<CloseableReference<CloseableImage>> r105 = r101.iterator();
    L21:
        if (r105.hasNext() == false) goto L23;
        CloseableReference.closeSafely(r105.next());
        goto L21
    L23:
        return;
    L24:
        th = move-exception;
        Iterator<CloseableReference<CloseableImage>> r106 = r101.iterator();
    L27:
        if (r106.hasNext() == false) goto L29;
        CloseableReference.closeSafely(r106.next());
        goto L27
    L29:
        throw th;
    }
}
