package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

/* JADX INFO: loaded from: classes23.dex */
public class BufferMemoryChunkPool extends MemoryChunkPool {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public MemoryChunk alloc(int r100) {
        return new BufferMemoryChunk(r100);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: alloc, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ MemoryChunk alloc2(int r100) {
        return alloc(r100);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public /* bridge */ /* synthetic */ MemoryChunk alloc(int r100) {
        return alloc(r100);
    }

    public BufferMemoryChunkPool(MemoryTrimmableRegistry r100, PoolParams r101, PoolStatsTracker r102) {
        super(r100, r101, r102);
    }
}
