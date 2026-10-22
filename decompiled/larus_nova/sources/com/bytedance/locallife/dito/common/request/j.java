package com.bytedance.locallife.dito.common.request;

/* JADX INFO: loaded from: classes21.dex */
public interface j {
    void a(ChunkData r100, DowngradeReason r101);

    void b(ChunkData r100);

    void onComplete();

    void onFailed(Throwable r100);
}
