package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;

/* JADX INFO: loaded from: classes3.dex */
public class PoolFactory {
    private BitmapPool mBitmapPool;
    private BufferMemoryChunkPool mBufferMemoryChunkPool;
    private final PoolConfig mConfig;
    private FlexByteArrayPool mFlexByteArrayPool;
    private NativeMemoryChunkPool mNativeMemoryChunkPool;
    private PooledByteBufferFactory mPooledByteBufferFactory;
    private PooledByteStreams mPooledByteStreams;
    private SharedByteArray mSharedByteArray;
    private ByteArrayPool mSmallByteArrayPool;

    public PooledByteBufferFactory getPooledByteBufferFactory() {
        return getPooledByteBufferFactory(0);
    }

    public BitmapPool getBitmapPool() {
        if (this.mBitmapPool != null) goto L28;
        String r100 = this.mConfig.getBitmapPoolType();
        switch(r100.hashCode()) {
            case -1868884870: goto L17;
            case -1106578487: goto L14;
            case -404562712: goto L11;
            case 95945896: goto L8;
            default: goto L19;
        };
    L19:
        byte r101 = -1;
    L20:
        if (r101 == 0) goto L26;
        if (r101 == 1) goto L25;
        if (r101 == 2) goto L24;
        this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapPoolParams(), this.mConfig.getBitmapPoolStatsTracker());
        goto L28
    L24:
        this.mBitmapPool = new BucketsBitmapPool(this.mConfig.getMemoryTrimmableRegistry(), DefaultBitmapPoolParams.get(), this.mConfig.getBitmapPoolStatsTracker());
        goto L28
    L25:
        this.mBitmapPool = new LruBitmapPool(this.mConfig.getBitmapPoolMaxPoolSize(), this.mConfig.getBitmapPoolMaxBitmapSize(), NoOpPoolStatsTracker.getInstance());
        goto L28
    L26:
        this.mBitmapPool = new DummyBitmapPool();
        goto L28
    L8:
        if (r100.equals(BitmapPoolType.DUMMY) == false) goto L19;
        r101 = 0;
        goto L20
    L11:
        if (r100.equals(BitmapPoolType.EXPERIMENTAL) == false) goto L19;
        r101 = 1;
        goto L20
    L14:
        if (r100.equals("legacy") == false) goto L19;
        r101 = 3;
        goto L20
    L17:
        if (r100.equals(BitmapPoolType.LEGACY_DEFAULT_PARAMS) == false) goto L19;
        r101 = 2;
    L28:
        return this.mBitmapPool;
    }

    public BufferMemoryChunkPool getBufferMemoryChunkPool() {
        if (this.mBufferMemoryChunkPool != null) goto L6;
        this.mBufferMemoryChunkPool = new BufferMemoryChunkPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
    L6:
        return this.mBufferMemoryChunkPool;
    }

    public FlexByteArrayPool getFlexByteArrayPool() {
        if (this.mFlexByteArrayPool != null) goto L6;
        this.mFlexByteArrayPool = new FlexByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    L6:
        return this.mFlexByteArrayPool;
    }

    public int getFlexByteArrayPoolMaxNumThreads() {
        return this.mConfig.getFlexByteArrayPoolParams().maxNumThreads;
    }

    public NativeMemoryChunkPool getNativeMemoryChunkPool() {
        if (this.mNativeMemoryChunkPool != null) goto L6;
        this.mNativeMemoryChunkPool = new NativeMemoryChunkPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getMemoryChunkPoolParams(), this.mConfig.getMemoryChunkPoolStatsTracker());
    L6:
        return this.mNativeMemoryChunkPool;
    }

    public PooledByteStreams getPooledByteStreams() {
        if (this.mPooledByteStreams != null) goto L6;
        this.mPooledByteStreams = new PooledByteStreams(getSmallByteArrayPool());
    L6:
        return this.mPooledByteStreams;
    }

    public SharedByteArray getSharedByteArray() {
        if (this.mSharedByteArray != null) goto L6;
        this.mSharedByteArray = new SharedByteArray(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getFlexByteArrayPoolParams());
    L6:
        return this.mSharedByteArray;
    }

    public ByteArrayPool getSmallByteArrayPool() {
        if (this.mSmallByteArrayPool != null) goto L6;
        this.mSmallByteArrayPool = new GenericByteArrayPool(this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getSmallByteArrayPoolParams(), this.mConfig.getSmallByteArrayPoolStatsTracker());
    L6:
        return this.mSmallByteArrayPool;
    }

    public PoolFactory(PoolConfig r100) {
        this.mConfig = (PoolConfig) Preconditions.checkNotNull(r100);
    }

    private MemoryChunkPool getMemoryChunkPool(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return getBufferMemoryChunkPool();
    L8:
        throw new IllegalArgumentException("Invalid MemoryChunkType");
    L10:
        return getNativeMemoryChunkPool();
    }

    public PooledByteBufferFactory getPooledByteBufferFactory(int r100) {
        if (this.mPooledByteBufferFactory != null) goto L6;
        this.mPooledByteBufferFactory = new MemoryPooledByteBufferFactory(getMemoryChunkPool(r100), getPooledByteStreams());
    L6:
        return this.mPooledByteBufferFactory;
    }
}
