package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawable.base.DrawableWithCaches;
import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;

/* JADX INFO: loaded from: classes32.dex */
public final class u extends q<CloseableReference<CloseableImage>, ImageInfo> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DrawableFactory f384060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MemoryCache<CacheKey, CloseableImage> f384061r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Supplier<DataSource<CloseableReference<CloseableImage>>> f384062s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ImageOriginListener f384063t;

    @Override // com.lynx.tasm.ui.image.q
    public final DataSource<CloseableReference<CloseableImage>> e() {
        return this.f384062s.get();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final String toString() {
        return Objects.toStringHelper(this).add("super", super.toString()).add("dataSourceSupplier", this.f384062s).toString();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final Drawable c(CloseableReference<CloseableImage> r100) {
        CloseableReference<CloseableImage> r101 = r100;
        Preconditions.checkState(CloseableReference.isValid(r101));
        CloseableImage r102 = r101.get();
        Drawable r103 = this.f384060q.createDrawable(r102);
        if (r103 == null) goto L6;
        return r103;
    L6:
        throw new UnsupportedOperationException("Unrecognized image class: " + r102);
    }

    @Override // com.lynx.tasm.ui.image.q
    public final int f(CloseableReference<CloseableImage> r100) {
        CloseableReference<CloseableImage> r101 = r100;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getValueHash();
    }

    @Override // com.lynx.tasm.ui.image.q
    public final ImageInfo g(CloseableReference<CloseableImage> r100) {
        CloseableReference<CloseableImage> r101 = r100;
        Preconditions.checkState(CloseableReference.isValid(r101));
        return r101.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.ui.image.q
    public final void k(Drawable r100) {
        if ((r100 instanceof DrawableWithCaches) == false) goto L6;
        ((DrawableWithCaches) r100).dropCaches();
        return;
    }

    @Override // com.lynx.tasm.ui.image.q
    public final void m(CloseableReference<CloseableImage> r100) {
        CloseableReference.closeSafely(r100);
    }

    public u(a r100, DrawableFactory r101, HandlerExecutorServiceImpl r102, MemoryCache r103) {
        super(r100, r102);
        this.f384060q = r101;
        this.f384061r = r103;
    }
}
