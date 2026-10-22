package v07;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.bytedance.fresco.sr.SRPostProcessor;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.MultiCacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements Postprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<v7a.b> f552337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f552338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SRPostProcessor f552339c;

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        StringBuilder r100 = new StringBuilder();
        Iterator<v7a.b> r101 = this.f552337a.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        v7a.b r102 = r101.next();
        if (r100.length() <= 0) goto L8;
        r100.append(",");
    L8:
        r100.append(r102.getName());
        goto L4
    L10:
        if (this.f552339c == null) goto L12;
        r100.append(",");
        r100.append(this.f552339c.getName());
    L12:
        r100.insert(0, "MultiPostProcessor (");
        r100.append(")");
        return r100.toString();
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey getPostprocessorCacheKey() {
        LinkedList r100 = new LinkedList();
        Iterator<v7a.b> r101 = this.f552337a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.push(new SimpleCacheKey(r101.next().getPostprocessorCacheKey()));
        goto L4
    L6:
        SRPostProcessor r102 = this.f552339c;
        if (r102 == null) goto L10;
        r100.push(r102.getPostprocessorCacheKey());
    L10:
        return new MultiCacheKey(r100);
    }

    public h(Bitmap.Config r100) {
        this.f552339c = null;
        this.f552338b = r100;
    }

    @Override // com.facebook.imagepipeline.request.Postprocessor
    public final CloseableReference<Bitmap> process(Bitmap r100, PlatformBitmapFactory r110) {
        CloseableReference<Bitmap> r101 = null;
        Iterator<v7a.b> r102 = this.f552337a.iterator();     // Catch: Throwable -> L34
        CloseableReference<Bitmap> r103 = null;
        CloseableReference r104 = null;
    L38:
    L32:
        th = th;
    L36:
        CloseableReference.closeSafely(r103);
        throw th;
    L6:
        if (r102.hasNext() == false) goto L22;
        v7a.b r105 = r102.next();     // Catch: Throwable -> L32
        Bitmap.Config r106 = this.f552338b;     // Catch: Throwable -> L32
        if (r106 != null) goto L11;
        r106 = r100.getConfig();     // Catch: Throwable -> L32
    L11:
        int r107 = r100.getWidth();     // Catch: Throwable -> L32
        int r108 = r100.getHeight();     // Catch: Throwable -> L32
        if (r106 != null) goto L15;
        r106 = BasePostprocessor.FALLBACK_BITMAP_CONFIGURATION;     // Catch: Throwable -> L32
    L15:
        r103 = r110.createBitmapInternal(r107, r108, r106);     // Catch: Throwable -> L32
        if (r103.get().getConfig() != r100.getConfig()) goto L18;
        Bitmaps.copyBitmap(r103.get(), r100);     // Catch: Throwable -> L32
    L19:
        if (r104 == null) goto L21;
        Bitmap r109 = (Bitmap) r104.get();     // Catch: Throwable -> L32
    L21:
        r105.a(r103.get());     // Catch: Throwable -> L32
        CloseableReference.closeSafely(r104);     // Catch: Throwable -> L32
        r104 = CloseableReference.cloneOrNull(r103);     // Catch: Throwable -> L32
        goto L38
    L18:
        new Canvas(r103.get()).drawBitmap(r100, 0.0f, 0.0f, null);     // Catch: Throwable -> L32
        goto L19
    L22:
        SRPostProcessor r111 = this.f552339c;     // Catch: Throwable -> L32
        if (r111 == null) goto L28;
        if (r104 == null) goto L26;
        r100 = (Bitmap) r104.get();     // Catch: Throwable -> L32
    L26:
        r101 = r111.process(r100, r110);     // Catch: Throwable -> L32
    L29:
        CloseableReference<Bitmap> r112 = CloseableReference.cloneOrNull(r101);     // Catch: Throwable -> L34
        CloseableReference.closeSafely(r101);
        return r112;
    L28:
        r101 = r103;
    L34:
        th = th;
        r103 = r101;
        goto L36
    }
}
