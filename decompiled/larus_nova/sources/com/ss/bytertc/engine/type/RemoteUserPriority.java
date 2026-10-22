package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum RemoteUserPriority extends Enum<RemoteUserPriority> {
    private static final /* synthetic */ RemoteUserPriority[] $VALUES = null;
    public static final RemoteUserPriority REMOTE_USER_PRIORITY_HIGH = null;
    public static final RemoteUserPriority REMOTE_USER_PRIORITY_LOW = null;
    public static final RemoteUserPriority REMOTE_USER_PRIORITY_MEDIUM = null;
    private int value;

    static {
        RemoteUserPriority r100 = new RemoteUserPriority("REMOTE_USER_PRIORITY_LOW", 0, 0);
        REMOTE_USER_PRIORITY_LOW = r100;
        RemoteUserPriority r101 = new RemoteUserPriority("REMOTE_USER_PRIORITY_MEDIUM", 1, 100);
        REMOTE_USER_PRIORITY_MEDIUM = r101;
        RemoteUserPriority r102 = new RemoteUserPriority("REMOTE_USER_PRIORITY_HIGH", 2, 200);
        REMOTE_USER_PRIORITY_HIGH = r102;
        $VALUES = new RemoteUserPriority[]{r100, r101, r102};
    }

    public static RemoteUserPriority[] values() {
        return (RemoteUserPriority[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static RemoteUserPriority valueOf(String r100) {
        return (RemoteUserPriority) a.a(RemoteUserPriority.class, r100);
    }

    private RemoteUserPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
