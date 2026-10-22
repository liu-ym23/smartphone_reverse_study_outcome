package org.apache.commons.compress.compressors.xz;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
final enum XZUtils$CachedAvailability extends Enum<XZUtils$CachedAvailability> {
    private static final /* synthetic */ XZUtils$CachedAvailability[] $VALUES = null;
    public static final XZUtils$CachedAvailability CACHED_AVAILABLE = null;
    public static final XZUtils$CachedAvailability CACHED_UNAVAILABLE = null;
    public static final XZUtils$CachedAvailability DONT_CACHE = null;

    static {
        XZUtils$CachedAvailability r100 = new XZUtils$CachedAvailability("DONT_CACHE", 0);
        DONT_CACHE = r100;
        XZUtils$CachedAvailability r101 = new XZUtils$CachedAvailability("CACHED_AVAILABLE", 1);
        CACHED_AVAILABLE = r101;
        XZUtils$CachedAvailability r102 = new XZUtils$CachedAvailability("CACHED_UNAVAILABLE", 2);
        CACHED_UNAVAILABLE = r102;
        $VALUES = new XZUtils$CachedAvailability[]{r100, r101, r102};
    }

    public static XZUtils$CachedAvailability[] values() {
        return (XZUtils$CachedAvailability[]) $VALUES.clone();
    }

    public static XZUtils$CachedAvailability valueOf(String r100) {
        return (XZUtils$CachedAvailability) a.a(XZUtils$CachedAvailability.class, r100);
    }

    private XZUtils$CachedAvailability(String r100, int r101) {
        super(r100, r101);
    }
}
