package com.ss.mediakit.medialoader;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLTaskEventID {
    public static final int TaskEventEnd = 1;
    private static final int TaskEventIdEnd = 2;
    private static final int TaskEventIdStart = -1;
    public static final int TaskEventStart = 0;
    public static final int TaskTypeCache = 3;
    private static final int TaskTypeEnd = 4;
    public static final int TaskTypePlay = 1;
    public static final int TaskTypePreload = 2;
    private static final int TaskTypeStart = 0;

    public AVMDLTaskEventID() {
    }

    public static boolean eventTypeIsValid(int r100) {
        if (r100 > (-1)) goto L5;
        return false;
    L5:
        if (r100 >= 2) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean taskTypeIsValid(int r100) {
        if (r100 > 0) goto L4;
        return false;
    L4:
        if (r100 >= 4) goto L10;
        return true;
    L10:
        return false;
    }
}
