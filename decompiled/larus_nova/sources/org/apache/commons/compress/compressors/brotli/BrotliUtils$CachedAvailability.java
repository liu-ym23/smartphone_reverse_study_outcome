package org.apache.commons.compress.compressors.brotli;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum BrotliUtils$CachedAvailability extends Enum<BrotliUtils$CachedAvailability> {
    private static final /* synthetic */ BrotliUtils$CachedAvailability[] $VALUES = null;
    public static final BrotliUtils$CachedAvailability CACHED_AVAILABLE = null;
    public static final BrotliUtils$CachedAvailability CACHED_UNAVAILABLE = null;
    public static final BrotliUtils$CachedAvailability DONT_CACHE = null;

    static {
        BrotliUtils$CachedAvailability r100 = new BrotliUtils$CachedAvailability("DONT_CACHE", 0);
        DONT_CACHE = r100;
        BrotliUtils$CachedAvailability r101 = new BrotliUtils$CachedAvailability("CACHED_AVAILABLE", 1);
        CACHED_AVAILABLE = r101;
        BrotliUtils$CachedAvailability r102 = new BrotliUtils$CachedAvailability("CACHED_UNAVAILABLE", 2);
        CACHED_UNAVAILABLE = r102;
        $VALUES = new BrotliUtils$CachedAvailability[]{r100, r101, r102};
    }

    public static BrotliUtils$CachedAvailability[] values() {
        return (BrotliUtils$CachedAvailability[]) $VALUES.clone();
    }

    public static BrotliUtils$CachedAvailability valueOf(String r100) {
        return (BrotliUtils$CachedAvailability) a.a(BrotliUtils$CachedAvailability.class, r100);
    }

    private BrotliUtils$CachedAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
