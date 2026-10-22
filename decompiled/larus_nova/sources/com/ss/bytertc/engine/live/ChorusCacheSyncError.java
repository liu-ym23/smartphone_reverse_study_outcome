package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum ChorusCacheSyncError extends Enum<ChorusCacheSyncError> {
    private static final /* synthetic */ ChorusCacheSyncError[] $VALUES = null;
    public static final ChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING = null;
    public static final ChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_OK = null;
    public static final ChorusCacheSyncError CHORUS_CACHE_SYNC_ERROR_WRONG_STATE = null;
    private int value;

    static {
        ChorusCacheSyncError r100 = new ChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_OK", 0, 0);
        CHORUS_CACHE_SYNC_ERROR_OK = r100;
        ChorusCacheSyncError r101 = new ChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_WRONG_STATE", 1, 1);
        CHORUS_CACHE_SYNC_ERROR_WRONG_STATE = r101;
        ChorusCacheSyncError r102 = new ChorusCacheSyncError("CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING", 2, 2);
        CHORUS_CACHE_SYNC_ERROR_ALREADY_RUNNING = r102;
        $VALUES = new ChorusCacheSyncError[]{r100, r101, r102};
    }

    public static ChorusCacheSyncError[] values() {
        return (ChorusCacheSyncError[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static ChorusCacheSyncError fromId(int r100) {
        ChorusCacheSyncError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        ChorusCacheSyncError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static ChorusCacheSyncError valueOf(String r100) {
        return (ChorusCacheSyncError) a.a(ChorusCacheSyncError.class, r100);
    }

    private ChorusCacheSyncError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
