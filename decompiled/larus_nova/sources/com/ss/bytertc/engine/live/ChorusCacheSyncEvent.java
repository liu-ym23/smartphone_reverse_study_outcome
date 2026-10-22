package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ChorusCacheSyncEvent extends Enum<ChorusCacheSyncEvent> {
    private static final /* synthetic */ ChorusCacheSyncEvent[] $VALUES = null;
    public static final ChorusCacheSyncEvent CHORUS_CACHE_SYNC_EVENT_START_FAILED = null;
    public static final ChorusCacheSyncEvent CHORUS_CACHE_SYNC_EVENT_START_SUCCESS = null;
    private int value;

    static {
        ChorusCacheSyncEvent r100 = new ChorusCacheSyncEvent("CHORUS_CACHE_SYNC_EVENT_START_SUCCESS", 0, 0);
        CHORUS_CACHE_SYNC_EVENT_START_SUCCESS = r100;
        ChorusCacheSyncEvent r101 = new ChorusCacheSyncEvent("CHORUS_CACHE_SYNC_EVENT_START_FAILED", 1, 1);
        CHORUS_CACHE_SYNC_EVENT_START_FAILED = r101;
        $VALUES = new ChorusCacheSyncEvent[]{r100, r101};
    }

    public static ChorusCacheSyncEvent[] values() {
        return (ChorusCacheSyncEvent[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncEvent fromId(int r100) {
        ChorusCacheSyncEvent[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ChorusCacheSyncEvent r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ChorusCacheSyncEvent valueOf(String r100) {
        return (ChorusCacheSyncEvent) a.a(ChorusCacheSyncEvent.class, r100);
    }

    private ChorusCacheSyncEvent(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
