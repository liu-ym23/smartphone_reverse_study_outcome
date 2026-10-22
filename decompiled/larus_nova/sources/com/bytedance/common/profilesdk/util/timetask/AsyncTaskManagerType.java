package com.bytedance.common.profilesdk.util.timetask;

import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum AsyncTaskManagerType extends Enum<AsyncTaskManagerType> {
    private static final /* synthetic */ AsyncTaskManagerType[] $VALUES = null;
    public static final AsyncTaskManagerType BACKGROUND = null;
    public static final AsyncTaskManagerType IO = null;
    public static final AsyncTaskManagerType LIGHT_WEIGHT = null;
    public static final AsyncTaskManagerType TIME_SENSITIVE = null;

    static {
        AsyncTaskManagerType r100 = new AsyncTaskManagerType("BACKGROUND", 0);
        BACKGROUND = r100;
        AsyncTaskManagerType r101 = new AsyncTaskManagerType("IO", 1);
        IO = r101;
        AsyncTaskManagerType r102 = new AsyncTaskManagerType("LIGHT_WEIGHT", 2);
        LIGHT_WEIGHT = r102;
        AsyncTaskManagerType r103 = new AsyncTaskManagerType("TIME_SENSITIVE", 3);
        TIME_SENSITIVE = r103;
        $VALUES = new AsyncTaskManagerType[]{r100, r101, r102, r103};
    }

    public static AsyncTaskManagerType[] values() {
        return (AsyncTaskManagerType[]) $VALUES.clone();
    }

    public static AsyncTaskManagerType valueOf(String r100) {
        return (AsyncTaskManagerType) a.a(AsyncTaskManagerType.class, r100);
    }

    private AsyncTaskManagerType(String r100, int r101) {
        super(r100, r101);
    }
}
