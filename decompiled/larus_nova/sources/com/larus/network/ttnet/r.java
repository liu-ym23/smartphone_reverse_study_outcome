package com.larus.network.ttnet;

import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDecompress;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements TTRequestCompressManager.AddZstdCompressCallback {
    public r() {
    }

    @Override // com.bytedance.retrofit2.mime.TTRequestCompressManager.AddZstdCompressCallback
    public final byte[] compress(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        return ZstdCompress.compress(r100, r101);
    L5:
        e = move-exception;
        FLogger r102 = FLogger.f375446a;
        String[] r103 = p.f360240a;
        r102.e("TTNetExt", "decompress error", e);
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TTRequestCompressManager.AddZstdCompressCallback
    public final byte[] decompress(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "src");
        return ZstdDecompress.decompress(r100, r101);
    L5:
        e = move-exception;
        FLogger r102 = FLogger.f375446a;
        String[] r103 = p.f360240a;
        r102.e("TTNetExt", "decompress error", e);
        return null;
    }
}
