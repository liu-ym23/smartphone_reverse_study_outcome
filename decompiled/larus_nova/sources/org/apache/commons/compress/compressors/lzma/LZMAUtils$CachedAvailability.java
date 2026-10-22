package org.apache.commons.compress.compressors.lzma;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum LZMAUtils$CachedAvailability extends Enum<LZMAUtils$CachedAvailability> {
    private static final /* synthetic */ LZMAUtils$CachedAvailability[] $VALUES = null;
    public static final LZMAUtils$CachedAvailability CACHED_AVAILABLE = null;
    public static final LZMAUtils$CachedAvailability CACHED_UNAVAILABLE = null;
    public static final LZMAUtils$CachedAvailability DONT_CACHE = null;

    static {
        LZMAUtils$CachedAvailability r100 = new LZMAUtils$CachedAvailability("DONT_CACHE", 0);
        DONT_CACHE = r100;
        LZMAUtils$CachedAvailability r101 = new LZMAUtils$CachedAvailability("CACHED_AVAILABLE", 1);
        CACHED_AVAILABLE = r101;
        LZMAUtils$CachedAvailability r102 = new LZMAUtils$CachedAvailability("CACHED_UNAVAILABLE", 2);
        CACHED_UNAVAILABLE = r102;
        $VALUES = new LZMAUtils$CachedAvailability[]{r100, r101, r102};
    }

    public static LZMAUtils$CachedAvailability[] values() {
        return (LZMAUtils$CachedAvailability[]) $VALUES.clone();
    }

    public static LZMAUtils$CachedAvailability valueOf(String r100) {
        return (LZMAUtils$CachedAvailability) a.a(LZMAUtils$CachedAvailability.class, r100);
    }

    private LZMAUtils$CachedAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
