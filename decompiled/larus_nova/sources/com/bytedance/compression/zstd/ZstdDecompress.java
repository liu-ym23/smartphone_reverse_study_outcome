package com.bytedance.compression.zstd;

import androidx.collection.SieveCacheKt;

/* JADX INFO: loaded from: classes15.dex */
public class ZstdDecompress {
    public ZstdDecompress() {
    }

    private static native long decompressedSize0(byte[] r100, int r101, int r102);

    public static native int loadDictDecompress(long r100, byte[] r101, int r102);

    public static native int loadFastDictDecompress(long r100, ZstdDictDecompress r101);

    static {
        vg4.a.b();
    }

    public static byte[] decompress(byte[] r100) throws ZstdException {
        long r101 = decompressedSize(r100);
        if (r101 > SieveCacheKt.NodeLinkMask) goto L7;
        return decompress(r100, (int) r101);
    L7:
        throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static long decompressedSize(byte[] r100) {
        return decompressedSize(r100, 0);
    }

    public static byte[] decompress(byte[] r100, ZstdDictDecompress r101) throws ZstdException {
        long r102 = decompressedSize(r100);
        if (r102 > SieveCacheKt.NodeLinkMask) goto L7;
        return decompress(r100, r101, (int) r102);
    L7:
        throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static long decompressedSize(byte[] r100, int r101) {
        return decompressedSize(r100, r101, r100.length - r101);
    }

    public static byte[] decompress(byte[] r100, byte[] r101) throws ZstdException {
        long r102 = decompressedSize(r100);
        if (r102 > SieveCacheKt.NodeLinkMask) goto L7;
        return decompress(r100, r101, (int) r102);
    L7:
        throw new ZstdException(Zstd.errGeneric(), "original size is greater than MAX_INT");
    }

    public static byte[] decompress(byte[] r100, int r101) throws ZstdException {
        ZstdDecompressCtx r102 = new ZstdDecompressCtx();
        byte[] r103 = r102.decompress(r100, r101);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static byte[] decompress(byte[] r100, ZstdDictDecompress r101, int r102) throws ZstdException {
        ZstdDecompressCtx r103 = new ZstdDecompressCtx();
        r103.loadDict(r101);     // Catch: Throwable -> L6
        byte[] r104 = r103.decompress(r100, r102);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static long decompressedSize(byte[] r100, int r101, int r102) {
        if (r101 >= r100.length) goto L11;
        int r103 = r101 + r102;
        if (r103 > r100.length) goto L9;
        return decompressedSize0(r100, r101, r102);
    L9:
        throw new ArrayIndexOutOfBoundsException(r103);
    L11:
        throw new ArrayIndexOutOfBoundsException(r101);
    }

    public static byte[] decompress(byte[] r100, byte[] r101, int r102) throws ZstdException {
        ZstdDecompressCtx r103 = new ZstdDecompressCtx();
        r103.loadDict(r101);     // Catch: Throwable -> L6
        byte[] r104 = r103.decompress(r100, r102);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }
}
