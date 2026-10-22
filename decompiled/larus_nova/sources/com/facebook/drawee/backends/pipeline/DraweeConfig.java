package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweePlaceHolderConfig;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class DraweeConfig {

    @Nullable
    private final ImmutableList<DrawableFactory> mCustomDrawableFactories;
    private final Supplier<Boolean> mDebugOverlayEnabledSupplier;

    @Nullable
    private final DraweePlaceHolderConfig mDraweePlaceHolderConfig;
    private Set<ControllerListener> mGlobalControllerListeners;

    @Nullable
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    /* JADX INFO: renamed from: com.facebook.drawee.backends.pipeline.DraweeConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private List<DrawableFactory> mCustomDrawableFactories;
        private Supplier<Boolean> mDebugOverlayEnabledSupplier;

        @Nullable
        private DraweePlaceHolderConfig mDraweePlaceHolderConfig;
        private Set<ControllerListener> mGlobalControllerListeners;
        private PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

        public Builder() {
        }

        public DraweeConfig build() {
            return new DraweeConfig(this, null);
        }

        public static /* synthetic */ List access$000(Builder r100) {
            return r100.mCustomDrawableFactories;
        }

        public static /* synthetic */ Supplier access$100(Builder r100) {
            return r100.mDebugOverlayEnabledSupplier;
        }

        public static /* synthetic */ PipelineDraweeControllerFactory access$200(Builder r100) {
            return r100.mPipelineDraweeControllerFactory;
        }

        public static /* synthetic */ Set access$300(Builder r100) {
            return r100.mGlobalControllerListeners;
        }

        public static /* synthetic */ DraweePlaceHolderConfig access$400(Builder r100) {
            return r100.mDraweePlaceHolderConfig;
        }

        public Builder addCustomDrawableFactory(DrawableFactory r100) {
            if (this.mCustomDrawableFactories != null) goto L5;
            this.mCustomDrawableFactories = new ArrayList();
        L5:
            this.mCustomDrawableFactories.add(r100);
            return this;
        }

        public Builder addGlobalControllerListener(ControllerListener r100) {
            if (this.mGlobalControllerListeners != null) goto L5;
            this.mGlobalControllerListeners = new HashSet();
        L5:
            this.mGlobalControllerListeners.add(r100);
            return this;
        }

        public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> r100) {
            Preconditions.checkNotNull(r100);
            this.mDebugOverlayEnabledSupplier = r100;
            return this;
        }

        public Builder setDrawDebugOverlay(boolean r100) {
            return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(r100)));
        }

        public Builder setDraweeHierarchyDefaultFadeDuration(int r100) {
            GenericDraweeHierarchyBuilder.setDefaultFadeDuration(r100);
            return this;
        }

        public Builder setDraweePlaceHolderConfig(DraweePlaceHolderConfig r100) {
            this.mDraweePlaceHolderConfig = r100;
            return this;
        }

        public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory r100) {
            this.mPipelineDraweeControllerFactory = r100;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Nullable
    public ImmutableList<DrawableFactory> getCustomDrawableFactories() {
        return this.mCustomDrawableFactories;
    }

    public Supplier<Boolean> getDebugOverlayEnabledSupplier() {
        return this.mDebugOverlayEnabledSupplier;
    }

    public DraweePlaceHolderConfig getDraweePlaceHolderConfig() {
        return this.mDraweePlaceHolderConfig;
    }

    public Set<ControllerListener> getGlobalControllerListeners() {
        return this.mGlobalControllerListeners;
    }

    @Nullable
    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.mPipelineDraweeControllerFactory;
    }

    private DraweeConfig(Builder r100) {
        if (Builder.access$000(r100) == null) goto L5;
        ImmutableList<DrawableFactory> r101 = ImmutableList.copyOf(Builder.access$000(r100));
    L6:
        this.mCustomDrawableFactories = r101;
        if (Builder.access$100(r100) == null) goto L9;
        Supplier<Boolean> r102 = Builder.access$100(r100);
    L10:
        this.mDebugOverlayEnabledSupplier = r102;
        this.mPipelineDraweeControllerFactory = Builder.access$200(r100);
        this.mGlobalControllerListeners = Builder.access$300(r100);
        this.mDraweePlaceHolderConfig = Builder.access$400(r100);
        return;
    L9:
        r102 = Suppliers.of(Boolean.FALSE);
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public /* synthetic */ DraweeConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
