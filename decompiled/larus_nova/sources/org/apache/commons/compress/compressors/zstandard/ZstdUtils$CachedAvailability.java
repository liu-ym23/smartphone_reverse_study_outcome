package org.apache.commons.compress.compressors.zstandard;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum ZstdUtils$CachedAvailability extends Enum<ZstdUtils$CachedAvailability> {
    private static final /* synthetic */ ZstdUtils$CachedAvailability[] $VALUES = null;
    public static final ZstdUtils$CachedAvailability CACHED_AVAILABLE = null;
    public static final ZstdUtils$CachedAvailability CACHED_UNAVAILABLE = null;
    public static final ZstdUtils$CachedAvailability DONT_CACHE = null;

    static {
        ZstdUtils$CachedAvailability r100 = new ZstdUtils$CachedAvailability("DONT_CACHE", 0);
        DONT_CACHE = r100;
        ZstdUtils$CachedAvailability r101 = new ZstdUtils$CachedAvailability("CACHED_AVAILABLE", 1);
        CACHED_AVAILABLE = r101;
        ZstdUtils$CachedAvailability r102 = new ZstdUtils$CachedAvailability("CACHED_UNAVAILABLE", 2);
        CACHED_UNAVAILABLE = r102;
        $VALUES = new ZstdUtils$CachedAvailability[]{r100, r101, r102};
    }

    public static ZstdUtils$CachedAvailability[] values() {
        return (ZstdUtils$CachedAvailability[]) $VALUES.clone();
    }

    public static ZstdUtils$CachedAvailability valueOf(String r100) {
        return (ZstdUtils$CachedAvailability) a.a(ZstdUtils$CachedAvailability.class, r100);
    }

    private ZstdUtils$CachedAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
