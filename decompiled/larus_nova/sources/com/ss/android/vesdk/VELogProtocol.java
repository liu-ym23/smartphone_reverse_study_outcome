package com.ss.android.vesdk;

/* JADX INFO: loaded from: classes40.dex */
public interface VELogProtocol {
    public static final int VELOG_DEBUG = 1;
    public static final int VELOG_ERROR = 4;
    public static final int VELOG_INFO = 2;
    public static final int VELOG_VERBOSE = 0;
    public static final int VELOG_WARN = 3;

    void logToLocal(int r100, String r101);
}
