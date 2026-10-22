package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes6.dex */
public class ZstdCompress {
    public ZstdCompress() {
    }

    public static native long compressBound(long r100);

    public static native int defaultCompressionLevel();

    public static native int loadDictCompress(long r100, byte[] r101, int r102);

    public static native int loadFastDictCompress(long r100, ZstdDictCompress r101);

    public static native int maxCompressionLevel();

    public static native int minCompressionLevel();

    public static native int setCompressionChecksums(long r100, boolean r101);

    public static native int setCompressionLevel(long r100, int r101);

    public static native int setCompressionLong(long r100, int r101);

    public static native int setCompressionWorkers(long r100, int r101);

    static {
        vg4.a.b();
    }

    public static byte[] compress(byte[] r100) throws ZstdException {
        return compress(r100, defaultCompressionLevel());
    }

    public static byte[] compress(byte[] r100, ZstdDictCompress r101) throws ZstdException {
        ZstdCompressCtx r102 = new ZstdCompressCtx();
        r102.loadDict(r101);     // Catch: Throwable -> L6
        r102.setLevel(r101.level());     // Catch: Throwable -> L6
        byte[] r103 = r102.compress(r100);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static byte[] compress(byte[] r100, int r101) throws ZstdException {
        ZstdCompressCtx r102 = new ZstdCompressCtx();
        r102.setLevel(r101);     // Catch: Throwable -> L6
        byte[] r103 = r102.compress(r100);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static byte[] compress(byte[] r100, byte[] r101, int r102) throws ZstdException {
        ZstdCompressCtx r103 = new ZstdCompressCtx();
        r103.loadDict(r101);     // Catch: Throwable -> L6
        r103.setLevel(r102);     // Catch: Throwable -> L6
        byte[] r104 = r103.compress(r100);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static int compress(byte[] r100, int r101, int r110, byte[] r111, int r112, int r113, ZstdDictCompress r114) throws ZstdException {
        ZstdCompressCtx r102 = new ZstdCompressCtx();
        r102.loadDict(r114);     // Catch: Throwable -> L6
        r102.setLevel(r114.level());     // Catch: Throwable -> L6
        int r103 = r102.compressByteArray(r100, r101, r110, r111, r112, r113);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static int compress(byte[] r100, int r101, int r110, byte[] r111, int r112, int r113, int r114) throws ZstdException {
        ZstdCompressCtx r102 = new ZstdCompressCtx();
        r102.setLevel(r114);     // Catch: Throwable -> L6
        int r103 = r102.compressByteArray(r100, r101, r110, r111, r112, r113);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }
}
