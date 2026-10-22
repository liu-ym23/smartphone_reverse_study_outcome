package com.lynx.tasm.ui.image;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class m0 implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Postprocessor> f384020a;

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Postprocessor> r101 = this.f384020a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Postprocessor r102 = r101.next();
        if (r100.length() <= 0) goto L8;
        r100.append(",");
    L8:
        r100.append(r102.getName());
        goto L4
    L9:
        r100.insert(0, "MultiPostProcessor (");
        r100.append(")");
        return r100.toString();
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        LinkedList r100 = new LinkedList();
        Iterator<Postprocessor> r101 = this.f384020a.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.push(r101.next().getPostprocessorCacheKey());
        goto L4
    L7:
        return new MultiCacheKey(r100);
    }

    public m0(List<Postprocessor> r100) {
        this.f384020a = new LinkedList(r100);
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r101) {
        CloseableReference<Bitmap> r102 = null;
        Iterator<Postprocessor> r103 = this.f384020a.iterator();     // Catch: Throwable -> L14
        CloseableReference r104 = null;
    L5:
        if (r103.hasNext() == false) goto L11;
        Postprocessor r105 = r103.next();     // Catch: Throwable -> L14
        if (r104 == null) goto L9;
        Bitmap r106 = (Bitmap) r104.get();     // Catch: Throwable -> L14
    L10:
        r102 = r105.process(r106, r101);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L14
        r104 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        r106 = r100;
        goto L10
    L11:
        CloseableReference<Bitmap> r107 = CloseableReference.cloneOrNull(r102);     // Catch: Throwable -> L14
        CloseableReference.closeSafely(r102);
        return r107;
    L14:
        th = move-exception;
        CloseableReference.closeSafely(r102);
        throw th;
    }
}
