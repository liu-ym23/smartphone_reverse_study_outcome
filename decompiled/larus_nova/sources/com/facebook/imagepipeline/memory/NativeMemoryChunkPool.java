package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes3.dex */
public class NativeMemoryChunkPool extends MemoryChunkPool {
    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public MemoryChunk alloc(int r100) {
        return new NativeMemoryChunk(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ MemoryChunk alloc(int r100) {
        return alloc(r100);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ MemoryChunk alloc(int r100) {
        return alloc(r100);
    }

    public NativeMemoryChunkPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        super(r100, r101, r102);
    }
}
