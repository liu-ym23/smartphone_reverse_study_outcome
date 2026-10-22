package com.facebook.cache.common;

/* JADX INFO: loaded from: classes3.dex */
public interface CacheEventListener {

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum EvictionReason extends Enum<EvictionReason> {
        private static final /* synthetic */ EvictionReason[] $VALUES = null;
        public static final EvictionReason CACHE_FULL = null;
        public static final EvictionReason CACHE_MANAGER_TRIMMED = null;
        public static final EvictionReason CONTENT_STALE = null;
        public static final EvictionReason USER_FORCED = null;

        static {
            EvictionReason r100 = new EvictionReason("CACHE_FULL", 0);
            CACHE_FULL = r100;
            EvictionReason r101 = new EvictionReason("CONTENT_STALE", 1);
            CONTENT_STALE = r101;
            EvictionReason r102 = new EvictionReason("USER_FORCED", 2);
            USER_FORCED = r102;
            EvictionReason r103 = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
            CACHE_MANAGER_TRIMMED = r103;
            $VALUES = new EvictionReason[]{r100, r101, r102, r103};
        }

        public static EvictionReason[] values() {
            return (EvictionReason[]) $VALUES.clone();
        }

        public static EvictionReason valueOf(String r100) {
            return (EvictionReason) Enum.valueOf(EvictionReason.class, r100);
        }

        private EvictionReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    void onCleared();

    void onEviction(CacheEvent r100);

    void onHit(CacheEvent r100);

    void onMiss(CacheEvent r100);

    void onReadException(CacheEvent r100);

    void onWriteAttempt(CacheEvent r100);

    void onWriteException(CacheEvent r100);

    void onWriteSuccess(CacheEvent r100);
}
