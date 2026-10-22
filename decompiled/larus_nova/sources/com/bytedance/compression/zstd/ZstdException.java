package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdException extends RuntimeException {
    private long code;

    public long getErrorCode() {
        return this.code;
    }

    public ZstdException(long r100) {
        this(Zstd.getErrorCode(r100), Zstd.getErrorName(r100));
    }

    public ZstdException(long r100, String r101) {
        super(r101);
        this.code = r100;
    }
}
