package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ChorusCacheSyncMode extends Enum<ChorusCacheSyncMode> {
    private static final /* synthetic */ ChorusCacheSyncMode[] $VALUES = null;
    public static final ChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_CONSUMER = null;
    public static final ChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_PRODUCER = null;
    public static final ChorusCacheSyncMode CHORUS_CACHE_SYNC_MODE_RETRANSMITTER = null;
    private int value;

    static {
        ChorusCacheSyncMode r100 = new ChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_PRODUCER", 0, 0);
        CHORUS_CACHE_SYNC_MODE_PRODUCER = r100;
        ChorusCacheSyncMode r101 = new ChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_RETRANSMITTER", 1, 1);
        CHORUS_CACHE_SYNC_MODE_RETRANSMITTER = r101;
        ChorusCacheSyncMode r102 = new ChorusCacheSyncMode("CHORUS_CACHE_SYNC_MODE_CONSUMER", 2, 2);
        CHORUS_CACHE_SYNC_MODE_CONSUMER = r102;
        $VALUES = new ChorusCacheSyncMode[]{r100, r101, r102};
    }

    public static ChorusCacheSyncMode[] values() {
        return (ChorusCacheSyncMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncMode fromId(int r100) {
        ChorusCacheSyncMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ChorusCacheSyncMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ChorusCacheSyncMode valueOf(String r100) {
        return (ChorusCacheSyncMode) a.a(ChorusCacheSyncMode.class, r100);
    }

    private ChorusCacheSyncMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
