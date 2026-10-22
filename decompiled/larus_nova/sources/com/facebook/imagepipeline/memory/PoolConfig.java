package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

/* JADX INFO: loaded from: classes3.dex */
public class PoolConfig {
    public static final int BITMAP_POOL_MAX_BITMAP_SIZE_DEFAULT = 4194304;
    private final int mBitmapPoolMaxBitmapSize;
    private final int mBitmapPoolMaxPoolSize;
    private final PoolParams mBitmapPoolParams;
    private final PoolStatsTracker mBitmapPoolStatsTracker;
    private final String mBitmapPoolType;
    private final PoolParams mFlexByteArrayPoolParams;
    private final PoolParams mMemoryChunkPoolParams;
    private final PoolStatsTracker mMemoryChunkPoolStatsTracker;
    private final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    private final PoolParams mSmallByteArrayPoolParams;
    private final PoolStatsTracker mSmallByteArrayPoolStatsTracker;

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.PoolConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int mBitmapPoolMaxBitmapSize;
        private int mBitmapPoolMaxPoolSize;
        private PoolParams mBitmapPoolParams;
        private PoolStatsTracker mBitmapPoolStatsTracker;
        private String mBitmapPoolType;
        private PoolParams mFlexByteArrayPoolParams;
        private PoolParams mMemoryChunkPoolParams;
        private PoolStatsTracker mMemoryChunkPoolStatsTracker;
        private MemoryTrimmableRegistry mMemoryTrimmableRegistry;
        private PoolParams mSmallByteArrayPoolParams;
        private PoolStatsTracker mSmallByteArrayPoolStatsTracker;

        public PoolConfig build() {
            return new PoolConfig(this, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ PoolParams access$000(Builder r100) {
            return r100.mBitmapPoolParams;
        }

        public static /* synthetic */ PoolStatsTracker access$100(Builder r100) {
            return r100.mBitmapPoolStatsTracker;
        }

        public static /* synthetic */ int access$1000(Builder r100) {
            return r100.mBitmapPoolMaxBitmapSize;
        }

        public static /* synthetic */ PoolParams access$200(Builder r100) {
            return r100.mFlexByteArrayPoolParams;
        }

        public static /* synthetic */ MemoryTrimmableRegistry access$300(Builder r100) {
            return r100.mMemoryTrimmableRegistry;
        }

        public static /* synthetic */ PoolParams access$400(Builder r100) {
            return r100.mMemoryChunkPoolParams;
        }

        public static /* synthetic */ PoolStatsTracker access$500(Builder r100) {
            return r100.mMemoryChunkPoolStatsTracker;
        }

        public static /* synthetic */ PoolParams access$600(Builder r100) {
            return r100.mSmallByteArrayPoolParams;
        }

        public static /* synthetic */ PoolStatsTracker access$700(Builder r100) {
            return r100.mSmallByteArrayPoolStatsTracker;
        }

        public static /* synthetic */ String access$800(Builder r100) {
            return r100.mBitmapPoolType;
        }

        public static /* synthetic */ int access$900(Builder r100) {
            return r100.mBitmapPoolMaxPoolSize;
        }

        public Builder setBitmapPoolMaxBitmapSize(int r100) {
            this.mBitmapPoolMaxBitmapSize = r100;
            return this;
        }

        public Builder setBitmapPoolMaxPoolSize(int r100) {
            this.mBitmapPoolMaxPoolSize = r100;
            return this;
        }

        public Builder setBitmapPoolParams(PoolParams r100) {
            this.mBitmapPoolParams = (PoolParams) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setBitmapPoolStatsTracker(PoolStatsTracker r100) {
            this.mBitmapPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setBitmapPoolType(String r100) {
            this.mBitmapPoolType = r100;
            return this;
        }

        public Builder setFlexByteArrayPoolParams(PoolParams r100) {
            this.mFlexByteArrayPoolParams = r100;
            return this;
        }

        public Builder setMemoryTrimmableRegistry(MemoryTrimmableRegistry r100) {
            this.mMemoryTrimmableRegistry = r100;
            return this;
        }

        public Builder setNativeMemoryChunkPoolParams(PoolParams r100) {
            this.mMemoryChunkPoolParams = (PoolParams) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setNativeMemoryChunkPoolStatsTracker(PoolStatsTracker r100) {
            this.mMemoryChunkPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setSmallByteArrayPoolParams(PoolParams r100) {
            this.mSmallByteArrayPoolParams = (PoolParams) Preconditions.checkNotNull(r100);
            return this;
        }

        public Builder setSmallByteArrayPoolStatsTracker(PoolStatsTracker r100) {
            this.mSmallByteArrayPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(r100);
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public int getBitmapPoolMaxBitmapSize() {
        return this.mBitmapPoolMaxBitmapSize;
    }

    public int getBitmapPoolMaxPoolSize() {
        return this.mBitmapPoolMaxPoolSize;
    }

    public PoolParams getBitmapPoolParams() {
        return this.mBitmapPoolParams;
    }

    public PoolStatsTracker getBitmapPoolStatsTracker() {
        return this.mBitmapPoolStatsTracker;
    }

    public String getBitmapPoolType() {
        return this.mBitmapPoolType;
    }

    public PoolParams getFlexByteArrayPoolParams() {
        return this.mFlexByteArrayPoolParams;
    }

    public PoolParams getMemoryChunkPoolParams() {
        return this.mMemoryChunkPoolParams;
    }

    public PoolStatsTracker getMemoryChunkPoolStatsTracker() {
        return this.mMemoryChunkPoolStatsTracker;
    }

    public MemoryTrimmableRegistry getMemoryTrimmableRegistry() {
        return this.mMemoryTrimmableRegistry;
    }

    public PoolParams getSmallByteArrayPoolParams() {
        return this.mSmallByteArrayPoolParams;
    }

    public PoolStatsTracker getSmallByteArrayPoolStatsTracker() {
        return this.mSmallByteArrayPoolStatsTracker;
    }

    private PoolConfig(Builder r100) {
        if (FrescoSystrace.isTracing() == false) goto L6;
        FrescoSystrace.beginSection("PoolConfig()");
    L6:
        if (Builder.access$000(r100) != null) goto L8;
        PoolParams r101 = DefaultBitmapPoolParams.get();
    L9:
        this.mBitmapPoolParams = r101;
        if (Builder.access$100(r100) != null) goto L12;
        PoolStatsTracker r102 = NoOpPoolStatsTracker.getInstance();
    L13:
        this.mBitmapPoolStatsTracker = r102;
        if (Builder.access$200(r100) != null) goto L16;
        PoolParams r103 = DefaultFlexByteArrayPoolParams.get();
    L17:
        this.mFlexByteArrayPoolParams = r103;
        if (Builder.access$300(r100) != null) goto L20;
        MemoryTrimmableRegistry r104 = NoOpMemoryTrimmableRegistry.getInstance();
    L21:
        this.mMemoryTrimmableRegistry = r104;
        if (Builder.access$400(r100) != null) goto L24;
        PoolParams r105 = DefaultNativeMemoryChunkPoolParams.get();
    L25:
        this.mMemoryChunkPoolParams = r105;
        if (Builder.access$500(r100) != null) goto L28;
        PoolStatsTracker r106 = NoOpPoolStatsTracker.getInstance();
    L29:
        this.mMemoryChunkPoolStatsTracker = r106;
        if (Builder.access$600(r100) != null) goto L32;
        PoolParams r107 = DefaultByteArrayPoolParams.get();
    L33:
        this.mSmallByteArrayPoolParams = r107;
        if (Builder.access$700(r100) != null) goto L36;
        PoolStatsTracker r108 = NoOpPoolStatsTracker.getInstance();
    L37:
        this.mSmallByteArrayPoolStatsTracker = r108;
        if (Builder.access$800(r100) != null) goto L40;
        String r109 = "legacy";
    L41:
        this.mBitmapPoolType = r109;
        this.mBitmapPoolMaxPoolSize = Builder.access$900(r100);
        if (Builder.access$1000(r100) <= 0) goto L44;
        int r110 = Builder.access$1000(r100);
    L45:
        this.mBitmapPoolMaxBitmapSize = r110;
        if (FrescoSystrace.isTracing() == false) goto L49;
        FrescoSystrace.endSection();
        return;
    L49:
        return;
    L44:
        r110 = 4194304;
        goto L45
    L40:
        r109 = Builder.access$800(r100);
        goto L41
    L36:
        r108 = Builder.access$700(r100);
        goto L37
    L32:
        r107 = Builder.access$600(r100);
        goto L33
    L28:
        r106 = Builder.access$500(r100);
        goto L29
    L24:
        r105 = Builder.access$400(r100);
        goto L25
    L20:
        r104 = Builder.access$300(r100);
        goto L21
    L16:
        r103 = Builder.access$200(r100);
        goto L17
    L12:
        r102 = Builder.access$100(r100);
        goto L13
    L8:
        r101 = Builder.access$000(r100);
        goto L9
    }

    public /* synthetic */ PoolConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
