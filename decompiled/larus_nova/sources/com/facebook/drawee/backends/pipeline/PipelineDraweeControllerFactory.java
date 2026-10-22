package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public class PipelineDraweeControllerFactory {
    private DrawableFactory mAnimatedDrawableFactory;

    @Nullable
    private Supplier<Boolean> mDebugOverlayEnabledSupplier;
    private DeferredReleaser mDeferredReleaser;

    @Nullable
    private ImmutableList<DrawableFactory> mDrawableFactories;

    @Nullable
    private Set<ControllerListener> mGlobalControllerListeners;
    private MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    private Resources mResources;
    private Executor mUiThreadExecutor;

    public PipelineDraweeControllerFactory() {
    }

    public PipelineDraweeController newController() {
        PipelineDraweeController r100 = internalCreateController(this.mResources, this.mDeferredReleaser, this.mAnimatedDrawableFactory, this.mUiThreadExecutor, this.mMemoryCache, this.mDrawableFactories);
        Supplier<Boolean> r101 = this.mDebugOverlayEnabledSupplier;
        if (r101 == null) goto L5;
        r100.setDrawDebugOverlay(r101.get().booleanValue());
    L5:
        return r100;
    }

    @Nullable
    public Set<ControllerListener> getGlobalControllerListeners() {
        return this.mGlobalControllerListeners;
    }

    public PipelineDraweeController internalCreateController(Resources r100, DeferredReleaser r110, DrawableFactory r111, Executor r112, MemoryCache<CacheKey, CloseableImage> r113, @Nullable ImmutableList<DrawableFactory> r114) {
        return new PipelineDraweeController(r100, r110, r111, r112, r113, r114);
    }

    public void init(Resources r100, DeferredReleaser r101, DrawableFactory r102, Executor r103, MemoryCache<CacheKey, CloseableImage> r104, @Nullable ImmutableList<DrawableFactory> r105, @Nullable Supplier<Boolean> r106) {
        this.mResources = r100;
        this.mDeferredReleaser = r101;
        this.mAnimatedDrawableFactory = r102;
        this.mUiThreadExecutor = r103;
        this.mMemoryCache = r104;
        this.mDrawableFactories = r105;
        this.mDebugOverlayEnabledSupplier = r106;
    }

    public void init(Resources r100, DeferredReleaser r101, DrawableFactory r102, Executor r103, MemoryCache<CacheKey, CloseableImage> r104, @Nullable ImmutableList<DrawableFactory> r105, @Nullable Supplier<Boolean> r106, @Nullable Set<ControllerListener> r107) {
        this.mResources = r100;
        this.mDeferredReleaser = r101;
        this.mAnimatedDrawableFactory = r102;
        this.mUiThreadExecutor = r103;
        this.mMemoryCache = r104;
        this.mDrawableFactories = r105;
        this.mDebugOverlayEnabledSupplier = r106;
        this.mGlobalControllerListeners = r107;
    }
}
